package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Statement;

@Aspect(className = Statement.class)
@SuppressWarnings("all")
public class StatementAspect {
  @Step
  public static void evaluateStatement(final Statement _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext
			.getSelf(_self);
	if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Not) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Not) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Block) {
		org.tetrabox.minijava.xminijava.aspects.BlockAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Block) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Or) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Or) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.StringConstant) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.StringConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayLength) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.ArrayLength) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.IntConstant) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.IntConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.WhileStatement) {
		org.tetrabox.minijava.xminijava.aspects.WhileStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.WhileStatement) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Inferior) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Inferior) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.IfStatement) {
		org.tetrabox.minijava.xminijava.aspects.IfStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.IfStatement) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Minus) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Minus) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Plus) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Plus) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Equality) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Equality) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ForStatement) {
		org.tetrabox.minijava.xminijava.aspects.ForStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.ForStatement) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.ArrayAccess) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.ArrayAccess) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Null) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Null) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Superior) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Superior) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.NewArray) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.NewArray) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.FieldAccess) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.FieldAccess) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Assignment) {
		org.tetrabox.minijava.xminijava.aspects.AssigmentAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Assignment) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.PrintStatement) {
		org.tetrabox.minijava.xminijava.aspects.PrintStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.PrintStatement) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.MethodCall) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.MethodCall) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.SymbolRef) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.SymbolRef) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.And) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.And) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Multiplication) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Multiplication) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Return) {
		org.tetrabox.minijava.xminijava.aspects.ReturnAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Return) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Inequality) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Inequality) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.BoolConstant) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.BoolConstant) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Super) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Super) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.This) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.This) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.NewObject) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.NewObject) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Neg) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Neg) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Division) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Division) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Expression) {
		org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspect
				.evaluateStatement((org.tetrabox.minijava.xminijava.miniJava.Expression) _self, state);
	} else if (_self instanceof org.tetrabox.minijava.xminijava.miniJava.Statement) {
		fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
			@Override
			public void execute() {
				org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_,
						(org.tetrabox.minijava.xminijava.miniJava.Statement) _self, state);
			}
		};
		fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry
				.getInstance().findStepManager(_self);
		if (manager != null) {
			manager.executeStep(_self, command, "Statement", "evaluateStatement");
		} else {
			command.execute();
		}
		;
	} else {
		throw new IllegalArgumentException(
				"Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString());
	}
	;
}
  
  protected static void _privk3_evaluateStatement(final StatementAspectStatementAspectProperties _self_, final Statement _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("evaluate should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
