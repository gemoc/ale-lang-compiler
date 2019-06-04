package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.FieldBinding;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class FieldAccessOperation extends ExpressionOperation {
	private final FieldAccess it;

	private final SwitchImplementation emfswitch;

	public FieldAccessOperation(FieldAccess it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectRefValue tmp0 = ((ObjectRefValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getReceiver())).evaluateExpression((State) (state))));
		ObjectInstance realReceiver = ((ObjectInstance) (tmp0.getInstance()));
		Field fld = ((Field) (this.it.getField()));
		FieldBinding fb = ((FieldBinding) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (fld))))));
		result = ((Value) (fb.getValue()));
		return result;
	}
}
