package org.eclipse.emf.ecoretools.ale.compiler.emfswitch;

import com.google.common.base.Objects;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.SwitchNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class SwitchImplementationCompiler {
  @Extension
  private SwitchNamingUtils namingUtils = new SwitchNamingUtils();
  
  private final File directory;
  
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private final String packageRoot;
  
  private final List<ALESwitchImplementationCompiler.ResolvedClass> resolved;
  
  public SwitchImplementationCompiler(final File rootDirectory, final Map<String, Pair<EPackage, GenModel>> syntaxes, final String packageRoot, final List<ALESwitchImplementationCompiler.ResolvedClass> resolved) {
    this.directory = rootDirectory;
    this.syntaxes = syntaxes;
    this.packageRoot = packageRoot;
    this.resolved = resolved;
  }
  
  public void compile() {
    try {
      final Pair<EPackage, GenModel> firstPackage = IterableExtensions.<Map.Entry<String, Pair<EPackage, GenModel>>>head(this.syntaxes.entrySet()).getValue();
      final GenPackage gp = IterableExtensions.<GenPackage>head(firstPackage.getValue().getGenPackages());
      final ParameterizedTypeName abstractSwitchType = ParameterizedTypeName.get(ClassName.get(gp.getUtilitiesPackageName(), gp.getSwitchClassName()), 
        ClassName.get(Object.class));
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
        String _instanceClassName = it.eCls.getInstanceClassName();
        return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
      };
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, MethodSpec> _function_1 = (ALESwitchImplementationCompiler.ResolvedClass resolved) -> {
        MethodSpec _xblockexpression = null;
        {
          final ClassName pcn = ClassName.get(resolved.getGenCls().getGenPackage().getInterfacePackageName(), resolved.getGenCls().getInterfaceName());
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("case");
          String _firstUpper = StringExtensions.toFirstUpper(resolved.eCls.getName());
          _builder.append(_firstUpper);
          MethodSpec.Builder _addParameter = MethodSpec.methodBuilder(_builder.toString()).addParameter(pcn, "it");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("return new $T(it, this);");
          _builder_1.newLine();
          _xblockexpression = _addParameter.addCode(_builder_1.toString(), ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), this.namingUtils.operationClassName(resolved.eCls))).returns(Object.class).addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).build();
        }
        return _xblockexpression;
      };
      final TypeSpec factory = TypeSpec.classBuilder(this.namingUtils.switchImplementationClassName(this.packageRoot)).superclass(abstractSwitchType).addMethods(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass, MethodSpec>map(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function), _function_1)).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.switchImplementationPackageName(this.packageRoot), factory).indent("\t").build();
      javaFile.writeTo(this.directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
