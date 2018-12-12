/**
 */
package imp.model.imp.impl;

import imp.model.imp.Expr;
import imp.model.imp.ImpPackage;
import imp.model.imp.Member;
import imp.model.imp.Project;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.impl.ProjectImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link imp.model.imp.impl.ProjectImpl#getRhs <em>Rhs</em>}</li>
 *   <li>{@link imp.model.imp.impl.ProjectImpl#isIsmethodcall <em>Ismethodcall</em>}</li>
 *   <li>{@link imp.model.imp.impl.ProjectImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends ExprImpl implements Project {
	/**
	 * The cached value of the '{@link #getLhs() <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLhs()
	 * @generated
	 * @ordered
	 */
	protected Expr lhs;

	/**
	 * The cached value of the '{@link #getRhs() <em>Rhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhs()
	 * @generated
	 * @ordered
	 */
	protected Member rhs;

	/**
	 * The default value of the '{@link #isIsmethodcall() <em>Ismethodcall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsmethodcall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ISMETHODCALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsmethodcall() <em>Ismethodcall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsmethodcall()
	 * @generated
	 * @ordered
	 */
	protected boolean ismethodcall = ISMETHODCALL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<Expr> params;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getLhs() {
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
		Expr oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.PROJECT__LHS,
					oldLhs, newLhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLhs(Expr newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.PROJECT__LHS,
						null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.PROJECT__LHS,
						null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.PROJECT__LHS, newLhs, newLhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member getRhs() {
		if (rhs != null && rhs.eIsProxy()) {
			InternalEObject oldRhs = (InternalEObject) rhs;
			rhs = (Member) eResolveProxy(oldRhs);
			if (rhs != oldRhs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImpPackage.PROJECT__RHS, oldRhs, rhs));
			}
		}
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member basicGetRhs() {
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhs(Member newRhs) {
		Member oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.PROJECT__RHS, oldRhs, rhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsmethodcall() {
		return ismethodcall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsmethodcall(boolean newIsmethodcall) {
		boolean oldIsmethodcall = ismethodcall;
		ismethodcall = newIsmethodcall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.PROJECT__ISMETHODCALL, oldIsmethodcall,
					ismethodcall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expr> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<Expr>(Expr.class, this, ImpPackage.PROJECT__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImpPackage.PROJECT__LHS:
			return basicSetLhs(null, msgs);
		case ImpPackage.PROJECT__PARAMS:
			return ((InternalEList<?>) getParams()).basicRemove(otherEnd, msgs);
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
		case ImpPackage.PROJECT__LHS:
			return getLhs();
		case ImpPackage.PROJECT__RHS:
			if (resolve)
				return getRhs();
			return basicGetRhs();
		case ImpPackage.PROJECT__ISMETHODCALL:
			return isIsmethodcall();
		case ImpPackage.PROJECT__PARAMS:
			return getParams();
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
		case ImpPackage.PROJECT__LHS:
			setLhs((Expr) newValue);
			return;
		case ImpPackage.PROJECT__RHS:
			setRhs((Member) newValue);
			return;
		case ImpPackage.PROJECT__ISMETHODCALL:
			setIsmethodcall((Boolean) newValue);
			return;
		case ImpPackage.PROJECT__PARAMS:
			getParams().clear();
			getParams().addAll((Collection<? extends Expr>) newValue);
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
		case ImpPackage.PROJECT__LHS:
			setLhs((Expr) null);
			return;
		case ImpPackage.PROJECT__RHS:
			setRhs((Member) null);
			return;
		case ImpPackage.PROJECT__ISMETHODCALL:
			setIsmethodcall(ISMETHODCALL_EDEFAULT);
			return;
		case ImpPackage.PROJECT__PARAMS:
			getParams().clear();
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
		case ImpPackage.PROJECT__LHS:
			return lhs != null;
		case ImpPackage.PROJECT__RHS:
			return rhs != null;
		case ImpPackage.PROJECT__ISMETHODCALL:
			return ismethodcall != ISMETHODCALL_EDEFAULT;
		case ImpPackage.PROJECT__PARAMS:
			return params != null && !params.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (ismethodcall: ");
		result.append(ismethodcall);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
