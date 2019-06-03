package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.ArrayInstance;
import org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.FieldBinding;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ContextAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.miniJava.ArrayAccess;
import org.tetrabox.minijava.xminijava.miniJava.Assignee;
import org.tetrabox.minijava.xminijava.miniJava.Assignment;
import org.tetrabox.minijava.xminijava.miniJava.Field;
import org.tetrabox.minijava.xminijava.miniJava.FieldAccess;
import org.tetrabox.minijava.xminijava.miniJava.Symbol;
import org.tetrabox.minijava.xminijava.miniJava.SymbolRef;
import org.tetrabox.minijava.xminijava.miniJava.VariableDeclaration;

@Aspect(className = Assignment.class)
@SuppressWarnings("all")
public class AssigmentAspect extends StatementAspect {
  @OverrideAspectMethod
  @Step
  public static void evaluateStatement(final Assignment _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectContext
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
		manager.executeStep(_self, command, "Assignment", "evaluateStatement");
	} else {
		command.execute();
	}
	;
	;
}
  
  private static void super_evaluateStatement(final Assignment _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final AssigmentAspectAssignmentAspectProperties _self_, final Assignment _self, final State state) {
    try {
      final Context context = StateAspect.findCurrentContext(state);
      final Value right = ExpressionAspect.evaluateExpression(_self.getValue(), state);
      final Assignee assignee = _self.getAssignee();
      boolean _matched = false;
      if (assignee instanceof SymbolRef) {
        _matched=true;
        final SymbolBinding existingBinding = ContextAspect.findBinding(context, ((SymbolRef)assignee).getSymbol());
        existingBinding.setValue(right);
      }
      if (!_matched) {
        if (assignee instanceof VariableDeclaration) {
          _matched=true;
          SymbolBinding _createSymbolBinding = MiniJavaFactory.eINSTANCE.createSymbolBinding();
          final Procedure1<SymbolBinding> _function = (SymbolBinding it) -> {
            it.setSymbol(((Symbol)assignee));
            it.setValue(right);
          };
          final SymbolBinding binding = ObjectExtensions.<SymbolBinding>operator_doubleArrow(_createSymbolBinding, _function);
          context.getBindings().add(binding);
        }
      }
      if (!_matched) {
        if (assignee instanceof FieldAccess) {
          _matched=true;
          Field _field = ((FieldAccess)assignee).getField();
          final Field f = ((Field) _field);
          Value _evaluateExpression = ExpressionAspect.evaluateExpression(((FieldAccess)assignee).getReceiver(), state);
          final ObjectInstance realReceiver = ((ObjectRefValue) _evaluateExpression).getInstance();
          final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
            Field _field_1 = it.getField();
            return Boolean.valueOf((_field_1 == f));
          };
          final FieldBinding existingBinding = IterableExtensions.<FieldBinding>findFirst(realReceiver.getFieldbindings(), _function);
          if ((existingBinding != null)) {
            existingBinding.setValue(right);
          } else {
            FieldBinding _createFieldBinding = MiniJavaFactory.eINSTANCE.createFieldBinding();
            final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
              it.setField(f);
              it.setValue(right);
            };
            final FieldBinding binding = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
            realReceiver.getFieldbindings().add(binding);
          }
        }
      }
      if (!_matched) {
        if (assignee instanceof ArrayAccess) {
          _matched=true;
          Value _evaluateExpression = ExpressionAspect.evaluateExpression(((ArrayAccess)assignee).getObject(), state);
          final ArrayInstance array = ((ArrayRefValue) _evaluateExpression).getInstance();
          Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(((ArrayAccess)assignee).getIndex(), state);
          final int index = ((IntegerValue) _evaluateExpression_1).getValue();
          array.getValue().set(index, right);
        }
      }
      if (!_matched) {
        throw new Exception(("Cannot assign a value to " + assignee));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
