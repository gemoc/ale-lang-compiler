package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToValueMap extends EObject, NodeInterface {
  String getKey();

  void setKey(String value);

  Value getValue();

  void setValue(Value value);
}
