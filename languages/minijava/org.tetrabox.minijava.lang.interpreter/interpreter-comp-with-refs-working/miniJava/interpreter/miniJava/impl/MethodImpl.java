package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.State;

public class MethodImpl extends MemberImpl implements Method {
	protected static final boolean ISABSTRACT_EDEFAULT = false;

	protected static final boolean ISSTATIC_EDEFAULT = false;

	protected Block body;

	protected boolean isabstract = ISABSTRACT_EDEFAULT;

	protected boolean isstatic = ISSTATIC_EDEFAULT;

	protected EList<Parameter> params;

	protected MethodImpl() {
		super();
	}

	public NotificationChain basicSetBody(Block newBody, NotificationChain msgs) {
		Block oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__BODY,
					oldBody, newBody);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void call(State state) {
		this.body.evaluateStatement(state);
		;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.METHOD__ISABSTRACT:
			return isIsabstract();
		case MiniJavaPackage.METHOD__ISSTATIC:
			return isIsstatic();
		case MiniJavaPackage.METHOD__PARAMS:
			return getParams();
		case MiniJavaPackage.METHOD__BODY:
			return getBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.METHOD__PARAMS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getParams()).basicRemove(otherEnd, msgs);
		case MiniJavaPackage.METHOD__BODY:
			return basicSetBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.METHOD__ISABSTRACT:
			return isabstract != ISABSTRACT_EDEFAULT;
		case MiniJavaPackage.METHOD__ISSTATIC:
			return isstatic != ISSTATIC_EDEFAULT;
		case MiniJavaPackage.METHOD__PARAMS:
			return params != null && !params.isEmpty();
		case MiniJavaPackage.METHOD__BODY:
			return body != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.METHOD__ISABSTRACT:
			setIsabstract((boolean) newValue);
			return;
		case MiniJavaPackage.METHOD__ISSTATIC:
			setIsstatic((boolean) newValue);
			return;
		case MiniJavaPackage.METHOD__PARAMS:
			getParams().clear();
			getParams().addAll((java.util.Collection<? extends Parameter>) newValue);
			return;
		case MiniJavaPackage.METHOD__BODY:
			setBody((Block) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.METHOD;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.METHOD__ISABSTRACT:
			setIsabstract(ISABSTRACT_EDEFAULT);
			return;
		case MiniJavaPackage.METHOD__ISSTATIC:
			setIsstatic(ISSTATIC_EDEFAULT);
			return;
		case MiniJavaPackage.METHOD__PARAMS:
			getParams().clear();
			return;
		case MiniJavaPackage.METHOD__BODY:
			setBody((Block) null);
			return;
		}
		super.eUnset(featureID);
	}

	public void evaluateStatement(State state) {
		this.body.evaluateStatement(state);
		;
	}

	public Method findOverride(Clazz c) {
		Method result;
		org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("TODO findOverride");
		result = null;
		;
		return result;
	}

	public Block getBody() {
		return body;
	}

	public EList<Parameter> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<Parameter>(Parameter.class, this, MiniJavaPackage.METHOD__PARAMS);
		}
		return params;
	}

	public boolean isIsabstract() {
		return isabstract;
	}

	public boolean isIsstatic() {
		return isstatic;
	}

	public void setBody(Block newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject) body).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject) newBody).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__BODY, newBody, newBody));
	}

	public void setIsabstract(boolean isabstract) {
		this.isabstract = isabstract;
	}

	public void setIsstatic(boolean isstatic) {
		this.isstatic = isstatic;
	}
}
