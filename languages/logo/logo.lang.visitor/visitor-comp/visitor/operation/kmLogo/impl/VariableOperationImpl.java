package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Variable;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.VariableOperation;

public class VariableOperationImpl implements VariableOperation {
	private final Variable it;

	private final VisitorInterface vis;

	public VariableOperationImpl(Variable it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
