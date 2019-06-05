package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.ImpFactory;
import imp.model.imp.IntConst;
import imp.model.imp.IntValue;
import imp.model.imp.Store;
import imp.model.imp.Value;

public class IntConstOperation extends ExprOperation {
	private final IntConst it;

	private final SwitchImplementation emfswitch;

	public IntConstOperation(IntConst it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluate(Store s) {
		Value result;
		IntValue tmp = ((IntValue) (ImpFactory.eINSTANCE.createIntValue()));
		tmp.setValue(this.it.getValue());
		result = ((IntValue) (tmp));
		return result;
	}
}
