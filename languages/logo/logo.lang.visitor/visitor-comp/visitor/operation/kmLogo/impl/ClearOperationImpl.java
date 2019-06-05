package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Clear;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ClearOperation;

public class ClearOperationImpl extends PrimitiveOperationImpl implements ClearOperation {
	private final Clear it;

	private final VisitorInterface vis;

	public ClearOperationImpl(Clear it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((Double) (0.0));
		return result;
	}
}
