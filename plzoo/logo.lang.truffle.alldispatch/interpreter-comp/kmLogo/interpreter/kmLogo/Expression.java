package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.ExpressionDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Expression extends EObject, NodeInterface, Instruction {
  double eval(Turtle turtle);

  ExpressionDispatchWrapperEval getCachedEval();
}
