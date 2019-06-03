package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.BoolValue;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import interpreter.imp.interpreter.imp.While;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class WhileImpl extends StmtImpl implements While {
	protected Expr cond;

	protected Stmt body;

	protected WhileImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.WHILE;
	}

	public Expr getCond() {
		return cond;
	}

	public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
		Expr oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.WHILE__COND, oldCond, newCond);
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
				msgs = ((InternalEObject) cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.WHILE__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject) newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.WHILE__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.WHILE__COND, newCond, newCond));
	}

	public Stmt getBody() {
		return body;
	}

	public NotificationChain basicSetBody(Stmt newBody, NotificationChain msgs) {
		Stmt oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.WHILE__BODY, oldBody, newBody);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setBody(Stmt newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject) body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.WHILE__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject) newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.WHILE__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.WHILE__BODY, newBody, newBody));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.WHILE__COND :
				return basicSetCond(null, msgs);
			case ImpPackage.WHILE__BODY :
				return basicSetBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.WHILE__COND :
				return getCond();
			case ImpPackage.WHILE__BODY :
				return getBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.WHILE__COND :
				setCond((Expr) newValue);
				return;
			case ImpPackage.WHILE__BODY :
				setBody((Stmt) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.WHILE__COND :
				setCond((Expr) null);
				return;
			case ImpPackage.WHILE__BODY :
				setBody((Stmt) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.WHILE__COND :
				return cond != null;
			case ImpPackage.WHILE__BODY :
				return body != null;
		}
		return super.eIsSet(featureID);
	}

	public Store execute(Store s) {
		Store result;
		boolean stop = ((boolean) (false));
		Store tmp = ((Store) (s));
		while (!(stop)) {
			Value conde = ((Value) (((Expr) (this.getCond())).evaluate((Store) (s))));
			if (conde instanceof BoolValue) {
				BoolValue condeb = ((BoolValue) (conde));
				if (condeb.isValue()) {
					tmp = ((Stmt) (this.getBody())).execute((Store) (tmp));
				}
				else {
					stop = true;
				}
			}
			else {
				stop = true;
			}
		}
		result = (Store) (tmp) ;
		return result;
	}
}
