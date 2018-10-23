package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Instruction;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.LogoProgram;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class LogoProgramImpl extends MinimalEObjectImpl.Container implements LogoProgram {
  private EList<Instruction> instructions;

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmlogo.interpreter.Instruction.class, this, KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LOGOPROGRAM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.InstructionImpl>) newValue);
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
    	return instructions != null;
    }
    return super.eIsSet(featureID);
  }

  public Turtle eval() {
    Turtle result;
    long start = ((long)logo.example.service.TimeService.time(this));
    Turtle turtle = ((Turtle)this.createTurtle());
    result = turtle;
    for(Instruction it: this.getInstructions()) {
      it.eval(turtle);
    }
    result = turtle;
    long stop = ((long)logo.example.service.TimeService.time(this));
    long time = ((long)(stop) - (start));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(time);
    logo.example.service.Display.show(turtle);
    return result;
  }

  public Turtle createTurtle() {
    Turtle result;
    Turtle turtle = ((Turtle)kmlogo.interpreter.KmLogoFactory.eINSTANCE.createTurtle());
    turtle.setPosition(kmlogo.interpreter.KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(kmlogo.interpreter.KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(kmlogo.interpreter.KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
