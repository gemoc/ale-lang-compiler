package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.File;
import boa.interpreter.boa.TopLevelCmd;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
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

  @TruffleBoundary
  public EList<TopLevelCmd> getCommands() {
    if(commands == null) {
    	commands = new EObjectContainmentEList<TopLevelCmd>(boa.interpreter.boa.TopLevelCmd.class, this, BoaPackage.FILE__COMMANDS);
    }
    return commands;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.FILE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	getCommands().clear();
    	getCommands().addAll((java.util.Collection<? extends boa.interpreter.boa.TopLevelCmd>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	getCommands().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    return getCommands();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	return commands != null && !commands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.FILE__COMMANDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void eval() {
    Ctx ctx = ((Ctx)boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
    for(TopLevelCmd it: this.getCommands()) {
      it.nextLine(ctx);
    }
  }
}
