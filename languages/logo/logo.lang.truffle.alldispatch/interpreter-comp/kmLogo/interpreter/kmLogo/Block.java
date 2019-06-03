package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.BlockDispatchWrapperEval;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Block extends EObject, NodeInterface, Instruction {
  EList<Instruction> getInstructions();

  double eval(Turtle turtle);

  BlockDispatchWrapperEval getCachedEval();
}
