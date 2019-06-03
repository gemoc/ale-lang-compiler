package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Null;

@Aspect(className = Null.class)
@SuppressWarnings("all")
public class NullAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Null _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Null _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NullAspectNullAspectProperties _self_, final Null _self, final State state) {
    return MiniJavaFactory.eINSTANCE.createNullValue();
  }
}
