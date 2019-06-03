package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.SinDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Sin extends EObject, NodeInterface, UnaryExpression {
  double eval(Turtle turtle);

  SinDispatchWrapperEval getCachedEval();
}
