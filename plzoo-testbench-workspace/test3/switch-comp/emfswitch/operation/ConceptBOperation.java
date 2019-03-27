package emfswitch.operation;

import emfswitch.SwitchImplementation;
import test1.ConceptB;

public class ConceptBOperation extends ConceptAOperation {
	private final ConceptB it;

	private final SwitchImplementation emfswitch;

	public ConceptBOperation(ConceptB it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void exec() {
		org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("okb");
	}

	public int execB() {
		int result;
		result = 1;
		return result;
	}
}
