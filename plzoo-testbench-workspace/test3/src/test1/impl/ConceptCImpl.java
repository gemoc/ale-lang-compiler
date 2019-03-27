/**
 */
package test1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import test1.ConceptC;
import test1.Test1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test1.impl.ConceptCImpl#getNbr <em>Nbr</em>}</li>
 *   <li>{@link test1.impl.ConceptCImpl#isCool <em>Cool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	/**
	 * The default value of the '{@link #getNbr() <em>Nbr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbr()
	 * @generated
	 * @ordered
	 */
	protected static final int NBR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbr() <em>Nbr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbr()
	 * @generated
	 * @ordered
	 */
	protected int nbr = NBR_EDEFAULT;

	/**
	 * The default value of the '{@link #isCool() <em>Cool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCool()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCool() <em>Cool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCool()
	 * @generated
	 * @ordered
	 */
	protected boolean cool = COOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbr() {
		return nbr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbr(int newNbr) {
		int oldNbr = nbr;
		nbr = newNbr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.CONCEPT_C__NBR, oldNbr, nbr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCool() {
		return cool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCool(boolean newCool) {
		boolean oldCool = cool;
		cool = newCool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.CONCEPT_C__COOL, oldCool, cool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.CONCEPT_C__NBR:
				return getNbr();
			case Test1Package.CONCEPT_C__COOL:
				return isCool();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.CONCEPT_C__NBR:
				setNbr((Integer)newValue);
				return;
			case Test1Package.CONCEPT_C__COOL:
				setCool((Boolean)newValue);
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
			case Test1Package.CONCEPT_C__NBR:
				setNbr(NBR_EDEFAULT);
				return;
			case Test1Package.CONCEPT_C__COOL:
				setCool(COOL_EDEFAULT);
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
			case Test1Package.CONCEPT_C__NBR:
				return nbr != NBR_EDEFAULT;
			case Test1Package.CONCEPT_C__COOL:
				return cool != COOL_EDEFAULT;
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
		result.append(" (nbr: ");
		result.append(nbr);
		result.append(", cool: ");
		result.append(cool);
		result.append(')');
		return result.toString();
	}

} //ConceptCImpl
