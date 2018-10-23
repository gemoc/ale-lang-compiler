package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Left extends EObject, Primitive {
  Expression getAngle();

  void setAngle(Expression angle);

  double eval(Turtle turtle);
}
