package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface PenDownOperation extends PrimitiveOperation {
	double eval(Turtle turtle);
}
