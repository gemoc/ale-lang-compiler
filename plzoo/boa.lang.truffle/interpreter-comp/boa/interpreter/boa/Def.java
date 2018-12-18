package boa.interpreter.boa;

import boa.interpreter.boa.impl.DefDispatchWrapperNextLine;
import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Def extends EObject, NodeInterface, TopLevelCmd {
  String getName();

  void setName(String value);

  Expr getExpr();

  void setExpr(Expr value);

  void nextLine(Ctx ctx);

  DefDispatchWrapperNextLine getCachedNextLine();
}
