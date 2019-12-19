package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Left;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.LeftOperation;
import visitor.operation.kmLogo.TurtleOperation;

public class LeftOperationImpl extends PrimitiveOperationImpl implements LeftOperation {
	private final Left it;

	private final VisitorInterface vis;

	public LeftOperationImpl(Left it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		double angle = ((double) (((ExpressionOperation)this.it.getAngle().accept(vis)).eval((Turtle) (turtle))));
		((TurtleOperation)turtle.accept(vis)).rotate((double) (angle));
		result = ((Double) (0.0));
		return result;
	}
}
