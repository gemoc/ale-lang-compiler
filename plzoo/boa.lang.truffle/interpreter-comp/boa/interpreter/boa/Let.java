package boa.interpreter.boa;

import boa.interpreter.boa.impl.LetDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Let extends EObject, NodeInterface, Expr {
  String getName();

  void setName(String value);

  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);

  LetDispatchWrapperEval getCachedEval();
}
