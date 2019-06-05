package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.BoolValue;
import imp.model.imp.If;
import imp.model.imp.Store;
import imp.model.imp.Value;

public class IfOperation extends StmtOperation {
	private final If it;

	private final SwitchImplementation emfswitch;

	public IfOperation(If it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		Value conde = ((Value) (((ExprOperation) emfswitch.doSwitch(this.it.getCond())).evaluate((Store) (s))));
		result = ((Store) (s));
		if(conde instanceof BoolValue) {
			BoolValue condeb = ((BoolValue) (conde));
			if(condeb.isValue()) {
				result = ((Store) (((StmtOperation) emfswitch.doSwitch(this.it.getLhs())).execute((Store) (s))));
			}
			else {
				result = ((Store) (((StmtOperation) emfswitch.doSwitch(this.it.getRhs())).execute((Store) (s))));
			}
		}
		return result;
	}
}
