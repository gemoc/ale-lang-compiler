package test.impl.operation;

import kmLogo.Turtle;

public interface ProcDeclarationOp extends InstructionOp {
	double eval(Turtle turtle);

	double deval(Turtle turtle);
}
