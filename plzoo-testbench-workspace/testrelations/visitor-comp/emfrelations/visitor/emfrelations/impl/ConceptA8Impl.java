package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA8;
import emfrelations.visitor.emfrelations.ConceptB8;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptA8Impl extends MinimalEObjectImpl.Container implements ConceptA8 {
	protected ConceptB8 conceptb8;

	protected ConceptA8Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A8;
	}

	public void setConceptb8(ConceptB8 newConceptb8) {
		ConceptB8 oldConceptb8 = conceptb8;
		conceptb8 = newConceptb8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A8__CONCEPTB8, oldConceptb8, conceptb8));
	}

	public ConceptB8 getConceptb8() {
		if (conceptb8 != null && conceptb8.eIsProxy()) {
			InternalEObject oldConceptb8 = (InternalEObject) conceptb8;
			conceptb8 = (ConceptB8) eResolveProxy(oldConceptb8);
			if (conceptb8 != oldConceptb8) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_A8__CONCEPTB8,
							oldConceptb8, conceptb8));
			}
		}
		return conceptb8;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8 :
				if (resolve)
					return getConceptb8();
				return basicGetConceptb8();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8 :
				setConceptb8((ConceptB8) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8 :
				setConceptb8((ConceptB8) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8 :
				return conceptb8 != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptA8(this);
	}
}
