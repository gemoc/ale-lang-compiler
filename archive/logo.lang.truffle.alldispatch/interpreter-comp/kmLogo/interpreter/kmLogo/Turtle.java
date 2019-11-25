package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.TurtleDispatchWrapperForward;
import kmLogo.interpreter.kmLogo.impl.TurtleDispatchWrapperMove;
import kmLogo.interpreter.kmLogo.impl.TurtleDispatchWrapperRotate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Turtle extends EObject, NodeInterface {
  double getHeading();

  void setHeading(double value);

  boolean isPenUp();

  void setPenUp(boolean value);

  Point getPosition();

  void setPosition(Point value);

  EList<Segment> getDrawings();

  CallStack getCallStack();

  void setCallStack(CallStack value);

  void move(double dx, double dy);

  void forward(double steps);

  void rotate(double angle);

  TurtleDispatchWrapperMove getCachedMove();

  TurtleDispatchWrapperForward getCachedForward();

  TurtleDispatchWrapperRotate getCachedRotate();
}
