package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.miniJava.ForStatement;

@Aspect(className = ForStatement.class)
@SuppressWarnings("all")
public class ForStatementAspect extends StatementAspect {
  @OverrideAspectMethod
  @Step
  public static void evaluateStatement(final ForStatement _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectContext
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
		manager.executeStep(_self, command, "ForStatement", "evaluateStatement");
	} else {
		command.execute();
	}
	;
	;
}
  
  private static void super_evaluateStatement(final ForStatement _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final ForStatementAspectForStatementAspectProperties _self_, final ForStatement _self, final State state) {
    StateAspect.pushNewContext(state);
    {
      StatementAspect.evaluateStatement(_self.getDeclaration(), state);
      Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getCondition(), state);
      boolean _isValue = ((BooleanValue) _evaluateExpression).isValue();
      boolean _while = _isValue;
      while (_while) {
        BlockAspect.evaluateStatement(_self.getBlock(), state);
        StatementAspect.evaluateStatement(_self.getProgression(), state);
        Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getCondition(), state);
        boolean _isValue_1 = ((BooleanValue) _evaluateExpression_1).isValue();
        _while = _isValue_1;
      }
    }
    StateAspect.popCurrentContext(state);
  }
}
