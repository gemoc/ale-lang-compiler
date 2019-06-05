package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Skip;
import imp.model.imp.Store;

public class SkipOperation extends StmtOperation {
	private final Skip it;

	private final SwitchImplementation emfswitch;

	public SkipOperation(Skip it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		return result;
	}
}
