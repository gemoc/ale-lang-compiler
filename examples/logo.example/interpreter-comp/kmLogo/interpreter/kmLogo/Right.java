package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Right extends EObject, Primitive {
  Expression getAngle();

  void setAngle(Expression value);

  double eval(Turtle turtle);
}
