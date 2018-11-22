package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Segment extends EObject, NodeInterface {
  Point getBegin();

  void setBegin(Point value);

  Point getEnd();

  void setEnd(Point value);
}
