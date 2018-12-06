package boa.interpreter.boa;

import boa.interpreter.boa.impl.BObjectDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface BObject extends EObject, NodeInterface, Expr {
  EList<Field> getFields();

  EvalRes eval(Ctx ctx);

  BObjectDispatchWrapperEval getCachedEval();
}
