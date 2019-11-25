package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.ArrayLength;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "ArrayLength"
)
public class ArrayLengthImpl extends ExpressionImpl implements ArrayLength {
  @Child
  protected Expression array;

  protected ArrayLengthImpl() {
    super();
  }

  @TruffleBoundary
  public void setArray(Expression newArray) {
    if (newArray != array) {
    	NotificationChain msgs = null;
    	if (array != null)
    		msgs = ((InternalEObject)array).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_LENGTH__ARRAY, null, msgs);
    	if (newArray != null)
    		msgs = ((InternalEObject)newArray).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_LENGTH__ARRAY, null, msgs);
    	msgs = basicSetArray(newArray, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_LENGTH__ARRAY, newArray, newArray));
  }

  @TruffleBoundary
  public NotificationChain basicSetArray(Expression newArray, NotificationChain msgs) {
    Expression oldArray = array;
    array = newArray;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_LENGTH__ARRAY, oldArray, newArray);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getArray() {
    return array;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.ARRAY_LENGTH;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_LENGTH__ARRAY:
    	setArray((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_LENGTH__ARRAY:
    	setArray((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_LENGTH__ARRAY:
    return getArray();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_LENGTH__ARRAY:
    	return array != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_LENGTH__ARRAY:
    	return basicSetArray(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.ArrayRefValue arrayRef = ((miniJava.interpreter.miniJava.ArrayRefValue)this.array.evaluateExpression(state));
        int size = ((int)arrayRef.getInstance().getSize());
        miniJava.interpreter.miniJava.IntegerValue tmp = ((miniJava.interpreter.miniJava.IntegerValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
        tmp.setValue(size);
        result = tmp;
        ;
    return result;
  }
}
