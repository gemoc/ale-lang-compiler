package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PackageInterfaceCompiler {
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  public void compilePackageInterface(final EPackage abstractSyntax, final File directory, final String packageRoot) {
    try {
      final Iterable<EClass> allClasses = Iterables.<EClass>filter(abstractSyntax.getEClassifiers(), EClass.class);
      final Iterable<EEnum> allEnums = Iterables.<EEnum>filter(abstractSyntax.getEClassifiers(), EEnum.class);
      final ClassName packageInterfaceType = ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.packageInterfaceClassName(abstractSyntax));
      final ClassName packageImplementationType = ClassName.get(this.namingUtils.packageImplementationPackageName(abstractSyntax, packageRoot), 
        this.namingUtils.packageImplementationClassName(abstractSyntax));
      final ClassName factoryInterfaceType = ClassName.get(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.factoryInterfaceClassName(abstractSyntax));
      FieldSpec.Builder _builder = FieldSpec.builder(packageInterfaceType, "eINSTANCE");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("$T.init()");
      final FieldSpec eInstanceField = _builder.initializer(_builder_1.toString(), packageImplementationType).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build();
      FieldSpec.Builder _builder_2 = FieldSpec.builder(String.class, "eNS_URI");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("http://");
      String _name = abstractSyntax.getName();
      _builder_3.append(_name);
      _builder_3.append(".");
      String _name_1 = abstractSyntax.getName();
      _builder_3.append(_name_1);
      _builder_3.append(".");
      String _name_2 = abstractSyntax.getName();
      _builder_3.append(_name_2);
      _builder_3.append("/");
      final FieldSpec eNSURIField = _builder_2.initializer("$S", _builder_3).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build();
      final FieldSpec eNameField = FieldSpec.builder(String.class, "eNAME").initializer("$S", abstractSyntax.getName()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build();
      final FieldSpec eNSPrefixField = FieldSpec.builder(String.class, "eNS_PREFIX").initializer("$S", abstractSyntax.getName()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build();
      final HashMap<EClassifier, FieldSpec> classFields = CollectionLiterals.<EClassifier, FieldSpec>newHashMap();
      int cptr = 0;
      for (final EClass clazz : allClasses) {
        {
          FieldSpec.Builder _builder_4 = FieldSpec.builder(int.class, this.namingUtils.normalizeUpperField(clazz.getName()));
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(cptr);
          classFields.put(clazz, 
            _builder_4.initializer(_builder_5.toString()).addModifiers(Modifier.STATIC, 
              Modifier.PUBLIC, Modifier.FINAL).build());
          cptr = (cptr + 1);
        }
      }
      for (final EEnum eEnum : allEnums) {
        {
          FieldSpec.Builder _builder_4 = FieldSpec.builder(int.class, this.namingUtils.normalizeUpperField(eEnum.getName()));
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(cptr);
          classFields.put(eEnum, 
            _builder_4.initializer(_builder_5.toString()).addModifiers(
              Modifier.STATIC, Modifier.PUBLIC, Modifier.FINAL).build());
          cptr = (cptr + 1);
        }
      }
      final HashMap<EClassifier, FieldSpec> classFieldsLiterals = CollectionLiterals.<EClassifier, FieldSpec>newHashMap();
      final HashMap<EClassifier, HashMap<ENamedElement, FieldSpec>> classStructuralFeaturesLiterals = CollectionLiterals.<EClassifier, HashMap<ENamedElement, FieldSpec>>newHashMap();
      for (final EClass clazz_1 : allClasses) {
        {
          FieldSpec.Builder _builder_4 = FieldSpec.builder(EClass.class, this.namingUtils.normalizeUpperField(clazz_1.getName()));
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("eINSTANCE.get");
          String _firstUpper = StringExtensions.toFirstUpper(clazz_1.getName());
          _builder_5.append(_firstUpper);
          _builder_5.append("()");
          classFieldsLiterals.put(clazz_1, _builder_4.initializer(_builder_5.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
          boolean _containsKey = classStructuralFeaturesLiterals.containsKey(clazz_1);
          boolean _not = (!_containsKey);
          if (_not) {
            classStructuralFeaturesLiterals.put(clazz_1, CollectionLiterals.<ENamedElement, FieldSpec>newHashMap());
          }
          EList<EReference> _eReferences = clazz_1.getEReferences();
          for (final EReference field : _eReferences) {
            FieldSpec.Builder _builder_6 = FieldSpec.builder(EReference.class, this.namingUtils.normalizeUpperField(field.getName(), clazz_1.getName()));
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("eINSTANCE.get");
            String _name_3 = clazz_1.getName();
            _builder_7.append(_name_3);
            _builder_7.append("_");
            String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
            _builder_7.append(_firstUpper_1);
            _builder_7.append("()");
            classStructuralFeaturesLiterals.get(clazz_1).put(field, _builder_6.initializer(_builder_7.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
          }
          EList<EAttribute> _eAllAttributes = clazz_1.getEAllAttributes();
          for (final EAttribute field_1 : _eAllAttributes) {
            FieldSpec.Builder _builder_8 = FieldSpec.builder(EAttribute.class, this.namingUtils.normalizeUpperField(field_1.getName(), clazz_1.getName()));
            StringConcatenation _builder_9 = new StringConcatenation();
            _builder_9.append("eINSTANCE.get");
            String _name_4 = clazz_1.getName();
            _builder_9.append(_name_4);
            _builder_9.append("_");
            String _firstUpper_2 = StringExtensions.toFirstUpper(field_1.getName());
            _builder_9.append(_firstUpper_2);
            _builder_9.append("()");
            classStructuralFeaturesLiterals.get(clazz_1).put(field_1, _builder_8.initializer(_builder_9.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
          }
        }
      }
      for (final EEnum eEnum_1 : allEnums) {
        FieldSpec.Builder _builder_4 = FieldSpec.builder(EEnum.class, eEnum_1.getName().toUpperCase());
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("eINSTANCE.get");
        String _firstUpper = StringExtensions.toFirstUpper(eEnum_1.getName());
        _builder_5.append(_firstUpper);
        _builder_5.append("()");
        classFieldsLiterals.put(eEnum_1, _builder_4.initializer(_builder_5.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
      }
      TypeSpec.Builder tmpliteralType = TypeSpec.interfaceBuilder("Literals");
      EList<EClassifier> _eClassifiers = abstractSyntax.getEClassifiers();
      for (final EClassifier clazz_2 : _eClassifiers) {
        if ((clazz_2 instanceof EClass)) {
          tmpliteralType = tmpliteralType.addField(classFieldsLiterals.get(clazz_2));
          EList<EStructuralFeature> _eStructuralFeatures = ((EClass)clazz_2).getEStructuralFeatures();
          for (final EStructuralFeature esf : _eStructuralFeatures) {
            tmpliteralType = tmpliteralType.addField(classStructuralFeaturesLiterals.get(clazz_2).get(esf));
          }
        } else {
          if ((clazz_2 instanceof EEnum)) {
            tmpliteralType = tmpliteralType.addField(classFieldsLiterals.get(clazz_2));
          }
        }
      }
      final TypeSpec literalType = tmpliteralType.addModifiers(Modifier.PUBLIC, Modifier.STATIC).build();
      final HashMap<EClassifier, MethodSpec> getterFields = CollectionLiterals.<EClassifier, MethodSpec>newHashMap();
      final HashMap<EClass, HashMap<EStructuralFeature, MethodSpec>> getterReferencesFields = CollectionLiterals.<EClass, HashMap<EStructuralFeature, MethodSpec>>newHashMap();
      for (final EClass clazz_3 : allClasses) {
        {
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("get");
          String _firstUpper_1 = StringExtensions.toFirstUpper(clazz_3.getName());
          _builder_6.append(_firstUpper_1);
          getterFields.put(clazz_3, MethodSpec.methodBuilder(_builder_6.toString()).returns(EClass.class).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
          boolean _containsKey = getterReferencesFields.containsKey(clazz_3);
          boolean _not = (!_containsKey);
          if (_not) {
            getterReferencesFields.put(clazz_3, CollectionLiterals.<EStructuralFeature, MethodSpec>newHashMap());
          }
          EList<EReference> _eReferences = clazz_3.getEReferences();
          for (final EReference field : _eReferences) {
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("get");
            String _name_3 = clazz_3.getName();
            _builder_7.append(_name_3);
            _builder_7.append("_");
            String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
            _builder_7.append(_firstUpper_2);
            getterReferencesFields.get(clazz_3).put(field, MethodSpec.methodBuilder(_builder_7.toString()).returns(EReference.class).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
          }
          EList<EAttribute> _eAttributes = clazz_3.getEAttributes();
          for (final EAttribute field_1 : _eAttributes) {
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append("get");
            String _name_4 = clazz_3.getName();
            _builder_8.append(_name_4);
            _builder_8.append("_");
            String _firstUpper_3 = StringExtensions.toFirstUpper(field_1.getName());
            _builder_8.append(_firstUpper_3);
            getterReferencesFields.get(clazz_3).put(field_1, MethodSpec.methodBuilder(_builder_8.toString()).returns(EAttribute.class).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
          }
        }
      }
      for (final EEnum eEnum_2 : allEnums) {
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(eEnum_2.getName());
        _builder_6.append(_firstUpper_1);
        getterFields.put(eEnum_2, 
          MethodSpec.methodBuilder(_builder_6.toString()).returns(EEnum.class).addModifiers(Modifier.ABSTRACT, 
            Modifier.PUBLIC).build());
      }
      final HashMap<EClass, ArrayList<FieldSpec>> fieldsAttributesFields = CollectionLiterals.<EClass, ArrayList<FieldSpec>>newHashMap();
      for (final EClass clazz_4 : allClasses) {
        {
          boolean _containsKey = fieldsAttributesFields.containsKey(clazz_4);
          boolean _not = (!_containsKey);
          if (_not) {
            fieldsAttributesFields.put(clazz_4, CollectionLiterals.<FieldSpec>newArrayList());
          }
          int cptrI = 0;
          final int offset = this.countOffset(clazz_4);
          EList<EStructuralFeature> _eAllStructuralFeatures = clazz_4.getEAllStructuralFeatures();
          for (final EStructuralFeature esf_1 : _eAllStructuralFeatures) {
            EClass _eContainingClass = esf_1.getEContainingClass();
            boolean _tripleEquals = (_eContainingClass == clazz_4);
            if (_tripleEquals) {
              FieldSpec.Builder _builder_7 = FieldSpec.builder(int.class, this.namingUtils.normalizeUpperField(esf_1.getName(), clazz_4.getName()));
              StringConcatenation _builder_8 = new StringConcatenation();
              _builder_8.append((cptrI + offset));
              fieldsAttributesFields.get(clazz_4).add(_builder_7.initializer(_builder_8.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
              cptrI = (cptrI + 1);
            } else {
              FieldSpec.Builder _builder_9 = FieldSpec.builder(int.class, this.namingUtils.normalizeUpperField(esf_1.getName(), clazz_4.getName()));
              StringConcatenation _builder_10 = new StringConcatenation();
              String _normalizeUpperField = this.namingUtils.normalizeUpperField(esf_1.getName(), esf_1.getEContainingClass().getName());
              _builder_10.append(_normalizeUpperField);
              fieldsAttributesFields.get(clazz_4).add(_builder_9.initializer(_builder_10.toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build());
            }
          }
        }
      }
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("get");
      String _firstUpper_2 = StringExtensions.toFirstUpper(abstractSyntax.getName());
      _builder_7.append(_firstUpper_2);
      _builder_7.append("Factory");
      final MethodSpec getFactoryMethod = MethodSpec.methodBuilder(_builder_7.toString()).returns(factoryInterfaceType).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build();
      TypeSpec.Builder packageTmp = TypeSpec.interfaceBuilder(this.namingUtils.packageInterfaceClassName(abstractSyntax)).addSuperinterface(EPackage.class).addField(eNameField).addField(eNSURIField).addField(eNSPrefixField).addField(eInstanceField);
      EList<EClassifier> _eClassifiers_1 = abstractSyntax.getEClassifiers();
      for (final EClassifier eClassifier : _eClassifiers_1) {
        {
          boolean _containsKey = classFields.containsKey(eClassifier);
          if (_containsKey) {
            packageTmp = packageTmp.addField(classFields.get(eClassifier));
          }
          boolean _containsKey_1 = fieldsAttributesFields.containsKey(eClassifier);
          if (_containsKey_1) {
            packageTmp = packageTmp.addFields(fieldsAttributesFields.get(eClassifier));
          }
          if ((eClassifier instanceof EClass)) {
            StringConcatenation _builder_8 = new StringConcatenation();
            String _normalizeUpperField = this.namingUtils.normalizeUpperField(((EClass)eClassifier).getName());
            _builder_8.append(_normalizeUpperField);
            _builder_8.append("_FEATURE_COUNT");
            FieldSpec.Builder _builder_9 = FieldSpec.builder(int.class, _builder_8.toString(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
            StringConcatenation _builder_10 = new StringConcatenation();
            {
              EList<EClass> _eSuperTypes = ((EClass)eClassifier).getESuperTypes();
              for(final EClass parentClazz : _eSuperTypes) {
                String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(parentClazz.getName());
                _builder_10.append(_normalizeUpperField_1);
                _builder_10.append("_FEATURE_COUNT + ");
              }
            }
            int _size = ((EClass)eClassifier).getEStructuralFeatures().size();
            _builder_10.append(_size);
            packageTmp = packageTmp.addField(_builder_9.initializer(_builder_10.toString()).build());
            StringConcatenation _builder_11 = new StringConcatenation();
            String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(((EClass)eClassifier).getName());
            _builder_11.append(_normalizeUpperField_2);
            _builder_11.append("_OPERATION_COUNT");
            FieldSpec.Builder _builder_12 = FieldSpec.builder(int.class, _builder_11.toString(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
            StringConcatenation _builder_13 = new StringConcatenation();
            {
              EList<EClass> _eSuperTypes_1 = ((EClass)eClassifier).getESuperTypes();
              for(final EClass parentClazz_1 : _eSuperTypes_1) {
                String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(parentClazz_1.getName());
                _builder_13.append(_normalizeUpperField_3);
                _builder_13.append("_OPERATION_COUNT + ");
              }
            }
            _builder_13.append("0");
            packageTmp = packageTmp.addField(_builder_12.initializer(_builder_13.toString()).build());
          }
        }
      }
      EList<EClassifier> _eClassifiers_2 = abstractSyntax.getEClassifiers();
      for (final EClassifier eClassifier_1 : _eClassifiers_2) {
        {
          packageTmp = packageTmp.addMethod(getterFields.get(eClassifier_1));
          if ((eClassifier_1 instanceof EClass)) {
            EList<EStructuralFeature> _eStructuralFeatures_1 = ((EClass)eClassifier_1).getEStructuralFeatures();
            for (final EStructuralFeature esf_1 : _eStructuralFeatures_1) {
              packageTmp = packageTmp.addMethod(getterReferencesFields.get(eClassifier_1).get(esf_1));
            }
          }
        }
      }
      final TypeSpec package_ = packageTmp.addMethod(getFactoryMethod).addType(literalType).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), package_).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int countOffset(final EClass clazz) {
    final Function1<EClass, Integer> _function = (EClass it) -> {
      return Integer.valueOf(it.getEStructuralFeatures().size());
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer l, Integer r) -> {
      return Integer.valueOf(((l).intValue() + (r).intValue()));
    };
    return (int) IterableExtensions.<Integer, Integer>fold(ListExtensions.<EClass, Integer>map(clazz.getEAllSuperTypes(), _function), Integer.valueOf(0), _function_1);
  }
}
