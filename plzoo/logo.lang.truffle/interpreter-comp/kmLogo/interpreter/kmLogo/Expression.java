package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expression extends EObject, NodeInterface, Instruction {
  double eval(Turtle turtle);
}
