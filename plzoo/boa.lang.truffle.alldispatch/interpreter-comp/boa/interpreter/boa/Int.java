package boa.interpreter.boa;

import boa.interpreter.boa.impl.IntDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Int extends EObject, NodeInterface, Expr {
  int getValue();

  void setValue(int value);

  EvalRes eval(Ctx ctx);

  IntDispatchWrapperEval getCachedEval();
}
