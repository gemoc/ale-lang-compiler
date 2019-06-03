package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.WhileStatement;

@Aspect(className = WhileStatement.class)
@SuppressWarnings("all")
public class WhileStatementAspect extends StatementAspect {
  @OverrideAspectMethod
  @Step
  public static void evaluateStatement(final WhileStatement _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectContext
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
		manager.executeStep(_self, command, "WhileStatement", "evaluateStatement");
	} else {
		command.execute();
	}
	;
	;
}
  
  private static void super_evaluateStatement(final WhileStatement _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final WhileStatementAspectWhileStatementAspectProperties _self_, final WhileStatement _self, final State state) {
    while (((BooleanValue) ExpressionAspect.evaluateExpression(_self.getCondition(), state)).isValue()) {
      BlockAspect.evaluateStatement(_self.getBlock(), state);
    }
  }
}
