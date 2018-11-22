package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.LowerDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Lower extends EObject, NodeInterface, BinaryExp {
  double eval(Turtle turtle);

  LowerDispatchWrapperEval getCachedEval();
}
