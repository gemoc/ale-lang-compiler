package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Cos;
import kmLogo.Turtle;

public class CosOperation extends UnaryExpressionOperation {
  private final Cos it;

  private final EmfswitchSwitchImplementation emfswitch;

  public CosOperation(Cos it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.cosinus(((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval(turtle));
    return result;
  }
}
