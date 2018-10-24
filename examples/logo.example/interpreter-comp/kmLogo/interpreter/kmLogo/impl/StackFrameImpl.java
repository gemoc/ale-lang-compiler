package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Variable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class StackFrameImpl extends MinimalEObjectImpl.Container implements StackFrame {
  private EList<Variable> variables;

  public EList<Variable> getVariables() {
    if(variables == null) {
    	variables = new EObjectContainmentEList<Variable>(kmLogo.interpreter.kmLogo.Variable.class, this, KmLogoPackage.STACK_FRAME__VARIABLES);
    }
    return variables;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.STACK_FRAME;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	getVariables().clear();
    	getVariables().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.impl.VariableImpl>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	getVariables().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	return getVariables();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	return variables != null;
    }
    return super.eIsSet(featureID);
  }
}
