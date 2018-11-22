package boa.interpreter.boa;

import boa.interpreter.boa.impl.WithDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface With extends EObject, NodeInterface, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);

  WithDispatchWrapperEval getCachedEval();
}
