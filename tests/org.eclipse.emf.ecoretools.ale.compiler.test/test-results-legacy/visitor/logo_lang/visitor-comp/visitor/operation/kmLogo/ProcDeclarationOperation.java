package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ProcDeclarationOperation extends InstructionOperation {
	double eval(Turtle turtle);

	double deval(Turtle turtle);
}
