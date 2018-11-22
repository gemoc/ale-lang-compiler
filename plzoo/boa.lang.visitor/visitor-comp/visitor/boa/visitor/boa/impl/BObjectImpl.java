package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.boa.visitor.boa.BObject;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Field;
import visitor.visitor.VisitorInterface;

public class BObjectImpl extends ExprImpl implements BObject {
  protected EList<Field> fields;

  protected BObjectImpl() {
    super();
  }

  public EList<Field> getFields() {
    if(fields == null) {
    	fields = new EObjectContainmentEList<Field>(visitor.boa.visitor.boa.Field.class, this, BoaPackage.BOBJECT__FIELDS);
    }
    return fields;
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.BOBJECT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	getFields().clear();
    	getFields().addAll((java.util.Collection<? extends visitor.boa.visitor.boa.Field>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	getFields().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    return getFields();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	return fields != null && !fields.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.boa.visitor.boa.BoaPackage.BOBJECT__FIELDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFields()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__BObject(this);}
}
