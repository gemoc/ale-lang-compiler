package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ContextAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;
import org.tetrabox.minijava.xminijava.miniJava.SymbolRef;

@Aspect(className = SymbolRef.class)
@SuppressWarnings("all")
public class SymbolRefAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final SymbolRef _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final SymbolRef _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final SymbolRefAspectSymbolRefAspectProperties _self_, final SymbolRef _self, final State state) {
    return ValueAspect.copy(ContextAspect.findBinding(StateAspect.findCurrentContext(state), _self.getSymbol()).getValue());
  }
}
