package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Parameter;
import miniJava.TypeRef;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class ParameterOperation extends SymbolOperation {
	private final Parameter it;

	private final SwitchImplementation emfswitch;

	public ParameterOperation(Parameter it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public boolean compare(Parameter other) {
		boolean result;
		result = ((EqualService.equals((this.it.getName()), (other.getName()))) && (((TypeRefOperation) emfswitch.doSwitch(this.it.getTypeRef())).compare((TypeRef) (other.getTypeRef()))));
		return result;
	}
}
