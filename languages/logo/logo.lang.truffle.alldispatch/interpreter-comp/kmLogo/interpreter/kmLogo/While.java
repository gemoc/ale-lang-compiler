package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.WhileDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface While extends EObject, NodeInterface, ControlStructure {
  Block getBlock();

  void setBlock(Block value);

  double eval(Turtle turtle);

  WhileDispatchWrapperEval getCachedEval();
}
