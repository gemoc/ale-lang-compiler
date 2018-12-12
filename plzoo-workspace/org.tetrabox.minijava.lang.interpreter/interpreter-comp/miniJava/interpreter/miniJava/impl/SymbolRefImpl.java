package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolRef;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class SymbolRefImpl extends ExpressionImpl implements SymbolRef {
  protected Symbol symbol;

  protected SymbolRefImpl() {
    super();
  }

  public void setSymbol(Symbol newSymbol) {
    Symbol oldSymbol = symbol;
    symbol = newSymbol;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_REF__SYMBOL, oldSymbol, symbol));
  }

  public Symbol getSymbol() {
    return symbol;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.SYMBOL_REF;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_REF__SYMBOL:
    	setSymbol((miniJava.interpreter.miniJava.Symbol) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_REF__SYMBOL:
    	setSymbol((miniJava.interpreter.miniJava.Symbol) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_REF__SYMBOL:
    return getSymbol();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_REF__SYMBOL:
    	return symbol != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
