package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect;

@Aspect(className = StringValue.class)
@SuppressWarnings("all")
public class StringValueToStringAspect extends ValueToStringAspect {
  @OverrideAspectMethod
  public static String customToString(final StringValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_customToString(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  private static String super_customToString(final StringValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_, _self);
  }
  
  protected static String _privk3_customToString(final StringValueToStringAspectStringValueAspectProperties _self_, final StringValue _self) {
    return _self.getValue().toString();
  }
}
