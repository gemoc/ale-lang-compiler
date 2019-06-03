package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Sin extends EObject, NodeInterface, UnaryExpression {
  double eval(Turtle turtle);
}
