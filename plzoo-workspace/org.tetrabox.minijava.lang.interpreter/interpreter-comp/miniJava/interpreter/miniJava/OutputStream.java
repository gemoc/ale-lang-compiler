package miniJava.interpreter.miniJava;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface OutputStream extends EObject {
  String getStream();

  void setStream(String value);
}
