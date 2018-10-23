package kmlogo.interpreter.impl;

import java.lang.Object;
import java.lang.String;
import kmlogo.interpreter.Instruction;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Parameter;
import kmlogo.interpreter.ProcCall;
import kmlogo.interpreter.ProcDeclaration;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ProcDeclarationImpl extends InstructionImpl implements ProcDeclaration {
  private String NAME_EDEFAULT = null;

  private String name = NAME_EDEFAULT;

  private EList<Parameter> args;

  private EList<ProcCall> procCall;

  private EList<Instruction> instructions;

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public EList<Parameter> getArgs() {
    if(args == null) {
    	args = new EObjectContainmentEList<Parameter>(kmlogo.interpreter.Parameter.class, this, KmLogoPackage.PROC_DECLARATION__ARGS);
    }
    return args;
  }

  public EList<ProcCall> getProcCall() {
    if(procCall == null) {
    	procCall = new EObjectContainmentEList<ProcCall>(kmlogo.interpreter.ProcCall.class, this, KmLogoPackage.PROC_DECLARATION__PROC_CALL);
    }
    return procCall;
  }

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmlogo.interpreter.Instruction.class, this, KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PROCDECLARATION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PROC_DECLARATION__NAME:
    	setName((java.lang.String) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__ARGS:
    	getArgs().clear();
    	getArgs().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.ParameterImpl>) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	getProcCall().clear();
    	getProcCall().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.ProcCallImpl>) newValue);
    return;
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.InstructionImpl>) newValue);
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
    	return args != null;
    case KmLogoPackage.PROC_DECLARATION__PROC_CALL:
    	return procCall != null;
    case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS:
    	return instructions != null;
    }
    return super.eIsSet(featureID);
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

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
    return result;
  }
}
