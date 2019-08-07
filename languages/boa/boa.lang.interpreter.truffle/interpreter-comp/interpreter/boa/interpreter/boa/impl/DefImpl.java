package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import execboa.SerializeService;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.Def;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

@NodeInfo(
		description = "Def"
)
public class DefImpl extends TopLevelCmdImpl implements Def {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	@Child
	protected Expr expr;

	protected DefImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.DEF;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__NAME, oldName, name));
	}

	@TruffleBoundary
	public Expr getExpr() {
		return expr;
	}

	@TruffleBoundary
	public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
		Expr oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__EXPR, oldExpr, newExpr);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setExpr(Expr newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject) expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.DEF__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject) newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.DEF__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.DEF__EXPR, newExpr, newExpr));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.DEF__EXPR :
				return basicSetExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.DEF__NAME :
				return getName();
			case BoaPackage.DEF__EXPR :
				return getExpr();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.DEF__NAME :
				setName((String) newValue);
				return;
			case BoaPackage.DEF__EXPR :
				setExpr((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.DEF__NAME :
				setName(NAME_EDEFAULT);
				return;
			case BoaPackage.DEF__EXPR :
				setExpr((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.DEF__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BoaPackage.DEF__EXPR :
				return expr != null;
		}
		return super.eIsSet(featureID);
	}

	public void nextLine(Ctx ctx) {
		EvalRes e = ((EvalRes) (((Expr) (this.getExpr())).eval((Ctx) (ctx))));
		LogService.log(((this.name) + (" = ")) + (SerializeService.serialize((EvalRes) (e))));
		MapService.put((EMap) (ctx.getEnv()), (String) (this.name), (EvalRes) (e));
	}
}
