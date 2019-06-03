package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface TanOperation extends UnaryExpressionOperation {
	double eval(Turtle turtle);
}
