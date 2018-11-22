package interpreter.boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Def extends EObject, TopLevelCmd {
  String getName();

  void setName(String value);

  Expr getExpr();

  void setExpr(Expr value);

  void nextLine(Ctx ctx);
}
