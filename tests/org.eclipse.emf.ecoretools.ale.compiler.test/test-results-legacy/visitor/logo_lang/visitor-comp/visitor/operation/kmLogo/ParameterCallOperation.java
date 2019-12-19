package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ParameterCallOperation extends ExpressionOperation {
	double eval(Turtle turtle);
}
