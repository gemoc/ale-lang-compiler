package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Tan extends EObject, NodeInterface, UnaryExpression {
  double eval(Turtle turtle);
}
