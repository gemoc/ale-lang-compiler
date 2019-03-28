package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EClassInterfaceCompiler {
  @Extension
  private VisitorNamingUtils namingUtils = new VisitorNamingUtils();
  
  @Extension
  private VisitorCompilerUtils _visitorCompilerUtils = new VisitorCompilerUtils();
  
  public void compileEClassInterface(final EClass eClass, final ExtendedClass aleClass, final File directory, final Dsl dsl, final String packageRoot) {
    try {
      final Function1<EAttribute, List<MethodSpec>> _function = (EAttribute field) -> {
        List<MethodSpec> _xblockexpression = null;
        {
          final TypeName fieldType = this._visitorCompilerUtils.scopedInterfaceTypeRef(field.getEType(), packageRoot);
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
          _xblockexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, setter));
        }
        return _xblockexpression;
      };
      final Iterable<MethodSpec> attributesMethods = Iterables.<MethodSpec>concat(ListExtensions.<EAttribute, List<MethodSpec>>map(eClass.getEAttributes(), _function));
      final Function1<EReference, Iterable<MethodSpec>> _function_1 = (EReference field) -> {
        Iterable<MethodSpec> _xblockexpression = null;
        {
          final EClassifier ert = field.getEGenericType().getERawType();
          final TypeName rt = this._visitorCompilerUtils.scopedInterfaceTypeRef(ert, packageRoot);
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
                  _xifexpression_2 = ParameterizedTypeName.get(ClassName.get(EMap.class), 
                    this._visitorCompilerUtils.scopedInterfaceTypeRef(key.getEType(), packageRoot), 
                    this._visitorCompilerUtils.scopedInterfaceTypeRef(value.getEType(), packageRoot));
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
      final Function1<EClass, ClassName> _function_2 = (EClass it) -> {
        return ClassName.get(this.namingUtils.classInterfacePackageName(it, packageRoot), this.namingUtils.classInterfaceClassName(it));
      };
      TypeSpec.Builder _addSuperinterfaces = TypeSpec.interfaceBuilder(this.namingUtils.classInterfaceClassName(eClass)).addSuperinterface(EObject.class).addSuperinterface(
        ClassName.get(this.namingUtils.acceptInterfacePackageName(packageRoot), 
          this.namingUtils.acceptInterfaceClassName())).addSuperinterfaces(ListExtensions.<EClass, ClassName>map(eClass.getESuperTypes(), _function_2));
      Iterable<MethodSpec> _plus = Iterables.<MethodSpec>concat(attributesMethods, referencesMethods);
      final TypeSpec factory = _addSuperinterfaces.addMethods(_plus).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.classInterfacePackageName(eClass, packageRoot), factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
