package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.PenDownDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface PenDown extends EObject, NodeInterface, Primitive {
  double eval(Turtle turtle);

  PenDownDispatchWrapperEval getCachedEval();
}
