package emfswitch.operation;

import autocast.ConceptA;
import autocast.ConceptB;
import autocast.ConceptC;
import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ConceptCOperation {
	private final ConceptC it;

	private final SwitchImplementation emfswitch;

	public ConceptCOperation(ConceptC it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void execB(ConceptB b) {
		LogService.log(b.getName());
	}

	public void exec1() {
		for (ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				((ConceptCOperation) emfswitch.doSwitch(this.it)).execB((ConceptB) a);
			}
		}
	}

	public void exec2() {
		for (ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				ConceptB b = ((ConceptB)a);
				LogService.log(b.getName());
			}
		}
	}

	public void exec3() {
		for (ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				((ConceptBOperation) emfswitch.doSwitch(a)).callB();
			}
		}
	}
}
