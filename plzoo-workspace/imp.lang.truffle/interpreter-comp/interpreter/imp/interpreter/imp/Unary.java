package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Unary extends EObject, NodeInterface, Expr {
  UnaryOp getOp();

  void setOp(UnaryOp value);

  Expr getExpr();

  void setExpr(Expr value);

  Value evaluate(Store s);
}
