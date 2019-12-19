package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Right;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.RightOperation;
import visitor.operation.kmLogo.TurtleOperation;

public class RightOperationImpl extends PrimitiveOperationImpl implements RightOperation {
	private final Right it;

	private final VisitorInterface vis;

	public RightOperationImpl(Right it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		double angle = ((double) (((ExpressionOperation)this.it.getAngle().accept(vis)).eval((Turtle) (turtle))));
		((TurtleOperation)turtle.accept(vis)).rotate((Double) (-(angle)));
		result = ((Double) (0.0));
		return result;
	}
}
