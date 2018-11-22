package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.RightDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Right extends EObject, NodeInterface, Primitive {
  Expression getAngle();

  void setAngle(Expression value);

  double eval(Turtle turtle);

  RightDispatchWrapperEval getCachedEval();
}
