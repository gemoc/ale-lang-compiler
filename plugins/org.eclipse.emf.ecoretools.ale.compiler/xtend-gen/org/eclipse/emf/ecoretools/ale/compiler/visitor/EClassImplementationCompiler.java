package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorCompilerUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
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
public class EClassImplementationCompiler {
  public static class CompilerExpressionCtx {
    public final String thisCtxName;
    
    public final ExtendedClass aleClass;
    
    public final EClass eClass;
    
    public CompilerExpressionCtx(final String thisCtxName, final ExtendedClass aleClass, final EClass eClass) {
      this.thisCtxName = thisCtxName;
      this.aleClass = aleClass;
      this.eClass = eClass;
    }
  }
  
  @Extension
  private VisitorNamingUtils namingUtils = new VisitorNamingUtils();
  
  @Extension
  private VisitorCompilerUtils _visitorCompilerUtils = new VisitorCompilerUtils();
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  private final EClassGetterCompiler eClassGetterCompiler = new EClassGetterCompiler(this.namingUtils);
  
  private Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private final Dsl dsl;
  
  private final String packageRoot;
  
  public EClassImplementationCompiler(final String packageRoot, final Dsl dsl) {
    this.packageRoot = packageRoot;
    this.dsl = dsl;
  }
  
  private TypeSpec.Builder compileEcoreRelated(final TypeSpec.Builder builder, final EClass eClass) {
    TypeSpec.Builder _xblockexpression = null;
    {
      final boolean isMapElement = ((eClass.getInstanceClass() != null) && Objects.equal(eClass.getInstanceClass(), Map.Entry.class));
      final ClassName ePackageInterfaceType = ClassName.get(this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), this.packageRoot), 
        this.namingUtils.packageInterfaceClassName(eClass.getEPackage()));
      boolean _isEmpty = eClass.getESuperTypes().isEmpty();
      final boolean hasSuperType = (!_isEmpty);
      final EClass superType = IterableExtensions.<EClass>head(eClass.getESuperTypes());
      final Function1<EAttribute, List<FieldSpec>> _function = (EAttribute field) -> {
        List<FieldSpec> _xblockexpression_1 = null;
        {
          final EClassifier fet = field.getEType();
          final TypeName type = this._visitorCompilerUtils.scopedTypeRef(fet, this.packageRoot);
          final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
          List<FieldSpec> _xifexpression = null;
          if (isMultiple) {
            List<FieldSpec> _xblockexpression_2 = null;
            {
              ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(EList.class), type.box());
              StringConcatenation _builder = new StringConcatenation();
              String _name = field.getName();
              _builder.append(_name);
              final FieldSpec fieldField = FieldSpec.builder(_get, _builder.toString(), Modifier.PROTECTED).build();
              _xblockexpression_2 = Collections.<FieldSpec>unmodifiableList(CollectionLiterals.<FieldSpec>newArrayList(fieldField));
            }
            _xifexpression = _xblockexpression_2;
          } else {
            List<FieldSpec> _xblockexpression_3 = null;
            {
              FieldSpec _xifexpression_1 = null;
              if ((fet instanceof EEnum)) {
                FieldSpec _xblockexpression_4 = null;
                {
                  StringConcatenation _builder = new StringConcatenation();
                  String _upperCase = field.getName().toUpperCase();
                  _builder.append(_upperCase);
                  _builder.append("_EDEFAULT");
                  FieldSpec.Builder tmpfs = FieldSpec.builder(type, _builder.toString());
                  if (((field.getDefaultValue() == null) || Objects.equal(field.getDefaultValue().toString(), ""))) {
                    StringConcatenation _builder_1 = new StringConcatenation();
                    _builder_1.append("null");
                    tmpfs = tmpfs.initializer(_builder_1.toString());
                  } else {
                    StringConcatenation _builder_2 = new StringConcatenation();
                    _builder_2.append("$T.");
                    String _upperCase_1 = field.getDefaultValue().toString().toUpperCase();
                    _builder_2.append(_upperCase_1);
                    tmpfs = tmpfs.initializer(_builder_2.toString(), 
                      ClassName.get(this.namingUtils.classInterfacePackageName(((EEnum)fet), this.packageRoot), this.namingUtils.classInterfaceClassName(((EEnum)fet))));
                  }
                  _xblockexpression_4 = tmpfs.addModifiers(Modifier.PROTECTED, Modifier.STATIC, Modifier.FINAL).build();
                }
                _xifexpression_1 = _xblockexpression_4;
              } else {
                StringConcatenation _builder = new StringConcatenation();
                String _upperCase = field.getName().toUpperCase();
                _builder.append(_upperCase);
                _builder.append("_EDEFAULT");
                FieldSpec.Builder _builder_1 = FieldSpec.builder(type, _builder.toString());
                StringConcatenation _builder_2 = new StringConcatenation();
                {
                  if (((field.getDefaultValue() == null) || Objects.equal(field.getDefaultValue().toString(), ""))) {
                    _builder_2.append("null");
                  } else {
                    Object _defaultValue = field.getDefaultValue();
                    _builder_2.append(_defaultValue);
                  }
                }
                _xifexpression_1 = _builder_1.initializer(_builder_2.toString()).addModifiers(Modifier.PROTECTED, Modifier.STATIC, Modifier.FINAL).build();
              }
              final FieldSpec edefault = _xifexpression_1;
              FieldSpec.Builder _builder_3 = FieldSpec.builder(type, this.namingUtils.normalizeVarName(field.getName()));
              StringConcatenation _builder_4 = new StringConcatenation();
              String _upperCase_1 = field.getName().toUpperCase();
              _builder_4.append(_upperCase_1);
              _builder_4.append("_EDEFAULT");
              final FieldSpec fieldField = _builder_3.initializer(_builder_4.toString()).addModifiers(Modifier.PROTECTED).build();
              _xblockexpression_3 = Collections.<FieldSpec>unmodifiableList(CollectionLiterals.<FieldSpec>newArrayList(edefault, fieldField));
            }
            _xifexpression = _xblockexpression_3;
          }
          _xblockexpression_1 = _xifexpression;
        }
        return _xblockexpression_1;
      };
      final Iterable<FieldSpec> fieldsEAttributes = Iterables.<FieldSpec>concat(ListExtensions.<EAttribute, List<FieldSpec>>map(eClass.getEAttributes(), _function));
      final Function1<EReference, Boolean> _function_1 = (EReference field) -> {
        boolean _xifexpression = false;
        EReference _eOpposite = field.getEOpposite();
        boolean _tripleNotEquals = (_eOpposite != null);
        if (_tripleNotEquals) {
          boolean _isContainment = field.getEOpposite().isContainment();
          _xifexpression = (!_isContainment);
        } else {
          _xifexpression = true;
        }
        return Boolean.valueOf(_xifexpression);
      };
      final Function1<EReference, FieldSpec> _function_2 = (EReference field) -> {
        FieldSpec _xblockexpression_1 = null;
        {
          final EClassifier ert = field.getEGenericType().getERawType();
          final TypeName rt = this._visitorCompilerUtils.scopedInterfaceTypeRef(ert, this.packageRoot);
          final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
          TypeName _xifexpression = null;
          if (isMultiple) {
            ParameterizedTypeName _xifexpression_1 = null;
            if (((ert.getInstanceClass() != null) && Objects.equal(ert.getInstanceClass(), Map.Entry.class))) {
              ParameterizedTypeName _xblockexpression_2 = null;
              {
                final Function1<EStructuralFeature, Boolean> _function_3 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "key"));
                };
                final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_3));
                final Function1<EStructuralFeature, Boolean> _function_4 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "value"));
                };
                final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_4));
                ParameterizedTypeName _xifexpression_2 = null;
                if (((key != null) && (value != null))) {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), this._visitorCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot), this._visitorCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot));
                } else {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EList.class), rt);
                }
                _xblockexpression_2 = _xifexpression_2;
              }
              _xifexpression_1 = _xblockexpression_2;
            } else {
              _xifexpression_1 = ParameterizedTypeName.get(ClassName.get(EList.class), rt);
            }
            _xifexpression = _xifexpression_1;
          } else {
            _xifexpression = rt;
          }
          final TypeName fieldType = _xifexpression;
          _xblockexpression_1 = FieldSpec.builder(fieldType, field.getName()).addModifiers(Modifier.PROTECTED).build();
        }
        return _xblockexpression_1;
      };
      final Iterable<FieldSpec> fieldsEReferences = IterableExtensions.<EReference, FieldSpec>map(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_1), _function_2);
      final Function1<EStructuralFeature, List<MethodSpec>> _function_3 = (EStructuralFeature field) -> {
        List<MethodSpec> _xblockexpression_1 = null;
        {
          final EClassifier ert = field.getEGenericType().getERawType();
          final TypeName rt = this._visitorCompilerUtils.scopedInterfaceTypeRef(ert, this.packageRoot);
          final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
          TypeName _xifexpression = null;
          if (isMultiple) {
            ParameterizedTypeName _xifexpression_1 = null;
            if (((ert.getInstanceClass() != null) && Objects.equal(ert.getInstanceClass(), Map.Entry.class))) {
              ParameterizedTypeName _xblockexpression_2 = null;
              {
                final Function1<EStructuralFeature, Boolean> _function_4 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "key"));
                };
                final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_4));
                final Function1<EStructuralFeature, Boolean> _function_5 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "value"));
                };
                final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_5));
                ParameterizedTypeName _xifexpression_2 = null;
                if (((key != null) && (value != null))) {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), this._visitorCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot).box(), this._visitorCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot).box());
                } else {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EList.class), rt.box());
                }
                _xblockexpression_2 = _xifexpression_2;
              }
              _xifexpression_1 = _xblockexpression_2;
            } else {
              _xifexpression_1 = ParameterizedTypeName.get(ClassName.get(EList.class), rt.box());
            }
            _xifexpression = _xifexpression_1;
          } else {
            _xifexpression = rt;
          }
          final TypeName fieldType = _xifexpression;
          _xblockexpression_1 = this.eClassGetterCompiler.compileGetter(field, fieldType, this.packageRoot, eClass, this.dsl, ePackageInterfaceType, isMapElement);
        }
        return _xblockexpression_1;
      };
      final Iterable<MethodSpec> methodsEReferences = Iterables.<MethodSpec>concat(ListExtensions.<EStructuralFeature, List<MethodSpec>>map(eClass.getEStructuralFeatures(), _function_3));
      MethodSpec.Builder _addModifiers = MethodSpec.methodBuilder("eStaticClass").addAnnotation(Override.class).returns(EClass.class).addModifiers(Modifier.PROTECTED);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return $1T.Literals.");
      String _normalizeUpperField = this.namingUtils.normalizeUpperField(eClass.getName());
      _builder.append(_normalizeUpperField);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      final MethodSpec eStaticClassMethod = _addModifiers.addCode(_builder.toString(), ePackageInterfaceType).build();
      Iterable<MethodSpec> _xifexpression = null;
      boolean _isEmpty_1 = eClass.getEStructuralFeatures().isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        Iterable<MethodSpec> _xblockexpression_1 = null;
        {
          Pair<String, TypeName> _mappedTo = Pair.<String, TypeName>of("epit", ePackageInterfaceType);
          ClassName _get = ClassName.get(EStructuralFeature.Setting.class);
          Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("esf", _get);
          final Map<String, TypeName> namedMap = CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1);
          EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
          for (final EStructuralFeature esf : _eStructuralFeatures) {
            if ((esf instanceof EAttribute)) {
              final TypeName tn = this._visitorCompilerUtils.scopedTypeRef(((EAttribute)esf).getEType(), this.packageRoot).box();
              String _name = ((EAttribute)esf).getName();
              String _plus = ("fieldtype" + _name);
              namedMap.put(_plus, tn);
              final WildcardTypeName genericType = WildcardTypeName.subtypeOf(tn);
              String _name_1 = ((EAttribute)esf).getName();
              String _plus_1 = ("collection" + _name_1);
              namedMap.put(_plus_1, ParameterizedTypeName.get(ClassName.get(Collection.class), genericType.box()));
            } else {
              EClassifier _eType = esf.getEType();
              EClassifier _eType_1 = esf.getEType();
              final ClassName tn_1 = ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eType), this.packageRoot), this.namingUtils.classInterfaceClassName(((EClass) _eType_1)));
              String _name_2 = esf.getName();
              String _plus_2 = ("fieldtype" + _name_2);
              namedMap.put(_plus_2, tn_1);
              String _name_3 = esf.getName();
              String _plus_3 = ("collection" + _name_3);
              namedMap.put(_plus_3, ParameterizedTypeName.get(ClassName.get(Collection.class), WildcardTypeName.subtypeOf(tn_1.box())));
            }
          }
          MethodSpec.Builder _addModifiers_1 = MethodSpec.methodBuilder("eSet").addAnnotation(Override.class).addParameter(int.class, "featureID").addParameter(Object.class, "newValue").addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("switch (featureID) {");
          _builder_1.newLine();
          {
            EList<EStructuralFeature> _eStructuralFeatures_1 = eClass.getEStructuralFeatures();
            for(final EStructuralFeature esf_1 : _eStructuralFeatures_1) {
              _builder_1.append("\t");
              _builder_1.append("case $epit:T.");
              String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(esf_1.getName(), eClass.getName());
              _builder_1.append(_normalizeUpperField_1, "\t");
              _builder_1.append(" :");
              _builder_1.newLineIfNotEmpty();
              {
                if ((esf_1 instanceof EAttribute)) {
                  {
                    if (((((EAttribute)esf_1).getUpperBound() <= 1) && (((EAttribute)esf_1).getUpperBound() >= 0))) {
                      _builder_1.append("\t");
                      _builder_1.append("\t");
                      _builder_1.append("set");
                      String _firstUpper = StringExtensions.toFirstUpper(((EAttribute)esf_1).getName());
                      _builder_1.append(_firstUpper, "\t\t");
                      _builder_1.append("(($fieldtype");
                      String _name_4 = ((EAttribute)esf_1).getName();
                      _builder_1.append(_name_4, "\t\t");
                      _builder_1.append(":T) newValue);");
                      _builder_1.newLineIfNotEmpty();
                    } else {
                      _builder_1.append("\t");
                      _builder_1.append("\t");
                      _builder_1.append("get");
                      String _firstUpper_1 = StringExtensions.toFirstUpper(((EAttribute)esf_1).getName());
                      _builder_1.append(_firstUpper_1, "\t\t");
                      _builder_1.append("().clear();");
                      _builder_1.newLineIfNotEmpty();
                      _builder_1.append("\t");
                      _builder_1.append("\t");
                      _builder_1.append("get");
                      String _firstUpper_2 = StringExtensions.toFirstUpper(((EAttribute)esf_1).getName());
                      _builder_1.append(_firstUpper_2, "\t\t");
                      _builder_1.append("().addAll(($collection");
                      String _name_5 = ((EAttribute)esf_1).getName();
                      _builder_1.append(_name_5, "\t\t");
                      _builder_1.append(":T) newValue);");
                      _builder_1.newLineIfNotEmpty();
                    }
                  }
                } else {
                  {
                    if (((esf_1.getUpperBound() <= 1) && (esf_1.getUpperBound() >= 0))) {
                      _builder_1.append("\t");
                      _builder_1.append("\t");
                      _builder_1.append("set");
                      String _firstUpper_3 = StringExtensions.toFirstUpper(esf_1.getName());
                      _builder_1.append(_firstUpper_3, "\t\t");
                      _builder_1.append("(($fieldtype");
                      String _name_6 = esf_1.getName();
                      _builder_1.append(_name_6, "\t\t");
                      _builder_1.append(":T) newValue);");
                      _builder_1.newLineIfNotEmpty();
                    } else {
                      {
                        if (((esf_1.getEType().getInstanceClass() != null) && Objects.equal(esf_1.getEType().getInstanceClass(), Map.Entry.class))) {
                          _builder_1.append("\t");
                          _builder_1.append("\t");
                          _builder_1.append("(($esf:T)get");
                          String _firstUpper_4 = StringExtensions.toFirstUpper(esf_1.getName());
                          _builder_1.append(_firstUpper_4, "\t\t");
                          _builder_1.append("()).set(newValue);");
                          _builder_1.newLineIfNotEmpty();
                        } else {
                          _builder_1.append("\t");
                          _builder_1.append("\t");
                          _builder_1.append("get");
                          String _firstUpper_5 = StringExtensions.toFirstUpper(esf_1.getName());
                          _builder_1.append(_firstUpper_5, "\t\t");
                          _builder_1.append("().clear();");
                          _builder_1.newLineIfNotEmpty();
                          _builder_1.append("\t");
                          _builder_1.append("\t");
                          _builder_1.append("get");
                          String _firstUpper_6 = StringExtensions.toFirstUpper(esf_1.getName());
                          _builder_1.append(_firstUpper_6, "\t\t");
                          _builder_1.append("().addAll(($collection");
                          String _name_7 = esf_1.getName();
                          _builder_1.append(_name_7, "\t\t");
                          _builder_1.append(":T) newValue);");
                          _builder_1.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                }
              }
              _builder_1.append("\t");
              _builder_1.append("\t");
              _builder_1.append("return;");
              _builder_1.newLine();
            }
          }
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("super.eSet(featureID, newValue);");
          _builder_1.newLine();
          final MethodSpec eSetMethod = _addModifiers_1.addNamedCode(_builder_1.toString(), namedMap).build();
          MethodSpec.Builder _addModifiers_2 = MethodSpec.methodBuilder("eUnset").addAnnotation(Override.class).addParameter(int.class, "featureID").addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("switch (featureID) {");
          _builder_2.newLine();
          {
            EList<EStructuralFeature> _eStructuralFeatures_2 = eClass.getEStructuralFeatures();
            for(final EStructuralFeature esf_2 : _eStructuralFeatures_2) {
              _builder_2.append("\t");
              _builder_2.append("case $epit:T.");
              String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(esf_2.getName(), eClass.getName());
              _builder_2.append(_normalizeUpperField_2, "\t");
              _builder_2.append(" :");
              _builder_2.newLineIfNotEmpty();
              {
                if ((esf_2 instanceof EAttribute)) {
                  {
                    if (((((EAttribute)esf_2).getUpperBound() <= 1) && (((EAttribute)esf_2).getUpperBound() >= 0))) {
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("set");
                      String _firstUpper_7 = StringExtensions.toFirstUpper(((EAttribute)esf_2).getName());
                      _builder_2.append(_firstUpper_7, "\t\t");
                      _builder_2.append("(");
                      String _upperCase = ((EAttribute)esf_2).getName().toUpperCase();
                      _builder_2.append(_upperCase, "\t\t");
                      _builder_2.append("_EDEFAULT);");
                      _builder_2.newLineIfNotEmpty();
                    } else {
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("get");
                      String _firstUpper_8 = StringExtensions.toFirstUpper(((EAttribute)esf_2).getName());
                      _builder_2.append(_firstUpper_8, "\t\t");
                      _builder_2.append("().clear();");
                      _builder_2.newLineIfNotEmpty();
                    }
                  }
                } else {
                  {
                    if (((esf_2.getUpperBound() <= 1) && (esf_2.getUpperBound() >= 0))) {
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("set");
                      String _firstUpper_9 = StringExtensions.toFirstUpper(esf_2.getName());
                      _builder_2.append(_firstUpper_9, "\t\t");
                      _builder_2.append("(($fieldtype");
                      String _name_8 = esf_2.getName();
                      _builder_2.append(_name_8, "\t\t");
                      _builder_2.append(":T) null);");
                      _builder_2.newLineIfNotEmpty();
                    } else {
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("get");
                      String _firstUpper_10 = StringExtensions.toFirstUpper(esf_2.getName());
                      _builder_2.append(_firstUpper_10, "\t\t");
                      _builder_2.append("().clear();");
                      _builder_2.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder_2.append("\t");
              _builder_2.append("\t");
              _builder_2.append("return;");
              _builder_2.newLine();
            }
          }
          _builder_2.append("}");
          _builder_2.newLine();
          _builder_2.append("super.eUnset(featureID);");
          _builder_2.newLine();
          final MethodSpec eUnsetMethod = _addModifiers_2.addNamedCode(_builder_2.toString(), namedMap).build();
          MethodSpec.Builder _addModifiers_3 = MethodSpec.methodBuilder("eGet").addAnnotation(Override.class).returns(Object.class).addParameter(int.class, "featureID").addParameter(boolean.class, "resolve").addParameter(boolean.class, "coreType").addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("switch (featureID) {");
          _builder_3.newLine();
          {
            EList<EStructuralFeature> _eStructuralFeatures_3 = eClass.getEStructuralFeatures();
            for(final EStructuralFeature esf_3 : _eStructuralFeatures_3) {
              _builder_3.append("\t");
              _builder_3.append("case $1T.");
              String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(esf_3.getName(), eClass.getName());
              _builder_3.append(_normalizeUpperField_3, "\t");
              _builder_3.append(" :");
              _builder_3.newLineIfNotEmpty();
              {
                if (((esf_3.getEType().getInstanceClass() != null) && Objects.equal(esf_3.getEType().getInstanceClass(), Map.Entry.class))) {
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("if (coreType)");
                  _builder_3.newLine();
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("return get");
                  String _firstUpper_11 = StringExtensions.toFirstUpper(esf_3.getName());
                  _builder_3.append(_firstUpper_11, "\t\t\t");
                  _builder_3.append("();");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("else");
                  _builder_3.newLine();
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("\t");
                  _builder_3.append("return get");
                  String _firstUpper_12 = StringExtensions.toFirstUpper(esf_3.getName());
                  _builder_3.append(_firstUpper_12, "\t\t\t");
                  _builder_3.append("().map();");
                  _builder_3.newLineIfNotEmpty();
                } else {
                  if ((this.isResolveProxies(esf_3) && (!this.isListType(esf_3)))) {
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("if (resolve)");
                    _builder_3.newLine();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("return ");
                    {
                      String _name_9 = esf_3.getEType().getName();
                      boolean _equals = Objects.equal(_name_9, "EBoolean");
                      if (_equals) {
                        _builder_3.append("is");
                      } else {
                        _builder_3.append("get");
                      }
                    }
                    String _firstUpper_13 = StringExtensions.toFirstUpper(esf_3.getName());
                    _builder_3.append(_firstUpper_13, "\t\t\t");
                    _builder_3.append("();");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("return basic");
                    {
                      String _name_10 = esf_3.getEType().getName();
                      boolean _equals_1 = Objects.equal(_name_10, "EBoolean");
                      if (_equals_1) {
                        _builder_3.append("Is");
                      } else {
                        _builder_3.append("Get");
                      }
                    }
                    String _firstUpper_14 = StringExtensions.toFirstUpper(esf_3.getName());
                    _builder_3.append(_firstUpper_14, "\t\t");
                    _builder_3.append("();");
                    _builder_3.newLineIfNotEmpty();
                  } else {
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("return ");
                    {
                      String _name_11 = esf_3.getEType().getName();
                      boolean _equals_2 = Objects.equal(_name_11, "EBoolean");
                      if (_equals_2) {
                        _builder_3.append("is");
                      } else {
                        _builder_3.append("get");
                      }
                    }
                    String _firstUpper_15 = StringExtensions.toFirstUpper(esf_3.getName());
                    _builder_3.append(_firstUpper_15, "\t\t");
                    _builder_3.append("();");
                    _builder_3.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
          _builder_3.append("}");
          _builder_3.newLine();
          _builder_3.append("return super.eGet(featureID, resolve, coreType);");
          _builder_3.newLine();
          final MethodSpec eGetMethod = _addModifiers_3.addCode(_builder_3.toString(), ePackageInterfaceType).build();
          MethodSpec.Builder _addModifiers_4 = MethodSpec.methodBuilder("eIsSet").addAnnotation(Override.class).returns(boolean.class).addParameter(int.class, "featureID").addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("switch (featureID) {");
          _builder_4.newLine();
          {
            EList<EStructuralFeature> _eStructuralFeatures_4 = eClass.getEStructuralFeatures();
            for(final EStructuralFeature esf_4 : _eStructuralFeatures_4) {
              _builder_4.append("\t");
              _builder_4.append("case $1T.");
              String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(esf_4.getName(), eClass.getName());
              _builder_4.append(_normalizeUpperField_4, "\t");
              _builder_4.append(" :");
              _builder_4.newLineIfNotEmpty();
              {
                if ((esf_4 instanceof EAttribute)) {
                  {
                    if (((((EAttribute)esf_4).getUpperBound() <= 1) && (((EAttribute)esf_4).getUpperBound() >= 0))) {
                      _builder_4.append("\t");
                      _builder_4.append("\t");
                      _builder_4.append("return ");
                      String _normalizeVarName = this.namingUtils.normalizeVarName(((EAttribute)esf_4).getName());
                      _builder_4.append(_normalizeVarName, "\t\t");
                      _builder_4.append(" != ");
                      String _upperCase_1 = ((EAttribute)esf_4).getName().toUpperCase();
                      _builder_4.append(_upperCase_1, "\t\t");
                      _builder_4.append("_EDEFAULT;");
                      _builder_4.newLineIfNotEmpty();
                    } else {
                      _builder_4.append("\t");
                      _builder_4.append("\t");
                      _builder_4.append("return ");
                      String _normalizeVarName_1 = this.namingUtils.normalizeVarName(((EAttribute)esf_4).getName());
                      _builder_4.append(_normalizeVarName_1, "\t\t");
                      _builder_4.append(" != null && !");
                      String _normalizeVarName_2 = this.namingUtils.normalizeVarName(((EAttribute)esf_4).getName());
                      _builder_4.append(_normalizeVarName_2, "\t\t");
                      _builder_4.append(".isEmpty();");
                      _builder_4.newLineIfNotEmpty();
                    }
                  }
                } else {
                  {
                    int _upperBound = esf_4.getUpperBound();
                    boolean _lessEqualsThan = (_upperBound <= 1);
                    if (_lessEqualsThan) {
                      {
                        if (((((EReference) esf_4).getEOpposite() != null) && ((EReference) esf_4).getEOpposite().isContainment())) {
                          _builder_4.append("\t");
                          _builder_4.append("\t");
                          _builder_4.append("return get");
                          String _firstUpper_16 = StringExtensions.toFirstUpper(esf_4.getName());
                          _builder_4.append(_firstUpper_16, "\t\t");
                          _builder_4.append("() != null;");
                          _builder_4.newLineIfNotEmpty();
                        } else {
                          {
                            if (((esf_4.getUpperBound() == 0) || (esf_4.getUpperBound() == 1))) {
                              _builder_4.append("\t");
                              _builder_4.append("\t");
                              _builder_4.append("return ");
                              String _normalizeVarName_3 = this.namingUtils.normalizeVarName(esf_4.getName());
                              _builder_4.append(_normalizeVarName_3, "\t\t");
                              _builder_4.append(" != null;");
                              _builder_4.newLineIfNotEmpty();
                            } else {
                              _builder_4.append("\t");
                              _builder_4.append("\t");
                              _builder_4.append("return ");
                              String _normalizeVarName_4 = this.namingUtils.normalizeVarName(esf_4.getName());
                              _builder_4.append(_normalizeVarName_4, "\t\t");
                              _builder_4.append(" != null && !");
                              String _normalizeVarName_5 = this.namingUtils.normalizeVarName(esf_4.getName());
                              _builder_4.append(_normalizeVarName_5, "\t\t");
                              _builder_4.append(".isEmpty();");
                              _builder_4.newLineIfNotEmpty();
                            }
                          }
                        }
                      }
                    } else {
                      _builder_4.append("\t");
                      _builder_4.append("\t");
                      _builder_4.append("throw new RuntimeException(\"Not Implemented\");");
                      _builder_4.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder_4.append("}");
          _builder_4.newLine();
          _builder_4.append("return super.eIsSet(featureID);");
          _builder_4.newLine();
          final MethodSpec eIsSetMethod = _addModifiers_4.addCode(_builder_4.toString(), ePackageInterfaceType).build();
          List<MethodSpec> _xifexpression_1 = null;
          final Function1<EReference, Boolean> _function_4 = (EReference it) -> {
            return Boolean.valueOf((it.isContainment() || (it.getEOpposite() != null)));
          };
          boolean _isEmpty_2 = IterableExtensions.isEmpty(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_4));
          boolean _not_1 = (!_isEmpty_2);
          if (_not_1) {
            List<MethodSpec> _xblockexpression_2 = null;
            {
              ParameterizedTypeName _get_1 = ParameterizedTypeName.get(ClassName.get(InternalEList.class), WildcardTypeName.subtypeOf(Object.class));
              Pair<String, ParameterizedTypeName> _mappedTo_2 = Pair.<String, ParameterizedTypeName>of("il", _get_1);
              ClassName _get_2 = ClassName.get(this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), this.packageRoot), this.namingUtils.packageInterfaceClassName(eClass.getEPackage()));
              Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("package", _get_2);
              final HashMap<String, TypeName> eInverseRemoveCodeMap = CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_2, _mappedTo_3);
              MethodSpec.Builder _addParameter = MethodSpec.methodBuilder("eInverseRemove").addAnnotation(Override.class).returns(NotificationChain.class).addModifiers(Modifier.PUBLIC).addParameter(ParameterSpec.builder(InternalEObject.class, "otherEnd").build()).addParameter(
                ParameterSpec.builder(int.class, "featureID").build()).addParameter(
                ParameterSpec.builder(NotificationChain.class, "msgs").build());
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("switch (featureID) {");
              _builder_5.newLine();
              {
                final Function1<EReference, Boolean> _function_5 = (EReference it) -> {
                  return Boolean.valueOf((it.isContainment() || (it.getEOpposite() != null)));
                };
                Iterable<EReference> _filter = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_5);
                for(final EReference ref : _filter) {
                  _builder_5.append("\t");
                  _builder_5.append("case $package:T.");
                  String _normalizeUpperField_5 = this.namingUtils.normalizeUpperField(ref.getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_5, "\t");
                  _builder_5.append(" :");
                  _builder_5.newLineIfNotEmpty();
                  {
                    if (((ref.getUpperBound() == 0) || (ref.getUpperBound() == 1))) {
                      _builder_5.append("\t");
                      _builder_5.append("\t");
                      _builder_5.append("return basicSet");
                      String _firstUpper_17 = StringExtensions.toFirstUpper(ref.getName());
                      _builder_5.append(_firstUpper_17, "\t\t");
                      _builder_5.append("(null, msgs);");
                      _builder_5.newLineIfNotEmpty();
                    } else {
                      _builder_5.append("\t");
                      _builder_5.append("\t");
                      _builder_5.append("return (($il:T) get");
                      String _firstUpper_18 = StringExtensions.toFirstUpper(ref.getName());
                      _builder_5.append(_firstUpper_18, "\t\t");
                      _builder_5.append("()).basicRemove(otherEnd, msgs);");
                      _builder_5.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder_5.append("}");
              _builder_5.newLine();
              _builder_5.append("return super.eInverseRemove(otherEnd, featureID, msgs);");
              _builder_5.newLine();
              final MethodSpec reteir = _addParameter.addNamedCode(_builder_5.toString(), eInverseRemoveCodeMap).build();
              _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(reteir));
            }
            _xifexpression_1 = _xblockexpression_2;
          } else {
            _xifexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
          }
          final List<MethodSpec> eInverseRemove = _xifexpression_1;
          final Function1<EReference, Boolean> _function_5 = (EReference field) -> {
            boolean _xblockexpression_3 = false;
            {
              final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
              EReference _eOpposite = field.getEOpposite();
              final boolean existEOpposite = (_eOpposite != null);
              final boolean isContainment = field.isContainment();
              final boolean isOppositeContainment = (existEOpposite && field.getEOpposite().isContainment());
              _xblockexpression_3 = (((existEOpposite && (!isMultiple)) && (!isContainment)) && isOppositeContainment);
            }
            return Boolean.valueOf(_xblockexpression_3);
          };
          final Iterable<EReference> eBasicRemoveFromContainerFeatureFields = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_5);
          List<MethodSpec> _xifexpression_2 = null;
          boolean _isEmpty_3 = IterableExtensions.isEmpty(eBasicRemoveFromContainerFeatureFields);
          boolean _not_2 = (!_isEmpty_3);
          if (_not_2) {
            List<MethodSpec> _xblockexpression_3 = null;
            {
              Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
              final HashMap<String, ClassName> hm = CollectionLiterals.<String, ClassName>newHashMap(_mappedTo_2);
              for (final EReference field : eBasicRemoveFromContainerFeatureFields) {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("type");
                String _name_12 = field.getEType().getName();
                _builder_5.append(_name_12);
                hm.put(_builder_5.toString(), ClassName.get(this.namingUtils.classInterfacePackageName(eClass, this.packageRoot), field.getEType().getName()));
              }
              StringConcatenation _builder_6 = new StringConcatenation();
              _builder_6.append("eBasicRemoveFromContainerFeature");
              MethodSpec.Builder _addParameter = MethodSpec.methodBuilder(_builder_6.toString()).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC).returns(NotificationChain.class).addParameter(NotificationChain.class, "msgs");
              StringConcatenation _builder_7 = new StringConcatenation();
              _builder_7.append("switch (eContainerFeatureID()) {");
              _builder_7.newLine();
              {
                for(final EReference field_1 : eBasicRemoveFromContainerFeatureFields) {
                  _builder_7.append("\t");
                  _builder_7.append("case $epit:T.");
                  String _normalizeUpperField_5 = this.namingUtils.normalizeUpperField(field_1.getName(), eClass.getName());
                  _builder_7.append(_normalizeUpperField_5, "\t");
                  _builder_7.append(" :");
                  _builder_7.newLineIfNotEmpty();
                  _builder_7.append("\t");
                  _builder_7.append("\t");
                  _builder_7.append("return eInternalContainer().eInverseRemove(this, $epit:T.");
                  String _normalizeUpperField_6 = this.namingUtils.normalizeUpperField(field_1.getEOpposite().getName(), field_1.getEOpposite().getEContainingClass().getName());
                  _builder_7.append(_normalizeUpperField_6, "\t\t");
                  _builder_7.append(", $type");
                  String _name_13 = field_1.getEType().getName();
                  _builder_7.append(_name_13, "\t\t");
                  _builder_7.append(":T.class, msgs);");
                  _builder_7.newLineIfNotEmpty();
                }
              }
              _builder_7.append("}");
              _builder_7.newLine();
              _builder_7.append("return super.eBasicRemoveFromContainerFeature(msgs);");
              _builder_7.newLine();
              MethodSpec _build = _addParameter.addNamedCode(_builder_7.toString(), hm).build();
              _xblockexpression_3 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(_build));
            }
            _xifexpression_2 = _xblockexpression_3;
          } else {
            _xifexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
          }
          final List<MethodSpec> eBasicRemoveFromContainerFeature = _xifexpression_2;
          Iterable<MethodSpec> _plus_4 = Iterables.<MethodSpec>concat(eInverseRemove, eBasicRemoveFromContainerFeature);
          _xblockexpression_1 = Iterables.<MethodSpec>concat(_plus_4, Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(eGetMethod, eSetMethod, eUnsetMethod, eIsSetMethod)));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      final Iterable<MethodSpec> eSetMethod = _xifexpression;
      List<MethodSpec> _xifexpression_1 = null;
      final Function1<EReference, Boolean> _function_4 = (EReference it) -> {
        EReference _eOpposite = it.getEOpposite();
        return Boolean.valueOf((_eOpposite != null));
      };
      boolean _isEmpty_2 = IterableExtensions.isEmpty(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_4));
      boolean _not_1 = (!_isEmpty_2);
      if (_not_1) {
        List<MethodSpec> _xblockexpression_2 = null;
        {
          Pair<String, Class<NotificationChain>> _mappedTo = Pair.<String, Class<NotificationChain>>of("nc", NotificationChain.class);
          Pair<String, ClassName> _mappedTo_1 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(InternalEList.class), ClassName.get(InternalEObject.class));
          Pair<String, ParameterizedTypeName> _mappedTo_2 = Pair.<String, ParameterizedTypeName>of("eil", _get);
          ParameterizedTypeName _get_1 = ParameterizedTypeName.get(ClassName.get(InternalEList.class), WildcardTypeName.subtypeOf(Object.class));
          Pair<String, ParameterizedTypeName> _mappedTo_3 = Pair.<String, ParameterizedTypeName>of("eilg", _get_1);
          TypeName _get_2 = TypeName.get(InternalEObject.class);
          Pair<String, TypeName> _mappedTo_4 = Pair.<String, TypeName>of("ieo", _get_2);
          final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4);
          final Function1<EReference, Boolean> _function_5 = (EReference it) -> {
            EReference _eOpposite = it.getEOpposite();
            return Boolean.valueOf((_eOpposite != null));
          };
          Iterable<EReference> _filter = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_5);
          for (final EReference ref : _filter) {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name = ref.getName();
            _builder_1.append(_name);
            _builder_1.append("eOppositeType");
            EObject _eContainer = ref.getEOpposite().eContainer();
            EObject _eContainer_1 = ref.getEOpposite().eContainer();
            hm.put(_builder_1.toString(), ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eContainer), this.packageRoot), this.namingUtils.classInterfaceClassName(((EClass) _eContainer_1))));
          }
          MethodSpec.Builder _addParameter = MethodSpec.methodBuilder("eInverseAdd").addAnnotation(Override.class).returns(NotificationChain.class).addParameter(InternalEObject.class, "otherEnd").addParameter(int.class, "featureID").addParameter(NotificationChain.class, "msgs");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("switch (featureID) {");
          _builder_2.newLine();
          {
            final Function1<EReference, Boolean> _function_6 = (EReference it) -> {
              EReference _eOpposite = it.getEOpposite();
              return Boolean.valueOf((_eOpposite != null));
            };
            Iterable<EReference> _filter_1 = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_6);
            for(final EReference ref_1 : _filter_1) {
              _builder_2.append("\t");
              _builder_2.append("case $epit:T.");
              String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(ref_1.getName(), eClass.getName());
              _builder_2.append(_normalizeUpperField_1, "\t");
              _builder_2.append(" :");
              _builder_2.newLineIfNotEmpty();
              {
                if (((ref_1.getUpperBound() == 0) || (ref_1.getUpperBound() == 1))) {
                  {
                    if (((ref_1.getEOpposite() != null) && ref_1.getEOpposite().isContainment())) {
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("if (eInternalContainer() != null)");
                      _builder_2.newLine();
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("msgs = eBasicRemoveFromContainer(msgs);");
                      _builder_2.newLine();
                      _builder_2.append("\t");
                      _builder_2.append("\t");
                      _builder_2.append("return basicSet");
                      String _firstUpper = StringExtensions.toFirstUpper(ref_1.getName());
                      _builder_2.append(_firstUpper, "\t\t");
                      _builder_2.append("(($");
                      String _name_1 = ref_1.getName();
                      _builder_2.append(_name_1, "\t\t");
                      _builder_2.append("eOppositeType:T) otherEnd, msgs);");
                      _builder_2.newLineIfNotEmpty();
                    } else {
                      if (((ref_1.getEOpposite() != null) && ref_1.isContainment())) {
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("if (");
                        String _name_2 = ref_1.getName();
                        _builder_2.append(_name_2, "\t\t");
                        _builder_2.append(" != null)");
                        _builder_2.newLineIfNotEmpty();
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("msgs = (($ieo:T) ");
                        String _name_3 = ref_1.getName();
                        _builder_2.append(_name_3, "\t\t\t");
                        _builder_2.append(").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $epit:T.");
                        String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(ref_1.getName(), ref_1.getEOpposite().getEType().getName());
                        _builder_2.append(_normalizeUpperField_2, "\t\t\t");
                        _builder_2.append(", null, msgs);");
                        _builder_2.newLineIfNotEmpty();
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("return basicSet");
                        String _firstUpper_1 = StringExtensions.toFirstUpper(ref_1.getName());
                        _builder_2.append(_firstUpper_1, "\t\t");
                        _builder_2.append("(($");
                        String _name_4 = ref_1.getName();
                        _builder_2.append(_name_4, "\t\t");
                        _builder_2.append("eOppositeType:T) otherEnd, msgs);");
                        _builder_2.newLineIfNotEmpty();
                      } else {
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("if (");
                        String _name_5 = ref_1.getName();
                        _builder_2.append(_name_5, "\t\t");
                        _builder_2.append(" != null)");
                        _builder_2.newLineIfNotEmpty();
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("msgs = (($ieo:T) ");
                        String _name_6 = ref_1.getName();
                        _builder_2.append(_name_6, "\t\t\t");
                        _builder_2.append(").eInverseRemove(this, $epit:T.");
                        EObject _eContainer_2 = ref_1.getEOpposite().eContainer();
                        String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(ref_1.getEOpposite().getName(), ((EClass) _eContainer_2).getName());
                        _builder_2.append(_normalizeUpperField_3, "\t\t\t");
                        _builder_2.append(", ");
                        EObject _eContainer_3 = ref_1.getEOpposite().eContainer();
                        String _name_7 = ((EClass) _eContainer_3).getName();
                        _builder_2.append(_name_7, "\t\t\t");
                        _builder_2.append(".class, msgs);");
                        _builder_2.newLineIfNotEmpty();
                        _builder_2.append("\t");
                        _builder_2.append("\t");
                        _builder_2.append("return basicSet");
                        String _firstUpper_2 = StringExtensions.toFirstUpper(ref_1.getName());
                        _builder_2.append(_firstUpper_2, "\t\t");
                        _builder_2.append("(($");
                        String _name_8 = ref_1.getName();
                        _builder_2.append(_name_8, "\t\t");
                        _builder_2.append("eOppositeType:T) otherEnd, msgs);");
                        _builder_2.newLineIfNotEmpty();
                      }
                    }
                  }
                } else {
                  _builder_2.append("\t");
                  _builder_2.append("\t");
                  _builder_2.append("return (($eil:T) ($eilg:T) get");
                  String _firstUpper_3 = StringExtensions.toFirstUpper(ref_1.getName());
                  _builder_2.append(_firstUpper_3, "\t\t");
                  _builder_2.append("()).basicAdd(otherEnd, msgs);");
                  _builder_2.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder_2.append("}");
          _builder_2.newLine();
          _builder_2.append("return super.eInverseAdd(otherEnd, featureID, msgs);");
          _builder_2.newLine();
          MethodSpec _build = _addParameter.addNamedCode(_builder_2.toString(), hm).addModifiers(Modifier.PUBLIC).build();
          _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(_build));
        }
        _xifexpression_1 = _xblockexpression_2;
      } else {
        _xifexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      final List<MethodSpec> eInverseAdd = _xifexpression_1;
      final Function1<EStructuralFeature, Boolean> _function_5 = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "key"));
      };
      final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass.eContents(), EStructuralFeature.class), _function_5));
      final Function1<EStructuralFeature, Boolean> _function_6 = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "value"));
      };
      final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass.eContents(), EStructuralFeature.class), _function_6));
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_7 = (TypeSpec.Builder it) -> {
        return it.addModifiers(Modifier.ABSTRACT);
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_8 = (TypeSpec.Builder it) -> {
        return it.superclass(ClassName.get(this.namingUtils.classImplementationPackageName(superType, this.packageRoot), this.namingUtils.classImplementationClassName(superType)));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_9 = (TypeSpec.Builder it) -> {
        return it.addSuperinterface(
          ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry.class), this._visitorCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot).box(), 
            this._visitorCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot).box()));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_10 = (TypeSpec.Builder it) -> {
        return it.superclass(ClassName.get(MinimalEObjectImpl.Container.class));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_11 = (TypeSpec.Builder it) -> {
        return it.addSuperinterface(ClassName.get(this.namingUtils.classInterfacePackageName(eClass, this.packageRoot), this.namingUtils.classInterfaceClassName(eClass)));
      };
      TypeSpec.Builder _applyIfTrue = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(builder, Boolean.valueOf(eClass.isAbstract()), _function_7), Boolean.valueOf(hasSuperType), _function_8), Boolean.valueOf(isMapElement), _function_9), Boolean.valueOf((!hasSuperType)), _function_10), 
        Boolean.valueOf((!isMapElement)), _function_11);
      Iterable<FieldSpec> _plus = Iterables.<FieldSpec>concat(fieldsEAttributes, fieldsEReferences);
      TypeSpec.Builder _addFields = _applyIfTrue.addFields(_plus);
      Iterable<MethodSpec> _plus_1 = Iterables.<MethodSpec>concat(Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(eStaticClassMethod)), methodsEReferences);
      Iterable<MethodSpec> _plus_2 = Iterables.<MethodSpec>concat(_plus_1, eInverseAdd);
      Iterable<MethodSpec> _plus_3 = Iterables.<MethodSpec>concat(_plus_2, eSetMethod);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_12 = (TypeSpec.Builder it) -> {
        MethodSpec.Builder _addParameter = MethodSpec.methodBuilder("setHash").addParameter(int.class, "hash");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("this.hash = hash;");
        _builder_1.newLine();
        MethodSpec.Builder _returns = MethodSpec.methodBuilder("getHash").returns(int.class);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("if (hash == -1) {");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Object theKey = getKey();");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("hash = (theKey == null ? 0 : theKey.hashCode());");
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("return hash;");
        _builder_2.newLine();
        return it.addField(FieldSpec.builder(int.class, "hash", Modifier.PROTECTED).initializer("-1").build()).addMethod(
          _addParameter.addCode(_builder_1.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
          _returns.addCode(_builder_2.toString()).addModifiers(Modifier.PUBLIC).build());
      };
      TypeSpec.Builder _applyIfTrue_1 = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_addFields.addMethods(_plus_3), Boolean.valueOf(isMapElement), _function_12);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_13 = (TypeSpec.Builder it) -> {
        MethodSpec.Builder _returns = MethodSpec.methodBuilder("accept").addAnnotation(Override.class).addParameter(ClassName.get(this.namingUtils.visitorInterfacePackageName(this.packageRoot), this.namingUtils.visitorInterfaceClassName()), "visitor").addModifiers(Modifier.PUBLIC).returns(Object.class);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("return visitor.visit");
        String _name = eClass.getEPackage().getName();
        _builder_1.append(_name);
        _builder_1.append("__");
        String _name_1 = eClass.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(this);");
        _builder_1.newLineIfNotEmpty();
        return it.addMethod(
          _returns.addCode(_builder_1.toString()).build());
      };
      _xblockexpression = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_applyIfTrue_1, Boolean.valueOf(((!eClass.isAbstract()) && (!isMapElement))), _function_13);
    }
    return _xblockexpression;
  }
  
  public void compileEClassImplementation(final EClass eClass, final File directory) {
    try {
      MethodSpec.Builder _constructorBuilder = MethodSpec.constructorBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super();");
      _builder.newLine();
      final TypeSpec factory = this.compileEcoreRelated(TypeSpec.classBuilder(this.namingUtils.classImplementationClassName(eClass)), eClass).addModifiers(Modifier.PUBLIC).addMethod(
        _constructorBuilder.addCode(_builder.toString()).addModifiers(Modifier.PROTECTED).build()).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.classImplementationPackageName(eClass, this.packageRoot), factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getEcoreInterfacesPackage() {
    String _xblockexpression = null;
    {
      final GenModel gm = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes())).getValue();
      _xblockexpression = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
    }
    return _xblockexpression;
  }
  
  public boolean isResolveProxies(final EStructuralFeature eStructuralFeature) {
    boolean _xifexpression = false;
    if ((eStructuralFeature instanceof EReference)) {
      boolean _xblockexpression = false;
      {
        final boolean isContainer = ((EReference)eStructuralFeature).isContainer();
        final boolean isContains = ((EReference)eStructuralFeature).isContainment();
        _xblockexpression = (((!isContainer) && (!isContains)) && ((EReference)eStructuralFeature).isResolveProxies());
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  public boolean isListType(final ETypedElement eTypedElement) {
    return ((eTypedElement != null) && (eTypedElement.isMany() || ((eTypedElement instanceof EClass) && Objects.equal(((EClass) eTypedElement).getInstanceClassName(), "java.util.Map$Entry"))));
  }
}
