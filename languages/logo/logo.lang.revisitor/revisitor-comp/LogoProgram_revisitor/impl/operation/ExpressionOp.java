package LogoProgram_revisitor.impl.operation;

import kmLogo.Turtle;

public interface ExpressionOp extends InstructionOp {
	double eval(Turtle turtle);
}
