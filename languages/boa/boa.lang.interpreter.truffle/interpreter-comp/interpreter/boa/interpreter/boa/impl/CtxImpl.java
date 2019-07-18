package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "Ctx"
)
public class CtxImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected EMap<String, EvalResImpl> env;

	protected EMap<String, EvalResImpl> th;

	protected CtxImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CTX;
	}

	@TruffleBoundary
	public EMap<String, EvalResImpl> getEnv() {
		if (env == null) {
			env = new EcoreEMap<String, EvalResImpl>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__ENV);
		}
		return env;
	}

	@TruffleBoundary
	public EMap<String, EvalResImpl> getTh() {
		if (th == null) {
			th = new EcoreEMap<String, EvalResImpl>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__TH);
		}
		return th;
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.CTX__ENV :
				return env != null && !env.isEmpty();
			case BoaPackage.CTX__TH :
				return th != null && !th.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
