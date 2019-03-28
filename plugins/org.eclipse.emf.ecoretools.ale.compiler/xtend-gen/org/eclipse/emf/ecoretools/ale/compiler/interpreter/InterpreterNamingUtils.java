package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class InterpreterNamingUtils implements AbstractNamingUtils {
  public String whileFieldName(final While w) {
    try {
      String _xblockexpression = null;
      {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] _digest = md.digest(EcoreUtil.getURI(w).toString().getBytes());
        BigInteger _bigInteger = new BigInteger(1, _digest);
        final String hash = String.format("%032X", _bigInteger);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("loopNode");
        _builder.append(hash);
        _xblockexpression = _builder.toString();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String dispatchWrapperClassName(final EClass eClass, final Method method) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eClass.getName();
    _builder.append(_name);
    _builder.append("DispatchWrapper");
    String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String factoryInterfacePackageName(final EPackage ePackage, final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.append(".interpreter.");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    return _builder.toString();
  }
  
  public String factoryInterfaceClassName(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(ePackage.getName());
    _builder.append(_firstUpper);
    _builder.append("Factory");
    return _builder.toString();
  }
  
  @Override
  public String packageInterfacePackageName(final EPackage ePackage, final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.append(".interpreter.");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    return _builder.toString();
  }
  
  @Override
  public String packageInterfaceClassName(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(ePackage.getName());
    _builder.append(_firstUpper);
    _builder.append("Package");
    return _builder.toString();
  }
  
  public String packageImplementationPackageName(final EPackage ePackage, final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.append(".interpreter.");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    _builder.append(".impl");
    return _builder.toString();
  }
  
  public String packageImplementationClassName(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(ePackage.getName());
    _builder.append(_firstUpper);
    _builder.append("PackageImpl");
    return _builder.toString();
  }
  
  public String factoryImplementationPackageName(final EPackage ePackage, final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.append(".interpreter.");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    _builder.append(".impl");
    return _builder.toString();
  }
  
  public String factoryImplementationClassName(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(ePackage.getName());
    _builder.append(_firstUpper);
    _builder.append("FactoryImpl");
    return _builder.toString();
  }
  
  @Override
  public String classInterfacePackageName(final EClass eClass, final String packageRoot) {
    return this.factoryInterfacePackageName(eClass.getEPackage(), packageRoot);
  }
  
  @Override
  public String classInterfacePackageName(final EEnum eEnum, final String packageRoot) {
    return this.factoryInterfacePackageName(eEnum.getEPackage(), packageRoot);
  }
  
  @Override
  public String classInterfaceClassName(final EClass eClass) {
    return StringExtensions.toFirstUpper(eClass.getName());
  }
  
  @Override
  public String classInterfaceClassName(final EEnum eEnum) {
    return StringExtensions.toFirstUpper(eEnum.getName());
  }
  
  @Override
  public String classImplementationPackageName(final EClass eClass, final String packageRoot) {
    return this.factoryImplementationPackageName(eClass.getEPackage(), packageRoot);
  }
  
  @Override
  public String classImplementationClassName(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(eClass.getName());
    _builder.append(_firstUpper);
    _builder.append("Impl");
    return _builder.toString();
  }
  
  @Override
  public String normalizeUpperField(final String input) {
    StringConcatenation _builder = new StringConcatenation();
    String _format = CodeGenUtil.format(input, '_', "", false, false);
    _builder.append(_format);
    return _builder.toString().toUpperCase();
  }
  
  @Override
  public String normalizeUpperField(final String input, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    String _format = CodeGenUtil.format(className, '_', "", false, false);
    _builder.append(_format);
    _builder.append("__");
    String _format_1 = CodeGenUtil.format(input, '_', "", false, false);
    _builder.append(_format_1);
    return _builder.toString().toUpperCase();
  }
  
  public String normalizeUpperMethod(final String input, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(className);
    _builder.append("_");
    String _firstUpper = StringExtensions.toFirstUpper(input);
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String normalizeExtendedClassName(final ExtendedClass ec) {
    return StringExtensions.toFirstUpper(IterableExtensions.<String>head(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(ec.getName().split("\\."))))));
  }
}
