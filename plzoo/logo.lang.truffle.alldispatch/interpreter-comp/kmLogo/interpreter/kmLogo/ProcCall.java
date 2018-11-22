package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.ProcCallDispatchWrapperEval;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ProcCall extends EObject, NodeInterface, Expression {
  EList<Expression> getActualArgs();

  ProcDeclaration getDeclaration();

  void setDeclaration(ProcDeclaration value);

  double eval(Turtle turtle);

  ProcCallDispatchWrapperEval getCachedEval();
}
