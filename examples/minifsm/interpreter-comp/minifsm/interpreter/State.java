package minifsm.interpreter;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface State extends EObject {
  String getName();

  void setName(String name);

  void execute();
}
