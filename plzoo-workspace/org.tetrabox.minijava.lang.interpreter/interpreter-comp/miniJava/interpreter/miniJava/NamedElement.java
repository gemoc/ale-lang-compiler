package miniJava.interpreter.miniJava;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface NamedElement extends EObject {
  String getName();

  void setName(String value);
}
