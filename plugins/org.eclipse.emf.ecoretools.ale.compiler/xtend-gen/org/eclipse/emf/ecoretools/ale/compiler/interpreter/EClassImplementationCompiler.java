package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils;
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.AleBodyCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.TypeSystemUtils;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
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
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  @Extension
  private InterpreterCompilerUtils _interpreterCompilerUtils = new InterpreterCompilerUtils(this.namingUtils);
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  @Extension
  private TypeSystemUtils tsu;
  
  @Extension
  private AleBodyCompiler abc;
  
  private final EClassGetterCompiler eClassGetterCompiler = new EClassGetterCompiler(this.namingUtils);
  
  private Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private Dsl dsl;
  
  private final String packageRoot;
  
  private Set<Method> registreredDispatch = CollectionLiterals.<Method>newHashSet();
  
  private Set<String> registreredArrays = CollectionLiterals.<String>newHashSet();
  
  private final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved;
  
  public EClassImplementationCompiler(final String packageRoot, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved) {
    this.packageRoot = packageRoot;
    this.resolved = resolved;
  }
  
  private TypeSpec.Builder compileEcoreRelated(final TypeSpec.Builder builder, final EClass eClass, final ExtendedClass aleClass) {
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
          final TypeName type = this._interpreterCompilerUtils.scopedTypeRef(fet, this.packageRoot);
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
          final TypeName rt = this._interpreterCompilerUtils.scopedInterfaceTypeRef(ert, this.packageRoot);
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
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), this._interpreterCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot), this._interpreterCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot));
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
          final boolean isMutable = ((aleClass != null) && IterableExtensions.<String>exists(aleClass.getMutable(), ((Function1<String, Boolean>) (String it) -> {
            String _name = field.getName();
            return Boolean.valueOf(Objects.equal(it, _name));
          })));
          FieldSpec.Builder _builder = FieldSpec.builder(fieldType, field.getName());
          final Function1<FieldSpec.Builder, FieldSpec.Builder> _function_3 = (FieldSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child"));
          };
          _xblockexpression_1 = this._javaPoetUtils.<FieldSpec.Builder>applyIfTrue(_builder, Boolean.valueOf(((((this.dsl.getDslProp().getOrDefault("child", "false").equals("true") && (!isMultiple)) && (!isMutable)) && field.isContainment()) && (!IterableExtensions.<EAnnotation>exists(field.getEType().getEAnnotations(), ((Function1<EAnnotation, Boolean>) (EAnnotation it) -> {
            String _source = it.getSource();
            return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
          }))))), _function_3).addModifiers(Modifier.PROTECTED).build();
        }
        return _xblockexpression_1;
      };
      final Iterable<FieldSpec> fieldsEReferences = IterableExtensions.<EReference, FieldSpec>map(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_1), _function_2);
      final Function1<EStructuralFeature, List<MethodSpec>> _function_3 = (EStructuralFeature field) -> {
        List<MethodSpec> _xblockexpression_1 = null;
        {
          final EClassifier ert = field.getEGenericType().getERawType();
          final TypeName rt = this._interpreterCompilerUtils.scopedInterfaceTypeRef(ert, this.packageRoot);
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
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), this._interpreterCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot), this._interpreterCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot));
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
      String _property = this.dsl.getDslProp().getProperty("truffle", "false");
      boolean _equals = Objects.equal(_property, "true");
      final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_4 = (MethodSpec.Builder it) -> {
        return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
      };
      MethodSpec.Builder _applyIfTrue = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addModifiers, Boolean.valueOf(_equals), _function_4);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return $1T.Literals.");
      String _normalizeUpperField = this.namingUtils.normalizeUpperField(eClass.getName());
      _builder.append(_normalizeUpperField);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      final MethodSpec eStaticClassMethod = _applyIfTrue.addCode(_builder.toString(), ePackageInterfaceType).build();
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
              final TypeName tn = this._interpreterCompilerUtils.scopedTypeRef(((EAttribute)esf).getEType(), this.packageRoot).box();
              String _name = ((EAttribute)esf).getName();
              String _plus = ("fieldtype" + _name);
              namedMap.put(_plus, tn);
              final WildcardTypeName genericType = WildcardTypeName.subtypeOf(tn);
              String _name_1 = ((EAttribute)esf).getName();
              String _plus_1 = ("collection" + _name_1);
              namedMap.put(_plus_1, ParameterizedTypeName.get(ClassName.get(Collection.class), genericType));
            } else {
              EClassifier _eType = esf.getEType();
              EClassifier _eType_1 = esf.getEType();
              final ClassName tn_1 = ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eType), this.packageRoot), this.namingUtils.classInterfaceClassName(((EClass) _eType_1)));
              String _name_2 = esf.getName();
              String _plus_2 = ("fieldtype" + _name_2);
              namedMap.put(_plus_2, tn_1);
              String _name_3 = esf.getName();
              String _plus_3 = ("collection" + _name_3);
              namedMap.put(_plus_3, ParameterizedTypeName.get(ClassName.get(Collection.class), WildcardTypeName.subtypeOf(tn_1)));
            }
          }
          MethodSpec.Builder _addParameter = MethodSpec.methodBuilder("eSet").addAnnotation(Override.class).addParameter(int.class, "featureID");
          String _property_1 = this.dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_1 = Objects.equal(_property_1, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_5 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _addModifiers_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addParameter, Boolean.valueOf(_equals_1), _function_5).addParameter(Object.class, "newValue").addModifiers(Modifier.PUBLIC);
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
          String _property_2 = this.dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_2 = Objects.equal(_property_2, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_6 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _applyIfTrue_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addModifiers_2, Boolean.valueOf(_equals_2), _function_6);
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
          final MethodSpec eUnsetMethod = _applyIfTrue_1.addNamedCode(_builder_2.toString(), namedMap).build();
          MethodSpec.Builder _addParameter_1 = MethodSpec.methodBuilder("eGet").addAnnotation(Override.class).returns(Object.class).addParameter(int.class, "featureID");
          String _property_3 = this.dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_3 = Objects.equal(_property_3, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_7 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _addModifiers_3 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addParameter_1, Boolean.valueOf(_equals_3), _function_7).addParameter(boolean.class, "resolve").addParameter(boolean.class, "coreType").addModifiers(Modifier.PUBLIC);
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
                      boolean _equals_4 = Objects.equal(_name_9, "EBoolean");
                      if (_equals_4) {
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
                      boolean _equals_5 = Objects.equal(_name_10, "EBoolean");
                      if (_equals_5) {
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
                      boolean _equals_6 = Objects.equal(_name_11, "EBoolean");
                      if (_equals_6) {
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
          MethodSpec.Builder _addParameter_2 = MethodSpec.methodBuilder("eIsSet").addAnnotation(Override.class).returns(boolean.class).addParameter(int.class, "featureID");
          String _property_4 = this.dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_7 = Objects.equal(_property_4, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_8 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _addModifiers_4 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addParameter_2, Boolean.valueOf(_equals_7), _function_8).addModifiers(Modifier.PUBLIC);
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
          final Function1<EReference, Boolean> _function_9 = (EReference it) -> {
            return Boolean.valueOf((it.isContainment() || (it.getEOpposite() != null)));
          };
          boolean _isEmpty_2 = IterableExtensions.isEmpty(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_9));
          boolean _not_1 = (!_isEmpty_2);
          if (_not_1) {
            List<MethodSpec> _xblockexpression_2 = null;
            {
              ParameterizedTypeName _get_1 = ParameterizedTypeName.get(ClassName.get(InternalEList.class), WildcardTypeName.subtypeOf(Object.class));
              Pair<String, ParameterizedTypeName> _mappedTo_2 = Pair.<String, ParameterizedTypeName>of("il", _get_1);
              ClassName _get_2 = ClassName.get(this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), this.packageRoot), this.namingUtils.packageInterfaceClassName(eClass.getEPackage()));
              Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("package", _get_2);
              final HashMap<String, TypeName> eInverseRemoveCodeMap = CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_2, _mappedTo_3);
              MethodSpec.Builder _addModifiers_5 = MethodSpec.methodBuilder("eInverseRemove").addAnnotation(Override.class).returns(NotificationChain.class).addModifiers(Modifier.PUBLIC);
              String _property_5 = this.dsl.getDslProp().getProperty("truffle", "false");
              boolean _equals_8 = Objects.equal(_property_5, "true");
              final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_10 = (MethodSpec.Builder it) -> {
                return it.addAnnotation(
                  ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
              };
              MethodSpec.Builder _addParameter_3 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_addModifiers_5, Boolean.valueOf(_equals_8), _function_10).addParameter(ParameterSpec.builder(InternalEObject.class, "otherEnd").build()).addParameter(
                ParameterSpec.builder(int.class, "featureID").build()).addParameter(
                ParameterSpec.builder(NotificationChain.class, "msgs").build());
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("switch (featureID) {");
              _builder_5.newLine();
              {
                final Function1<EReference, Boolean> _function_11 = (EReference it) -> {
                  return Boolean.valueOf((it.isContainment() || (it.getEOpposite() != null)));
                };
                Iterable<EReference> _filter = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_11);
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
              final MethodSpec reteir = _addParameter_3.addNamedCode(_builder_5.toString(), eInverseRemoveCodeMap).build();
              _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(reteir));
            }
            _xifexpression_1 = _xblockexpression_2;
          } else {
            _xifexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
          }
          final List<MethodSpec> eInverseRemove = _xifexpression_1;
          final Function1<EReference, Boolean> _function_10 = (EReference field) -> {
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
          final Iterable<EReference> eBasicRemoveFromContainerFeatureFields = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_10);
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
              MethodSpec.Builder _addParameter_3 = MethodSpec.methodBuilder(_builder_6.toString()).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC).returns(NotificationChain.class).addParameter(NotificationChain.class, "msgs");
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
              MethodSpec _build = _addParameter_3.addNamedCode(_builder_7.toString(), hm).build();
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
      final Function1<EReference, Boolean> _function_5 = (EReference it) -> {
        EReference _eOpposite = it.getEOpposite();
        return Boolean.valueOf((_eOpposite != null));
      };
      boolean _isEmpty_2 = IterableExtensions.isEmpty(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_5));
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
          final Function1<EReference, Boolean> _function_6 = (EReference it) -> {
            EReference _eOpposite = it.getEOpposite();
            return Boolean.valueOf((_eOpposite != null));
          };
          Iterable<EReference> _filter = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_6);
          for (final EReference ref : _filter) {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name = ref.getName();
            _builder_1.append(_name);
            _builder_1.append("eOppositeType");
            EObject _eContainer = ref.getEOpposite().eContainer();
            EObject _eContainer_1 = ref.getEOpposite().eContainer();
            hm.put(_builder_1.toString(), ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eContainer), this.packageRoot), this.namingUtils.classInterfaceClassName(((EClass) _eContainer_1))));
          }
          MethodSpec.Builder _returns = MethodSpec.methodBuilder("eInverseAdd").addAnnotation(Override.class).returns(NotificationChain.class);
          String _property_1 = this.dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_1 = Objects.equal(_property_1, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_7 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns, Boolean.valueOf(_equals_1), _function_7).addParameter(InternalEObject.class, "otherEnd").addParameter(int.class, "featureID").addParameter(NotificationChain.class, "msgs");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("switch (featureID) {");
          _builder_2.newLine();
          {
            final Function1<EReference, Boolean> _function_8 = (EReference it) -> {
              EReference _eOpposite = it.getEOpposite();
              return Boolean.valueOf((_eOpposite != null));
            };
            Iterable<EReference> _filter_1 = IterableExtensions.<EReference>filter(eClass.getEReferences(), _function_8);
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
      final Function1<EStructuralFeature, Boolean> _function_6 = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "key"));
      };
      final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass.eContents(), EStructuralFeature.class), _function_6));
      final Function1<EStructuralFeature, Boolean> _function_7 = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "value"));
      };
      final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass.eContents(), EStructuralFeature.class), _function_7));
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_8 = (TypeSpec.Builder it) -> {
        return it.addModifiers(Modifier.ABSTRACT);
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_9 = (TypeSpec.Builder it) -> {
        return it.superclass(ClassName.get(this.namingUtils.classImplementationPackageName(superType, this.packageRoot), this.namingUtils.classImplementationClassName(superType)));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_10 = (TypeSpec.Builder it) -> {
        return it.addSuperinterface(
          ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry.class), this._interpreterCompilerUtils.scopedInterfaceTypeRef(key.getEType(), this.packageRoot), 
            this._interpreterCompilerUtils.scopedInterfaceTypeRef(value.getEType(), this.packageRoot)));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_11 = (TypeSpec.Builder it) -> {
        TypeSpec.Builder _xifexpression_2 = null;
        Object _orDefault = this.dsl.getDslProp().getOrDefault("truffle", "false");
        boolean _equals_1 = Objects.equal(_orDefault, "true");
        if (_equals_1) {
          TypeSpec.Builder _xifexpression_3 = null;
          final Function1<EAnnotation, Boolean> _function_12 = (EAnnotation it_1) -> {
            String _source = it_1.getSource();
            return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
          };
          boolean _exists = IterableExtensions.<EAnnotation>exists(eClass.getEAnnotations(), _function_12);
          boolean _not_2 = (!_exists);
          if (_not_2) {
            _xifexpression_3 = it.superclass(ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.truffle", "MinimalTruffleEObjectImpl", "TruffleContainer"));
          } else {
            _xifexpression_3 = it.superclass(ClassName.get(MinimalEObjectImpl.Container.class));
          }
          _xifexpression_2 = _xifexpression_3;
        } else {
          _xifexpression_2 = it.superclass(ClassName.get(MinimalEObjectImpl.Container.class));
        }
        return _xifexpression_2;
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_12 = (TypeSpec.Builder it) -> {
        return it.addSuperinterface(ClassName.get(this.namingUtils.classInterfacePackageName(eClass, this.packageRoot), this.namingUtils.classInterfaceClassName(eClass)));
      };
      TypeSpec.Builder _applyIfTrue_1 = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(builder, Boolean.valueOf(eClass.isAbstract()), _function_8), Boolean.valueOf(hasSuperType), _function_9), Boolean.valueOf(isMapElement), _function_10), Boolean.valueOf((!hasSuperType)), _function_11), 
        Boolean.valueOf((!isMapElement)), _function_12);
      Iterable<FieldSpec> _plus = Iterables.<FieldSpec>concat(fieldsEAttributes, fieldsEReferences);
      TypeSpec.Builder _addFields = _applyIfTrue_1.addFields(_plus);
      Iterable<MethodSpec> _plus_1 = Iterables.<MethodSpec>concat(Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(eStaticClassMethod)), methodsEReferences);
      Iterable<MethodSpec> _plus_2 = Iterables.<MethodSpec>concat(_plus_1, eInverseAdd);
      Iterable<MethodSpec> _plus_3 = Iterables.<MethodSpec>concat(_plus_2, eSetMethod);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_13 = (TypeSpec.Builder it) -> {
        MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder("setHash");
        String _property_1 = this.dsl.getDslProp().getProperty("truffle", "false");
        boolean _equals_1 = Objects.equal(_property_1, "true");
        final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_14 = (MethodSpec.Builder it_1) -> {
          return it_1.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
        };
        MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals_1), _function_14).addParameter(int.class, "hash");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("this.hash = hash;");
        _builder_1.newLine();
        MethodSpec.Builder _methodBuilder_1 = MethodSpec.methodBuilder("getHash");
        String _property_2 = this.dsl.getDslProp().getProperty("truffle", "false");
        boolean _equals_2 = Objects.equal(_property_2, "true");
        final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_15 = (MethodSpec.Builder it_1) -> {
          return it_1.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
        };
        MethodSpec.Builder _returns = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder_1, Boolean.valueOf(_equals_2), _function_15).returns(int.class);
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
      _xblockexpression = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_addFields.addMethods(_plus_3), Boolean.valueOf(isMapElement), _function_13);
    }
    return _xblockexpression;
  }
  
  protected Set<Method> _compileEClassImplementation(final EClassifier eClass, final ExtendedClass aleClass, final File directory, final Map<String, Pair<EPackage, GenModel>> syntaxes, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved, final Map<String, Class<?>> registeredServices, final Dsl dsl, final BaseValidator base) {
    return null;
  }
  
  protected Set<Method> _compileEClassImplementation(final EClass eClass, final ExtendedClass aleClass, final File directory, final Map<String, Pair<EPackage, GenModel>> syntaxes, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved, final Map<String, Class<?>> registeredServices, final Dsl dsl, final BaseValidator base) {
    try {
      Set<Method> _xblockexpression = null;
      {
        this.syntaxes = syntaxes;
        this.dsl = dsl;
        Object _orDefault = dsl.getDslProp().getOrDefault("truffle", "false");
        final boolean isTruffle = Objects.equal(_orDefault, "true");
        TypeSystemUtils _typeSystemUtils = new TypeSystemUtils(syntaxes, this.packageRoot, base, resolved);
        this.tsu = _typeSystemUtils;
        AleBodyCompiler _aleBodyCompiler = new AleBodyCompiler(syntaxes, this.packageRoot, base, resolved, this.registreredDispatch, this.registreredArrays, registeredServices, isTruffle);
        this.abc = _aleBodyCompiler;
        final String implPackage = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
        List<MethodSpec> _xifexpression = null;
        if ((aleClass != null)) {
          ArrayList<MethodSpec> _xblockexpression_1 = null;
          {
            final ArrayList<MethodSpec> ret = CollectionLiterals.<MethodSpec>newArrayList();
            EList<Method> _methods = aleClass.getMethods();
            for (final Method x : _methods) {
              MethodSpec _compile = this.compile(x, aleClass, eClass, isTruffle);
              ret.add(_compile);
            }
            _xblockexpression_1 = ret;
          }
          _xifexpression = _xblockexpression_1;
        } else {
          _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
        }
        final List<MethodSpec> aleMethods = _xifexpression;
        List<While> _xifexpression_1 = null;
        if ((aleClass != null)) {
          _xifexpression_1 = EcoreUtil2.<While>getAllContentsOfType(aleClass, While.class);
        } else {
          _xifexpression_1 = Collections.<While>unmodifiableList(CollectionLiterals.<While>newArrayList());
        }
        final List<While> whileOps = _xifexpression_1;
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function = (TypeSpec.Builder it) -> {
          return it.addMethods(aleMethods);
        };
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_1 = (TypeSpec.Builder it) -> {
          final Function1<String, FieldSpec> _function_2 = (String fieldName) -> {
            FieldSpec _xblockexpression_2 = null;
            {
              final Function1<EReference, Boolean> _function_3 = (EReference it_1) -> {
                String _name = it_1.getName();
                return Boolean.valueOf(Objects.equal(_name, fieldName));
              };
              final ClassName x = this.tsu.resolveType(IterableExtensions.<EReference>head(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function_3)).getEType());
              final ArrayTypeName xa = ArrayTypeName.of(x);
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(fieldName);
              _builder.append("Arr");
              FieldSpec.Builder _builder_1 = FieldSpec.builder(xa, _builder.toString(), Modifier.PRIVATE);
              final Function1<FieldSpec.Builder, FieldSpec.Builder> _function_4 = (FieldSpec.Builder it_1) -> {
                return it_1.addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Children"));
              };
              _xblockexpression_2 = this._javaPoetUtils.<FieldSpec.Builder>applyIfTrue(_builder_1, Boolean.valueOf((isTruffle && (!IterableExtensions.<EAnnotation>exists(eClass.getEAnnotations(), ((Function1<EAnnotation, Boolean>) (EAnnotation it_1) -> {
                String _source = it_1.getSource();
                return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
              }))))), _function_4).build();
            }
            return _xblockexpression_2;
          };
          return it.addFields(
            IterableExtensions.<String, FieldSpec>map(this.registreredArrays, _function_2));
        };
        TypeSpec.Builder _applyIfTrue = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this.compileEcoreRelated(TypeSpec.classBuilder(this.namingUtils.classImplementationClassName(eClass)), eClass, aleClass), Boolean.valueOf((aleClass != null)), _function), Boolean.valueOf(isTruffle), _function_1);
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_2 = (TypeSpec.Builder it) -> {
          return it.addAnnotation(
            AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "NodeInfo")).addMember(
              "description", "$S", eClass.getName()).build());
        };
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_3 = (TypeSpec.Builder it) -> {
          final Function1<Method, Boolean> _function_4 = (Method it_1) -> {
            return Boolean.valueOf((it_1.isDispatch() && Objects.equal(dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
          };
          final Function1<Method, FieldSpec> _function_5 = (Method it_1) -> {
            String _classImplementationPackageName = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
            StringConcatenation _builder = new StringConcatenation();
            String _name = eClass.getName();
            _builder.append(_name);
            _builder.append("DispatchWrapper");
            String _firstUpper = StringExtensions.toFirstUpper(it_1.getOperationRef().getName());
            _builder.append(_firstUpper);
            ClassName _get = ClassName.get(_classImplementationPackageName, _builder.toString());
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("cached");
            String _firstUpper_1 = StringExtensions.toFirstUpper(it_1.getOperationRef().getName());
            _builder_1.append(_firstUpper_1);
            return FieldSpec.builder(_get, _builder_1.toString()).addModifiers(Modifier.PRIVATE).addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "CompilationFinal")).build();
          };
          return it.addFields(IterableExtensions.<Method, FieldSpec>map(IterableExtensions.<Method>filter(aleClass.getMethods(), _function_4), _function_5));
        };
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_4 = (TypeSpec.Builder it) -> {
          final Function1<Method, Boolean> _function_5 = (Method it_1) -> {
            return Boolean.valueOf((it_1.isDispatch() && Objects.equal(dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
          };
          final Function1<Method, MethodSpec> _function_6 = (Method it_1) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("getCached");
            String _firstUpper = StringExtensions.toFirstUpper(it_1.getOperationRef().getName());
            _builder.append(_firstUpper);
            String _classImplementationPackageName = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name = eClass.getName();
            _builder_1.append(_name);
            _builder_1.append("DispatchWrapper");
            String _firstUpper_1 = StringExtensions.toFirstUpper(it_1.getOperationRef().getName());
            _builder_1.append(_firstUpper_1);
            MethodSpec.Builder _addModifiers = MethodSpec.methodBuilder(_builder.toString()).returns(ClassName.get(_classImplementationPackageName, _builder_1.toString())).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("return this.cached");
            String _firstUpper_2 = StringExtensions.toFirstUpper(it_1.getOperationRef().getName());
            _builder_2.append(_firstUpper_2);
            _builder_2.append(";");
            _builder_2.newLineIfNotEmpty();
            return _addModifiers.addCode(_builder_2.toString()).build();
          };
          return it.addMethods(IterableExtensions.<Method, MethodSpec>map(IterableExtensions.<Method>filter(aleClass.getMethods(), _function_5), _function_6));
        };
        final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_5 = (TypeSpec.Builder it) -> {
          final Function1<Method, FieldSpec> _function_6 = (Method method) -> {
            StringConcatenation _builder = new StringConcatenation();
            EObject _eContainer = method.eContainer();
            String _normalizeExtendedClassName = this.namingUtils.normalizeExtendedClassName(((ExtendedClass) _eContainer));
            _builder.append(_normalizeExtendedClassName);
            _builder.append("Dispatch");
            String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
            _builder.append(_firstUpper);
            ClassName _get = ClassName.get(implPackage, _builder.toString());
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("dispatch");
            EObject _eContainer_1 = method.eContainer();
            String _normalizeExtendedClassName_1 = this.namingUtils.normalizeExtendedClassName(((ExtendedClass) _eContainer_1));
            _builder_1.append(_normalizeExtendedClassName_1);
            String _firstUpper_1 = StringExtensions.toFirstUpper(method.getOperationRef().getName());
            _builder_1.append(_firstUpper_1);
            return FieldSpec.builder(_get, _builder_1.toString(), Modifier.PRIVATE).addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child")).build();
          };
          return it.addFields(
            ListExtensions.<Method, FieldSpec>map(IterableExtensions.<Method>toList(this.registreredDispatch), _function_6));
        };
        MethodSpec.Builder _constructorBuilder = MethodSpec.constructorBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("super();");
        _builder.newLine();
        {
          if ((aleClass != null)) {
            {
              final Function1<Method, Boolean> _function_6 = (Method it) -> {
                return Boolean.valueOf((it.isDispatch() && Objects.equal(dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
              };
              Iterable<Method> _filter = IterableExtensions.<Method>filter(aleClass.getMethods(), _function_6);
              for(final Method method : _filter) {
                _builder.append("this.cached");
                String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
                _builder.append(_firstUpper);
                _builder.append(" = new ");
                String _classImplementationPackageName = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
                _builder.append(_classImplementationPackageName);
                _builder.append(".");
                String _name = eClass.getName();
                _builder.append(_name);
                _builder.append("DispatchWrapper");
                String _firstUpper_1 = StringExtensions.toFirstUpper(method.getOperationRef().getName());
                _builder.append(_firstUpper_1);
                _builder.append("(this);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              for(final While w : whileOps) {
              }
            }
          }
        }
        {
          if (isTruffle) {
            {
              List<Method> _list = IterableExtensions.<Method>toList(this.registreredDispatch);
              for(final Method method_1 : _list) {
                _builder.append("this.dispatch");
                EObject _eContainer = method_1.eContainer();
                String _normalizeExtendedClassName = this.namingUtils.normalizeExtendedClassName(((ExtendedClass) _eContainer));
                _builder.append(_normalizeExtendedClassName);
                String _firstUpper_2 = StringExtensions.toFirstUpper(method_1.getOperationRef().getName());
                _builder.append(_firstUpper_2);
                _builder.append(" = ");
                _builder.append(implPackage);
                _builder.append(".");
                EObject _eContainer_1 = method_1.eContainer();
                String _normalizeExtendedClassName_1 = this.namingUtils.normalizeExtendedClassName(((ExtendedClass) _eContainer_1));
                _builder.append(_normalizeExtendedClassName_1);
                _builder.append("Dispatch");
                String _firstUpper_3 = StringExtensions.toFirstUpper(method_1.getOperationRef().getName());
                _builder.append(_firstUpper_3);
                _builder.append("NodeGen.create(); ");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        final TypeSpec factory = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_applyIfTrue, Boolean.valueOf((isTruffle && (!IterableExtensions.<EAnnotation>exists(eClass.getEAnnotations(), ((Function1<EAnnotation, Boolean>) (EAnnotation it) -> {
          String _source = it.getSource();
          return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
        }))))), _function_2), Boolean.valueOf((aleClass != null)), _function_3), Boolean.valueOf((aleClass != null)), _function_4), Boolean.valueOf(isTruffle), _function_5).addMethod(_constructorBuilder.addCode(_builder.toString()).addModifiers(Modifier.PROTECTED).build()).addModifiers(Modifier.PUBLIC).build();
        final JavaFile javaFile = JavaFile.builder(this.namingUtils.classImplementationPackageName(eClass, this.packageRoot), factory).indent("\t").build();
        javaFile.writeTo(directory);
        this.generateDispatchClasses(aleClass, directory, eClass);
        this.generateDispatchWrapperClasses(aleClass, directory, eClass);
        this.generateRootNodes(aleClass, directory, eClass);
        this.registreredArrays = CollectionLiterals.<String>newHashSet();
        _xblockexpression = this.registreredDispatch = CollectionLiterals.<Method>newHashSet();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void generateRootNodes(final ExtendedClass aleClass, final File directory, final EClass eClass) {
    if ((aleClass != null)) {
      final Function1<Method, Boolean> _function = (Method it) -> {
        return Boolean.valueOf((it.isDispatch() && Objects.equal(this.dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
      };
      final Consumer<Method> _function_1 = (Method method) -> {
        try {
          final String packageFQN = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
          StringConcatenation _builder = new StringConcatenation();
          String _name = eClass.getName();
          _builder.append(_name);
          String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder.append(_firstUpper);
          _builder.append("RootNode");
          final String rootNodeName = _builder.toString();
          final ClassName eClassInterfaceType = ClassName.get(this.namingUtils.classInterfacePackageName(eClass, this.packageRoot), this.namingUtils.classInterfaceClassName(eClass));
          final ClassName virtualFrameType = ClassName.get("com.oracle.truffle.api.frame", "VirtualFrame");
          MethodSpec.Builder _addParameter = MethodSpec.constructorBuilder().addParameter(eClassInterfaceType, "it");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("super(null);");
          _builder_1.newLine();
          _builder_1.append("this.it = it;");
          _builder_1.newLine();
          MethodSpec.Builder _mapParameters = this.mapParameters(MethodSpec.methodBuilder("execute").addAnnotation(Override.class).addParameter(virtualFrameType, "frame").returns(Object.class), method);
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            EClassifier _eType = method.getOperationRef().getEType();
            boolean _tripleNotEquals = (_eType != null);
            if (_tripleNotEquals) {
              _builder_2.append("return ");
            }
          }
          _builder_2.append("it.");
          String _name_1 = method.getOperationRef().getName();
          _builder_2.append(_name_1);
          _builder_2.append("(");
          {
            EList<EParameter> _eParameters = method.getOperationRef().getEParameters();
            boolean _hasElements = false;
            for(final EParameter p : _eParameters) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder_2.appendImmediate(", ", "");
              }
              String _name_2 = p.getName();
              _builder_2.append(_name_2);
            }
          }
          _builder_2.append(");");
          _builder_2.newLineIfNotEmpty();
          {
            EClassifier _eType_1 = method.getOperationRef().getEType();
            boolean _tripleEquals = (_eType_1 == null);
            if (_tripleEquals) {
              _builder_2.append("return null;");
            }
          }
          _builder_2.newLineIfNotEmpty();
          final TypeSpec factoryDispatch = TypeSpec.classBuilder(rootNodeName).superclass(ClassName.get("com.oracle.truffle.api.nodes", "RootNode")).addField(
            FieldSpec.builder(eClassInterfaceType, "it", Modifier.PRIVATE).addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child")).build()).addMethod(
            _addParameter.addCode(_builder_1.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
            _mapParameters.addCode(_builder_2.toString()).addModifiers(Modifier.PUBLIC).build()).addModifiers(Modifier.PUBLIC).build();
          final JavaFile javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch).indent("\t").build();
          javaFileDispatch.writeTo(directory);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      IterableExtensions.<Method>filter(aleClass.getMethods(), _function).forEach(_function_1);
    }
  }
  
  public void generateDispatchWrapperClasses(final ExtendedClass aleClass, final File directory, final EClass eClass) {
    if ((aleClass != null)) {
      final Function1<Method, Boolean> _function = (Method it) -> {
        return Boolean.valueOf((it.isDispatch() && Objects.equal(this.dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
      };
      final Consumer<Method> _function_1 = (Method method) -> {
        try {
          final String packageFQN = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
          final ClassName cyclicAssumptionType = ClassName.get("com.oracle.truffle.api.utilities", "CyclicAssumption");
          final ClassName rootCalltargetType = ClassName.get("com.oracle.truffle.api", "RootCallTarget");
          final ClassName assumptionType = ClassName.get("com.oracle.truffle.api", "Assumption");
          final ClassName truffleType = ClassName.get("com.oracle.truffle.api", "Truffle");
          StringConcatenation _builder = new StringConcatenation();
          String _name = eClass.getName();
          _builder.append(_name);
          String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder.append(_firstUpper);
          _builder.append("RootNode");
          final String rootNodeName = _builder.toString();
          final ClassName rootNodeType = ClassName.get(packageFQN, rootNodeName);
          final ClassName eClassInterfaceType = ClassName.get(this.namingUtils.classInterfacePackageName(eClass, this.packageRoot), this.namingUtils.classInterfaceClassName(eClass));
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name_1 = eClass.getName();
          _builder_1.append(_name_1);
          _builder_1.append("DispatchWrapper");
          String _firstUpper_1 = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder_1.append(_firstUpper_1);
          _builder_1.append("_");
          double _random = Math.random();
          double _multiply = (_random * 99999999);
          _builder_1.append(_multiply);
          final String name = _builder_1.toString();
          final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_2 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
            return Boolean.valueOf(eClass.getEAllSuperTypes().contains(it.eCls));
          };
          final Iterable<ALEInterpreterImplementationCompiler.ResolvedClass> s0 = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function_2);
          final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_3 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
            ExtendedClass _aleCls = it.getAleCls();
            return Boolean.valueOf((_aleCls != null));
          };
          final Iterable<ALEInterpreterImplementationCompiler.ResolvedClass> s1 = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(s0, _function_3);
          final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Iterable<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>> _function_4 = (ALEInterpreterImplementationCompiler.ResolvedClass resolved) -> {
            final Function1<Method, Boolean> _function_5 = (Method it) -> {
              return Boolean.valueOf((Objects.equal(it.getOperationRef().getName(), method.getOperationRef().getName()) && method.isDispatch()));
            };
            final Function1<Method, Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>> _function_6 = (Method it) -> {
              return Pair.<ALEInterpreterImplementationCompiler.ResolvedClass, Method>of(resolved, it);
            };
            return IterableExtensions.<Method, Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>map(IterableExtensions.<Method>filter(this.tsu.allMethods(resolved.getAleCls()), _function_5), _function_6);
          };
          final Iterable<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>> s2 = Iterables.<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>concat(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass, Iterable<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>>map(s1, _function_4));
          final Function1<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>, Boolean> _function_5 = (Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method> x) -> {
            return Boolean.valueOf(x.getValue().isDispatch());
          };
          final Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method> overridenMethods = IterableExtensions.<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>head(IterableExtensions.<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>sortWith(IterableExtensions.<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>filter(s2, _function_5), new Comparator<Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method>>() {
            @Override
            public int compare(final Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method> arg0, final Pair<ALEInterpreterImplementationCompiler.ResolvedClass, Method> arg1) {
              int _xifexpression = (int) 0;
              if ((arg0.getKey().eCls instanceof EClass)) {
                int _xblockexpression = (int) 0;
                {
                  final EClass eCls = ((EClass) arg0.getKey().eCls);
                  int _xifexpression_1 = (int) 0;
                  boolean _contains = eCls.getEAllSuperTypes().contains(arg1.getKey().eCls);
                  if (_contains) {
                    _xifexpression_1 = (-1);
                  } else {
                    _xifexpression_1 = 1;
                  }
                  _xblockexpression = _xifexpression_1;
                }
                _xifexpression = _xblockexpression;
              } else {
                _xifexpression = 0;
              }
              return _xifexpression;
            }
          }));
          final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_6 = (TypeSpec.Builder it) -> {
            return it.superclass(ClassName.get(packageFQN, this.namingUtils.dispatchWrapperClassName(((EClass) overridenMethods.getKey().eCls), overridenMethods.getValue())));
          };
          MethodSpec.Builder _addParameter = MethodSpec.constructorBuilder().addParameter(eClassInterfaceType, "it");
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            if ((overridenMethods != null)) {
              _builder_2.append("super(it);");
            }
          }
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("this.callTargetStable = new $T($S);");
          _builder_2.newLine();
          _builder_2.append("this.callTarget = $T.getRuntime().createCallTarget(new $T(it));");
          _builder_2.newLine();
          MethodSpec.Builder _returns = MethodSpec.methodBuilder("getCallTarget").returns(rootCalltargetType);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("return callTarget;");
          MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder("getCallTargetStable").returns(assumptionType);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("return callTargetStable.getAssumption();");
          final TypeSpec factoryDispatch = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(TypeSpec.classBuilder(this.namingUtils.dispatchWrapperClassName(eClass, method)), Boolean.valueOf((overridenMethods != null)), _function_6).addField(ClassName.get("com.oracle.truffle.api", "RootCallTarget"), "callTarget", Modifier.PRIVATE).addField(cyclicAssumptionType, "callTargetStable", Modifier.PRIVATE, Modifier.FINAL).addMethod(
            _addParameter.addCode(_builder_2.toString(), cyclicAssumptionType, name, truffleType, rootNodeType).addModifiers(Modifier.PROTECTED).build()).addMethod(
            _returns.addCode(_builder_3.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
            _returns_1.addCode(_builder_4.toString()).addModifiers(Modifier.PUBLIC).build()).addModifiers(Modifier.PUBLIC).build();
          final JavaFile javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch).indent("\t").build();
          javaFileDispatch.writeTo(directory);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      IterableExtensions.<Method>filter(aleClass.getMethods(), _function).forEach(_function_1);
    }
  }
  
  public void generateDispatchClasses(final ExtendedClass aleClass, final File directory, final EClass eClass) {
    if ((aleClass != null)) {
      final Function1<Method, Boolean> _function = (Method it) -> {
        return Boolean.valueOf((it.isDispatch() && Objects.equal(this.dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
      };
      final Consumer<Method> _function_1 = (Method method) -> {
        try {
          final ClassName specializationType = ClassName.get("com.oracle.truffle.api.dsl", "Specialization");
          final ClassName cachedType = ClassName.get("com.oracle.truffle.api.dsl", "Cached");
          StringConcatenation _builder = new StringConcatenation();
          String _name = eClass.getName();
          _builder.append(_name);
          _builder.append("Dispatch");
          String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder.append(_firstUpper);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("executeDispatch");
          String _classImplementationPackageName = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
          StringConcatenation _builder_2 = new StringConcatenation();
          String _name_1 = eClass.getName();
          _builder_2.append(_name_1);
          _builder_2.append("DispatchWrapper");
          String _firstUpper_1 = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder_2.append(_firstUpper_1);
          String _classImplementationPackageName_1 = this.namingUtils.classImplementationPackageName(eClass, this.packageRoot);
          StringConcatenation _builder_3 = new StringConcatenation();
          String _name_2 = eClass.getName();
          _builder_3.append(_name_2);
          _builder_3.append("DispatchWrapper");
          String _firstUpper_2 = StringExtensions.toFirstUpper(method.getOperationRef().getName());
          _builder_3.append(_firstUpper_2);
          MethodSpec.Builder _addParameter = MethodSpec.methodBuilder("doIndirect").addAnnotation(
            AnnotationSpec.builder(specializationType).addMember("replaces", "\"doDirect\"").build()).addParameter(
            ParameterSpec.builder(ClassName.get(_classImplementationPackageName_1, _builder_3.toString()), "function").build()).addParameter(Object[].class, "arguments").addParameter(
            ParameterSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "IndirectCallNode"), "callNode").addAnnotation(AnnotationSpec.builder(cachedType).addMember("value", "\"create()\"").build()).build());
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("return callNode.call(function.getCallTarget(), arguments);");
          final TypeSpec factoryDispatch = TypeSpec.classBuilder(_builder.toString()).superclass(
            ClassName.get("com.oracle.truffle.api.nodes", "Node")).addField(
            FieldSpec.builder(int.class, "INLINE_CACHE_SIZE", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).initializer("3").build()).addMethod(
            MethodSpec.methodBuilder(_builder_1.toString()).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).addParameter(Object.class, "function").addParameter(Object[].class, "arguments").returns(Object.class).build()).addMethod(
            MethodSpec.methodBuilder("doDirect").addAnnotation(
              AnnotationSpec.builder(specializationType).addMember("limit", "\"INLINE_CACHE_SIZE\"").addMember("guards", 
                "\"function.getCallTarget() == cachedTarget\"").addMember("assumptions", "\"callTargetStable\"").build()).addModifiers(Modifier.PROTECTED, Modifier.STATIC).returns(Object.class).addParameter(
              ParameterSpec.builder(ClassName.get(_classImplementationPackageName, _builder_2.toString()), "function").build()).addParameter(Object[].class, "arguments").addParameter(
              ParameterSpec.builder(ClassName.get("com.oracle.truffle.api", "Assumption"), 
                "callTargetStable").addAnnotation(
                AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.dsl", "Cached")).addMember("value", "\"function.getCallTargetStable()\"").build()).build()).addParameter(
              ParameterSpec.builder(ClassName.get("com.oracle.truffle.api", "RootCallTarget"), 
                "cachedTarget").addAnnotation(
                AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.dsl", "Cached")).addMember("value", "\"function.getCallTarget()\"").build()).build()).addParameter(
              ParameterSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "DirectCallNode"), 
                "callNode").addAnnotation(
                AnnotationSpec.builder(cachedType).addMember("value", "\"create(cachedTarget)\"").build()).build()).addCode("return callNode.call(arguments);").build()).addMethod(
            _addParameter.addCode(_builder_4.toString()).returns(Object.class).addModifiers(Modifier.PROTECTED, Modifier.STATIC).build()).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build();
          final JavaFile javaFileDispatch = JavaFile.builder(this.namingUtils.classImplementationPackageName(eClass, this.packageRoot), factoryDispatch).indent("\t").build();
          javaFileDispatch.writeTo(directory);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      IterableExtensions.<Method>filter(aleClass.getMethods(), _function).forEach(_function_1);
    }
  }
  
  public MethodSpec compile(final Method method, final ExtendedClass aleClass, final EClass aClass, final boolean isTruffle) {
    MethodSpec _xblockexpression = null;
    {
      EClassifier _eType = method.getOperationRef().getEType();
      TypeName _resolveType2 = null;
      if (_eType!=null) {
        _resolveType2=this.tsu.resolveType2(_eType);
      }
      final TypeName retType = _resolveType2;
      final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
        return it.returns(retType);
      };
      final Function1<EAnnotation, Boolean> _function_1 = (EAnnotation it) -> {
        String _source = it.getSource();
        return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
      };
      final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_2 = (MethodSpec.Builder it) -> {
        return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
      };
      final Function1<EParameter, ParameterSpec> _function_3 = (EParameter it) -> {
        ParameterSpec _xifexpression = null;
        Class<?> _instanceClass = it.getEType().getInstanceClass();
        boolean _tripleNotEquals = (_instanceClass != null);
        if (_tripleNotEquals) {
          ParameterSpec _xifexpression_1 = null;
          if (((it.getEType() instanceof EClass) && (!Objects.equal(it.getEType().getEPackage(), EcorePackage.eINSTANCE)))) {
            EClassifier _eType_1 = it.getEType();
            EClassifier _eType_2 = it.getEType();
            _xifexpression_1 = ParameterSpec.builder(
              ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eType_1), this.packageRoot), ((EClass) _eType_2).getName()), 
              it.getName()).build();
          } else {
            _xifexpression_1 = ParameterSpec.builder(it.getEType().getInstanceClass(), it.getName()).build();
          }
          _xifexpression = _xifexpression_1;
        } else {
          _xifexpression = ParameterSpec.builder(this.tsu.resolveType(it.getEType()), it.getName()).build();
        }
        return _xifexpression;
      };
      MethodSpec.Builder _openMethod = this.openMethod(this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(MethodSpec.methodBuilder(method.getOperationRef().getName()).addModifiers(Modifier.PUBLIC), Boolean.valueOf((retType != null)), _function), Boolean.valueOf(IterableExtensions.<EAnnotation>exists(aClass.getEAnnotations(), _function_1)), _function_2).addParameters(ListExtensions.<EParameter, ParameterSpec>map(method.getOperationRef().getEParameters(), _function_3)), method.getOperationRef().getEType());
      Block _body = method.getBody();
      EClassImplementationCompiler.CompilerExpressionCtx _compilerExpressionCtx = new EClassImplementationCompiler.CompilerExpressionCtx("this", aleClass, aClass);
      _xblockexpression = this.closeMethod(this.compileBodyAndPrefix(_openMethod, _body, _compilerExpressionCtx, isTruffle), method.getOperationRef().getEType()).build();
    }
    return _xblockexpression;
  }
  
  public MethodSpec.Builder compileBodyAndPrefix(final MethodSpec.Builder builder, final Statement body, final EClassImplementationCompiler.CompilerExpressionCtx ctx, final boolean isTruffle) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final CodeBlock.Builder cbb = this.abc.compileBody(CodeBlock.builder(), body, ctx);
      MethodSpec.Builder _xifexpression = null;
      if (isTruffle) {
        final Function2<MethodSpec.Builder, String, MethodSpec.Builder> _function = (MethodSpec.Builder b, String array) -> {
          MethodSpec.Builder _xblockexpression_1 = null;
          {
            final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, array));
            };
            final ClassName x = this.tsu.resolveType(IterableExtensions.<EReference>head(IterableExtensions.<EReference>filter(ctx.eClass.getEAllReferences(), _function_1)).getEType());
            CodeBlock.Builder _builder = CodeBlock.builder();
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("if (this.");
            _builder_1.append(array);
            _builder_1.append("Arr == null) {");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("$cd:T.transferToInterpreterAndInvalidate();");
            _builder_1.newLine();
            _builder_1.append("\t");
            _builder_1.append("if (this.");
            _builder_1.append(array, "\t");
            _builder_1.append(" != null) this.");
            _builder_1.append(array, "\t");
            _builder_1.append("Arr = this.");
            _builder_1.append(array, "\t");
            _builder_1.append(".toArray(new ");
            _builder_1.append(x, "\t");
            _builder_1.append("[0]);");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("else this.");
            _builder_1.append(array, "\t");
            _builder_1.append("Arr = new ");
            _builder_1.append(x, "\t");
            _builder_1.append("[] {};");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.newLine();
            _builder_1.append("}");
            _builder_1.newLine();
            ClassName _get = ClassName.get("com.oracle.truffle.api", "CompilerDirectives");
            Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("cd", _get);
            _xblockexpression_1 = b.addStatement(_builder.addNamed(_builder_1.toString(), CollectionLiterals.<String, ClassName>newHashMap(_mappedTo)).build());
          }
          return _xblockexpression_1;
        };
        _xifexpression = IterableExtensions.<String, MethodSpec.Builder>fold(this.registreredArrays, builder, _function).addStatement(cbb.build());
      } else {
        _xifexpression = builder.addCode(cbb.build());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public MethodSpec.Builder closeMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      _xifexpression = builder.addStatement("return result");
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public MethodSpec.Builder openMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("$T result");
      _xifexpression = builder.addStatement(_builder.toString(), this.tsu.resolveType2(type));
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public MethodSpec.Builder mapParameters(final MethodSpec.Builder builderSeed, final Method method) {
    MethodSpec.Builder builder = builderSeed;
    for (int i = 0; (i < method.getOperationRef().getEParameters().size()); i = (i + 1)) {
      {
        final EParameter parameter = method.getOperationRef().getEParameters().get(i);
        ClassName _xifexpression = null;
        Class<?> _instanceClass = parameter.getEType().getInstanceClass();
        boolean _tripleNotEquals = (_instanceClass != null);
        if (_tripleNotEquals) {
          ClassName _xifexpression_1 = null;
          if (((parameter.getEType() instanceof EClass) && (!Objects.equal(parameter.getEType().getEPackage(), EcorePackage.eINSTANCE)))) {
            EClassifier _eType = parameter.getEType();
            EClassifier _eType_1 = parameter.getEType();
            _xifexpression_1 = ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eType), this.packageRoot), 
              ((EClass) _eType_1).getName());
          } else {
            _xifexpression_1 = ClassName.get(parameter.getEType().getInstanceClass());
          }
          _xifexpression = _xifexpression_1;
        } else {
          _xifexpression = this.tsu.resolveType(parameter.getEType());
        }
        final ClassName type = _xifexpression;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(type);
        _builder.append(" ");
        String _name = parameter.getName();
        _builder.append(_name);
        _builder.append(" = (");
        _builder.append(type);
        _builder.append(") frame.getArguments()[");
        _builder.append(i);
        _builder.append("]");
        builder = builder.addStatement(_builder.toString());
      }
    }
    return builder;
  }
  
  public String getEcoreInterfacesPackage() {
    String _xblockexpression = null;
    {
      final GenModel gm = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes())).getValue();
      _xblockexpression = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
    }
    return _xblockexpression;
  }
  
  public MethodSpec.Builder returnType(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      MethodSpec.Builder _xifexpression_1 = null;
      Class<?> _instanceClass = type.getInstanceClass();
      boolean _tripleNotEquals = (_instanceClass != null);
      if (_tripleNotEquals) {
        _xifexpression_1 = builder.returns(type.getInstanceClass());
      } else {
        _xifexpression_1 = builder.returns(this.tsu.resolveType(type));
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
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
  
  public Set<Method> compileEClassImplementation(final EClassifier eClass, final ExtendedClass aleClass, final File directory, final Map<String, Pair<EPackage, GenModel>> syntaxes, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved, final Map<String, Class<?>> registeredServices, final Dsl dsl, final BaseValidator base) {
    if (eClass instanceof EClass) {
      return _compileEClassImplementation((EClass)eClass, aleClass, directory, syntaxes, resolved, registeredServices, dsl, base);
    } else if (eClass != null) {
      return _compileEClassImplementation(eClass, aleClass, directory, syntaxes, resolved, registeredServices, dsl, base);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass, aleClass, directory, syntaxes, resolved, registeredServices, dsl, base).toString());
    }
  }
}
