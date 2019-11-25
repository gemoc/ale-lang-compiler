/**
 */
package testbidirectionalrelation.impl;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConceptb <em>Conceptb</em>}</li>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConceptc <em>Conceptc</em>}</li>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConceptd <em>Conceptd</em>}</li>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConcepte <em>Concepte</em>}</li>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConceptf <em>Conceptf</em>}</li>
 *   <li>{@link testbidirectionalrelation.impl.ConceptAImpl#getConceptg <em>Conceptg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	/**
	 * The cached value of the '{@link #getConceptb() <em>Conceptb</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptB> conceptb;

	/**
	 * The cached value of the '{@link #getConceptc() <em>Conceptc</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptc()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptC> conceptc;

	/**
	 * The cached value of the '{@link #getConceptd() <em>Conceptd</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptd()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptD> conceptd;

	/**
	 * The cached value of the '{@link #getConcepte() <em>Concepte</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepte()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptE> concepte;

	/**
	 * The cached value of the '{@link #getConceptf() <em>Conceptf</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptf()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptF> conceptf;

	/**
	 * The cached value of the '{@link #getConceptg() <em>Conceptg</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptg()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptG> conceptg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptB> getConceptb() {
		if (conceptb == null) {
			conceptb = new EObjectContainmentEList<ConceptB>(ConceptB.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB);
		}
		return conceptb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptC> getConceptc() {
		if (conceptc == null) {
			conceptc = new EObjectContainmentEList<ConceptC>(ConceptC.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC);
		}
		return conceptc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptD> getConceptd() {
		if (conceptd == null) {
			conceptd = new EObjectContainmentEList<ConceptD>(ConceptD.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD);
		}
		return conceptd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptE> getConcepte() {
		if (concepte == null) {
			concepte = new EObjectContainmentEList<ConceptE>(ConceptE.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE);
		}
		return concepte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptF> getConceptf() {
		if (conceptf == null) {
			conceptf = new EObjectContainmentEList<ConceptF>(ConceptF.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF);
		}
		return conceptf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptG> getConceptg() {
		if (conceptg == null) {
			conceptg = new EObjectContainmentEList<ConceptG>(ConceptG.class, this, TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG);
		}
		return conceptg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB:
				return ((InternalEList<?>)getConceptb()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC:
				return ((InternalEList<?>)getConceptc()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD:
				return ((InternalEList<?>)getConceptd()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE:
				return ((InternalEList<?>)getConcepte()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF:
				return ((InternalEList<?>)getConceptf()).basicRemove(otherEnd, msgs);
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG:
				return ((InternalEList<?>)getConceptg()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB:
				return getConceptb();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC:
				return getConceptc();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD:
				return getConceptd();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE:
				return getConcepte();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF:
				return getConceptf();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG:
				return getConceptg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB:
				getConceptb().clear();
				getConceptb().addAll((Collection<? extends ConceptB>)newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC:
				getConceptc().clear();
				getConceptc().addAll((Collection<? extends ConceptC>)newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD:
				getConceptd().clear();
				getConceptd().addAll((Collection<? extends ConceptD>)newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE:
				getConcepte().clear();
				getConcepte().addAll((Collection<? extends ConceptE>)newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF:
				getConceptf().clear();
				getConceptf().addAll((Collection<? extends ConceptF>)newValue);
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG:
				getConceptg().clear();
				getConceptg().addAll((Collection<? extends ConceptG>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB:
				getConceptb().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC:
				getConceptc().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD:
				getConceptd().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE:
				getConcepte().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF:
				getConceptf().clear();
				return;
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG:
				getConceptg().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTB:
				return conceptb != null && !conceptb.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTC:
				return conceptc != null && !conceptc.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTD:
				return conceptd != null && !conceptd.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTE:
				return concepte != null && !concepte.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTF:
				return conceptf != null && !conceptf.isEmpty();
			case TestbidirectionalrelationPackage.CONCEPT_A__CONCEPTG:
				return conceptg != null && !conceptg.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptAImpl
