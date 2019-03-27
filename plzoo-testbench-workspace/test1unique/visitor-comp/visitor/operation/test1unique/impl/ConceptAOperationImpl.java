package visitor.operation.test1unique.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1unique.visitor.test1unique.ConceptA;
import visitor.VisitorInterface;
import visitor.operation.test1unique.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void exec() {
		LogService.log("ok");
	}
}
