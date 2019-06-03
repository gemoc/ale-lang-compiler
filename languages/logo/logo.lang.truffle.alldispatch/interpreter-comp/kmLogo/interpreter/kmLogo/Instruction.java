package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.InstructionDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Instruction extends EObject, NodeInterface {
  double eval(Turtle turtle);

  InstructionDispatchWrapperEval getCachedEval();
}
