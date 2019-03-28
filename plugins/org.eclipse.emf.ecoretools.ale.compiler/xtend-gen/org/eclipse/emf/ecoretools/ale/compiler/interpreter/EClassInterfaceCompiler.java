package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.xtend2.lib.StringConcatenation;
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
public class EClassInterfaceCompiler {
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  @Extension
  private InterpreterCompilerUtils _interpreterCompilerUtils = new InterpreterCompilerUtils(this.namingUtils);
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  protected void _compileEClassInterface(final EEnum eEnum, final ExtendedClass aleClass, final File directory, final Dsl dsl, final String packageRoot) {
    try {
      final String selfClassName = eEnum.getName();
      final String selfPackageName = this.namingUtils.classInterfacePackageName(eEnum, packageRoot);
      final ClassName selfClass = ClassName.get(selfPackageName, selfClassName);
      final ArrayTypeName selfArrayClass = ArrayTypeName.of(selfClass);
      final ParameterizedTypeName selfListClass = ParameterizedTypeName.get(ClassName.get(List.class), selfClass);
      final Function1<EEnumLiteral, Pair<String, TypeSpec>> _function = (EEnumLiteral it) -> {
        String _name = it.getName();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("$L, $S, $S");
        TypeSpec _build = TypeSpec.anonymousClassBuilder(_builder.toString(), Integer.valueOf(it.getValue()), it.getName(), it.getLiteral()).build();
        return Pair.<String, TypeSpec>of(_name, _build);
      };
      final Function1<EEnumLiteral, FieldSpec> _function_1 = (EEnumLiteral it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _upperCase = it.getName().toUpperCase();
        _builder.append(_upperCase);
        _builder.append("_VALUE");
        FieldSpec.Builder _builder_1 = FieldSpec.builder(int.class, _builder.toString(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
        StringConcatenation _builder_2 = new StringConcatenation();
        int _value = it.getValue();
        _builder_2.append(_value);
        return _builder_1.initializer(_builder_2.toString()).build();
      };
      FieldSpec.Builder _builder = FieldSpec.builder(selfArrayClass, "VALUES_ARRAY", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("new $T { ");
      {
        EList<EEnumLiteral> _eLiterals = eEnum.getELiterals();
        boolean _hasElements = false;
        for(final EEnumLiteral lit : _eLiterals) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate(", ", "");
          }
          String _name = lit.getName();
          _builder_1.append(_name);
        }
      }
      _builder_1.append(" }");
      FieldSpec.Builder _builder_2 = FieldSpec.builder(selfListClass, "VALUES", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("$T.unmodifiableList($T.asList(VALUES_ARRAY))");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("get");
      MethodSpec.Builder _addParameter = MethodSpec.methodBuilder(_builder_4.toString()).returns(selfClass).addParameter(int.class, "value");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("switch (value) {");
      _builder_5.newLine();
      {
        EList<EEnumLiteral> _eLiterals_1 = eEnum.getELiterals();
        for(final EEnumLiteral lit_1 : _eLiterals_1) {
          _builder_5.append("\t");
          _builder_5.append("case ");
          String _name_1 = lit_1.getName();
          _builder_5.append(_name_1, "\t");
          _builder_5.append("_VALUE: return ");
          String _name_2 = lit_1.getName();
          _builder_5.append(_name_2, "\t");
          _builder_5.append(";");
          _builder_5.newLineIfNotEmpty();
        }
      }
      _builder_5.append("}");
      _builder_5.newLine();
      _builder_5.append("return null;");
      _builder_5.newLine();
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("get");
      MethodSpec.Builder _addParameter_1 = MethodSpec.methodBuilder(_builder_6.toString()).returns(selfClass).addParameter(String.class, "literal");
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("for (int i = 0; i < VALUES_ARRAY.length; ++i) {");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append("$T result = VALUES_ARRAY[i];");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append("if (result.toString().equals(literal)) {");
      _builder_7.newLine();
      _builder_7.append("\t\t");
      _builder_7.append("return result;");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append("}");
      _builder_7.newLine();
      _builder_7.append("}");
      _builder_7.newLine();
      _builder_7.append("return null;");
      _builder_7.newLine();
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("getByName");
      MethodSpec.Builder _addParameter_2 = MethodSpec.methodBuilder(_builder_8.toString()).returns(selfClass).addParameter(String.class, "name");
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("for (int i = 0; i < VALUES_ARRAY.length; ++i) {");
      _builder_9.newLine();
      _builder_9.append("\t");
      _builder_9.append("$T result = VALUES_ARRAY[i];");
      _builder_9.newLine();
      _builder_9.append("\t");
      _builder_9.append("if (result.getName().equals(name)) {");
      _builder_9.newLine();
      _builder_9.append("\t\t");
      _builder_9.append("return result;");
      _builder_9.newLine();
      _builder_9.append("\t");
      _builder_9.append("}");
      _builder_9.newLine();
      _builder_9.append("}");
      _builder_9.newLine();
      _builder_9.append("return null;");
      _builder_9.newLine();
      MethodSpec.Builder _addParameter_3 = MethodSpec.constructorBuilder().addParameter(int.class, "value").addParameter(String.class, "name").addParameter(String.class, "literal");
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("this.value = value;");
      _builder_10.newLine();
      _builder_10.append("this.name = name;");
      _builder_10.newLine();
      _builder_10.append("this.literal = literal;");
      _builder_10.newLine();
      MethodSpec.Builder _returns = MethodSpec.methodBuilder("getValue").returns(int.class);
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("return value;");
      _builder_11.newLine();
      MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder("getLiteral").returns(String.class);
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("return literal;");
      _builder_12.newLine();
      MethodSpec.Builder _returns_2 = MethodSpec.methodBuilder("getName").returns(String.class);
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append("return name;");
      _builder_13.newLine();
      MethodSpec.Builder _returns_3 = MethodSpec.methodBuilder("toString").addAnnotation(Override.class).returns(String.class);
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append("return literal;");
      _builder_14.newLine();
      final TypeSpec factory = this.addEnumConstants(TypeSpec.enumBuilder(selfClassName).addSuperinterface(ClassName.get("org.eclipse.emf.common.util", "Enumerator")), ListExtensions.<EEnumLiteral, Pair<String, TypeSpec>>map(eEnum.getELiterals(), _function)).addFields(
        ListExtensions.<EEnumLiteral, FieldSpec>map(eEnum.getELiterals(), _function_1)).addField(
        _builder.initializer(_builder_1.toString(), selfArrayClass).build()).addField(
        _builder_2.initializer(_builder_3.toString(), Collections.class, Arrays.class).build()).addMethod(
        _addParameter.addCode(_builder_5.toString(), selfClass).addModifiers(Modifier.PUBLIC, Modifier.STATIC).build()).addMethod(
        _addParameter_1.addCode(_builder_7.toString(), selfClass).addModifiers(Modifier.PUBLIC, Modifier.STATIC).build()).addMethod(
        _addParameter_2.addCode(_builder_9.toString(), selfClass).addModifiers(Modifier.PUBLIC, Modifier.STATIC).build()).addField(int.class, "value", Modifier.PRIVATE, Modifier.FINAL).addField(String.class, "name", Modifier.PRIVATE, Modifier.FINAL).addField(String.class, "literal", Modifier.PRIVATE, Modifier.FINAL).addMethod(
        _addParameter_3.addCode(_builder_10.toString()).addModifiers(Modifier.PRIVATE).build()).addMethod(
        _returns.addCode(_builder_11.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
        _returns_1.addCode(_builder_12.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
        _returns_2.addCode(_builder_13.toString()).addModifiers(Modifier.PUBLIC).build()).addMethod(
        _returns_3.addCode(_builder_14.toString()).addModifiers(Modifier.PUBLIC).build()).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(selfPackageName, factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public TypeSpec.Builder addEnumConstants(final TypeSpec.Builder seed, final List<Pair<String, TypeSpec>> constants) {
    final Function2<TypeSpec.Builder, Pair<String, TypeSpec>, TypeSpec.Builder> _function = (TypeSpec.Builder builder, Pair<String, TypeSpec> ec) -> {
      return builder.addEnumConstant(ec.getKey(), ec.getValue());
    };
    return IterableExtensions.<Pair<String, TypeSpec>, TypeSpec.Builder>fold(constants, seed, _function);
  }
  
  protected void _compileEClassInterface(final EClass eClass, final ExtendedClass aleClass, final File directory, final Dsl dsl, final String packageRoot) {
    try {
      final Function1<EAttribute, List<MethodSpec>> _function = (EAttribute field) -> {
        List<MethodSpec> _xblockexpression = null;
        {
          final TypeName fieldType = this._interpreterCompilerUtils.scopedInterfaceTypeRef(field.getEType(), packageRoot);
          final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
          List<MethodSpec> _xifexpression = null;
          if (isMultiple) {
            List<MethodSpec> _xblockexpression_1 = null;
            {
              final ParameterizedTypeName elistType = ParameterizedTypeName.get(ClassName.get(EList.class), fieldType.box());
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("get");
              String _firstUpper = StringExtensions.toFirstUpper(field.getName());
              _builder.append(_firstUpper);
              final MethodSpec getter = MethodSpec.methodBuilder(_builder.toString()).returns(elistType).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
              _xblockexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter));
            }
            _xifexpression = _xblockexpression_1;
          } else {
            List<MethodSpec> _xblockexpression_2 = null;
            {
              StringConcatenation _builder = new StringConcatenation();
              {
                String _name = field.getEType().getName();
                boolean _equals = Objects.equal(_name, "EBoolean");
                if (_equals) {
                  _builder.append("is");
                } else {
                  _builder.append("get");
                }
              }
              String _firstUpper = StringExtensions.toFirstUpper(field.getName());
              _builder.append(_firstUpper);
              final MethodSpec getter = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("set");
              String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
              _builder_1.append(_firstUpper_1);
              final MethodSpec setter = MethodSpec.methodBuilder(_builder_1.toString()).addParameter(fieldType, "value").addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
              _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, setter));
            }
            _xifexpression = _xblockexpression_2;
          }
          _xblockexpression = _xifexpression;
        }
        return _xblockexpression;
      };
      final Iterable<MethodSpec> attributesMethods = Iterables.<MethodSpec>concat(ListExtensions.<EAttribute, List<MethodSpec>>map(eClass.getEAttributes(), _function));
      final Function1<EReference, Iterable<MethodSpec>> _function_1 = (EReference field) -> {
        Iterable<MethodSpec> _xblockexpression = null;
        {
          final EClassifier ert = field.getEGenericType().getERawType();
          final TypeName rt = this._interpreterCompilerUtils.scopedInterfaceTypeRef(ert, packageRoot);
          final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
          TypeName _xifexpression = null;
          if (isMultiple) {
            ParameterizedTypeName _xifexpression_1 = null;
            if (((ert.getInstanceClass() != null) && Objects.equal(ert.getInstanceClass(), Map.Entry.class))) {
              ParameterizedTypeName _xblockexpression_1 = null;
              {
                final Function1<EStructuralFeature, Boolean> _function_2 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "key"));
                };
                final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_2));
                final Function1<EStructuralFeature, Boolean> _function_3 = (EStructuralFeature it) -> {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "value"));
                };
                final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_3));
                ParameterizedTypeName _xifexpression_2 = null;
                if (((key != null) && (value != null))) {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), this._interpreterCompilerUtils.scopedInterfaceTypeRef(key.getEType(), packageRoot), 
                    this._interpreterCompilerUtils.scopedInterfaceTypeRef(value.getEType(), packageRoot));
                } else {
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EList.class), rt);
                }
                _xblockexpression_1 = _xifexpression_2;
              }
              _xifexpression_1 = _xblockexpression_1;
            } else {
              _xifexpression_1 = ParameterizedTypeName.get(ClassName.get(EList.class), rt);
            }
            _xifexpression = _xifexpression_1;
          } else {
            _xifexpression = rt;
          }
          final TypeName fieldType = _xifexpression;
          List<MethodSpec> _xifexpression_2 = null;
          if ((!isMultiple)) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("set");
            String _firstUpper = StringExtensions.toFirstUpper(field.getName());
            _builder.append(_firstUpper);
            MethodSpec _build = MethodSpec.methodBuilder(_builder.toString()).addParameter(fieldType, "value").addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
            _xifexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(_build));
          } else {
            _xifexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
          }
          final List<MethodSpec> setter = _xifexpression_2;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("get");
          String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
          _builder_1.append(_firstUpper_1);
          MethodSpec _build_1 = MethodSpec.methodBuilder(_builder_1.toString()).returns(fieldType).addModifiers(
            Modifier.ABSTRACT, Modifier.PUBLIC).build();
          final List<MethodSpec> getter = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(_build_1));
          _xblockexpression = Iterables.<MethodSpec>concat(getter, setter);
        }
        return _xblockexpression;
      };
      final Iterable<MethodSpec> referencesMethods = Iterables.<MethodSpec>concat(ListExtensions.<EReference, Iterable<MethodSpec>>map(eClass.getEReferences(), _function_1));
      List<MethodSpec> _xifexpression = null;
      if ((aleClass != null)) {
        final Function1<Method, MethodSpec> _function_2 = (Method method) -> {
          MethodSpec _xblockexpression = null;
          {
            final Function1<EParameter, ParameterSpec> _function_3 = (EParameter param) -> {
              return ParameterSpec.builder(this._interpreterCompilerUtils.scopedInterfaceTypeRef(param.getEType(), packageRoot), param.getName()).build();
            };
            final List<ParameterSpec> params = ListExtensions.<EParameter, ParameterSpec>map(method.getOperationRef().getEParameters(), _function_3);
            MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(method.getOperationRef().getName());
            EClassifier _eType = method.getOperationRef().getEType();
            TypeName _scopedInterfaceTypeRef = null;
            if (_eType!=null) {
              _scopedInterfaceTypeRef=this._interpreterCompilerUtils.scopedInterfaceTypeRef(_eType, packageRoot);
            }
            _xblockexpression = this.returnsIfNotNull(_methodBuilder, _scopedInterfaceTypeRef).addParameters(params).addModifiers(
              Modifier.ABSTRACT, Modifier.PUBLIC).build();
          }
          return _xblockexpression;
        };
        _xifexpression = ListExtensions.<Method, MethodSpec>map(aleClass.getMethods(), _function_2);
      } else {
        _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      final List<MethodSpec> operations = _xifexpression;
      Iterable<MethodSpec> _xifexpression_1 = null;
      if ((aleClass != null)) {
        final Function1<Method, Boolean> _function_3 = (Method it) -> {
          return Boolean.valueOf((it.isDispatch() && Objects.equal(dsl.getDslProp().getOrDefault("dispatch", "false"), "true")));
        };
        final Function1<Method, MethodSpec> _function_4 = (Method it) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("getCached");
          String _firstUpper = StringExtensions.toFirstUpper(it.getOperationRef().getName());
          _builder.append(_firstUpper);
          String _classImplementationPackageName = this.namingUtils.classImplementationPackageName(eClass, packageRoot);
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name = eClass.getName();
          _builder_1.append(_name);
          _builder_1.append("DispatchWrapper");
          String _firstUpper_1 = StringExtensions.toFirstUpper(it.getOperationRef().getName());
          _builder_1.append(_firstUpper_1);
          return MethodSpec.methodBuilder(_builder.toString()).returns(ClassName.get(_classImplementationPackageName, _builder_1.toString())).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build();
        };
        _xifexpression_1 = IterableExtensions.<Method, MethodSpec>map(IterableExtensions.<Method>filter(aleClass.getMethods(), _function_3), _function_4);
      } else {
        _xifexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      final Iterable<MethodSpec> cached = _xifexpression_1;
      TypeSpec.Builder _addSuperinterface = TypeSpec.interfaceBuilder(this.namingUtils.classInterfaceClassName(eClass)).addSuperinterface(EObject.class);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_5 = (TypeSpec.Builder it) -> {
        return it.addSuperinterface(ClassName.get("com.oracle.truffle.api.nodes", "NodeInterface"));
      };
      final Function1<EClass, ClassName> _function_6 = (EClass it) -> {
        return ClassName.get(this.namingUtils.classInterfacePackageName(it, packageRoot), this.namingUtils.classInterfaceClassName(it));
      };
      TypeSpec.Builder _addSuperinterfaces = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_addSuperinterface, 
        Boolean.valueOf((Objects.equal(dsl.getDslProp().getProperty("truffle", "false"), "true") && (!IterableExtensions.<EAnnotation>exists(eClass.getEAnnotations(), ((Function1<EAnnotation, Boolean>) (EAnnotation it) -> {
          String _source = it.getSource();
          return Boolean.valueOf(Objects.equal(_source, "RuntimeData"));
        }))))), _function_5).addSuperinterfaces(ListExtensions.<EClass, ClassName>map(eClass.getESuperTypes(), _function_6));
      Iterable<MethodSpec> _plus = Iterables.<MethodSpec>concat(attributesMethods, referencesMethods);
      Iterable<MethodSpec> _plus_1 = Iterables.<MethodSpec>concat(_plus, operations);
      Iterable<MethodSpec> _plus_2 = Iterables.<MethodSpec>concat(_plus_1, cached);
      final TypeSpec factory = _addSuperinterfaces.addMethods(_plus_2).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.classInterfacePackageName(eClass, packageRoot), factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public MethodSpec.Builder returnsIfNotNull(final MethodSpec.Builder builder, final TypeName typeName) {
    MethodSpec.Builder _xifexpression = null;
    if ((typeName != null)) {
      _xifexpression = builder.returns(typeName);
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public void compileEClassInterface(final EClassifier eEnum, final ExtendedClass aleClass, final File directory, final Dsl dsl, final String packageRoot) {
    if (eEnum instanceof EEnum) {
      _compileEClassInterface((EEnum)eEnum, aleClass, directory, dsl, packageRoot);
      return;
    } else if (eEnum instanceof EClass) {
      _compileEClassInterface((EClass)eEnum, aleClass, directory, dsl, packageRoot);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eEnum, aleClass, directory, dsl, packageRoot).toString());
    }
  }
}
