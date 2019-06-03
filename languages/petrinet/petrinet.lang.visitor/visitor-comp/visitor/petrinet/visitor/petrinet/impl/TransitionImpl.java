package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.petrinet.visitor.petrinet.Transition;
import visitor.visitor.VisitorInterface;

public class TransitionImpl extends NodeImpl implements Transition {
	protected TransitionImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return PetrinetPackage.Literals.TRANSITION;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitpetrinet__Transition(this);
	}
}
