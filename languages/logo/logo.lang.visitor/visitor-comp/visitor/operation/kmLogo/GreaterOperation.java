package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface GreaterOperation extends BinaryExpOperation {
	double eval(Turtle turtle);
}
