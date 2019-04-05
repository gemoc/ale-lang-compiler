package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalBoolRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.If;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class IfImpl extends ExprImpl implements If {
	protected Expr cond;

	protected Expr thn;

	protected Expr els;

	protected IfImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.IF;
	}
	
	public Expr getCond() {
		return cond;
	}
	
	public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
		Expr oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, oldCond, newCond);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	public void setCond(Expr newCond) {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, newCond, newCond));
	}
	
	public Expr getThn() {
		return thn;
	}
	
	public NotificationChain basicSetThn(Expr newThn, NotificationChain msgs) {
		Expr oldThn = thn;
		thn = newThn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, oldThn, newThn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	public void setThn(Expr newThn) {
		if (newThn != thn) {
			NotificationChain msgs = null;
			if (thn != null)
				msgs = ((InternalEObject)thn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			if (newThn != null)
				msgs = ((InternalEObject)newThn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			msgs = basicSetThn(newThn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, newThn, newThn));
	}
	
	public Expr getEls() {
		return els;
	}
	
	public NotificationChain basicSetEls(Expr newEls, NotificationChain msgs) {
		Expr oldEls = els;
		els = newEls;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, oldEls, newEls);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	public void setEls(Expr newEls) {
		if (newEls != els) {
			NotificationChain msgs = null;
			if (els != null)
				msgs = ((InternalEObject)els).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			if (newEls != null)
				msgs = ((InternalEObject)newEls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			msgs = basicSetEls(newEls, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, newEls, newEls));
	}
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				return basicSetCond(null, msgs);
			case BoaPackage.IF__THN:
				return basicSetThn(null, msgs);
			case BoaPackage.IF__ELS:
				return basicSetEls(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				return getCond();
			case BoaPackage.IF__THN:
				return getThn();
			case BoaPackage.IF__ELS:
				return getEls();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				setCond((Expr)newValue);
				return;
			case BoaPackage.IF__THN:
				setThn((Expr)newValue);
				return;
			case BoaPackage.IF__ELS:
				setEls((Expr)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				setCond((Expr)null);
				return;
			case BoaPackage.IF__THN:
				setThn((Expr)null);
				return;
			case BoaPackage.IF__ELS:
				setEls((Expr)null);
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				return cond != null;
			case BoaPackage.IF__THN:
				return thn != null;
			case BoaPackage.IF__ELS:
				return els != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcond = ((EvalRes) (((Expr) (this.cond)).eval((Ctx) (ctx))));
		if (vcond instanceof EvalBoolRes) {
			EvalBoolRes bvcond = ((EvalBoolRes) (vcond));
			if (bvcond.isValue()) {
				result = ((Expr) (this.thn)).eval((Ctx) (ctx));
			}
			else {
				result = ((Expr) (this.els)).eval((Ctx) (ctx));
			}
		}
		else {
			result = null;
		}
		return result;
	}
}
