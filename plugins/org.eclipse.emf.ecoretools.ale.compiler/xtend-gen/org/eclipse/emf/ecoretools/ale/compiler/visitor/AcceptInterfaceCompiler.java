package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AcceptInterfaceCompiler {
  @Extension
  private VisitorNamingUtils namingUtils = new VisitorNamingUtils();
  
  private final File directory;
  
  private final String packageRoot;
  
  public AcceptInterfaceCompiler(final File rootDirectory, final String packageRoot) {
    this.directory = rootDirectory;
    this.packageRoot = packageRoot;
  }
  
  public void compile() {
    try {
      final TypeSpec factory = TypeSpec.interfaceBuilder(this.namingUtils.acceptInterfaceClassName()).addMethod(
        MethodSpec.methodBuilder("accept").addParameter(ClassName.get(this.namingUtils.visitorInterfacePackageName(this.packageRoot), this.namingUtils.visitorInterfaceClassName()), "accept").addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).returns(Object.class).build()).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.acceptInterfacePackageName(this.packageRoot), factory).indent("\t").build();
      javaFile.writeTo(this.directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
