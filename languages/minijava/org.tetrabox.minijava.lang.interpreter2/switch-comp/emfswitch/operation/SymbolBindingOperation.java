package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.SymbolBinding;

public class SymbolBindingOperation {
	private final SymbolBinding it;

	private final SwitchImplementation emfswitch;

	public SymbolBindingOperation(SymbolBinding it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
