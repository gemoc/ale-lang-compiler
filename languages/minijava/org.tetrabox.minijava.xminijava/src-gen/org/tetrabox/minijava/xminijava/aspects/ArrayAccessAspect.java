package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.ArrayInstance;
import org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;
import org.tetrabox.minijava.xminijava.miniJava.ArrayAccess;

@Aspect(className = ArrayAccess.class)
@SuppressWarnings("all")
public class ArrayAccessAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final ArrayAccess _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final ArrayAccess _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ArrayAccessAspectArrayAccessAspectProperties _self_, final ArrayAccess _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getObject(), state);
    final ArrayInstance array = ((ArrayRefValue) _evaluateExpression).getInstance();
    Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getIndex(), state);
    final int index = ((IntegerValue) _evaluateExpression_1).getValue();
    return ValueAspect.copy(array.getValue().get(index));
  }
}
