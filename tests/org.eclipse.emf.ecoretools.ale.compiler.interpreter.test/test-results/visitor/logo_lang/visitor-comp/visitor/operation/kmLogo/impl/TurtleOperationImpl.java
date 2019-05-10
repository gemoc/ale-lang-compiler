package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.KmLogoFactory;
import kmLogo.visitor.kmLogo.Point;
import kmLogo.visitor.kmLogo.Segment;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.TurtleOperation;

public class TurtleOperationImpl implements TurtleOperation {
	private final Turtle it;

	private final VisitorInterface vis;

	public TurtleOperationImpl(Turtle it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
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
		((TurtleOperation)this.it.accept(vis)).move((Double) ((steps) * (TrigoServices.cosinus(this.it.getHeading()))), (Double) ((steps) * (TrigoServices.sinus(this.it.getHeading()))));
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
