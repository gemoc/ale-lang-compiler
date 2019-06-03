package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.PenDown;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.PenDownOperation;

public class PenDownOperationImpl extends PrimitiveOperationImpl implements PenDownOperation {
	private final PenDown it;

	private final VisitorInterface vis;

	public PenDownOperationImpl(PenDown it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(false);
		result = 0.0;
		return result;
	}
}
