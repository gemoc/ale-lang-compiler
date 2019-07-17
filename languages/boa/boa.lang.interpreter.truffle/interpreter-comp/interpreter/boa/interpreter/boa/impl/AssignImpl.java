package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
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
		description = "Assign"
)
public class AssignImpl extends ExprImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	@Child
	protected ExprImpl lhs;

	@Child
	protected ExprImpl rhs;

	protected AssignImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ASSIGN;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__LHS, oldLhs, newLhs);
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
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.ASSIGN__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.ASSIGN__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__LHS, newLhs, newLhs));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__RHS, oldRhs, newRhs);
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
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.ASSIGN__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.ASSIGN__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__RHS, newRhs, newRhs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__NAME, oldName, name));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.ASSIGN__LHS :
				return basicSetLhs(null, msgs);
			case BoaPackage.ASSIGN__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.ASSIGN__LHS :
				return getLhs();
			case BoaPackage.ASSIGN__RHS :
				return getRhs();
			case BoaPackage.ASSIGN__NAME :
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.ASSIGN__LHS :
				setLhs((ExprImpl) newValue);
				return;
			case BoaPackage.ASSIGN__RHS :
				setRhs((ExprImpl) newValue);
				return;
			case BoaPackage.ASSIGN__NAME :
				setName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.ASSIGN__LHS :
				setLhs((ExprImpl) null);
				return;
			case BoaPackage.ASSIGN__RHS :
				setRhs((ExprImpl) null);
				return;
			case BoaPackage.ASSIGN__NAME :
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.ASSIGN__LHS :
				return lhs != null;
			case BoaPackage.ASSIGN__RHS :
				return rhs != null;
			case BoaPackage.ASSIGN__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vlhs = ((EvalResImpl) (((ExprImpl) (this.getLhs())).eval((CtxImpl) (ctx))));
		EvalResImpl vrhs = ((EvalResImpl) (((ExprImpl) (this.getRhs())).eval((CtxImpl) (ctx))));
		if (vlhs instanceof EvalMapResImpl) {
			EvalMapResImpl mvlhs = ((EvalMapResImpl) (vlhs));
			if (MapService.containsKey((EMap) (mvlhs.getValues()), (String) (this.name))) {
				MapService.put((EMap) (mvlhs.getValues()), (String) (this.name), (EvalResImpl) (vrhs));
				result = (EvalResImpl) (vrhs) ;
			}
			else {
				result = (EvalResImpl) (null) ;
			}
		}
		else {
			result = (EvalResImpl) (null) ;
		}
		return result;
	}
}
