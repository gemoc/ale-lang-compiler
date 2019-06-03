package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.PenUpDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface PenUp extends EObject, NodeInterface, Primitive {
  double eval(Turtle turtle);

  PenUpDispatchWrapperEval getCachedEval();
}
