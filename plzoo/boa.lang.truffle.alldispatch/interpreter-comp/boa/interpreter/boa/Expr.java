package boa.interpreter.boa;

import boa.interpreter.boa.impl.ExprDispatchWrapperEval;
import boa.interpreter.boa.impl.ExprDispatchWrapperNextLine;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, NodeInterface, TopLevelCmd {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);

  ExprDispatchWrapperEval getCachedEval();

  ExprDispatchWrapperNextLine getCachedNextLine();
}
