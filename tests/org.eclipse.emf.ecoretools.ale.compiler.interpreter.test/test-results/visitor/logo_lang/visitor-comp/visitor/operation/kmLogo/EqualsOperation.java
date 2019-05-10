package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface EqualsOperation extends BinaryExpOperation {
	double eval(Turtle turtle);
}
