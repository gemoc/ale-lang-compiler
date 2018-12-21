package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.File;
import boa.interpreter.boa.TopLevelCmd;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
    description = "File"
)
public class FileImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements File {
  protected EList<TopLevelCmd> commands;

  @Children
  private TopLevelCmd[] commandsArr;

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
    if(this.commandsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.commands != null) this.commandsArr = this.commands.toArray(new boa.interpreter.boa.TopLevelCmd[0]);
        				else this.commandsArr = new boa.interpreter.boa.TopLevelCmd[] {};
        				
        			};
    boa.interpreter.boa.Ctx ctx = ((boa.interpreter.boa.Ctx)boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
        for(boa.interpreter.boa.TopLevelCmd it: this.commandsArr) {
          it.nextLine(ctx);
        }
        ;
  }
}
