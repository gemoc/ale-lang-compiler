package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Boolean;
import miniJava.TypeRef;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class TypeRefOperation {
	private final TypeRef it;

	private final SwitchImplementation emfswitch;

	public TypeRefOperation(TypeRef it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public boolean compare(TypeRef other) {
		boolean result;
		result = ((Boolean) (EqualService.equals((this.it.eClass()), (other.eClass()))));
		return result;
	}
}
