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
import org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Multiplication;

@Aspect(className = Multiplication.class)
@SuppressWarnings("all")
public class MultiplicationAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Multiplication _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Multiplication _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final int left = ((IntegerValue) _evaluateExpression).getValue();
    Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    final int right = ((IntegerValue) _evaluateExpression_1).getValue();
    IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue((left * right));
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
