package emfswitch.operation;

import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.ConceptC;

public class ConceptCOperation {
	private final ConceptC it;

	private final SwitchImplementation emfswitch;

	public ConceptCOperation(ConceptC it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void call() {
		LogService.log(this.it.getNbr());
	}
}
