package miniJava.interpreter.miniJava;

import java.lang.String;
import miniJava.interpreter.miniJava.impl.StringValueDispatchWrapperCopyj;
import miniJava.interpreter.miniJava.impl.StringValueDispatchWrapperCustomToString;
import org.eclipse.emf.ecore.EObject;

public interface StringValue extends EObject, Value {
  String getValue();

  void setValue(String value);

  String customToString();

  Value copyj();

  StringValueDispatchWrapperCustomToString getCachedCustomToString();

  StringValueDispatchWrapperCopyj getCachedCopyj();
}
