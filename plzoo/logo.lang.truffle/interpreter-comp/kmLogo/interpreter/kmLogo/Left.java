package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Left extends EObject, NodeInterface, Primitive {
  Expression getAngle();

  void setAngle(Expression value);

  double eval(Turtle turtle);
}
