package boa.interpreter.boa;

import boa.interpreter.boa.impl.FunDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Fun extends EObject, NodeInterface, Expr {
  String getName();

  void setName(String value);

  Expr getBody();

  void setBody(Expr value);

  EvalRes eval(Ctx ctx);

  FunDispatchWrapperEval getCachedEval();
}
