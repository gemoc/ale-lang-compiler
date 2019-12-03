package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Constant;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ConstantOperation;

public class ConstantOperationImpl extends ExpressionOperationImpl implements ConstantOperation {
	private final Constant it;

	private final VisitorInterface vis;

	public ConstantOperationImpl(Constant it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((double) (this.it.getValue()));
		return result;
	}
}
