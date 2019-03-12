package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected EList<ConceptB> conceptb;

	protected EList<ConceptC> conceptc;

	protected EList<ConceptD> conceptd;

	protected EList<ConceptE> concepte;

	protected EList<ConceptF> conceptf;

	protected EList<ConceptG> conceptg;

	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_A;
	}

	public EList<ConceptB> getConceptb() {
		if (conceptb == null) {
			conceptb = new EObjectContainmentEList<ConceptB>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptB.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB);
		}
		return conceptb;
	}

	public EList<ConceptC> getConceptc() {
		if (conceptc == null) {
			conceptc = new EObjectContainmentEList<ConceptC>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptC.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC);
		}
		return conceptc;
	}

	public EList<ConceptD> getConceptd() {
		if (conceptd == null) {
			conceptd = new EObjectContainmentEList<ConceptD>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptD.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD);
		}
		return conceptd;
	}

	public EList<ConceptE> getConcepte() {
		if (concepte == null) {
			concepte = new EObjectContainmentEList<ConceptE>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptE.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE);
		}
		return concepte;
	}

	public EList<ConceptF> getConceptf() {
		if (conceptf == null) {
			conceptf = new EObjectContainmentEList<ConceptF>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptF.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF);
		}
		return conceptf;
	}

	public EList<ConceptG> getConceptg() {
		if (conceptg == null) {
			conceptg = new EObjectContainmentEList<ConceptG>(testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptG.class, this, testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG);
		}
		return conceptg;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return ((InternalEList<?>) getConceptb()).basicRemove(otherEnd, msgs);
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return ((InternalEList<?>) getConceptc()).basicRemove(otherEnd, msgs);
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return ((InternalEList<?>) getConceptd()).basicRemove(otherEnd, msgs);
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return ((InternalEList<?>) getConcepte()).basicRemove(otherEnd, msgs);
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return ((InternalEList<?>) getConceptf()).basicRemove(otherEnd, msgs);
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return ((InternalEList<?>) getConceptg()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return getConceptb();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return getConceptc();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return getConceptd();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return getConcepte();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return getConceptf();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return getConceptg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				getConceptb().clear();
				getConceptb().addAll((Collection<? extends ConceptB>) newValue);
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				getConceptc().clear();
				getConceptc().addAll((Collection<? extends ConceptC>) newValue);
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				getConceptd().clear();
				getConceptd().addAll((Collection<? extends ConceptD>) newValue);
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				getConcepte().clear();
				getConcepte().addAll((Collection<? extends ConceptE>) newValue);
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				getConceptf().clear();
				getConceptf().addAll((Collection<? extends ConceptF>) newValue);
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				getConceptg().clear();
				getConceptg().addAll((Collection<? extends ConceptG>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				getConceptb().clear();
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				getConceptc().clear();
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				getConceptd().clear();
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				getConcepte().clear();
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				getConceptf().clear();
				return;
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				getConceptg().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return conceptb != null && !conceptb.isEmpty();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return conceptc != null && !conceptc.isEmpty();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return conceptd != null && !conceptd.isEmpty();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return concepte != null && !concepte.isEmpty();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return conceptf != null && !conceptf.isEmpty();
			case testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return conceptg != null && !conceptg.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}