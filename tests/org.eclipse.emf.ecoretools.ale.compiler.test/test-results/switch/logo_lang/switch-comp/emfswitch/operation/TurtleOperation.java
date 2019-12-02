package emfswitch.operation;

import emfswitch.KmLogoFactory;
import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Point;
import kmLogo.Segment;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class TurtleOperation {
	private final Turtle it;

	private final SwitchImplementation emfswitch;

	public TurtleOperation(Turtle it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void move(double dx, double dy) {
		Point newPos = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
		newPos.setX((this.it.getPosition().getX()) + (dx));
		newPos.setY((this.it.getPosition().getY()) + (dy));
		if(this.it.isPenUp()) {
		}
		else {
			Segment newSegment = ((Segment) (KmLogoFactory.eINSTANCE.createSegment()));
			newSegment.setBegin(this.it.getPosition());
			newSegment.setEnd(newPos);
			this.it.getDrawings().add(newSegment);
		}
		Point newPosCopy = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
		newPosCopy.setX(newPos.getX());
		newPosCopy.setY(newPos.getY());
		this.it.setPosition(newPosCopy);
	}

	public void forward(double steps) {
		((TurtleOperation) emfswitch.doSwitch(this.it)).move((Double) ((steps) * (TrigoServices.cosinus((double) (this.it.getHeading())))), (Double) ((steps) * (TrigoServices.sinus((double) (this.it.getHeading())))));
	}

	public void rotate(double angle) {
		double newAngle = ((double) ((this.it.getHeading()) + (angle)));
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
