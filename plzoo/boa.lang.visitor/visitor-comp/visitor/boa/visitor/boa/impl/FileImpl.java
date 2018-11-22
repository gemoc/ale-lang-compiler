package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.File;
import visitor.boa.visitor.boa.TopLevelCmd;
import visitor.visitor.VisitorInterface;

public class FileImpl extends MinimalEObjectImpl.Container implements File {
  protected EList<TopLevelCmd> commands;

  protected FileImpl() {
    super();
  }

  public EList<TopLevelCmd> getCommands() {
    if(commands == null) {
    	commands = new EObjectContainmentEList<TopLevelCmd>(visitor.boa.visitor.boa.TopLevelCmd.class, this, BoaPackage.FILE__COMMANDS);
    }
    return commands;
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.FILE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.FILE__COMMANDS:
    	getCommands().clear();
    	getCommands().addAll((java.util.Collection<? extends visitor.boa.visitor.boa.TopLevelCmd>) newValue);
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
    case visitor.boa.visitor.boa.BoaPackage.FILE__COMMANDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__File(this);}
}
