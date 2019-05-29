package visitor.operation.test1.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.visitor.test1.ConceptA;
import visitor.VisitorInterface;
import visitor.operation.test1.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void exec() {
		LogService.log("ok");
		int a = ((int) (1));
		this.it.setB(42);
	}
}
