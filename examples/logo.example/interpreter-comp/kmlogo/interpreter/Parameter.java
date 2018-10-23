package kmlogo.interpreter;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Parameter extends EObject {
  String getName();

  void setName(String name);
}
