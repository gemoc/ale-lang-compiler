package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Store;
import imp.model.imp.Value;
import imp.model.imp.Var;
import java.lang.String;

public class VarOperation extends ExprOperation {
	private final Var it;

	private final SwitchImplementation emfswitch;

	public VarOperation(Var it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluate(Store s) {
		Value result;
		result = ((Value) (s.getValues().get((String) (this.it.getName()))));
		return result;
	}
}
