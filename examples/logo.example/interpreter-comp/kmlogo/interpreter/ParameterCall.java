package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface ParameterCall extends EObject, Expression {
  Parameter getParameter();

  void setParameter(Parameter parameter);

  double eval(Turtle turtle);
}
