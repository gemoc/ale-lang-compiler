package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Expression;
import kmLogo.ProcCall;
import kmLogo.ProcDeclaration;
import kmLogo.StackFrame;
import kmLogo.Turtle;
import kmLogo.Variable;

public class ProcCallOperation extends ExpressionOperation {
  private final ProcCall it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ProcCallOperation(ProcCall it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Calling ") + (this.it.getDeclaration().getName()));
    StackFrame newFrame = ((StackFrame)kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    int i = ((int)1);
    for(Expression exp: this.it.getActualArgs()) {
      Variable newVar = ((Variable)kmLogo.KmLogoFactory.eINSTANCE.createVariable());
      newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.it.getDeclaration().getArgs(), i).getName());
      newVar.setValue(((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(exp)).eval(turtle));
      newFrame.getVariables().add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    if(this.it.getDeclaration() instanceof kmLogo.ProcDeclaration) {
      ProcDeclaration decl = ((ProcDeclaration)this.it.getDeclaration());
      ((emfswitch.emfswitch.operation.ProcDeclarationOperation) emfswitch.doSwitch(decl)).eval(turtle);
    }
    turtle.getCallStack().getFrames().remove(newFrame);
    return result;
  }
}
