package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Variable;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class VariableImpl extends MinimalEObjectImpl.Container implements Variable {
  protected static final String NAME_EDEFAULT = null;

  protected static final double VALUE_EDEFAULT = 0.0;

  protected String name = NAME_EDEFAULT;

  protected double value = VALUE_EDEFAULT;

  protected VariableImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public double getValue() {
    return value;}

  public void setValue(double value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.VARIABLE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.VARIABLE__NAME:
    	setName((java.lang.String) newValue);
    return;
    case KmLogoPackage.VARIABLE__VALUE:
    	setValue((double) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.VARIABLE__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case KmLogoPackage.VARIABLE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.VARIABLE__NAME:
    return getName();
    case KmLogoPackage.VARIABLE__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.VARIABLE__NAME:
    	return name != NAME_EDEFAULT;
    case KmLogoPackage.VARIABLE__VALUE:
    	return value != VALUE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__Variable(this);}
}
