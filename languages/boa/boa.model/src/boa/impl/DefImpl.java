
package boa.impl;
import boa.BoaPackage;
import boa.Def;
import boa.Expr;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class DefImpl extends TopLevelCmdImpl implements Def {
	
	protected static final String NAME_EDEFAULT = null;
	
	protected String name = NAME_EDEFAULT;
	
	protected Expr expr;
	
	protected DefImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.DEF;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__NAME, oldName, name));
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
		Expr oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	public void setExpr(Expr newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.DEF__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.DEF__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__EXPR, newExpr, newExpr));
	}
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.DEF__EXPR:
				return basicSetExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.DEF__NAME:
				return getName();
			case BoaPackage.DEF__EXPR:
				return getExpr();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.DEF__NAME:
				setName((String)newValue);
				return;
			case BoaPackage.DEF__EXPR:
				setExpr((Expr)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.DEF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BoaPackage.DEF__EXPR:
				setExpr((Expr)null);
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.DEF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BoaPackage.DEF__EXPR:
				return expr != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}
} //DefImpl
