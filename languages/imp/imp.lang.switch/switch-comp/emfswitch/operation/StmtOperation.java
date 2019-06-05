package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Stmt;
import imp.model.imp.Store;

public class StmtOperation {
	private final Stmt it;

	private final SwitchImplementation emfswitch;

	public StmtOperation(Stmt it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		return result;
	}
}
