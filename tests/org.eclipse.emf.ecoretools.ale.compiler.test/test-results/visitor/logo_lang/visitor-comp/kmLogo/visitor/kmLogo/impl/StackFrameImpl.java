package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Variable;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class StackFrameImpl extends MinimalEObjectImpl.Container implements StackFrame {
	protected EList<Variable> variables;

	protected StackFrameImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.STACK_FRAME;
	}

	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, KmLogoPackage.STACK_FRAME__VARIABLES);
		}
		return variables;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.STACK_FRAME__VARIABLES :
				return ((InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.STACK_FRAME__VARIABLES :
				return getVariables();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.STACK_FRAME__VARIABLES :
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.STACK_FRAME__VARIABLES :
				getVariables().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.STACK_FRAME__VARIABLES :
				return variables != null && !variables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__StackFrame(this);
	}
}
