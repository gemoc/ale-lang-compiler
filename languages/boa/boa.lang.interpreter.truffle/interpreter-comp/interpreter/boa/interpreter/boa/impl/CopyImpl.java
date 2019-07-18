package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Copy"
)
public class CopyImpl extends ExprImpl {
	@Child
	protected ExprImpl copy;

	protected CopyImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.COPY;
	}

	@TruffleBoundary
	public ExprImpl getCopy() {
		return copy;
	}

	@TruffleBoundary
	public NotificationChain basicSetCopy(ExprImpl newCopy, NotificationChain msgs) {
		ExprImpl oldCopy = copy;
		copy = newCopy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, oldCopy, newCopy);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setCopy(ExprImpl newCopy) {
		if (newCopy != copy) {
			NotificationChain msgs = null;
			if (copy != null)
				msgs = ((InternalEObject) copy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			if (newCopy != null)
				msgs = ((InternalEObject) newCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			msgs = basicSetCopy(newCopy, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, newCopy, newCopy));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return basicSetCopy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return getCopy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				setCopy((ExprImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				setCopy((ExprImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return copy != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vcopy = ((EvalResImpl) (((ExprImpl) (this.getCopy())).eval((CtxImpl) (ctx))));
		if (vcopy instanceof EvalMapResImpl) {
			EvalMapResImpl mvcopy = ((EvalMapResImpl) (vcopy));
			EvalMapResImpl ret = ((EvalMapResImpl) (BoaFactory.eINSTANCE.createEvalMapRes()));
			MapService.putAll((EMap) (ret.getValues()), (EMap) (mvcopy.getValues()));
			result = (EvalResImpl) (ret) ;
		}
		else {
			result = (EvalResImpl) (null) ;
		}
		return result;
	}
}
