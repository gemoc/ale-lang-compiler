package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringConstant;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "StringConstant"
)
public class StringConstantImpl extends ExpressionImpl implements StringConstant {
  protected static final String VALUE_EDEFAULT = null;

  protected String value = VALUE_EDEFAULT;

  protected StringConstantImpl() {
    super();
  }

  public String getValue() {
    return value;}

  public void setValue(String value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.STRING_CONSTANT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.STRING_CONSTANT__VALUE:
    	setValue((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_CONSTANT__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.STRING_CONSTANT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_CONSTANT__VALUE:
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
    miniJava.interpreter.miniJava.StringValue ret = ((miniJava.interpreter.miniJava.StringValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createStringValue());
        ret.setValue(this.value);
        result = ret;
        ;
    return result;
  }
}
