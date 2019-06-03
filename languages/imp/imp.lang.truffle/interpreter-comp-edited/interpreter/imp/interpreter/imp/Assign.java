package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Assign extends EObject, NodeInterface, Stmt {
  String getName();

  void setName(String value);

  Expr getExp();

  void setExp(Expr value);

  Expr getIndex();

  void setIndex(Expr value);

  Store execute(Store s);
}
