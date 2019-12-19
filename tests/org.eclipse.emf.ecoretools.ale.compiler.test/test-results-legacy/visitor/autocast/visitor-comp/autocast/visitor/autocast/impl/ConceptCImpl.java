package autocast.visitor.autocast.impl;

import autocast.visitor.autocast.AutocastPackage;
import autocast.visitor.autocast.ConceptA;
import autocast.visitor.autocast.ConceptC;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	protected EList<ConceptA> ax;

	protected ConceptCImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return AutocastPackage.Literals.CONCEPT_C;
	}

	public EList<ConceptA> getAx() {
		if (ax == null) {
			ax = new EObjectContainmentEList<ConceptA>(ConceptA.class, this, AutocastPackage.CONCEPT_C__AX);
		}
		return ax;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case AutocastPackage.CONCEPT_C__AX :
				return ((InternalEList<?>) getAx()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AutocastPackage.CONCEPT_C__AX :
				return getAx();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AutocastPackage.CONCEPT_C__AX :
				getAx().clear();
				getAx().addAll((Collection<? extends ConceptA>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AutocastPackage.CONCEPT_C__AX :
				getAx().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AutocastPackage.CONCEPT_C__AX :
				return ax != null && !ax.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitautocast__ConceptC(this);
	}
}
