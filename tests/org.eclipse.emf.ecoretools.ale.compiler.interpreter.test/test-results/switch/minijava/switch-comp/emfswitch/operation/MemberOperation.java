package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Member;

public class MemberOperation extends TypedDeclarationOperation {
	private final Member it;

	private final SwitchImplementation emfswitch;

	public MemberOperation(Member it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
