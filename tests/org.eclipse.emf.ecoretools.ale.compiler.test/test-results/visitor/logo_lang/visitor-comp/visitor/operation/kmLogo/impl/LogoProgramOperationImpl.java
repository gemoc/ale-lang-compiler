package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.KmLogoFactory;
import kmLogo.visitor.kmLogo.LogoProgram;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.InstructionOperation;
import visitor.operation.kmLogo.LogoProgramOperation;

public class LogoProgramOperationImpl implements LogoProgramOperation {
	private final LogoProgram it;

	private final VisitorInterface vis;

	public LogoProgramOperationImpl(LogoProgram it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public Turtle eval() {
		Turtle result;
		Turtle turtle = ((Turtle) (((LogoProgramOperation)this.it.accept(vis)).createTurtle()));
		result = ((Turtle) (turtle));
		for(Instruction it: this.it.getInstructions()) {
			((InstructionOperation)it.accept(vis)).eval((Turtle) (turtle));
		}
		result = ((Turtle) (turtle));
		return result;
	}

	public Turtle createTurtle() {
		Turtle result;
		Turtle turtle = ((Turtle) (KmLogoFactory.eINSTANCE.createTurtle()));
		turtle.setPosition(KmLogoFactory.eINSTANCE.createPoint());
		turtle.getPosition().setX(0.0);
		turtle.getPosition().setY(0.0);
		turtle.setCallStack(KmLogoFactory.eINSTANCE.createCallStack());
		turtle.getCallStack().getFrames().add(KmLogoFactory.eINSTANCE.createStackFrame());
		result = ((Turtle) (turtle));
		return result;
	}
}
