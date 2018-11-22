package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.BackDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Back extends EObject, NodeInterface, Primitive {
  Expression getSteps();

  void setSteps(Expression value);

  double eval(Turtle turtle);

  BackDispatchWrapperEval getCachedEval();
}
