package boa.interpreter.boa;

import boa.interpreter.boa.impl.NotDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, NodeInterface, Expr {
  Expr getValue();

  void setValue(Expr value);

  EvalRes eval(Ctx ctx);

  NotDispatchWrapperEval getCachedEval();
}
