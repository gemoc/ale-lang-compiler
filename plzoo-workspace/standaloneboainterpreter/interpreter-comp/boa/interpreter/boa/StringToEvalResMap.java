package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToEvalResMap extends EObject, NodeInterface {
  String getKey();

  void setKey(String value);

  EvalRes getValue();

  void setValue(EvalRes value);
}
