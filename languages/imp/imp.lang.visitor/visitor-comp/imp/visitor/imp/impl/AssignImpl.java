package imp.visitor.imp.impl;

import imp.visitor.imp.Assign;
import imp.visitor.imp.Expr;
import imp.visitor.imp.ImpPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class AssignImpl extends StmtImpl implements Assign {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected Expr exp;

	protected AssignImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.ASSIGN;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.ASSIGN__NAME, oldName, name));
	}

	public Expr getExp() {
		return exp;
	}

	public NotificationChain basicSetExp(Expr newExp, NotificationChain msgs) {
		Expr oldExp = exp;
		exp = newExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.ASSIGN__EXP, oldExp, newExp);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setExp(Expr newExp) {
		if (newExp != exp) {
			NotificationChain msgs = null;
			if (exp != null)
				msgs = ((InternalEObject) exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.ASSIGN__EXP, null, msgs);
			if (newExp != null)
				msgs = ((InternalEObject) newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.ASSIGN__EXP, null, msgs);
			msgs = basicSetExp(newExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.ASSIGN__EXP, newExp, newExp));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.ASSIGN__EXP :
				return basicSetExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.ASSIGN__NAME :
				return getName();
			case ImpPackage.ASSIGN__EXP :
				return getExp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.ASSIGN__NAME :
				setName((String) newValue);
				return;
			case ImpPackage.ASSIGN__EXP :
				setExp((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.ASSIGN__NAME :
				setName(NAME_EDEFAULT);
				return;
			case ImpPackage.ASSIGN__EXP :
				setExp((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.ASSIGN__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImpPackage.ASSIGN__EXP :
				return exp != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitimp__Assign(this);
	}
}
