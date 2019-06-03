package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
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

@NodeInfo(
    description = "Block"
)
public class BlockImpl extends StmtImpl implements Block {
  protected EList<Stmt> stmts;

  @Children
  private Stmt[] stmtsArr;

  protected BlockImpl() {
    super();
  }

  @TruffleBoundary
  public EList<Stmt> getStmts() {
    if(stmts == null) {
    	stmts = new EObjectContainmentEList<Stmt>(interpreter.imp.interpreter.imp.Stmt.class, this, ImpPackage.BLOCK__STMTS);
    }
    return stmts;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.BLOCK;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	getStmts().clear();
    	getStmts().addAll((java.util.Collection<? extends interpreter.imp.interpreter.imp.Stmt>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	getStmts().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    return getStmts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.BLOCK__STMTS:
    	return stmts != null && !stmts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
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
    if(this.stmtsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.stmtsArr = this.stmts.toArray(new interpreter.imp.interpreter.imp.Stmt[0]);
        			};
    result = s;
        for(interpreter.imp.interpreter.imp.Stmt e: this.stmtsArr) {
          result = e.execute(result);
        }
        ;
    return result;
  }
}
