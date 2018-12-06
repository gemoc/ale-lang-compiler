package boa.interpreter.boa;

import boa.interpreter.boa.impl.ArithOpMinusDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpMinus extends EObject, NodeInterface, ArithOp {
  EvalRes eval(Ctx ctx);

  ArithOpMinusDispatchWrapperEval getCachedEval();
}
