package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.BoolConstant;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "BoolConstant"
)
public class BoolConstantImpl extends ExpressionImpl implements BoolConstant {
  protected static final String VALUE_EDEFAULT = null;

  protected String value = VALUE_EDEFAULT;

  protected BoolConstantImpl() {
    super();
  }

  public String getValue() {
    return value;}

  public void setValue(String value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.BOOL_CONSTANT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.BOOL_CONSTANT__VALUE:
    	setValue((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BOOL_CONSTANT__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.BOOL_CONSTANT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BOOL_CONSTANT__VALUE:
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

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.BooleanValue ret = ((miniJava.interpreter.miniJava.BooleanValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
        ret.setValue(java.util.Objects.equals((this.value), ("true")));
        result = ret;
        ;
    return result;
  }
}
