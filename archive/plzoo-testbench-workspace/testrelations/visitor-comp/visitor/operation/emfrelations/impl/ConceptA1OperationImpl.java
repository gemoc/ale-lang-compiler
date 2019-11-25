package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA1;
import emfrelations.visitor.emfrelations.ConceptB1;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA1Operation;

public class ConceptA1OperationImpl implements ConceptA1Operation {
	private final ConceptA1 it;

	private final VisitorInterface vis;

	public ConceptA1OperationImpl(ConceptA1 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void logBS() {
		for(ConceptB1 b1: this.it.getConceptb1()) {
			LogService.log(b1);
		}
	}
}
