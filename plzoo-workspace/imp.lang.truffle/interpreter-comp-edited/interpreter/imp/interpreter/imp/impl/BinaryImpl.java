package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.imp.interpreter.imp.Binary;
import interpreter.imp.interpreter.imp.BinaryOp;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Binary"
)
public class BinaryImpl extends ExprImpl implements Binary {
  protected static final BinaryOp OP_EDEFAULT = interpreter.imp.interpreter.imp.BinaryOp.ADD;

  protected BinaryOp op = OP_EDEFAULT;

  @Child
  protected Expr lhs;

  @Child
  protected Expr rhs;

  protected BinaryImpl() {
    super();
  }

  public BinaryOp getOp() {
    return op;}

  public void setOp(BinaryOp op) {
    this.op = op;}

  @TruffleBoundary
  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.BINARY__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.BINARY__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.BINARY__LHS, newLhs, newLhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.BINARY__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getLhs() {
    return lhs;}

  @TruffleBoundary
  public void setRhs(Expr newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.BINARY__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.BINARY__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.BINARY__RHS, newRhs, newRhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.BINARY__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getRhs() {
    return rhs;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.BINARY;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.BINARY__LHS:
    	setLhs((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    case ImpPackage.BINARY__RHS:
    	setRhs((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    case ImpPackage.BINARY__OP:
    	setOp((interpreter.imp.interpreter.imp.BinaryOp) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.BINARY__LHS:
    	setLhs((interpreter.imp.interpreter.imp.Expr) null);
    return;
    case ImpPackage.BINARY__RHS:
    	setRhs((interpreter.imp.interpreter.imp.Expr) null);
    return;
    case ImpPackage.BINARY__OP:
    	setOp(OP_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.BINARY__LHS:
    return getLhs();
    case ImpPackage.BINARY__RHS:
    return getRhs();
    case ImpPackage.BINARY__OP:
    return getOp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.BINARY__LHS:
    	return lhs != null;
    case ImpPackage.BINARY__RHS:
    	return rhs != null;
    case ImpPackage.BINARY__OP:
    	return op != OP_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.BINARY__LHS:
    	return basicSetLhs(null, msgs);
    case interpreter.imp.interpreter.imp.ImpPackage.BINARY__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluate(Store s) {
    Value result;
    interpreter.imp.interpreter.imp.Value lv = ((interpreter.imp.interpreter.imp.Value)this.lhs.evaluate(s));
        interpreter.imp.interpreter.imp.Value rv = ((interpreter.imp.interpreter.imp.Value)this.rhs.evaluate(s));
        result = interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue();
        if(lv instanceof interpreter.imp.interpreter.imp.IntValue) {
          interpreter.imp.interpreter.imp.IntValue clv = ((interpreter.imp.interpreter.imp.IntValue)lv);
          if(rv instanceof interpreter.imp.interpreter.imp.IntValue) {
            interpreter.imp.interpreter.imp.IntValue crv = ((interpreter.imp.interpreter.imp.IntValue)rv);
            if(java.util.Objects.equals((this.op.getValue()), (0))) {
              interpreter.imp.interpreter.imp.IntValue tmp2 = ((interpreter.imp.interpreter.imp.IntValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue());
              tmp2.setValue((clv.getValue()) + (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (1))) {
              interpreter.imp.interpreter.imp.IntValue tmp2 = ((interpreter.imp.interpreter.imp.IntValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue());
              tmp2.setValue((clv.getValue()) - (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (2))) {
              interpreter.imp.interpreter.imp.IntValue tmp2 = ((interpreter.imp.interpreter.imp.IntValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue());
              tmp2.setValue((clv.getValue()) * (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (3))) {
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue((clv.getValue()) < (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (4))) {
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue((clv.getValue()) <= (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (5))) {
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue(java.util.Objects.equals((clv.getValue()), (crv.getValue())));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (6))) {
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue((clv.getValue()) >= (crv.getValue()));
              result = tmp2;
            }
            if(java.util.Objects.equals((this.op.getValue()), (7))) {
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue((clv.getValue()) > (crv.getValue()));
              result = tmp2;
            }
          }
        }
        else {
          if(lv instanceof interpreter.imp.interpreter.imp.BoolValue) {
            interpreter.imp.interpreter.imp.BoolValue clv = ((interpreter.imp.interpreter.imp.BoolValue)lv);
            if(rv instanceof interpreter.imp.interpreter.imp.BoolValue) {
              interpreter.imp.interpreter.imp.BoolValue crv = ((interpreter.imp.interpreter.imp.BoolValue)rv);
              if(java.util.Objects.equals((this.op.getValue()), (8))) {
                interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
                tmp2.setValue(((clv.isValue()) && (crv.isValue())));
                result = tmp2;
              }
              if(java.util.Objects.equals((this.op.getValue()), (9))) {
                interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
                tmp2.setValue(((clv.isValue()) || (crv.isValue())));
                result = tmp2;
              }
            }
          }
        }
        ;
    return result;
  }
}
