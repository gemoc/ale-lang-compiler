package org.eclipse.emf.ecoretools.ale.compiler;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class InterpreterCompilerUtils {
  @Extension
  private AbstractNamingUtils anu;
  
  public InterpreterCompilerUtils(final AbstractNamingUtils anu) {
    this.anu = anu;
  }
  
  protected TypeName _scopedTypeRef(final EDataType edt, final String packageRoot) {
    return TypeName.get(edt.getInstanceClass());
  }
  
  protected TypeName _scopedTypeRef(final EClass clazz, final String packageRoot) {
    return ClassName.get(this.anu.classImplementationPackageName(clazz, packageRoot), this.anu.classImplementationClassName(clazz));
  }
  
  protected TypeName _scopedTypeRef(final EEnum eEnum, final String packageRoot) {
    return ClassName.get(this.anu.classInterfacePackageName(eEnum, packageRoot), this.anu.classInterfaceClassName(eEnum));
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EDataType edt, final String packageRoot) {
    return TypeName.get(edt.getInstanceClass());
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EClass clazz, final String packageRoot) {
    return ClassName.get(this.anu.classInterfacePackageName(clazz, packageRoot), this.anu.classInterfaceClassName(clazz));
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EEnum eEnum, final String packageRoot) {
    return ClassName.get(this.anu.classInterfacePackageName(eEnum, packageRoot), this.anu.classInterfaceClassName(eEnum));
  }
  
  public TypeName scopedTypeRef(final EClassifier eEnum, final String packageRoot) {
    if (eEnum instanceof EEnum) {
      return _scopedTypeRef((EEnum)eEnum, packageRoot);
    } else if (eEnum instanceof EClass) {
      return _scopedTypeRef((EClass)eEnum, packageRoot);
    } else if (eEnum instanceof EDataType) {
      return _scopedTypeRef((EDataType)eEnum, packageRoot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eEnum, packageRoot).toString());
    }
  }
  
  public TypeName scopedInterfaceTypeRef(final EClassifier eEnum, final String packageRoot) {
    if (eEnum instanceof EEnum) {
      return _scopedInterfaceTypeRef((EEnum)eEnum, packageRoot);
    } else if (eEnum instanceof EClass) {
      return _scopedInterfaceTypeRef((EClass)eEnum, packageRoot);
    } else if (eEnum instanceof EDataType) {
      return _scopedInterfaceTypeRef((EDataType)eEnum, packageRoot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eEnum, packageRoot).toString());
    }
  }
}
