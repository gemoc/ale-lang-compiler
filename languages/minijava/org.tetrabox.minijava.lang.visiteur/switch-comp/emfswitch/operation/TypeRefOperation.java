package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.TypeRef;

public class TypeRefOperation {
	private final TypeRef it;

	private final SwitchImplementation emfswitch;

	public TypeRefOperation(TypeRef it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public boolean compare(TypeRef other) {
		boolean result;
		result = java.util.Objects.equals((/* CASEC */this.it.eClass()), (/* CASEC */other.eClass()));
		return result;
	}
}
