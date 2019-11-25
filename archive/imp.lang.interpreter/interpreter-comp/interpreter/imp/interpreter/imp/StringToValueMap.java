package interpreter.imp.interpreter.imp;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToValueMap extends EObject {
  String getKey();

  void setKey(String value);

  Value getValue();

  void setValue(Value value);
}
