package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Variable extends EObject, NodeInterface {
  String getName();

  void setName(String value);

  double getValue();

  void setValue(double value);
}
