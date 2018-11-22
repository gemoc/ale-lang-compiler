package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BObject;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Field;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class BObjectImpl extends ExprImpl implements BObject {
  protected EList<Field> fields;

  protected BObjectImpl() {
    super();
  }

  public EList<Field> getFields() {
    if(fields == null) {
    	fields = new EObjectContainmentEList<Field>(interpreter.boa.interpreter.boa.Field.class, this, BoaPackage.BOBJECT__FIELDS);
    }
    return fields;
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.BOBJECT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.BOBJECT__FIELDS:
    	getFields().clear();
    	getFields().addAll((java.util.Collection<? extends interpreter.boa.interpreter.boa.Field>) newValue);
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
    case interpreter.boa.interpreter.boa.BoaPackage.BOBJECT__FIELDS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFields()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalMapRes ret = ((interpreter.boa.interpreter.boa.EvalMapRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalMapRes());
        for(interpreter.boa.interpreter.boa.Field x: this.getFields()) {
          interpreter.boa.interpreter.boa.EvalRes v = ((interpreter.boa.interpreter.boa.EvalRes)x.getValue().eval(ctx));
          execboa.MapService.put(ret.getValues(), x.getName(), v);
        }
        result = ret;
        ;
    return result;
  }
}
