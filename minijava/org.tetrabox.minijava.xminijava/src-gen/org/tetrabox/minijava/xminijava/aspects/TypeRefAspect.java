package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.emf.ecore.EClass;
import org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.TypeRef;

@Aspect(className = TypeRef.class)
@SuppressWarnings("all")
public class TypeRefAspect {
  public static boolean compare(final TypeRef _self, final TypeRef other) {
	final org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectContext
			.getSelf(_self);
	Object result = null;
	if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.ArrayTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ClassRef) {
		result = org.tetrabox.minijava.xminijava.aspects.ClassRefAspect
				.compare((org.tetrabox.minijava.xminijava.miniJava.ClassRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.IntegerTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.IntegerTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.VoidTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.VoidTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.StringTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.StringTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.BooleanTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.BooleanTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.SingleTypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.SingleTypeRef) _self, other);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.TypeRef) {
		result = org.tetrabox.minijava.xminijava.aspects.TypeRefAspect._privk3_compare(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.TypeRef) _self, other);
	} else {
		throw new IllegalArgumentException(
				"Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString());
	}
	;
	return (boolean) result;
}
  
  protected static boolean _privk3_compare(final TypeRefAspectTypeRefAspectProperties _self_, final TypeRef _self, final TypeRef other) {
    EClass _eClass = _self.eClass();
    EClass _eClass_1 = other.eClass();
    return Objects.equal(_eClass, _eClass_1);
  }
}
