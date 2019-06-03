package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.TypeRefAspect;
import org.tetrabox.minijava.xminijava.miniJava.ClassRef;
import org.tetrabox.minijava.xminijava.miniJava.TypeDeclaration;
import org.tetrabox.minijava.xminijava.miniJava.TypeRef;

@Aspect(className = ClassRef.class)
@SuppressWarnings("all")
public class ClassRefAspect extends TypeRefAspect {
  @OverrideAspectMethod
  public static boolean compare(final ClassRef _self, final TypeRef other) {
	final org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_compare(_self_, _self, other);
	;
	return (boolean) result;
}
  
  private static boolean super_compare(final ClassRef _self, final TypeRef other) {
    final org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_, _self,other);
  }
  
  protected static boolean _privk3_compare(final ClassRefAspectClassRefAspectProperties _self_, final ClassRef _self, final TypeRef other) {
    if ((other instanceof ClassRef)) {
      TypeDeclaration _referencedClass = _self.getReferencedClass();
      TypeDeclaration _referencedClass_1 = ((ClassRef)other).getReferencedClass();
      return Objects.equal(_referencedClass, _referencedClass_1);
    } else {
      return false;
    }
  }
}
