package kmlogo.interpreter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ProcCall extends EObject, Expression {
  EList<Expression> getActualArgs();

  ProcDeclaration getDeclaration();

  void setDeclaration(ProcDeclaration declaration);

  double eval(Turtle turtle);
}
