package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface If extends EObject, AcceptInterface, ControlStructure {
  Block getThenPart();

  void setThenPart(Block value);

  Block getElsePart();

  void setElsePart(Block value);
}
