package boa.interpreter.boa;

import boa.interpreter.boa.impl.ArithOpPlusDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpPlus extends EObject, NodeInterface, ArithOp {
  EvalRes eval(Ctx ctx);

  ArithOpPlusDispatchWrapperEval getCachedEval();
}
