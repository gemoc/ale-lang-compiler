package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect;

@Aspect(className = BooleanValue.class)
@SuppressWarnings("all")
public class BooleanValueToStringAspect extends ValueToStringAspect {
  @OverrideAspectMethod
  public static String customToString(final BooleanValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_customToString(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  private static String super_customToString(final BooleanValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_, _self);
  }
  
  protected static String _privk3_customToString(final BooleanValueToStringAspectBooleanValueAspectProperties _self_, final BooleanValue _self) {
    return Boolean.valueOf(_self.isValue()).toString();
  }
}
