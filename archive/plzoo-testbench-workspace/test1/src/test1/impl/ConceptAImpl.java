/**
 */
package test1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import test1.ConceptA;
import test1.Test1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test1.impl.ConceptAImpl#getBs <em>Bs</em>}</li>
 *   <li>{@link test1.impl.ConceptAImpl#getB <em>B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	/**
	 * The cached value of the '{@link #getBs() <em>Bs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBs()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> bs;

	/**
	 * The default value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected static final long B_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected long b = B_EDEFAULT;

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
		return Test1Package.Literals.CONCEPT_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Boolean> getBs() {
		if (bs == null) {
			bs = new EDataTypeEList<Boolean>(Boolean.class, this, Test1Package.CONCEPT_A__BS);
		}
		return bs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(long newB) {
		long oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.CONCEPT_A__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__BS:
				return getBs();
			case Test1Package.CONCEPT_A__B:
				return getB();
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
			case Test1Package.CONCEPT_A__BS:
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>)newValue);
				return;
			case Test1Package.CONCEPT_A__B:
				setB((Long)newValue);
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
			case Test1Package.CONCEPT_A__BS:
				getBs().clear();
				return;
			case Test1Package.CONCEPT_A__B:
				setB(B_EDEFAULT);
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
			case Test1Package.CONCEPT_A__BS:
				return bs != null && !bs.isEmpty();
			case Test1Package.CONCEPT_A__B:
				return b != B_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bs: ");
		result.append(bs);
		result.append(", b: ");
		result.append(b);
		result.append(')');
		return result.toString();
	}

} //ConceptAImpl
