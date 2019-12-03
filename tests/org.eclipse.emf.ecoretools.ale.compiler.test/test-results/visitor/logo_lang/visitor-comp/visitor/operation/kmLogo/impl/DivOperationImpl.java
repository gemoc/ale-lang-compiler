package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Div;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.DivOperation;
import visitor.operation.kmLogo.ExpressionOperation;

public class DivOperationImpl extends BinaryExpOperationImpl implements DivOperation {
	private final Div it;

	private final VisitorInterface vis;

	public DivOperationImpl(Div it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		if(!EqualService.equals((((ExpressionOperation)this.it.getRhs().accept(vis)).eval((Turtle) (turtle))), (0.0))) {
			result = ((Double) ((((ExpressionOperation)this.it.getLhs().accept(vis)).eval((Turtle) (turtle))) / (((ExpressionOperation)this.it.getRhs().accept(vis)).eval((Turtle) (turtle)))));
		}
		else {
			result = ((Double) (0.0));
		}
		return result;
	}
}
