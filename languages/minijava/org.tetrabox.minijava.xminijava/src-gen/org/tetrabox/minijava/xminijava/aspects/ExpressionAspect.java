package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Expression;

@Aspect(className = Expression.class)
@SuppressWarnings("all")
public class ExpressionAspect {
  public static Value evaluateExpression(final Expression _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext
			.getSelf(_self);
	Object result = null;
	if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.FieldAccess) {
		result = org.tetrabox.minijava.xminijava.aspects.FieldAccessAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.FieldAccess) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Super) {
		result = org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.Super) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.IntConstant) {
		result = org.tetrabox.minijava.xminijava.aspects.IntConstantAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.IntConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Multiplication) {
		result = org.tetrabox.minijava.xminijava.aspects.MultiplicationAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Multiplication) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.BoolConstant) {
		result = org.tetrabox.minijava.xminijava.aspects.BoolConstantAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.BoolConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.NewObject) {
		result = org.tetrabox.minijava.xminijava.aspects.NewObjectAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.NewObject) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual) {
		result = org.tetrabox.minijava.xminijava.aspects.InferiorOrEqualAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Plus) {
		result = org.tetrabox.minijava.xminijava.aspects.PlusAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Plus) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.StringConstant) {
		result = org.tetrabox.minijava.xminijava.aspects.StringConstantAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.StringConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Neg) {
		result = org.tetrabox.minijava.xminijava.aspects.NegAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Neg) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.This) {
		result = org.tetrabox.minijava.xminijava.aspects.ThisAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.This) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.NewArray) {
		result = org.tetrabox.minijava.xminijava.aspects.NewArrayAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.NewArray) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Superior) {
		result = org.tetrabox.minijava.xminijava.aspects.SuperiorAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Superior) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.And) {
		result = org.tetrabox.minijava.xminijava.aspects.AndAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.And) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Not) {
		result = org.tetrabox.minijava.xminijava.aspects.NotAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Not) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Equality) {
		result = org.tetrabox.minijava.xminijava.aspects.EqualityAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Equality) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Minus) {
		result = org.tetrabox.minijava.xminijava.aspects.MinusAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Minus) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayAccess) {
		result = org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.ArrayAccess) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Division) {
		result = org.tetrabox.minijava.xminijava.aspects.DivisionAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Division) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayLength) {
		result = org.tetrabox.minijava.xminijava.aspects.ArrayLengthAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.ArrayLength) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Inferior) {
		result = org.tetrabox.minijava.xminijava.aspects.InferiorAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Inferior) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.MethodCall) {
		result = org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.MethodCall) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Or) {
		result = org.tetrabox.minijava.xminijava.aspects.OrAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Or) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Inequality) {
		result = org.tetrabox.minijava.xminijava.aspects.InequalityAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Inequality) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual) {
		result = org.tetrabox.minijava.xminijava.aspects.SuperiorOrEqualAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Null) {
		result = org.tetrabox.minijava.xminijava.aspects.NullAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.Null) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.SymbolRef) {
		result = org.tetrabox.minijava.xminijava.aspects.SymbolRefAspect
				.evaluateExpression((org.tetrabox.minijava.xminijava.miniJava.SymbolRef) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Expression) {
		result = org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_,
				(org.tetrabox.minijava.xminijava.miniJava.Expression) _self, state);
	} else {
		throw new IllegalArgumentException(
				"Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString());
	}
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  protected static Value _privk3_evaluateExpression(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("evaluate should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
