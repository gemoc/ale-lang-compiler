package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.SuppressWarnings;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage;

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
			conceptb = new EObjectContainmentEList<ConceptB>(ConceptB.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB);
		}
		return conceptb;
	}

	public EList<ConceptC> getConceptc() {
		if (conceptc == null) {
			conceptc = new EObjectContainmentEList<ConceptC>(ConceptC.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC);
		}
		return conceptc;
	}

	public EList<ConceptD> getConceptd() {
		if (conceptd == null) {
			conceptd = new EObjectContainmentEList<ConceptD>(ConceptD.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD);
		}
		return conceptd;
	}

	public EList<ConceptE> getConcepte() {
		if (concepte == null) {
			concepte = new EObjectContainmentEList<ConceptE>(ConceptE.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE);
		}
		return concepte;
	}

	public EList<ConceptF> getConceptf() {
		if (conceptf == null) {
			conceptf = new EObjectContainmentEList<ConceptF>(ConceptF.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF);
		}
		return conceptf;
	}

	public EList<ConceptG> getConceptg() {
		if (conceptg == null) {
			conceptg = new EObjectContainmentEList<ConceptG>(ConceptG.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG);
		}
		return conceptg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return ((InternalEList<?>) getConceptb()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return ((InternalEList<?>) getConceptc()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return ((InternalEList<?>) getConceptd()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return ((InternalEList<?>) getConcepte()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return ((InternalEList<?>) getConceptf()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return ((InternalEList<?>) getConceptg()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return getConceptb();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return getConceptc();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return getConceptd();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return getConcepte();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return getConceptf();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return getConceptg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				getConceptb().clear();
				getConceptb().addAll((Collection<? extends ConceptB>) newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				getConceptc().clear();
				getConceptc().addAll((Collection<? extends ConceptC>) newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				getConceptd().clear();
				getConceptd().addAll((Collection<? extends ConceptD>) newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				getConcepte().clear();
				getConcepte().addAll((Collection<? extends ConceptE>) newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				getConceptf().clear();
				getConceptf().addAll((Collection<? extends ConceptF>) newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				getConceptg().clear();
				getConceptg().addAll((Collection<? extends ConceptG>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				getConceptb().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				getConceptc().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				getConceptd().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				getConcepte().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				getConceptf().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				getConceptg().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB :
				return conceptb != null && !conceptb.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC :
				return conceptc != null && !conceptc.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD :
				return conceptd != null && !conceptd.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE :
				return concepte != null && !concepte.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF :
				return conceptf != null && !conceptf.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG :
				return conceptg != null && !conceptg.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}