package visitor.boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Def extends EObject, AcceptInterface, TopLevelCmd {
  String getName();

  void setName(String value);

  Expr getExpr();

  void setExpr(Expr value);
}
