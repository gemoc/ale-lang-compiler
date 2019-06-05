package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.InstructionOperation;

public abstract class InstructionOperationImpl implements InstructionOperation {
	private final Instruction it;

	private final VisitorInterface vis;

	public InstructionOperationImpl(Instruction it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((Double) (0.0));
		return result;
	}
}
