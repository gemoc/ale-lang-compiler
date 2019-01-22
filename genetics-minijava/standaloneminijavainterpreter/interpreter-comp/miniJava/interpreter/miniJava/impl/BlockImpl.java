package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

@NodeInfo(
    description = "Block"
)
public class BlockImpl extends StatementImpl implements Block {
  protected EList<Statement> statements;

  protected BlockImpl() {
    super();
  }

  @TruffleBoundary
  public EList<Statement> getStatements() {
    if(statements == null) {
    	statements = new EObjectContainmentEList<Statement>(miniJava.interpreter.miniJava.Statement.class, this, MiniJavaPackage.BLOCK__STATEMENTS);
    }
    return statements;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.BLOCK;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.BLOCK__STATEMENTS:
    	getStatements().clear();
    	getStatements().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Statement>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BLOCK__STATEMENTS:
    	getStatements().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.BLOCK__STATEMENTS:
    return getStatements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BLOCK__STATEMENTS:
    	return statements != null && !statements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.BLOCK__STATEMENTS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getStatements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void evaluateStatementKeepContext(State state) {
    state.pushNewContext();
        miniJava.interpreter.miniJava.Frame currentFrame = ((miniJava.interpreter.miniJava.Frame)state.findCurrentFrame());
        int lgt = ((int)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.statements));
        int i = ((int)0);
        while ((((i) < (lgt)) && (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((currentFrame.getReturnValue()), (null))))) {
          org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.statements, i).evaluateStatement(state);
          i = (i) + (1);
        }
        ;
  }

  public void evaluateStatement(State state) {
    this.evaluateStatementKeepContext(state);
        state.popCurrentContext();
        ;
  }
}
