package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class NullValueImpl extends ValueImpl implements NullValue {
  protected NullValueImpl() {
    super();
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NULL_VALUE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public Value copyj() {
    Value result;
    miniJava.interpreter.miniJava.NullValue tmp = ((miniJava.interpreter.miniJava.NullValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createNullValue());
        result = tmp;
        ;
    return result;
  }
}
