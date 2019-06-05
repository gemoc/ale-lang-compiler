package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect;

@Aspect(className = IntegerValue.class)
@SuppressWarnings("all")
public class IntegerValueToStringAspect extends ValueToStringAspect {
  @OverrideAspectMethod
  public static String customToString(final IntegerValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_customToString(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  private static String super_customToString(final IntegerValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_, _self);
  }
  
  protected static String _privk3_customToString(final IntegerValueToStringAspectIntegerValueAspectProperties _self_, final IntegerValue _self) {
    return Integer.valueOf(_self.getValue()).toString();
  }
}
