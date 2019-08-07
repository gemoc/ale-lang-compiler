package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
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

@NodeInfo(
		description = "If"
)
public class IfImpl extends ExprImpl implements If {
	@Child
	protected Expr cond;

	@Child
	protected Expr thn;

	@Child
	protected Expr els;

	protected IfImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.IF;
	}

	@TruffleBoundary
	public Expr getCond() {
		return cond;
	}

	@TruffleBoundary
	public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
		Expr oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, oldCond, newCond);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setCond(Expr newCond) {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject) cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject) newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, newCond, newCond));
	}

	@TruffleBoundary
	public Expr getThn() {
		return thn;
	}

	@TruffleBoundary
	public NotificationChain basicSetThn(Expr newThn, NotificationChain msgs) {
		Expr oldThn = thn;
		thn = newThn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, oldThn, newThn);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setThn(Expr newThn) {
		if (newThn != thn) {
			NotificationChain msgs = null;
			if (thn != null)
				msgs = ((InternalEObject) thn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			if (newThn != null)
				msgs = ((InternalEObject) newThn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			msgs = basicSetThn(newThn, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, newThn, newThn));
	}

	@TruffleBoundary
	public Expr getEls() {
		return els;
	}

	@TruffleBoundary
	public NotificationChain basicSetEls(Expr newEls, NotificationChain msgs) {
		Expr oldEls = els;
		els = newEls;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, oldEls, newEls);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setEls(Expr newEls) {
		if (newEls != els) {
			NotificationChain msgs = null;
			if (els != null)
				msgs = ((InternalEObject) els).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			if (newEls != null)
				msgs = ((InternalEObject) newEls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			msgs = basicSetEls(newEls, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, newEls, newEls));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.IF__COND :
				return basicSetCond(null, msgs);
			case BoaPackage.IF__THN :
				return basicSetThn(null, msgs);
			case BoaPackage.IF__ELS :
				return basicSetEls(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.IF__COND :
				return getCond();
			case BoaPackage.IF__THN :
				return getThn();
			case BoaPackage.IF__ELS :
				return getEls();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.IF__COND :
				setCond((Expr) newValue);
				return;
			case BoaPackage.IF__THN :
				setThn((Expr) newValue);
				return;
			case BoaPackage.IF__ELS :
				setEls((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.IF__COND :
				setCond((Expr) null);
				return;
			case BoaPackage.IF__THN :
				setThn((Expr) null);
				return;
			case BoaPackage.IF__ELS :
				setEls((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.IF__COND :
				return cond != null;
			case BoaPackage.IF__THN :
				return thn != null;
			case BoaPackage.IF__ELS :
				return els != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcond = ((EvalRes) (((Expr) (this.getCond())).eval((Ctx) (ctx))));
		if (vcond instanceof EvalBoolRes) {
			EvalBoolRes bvcond = ((EvalBoolRes) (vcond));
			if (bvcond.isValue()) {
				result = (EvalRes) (((Expr) (this.getThn())).eval((Ctx) (ctx))) ;
			}
			else {
				result = (EvalRes) (((Expr) (this.getEls())).eval((Ctx) (ctx))) ;
			}
		}
		else {
			result = (EvalRes) (null) ;
		}
		return result;
	}
}
