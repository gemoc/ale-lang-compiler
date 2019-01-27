package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldAccess;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "FieldAccess"
)
public class FieldAccessImpl extends ExpressionImpl implements FieldAccess {
  @Child
  protected Expression receiver;

  protected Field field;

  protected FieldAccessImpl() {
    super();
  }

  @TruffleBoundary
  public void setReceiver(Expression newReceiver) {
    if (newReceiver != receiver) {
    	NotificationChain msgs = null;
    	if (receiver != null)
    		msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
    	if (newReceiver != null)
    		msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
    	msgs = basicSetReceiver(newReceiver, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_ACCESS__RECEIVER, newReceiver, newReceiver));
  }

  @TruffleBoundary
  public NotificationChain basicSetReceiver(Expression newReceiver, NotificationChain msgs) {
    Expression oldReceiver = receiver;
    receiver = newReceiver;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_ACCESS__RECEIVER, oldReceiver, newReceiver);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getReceiver() {
    return receiver;
  }

  @TruffleBoundary
  public void setField(Field newField) {
    Field oldField = field;
    field = newField;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__FIELD, oldField, field));
  }

  @TruffleBoundary
  public Field getField() {
    if (field != null && field.eIsProxy()) {
    	InternalEObject oldfield = (InternalEObject) field;
    	field = (Field) eResolveProxy(oldfield);
    	if (field != oldfield) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FIELD_ACCESS__FIELD,
    					oldfield, field));
    	}
    }
    return field;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.FIELD_ACCESS;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
    	setReceiver((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.FIELD_ACCESS__FIELD:
    	setField((miniJava.interpreter.miniJava.Field) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
    	setReceiver((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.FIELD_ACCESS__FIELD:
    	setField((miniJava.interpreter.miniJava.Field) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
    return getReceiver();
    case MiniJavaPackage.FIELD_ACCESS__FIELD:
    return getField();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
    	return receiver != null;
    case MiniJavaPackage.FIELD_ACCESS__FIELD:
    	return field != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_ACCESS__RECEIVER:
    	return basicSetReceiver(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.ObjectRefValue tmp0 = ((miniJava.interpreter.miniJava.ObjectRefValue)this.receiver.evaluateExpression(state));
        miniJava.interpreter.miniJava.ObjectInstance realReceiver = ((miniJava.interpreter.miniJava.ObjectInstance)tmp0.getInstance());
        miniJava.interpreter.miniJava.Field fld = ((miniJava.interpreter.miniJava.Field)this.field);
        miniJava.interpreter.miniJava.FieldBinding fb = ((miniJava.interpreter.miniJava.FieldBinding)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(realReceiver.getFieldbindings(), (x) -> org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((x.getField()), (fld)))));
        result = fb.getValue();
        ;
    return result;
  }
}
