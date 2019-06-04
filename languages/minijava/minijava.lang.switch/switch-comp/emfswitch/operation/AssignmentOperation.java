package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayAccess;
import miniJava.ArrayInstance;
import miniJava.ArrayRefValue;
import miniJava.Assignee;
import miniJava.Assignment;
import miniJava.Context;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.FieldBinding;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.Symbol;
import miniJava.SymbolBinding;
import miniJava.SymbolRef;
import miniJava.Value;
import miniJava.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class AssignmentOperation extends StatementOperation {
	private final Assignment it;

	private final SwitchImplementation emfswitch;

	public AssignmentOperation(Assignment it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		Context context = ((Context) (((StateOperation) emfswitch.doSwitch(state)).findCurrentContext()));
		Value right = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getValue())).evaluateExpression((State) (state))));
		Assignee assignee = ((Assignee) (this.it.getAssignee()));
		if(assignee instanceof SymbolRef) {
			SymbolRef assigneeSymbolRef = ((SymbolRef) (assignee));
			SymbolBinding existingBinding = ((SymbolBinding) (((ContextOperation) emfswitch.doSwitch(context)).findBinding((Symbol) (assigneeSymbolRef.getSymbol()))));
			existingBinding.setValue(right);
		}
		else {
			if(assignee instanceof VariableDeclaration) {
				VariableDeclaration assigneeVariableDeclaration = ((VariableDeclaration) (assignee));
				SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(assigneeVariableDeclaration);
				binding.setValue(right);
				context.getBindings().add(binding);
			}
			else {
				if(assignee instanceof FieldAccess) {
					FieldAccess assigneeFieldAccess = ((FieldAccess) (assignee));
					Field f = ((Field) (assigneeFieldAccess.getField()));
					ObjectRefValue realReceiverValue = ((ObjectRefValue) (((ObjectRefValue) (((ExpressionOperation) emfswitch.doSwitch(assigneeFieldAccess.getReceiver())).evaluateExpression((State) (state))))));
					ObjectInstance realReceiver = ((ObjectInstance) (realReceiverValue.getInstance()));
					FieldBinding existingBinding = ((FieldBinding) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (f))))));
					if(EqualService.equals((existingBinding), (null))) {
						FieldBinding binding = ((FieldBinding) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
						binding.setField(f);
						binding.setValue(right);
						realReceiver.getFieldbindings().add(binding);
					}
					else {
						existingBinding.setValue(right);
					}
				}
				else {
					if(assignee instanceof ArrayAccess) {
						ArrayAccess assigneeArrayAccess = ((ArrayAccess) (assignee));
						ArrayRefValue arrayRefValue = ((ArrayRefValue) (((ArrayRefValue) (((ExpressionOperation) emfswitch.doSwitch(assigneeArrayAccess.getObject())).evaluateExpression((State) (state))))));
						ArrayInstance array = ((ArrayInstance) (arrayRefValue.getInstance()));
						IntegerValue integerValue = ((IntegerValue) (((IntegerValue) (((ExpressionOperation) emfswitch.doSwitch(assigneeArrayAccess.getIndex())).evaluateExpression((State) (state))))));
						int index = ((int) (integerValue.getValue()));
						CollectionService.set(array.getValue(), index, right);
					}
					else {
					}
				}
			}
		}
	}
}
