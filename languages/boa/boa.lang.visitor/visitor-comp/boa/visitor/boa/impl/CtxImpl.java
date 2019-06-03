package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class CtxImpl extends MinimalEObjectImpl.Container implements Ctx {
	protected EMap<String, EvalRes> env;

	protected EMap<String, EvalRes> th;

	protected CtxImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CTX;
	}

	public EMap<String, EvalRes> getEnv() {
		if (env == null) {
			env = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__ENV);
		}
		return env;
	}

	public EMap<String, EvalRes> getTh() {
		if (th == null) {
			th = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__TH);
		}
		return th;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				return ((InternalEList<?>) getEnv()).basicRemove(otherEnd, msgs);
			case BoaPackage.CTX__TH :
				return ((InternalEList<?>) getTh()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				if (coreType) return getEnv();
				else return getEnv().map();
			case BoaPackage.CTX__TH :
				if (coreType) return getTh();
				else return getTh().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				((Setting)getEnv()).set(newValue);
				return;
			case BoaPackage.CTX__TH :
				((Setting)getTh()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				getEnv().clear();
				return;
			case BoaPackage.CTX__TH :
				getTh().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				return env != null && !env.isEmpty();
			case BoaPackage.CTX__TH :
				return th != null && !th.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__Ctx(this);
	}
}
