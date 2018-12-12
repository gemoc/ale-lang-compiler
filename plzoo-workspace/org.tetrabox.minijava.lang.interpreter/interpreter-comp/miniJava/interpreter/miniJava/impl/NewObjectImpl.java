package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewObject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class NewObjectImpl extends ExpressionImpl implements NewObject {
  protected Clazz type;

  protected EList<Expression> args;

  protected NewObjectImpl() {
    super();
  }

  public void setType(Clazz newType) {
    Clazz oldType = type;
    type = newType;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_OBJECT__TYPE, oldType, type));
  }

  public Clazz getType() {
    return type;}

  public EList<Expression> getArgs() {
    if(args == null) {
    	args = new EObjectContainmentEList<Expression>(miniJava.interpreter.miniJava.Expression.class, this, MiniJavaPackage.NEW_OBJECT__ARGS);
    }
    return args;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NEW_OBJECT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) newValue);
    return;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	getArgs().clear();
    	getArgs().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Expression>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) null);
    return;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	getArgs().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    return getType();
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    return getArgs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	return type != null;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.NEW_OBJECT__ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
