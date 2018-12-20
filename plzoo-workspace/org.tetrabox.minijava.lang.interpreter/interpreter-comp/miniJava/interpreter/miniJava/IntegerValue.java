package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface IntegerValue extends EObject,  Value {
  int getValue();

  void setValue(int value);

  String customToString();

  Value copyj();
}
