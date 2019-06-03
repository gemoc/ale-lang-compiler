package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;

@Aspect(className = IntegerValue.class)
@SuppressWarnings("all")
public class IntegerValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static Value copy(final IntegerValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_copy(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_copy(final IntegerValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final IntegerValueAspectIntegerValueAspectProperties _self_, final IntegerValue _self) {
    IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
