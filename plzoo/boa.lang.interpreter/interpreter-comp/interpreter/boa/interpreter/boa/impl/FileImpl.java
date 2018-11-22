package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.File;
import interpreter.boa.interpreter.boa.TopLevelCmd;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class FileImpl extends MinimalEObjectImpl.Container implements File {
  protected EList<TopLevelCmd> commands;

  protected FileImpl() {
    super();
  }

  public EList<TopLevelCmd> getCommands() {
    if(commands == null) {
    	commands = new EObjectContainmentEList<TopLevelCmd>(interpreter.boa.interpreter.boa.TopLevelCmd.class, this, BoaPackage.FILE__COMMANDS);
    }
    return commands;
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.FILE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	getCommands().clear();
    	getCommands().addAll((java.util.Collection<? extends interpreter.boa.interpreter.boa.TopLevelCmd>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	getCommands().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    return getCommands();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	return commands != null && !commands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.FILE__COMMANDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void eval() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("v1");
        interpreter.boa.interpreter.boa.Ctx ctx = ((interpreter.boa.interpreter.boa.Ctx)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
        for(interpreter.boa.interpreter.boa.TopLevelCmd it: this.getCommands()) {
          it.nextLine(ctx);
        }
        ;
  }
}
