package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.PrintStatement;
import miniJava.interpreter.miniJava.State;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "PrintStatement"
)
public class PrintStatementImpl extends StatementImpl implements PrintStatement {
  @Child
  protected Expression expression;

  @CompilationFinal
  private PrintStatementDispatchWrapperEvaluateStatement cachedEvaluateStatement;

  protected PrintStatementImpl() {
    super();
    this.cachedEvaluateStatement = new miniJava.interpreter.miniJava.impl.PrintStatementDispatchWrapperEvaluateStatement(this);
  }

  @TruffleBoundary
  public void setExpression(Expression newExpression) {
    if (newExpression != expression) {
    	NotificationChain msgs = null;
    	if (expression != null)
    		msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.PRINT_STATEMENT__EXPRESSION, null, msgs);
    	if (newExpression != null)
    		msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.PRINT_STATEMENT__EXPRESSION, null, msgs);
    	msgs = basicSetExpression(newExpression, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.PRINT_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  @TruffleBoundary
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.PRINT_STATEMENT__EXPRESSION, oldExpression, newExpression);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getExpression() {
    return expression;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.PRINT_STATEMENT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.PRINT_STATEMENT__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.PRINT_STATEMENT__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.PRINT_STATEMENT__EXPRESSION:
    return getExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.PRINT_STATEMENT__EXPRESSION:
    	return expression != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.PRINT_STATEMENT__EXPRESSION:
    	return basicSetExpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void evaluateStatement(State state) {
    java.lang.String res = ((java.lang.String)this.expression.evaluateExpression(state).customToString());
        state.println(res);
        ;
  }

  public PrintStatementDispatchWrapperEvaluateStatement getCachedEvaluateStatement() {
    return this.cachedEvaluateStatement;
  }
}
