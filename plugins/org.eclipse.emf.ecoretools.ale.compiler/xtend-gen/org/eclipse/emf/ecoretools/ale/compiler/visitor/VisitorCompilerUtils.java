package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class VisitorCompilerUtils {
  @Extension
  private VisitorNamingUtils _visitorNamingUtils = new VisitorNamingUtils();
  
  protected TypeName _scopedTypeRef(final EDataType edt, final String packageRoot) {
    return TypeName.get(edt.getInstanceClass());
  }
  
  protected TypeName _scopedTypeRef(final EClass clazz, final String packageRoot) {
    return ClassName.get(this._visitorNamingUtils.classImplementationPackageName(clazz, packageRoot), this._visitorNamingUtils.classImplementationClassName(clazz));
  }
  
  protected TypeName _scopedTypeRef(final EEnum eEnum, final String packageRoot) {
    return ClassName.get(this._visitorNamingUtils.classInterfacePackageName(eEnum, packageRoot), this._visitorNamingUtils.classInterfaceClassName(eEnum));
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EDataType edt, final String packageRoot) {
    return TypeName.get(edt.getInstanceClass());
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EClass clazz, final String packageRoot) {
    return ClassName.get(this._visitorNamingUtils.classInterfacePackageName(clazz, packageRoot), this._visitorNamingUtils.classInterfaceClassName(clazz));
  }
  
  protected TypeName _scopedInterfaceTypeRef(final EEnum eEnum, final String packageRoot) {
    return ClassName.get(this._visitorNamingUtils.classInterfacePackageName(eEnum, packageRoot), this._visitorNamingUtils.classInterfaceClassName(eEnum));
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
