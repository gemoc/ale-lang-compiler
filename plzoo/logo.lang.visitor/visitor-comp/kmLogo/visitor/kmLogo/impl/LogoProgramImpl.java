package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.LogoProgram;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.VisitorInterface;

public class LogoProgramImpl extends MinimalEObjectImpl.Container implements LogoProgram {
  protected EList<Instruction> instructions;

  protected LogoProgramImpl() {
    super();
  }

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmLogo.visitor.kmLogo.Instruction.class, this, KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LOGO_PROGRAM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.Instruction>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	getInstructions().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    return getInstructions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	return instructions != null && !instructions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__LogoProgram(this);}
}
