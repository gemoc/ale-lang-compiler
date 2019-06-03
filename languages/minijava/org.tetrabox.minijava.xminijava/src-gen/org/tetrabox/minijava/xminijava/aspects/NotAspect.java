package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Not;

@Aspect(className = Not.class)
@SuppressWarnings("all")
public class NotAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Not _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Not _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NotAspectNotAspectProperties _self_, final Not _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    final boolean expr = ((BooleanValue) _evaluateExpression).isValue();
    BooleanValue _createBooleanValue = MiniJavaFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue((!expr));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
