package visitor.operation.functioncall.impl;

import functioncall.visitor.functioncall.ConceptB;
import functioncall.visitor.functioncall.FunctioncallFactory;
import visitor.VisitorInterface;
import visitor.operation.functioncall.ConceptBOperation;

public class ConceptBOperationImpl extends ConceptAOperationImpl implements ConceptBOperation {
	private final ConceptB it;

	private final VisitorInterface vis;

	public ConceptBOperationImpl(ConceptB it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public ConceptB fct2() {
		ConceptB result;
		result = FunctioncallFactory.eINSTANCE.createConceptB();
		return result;
	}
}
