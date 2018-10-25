package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface ParameterCall extends EObject, Expression {
  Parameter getParameter();

  void setParameter(Parameter value);

  double eval(Turtle turtle);
}
