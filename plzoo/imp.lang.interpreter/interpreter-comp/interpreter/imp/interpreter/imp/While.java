package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface While extends EObject, Stmt {
  Expr getCond();

  void setCond(Expr value);

  Stmt getBody();

  void setBody(Stmt value);

  Store execute(Store s);
}
