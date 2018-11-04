package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Variable;

@NodeInfo(
    description = "StackFrame"
)
public class StackFrameImpl extends MinimalEObjectImpl.Container implements StackFrame {
  protected EList<Variable> variables;

  protected StackFrameImpl() {
    super();
  }

  @TruffleBoundary
  public EList<Variable> getVariables() {
    if(variables == null) {
    	variables = new EObjectContainmentEList<Variable>(kmLogo.interpreter.kmLogo.Variable.class, this, KmLogoPackage.STACK_FRAME__VARIABLES);
    }
    return variables;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.STACK_FRAME;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	getVariables().clear();
    	getVariables().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.Variable>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	getVariables().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    return getVariables();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	return variables != null && !variables.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.STACK_FRAME__VARIABLES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
