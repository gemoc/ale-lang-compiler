package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.ArrayAccess;
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
    description = "ArrayAccess"
)
public class ArrayAccessImpl extends ExpressionImpl implements ArrayAccess {
  
  protected Expression object;

  
  protected Expression index;

  protected ArrayAccessImpl() {
    super();
  }

  @TruffleBoundary
  public void setObject(Expression newObject) {
    if (newObject != object) {
    	NotificationChain msgs = null;
    	if (object != null)
    		msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__OBJECT, null, msgs);
    	if (newObject != null)
    		msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__OBJECT, null, msgs);
    	msgs = basicSetObject(newObject, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__OBJECT, newObject, newObject));
  }

  @TruffleBoundary
  public NotificationChain basicSetObject(Expression newObject, NotificationChain msgs) {
    Expression oldObject = object;
    object = newObject;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__OBJECT, oldObject, newObject);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getObject() {
    return object;
  }

  @TruffleBoundary
  public void setIndex(Expression newIndex) {
    if (newIndex != index) {
    	NotificationChain msgs = null;
    	if (index != null)
    		msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__INDEX, null, msgs);
    	if (newIndex != null)
    		msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__INDEX, null, msgs);
    	msgs = basicSetIndex(newIndex, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__INDEX, newIndex, newIndex));
  }

  @TruffleBoundary
  public NotificationChain basicSetIndex(Expression newIndex, NotificationChain msgs) {
    Expression oldIndex = index;
    index = newIndex;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__INDEX, oldIndex, newIndex);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getIndex() {
    return index;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.ARRAY_ACCESS;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_ACCESS__OBJECT:
    	setObject((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.ARRAY_ACCESS__INDEX:
    	setIndex((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_ACCESS__OBJECT:
    	setObject((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.ARRAY_ACCESS__INDEX:
    	setIndex((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_ACCESS__OBJECT:
    return getObject();
    case MiniJavaPackage.ARRAY_ACCESS__INDEX:
    return getIndex();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_ACCESS__OBJECT:
    	return object != null;
    case MiniJavaPackage.ARRAY_ACCESS__INDEX:
    	return index != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__OBJECT:
    	return basicSetObject(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_ACCESS__INDEX:
    	return basicSetIndex(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.ArrayRefValue arrayVal = ((miniJava.interpreter.miniJava.ArrayRefValue)this.object.evaluateExpression(state));
        miniJava.interpreter.miniJava.IntegerValue indexVal = ((miniJava.interpreter.miniJava.IntegerValue)this.index.evaluateExpression(state));
        result = arrayVal.getInstance().getValue().get(indexVal.getValue()).copyj();
        ;
    return result;
  }
}
