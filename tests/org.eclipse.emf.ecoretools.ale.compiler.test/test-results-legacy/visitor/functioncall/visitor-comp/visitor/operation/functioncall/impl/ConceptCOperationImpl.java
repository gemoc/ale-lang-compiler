package visitor.operation.functioncall.impl;

import functioncall.visitor.functioncall.ConceptA;
import functioncall.visitor.functioncall.ConceptB;
import functioncall.visitor.functioncall.ConceptC;
import visitor.VisitorInterface;
import visitor.operation.functioncall.ConceptAOperation;
import visitor.operation.functioncall.ConceptBOperation;
import visitor.operation.functioncall.ConceptCOperation;

public class ConceptCOperationImpl implements ConceptCOperation {
	private final ConceptC it;

	private final VisitorInterface vis;

	public ConceptCOperationImpl(ConceptC it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void exec1() {
		((ConceptAOperation)this.it.getConcepta1().accept(vis)).fct1();
		ConceptA tmpA = ((ConceptA) (((ConceptAOperation)this.it.getConcepta1().accept(vis)).fct2()));
		((ConceptAOperation)this.it.getConcepta2().accept(vis)).fct1();
		ConceptA tmpB = ((ConceptA) (((ConceptAOperation)this.it.getConcepta2().accept(vis)).fct2()));
		((ConceptBOperation)this.it.getConceptb().accept(vis)).fct1();
		ConceptB tmpC = ((ConceptB) (((ConceptBOperation)this.it.getConceptb().accept(vis)).fct2()));
	}
}
