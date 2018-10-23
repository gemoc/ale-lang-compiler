package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Block;
import kmlogo.interpreter.Instruction;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class BlockImpl extends InstructionImpl implements Block {
  private EList<Instruction> instructions;

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmlogo.interpreter.Instruction.class, this, KmLogoPackage.BLOCK__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BLOCK;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BLOCK__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.InstructionImpl>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BLOCK__INSTRUCTIONS:
    	getInstructions().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.BLOCK__INSTRUCTIONS:
    	return getInstructions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BLOCK__INSTRUCTIONS:
    	return instructions != null;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    for(Instruction inst: this.getInstructions()) {
      inst.eval(turtle);
    }
    result = 0.0;
    return result;
  }
}
