package kmLogo.visitor.kmLogo;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Variable extends EObject, AcceptInterface {
  String getName();

  void setName(String value);

  double getValue();

  void setValue(double value);
}
