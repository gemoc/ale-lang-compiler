package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Block;
import imp.model.imp.Stmt;
import imp.model.imp.Store;

public class BlockOperation extends StmtOperation {
	private final Block it;

	private final SwitchImplementation emfswitch;

	public BlockOperation(Block it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		for (Stmt e: this.it.getStmts()) {
			result = ((Store) (((StmtOperation) emfswitch.doSwitch(e)).execute((Store) (result))));
		}
		return result;
	}
}
