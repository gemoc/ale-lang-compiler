package emfswitch.operation;

import org.eclipse.emf.ecore.EOperation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayAccess;
import miniJava.ArrayInstance;
import miniJava.ArrayRefValue;
import miniJava.Assignee;
import miniJava.Assignment;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.FieldBinding;
import miniJava.IntegerValue;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.SymbolRef;
import miniJava.Value;
import miniJava.VariableDeclaration;

public class AssignmentOperation extends StatementOperation {
	private final Assignment it;

	private final SwitchImplementation emfswitch;

	public AssignmentOperation(Assignment it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		Context context = ((Context) /* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state))
				.findCurrentContext());
		Value right = ((Value) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getValue())).evaluateExpression(state));
		Assignee assignee = this.it.getAssignee();
		if (assignee instanceof miniJava.SymbolRef) {
			SymbolRef assigneeSymbolRef = ((SymbolRef) assignee);
			SymbolBinding existingBinding = ((SymbolBinding) /* CASEA */((emfswitch.operation.ContextOperation) emfswitch
					.doSwitch(context)).findBinding(assigneeSymbolRef.getSymbol()));
			/* CASEF */existingBinding.setValue(right);
		} else {
			if (assignee instanceof miniJava.VariableDeclaration) {
				VariableDeclaration assigneeVariableDeclaration = ((VariableDeclaration) assignee);
				SymbolBinding binding = ((SymbolBinding) miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
				binding.setSymbol(assigneeVariableDeclaration);
				binding.setValue(right);
				context.getBindings().add(binding);
			} else {
				if (assignee instanceof miniJava.FieldAccess) {
					FieldAccess assigneeFieldAccess = ((FieldAccess) assignee);
					Field f = ((Field) assigneeFieldAccess.getField());
					ObjectRefValue realReceiverValue = (ObjectRefValue) ((ExpressionOperation) emfswitch
							.caseExpression(assigneeFieldAccess.getReceiver())).evaluateExpression(state);
					ObjectInstance realReceiver = ((ObjectInstance) realReceiverValue.getInstance());
					FieldBinding existingBinding = ((FieldBinding) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
							.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(
									realReceiver.getFieldbindings(),
									(x) -> java.util.Objects.equals((x.getField()), (f)))));
					if (java.util.Objects.equals((existingBinding), (null))) {
						FieldBinding binding = ((FieldBinding) miniJava.MiniJavaFactory.eINSTANCE.createFieldBinding());
						binding.setField(f);
						binding.setValue(right);
						realReceiver.getFieldbindings().add(binding);
					} else {
						/* CASEF */existingBinding.setValue(right);
					}
				} else {
					if (assignee instanceof miniJava.ArrayAccess) {
						ArrayAccess assigneeArrayAccess = ((ArrayAccess) assignee);
						ArrayRefValue arrayRefValue = (ArrayRefValue) ((ExpressionOperation) emfswitch
								.caseExpression(assigneeArrayAccess.getObject())).evaluateExpression(state);
						ArrayInstance array = ((ArrayInstance) arrayRefValue.getInstance());
						IntegerValue integerValue = (IntegerValue) ((ExpressionOperation) emfswitch
								.caseExpression(assigneeArrayAccess.getIndex())).evaluateExpression(state);
						int index = ((int) integerValue.getValue());
						/* CASEF */array.getValue().set(index, right);
					} else {
					}
				}
			}
		}
	}
}
