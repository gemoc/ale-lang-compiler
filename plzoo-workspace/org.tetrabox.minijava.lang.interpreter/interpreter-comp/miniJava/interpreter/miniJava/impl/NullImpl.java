package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Null;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class NullImpl extends ExpressionImpl implements Null {
  protected NullImpl() {
    super();
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NULL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    result = miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createNullValue();
        ;
    return result;
  }
}
