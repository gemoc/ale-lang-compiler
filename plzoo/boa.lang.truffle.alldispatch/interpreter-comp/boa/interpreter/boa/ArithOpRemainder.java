package boa.interpreter.boa;

import boa.interpreter.boa.impl.ArithOpRemainderDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpRemainder extends EObject, NodeInterface, ArithOp {
  EvalRes eval(Ctx ctx);

  ArithOpRemainderDispatchWrapperEval getCachedEval();
}
