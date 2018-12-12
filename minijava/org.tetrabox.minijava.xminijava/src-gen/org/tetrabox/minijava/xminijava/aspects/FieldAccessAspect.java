package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.tetrabox.minijava.xminijava.miniJava.FieldBinding;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Field;
import org.tetrabox.minijava.xminijava.miniJava.FieldAccess;

@Aspect(className = FieldAccess.class)
@SuppressWarnings("all")
public class FieldAccessAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final FieldAccess _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final FieldAccess _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final FieldAccessAspectFieldAccessAspectProperties _self_, final FieldAccess _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getReceiver(), state);
    ObjectInstance _instance = ((ObjectRefValue) _evaluateExpression).getInstance();
    final ObjectInstance realReceiver = ((ObjectInstance) _instance);
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      Field _field = it.getField();
      Field _field_1 = _self.getField();
      return Boolean.valueOf((_field == _field_1));
    };
    return IterableExtensions.<FieldBinding>findFirst(realReceiver.getFieldbindings(), _function).getValue();
  }
}
