package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.LogoProgram;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class LogoProgramImpl extends MinimalEObjectImpl.Container implements LogoProgram {
  protected EList<Instruction> instructions;

  protected LogoProgramImpl() {
    super();
  }

  public EList<Instruction> getInstructions() {
    if(instructions == null) {
    	instructions = new EObjectContainmentEList<Instruction>(kmLogo.interpreter.kmLogo.Instruction.class, this, KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS);
    }
    return instructions;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LOGO_PROGRAM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	getInstructions().clear();
    	getInstructions().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.Instruction>) newValue);
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
    case kmLogo.interpreter.kmLogo.KmLogoPackage.LOGO_PROGRAM__INSTRUCTIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(turtle.getDrawings()));
    return result;
  }

  public Turtle createTurtle() {
    Turtle result;
    Turtle turtle = ((Turtle)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createTurtle());
    turtle.setPosition(kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
