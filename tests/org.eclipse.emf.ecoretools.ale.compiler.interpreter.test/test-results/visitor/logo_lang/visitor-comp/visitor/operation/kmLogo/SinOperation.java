package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface SinOperation extends UnaryExpressionOperation {
	double eval(Turtle turtle);
}
