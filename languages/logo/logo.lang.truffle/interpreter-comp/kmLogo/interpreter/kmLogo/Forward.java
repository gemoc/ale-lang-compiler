package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Forward extends EObject, NodeInterface, Primitive {
  Expression getSteps();

  void setSteps(Expression value);

  double eval(Turtle turtle);
}
