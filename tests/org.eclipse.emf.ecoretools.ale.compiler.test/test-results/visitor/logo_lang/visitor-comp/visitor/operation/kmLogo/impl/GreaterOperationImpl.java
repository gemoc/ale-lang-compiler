package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Greater;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.GreaterOperation;

public class GreaterOperationImpl extends BinaryExpOperationImpl implements GreaterOperation {
	private final Greater it;

	private final VisitorInterface vis;

	public GreaterOperationImpl(Greater it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		if((((ExpressionOperation)this.it.getLhs().accept(vis)).eval((Turtle) (turtle))) > (((ExpressionOperation)this.it.getRhs().accept(vis)).eval((Turtle) (turtle)))) {
			result = 1.0;
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
