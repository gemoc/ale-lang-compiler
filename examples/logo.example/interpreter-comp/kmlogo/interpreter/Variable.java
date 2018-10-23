package kmlogo.interpreter;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Variable extends EObject {
  String getName();

  void setName(String name);

  double getValue();

  void setValue(double value);
}
