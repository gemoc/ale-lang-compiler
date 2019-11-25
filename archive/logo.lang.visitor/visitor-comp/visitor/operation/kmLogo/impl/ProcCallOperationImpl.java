package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.ProcCall;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Turtle;
import kmLogo.visitor.kmLogo.Variable;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ProcCallOperation;

public class ProcCallOperationImpl extends ExpressionOperationImpl implements ProcCallOperation {
  private final ProcCall it;

  private final VisitorInterface vis;

  public ProcCallOperationImpl(ProcCall it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Calling ") + (this.it.getDeclaration().getName()));
    StackFrame newFrame = ((StackFrame)kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    int i = ((int)1);
    for(Expression exp: this.it.getActualArgs()) {
      Variable newVar = ((Variable)kmLogo.visitor.kmLogo.KmLogoFactory.eINSTANCE.createVariable());
      newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.it.getDeclaration().getArgs(), i).getName());
      newVar.setValue(((visitor.operation.kmLogo.ExpressionOperation)exp.accept(vis)).eval(turtle));
      newFrame.getVariables().add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    if(this.it.getDeclaration() instanceof kmLogo.visitor.kmLogo.ProcDeclaration) {
      ProcDeclaration decl = ((ProcDeclaration)this.it.getDeclaration());
      ((visitor.operation.kmLogo.ProcDeclarationOperation)decl.accept(vis)).eval(turtle);
    }
    turtle.getCallStack().getFrames().remove(newFrame);
    return result;
  }
}
