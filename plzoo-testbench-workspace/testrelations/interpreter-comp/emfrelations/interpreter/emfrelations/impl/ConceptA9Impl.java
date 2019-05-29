package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA9;
import emfrelations.interpreter.emfrelations.ConceptB9;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

public class ConceptA9Impl extends MinimalEObjectImpl.Container implements ConceptA9 {
	protected EList<ConceptB9> conceptb9;

	protected ConceptA9Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A9;
	}

	public EList<ConceptB9> getConceptb9() {
		if (conceptb9 == null) {
			conceptb9 = new EObjectResolvingEList<ConceptB9>(ConceptB9.class, this, EmfrelationsPackage.CONCEPT_A9__CONCEPTB9);
		}
		return conceptb9;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9 :
				return getConceptb9();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9 :
				getConceptb9().clear();
				getConceptb9().addAll((Collection<? extends ConceptB9>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9 :
				getConceptb9().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9 :
				return conceptb9 != null && !conceptb9.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
