package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Point extends EObject {
  double getX();

  void setX(double value);

  double getY();

  void setY(double value);
}
