package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.MultDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Mult extends EObject, NodeInterface, BinaryExp {
  double eval(Turtle turtle);

  MultDispatchWrapperEval getCachedEval();
}
