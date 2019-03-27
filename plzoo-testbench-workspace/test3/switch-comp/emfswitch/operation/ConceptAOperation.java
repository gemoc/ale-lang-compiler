package emfswitch.operation;

import emfswitch.SwitchImplementation;
import test1.ConceptA;
import test1.ConceptC;

public class ConceptAOperation {
	private final ConceptA it;

	private final SwitchImplementation emfswitch;

	public ConceptAOperation(ConceptA it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void exec() {
		org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("ok");
		for (ConceptC c: this.it.getCs()) {
			((emfswitch.operation.ConceptCOperation) emfswitch.doSwitch(c)).call();
		}
	}
}
