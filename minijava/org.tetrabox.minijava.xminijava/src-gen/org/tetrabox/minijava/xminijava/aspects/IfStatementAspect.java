package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.miniJava.Block;
import org.tetrabox.minijava.xminijava.miniJava.IfStatement;

@Aspect(className = IfStatement.class)
@SuppressWarnings("all")
public class IfStatementAspect extends StatementAspect {
  @OverrideAspectMethod
  @Step
  public static void evaluateStatement(final IfStatement _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectContext
			.getSelf(_self);
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
		@Override
		public void execute() {
			_privk3_evaluateStatement(_self_, _self, state);
		}
	};
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry
			.getInstance().findStepManager(_self);
	if (manager != null) {
		manager.executeStep(_self, command, "IfStatement", "evaluateStatement");
	} else {
		command.execute();
	}
	;
	;
}
  
  private static void super_evaluateStatement(final IfStatement _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final IfStatementAspectIfStatementAspectProperties _self_, final IfStatement _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    boolean _isValue = ((BooleanValue) _evaluateExpression).isValue();
    if (_isValue) {
      BlockAspect.evaluateStatement(_self.getThenBlock(), state);
    } else {
      Block _elseBlock = _self.getElseBlock();
      boolean _tripleNotEquals = (_elseBlock != null);
      if (_tripleNotEquals) {
        BlockAspect.evaluateStatement(_self.getElseBlock(), state);
      }
    }
  }
}
