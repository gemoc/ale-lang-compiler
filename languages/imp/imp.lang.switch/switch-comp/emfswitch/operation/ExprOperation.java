package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Expr;
import imp.model.imp.ImpFactory;
import imp.model.imp.IntValue;
import imp.model.imp.Store;
import imp.model.imp.Value;

public class ExprOperation {
	private final Expr it;

	private final SwitchImplementation emfswitch;

	public ExprOperation(Expr it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluate(Store s) {
		Value result;
		result = ((IntValue) (ImpFactory.eINSTANCE.createIntValue()));
		return result;
	}
}
