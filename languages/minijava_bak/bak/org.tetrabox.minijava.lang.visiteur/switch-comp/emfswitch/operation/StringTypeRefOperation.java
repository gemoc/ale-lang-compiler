package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.StringTypeRef;

public class StringTypeRefOperation extends SingleTypeRefOperation {
	private final StringTypeRef it;

	private final SwitchImplementation emfswitch;

	public StringTypeRefOperation(StringTypeRef it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
