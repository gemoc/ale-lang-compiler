package kmLogo.visitor.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Turtle extends EObject, AcceptInterface {
  double getHeading();

  void setHeading(double value);

  boolean isPenUp();

  void setPenUp(boolean value);

  Point getPosition();

  void setPosition(Point value);

  EList<Segment> getDrawings();

  CallStack getCallStack();

  void setCallStack(CallStack value);
}
