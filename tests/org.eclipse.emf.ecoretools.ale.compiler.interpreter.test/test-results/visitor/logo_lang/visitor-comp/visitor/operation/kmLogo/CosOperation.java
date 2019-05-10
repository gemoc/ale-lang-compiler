package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface CosOperation extends UnaryExpressionOperation {
	double eval(Turtle turtle);
}
