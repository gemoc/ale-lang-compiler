package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.String;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Parameter;
import kmLogo.visitor.kmLogo.ProcCall;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import visitor.VisitorInterface;

public class ProcDeclarationImpl extends InstructionImpl implements ProcDeclaration {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Parameter> args;

  protected EList<ProcCall> procCall;

  protected EList<Instruction> instructions;

  protected ProcDeclarationImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public EList<Parameter> getArgs() {
    if(args == null) {
    	args = new EObjectContainmentEList<Parameter>(kmLogo.visitor.kmLogo.Parameter.class, this, KmLogoPackage.PROC_DECLARATION__ARGS);
    }
    return args;
  }

  public EList<ProcCall> getProcCall() {
    if (procCall == null) {
    	procCall = new EObjectContainmentWithInverseEList<ProcCall>(ProcCall.class, this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, KmLogoPackage.PROC_CALL__DECLARATION);
    }
    return procCall;
  }

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmLogo.visitor.kmLogo.Instruction.class, this, KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PROC_DECLARATION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PROC_DECLARATION__NAME:
    	setName((java.lang.String) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__ARGS:
    	getArgs().clear();
    	getArgs().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.Parameter>) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	getProcCall().clear();
    	getProcCall().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.ProcCall>) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.Instruction>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_DECLARATION__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case KmLogoPackage.PROC_DECLARATION__ARGS:
    	getArgs().clear();
    return;
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	getProcCall().clear();
    return;
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	getInstructions().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PROC_DECLARATION__NAME:
    return getName();
    case KmLogoPackage.PROC_DECLARATION__ARGS:
    return getArgs();
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    return getProcCall();
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    return getInstructions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_DECLARATION__NAME:
    	return name != NAME_EDEFAULT;
    case KmLogoPackage.PROC_DECLARATION__ARGS:
    	return args != null && !args.isEmpty();
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	return procCall != null && !procCall.isEmpty();
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	return instructions != null && !instructions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.PROC_DECLARATION__ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
    case kmLogo.visitor.kmLogo.KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getProcCall()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__ProcDeclaration(this);}
}
