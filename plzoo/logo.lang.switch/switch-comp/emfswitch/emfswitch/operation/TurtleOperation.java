package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Point;
import kmLogo.Segment;
import kmLogo.Turtle;

public class TurtleOperation {
  private final Turtle it;

  private final EmfswitchSwitchImplementation emfswitch;

  public TurtleOperation(Turtle it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void move(double dx, double dy) {
    Point newPos = ((Point)kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPos.setX((this.it.getPosition().getX()) + (dx));
    newPos.setY((this.it.getPosition().getY()) + (dy));
    if(this.it.isPenUp()) {
    }
    else {
      Segment newSegment = ((Segment)kmLogo.KmLogoFactory.eINSTANCE.createSegment());
      newSegment.setBegin(this.it.getPosition());
      newSegment.setEnd(newPos);
      this.it.getDrawings().add(newSegment);
    }
    Point newPosCopy = ((Point)kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPosCopy.setX(newPos.getX());
    newPosCopy.setY(newPos.getY());
    this.it.setPosition(newPosCopy);
  }

  public void forward(double steps) {
    ((emfswitch.emfswitch.operation.TurtleOperation) emfswitch.doSwitch(this.it)).move((steps) * (org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.cosinus(this.it.getHeading())),(steps) * (org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.sinus(this.it.getHeading())));
  }

  public void rotate(double angle) {
    double newAngle = ((double)(this.it.getHeading()) + (angle));
    if((newAngle) > (360.0)) {
      newAngle = (newAngle) - (360.0);
      this.it.setHeading(newAngle);
    }
    else {
      if((newAngle) < (0.0)) {
        newAngle = (360.0) + (newAngle);
        this.it.setHeading(newAngle);
      }
      else {
        this.it.setHeading(newAngle);
      }
    }
  }
}
