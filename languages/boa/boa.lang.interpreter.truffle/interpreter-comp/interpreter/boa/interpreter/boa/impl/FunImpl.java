package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Fun"
)
public class FunImpl extends ExprImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	@Child
	protected ExprImpl body;

	protected FunImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.FUN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.FUN__NAME, oldName, name));
	}

	@TruffleBoundary
	public ExprImpl getBody() {
		return body;
	}

	@TruffleBoundary
	public NotificationChain basicSetBody(ExprImpl newBody, NotificationChain msgs) {
		ExprImpl oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.FUN__BODY, oldBody, newBody);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setBody(ExprImpl newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject) body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.FUN__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject) newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.FUN__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.FUN__BODY, newBody, newBody));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.FUN__BODY :
				return basicSetBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.FUN__NAME :
				return getName();
			case BoaPackage.FUN__BODY :
				return getBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.FUN__NAME :
				setName((String) newValue);
				return;
			case BoaPackage.FUN__BODY :
				setBody((ExprImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.FUN__NAME :
				setName(NAME_EDEFAULT);
				return;
			case BoaPackage.FUN__BODY :
				setBody((ExprImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.FUN__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BoaPackage.FUN__BODY :
				return body != null;
		}
		return super.eIsSet(featureID);
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalFunResImpl ret = ((EvalFunResImpl) (BoaFactory.eINSTANCE.createEvalFunRes()));
		ret.setExp(this.getBody());
		ret.setCtx(ctx);
		ret.setName(this.name);
		result = (EvalResImpl) (ret) ;
		return result;
	}
}
