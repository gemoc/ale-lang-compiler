package org.eclipse.emf.ecoretools.ale.compiler.emfswitch;

import com.squareup.javapoet.ClassName;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class SwitchNamingUtils {
  public String switchImplementationClassName(final String pkg) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(pkg);
    _builder.append(_firstUpper);
    _builder.append("SwitchImplementation");
    return _builder.toString();
  }
  
  public String switchImplementationPackageName(final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("emfswitch");
    return _builder.toString();
  }
  
  public String operationPackageName(final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("emfswitch.operation");
    return _builder.toString();
  }
  
  protected String _operationClassName(final EClass eCls) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(eCls.getName());
    _builder.append(_firstUpper);
    _builder.append("Operation");
    return _builder.toString();
  }
  
  protected String _operationClassName(final ClassName eCls) {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = eCls.simpleName();
    _builder.append(_simpleName);
    _builder.append("Operation");
    return _builder.toString();
  }
  
  public String factoryInterfaceClassName(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(ePackage.getName());
    _builder.append(_firstUpper);
    _builder.append("Factory");
    return _builder.toString();
  }
  
  public String operationClassName(final Object eCls) {
    if (eCls instanceof EClass) {
      return _operationClassName((EClass)eCls);
    } else if (eCls instanceof ClassName) {
      return _operationClassName((ClassName)eCls);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eCls).toString());
    }
  }
}
