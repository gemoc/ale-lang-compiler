package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.MinusDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Minus extends EObject, NodeInterface, BinaryExp {
  double eval(Turtle turtle);

  MinusDispatchWrapperEval getCachedEval();
}
