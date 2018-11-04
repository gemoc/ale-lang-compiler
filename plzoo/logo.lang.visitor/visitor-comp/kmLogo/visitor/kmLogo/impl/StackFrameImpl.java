package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Variable;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.VisitorInterface;

public class StackFrameImpl extends MinimalEObjectImpl.Container implements StackFrame {
  protected EList<Variable> variables;

  protected StackFrameImpl() {
    super();
  }

  public EList<Variable> getVariables() {
    if(variables == null) {
    	variables = new EObjectContainmentEList<Variable>(kmLogo.visitor.kmLogo.Variable.class, this, KmLogoPackage.STACK_FRAME__VARIABLES);
    }
    return variables;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.STACK_FRAME;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.STACK_FRAME__VARIABLES:
    	getVariables().clear();
    	getVariables().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.Variable>) newValue);
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
    	return variables != null && !variables.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.STACK_FRAME__VARIABLES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__StackFrame(this);}
}
