package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Or;

@Aspect(className = Or.class)
@SuppressWarnings("all")
public class OrAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Or _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Or _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final OrAspectOrAspectProperties _self_, final Or _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    if ((left instanceof BooleanValue)) {
      if ((right instanceof BooleanValue)) {
        BooleanValue _createBooleanValue = MiniJavaFactory.eINSTANCE.createBooleanValue();
        final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
          it.setValue((((BooleanValue)left).isValue() || ((BooleanValue)right).isValue()));
        };
        return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Unsupported or operands: ");
    _builder.append(left);
    _builder.append(" || ");
    _builder.append(right);
    _builder.append(".");
    throw new RuntimeException(_builder.toString());
  }
}
