package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Store;

public class StoreOperation {
	private final Store it;

	private final SwitchImplementation emfswitch;

	public StoreOperation(Store it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
