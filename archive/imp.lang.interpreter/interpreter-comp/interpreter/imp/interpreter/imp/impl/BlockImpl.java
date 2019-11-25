package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Block;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class BlockImpl extends StmtImpl implements Block {
  protected EList<Stmt> stmts;

  protected BlockImpl() {
    super();
  }

  public EList<Stmt> getStmts() {
    if(stmts == null) {
    	stmts = new EObjectContainmentEList<Stmt>(interpreter.imp.interpreter.imp.Stmt.class, this, ImpPackage.BLOCK__STMTS);
    }
    return stmts;
  }

  protected EClass eStaticClass() {
    return ImpPackage.Literals.BLOCK;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	getStmts().clear();
    	getStmts().addAll((java.util.Collection<? extends interpreter.imp.interpreter.imp.Stmt>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	getStmts().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    return getStmts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	return stmts != null && !stmts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.BLOCK__STMTS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getStmts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Store execute(Store s) {
    Store result;
    result = s;
        for(interpreter.imp.interpreter.imp.Stmt e: this.getStmts()) {
          result = e.execute(result);
        }
        ;
    return result;
  }
}
