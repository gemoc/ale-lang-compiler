package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Field extends EObject, NodeInterface {
  String getName();

  void setName(String value);

  Expr getValue();

  void setValue(Expr value);
}
