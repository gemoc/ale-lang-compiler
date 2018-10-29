package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, NodeInterface, TopLevelCmd {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);
}
