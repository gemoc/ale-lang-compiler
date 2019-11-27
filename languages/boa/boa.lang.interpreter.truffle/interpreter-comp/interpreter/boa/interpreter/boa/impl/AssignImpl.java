package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.Assign;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalMapRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
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
public class AssignImpl extends ExprImpl implements Assign {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected Expr lhs;

	protected Expr rhs;

	protected AssignImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ASSIGN;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.ASSIGN__LHS, oldLhs, newLhs);
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
	public Expr getRhs() {
		return rhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
		Expr oldRhs = rhs;
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
	public void setRhs(Expr newRhs) {
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
				setLhs((Expr) newValue);
				return;
			case BoaPackage.ASSIGN__RHS :
				setRhs((Expr) newValue);
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
				setLhs((Expr) null);
				return;
			case BoaPackage.ASSIGN__RHS :
				setRhs((Expr) null);
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

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((Expr) (this.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((Expr) (this.getRhs())).eval((Ctx) (ctx))));
		if (vlhs instanceof EvalMapRes) {
			EvalMapRes mvlhs = ((EvalMapRes) (vlhs));
			if (MapService.containsKey((EMap) (mvlhs.getValues()), (String) (this.name))) {
				MapService.put((EMap) (mvlhs.getValues()), (String) (this.name), (EvalRes) (vrhs));
				result = (EvalRes) (vrhs) ;
			}
			else {
				result = (EvalRes) (null) ;
			}
		}
		else {
			result = (EvalRes) (null) ;
		}
		return result;
	}
}
