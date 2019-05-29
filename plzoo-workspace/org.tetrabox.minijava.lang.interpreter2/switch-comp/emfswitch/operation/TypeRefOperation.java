package emfswitch.operation;

import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

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
		result = EqualService.equals((this.it.eClass()), (other.eClass()));
		return result;
	}
}
