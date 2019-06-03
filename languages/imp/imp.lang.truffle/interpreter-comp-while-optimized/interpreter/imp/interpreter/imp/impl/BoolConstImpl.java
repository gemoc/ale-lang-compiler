package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.imp.interpreter.imp.BoolConst;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "BoolConst"
)
public class BoolConstImpl extends ExprImpl implements BoolConst {
  protected static final boolean VALUE_EDEFAULT = false;

  protected boolean value = VALUE_EDEFAULT;

  protected BoolConstImpl() {
    super();
  }

  public boolean isValue() {
    return value;}

  public void setValue(boolean value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.BOOL_CONST;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.BOOL_CONST__VALUE:
    	setValue((boolean) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.BOOL_CONST__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.BOOL_CONST__VALUE:
    return isValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.BOOL_CONST__VALUE:
    	return value != VALUE_EDEFAULT;
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

  public Value evaluate(Store s) {
    Value result;
    interpreter.imp.interpreter.imp.BoolValue tmp = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
        tmp.setValue(this.value);
        result = tmp;
        ;
    return result;
  }
}
