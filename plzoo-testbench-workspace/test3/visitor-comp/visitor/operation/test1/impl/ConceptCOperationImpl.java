package visitor.operation.test1.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.visitor.test1.ConceptC;
import visitor.VisitorInterface;
import visitor.operation.test1.ConceptCOperation;

public class ConceptCOperationImpl implements ConceptCOperation {
	private final ConceptC it;

	private final VisitorInterface vis;

	public ConceptCOperationImpl(ConceptC it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void call() {
		LogService.log(this.it.getNbr());
	}
}
