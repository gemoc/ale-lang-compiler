package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class VisitorNamingUtils implements AbstractNamingUtils {
  public String operationInterfacePackageName(final String packageRoot, final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("visitor.operation.");
    String _name = eClass.getEPackage().getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String operationInterfaceClassName(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eClass.getName();
    _builder.append(_name);
    _builder.append("Operation");
    return _builder.toString();
  }
  
  public String operationImplementationPackageName(final String packageRoot, final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("visitor.operation.");
    String _name = eClass.getEPackage().getName();
    _builder.append(_name);
    _builder.append(".impl");
    return _builder.toString();
  }
  
  public String operationImplementationClassName(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eClass.getName();
    _builder.append(_name);
    _builder.append("OperationImpl");
    return _builder.toString();
  }
  
  public String visitorInterfacePackageName(final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("visitor");
    return _builder.toString();
  }
  
  public String visitorInterfaceClassName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("VisitorInterface");
    return _builder.toString();
  }
  
  public String visitorImplementationPackageName(final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("visitor");
    return _builder.toString();
  }
  
  public String visitorImplementationClassName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("VisitorImplementation");
    return _builder.toString();
  }
  
  public String acceptInterfacePackageName(final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((packageRoot != null)) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    _builder.append("visitor");
    return _builder.toString();
  }
  
  public String acceptInterfaceClassName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AcceptInterface");
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
    _builder.append(".visitor.");
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
    _builder.append(".visitor.");
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
    _builder.append(".visitor.");
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
    _builder.append(".visitor.");
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
}
