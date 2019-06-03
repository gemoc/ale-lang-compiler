package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.ClearDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Clear extends EObject, NodeInterface, Primitive {
  double eval(Turtle turtle);

  ClearDispatchWrapperEval getCachedEval();
}
