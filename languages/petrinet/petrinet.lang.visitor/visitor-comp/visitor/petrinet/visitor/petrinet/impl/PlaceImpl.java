package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.petrinet.visitor.petrinet.Place;
import visitor.visitor.VisitorInterface;

public class PlaceImpl extends NodeImpl implements Place {
	protected static final int TOKENNB_EDEFAULT = 0;

	protected int tokenNb = TOKENNB_EDEFAULT;

	protected PlaceImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return PetrinetPackage.Literals.PLACE;
	}

	public int getTokenNb() {
		return tokenNb;
	}

	public void setTokenNb(int newTokenNb) {
		int oldTokenNb = tokenNb;
		tokenNb = newTokenNb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetrinetPackage.PLACE__TOKEN_NB, oldTokenNb, tokenNb));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetrinetPackage.PLACE__TOKEN_NB :
				return getTokenNb();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetrinetPackage.PLACE__TOKEN_NB :
				setTokenNb((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PLACE__TOKEN_NB :
				setTokenNb(TOKENNB_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PLACE__TOKEN_NB :
				return tokenNb != TOKENNB_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitpetrinet__Place(this);
	}
}
