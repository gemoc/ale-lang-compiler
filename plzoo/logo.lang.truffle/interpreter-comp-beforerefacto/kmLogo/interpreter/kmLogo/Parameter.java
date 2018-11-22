package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Parameter extends EObject, NodeInterface {
  String getName();

  void setName(String value);
}
