package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalBoolRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.Not;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Not"
)
public class NotImpl extends ExprImpl implements Not {
	protected Expr value;

	protected NotImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.NOT;
	}

	@TruffleBoundary
	public Expr getValue() {
		return value;
	}

	@TruffleBoundary
	public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs) {
		Expr oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.NOT__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setValue(Expr newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.NOT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.NOT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.NOT__VALUE, newValue, newValue));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.NOT__VALUE :
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.NOT__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.NOT__VALUE :
				setValue((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.NOT__VALUE :
				setValue((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.NOT__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vvalue = ((EvalRes) (((Expr) (this.getValue())).eval((Ctx) (ctx))));
		if (vvalue instanceof EvalBoolRes) {
			EvalBoolRes bvvalue = ((EvalBoolRes) (vvalue));
			EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
			ret.setValue(!(bvvalue.isValue()));
			result = (EvalRes) (ret) ;
		}
		else {
			result = (EvalRes) (null) ;
		}
		return result;
	}
}
