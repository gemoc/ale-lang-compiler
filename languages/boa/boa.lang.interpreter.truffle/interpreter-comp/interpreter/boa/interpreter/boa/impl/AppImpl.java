package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.App;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalBoundFunRes;
import interpreter.boa.interpreter.boa.EvalFunRes;
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
		description = "App"
)
public class AppImpl extends ExprImpl implements App {
	protected Expr lhs;

	protected Expr rhs;

	protected AppImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.APP;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.APP__LHS, oldLhs, newLhs);
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
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.APP__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.APP__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.APP__LHS, newLhs, newLhs));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.APP__RHS, oldRhs, newRhs);
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
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.APP__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.APP__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.APP__RHS, newRhs, newRhs));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				return basicSetLhs(null, msgs);
			case BoaPackage.APP__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				return getLhs();
			case BoaPackage.APP__RHS :
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				setLhs((Expr) newValue);
				return;
			case BoaPackage.APP__RHS :
				setRhs((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				setLhs((Expr) null);
				return;
			case BoaPackage.APP__RHS :
				setRhs((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				return lhs != null;
			case BoaPackage.APP__RHS :
				return rhs != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((Expr) (this.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((Expr) (this.getRhs())).eval((Ctx) (ctx))));
		if (vlhs instanceof EvalFunRes) {
			if (vlhs instanceof EvalBoundFunRes) {
				EvalBoundFunRes fct = ((EvalBoundFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (fct.getTh()));
				EvalRes fe = ((EvalRes) (((App) (this)).callFunc((EvalBoundFunRes) (fct), (Ctx) (callCtx))));
				if (fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (fct.getTh()));
					result = (EvalRes) (tmp) ;
				}
				else {
					result = (EvalRes) (fe) ;
				}
			}
			else {
				EvalFunRes fct = ((EvalFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (ctx.getTh()));
				EvalRes fe = ((EvalRes) (((App) (this)).callFunc((EvalFunRes) (fct), (Ctx) (callCtx))));
				if (fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (ctx.getTh()));
					result = (EvalRes) (tmp) ;
				}
				else {
					result = (EvalRes) (fe) ;
				}
			}
		}
		else {
			result = (EvalRes) (null) ;
		}
		return result;
	}

	public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
		EvalRes result;
		result = (EvalRes) (((Expr) (fct.getExp())).eval((Ctx) (callCtx))) ;
		return result;
	}
}
