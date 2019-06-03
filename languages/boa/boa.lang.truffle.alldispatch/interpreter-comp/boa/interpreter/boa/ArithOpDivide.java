package boa.interpreter.boa;

import boa.interpreter.boa.impl.ArithOpDivideDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpDivide extends EObject, NodeInterface, ArithOp {
  EvalRes eval(Ctx ctx);

  ArithOpDivideDispatchWrapperEval getCachedEval();
}
