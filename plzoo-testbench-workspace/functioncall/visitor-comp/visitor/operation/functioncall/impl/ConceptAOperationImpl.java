package visitor.operation.functioncall.impl;

import functioncall.visitor.functioncall.ConceptA;
import visitor.VisitorInterface;
import visitor.operation.functioncall.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void fct1() {
	}

	public ConceptA fct2() {
		ConceptA result;
		result = functioncall.visitor.functioncall.FunctioncallFactory.eINSTANCE.createConceptA();
		return result;
	}
}
