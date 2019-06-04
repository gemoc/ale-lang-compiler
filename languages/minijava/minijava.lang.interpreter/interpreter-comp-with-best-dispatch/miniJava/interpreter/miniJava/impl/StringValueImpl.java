package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class StringValueImpl extends ValueImpl implements StringValue {
  protected static final String VALUE_EDEFAULT = null;

  protected String value = VALUE_EDEFAULT;

  @CompilationFinal
  private StringValueDispatchWrapperCustomToString cachedCustomToString;

  @CompilationFinal
  private StringValueDispatchWrapperCopyj cachedCopyj;

  protected StringValueImpl() {
    super();
    this.cachedCustomToString = new miniJava.interpreter.miniJava.impl.StringValueDispatchWrapperCustomToString(this);
    this.cachedCopyj = new miniJava.interpreter.miniJava.impl.StringValueDispatchWrapperCopyj(this);
  }

  public String getValue() {
    return value;}

  public void setValue(String value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.STRING_VALUE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    	setValue((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
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

  @TruffleBoundary
  public String customToString() {
    String result;
    result = this.value.toString();
        ;
    return result;
  }

  @TruffleBoundary
  public Value copyj() {
    Value result;
    miniJava.interpreter.miniJava.StringValue tmp = ((miniJava.interpreter.miniJava.StringValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createStringValue());
        tmp.setValue(this.value);
        result = tmp;
        ;
    return result;
  }

  public StringValueDispatchWrapperCustomToString getCachedCustomToString() {
    return this.cachedCustomToString;
  }

  public StringValueDispatchWrapperCopyj getCachedCopyj() {
    return this.cachedCopyj;
  }
}
