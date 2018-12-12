package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface While extends EObject, NodeInterface, Stmt {
  Expr getCond();

  void setCond(Expr value);

  Stmt getBody();

  void setBody(Stmt value);

  Store execute(Store s);
}
