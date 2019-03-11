package test1.interpreter.test1.impl;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import test1.interpreter.test1.ConceptA;
import test1.interpreter.test1.Test1Package;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected EMap<String, Integer> cs;

	protected ConceptAImpl() {
		super();
	}

	public EMap<String, Integer> getCs() {
		if (cs == null) {
			cs = new EcoreEMap<String, Integer>(Test1Package.Literals.STRING_TO_INTEGER_MAP_ENTRY, StringToIntegerMapEntryImpl.class, this, Test1Package.CONCEPT_A__CS);
		}
		return cs;
	}

	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_A;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				((org.eclipse.emf.ecore.EStructuralFeature.Setting)getCs()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				getCs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				if (coreType)
					return getCs();
				else
					return getCs().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__CS :
				return cs != null && !cs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case test1.interpreter.test1.Test1Package.CONCEPT_A__CS :
				return ((org.eclipse.emf.ecore.util.InternalEList<?>) getCs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public void exec() {
		for (test1.interpreter.test1.StringToIntegerMapEntry c : this.cs) {
		  c.call();
		}
	}
}
