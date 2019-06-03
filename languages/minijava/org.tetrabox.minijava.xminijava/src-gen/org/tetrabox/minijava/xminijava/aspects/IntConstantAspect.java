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
import org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.IntConstant;

@Aspect(className = IntConstant.class)
@SuppressWarnings("all")
public class IntConstantAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final IntConstant _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final IntConstant _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final IntConstantAspectIntConstantAspectProperties _self_, final IntConstant _self, final State state) {
    IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
