package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Neg;

@Aspect(className = Neg.class)
@SuppressWarnings("all")
public class NegAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Neg _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Neg _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NegAspectNegAspectProperties _self_, final Neg _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    final int intabsvalue = ((IntegerValue) _evaluateExpression).getValue();
    IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue((-intabsvalue));
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
