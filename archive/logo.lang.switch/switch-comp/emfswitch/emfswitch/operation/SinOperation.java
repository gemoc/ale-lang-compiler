package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Sin;
import kmLogo.Turtle;

public class SinOperation extends UnaryExpressionOperation {
  private final Sin it;

  private final EmfswitchSwitchImplementation emfswitch;

  public SinOperation(Sin it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = /*CASED*/org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.sinus(/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval(turtle));
    return result;
  }
}
