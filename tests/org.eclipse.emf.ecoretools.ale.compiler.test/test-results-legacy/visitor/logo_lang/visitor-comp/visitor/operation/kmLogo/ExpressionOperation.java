package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ExpressionOperation extends InstructionOperation {
	double eval(Turtle turtle);
}
