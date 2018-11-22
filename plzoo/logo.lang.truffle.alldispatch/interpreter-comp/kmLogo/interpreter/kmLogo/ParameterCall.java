package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.ParameterCallDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface ParameterCall extends EObject, NodeInterface, Expression {
  Parameter getParameter();

  void setParameter(Parameter value);

  double eval(Turtle turtle);

  ParameterCallDispatchWrapperEval getCachedEval();
}
