package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;

@Aspect(className = BooleanValue.class)
@SuppressWarnings("all")
public class BooleanValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static Value copy(final BooleanValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_copy(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_copy(final BooleanValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final BooleanValueAspectBooleanValueAspectProperties _self_, final BooleanValue _self) {
    BooleanValue _createBooleanValue = MiniJavaFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue(_self.isValue());
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
