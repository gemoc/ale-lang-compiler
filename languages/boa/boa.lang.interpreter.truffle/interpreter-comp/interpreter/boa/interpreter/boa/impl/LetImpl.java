package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
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
public class LetImpl extends ExprImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	@Child
	protected ExprImpl lhs;

	@Child
	protected ExprImpl rhs;

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
	public ExprImpl getLhs() {
		return lhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetLhs(ExprImpl newLhs, NotificationChain msgs) {
		ExprImpl oldLhs = lhs;
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
	public void setLhs(ExprImpl newLhs) {
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
	public ExprImpl getRhs() {
		return rhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetRhs(ExprImpl newRhs, NotificationChain msgs) {
		ExprImpl oldRhs = rhs;
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
	public void setRhs(ExprImpl newRhs) {
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
				setLhs((ExprImpl) newValue);
				return;
			case BoaPackage.LET__RHS :
				setRhs((ExprImpl) newValue);
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
				setLhs((ExprImpl) null);
				return;
			case BoaPackage.LET__RHS :
				setRhs((ExprImpl) null);
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

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		ExprImpl lhs = ((ExprImpl) (this.getLhs()));
		EvalResImpl vlhs = ((EvalResImpl) (((ExprImpl) (lhs)).eval((CtxImpl) (ctx))));
		CtxImpl nctx = ((CtxImpl) (BoaFactory.eINSTANCE.createCtx()));
		MapService.putAll((EMap) (nctx.getEnv()), (EMap) (ctx.getEnv()));
		MapService.put((EMap) (nctx.getEnv()), (String) (this.name), (EvalResImpl) (vlhs));
		result = (EvalResImpl) (((ExprImpl) (this.getRhs())).eval((CtxImpl) (nctx))) ;
		return result;
	}
}
