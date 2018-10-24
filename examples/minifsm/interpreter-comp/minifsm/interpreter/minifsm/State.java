package minifsm.interpreter.minifsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface State extends EObject {
  String getName();

  void setName(String value);

  void execute();
}
