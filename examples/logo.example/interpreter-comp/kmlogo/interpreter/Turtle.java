package kmlogo.interpreter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Turtle extends EObject {
  double getHeading();

  void setHeading(double heading);

  boolean getPenUp();

  void setPenUp(boolean penUp);

  Point getPosition();

  void setPosition(Point position);

  EList<Segment> getDrawings();

  CallStack getCallStack();

  void setCallStack(CallStack callStack);

  void move(double dx, double dy);

  void forward(double steps);

  void rotate(double angle);
}
