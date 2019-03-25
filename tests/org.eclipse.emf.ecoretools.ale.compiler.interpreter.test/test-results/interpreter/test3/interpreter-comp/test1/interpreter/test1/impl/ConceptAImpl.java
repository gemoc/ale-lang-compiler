package test1.interpreter.test1.impl;

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
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.interpreter.test1.ConceptA;
import test1.interpreter.test1.ConceptC;
import test1.interpreter.test1.Test1Package;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected EList<ConceptC> cs;

	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_A;
	}

	public EList<ConceptC> getCs() {
		if (cs == null) {
			cs = new EObjectContainmentEList<ConceptC>(ConceptC.class, this, Test1Package.CONCEPT_A__CS);
		}
		return cs;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				return ((InternalEList<?>) getCs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				return getCs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				getCs().clear();
				getCs().addAll((Collection<? extends ConceptC>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				getCs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				return cs != null && !cs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void exec() {
		LogService.log("ok");
		for (ConceptC c : this.getCs()) {
		  c.call();
		}
	}
}
