package boa.interpreter.boa.impl;

import boa.interpreter.boa.BObject;
import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Field;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

@NodeInfo(
    description = "BObject"
)
public class BObjectImpl extends ExprImpl implements BObject {
  protected EList<Field> fields;

  protected BObjectImpl() {
    super();
  }

  @TruffleBoundary
  public EList<Field> getFields() {
    if(fields == null) {
    	fields = new EObjectContainmentEList<Field>(boa.interpreter.boa.Field.class, this, BoaPackage.BOBJECT__FIELDS);
    }
    return fields;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.BOBJECT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	getFields().clear();
    	getFields().addAll((java.util.Collection<? extends boa.interpreter.boa.Field>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	getFields().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    return getFields();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	return fields != null && !fields.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.BOBJECT__FIELDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFields()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
