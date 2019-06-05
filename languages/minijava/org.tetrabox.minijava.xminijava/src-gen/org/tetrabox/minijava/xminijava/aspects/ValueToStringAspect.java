package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties;

@Aspect(className = Value.class)
@SuppressWarnings("all")
public class ValueToStringAspect {
  public static String customToString(final Value _self) {
	final org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectContext
			.getSelf(_self);
	Object result = null;
	if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue) {
		result = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.BooleanValue) {
		result = org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspect
				.customToString((org.tetrabox.minijava.xminijava.miniJava.BooleanValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.NullValue) {
		result = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.NullValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue) {
		result = org.tetrabox.minijava.xminijava.aspects.ObjectRefValueToStringAspect
				.customToString((org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.StringValue) {
		result = org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspect
				.customToString((org.tetrabox.minijava.xminijava.miniJava.StringValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.IntegerValue) {
		result = org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspect
				.customToString((org.tetrabox.minijava.xminijava.miniJava.IntegerValue) _self);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Value) {
		result = org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect._privk3_customToString(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.Value) _self);
	} else {
		throw new IllegalArgumentException(
				"Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString());
	}
	;
	return (java.lang.String) result;
}
  
  protected static String _privk3_customToString(final ValueToStringAspectValueAspectProperties _self_, final Value _self) {
    return null;
  }
}
