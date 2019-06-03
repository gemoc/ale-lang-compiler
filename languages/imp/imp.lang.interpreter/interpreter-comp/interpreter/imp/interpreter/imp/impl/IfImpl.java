package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.BoolValue;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.If;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class IfImpl extends StmtImpl implements If {
	protected Expr cond;

	protected Stmt lhs;

	protected Stmt rhs;

	protected IfImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.IF;
	}

	public Expr getCond() {
		return cond;
	}

	public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
		Expr oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.IF__COND, oldCond, newCond);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setCond(Expr newCond) {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject) cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject) newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.IF__COND, newCond, newCond));
	}

	public Stmt getLhs() {
		return lhs;
	}

	public NotificationChain basicSetLhs(Stmt newLhs, NotificationChain msgs) {
		Stmt oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.IF__LHS, oldLhs, newLhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setLhs(Stmt newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.IF__LHS, newLhs, newLhs));
	}

	public Stmt getRhs() {
		return rhs;
	}

	public NotificationChain basicSetRhs(Stmt newRhs, NotificationChain msgs) {
		Stmt oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.IF__RHS, oldRhs, newRhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setRhs(Stmt newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.IF__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.IF__RHS, newRhs, newRhs));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.IF__COND :
				return basicSetCond(null, msgs);
			case ImpPackage.IF__LHS :
				return basicSetLhs(null, msgs);
			case ImpPackage.IF__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.IF__COND :
				return getCond();
			case ImpPackage.IF__LHS :
				return getLhs();
			case ImpPackage.IF__RHS :
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.IF__COND :
				setCond((Expr) newValue);
				return;
			case ImpPackage.IF__LHS :
				setLhs((Stmt) newValue);
				return;
			case ImpPackage.IF__RHS :
				setRhs((Stmt) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.IF__COND :
				setCond((Expr) null);
				return;
			case ImpPackage.IF__LHS :
				setLhs((Stmt) null);
				return;
			case ImpPackage.IF__RHS :
				setRhs((Stmt) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.IF__COND :
				return cond != null;
			case ImpPackage.IF__LHS :
				return lhs != null;
			case ImpPackage.IF__RHS :
				return rhs != null;
		}
		return super.eIsSet(featureID);
	}

	public Store execute(Store s) {
		Store result;
		Value conde = ((Value) (((Expr) (this.getCond())).evaluate((Store) (s))));
		result = (Store) (s) ;
		if (conde instanceof BoolValue) {
			BoolValue condeb = ((BoolValue) (conde));
			if (condeb.isValue()) {
				result = (Store) (((Stmt) (this.getLhs())).execute((Store) (s))) ;
			}
			else {
				result = (Store) (((Stmt) (this.getRhs())).execute((Store) (s))) ;
			}
		}
		return result;
	}
}
