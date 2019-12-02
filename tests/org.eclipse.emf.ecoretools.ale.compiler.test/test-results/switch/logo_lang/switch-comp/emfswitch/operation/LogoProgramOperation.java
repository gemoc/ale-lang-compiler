package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Instruction;
import kmLogo.KmLogoFactory;
import kmLogo.LogoProgram;
import kmLogo.Turtle;

public class LogoProgramOperation {
	private final LogoProgram it;

	private final SwitchImplementation emfswitch;

	public LogoProgramOperation(LogoProgram it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Turtle eval() {
		Turtle result;
		Turtle turtle = ((Turtle) (((LogoProgramOperation) emfswitch.doSwitch(this.it)).createTurtle()));
		result = turtle;
		for (Instruction it: this.it.getInstructions()) {
			((InstructionOperation) emfswitch.doSwitch(it)).eval((Turtle) turtle);
		}
		result = turtle;
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
		result = turtle;
		return result;
	}
}
