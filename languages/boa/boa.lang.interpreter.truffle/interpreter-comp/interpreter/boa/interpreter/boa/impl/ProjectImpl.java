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
		description = "Project"
)
public class ProjectImpl extends ExprImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	@Child
	protected ExprImpl exp;

	protected ProjectImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.PROJECT;
	}

	@TruffleBoundary
	public ExprImpl getExp() {
		return exp;
	}

	@TruffleBoundary
	public NotificationChain basicSetExp(ExprImpl newExp, NotificationChain msgs) {
		ExprImpl oldExp = exp;
		exp = newExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.PROJECT__EXP, oldExp, newExp);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setExp(ExprImpl newExp) {
		if (newExp != exp) {
			NotificationChain msgs = null;
			if (exp != null)
				msgs = ((InternalEObject) exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.PROJECT__EXP, null, msgs);
			if (newExp != null)
				msgs = ((InternalEObject) newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.PROJECT__EXP, null, msgs);
			msgs = basicSetExp(newExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.PROJECT__EXP, newExp, newExp));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.PROJECT__NAME, oldName, name));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.PROJECT__EXP :
				return basicSetExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.PROJECT__EXP :
				return getExp();
			case BoaPackage.PROJECT__NAME :
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.PROJECT__EXP :
				setExp((ExprImpl) newValue);
				return;
			case BoaPackage.PROJECT__NAME :
				setName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.PROJECT__EXP :
				setExp((ExprImpl) null);
				return;
			case BoaPackage.PROJECT__NAME :
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.PROJECT__EXP :
				return exp != null;
			case BoaPackage.PROJECT__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vexp = ((EvalResImpl) (((ExprImpl) (this.getExp())).eval((CtxImpl) (ctx))));
		if (vexp instanceof EvalMapResImpl) {
			EvalMapResImpl mvexp = ((EvalMapResImpl) (vexp));
			if (MapService.containsKey((EMap) (mvexp.getValues()), (String) (this.name))) {
				EvalResImpl x = ((EvalResImpl) (mvexp.getValues().get((String) (this.name))));
				if (x instanceof EvalFunResImpl) {
					EvalFunResImpl func = ((EvalFunResImpl) (x));
					result = (EvalResImpl) (((ProjectImpl) (this)).project((EvalFunResImpl) (func), (EvalMapResImpl) (mvexp))) ;
				}
				else {
					result = (EvalResImpl) (x) ;
				}
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

	public EvalResImpl project(EvalFunResImpl func, EvalMapResImpl mvexp) {
		EvalResImpl result;
		EvalBoundFunResImpl ret = ((EvalBoundFunResImpl) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
		ret.setExp(func.getExp());
		ret.setCtx(func.getCtx());
		ret.setName(func.getName());
		MapService.replaceWith((EMap) (ret.getTh()), (EMap) (mvexp.getValues()));
		result = (EvalResImpl) (ret) ;
		return result;
	}
}
