package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.Let;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Let"
)
public class LetImpl extends ExprImpl implements Let {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected Expr lhs;

	protected Expr rhs;

	protected LetImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.LET;
	}

	@TruffleBoundary
	public String getName() {
		return name;
	}

	@TruffleBoundary
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.LET__NAME, oldName, name));
	}

	@TruffleBoundary
	public Expr getLhs() {
		return lhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
		Expr oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.LET__LHS, oldLhs, newLhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setLhs(Expr newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.LET__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.LET__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.LET__LHS, newLhs, newLhs));
	}

	@TruffleBoundary
	public Expr getRhs() {
		return rhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
		Expr oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.LET__RHS, oldRhs, newRhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setRhs(Expr newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.LET__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.LET__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.LET__RHS, newRhs, newRhs));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.LET__LHS :
				return basicSetLhs(null, msgs);
			case BoaPackage.LET__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.LET__NAME :
				return getName();
			case BoaPackage.LET__LHS :
				return getLhs();
			case BoaPackage.LET__RHS :
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.LET__NAME :
				setName((String) newValue);
				return;
			case BoaPackage.LET__LHS :
				setLhs((Expr) newValue);
				return;
			case BoaPackage.LET__RHS :
				setRhs((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.LET__NAME :
				setName(NAME_EDEFAULT);
				return;
			case BoaPackage.LET__LHS :
				setLhs((Expr) null);
				return;
			case BoaPackage.LET__RHS :
				setRhs((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.LET__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BoaPackage.LET__LHS :
				return lhs != null;
			case BoaPackage.LET__RHS :
				return rhs != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		Expr lhs = ((Expr) (this.getLhs()));
		EvalRes vlhs = ((EvalRes) (((Expr) (lhs)).eval((Ctx) (ctx))));
		Ctx nctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		MapService.putAll((EMap) (nctx.getEnv()), (EMap) (ctx.getEnv()));
		MapService.put((EMap) (nctx.getEnv()), (String) (this.name), (EvalRes) (vlhs));
		result = (EvalRes) (((Expr) (this.getRhs())).eval((Ctx) (nctx))) ;
		return result;
	}
}
