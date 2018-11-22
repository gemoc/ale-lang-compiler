package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Instruction;
import kmLogo.LogoProgram;
import kmLogo.Turtle;

public class LogoProgramOperation {
  private final LogoProgram it;

  private final EmfswitchSwitchImplementation emfswitch;

  public LogoProgramOperation(LogoProgram it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Turtle eval() {
    Turtle result;
    Turtle turtle = ((Turtle)((emfswitch.emfswitch.operation.LogoProgramOperation) emfswitch.doSwitch(this.it)).createTurtle());
    result = turtle;
    for(Instruction it: this.it.getInstructions()) {
      ((emfswitch.emfswitch.operation.InstructionOperation) emfswitch.doSwitch(it)).eval(turtle);
    }
    result = turtle;
    return result;
  }

  public Turtle createTurtle() {
    Turtle result;
    Turtle turtle = ((Turtle)kmLogo.KmLogoFactory.eINSTANCE.createTurtle());
    turtle.setPosition(kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(kmLogo.KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
