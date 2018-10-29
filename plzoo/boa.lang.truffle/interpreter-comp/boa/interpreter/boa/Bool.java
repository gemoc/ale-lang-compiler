package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Bool extends EObject, NodeInterface, Expr {
  boolean isValue();

  void setValue(boolean value);

  EvalRes eval(Ctx ctx);
}
