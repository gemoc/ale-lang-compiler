/**
 */
package imp.model.imp.impl;

import imp.model.imp.ImpPackage;
import imp.model.imp.MethodDecl;
import imp.model.imp.ParamDecl;
import imp.model.imp.Stmt;

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
 * An implementation of the model object '<em><b>Method Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.impl.MethodDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link imp.model.imp.impl.MethodDeclImpl#getStmt <em>Stmt</em>}</li>
 *   <li>{@link imp.model.imp.impl.MethodDeclImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodDeclImpl extends MemberImpl implements MethodDecl {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStmt() <em>Stmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStmt()
	 * @generated
	 * @ordered
	 */
	protected Stmt stmt;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamDecl> params;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.METHOD_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.METHOD_DECL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamDecl> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<ParamDecl>(ParamDecl.class, this, ImpPackage.METHOD_DECL__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stmt getStmt() {
		return stmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStmt(Stmt newStmt, NotificationChain msgs) {
		Stmt oldStmt = stmt;
		stmt = newStmt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.METHOD_DECL__STMT,
					oldStmt, newStmt);
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
	public void setStmt(Stmt newStmt) {
		if (newStmt != stmt) {
			NotificationChain msgs = null;
			if (stmt != null)
				msgs = ((InternalEObject) stmt).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ImpPackage.METHOD_DECL__STMT, null, msgs);
			if (newStmt != null)
				msgs = ((InternalEObject) newStmt).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ImpPackage.METHOD_DECL__STMT, null, msgs);
			msgs = basicSetStmt(newStmt, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.METHOD_DECL__STMT, newStmt, newStmt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImpPackage.METHOD_DECL__STMT:
			return basicSetStmt(null, msgs);
		case ImpPackage.METHOD_DECL__PARAMS:
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
		case ImpPackage.METHOD_DECL__NAME:
			return getName();
		case ImpPackage.METHOD_DECL__STMT:
			return getStmt();
		case ImpPackage.METHOD_DECL__PARAMS:
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
		case ImpPackage.METHOD_DECL__NAME:
			setName((String) newValue);
			return;
		case ImpPackage.METHOD_DECL__STMT:
			setStmt((Stmt) newValue);
			return;
		case ImpPackage.METHOD_DECL__PARAMS:
			getParams().clear();
			getParams().addAll((Collection<? extends ParamDecl>) newValue);
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
		case ImpPackage.METHOD_DECL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ImpPackage.METHOD_DECL__STMT:
			setStmt((Stmt) null);
			return;
		case ImpPackage.METHOD_DECL__PARAMS:
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
		case ImpPackage.METHOD_DECL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ImpPackage.METHOD_DECL__STMT:
			return stmt != null;
		case ImpPackage.METHOD_DECL__PARAMS:
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MethodDeclImpl
