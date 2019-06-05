package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.BoolValue;
import imp.model.imp.Store;
import imp.model.imp.Value;
import imp.model.imp.While;
import java.lang.Boolean;

public class WhileOperation extends StmtOperation {
	private final While it;

	private final SwitchImplementation emfswitch;

	public WhileOperation(While it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		boolean stop = ((boolean) (false));
		Store tmp = ((Store) (s));
		while (!(stop)) {
			Value conde = ((Value) (((ExprOperation) emfswitch.doSwitch(this.it.getCond())).evaluate((Store) (s))));
			if(conde instanceof BoolValue) {
				BoolValue condeb = ((BoolValue) (conde));
				if(condeb.isValue()) {
					tmp = ((Store) (((StmtOperation) emfswitch.doSwitch(this.it.getBody())).execute((Store) (tmp))));
				}
				else {
					stop = ((Boolean) (true));
				}
			}
			else {
				stop = ((Boolean) (true));
			}
		}
		result = ((Store) (tmp));
		return result;
	}
}
