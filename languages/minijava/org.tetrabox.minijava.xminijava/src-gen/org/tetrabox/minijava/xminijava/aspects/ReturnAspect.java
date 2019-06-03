package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.miniJava.Return;

@Aspect(className = Return.class)
@SuppressWarnings("all")
public class ReturnAspect extends StatementAspect {
  @OverrideAspectMethod
  @Step
  public static void evaluateStatement(final Return _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectContext
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
		manager.executeStep(_self, command, "Return", "evaluateStatement");
	} else {
		command.execute();
	}
	;
	;
}
  
  private static void super_evaluateStatement(final Return _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final ReturnAspectReturnAspectProperties _self_, final Return _self, final State state) {
    final Value value = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(state);
    _findCurrentFrame.setReturnValue(value);
  }
}
