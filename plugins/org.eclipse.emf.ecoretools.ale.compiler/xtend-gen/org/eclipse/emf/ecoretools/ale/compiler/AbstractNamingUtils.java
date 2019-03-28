package org.eclipse.emf.ecoretools.ale.compiler;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public interface AbstractNamingUtils {
  public abstract String normalizeUpperField(final String input);
  
  public abstract String normalizeUpperField(final String input, final String className);
  
  public abstract String packageInterfaceClassName(final EPackage ePackage);
  
  public abstract String packageInterfacePackageName(final EPackage ePackage, final String packageRoot);
  
  public abstract String classImplementationPackageName(final EClass eClass, final String packageRoot);
  
  public abstract String classImplementationClassName(final EClass eClass);
  
  public abstract String classInterfacePackageName(final EClass eClass, final String packageRoot);
  
  public abstract String classInterfacePackageName(final EEnum eEnum, final String packageRoot);
  
  public abstract String classInterfaceClassName(final EClass eClass);
  
  public abstract String classInterfaceClassName(final EEnum eEnum);
  
  public default String normalizeVarName(final String name) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(name, "enum");
    if (_equals) {
      _xifexpression = "enum_";
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  public default String normalizeVarNewName(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public default String normalizeVarOldName(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("old");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper);
    return _builder.toString();
  }
}
