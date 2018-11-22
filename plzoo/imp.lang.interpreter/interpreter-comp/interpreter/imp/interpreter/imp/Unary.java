package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface Unary extends EObject, Expr {
  UnaryOp getOp();

  void setOp(UnaryOp value);

  Expr getExpr();

  void setExpr(Expr value);
}
