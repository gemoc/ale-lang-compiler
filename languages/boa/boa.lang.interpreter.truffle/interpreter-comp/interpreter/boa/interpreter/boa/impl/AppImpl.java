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
		description = "App"
)
public class AppImpl extends ExprImpl {
	@Child
	protected ExprImpl lhs;

	@Child
	protected ExprImpl rhs;

	protected AppImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.APP;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.APP__LHS, oldLhs, newLhs);
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
	public ExprImpl getRhs() {
		return rhs;
	}

	@TruffleBoundary
	public NotificationChain basicSetRhs(ExprImpl newRhs, NotificationChain msgs) {
		ExprImpl oldRhs = rhs;
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
	public void setRhs(ExprImpl newRhs) {
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
				setLhs((ExprImpl) newValue);
				return;
			case BoaPackage.APP__RHS :
				setRhs((ExprImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.APP__LHS :
				setLhs((ExprImpl) null);
				return;
			case BoaPackage.APP__RHS :
				setRhs((ExprImpl) null);
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

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vlhs = ((EvalResImpl) (((ExprImpl) (this.getLhs())).eval((CtxImpl) (ctx))));
		EvalResImpl vrhs = ((EvalResImpl) (((ExprImpl) (this.getRhs())).eval((CtxImpl) (ctx))));
		if (vlhs instanceof EvalFunResImpl) {
			if (vlhs instanceof EvalBoundFunResImpl) {
				EvalBoundFunResImpl fct = ((EvalBoundFunResImpl) (vlhs));
				CtxImpl callCtx = ((CtxImpl) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalResImpl) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (fct.getTh()));
				EvalResImpl fe = ((EvalResImpl) (((AppImpl) (this)).callFunc((EvalBoundFunResImpl) (fct), (CtxImpl) (callCtx))));
				if (fe instanceof EvalFunResImpl) {
					EvalFunResImpl fun = ((EvalFunResImpl) (fe));
					EvalBoundFunResImpl tmp = ((EvalBoundFunResImpl) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (fct.getTh()));
					result = (EvalResImpl) (tmp) ;
				}
				else {
					result = (EvalResImpl) (fe) ;
				}
			}
			else {
				EvalFunResImpl fct = ((EvalFunResImpl) (vlhs));
				CtxImpl callCtx = ((CtxImpl) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalResImpl) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (ctx.getTh()));
				EvalResImpl fe = ((EvalResImpl) (((AppImpl) (this)).callFunc((EvalFunResImpl) (fct), (CtxImpl) (callCtx))));
				if (fe instanceof EvalFunResImpl) {
					EvalFunResImpl fun = ((EvalFunResImpl) (fe));
					EvalBoundFunResImpl tmp = ((EvalBoundFunResImpl) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (ctx.getTh()));
					result = (EvalResImpl) (tmp) ;
				}
				else {
					result = (EvalResImpl) (fe) ;
				}
			}
		}
		else {
			result = (EvalResImpl) (null) ;
		}
		return result;
	}

	public EvalResImpl callFunc(EvalFunResImpl fct, CtxImpl callCtx) {
		EvalResImpl result;
		result = (EvalResImpl) (((ExprImpl) (fct.getExp())).eval((CtxImpl) (callCtx))) ;
		return result;
	}
}
