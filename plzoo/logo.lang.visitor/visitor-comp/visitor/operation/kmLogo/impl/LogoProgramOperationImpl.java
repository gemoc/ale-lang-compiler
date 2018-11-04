package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.LogoProgram;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
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
    long start = ((long)logo.example.service.TimeService.time(this.it));
    Turtle turtle = ((Turtle)((visitor.operation.kmLogo.LogoProgramOperation)this.it.accept(vis)).createTurtle());
    result = turtle;
    for(Instruction it: this.it.getInstructions()) {
      ((visitor.operation.kmLogo.InstructionOperation)it.accept(vis)).eval(turtle);
    }
    result = turtle;
    long stop = ((long)logo.example.service.TimeService.time(this.it));
    long time = ((long)(stop) - (start));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(time);
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(turtle.getDrawings()));
    logo.example.service.Display.show(turtle);
    return result;
  }

  public Turtle createTurtle() {
    Turtle result;
    Turtle turtle = ((Turtle)kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createTurtle());
    turtle.setPosition(kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
