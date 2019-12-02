package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ConstantOperation extends ExpressionOperation {
	double eval(Turtle turtle);
}
