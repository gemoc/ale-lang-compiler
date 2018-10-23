package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Forward extends EObject, Primitive {
  Expression getSteps();

  void setSteps(Expression steps);

  double eval(Turtle turtle);
}
