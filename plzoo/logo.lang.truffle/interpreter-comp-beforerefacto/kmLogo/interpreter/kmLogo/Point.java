package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Point extends EObject, NodeInterface {
  double getX();

  void setX(double value);

  double getY();

  void setY(double value);
}
