package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FactoryInterfaceCompiler {
  @Extension
  private VisitorNamingUtils namingUtils = new VisitorNamingUtils();
  
  public void compileFactoryInterface(final EPackage abstractSyntax, final File directory, final String packageRoot) {
    try {
      final ClassName factoryInterfaceType = ClassName.get(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.factoryInterfaceClassName(abstractSyntax));
      final ClassName packageInterfaceType = ClassName.get(this.namingUtils.packageInterfacePackageName(abstractSyntax, packageRoot), 
        this.namingUtils.packageInterfaceClassName(abstractSyntax));
      final ClassName factoryImplType = ClassName.get(this.namingUtils.factoryImplementationPackageName(abstractSyntax, packageRoot), 
        this.namingUtils.factoryImplementationClassName(abstractSyntax));
      FieldSpec.Builder _builder = FieldSpec.builder(factoryInterfaceType, "eINSTANCE", Modifier.PUBLIC, Modifier.FINAL, Modifier.STATIC);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("$T.init()");
      final FieldSpec einstance = _builder.initializer(_builder_1.toString(), factoryImplType).build();
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        return Boolean.valueOf(((!it.isAbstract()) && (!((it.getInstanceClass() != null) && Objects.equal(it.getInstanceClass(), Map.Entry.class)))));
      };
      final Function1<EClass, MethodSpec> _function_1 = (EClass it) -> {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("create");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder_2.append(_firstUpper);
        return MethodSpec.methodBuilder(_builder_2.toString()).returns(
          ClassName.get(this.namingUtils.classInterfacePackageName(it, packageRoot), this.namingUtils.classInterfaceClassName(it))).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
      };
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("get");
      String _firstUpper = StringExtensions.toFirstUpper(abstractSyntax.getName());
      _builder_2.append(_firstUpper);
      _builder_2.append("Package");
      final TypeSpec factory = TypeSpec.interfaceBuilder(this.namingUtils.factoryInterfaceClassName(abstractSyntax)).addSuperinterface(EFactory.class).addField(einstance).addMethods(IterableExtensions.<EClass, MethodSpec>map(IterableExtensions.<EClass>filter(Iterables.<EClass>filter(abstractSyntax.getEClassifiers(), EClass.class), _function), _function_1)).addMethod(
        MethodSpec.methodBuilder(_builder_2.toString()).returns(packageInterfaceType).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build()).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.factoryInterfacePackageName(abstractSyntax, packageRoot), factory).indent("\t").build();
      javaFile.writeTo(directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
