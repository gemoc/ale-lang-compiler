package boa.interpreter.boa;

import boa.interpreter.boa.impl.BoolOpAndDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface BoolOpAnd extends EObject, NodeInterface, BoolOp {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);

  BoolOpAndDispatchWrapperEval getCachedEval();
}
