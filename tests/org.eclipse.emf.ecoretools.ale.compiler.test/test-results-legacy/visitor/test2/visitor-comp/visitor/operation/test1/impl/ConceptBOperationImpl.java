package visitor.operation.test1.impl;

import java.lang.Integer;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.visitor.test1.ConceptB;
import visitor.VisitorInterface;
import visitor.operation.test1.ConceptBOperation;

public class ConceptBOperationImpl extends ConceptAOperationImpl implements ConceptBOperation {
	private final ConceptB it;

	private final VisitorInterface vis;

	public ConceptBOperationImpl(ConceptB it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void exec() {
		LogService.log("okb");
	}

	public int execB() {
		int result;
		result = ((Integer) (1));
		return result;
	}
}
