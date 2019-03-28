package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FactoryImplementationCompiler {
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  @Extension
  private InterpreterCompilerUtils _interpreterCompilerUtils = new InterpreterCompilerUtils(this.namingUtils);
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  public void compileFactoryImplementation(final EPackage abstractSyntax, final File directory, final String packageRoot, final boolean isTruffle) {
    try {
      final Iterable<EClass> allClasses = Iterables.<EClass>filter(abstractSyntax.getEClassifiers(), EClass.class);
      final Iterable<EEnum> allEnum = Iterables.<EEnum>filter(abstractSyntax.getEClassifiers(), EEnum.class);
      final ClassName factoryInterfaceType = ClassName.get(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.factoryInterfaceClassName(abstractSyntax));
      final ClassName packageInterfaceType = ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.packageInterfaceClassName(abstractSyntax));
      MethodSpec.Builder _addModifiers = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super();");
      _builder.newLine();
      final MethodSpec constructor = _addModifiers.addCode(_builder.toString()).build();
      final String ctn = abstractSyntax.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(ctn);
      _builder_1.append(_firstUpper);
      _builder_1.append("Factory");
      final String ctnf = _builder_1.toString();
      MethodSpec.Builder _returns = MethodSpec.methodBuilder("init").addModifiers(Modifier.STATIC, Modifier.PUBLIC).returns(factoryInterfaceType);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("try {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append(ctnf, "\t");
      _builder_2.append(" the");
      _builder_2.append(ctnf, "\t");
      _builder_2.append(" = (");
      _builder_2.append(ctnf, "\t");
      _builder_2.append(") $T.INSTANCE.getEFactory($T.eNS_URI);");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("if (the");
      _builder_2.append(ctnf, "\t");
      _builder_2.append(" != null) {");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t\t");
      _builder_2.append("return the");
      _builder_2.append(ctnf, "\t\t");
      _builder_2.append(";");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("} catch (Exception exception) {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("$T.INSTANCE.log(exception);");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("return new ");
      _builder_2.append(ctnf);
      _builder_2.append("Impl();");
      _builder_2.newLineIfNotEmpty();
      final MethodSpec initMethod = _returns.addCode(_builder_2.toString(), EPackage.Registry.class, packageInterfaceType, EcorePlugin.class).build();
      final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
        return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
      };
      MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(MethodSpec.methodBuilder("create").addAnnotation(Override.class).returns(EObject.class), Boolean.valueOf(isTruffle), _function).addParameter(ParameterSpec.builder(EClass.class, "eClass").build());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("switch (eClass.getClassifierID()) {");
      _builder_3.newLine();
      {
        final Function1<EClass, Boolean> _function_1 = (EClass it) -> {
          boolean _isAbstract = it.isAbstract();
          return Boolean.valueOf((!_isAbstract));
        };
        Iterable<EClass> _filter = IterableExtensions.<EClass>filter(allClasses, _function_1);
        for(final EClass eClass : _filter) {
          _builder_3.append("\t");
          _builder_3.append("case $pit:T.");
          String _normalizeUpperField = this.namingUtils.normalizeUpperField(eClass.getName());
          _builder_3.append(_normalizeUpperField, "\t");
          _builder_3.append(" :");
          _builder_3.newLineIfNotEmpty();
          {
            if (((eClass.getInstanceClass() != null) && Objects.equal(eClass.getInstanceClass(), Map.Entry.class))) {
              _builder_3.append("\t");
              _builder_3.append("\t");
              _builder_3.append("return ($eo:T) create");
              String _name = eClass.getName();
              _builder_3.append(_name, "\t\t");
              _builder_3.append("();");
              _builder_3.newLineIfNotEmpty();
            } else {
              _builder_3.append("\t");
              _builder_3.append("\t");
              _builder_3.append("return create");
              String _name_1 = eClass.getName();
              _builder_3.append(_name_1, "\t\t");
              _builder_3.append("();");
              _builder_3.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder_3.append("\t");
      _builder_3.append("default :");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("throw new $iae:T(\"The class \'\" + eClass.getName() + \"\' is not a valid classifier\");");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("pit", packageInterfaceType);
      Pair<String, Class<IllegalArgumentException>> _mappedTo_1 = Pair.<String, Class<IllegalArgumentException>>of("iae", IllegalArgumentException.class);
      Pair<String, Class<EObject>> _mappedTo_2 = Pair.<String, Class<EObject>>of("eo", EObject.class);
      final MethodSpec createMethod = _addParameter.addNamedCode(_builder_3.toString(), CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)).addModifiers(Modifier.PUBLIC).build();
      ClassName _get = ClassName.get(IllegalArgumentException.class);
      Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("iae", _get);
      final HashMap<String, ClassName> createFromStringMethodMap = CollectionLiterals.<String, ClassName>newHashMap(_mappedTo_3);
      for (final EEnum eEnum : allEnum) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("type");
        String _name_2 = eEnum.getName();
        _builder_4.append(_name_2);
        createFromStringMethodMap.put(_builder_4.toString(), ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), this.namingUtils.packageInterfaceClassName(abstractSyntax)));
      }
      List<MethodSpec> _xifexpression = null;
      boolean _isEmpty = IterableExtensions.isEmpty(allEnum);
      boolean _not = (!_isEmpty);
      if (_not) {
        MethodSpec.Builder _addParameter_1 = MethodSpec.methodBuilder("createFromString").addAnnotation(Override.class).returns(Object.class).addParameter(ClassName.get("org.eclipse.emf.ecore", "EDataType"), "eDataType").addParameter(String.class, "initialValue");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("switch (eDataType.getClassifierID()) {");
        _builder_5.newLine();
        {
          for(final EEnum eEnum_1 : allEnum) {
            _builder_5.append("\t");
            _builder_5.append("case $type");
            String _name_3 = eEnum_1.getName();
            _builder_5.append(_name_3, "\t");
            _builder_5.append(":T.");
            String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(eEnum_1.getName());
            _builder_5.append(_normalizeUpperField_1, "\t");
            _builder_5.append(" :");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t");
            _builder_5.append("\t");
            _builder_5.append("return create");
            String _name_4 = eEnum_1.getName();
            _builder_5.append(_name_4, "\t\t");
            _builder_5.append("FromString(eDataType, initialValue);");
            _builder_5.newLineIfNotEmpty();
          }
        }
        _builder_5.append("\t");
        _builder_5.append("default :");
        _builder_5.newLine();
        _builder_5.append("\t\t");
        _builder_5.append("throw new $iae:T(\"The datatype \'\" + eDataType.getName() + \"\' is not a valid classifier\");");
        _builder_5.newLine();
        _builder_5.append("}");
        _builder_5.newLine();
        MethodSpec _build = _addParameter_1.addNamedCode(_builder_5.toString(), createFromStringMethodMap).addModifiers(Modifier.PUBLIC).build();
        MethodSpec.Builder _addParameter_2 = MethodSpec.methodBuilder("convertToString").returns(String.class).addAnnotation(Override.class).addParameter(ClassName.get("org.eclipse.emf.ecore", "EDataType"), "eDataType").addParameter(Object.class, "instanceValue");
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("switch (eDataType.getClassifierID()) {");
        _builder_6.newLine();
        {
          for(final EEnum eEnum_2 : allEnum) {
            _builder_6.append("\t");
            _builder_6.append("case $type");
            String _name_5 = eEnum_2.getName();
            _builder_6.append(_name_5, "\t");
            _builder_6.append(":T.");
            String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(eEnum_2.getName());
            _builder_6.append(_normalizeUpperField_2, "\t");
            _builder_6.append(" :");
            _builder_6.newLineIfNotEmpty();
            _builder_6.append("\t");
            _builder_6.append("\t");
            _builder_6.append("return convert");
            String _name_6 = eEnum_2.getName();
            _builder_6.append(_name_6, "\t\t");
            _builder_6.append("ToString(eDataType, instanceValue);");
            _builder_6.newLineIfNotEmpty();
          }
        }
        _builder_6.append("\t");
        _builder_6.append("default :");
        _builder_6.newLine();
        _builder_6.append("\t\t");
        _builder_6.append("throw new $iae:T(\"The datatype \'\" + eDataType.getName() + \"\' is not a valid classifier\");");
        _builder_6.newLine();
        _builder_6.append("}");
        _builder_6.newLine();
        MethodSpec _build_1 = _addParameter_2.addNamedCode(_builder_6.toString(), createFromStringMethodMap).addModifiers(Modifier.PUBLIC).build();
        _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(_build, _build_1));
      } else {
        _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      final List<MethodSpec> createFromStringMethod = _xifexpression;
      final Function1<EEnum, List<MethodSpec>> _function_2 = (EEnum eEnum_3) -> {
        List<MethodSpec> _xblockexpression = null;
        {
          final ClassName enumType = ClassName.get(this.namingUtils.classInterfacePackageName(eEnum_3, packageRoot), this.namingUtils.classInterfaceClassName(eEnum_3));
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("create");
          String _name_7 = eEnum_3.getName();
          _builder_7.append(_name_7);
          _builder_7.append("FromString");
          MethodSpec.Builder _addParameter_3 = MethodSpec.methodBuilder(_builder_7.toString()).returns(enumType).addParameter(ClassName.get("org.eclipse.emf.ecore", "EDataType"), "eDataType").addParameter(String.class, "initialValue");
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("$1T result = $1T.get(initialValue);");
          _builder_8.newLine();
          _builder_8.append("if (result == null)");
          _builder_8.newLine();
          _builder_8.append("\t");
          _builder_8.append("throw new IllegalArgumentException(");
          _builder_8.newLine();
          _builder_8.append("\t\t\t");
          _builder_8.append("\"The value \'\" + initialValue + \"\' is not a valid enumerator of \'\" + eDataType.getName() + \"\'\");");
          _builder_8.newLine();
          _builder_8.append("return result;");
          _builder_8.newLine();
          final MethodSpec methodFrom = _addParameter_3.addCode(_builder_8.toString(), enumType).addModifiers(Modifier.PUBLIC).build();
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("convert");
          String _name_8 = eEnum_3.getName();
          _builder_9.append(_name_8);
          _builder_9.append("ToString");
          MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_9.toString()).addParameter(ClassName.get("org.eclipse.emf.ecore", "EDataType"), "eDataType").addParameter(Object.class, "instanceValue").returns(String.class);
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append("return instanceValue == null ? null : instanceValue.toString();");
          _builder_10.newLine();
          final MethodSpec methodTo = _returns_1.addCode(_builder_10.toString()).addModifiers(Modifier.PUBLIC).build();
          _xblockexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(methodFrom, methodTo));
        }
        return _xblockexpression;
      };
      final Iterable<MethodSpec> methodsFromString = Iterables.<MethodSpec>concat(IterableExtensions.<EEnum, List<MethodSpec>>map(allEnum, _function_2));
      final Function1<EClass, Boolean> _function_3 = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      final Function1<EClass, MethodSpec> _function_4 = (EClass eClass_1) -> {
        MethodSpec _xblockexpression = null;
        {
          TypeName _xifexpression_1 = null;
          if (((eClass_1.getInstanceClass() != null) && Objects.equal(eClass_1.getInstanceClass(), Map.Entry.class))) {
            ParameterizedTypeName _xblockexpression_1 = null;
            {
              final Function1<EStructuralFeature, Boolean> _function_5 = (EStructuralFeature it) -> {
                String _name_7 = it.getName();
                return Boolean.valueOf(Objects.equal(_name_7, "key"));
              };
              final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass_1.eContents(), EStructuralFeature.class), _function_5));
              final Function1<EStructuralFeature, Boolean> _function_6 = (EStructuralFeature it) -> {
                String _name_7 = it.getName();
                return Boolean.valueOf(Objects.equal(_name_7, "value"));
              };
              final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(eClass_1.eContents(), EStructuralFeature.class), _function_6));
              _xblockexpression_1 = ParameterizedTypeName.get(ClassName.get(Map.Entry.class), this._interpreterCompilerUtils.scopedInterfaceTypeRef(key.getEType(), packageRoot), 
                this._interpreterCompilerUtils.scopedInterfaceTypeRef(value.getEType(), packageRoot));
            }
            _xifexpression_1 = _xblockexpression_1;
          } else {
            _xifexpression_1 = ClassName.get(this.namingUtils.classInterfacePackageName(eClass_1, packageRoot), this.namingUtils.classInterfaceClassName(eClass_1));
          }
          final TypeName returnType = _xifexpression_1;
          final ClassName classImplType = ClassName.get(this.namingUtils.classImplementationPackageName(eClass_1, packageRoot), 
            this.namingUtils.classImplementationClassName(eClass_1));
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("create");
          String _firstUpper_1 = StringExtensions.toFirstUpper(eClass_1.getName());
          _builder_7.append(_firstUpper_1);
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_5 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _returns_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(MethodSpec.methodBuilder(_builder_7.toString()), Boolean.valueOf(isTruffle), _function_5).returns(returnType);
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("$1T ");
          String _firstLower = StringExtensions.toFirstLower(eClass_1.getName());
          _builder_8.append(_firstLower);
          _builder_8.append(" = new $1T();");
          _builder_8.newLineIfNotEmpty();
          _builder_8.append("return ");
          String _firstLower_1 = StringExtensions.toFirstLower(eClass_1.getName());
          _builder_8.append(_firstLower_1);
          _builder_8.append(";");
          _builder_8.newLineIfNotEmpty();
          _xblockexpression = _returns_1.addCode(_builder_8.toString(), classImplType).addModifiers(Modifier.PUBLIC).build();
        }
        return _xblockexpression;
      };
      final Iterable<MethodSpec> createMethods = IterableExtensions.<EClass, MethodSpec>map(IterableExtensions.<EClass>filter(allClasses, _function_3), _function_4);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("get");
      String _firstUpper_1 = StringExtensions.toFirstUpper(abstractSyntax.getName());
      _builder_7.append(_firstUpper_1);
      _builder_7.append("Package");
      MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_7.toString()).returns(packageInterfaceType);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("return ($1T) getEPackage();");
      _builder_8.newLine();
      final MethodSpec getPackageMethod = _returns_1.addCode(_builder_8.toString(), packageInterfaceType).addModifiers(Modifier.PUBLIC).build();
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("getPackage");
      MethodSpec.Builder _returns_2 = MethodSpec.methodBuilder(_builder_9.toString()).addAnnotation(Deprecated.class).returns(packageInterfaceType);
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("return $1T.eINSTANCE;");
      _builder_10.newLine();
      final MethodSpec getDeprecatedPackageMethod = _returns_2.addCode(_builder_10.toString(), packageInterfaceType).addModifiers(Modifier.PUBLIC, Modifier.STATIC).build();
      TypeSpec.Builder _addSuperinterface = TypeSpec.classBuilder(this.namingUtils.factoryImplementationClassName(abstractSyntax)).superclass(EFactoryImpl.class).addSuperinterface(factoryInterfaceType);
      Iterable<MethodSpec> _plus = Iterables.<MethodSpec>concat(Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(initMethod, constructor, createMethod)), createFromStringMethod);
      Iterable<MethodSpec> _plus_1 = Iterables.<MethodSpec>concat(_plus, createMethods);
      Iterable<MethodSpec> _plus_2 = Iterables.<MethodSpec>concat(_plus_1, methodsFromString);
      Iterable<MethodSpec> _plus_3 = Iterables.<MethodSpec>concat(_plus_2, Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getPackageMethod, getDeprecatedPackageMethod)));
      final TypeSpec factory = _addSuperinterface.addMethods(_plus_3).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.factoryImplementationPackageName(abstractSyntax, packageRoot), factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
