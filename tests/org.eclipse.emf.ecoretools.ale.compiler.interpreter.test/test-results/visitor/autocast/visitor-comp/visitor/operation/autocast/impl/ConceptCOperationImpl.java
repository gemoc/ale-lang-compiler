package visitor.operation.autocast.impl;

import autocast.visitor.autocast.ConceptA;
import autocast.visitor.autocast.ConceptB;
import autocast.visitor.autocast.ConceptC;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.autocast.ConceptCOperation;

public class ConceptCOperationImpl implements ConceptCOperation {
	private final ConceptC it;

	private final VisitorInterface vis;

	public ConceptCOperationImpl(ConceptC it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void execB(ConceptB b) {
		LogService.log(b.getName());
	}

	public void exec1() {
		for(ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				((ConceptCOperation)this.it.accept(vis)).execB((ConceptB)a);
			}
		}
	}

	public void exec2() {
		for(ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				ConceptB b = ((ConceptB)a);
				LogService.log(b.getName());
			}
		}
	}

	public void exec3() {
		for(ConceptA a: this.it.getAx()) {
			if(a instanceof ConceptB) {
				((ConceptBOperation)a.accept(vis)).callB();
			}
		}
	}
}
