package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PackageImplementationCompiler {
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  public boolean isResolveProxiesFlag(final EReference ref) {
    final EReference eStructuralFeature = ref;
    final boolean isContainer = ((ref.getEOpposite() != null) && ref.getEOpposite().isContainment());
    final boolean isContains = ref.isContainment();
    return ((((!isContainer) && (!isContains)) && (eStructuralFeature instanceof EReference)) && ref.isResolveProxies());
  }
  
  public void compilePackageImplementation(final EPackage abstractSyntax, final File directory, final String packageRoot) {
    try {
      final Iterable<EClass> allClasses = Iterables.<EClass>filter(abstractSyntax.getEClassifiers(), EClass.class);
      final Iterable<EEnum> allEnums = Iterables.<EEnum>filter(abstractSyntax.getEClassifiers(), EEnum.class);
      FieldSpec.Builder _addModifiers = FieldSpec.builder(boolean.class, "isInited").addModifiers(Modifier.PRIVATE, Modifier.STATIC);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("false");
      final FieldSpec isInitedField = _addModifiers.initializer(_builder.toString()).build();
      FieldSpec.Builder _addModifiers_1 = FieldSpec.builder(boolean.class, "isCreated").addModifiers(Modifier.PRIVATE);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("false");
      final FieldSpec isCreatedField = _addModifiers_1.initializer(_builder_1.toString()).build();
      FieldSpec.Builder _addModifiers_2 = FieldSpec.builder(boolean.class, "isInitialized").addModifiers(Modifier.PRIVATE);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("false");
      final FieldSpec isInitializedField = _addModifiers_2.initializer(_builder_2.toString()).build();
      final ClassName packageInterfaceType = ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.packageInterfaceClassName(abstractSyntax));
      final String packageInterfaceName = this.namingUtils.packageInterfaceClassName(abstractSyntax);
      final ClassName factoryInterfaceType = ClassName.get(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.factoryInterfaceClassName(abstractSyntax));
      StringConcatenation _builder_3 = new StringConcatenation();
      String _packageImplementationClassName = this.namingUtils.packageImplementationClassName(abstractSyntax);
      _builder_3.append(_packageImplementationClassName);
      final String test = _builder_3.toString();
      MethodSpec.Builder _returns = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(packageInterfaceType);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("if (isInited)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("return ($1T) $2T.INSTANCE.getEPackage($1T.eNS_URI);");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("// Obtain or create and register package");
      _builder_4.newLine();
      _builder_4.append("Object registered");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(" = EPackage.Registry.INSTANCE.get(eNS_URI);");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append(test);
      _builder_4.append(" the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(" = registered");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(" instanceof ");
      _builder_4.append(test);
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("\t\t");
      _builder_4.append("? (");
      _builder_4.append(test, "\t\t");
      _builder_4.append(") registered");
      _builder_4.append(packageInterfaceName, "\t\t");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("\t\t");
      _builder_4.append(": new ");
      _builder_4.append(test, "\t\t");
      _builder_4.append("();");
      _builder_4.newLineIfNotEmpty();
      _builder_4.newLine();
      _builder_4.append("isInited = true;");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("// Create package meta-data objects");
      _builder_4.newLine();
      _builder_4.append("the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(".createPackageContents();");
      _builder_4.newLineIfNotEmpty();
      _builder_4.newLine();
      _builder_4.append("// Initialize created meta-data");
      _builder_4.newLine();
      _builder_4.append("the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(".initializePackageContents();");
      _builder_4.newLineIfNotEmpty();
      _builder_4.newLine();
      _builder_4.append("// Mark meta-data to indicate it can\'t be changed");
      _builder_4.newLine();
      _builder_4.append("the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(".freeze();");
      _builder_4.newLineIfNotEmpty();
      _builder_4.newLine();
      _builder_4.append("// Update the registry and return the package");
      _builder_4.newLine();
      _builder_4.append("$2T.INSTANCE.put($1T.eNS_URI, the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(");");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("return the");
      _builder_4.append(packageInterfaceName);
      _builder_4.append(";");
      _builder_4.newLineIfNotEmpty();
      final MethodSpec initMethod = _returns.addCode(_builder_4.toString(), packageInterfaceType, EPackage.Registry.class).build();
      MethodSpec.Builder _addModifiers_3 = MethodSpec.methodBuilder("createPackageContents").addModifiers(Modifier.PUBLIC);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("if (isCreated)");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("return;");
      _builder_5.newLine();
      _builder_5.append("isCreated = true;");
      _builder_5.newLine();
      _builder_5.newLine();
      _builder_5.append("// Create classes and their features");
      _builder_5.newLine();
      {
        boolean _hasElements = false;
        for(final EClass eClass : allClasses) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_5.appendImmediate("\n", "");
          }
          String _firstLower = StringExtensions.toFirstLower(eClass.getName());
          _builder_5.append(_firstLower);
          _builder_5.append("EClass = createEClass(");
          String _normalizeUpperField = this.namingUtils.normalizeUpperField(eClass.getName());
          _builder_5.append(_normalizeUpperField);
          _builder_5.append(");");
          _builder_5.newLineIfNotEmpty();
          {
            EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
            for(final EStructuralFeature eAttr : _eStructuralFeatures) {
              {
                if ((eAttr instanceof EReference)) {
                  _builder_5.append("createEReference(");
                  String _firstLower_1 = StringExtensions.toFirstLower(eClass.getName());
                  _builder_5.append(_firstLower_1);
                  _builder_5.append("EClass, ");
                  String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(((EReference)eAttr).getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_1);
                  _builder_5.append(");");
                  _builder_5.newLineIfNotEmpty();
                } else {
                  _builder_5.append("createEAttribute(");
                  String _firstLower_2 = StringExtensions.toFirstLower(eClass.getName());
                  _builder_5.append(_firstLower_2);
                  _builder_5.append("EClass, ");
                  String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(eAttr.getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_2);
                  _builder_5.append(");");
                  _builder_5.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      {
        boolean _isEmpty = IterableExtensions.isEmpty(allEnums);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder_5.newLine();
          _builder_5.append("// Create enums");
          _builder_5.newLine();
          {
            for(final EEnum eEnum : allEnums) {
              String _firstLower_3 = StringExtensions.toFirstLower(eEnum.getName());
              _builder_5.append(_firstLower_3);
              _builder_5.append("EEnum = createEEnum(");
              String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(eEnum.getName());
              _builder_5.append(_normalizeUpperField_3);
              _builder_5.append(");");
              _builder_5.newLineIfNotEmpty();
            }
          }
        }
      }
      final MethodSpec createPackageContentsMethod = _addModifiers_3.addCode(_builder_5.toString()).build();
      final HashMap<String, ClassName> hm = CollectionLiterals.<String, ClassName>newHashMap();
      for (final EClass eClass_1 : allClasses) {
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("type");
        String _name = eClass_1.getName();
        _builder_6.append(_name);
        hm.put(_builder_6.toString(), ClassName.get(this.namingUtils.classInterfacePackageName(eClass_1, packageRoot), eClass_1.getName()));
      }
      for (final EEnum eEnum_1 : allEnums) {
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("type");
        String _name_1 = eEnum_1.getName();
        _builder_7.append(_name_1);
        hm.put(_builder_7.toString(), ClassName.get(this.namingUtils.classInterfacePackageName(eEnum_1, packageRoot), eEnum_1.getName()));
      }
      MethodSpec.Builder _addModifiers_4 = MethodSpec.methodBuilder("initializePackageContents").addModifiers(Modifier.PUBLIC);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("if (isInitialized)");
      _builder_8.newLine();
      _builder_8.append("\t");
      _builder_8.append("return;");
      _builder_8.newLine();
      _builder_8.append("isInitialized = true;");
      _builder_8.newLine();
      _builder_8.newLine();
      _builder_8.append("// Initialize package");
      _builder_8.newLine();
      _builder_8.append("setName(eNAME);");
      _builder_8.newLine();
      _builder_8.append("setNsPrefix(eNS_PREFIX);");
      _builder_8.newLine();
      _builder_8.append("setNsURI(eNS_URI);");
      _builder_8.newLine();
      _builder_8.newLine();
      _builder_8.append("// Create type parameters");
      _builder_8.newLine();
      _builder_8.newLine();
      _builder_8.append("// Set bounds for type parameters");
      _builder_8.newLine();
      _builder_8.newLine();
      _builder_8.append("// Add supertypes to classes");
      _builder_8.newLine();
      {
        for(final EClass eClass_2 : allClasses) {
          {
            EList<EClass> _eSuperTypes = eClass_2.getESuperTypes();
            for(final EClass esp : _eSuperTypes) {
              String _firstLower_4 = StringExtensions.toFirstLower(eClass_2.getName());
              _builder_8.append(_firstLower_4);
              _builder_8.append("EClass.getESuperTypes().add(this.get");
              String _name_2 = esp.getName();
              _builder_8.append(_name_2);
              _builder_8.append("());");
              _builder_8.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder_8.newLine();
      _builder_8.append("// Initialize classes, features, and operations; add parameters");
      _builder_8.newLine();
      {
        boolean _hasElements_1 = false;
        for(final EClass eClass_3 : allClasses) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder_8.appendImmediate("\n", "");
          }
          _builder_8.append("initEClass(");
          String _firstLower_5 = StringExtensions.toFirstLower(eClass_3.getName());
          _builder_8.append(_firstLower_5);
          _builder_8.append("EClass, $type");
          String _name_3 = eClass_3.getName();
          _builder_8.append(_name_3);
          _builder_8.append(":T.class, \"");
          String _name_4 = eClass_3.getName();
          _builder_8.append(_name_4);
          _builder_8.append("\", ");
          {
            boolean _isAbstract = eClass_3.isAbstract();
            if (_isAbstract) {
            } else {
              _builder_8.append("!");
            }
          }
          _builder_8.append("IS_ABSTRACT, ");
          {
            boolean _isInterface = eClass_3.isInterface();
            if (_isInterface) {
            } else {
              _builder_8.append("!");
            }
          }
          _builder_8.append("IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);");
          _builder_8.newLineIfNotEmpty();
          {
            EList<EStructuralFeature> _eStructuralFeatures_1 = eClass_3.getEStructuralFeatures();
            for(final EStructuralFeature eAttr_1 : _eStructuralFeatures_1) {
              {
                if ((eAttr_1 instanceof EReference)) {
                  {
                    EPackage _ePackage = ((EReference)eAttr_1).getEType().getEPackage();
                    boolean _notEquals = (!Objects.equal(_ePackage, abstractSyntax));
                    if (_notEquals) {
                      _builder_8.append("initEReference(get");
                      String _name_5 = eClass_3.getName();
                      _builder_8.append(_name_5);
                      _builder_8.append("_");
                      String _firstUpper = StringExtensions.toFirstUpper(((EReference)eAttr_1).getName());
                      _builder_8.append(_firstUpper);
                      _builder_8.append("(), ((");
                      String _packageInterfacePackageName = this.namingUtils.packageInterfacePackageName(((EReference)eAttr_1).getEType().getEPackage(), packageRoot);
                      _builder_8.append(_packageInterfacePackageName);
                      _builder_8.append(".");
                      String _packageInterfaceClassName = this.namingUtils.packageInterfaceClassName(((EReference)eAttr_1).getEType().getEPackage());
                      _builder_8.append(_packageInterfaceClassName);
                      _builder_8.append(")org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.getEPackage(");
                      String _packageInterfacePackageName_1 = this.namingUtils.packageInterfacePackageName(((EReference)eAttr_1).getEType().getEPackage(), packageRoot);
                      _builder_8.append(_packageInterfacePackageName_1);
                      _builder_8.append(".");
                      String _packageInterfaceClassName_1 = this.namingUtils.packageInterfaceClassName(((EReference)eAttr_1).getEType().getEPackage());
                      _builder_8.append(_packageInterfaceClassName_1);
                      _builder_8.append(".eNS_URI)).get");
                      String _name_6 = ((EReference)eAttr_1).getEType().getName();
                      _builder_8.append(_name_6);
                      _builder_8.append("(), ");
                      {
                        EReference _eOpposite = ((EReference)eAttr_1).getEOpposite();
                        boolean _tripleNotEquals = (_eOpposite != null);
                        if (_tripleNotEquals) {
                          _builder_8.append("this.get");
                          EObject _eContainer = ((EReference)eAttr_1).getEOpposite().eContainer();
                          String _normalizeUpperMethod = this.namingUtils.normalizeUpperMethod(((EReference)eAttr_1).getEOpposite().getName(), ((EClass) _eContainer).getName());
                          _builder_8.append(_normalizeUpperMethod);
                          _builder_8.append("()");
                        } else {
                          _builder_8.append("null");
                        }
                      }
                      _builder_8.append(", \"");
                      String _name_7 = ((EReference)eAttr_1).getName();
                      _builder_8.append(_name_7);
                      _builder_8.append("\", null, ");
                      int _lowerBound = ((EReference)eAttr_1).getLowerBound();
                      _builder_8.append(_lowerBound);
                      _builder_8.append(", ");
                      int _upperBound = ((EReference)eAttr_1).getUpperBound();
                      _builder_8.append(_upperBound);
                      _builder_8.append(", $type");
                      String _name_8 = eClass_3.getName();
                      _builder_8.append(_name_8);
                      _builder_8.append(":T.class, ");
                      {
                        boolean _isTransient = ((EReference)eAttr_1).isTransient();
                        if (_isTransient) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_TRANSIENT, ");
                      {
                        boolean _isVolatile = ((EReference)eAttr_1).isVolatile();
                        if (_isVolatile) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_VOLATILE, ");
                      {
                        boolean _isChangeable = ((EReference)eAttr_1).isChangeable();
                        if (_isChangeable) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_CHANGEABLE, ");
                      {
                        boolean _isContainment = ((EReference)eAttr_1).isContainment();
                        if (_isContainment) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_COMPOSITE, ");
                      {
                        boolean _isResolveProxiesFlag = this.isResolveProxiesFlag(((EReference)eAttr_1));
                        if (_isResolveProxiesFlag) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_RESOLVE_PROXIES, ");
                      {
                        boolean _isUnsettable = ((EReference)eAttr_1).isUnsettable();
                        if (_isUnsettable) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_UNSETTABLE, ");
                      {
                        boolean _isUnique = ((EReference)eAttr_1).isUnique();
                        if (_isUnique) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_UNIQUE, ");
                      {
                        boolean _isDerived = ((EReference)eAttr_1).isDerived();
                        if (_isDerived) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_DERIVED, ");
                      {
                        boolean _isOrdered = ((EReference)eAttr_1).isOrdered();
                        if (_isOrdered) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_ORDERED);");
                      _builder_8.newLineIfNotEmpty();
                    } else {
                      _builder_8.append("initEReference(get");
                      String _name_9 = eClass_3.getName();
                      _builder_8.append(_name_9);
                      _builder_8.append("_");
                      String _firstUpper_1 = StringExtensions.toFirstUpper(((EReference)eAttr_1).getName());
                      _builder_8.append(_firstUpper_1);
                      _builder_8.append("(), this.get");
                      String _name_10 = ((EReference)eAttr_1).getEType().getName();
                      _builder_8.append(_name_10);
                      _builder_8.append("(), ");
                      {
                        EReference _eOpposite_1 = ((EReference)eAttr_1).getEOpposite();
                        boolean _tripleNotEquals_1 = (_eOpposite_1 != null);
                        if (_tripleNotEquals_1) {
                          _builder_8.append("this.get");
                          EObject _eContainer_1 = ((EReference)eAttr_1).getEOpposite().eContainer();
                          String _normalizeUpperMethod_1 = this.namingUtils.normalizeUpperMethod(((EReference)eAttr_1).getEOpposite().getName(), ((EClass) _eContainer_1).getName());
                          _builder_8.append(_normalizeUpperMethod_1);
                          _builder_8.append("()");
                        } else {
                          _builder_8.append("null");
                        }
                      }
                      _builder_8.append(", \"");
                      String _name_11 = ((EReference)eAttr_1).getName();
                      _builder_8.append(_name_11);
                      _builder_8.append("\", null, ");
                      int _lowerBound_1 = ((EReference)eAttr_1).getLowerBound();
                      _builder_8.append(_lowerBound_1);
                      _builder_8.append(", ");
                      int _upperBound_1 = ((EReference)eAttr_1).getUpperBound();
                      _builder_8.append(_upperBound_1);
                      _builder_8.append(", $type");
                      String _name_12 = eClass_3.getName();
                      _builder_8.append(_name_12);
                      _builder_8.append(":T.class, ");
                      {
                        boolean _isTransient_1 = ((EReference)eAttr_1).isTransient();
                        if (_isTransient_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_TRANSIENT, ");
                      {
                        boolean _isVolatile_1 = ((EReference)eAttr_1).isVolatile();
                        if (_isVolatile_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_VOLATILE, ");
                      {
                        boolean _isChangeable_1 = ((EReference)eAttr_1).isChangeable();
                        if (_isChangeable_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_CHANGEABLE, ");
                      {
                        boolean _isContainment_1 = ((EReference)eAttr_1).isContainment();
                        if (_isContainment_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_COMPOSITE, ");
                      {
                        boolean _isResolveProxiesFlag_1 = this.isResolveProxiesFlag(((EReference)eAttr_1));
                        if (_isResolveProxiesFlag_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_RESOLVE_PROXIES, ");
                      {
                        boolean _isUnsettable_1 = ((EReference)eAttr_1).isUnsettable();
                        if (_isUnsettable_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_UNSETTABLE, ");
                      {
                        boolean _isUnique_1 = ((EReference)eAttr_1).isUnique();
                        if (_isUnique_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_UNIQUE, ");
                      {
                        boolean _isDerived_1 = ((EReference)eAttr_1).isDerived();
                        if (_isDerived_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_DERIVED, ");
                      {
                        boolean _isOrdered_1 = ((EReference)eAttr_1).isOrdered();
                        if (_isOrdered_1) {
                        } else {
                          _builder_8.append("!");
                        }
                      }
                      _builder_8.append("IS_ORDERED);");
                      _builder_8.newLineIfNotEmpty();
                    }
                  }
                } else {
                  EClassifier _eType = eAttr_1.getEType();
                  if ((_eType instanceof EEnum)) {
                    _builder_8.append("initEAttribute(get");
                    String _normalizeUpperMethod_2 = this.namingUtils.normalizeUpperMethod(eAttr_1.getName(), eClass_3.getName());
                    _builder_8.append(_normalizeUpperMethod_2);
                    _builder_8.append("(), this.get");
                    String _firstUpper_2 = StringExtensions.toFirstUpper(eAttr_1.getEType().getName());
                    _builder_8.append(_firstUpper_2);
                    _builder_8.append("(), \"");
                    String _name_13 = eAttr_1.getName();
                    _builder_8.append(_name_13);
                    _builder_8.append("\", ");
                    {
                      Object _defaultValue = eAttr_1.getDefaultValue();
                      boolean _tripleEquals = (_defaultValue == null);
                      if (_tripleEquals) {
                        _builder_8.append("null");
                      } else {
                        _builder_8.append("\"");
                        Object _defaultValue_1 = eAttr_1.getDefaultValue();
                        _builder_8.append(_defaultValue_1);
                        _builder_8.append("\"");
                      }
                    }
                    _builder_8.append(", ");
                    int _lowerBound_2 = eAttr_1.getLowerBound();
                    _builder_8.append(_lowerBound_2);
                    _builder_8.append(", ");
                    int _upperBound_2 = eAttr_1.getUpperBound();
                    _builder_8.append(_upperBound_2);
                    _builder_8.append(", $type");
                    String _name_14 = eClass_3.getName();
                    _builder_8.append(_name_14);
                    _builder_8.append(":T.class, ");
                    {
                      boolean _isTransient_2 = eAttr_1.isTransient();
                      if (_isTransient_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_TRANSIENT, ");
                    {
                      boolean _isVolatile_2 = eAttr_1.isVolatile();
                      if (_isVolatile_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_VOLATILE, ");
                    {
                      boolean _isChangeable_2 = eAttr_1.isChangeable();
                      if (_isChangeable_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_CHANGEABLE, ");
                    {
                      boolean _isUnsettable_2 = eAttr_1.isUnsettable();
                      if (_isUnsettable_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_UNSETTABLE, ");
                    {
                      boolean _isID = ((EAttribute) eAttr_1).isID();
                      if (_isID) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_ID, ");
                    {
                      boolean _isUnique_2 = eAttr_1.isUnique();
                      if (_isUnique_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_UNIQUE, ");
                    {
                      boolean _isDerived_2 = eAttr_1.isDerived();
                      if (_isDerived_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_DERIVED, ");
                    {
                      boolean _isOrdered_2 = eAttr_1.isOrdered();
                      if (_isOrdered_2) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_ORDERED);");
                    _builder_8.newLineIfNotEmpty();
                  } else {
                    _builder_8.append("initEAttribute(get");
                    String _normalizeUpperMethod_3 = this.namingUtils.normalizeUpperMethod(eAttr_1.getName(), eClass_3.getName());
                    _builder_8.append(_normalizeUpperMethod_3);
                    _builder_8.append("(), ecorePackage.get");
                    {
                      boolean _startsWith = eAttr_1.getEType().getName().startsWith("E");
                      boolean _not_1 = (!_startsWith);
                      if (_not_1) {
                        _builder_8.append("E");
                      }
                    }
                    String _name_15 = eAttr_1.getEType().getName();
                    _builder_8.append(_name_15);
                    _builder_8.append("(), \"");
                    String _name_16 = eAttr_1.getName();
                    _builder_8.append(_name_16);
                    _builder_8.append("\", null, ");
                    int _lowerBound_3 = eAttr_1.getLowerBound();
                    _builder_8.append(_lowerBound_3);
                    _builder_8.append(", ");
                    int _upperBound_3 = eAttr_1.getUpperBound();
                    _builder_8.append(_upperBound_3);
                    _builder_8.append(", $type");
                    String _name_17 = eClass_3.getName();
                    _builder_8.append(_name_17);
                    _builder_8.append(":T.class, ");
                    {
                      boolean _isTransient_3 = eAttr_1.isTransient();
                      if (_isTransient_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_TRANSIENT, ");
                    {
                      boolean _isVolatile_3 = eAttr_1.isVolatile();
                      if (_isVolatile_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_VOLATILE, ");
                    {
                      boolean _isChangeable_3 = eAttr_1.isChangeable();
                      if (_isChangeable_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_CHANGEABLE, ");
                    {
                      boolean _isUnsettable_3 = eAttr_1.isUnsettable();
                      if (_isUnsettable_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_UNSETTABLE, ");
                    {
                      boolean _isID_1 = ((EAttribute) eAttr_1).isID();
                      if (_isID_1) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_ID, ");
                    {
                      boolean _isUnique_3 = eAttr_1.isUnique();
                      if (_isUnique_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_UNIQUE, ");
                    {
                      boolean _isDerived_3 = eAttr_1.isDerived();
                      if (_isDerived_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_DERIVED, ");
                    {
                      boolean _isOrdered_3 = eAttr_1.isOrdered();
                      if (_isOrdered_3) {
                      } else {
                        _builder_8.append("!");
                      }
                    }
                    _builder_8.append("IS_ORDERED);");
                    _builder_8.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
      {
        boolean _isEmpty_1 = IterableExtensions.isEmpty(allEnums);
        boolean _not_2 = (!_isEmpty_1);
        if (_not_2) {
          _builder_8.newLine();
          _builder_8.append("// Initialize enums and add enum literals");
          _builder_8.newLine();
          {
            for(final EEnum eEnum_2 : allEnums) {
              _builder_8.append("initEEnum(");
              String _firstLower_6 = StringExtensions.toFirstLower(eEnum_2.getName());
              _builder_8.append(_firstLower_6);
              _builder_8.append("EEnum, $type");
              String _name_18 = eEnum_2.getName();
              _builder_8.append(_name_18);
              _builder_8.append(":T.class, \"");
              String _name_19 = eEnum_2.getName();
              _builder_8.append(_name_19);
              _builder_8.append("\");");
              _builder_8.newLineIfNotEmpty();
              {
                EList<EEnumLiteral> _eLiterals = eEnum_2.getELiterals();
                for(final EEnumLiteral lit : _eLiterals) {
                  _builder_8.append("addEEnumLiteral(");
                  String _firstLower_7 = StringExtensions.toFirstLower(eEnum_2.getName());
                  _builder_8.append(_firstLower_7);
                  _builder_8.append("EEnum, $type");
                  String _name_20 = eEnum_2.getName();
                  _builder_8.append(_name_20);
                  _builder_8.append(":T.");
                  String _name_21 = lit.getName();
                  _builder_8.append(_name_21);
                  _builder_8.append(");");
                  _builder_8.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder_8.newLine();
      _builder_8.append("// Create resource");
      _builder_8.newLine();
      _builder_8.append("createResource(eNS_URI);");
      _builder_8.newLine();
      final MethodSpec initializePackageContentsMethod = _addModifiers_4.addNamedCode(_builder_8.toString(), hm).build();
      final Function1<EClassifier, FieldSpec> _function = (EClassifier eClassifier) -> {
        FieldSpec _xifexpression = null;
        if ((eClassifier instanceof EClass)) {
          StringConcatenation _builder_9 = new StringConcatenation();
          String _firstLower_8 = StringExtensions.toFirstLower(((EClass)eClassifier).getName());
          _builder_9.append(_firstLower_8);
          _builder_9.append("EClass");
          FieldSpec.Builder _builder_10 = FieldSpec.builder(EClass.class, _builder_9.toString());
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("null");
          _xifexpression = _builder_10.initializer(_builder_11.toString()).addModifiers(Modifier.PRIVATE).build();
        } else {
          StringConcatenation _builder_12 = new StringConcatenation();
          String _firstLower_9 = StringExtensions.toFirstLower(eClassifier.getName());
          _builder_12.append(_firstLower_9);
          _builder_12.append("EEnum");
          FieldSpec.Builder _builder_13 = FieldSpec.builder(EEnum.class, _builder_12.toString());
          StringConcatenation _builder_14 = new StringConcatenation();
          _builder_14.append("null");
          _xifexpression = _builder_13.initializer(_builder_14.toString()).addModifiers(Modifier.PRIVATE).build();
        }
        return _xifexpression;
      };
      final List<FieldSpec> eClassifiers = ListExtensions.<EClassifier, FieldSpec>map(abstractSyntax.getEClassifiers(), _function);
      final Function1<EClassifier, Pair<? extends EClassifier, MethodSpec>> _function_1 = (EClassifier eClassifier) -> {
        Pair<? extends EClassifier, MethodSpec> _xifexpression = null;
        if ((eClassifier instanceof EClass)) {
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("get");
          String _firstUpper_3 = StringExtensions.toFirstUpper(((EClass)eClassifier).getName());
          _builder_9.append(_firstUpper_3);
          MethodSpec.Builder _addModifiers_5 = MethodSpec.methodBuilder(_builder_9.toString()).returns(EClass.class).addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append("return ");
          String _firstLower_8 = StringExtensions.toFirstLower(((EClass)eClassifier).getName());
          _builder_10.append(_firstLower_8);
          _builder_10.append("EClass;");
          _builder_10.newLineIfNotEmpty();
          MethodSpec _build = _addModifiers_5.addCode(_builder_10.toString()).build();
          _xifexpression = Pair.<EClass, MethodSpec>of(((EClass)eClassifier), _build);
        } else {
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("get");
          String _firstUpper_4 = StringExtensions.toFirstUpper(eClassifier.getName());
          _builder_11.append(_firstUpper_4);
          MethodSpec.Builder _addModifiers_6 = MethodSpec.methodBuilder(_builder_11.toString()).returns(EEnum.class).addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_12 = new StringConcatenation();
          _builder_12.append("return ");
          String _firstLower_9 = StringExtensions.toFirstLower(eClassifier.getName());
          _builder_12.append(_firstLower_9);
          _builder_12.append("EEnum;");
          _builder_12.newLineIfNotEmpty();
          MethodSpec _build_1 = _addModifiers_6.addCode(_builder_12.toString()).build();
          _xifexpression = Pair.<EClassifier, MethodSpec>of(eClassifier, _build_1);
        }
        return _xifexpression;
      };
      final List<Pair<? extends EClassifier, MethodSpec>> eClassifierGetterMethods = ListExtensions.<EClassifier, Pair<? extends EClassifier, MethodSpec>>map(abstractSyntax.getEClassifiers(), _function_1);
      MethodSpec.Builder _addModifiers_5 = MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("super(eNS_URI, $T.eINSTANCE);");
      _builder_9.newLine();
      final MethodSpec constructor = _addModifiers_5.addCode(_builder_9.toString(), ClassName.get(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), this.namingUtils.factoryInterfaceClassName(abstractSyntax))).build();
      final Map<EClass, List<MethodSpec>> accessorsMethods = CollectionLiterals.<EClass, List<MethodSpec>>newHashMap();
      for (final EClass clazz : allClasses) {
        {
          int cptrI = 0;
          EList<EStructuralFeature> _eStructuralFeatures_2 = clazz.getEStructuralFeatures();
          for (final EStructuralFeature field : _eStructuralFeatures_2) {
            {
              boolean _containsKey = accessorsMethods.containsKey(clazz);
              boolean _not_3 = (!_containsKey);
              if (_not_3) {
                accessorsMethods.put(clazz, CollectionLiterals.<MethodSpec>newArrayList());
              }
              if ((field instanceof EReference)) {
                StringConcatenation _builder_10 = new StringConcatenation();
                _builder_10.append("get");
                String _name_22 = clazz.getName();
                _builder_10.append(_name_22);
                _builder_10.append("_");
                String _firstUpper_3 = StringExtensions.toFirstUpper(((EReference)field).getName());
                _builder_10.append(_firstUpper_3);
                MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_10.toString()).returns(EReference.class);
                StringConcatenation _builder_11 = new StringConcatenation();
                _builder_11.append("return ($T) ");
                String _firstLower_8 = StringExtensions.toFirstLower(clazz.getName());
                _builder_11.append(_firstLower_8);
                _builder_11.append("EClass.getEStructuralFeatures().get(");
                _builder_11.append(cptrI);
                _builder_11.append(");");
                _builder_11.newLineIfNotEmpty();
                accessorsMethods.get(clazz).add(
                  _returns_1.addCode(_builder_11.toString(), EReference.class).addModifiers(Modifier.PUBLIC).build());
              } else {
                if ((field instanceof EAttribute)) {
                  StringConcatenation _builder_12 = new StringConcatenation();
                  _builder_12.append("get");
                  String _firstUpper_4 = StringExtensions.toFirstUpper(this.namingUtils.normalizeUpperMethod(((EAttribute)field).getName(), clazz.getName()));
                  _builder_12.append(_firstUpper_4);
                  MethodSpec.Builder _returns_2 = MethodSpec.methodBuilder(_builder_12.toString()).returns(EAttribute.class);
                  StringConcatenation _builder_13 = new StringConcatenation();
                  _builder_13.append("return ($T) ");
                  String _firstLower_9 = StringExtensions.toFirstLower(clazz.getName());
                  _builder_13.append(_firstLower_9);
                  _builder_13.append("EClass.getEStructuralFeatures().get(");
                  _builder_13.append(cptrI);
                  _builder_13.append(");");
                  _builder_13.newLineIfNotEmpty();
                  accessorsMethods.get(clazz).add(
                    _returns_2.addCode(_builder_13.toString(), EAttribute.class).addModifiers(Modifier.PUBLIC).build());
                }
              }
              cptrI = (cptrI + 1);
            }
          }
        }
      }
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("get");
      String _firstUpper_3 = StringExtensions.toFirstUpper(abstractSyntax.getName());
      _builder_10.append(_firstUpper_3);
      _builder_10.append("Factory");
      MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_10.toString()).returns(factoryInterfaceType);
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("return ($T) getEFactoryInstance();");
      _builder_11.newLine();
      final MethodSpec getFactoryMethod = _returns_1.addCode(_builder_11.toString(), factoryInterfaceType).addModifiers(Modifier.PUBLIC).build();
      TypeSpec.Builder packageImplTmp = TypeSpec.classBuilder(this.namingUtils.packageImplementationClassName(abstractSyntax)).superclass(EPackageImpl.class).addSuperinterface(ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), this.namingUtils.packageInterfaceClassName(abstractSyntax))).addField(isInitedField).addFields(eClassifiers).addFields(Collections.<FieldSpec>unmodifiableList(CollectionLiterals.<FieldSpec>newArrayList(isCreatedField, isInitializedField))).addMethod(constructor).addMethod(initMethod);
      for (final Pair<? extends EClassifier, MethodSpec> mgf : eClassifierGetterMethods) {
        {
          packageImplTmp = packageImplTmp.addMethod(mgf.getValue());
          boolean _containsKey = accessorsMethods.containsKey(mgf.getKey());
          if (_containsKey) {
            packageImplTmp = packageImplTmp.addMethods(accessorsMethods.get(mgf.getKey()));
          }
        }
      }
      final TypeSpec packageImpl = packageImplTmp.addMethods(Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getFactoryMethod, createPackageContentsMethod, initializePackageContentsMethod))).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.packageImplementationPackageName(abstractSyntax, packageRoot), packageImpl).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
