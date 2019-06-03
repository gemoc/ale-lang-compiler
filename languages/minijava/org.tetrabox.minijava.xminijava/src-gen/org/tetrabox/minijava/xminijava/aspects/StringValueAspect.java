package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;

@Aspect(className = StringValue.class)
@SuppressWarnings("all")
public class StringValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static Value copy(final StringValue _self) {
	final org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_copy(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_copy(final StringValue _self) {
    final org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final StringValueAspectStringValueAspectProperties _self_, final StringValue _self) {
    StringValue _createStringValue = MiniJavaFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
}
