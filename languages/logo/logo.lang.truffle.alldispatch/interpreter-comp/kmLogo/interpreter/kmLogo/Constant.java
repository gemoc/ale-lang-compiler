package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.ConstantDispatchWrapperEval;
import org.eclipse.emf.ecore.EObject;

public interface Constant extends EObject, NodeInterface, Expression {
  double getValue();

  void setValue(double value);

  double eval(Turtle turtle);

  ConstantDispatchWrapperEval getCachedEval();
}
