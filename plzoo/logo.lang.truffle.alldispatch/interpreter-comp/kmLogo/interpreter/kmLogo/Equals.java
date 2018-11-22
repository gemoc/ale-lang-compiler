package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.EqualsDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Equals extends EObject, NodeInterface, BinaryExp {
  double eval(Turtle turtle);

  EqualsDispatchWrapperEval getCachedEval();
}
