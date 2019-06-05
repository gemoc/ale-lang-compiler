package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Method;

@Aspect(className = Method.class)
@SuppressWarnings("all")
public class MethodSortofStatementAspect {
  @Step
  public static void call(final Method _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectContext
			.getSelf(_self);
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
		@Override
		public void execute() {
			_privk3_call(_self_, _self, state);
		}
	};
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry
			.getInstance().findStepManager(_self);
	if (manager != null) {
		manager.executeStep(_self, command, "Method", "call");
	} else {
		command.execute();
	}
	;
	;
}
  
  protected static void _privk3_call(final MethodSortofStatementAspectMethodAspectProperties _self_, final Method _self, final State state) {
    BlockAspect.evaluateStatement(_self.getBody(), state);
  }
}
