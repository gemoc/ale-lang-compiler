package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.NullValue;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;

@Aspect(className = NullValue.class)
@SuppressWarnings("all")
public class NullValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static Value copy(final NullValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_copy(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_copy(final NullValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final NullValueAspectNullValueAspectProperties _self_, final NullValue _self) {
    return MiniJavaFactory.eINSTANCE.createNullValue();
  }
}
