package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ProcCall extends EObject, Expression {
  EList<Expression> getActualArgs();

  ProcDeclaration getDeclaration();

  void setDeclaration(ProcDeclaration value);

  double eval(Turtle turtle);
}
