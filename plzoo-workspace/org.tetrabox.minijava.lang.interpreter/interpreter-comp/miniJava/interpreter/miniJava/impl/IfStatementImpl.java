package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IfStatement;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "IfStatement"
)
public class IfStatementImpl extends StatementImpl implements IfStatement {
  @Child
  protected Expression expression;

  @Child
  protected Block thenBlock;

  @Child
  protected Block elseBlock;

  protected IfStatementImpl() {
    super();
  }

  @TruffleBoundary
  public void setExpression(Expression newExpression) {
    if (newExpression != expression) {
    	NotificationChain msgs = null;
    	if (expression != null)
    		msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
    	if (newExpression != null)
    		msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
    	msgs = basicSetExpression(newExpression, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  @TruffleBoundary
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__EXPRESSION, oldExpression, newExpression);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getExpression() {
    return expression;
  }

  @TruffleBoundary
  public void setThenBlock(Block newThenBlock) {
    if (newThenBlock != thenBlock) {
    	NotificationChain msgs = null;
    	if (thenBlock != null)
    		msgs = ((InternalEObject)thenBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
    	if (newThenBlock != null)
    		msgs = ((InternalEObject)newThenBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
    	msgs = basicSetThenBlock(newThenBlock, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, newThenBlock, newThenBlock));
  }

  @TruffleBoundary
  public NotificationChain basicSetThenBlock(Block newThenBlock, NotificationChain msgs) {
    Block oldThenBlock = thenBlock;
    thenBlock = newThenBlock;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, oldThenBlock, newThenBlock);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Block getThenBlock() {
    return thenBlock;
  }

  @TruffleBoundary
  public void setElseBlock(Block newElseBlock) {
    if (newElseBlock != elseBlock) {
    	NotificationChain msgs = null;
    	if (elseBlock != null)
    		msgs = ((InternalEObject)elseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
    	if (newElseBlock != null)
    		msgs = ((InternalEObject)newElseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
    	msgs = basicSetElseBlock(newElseBlock, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, newElseBlock, newElseBlock));
  }

  @TruffleBoundary
  public NotificationChain basicSetElseBlock(Block newElseBlock, NotificationChain msgs) {
    Block oldElseBlock = elseBlock;
    elseBlock = newElseBlock;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, oldElseBlock, newElseBlock);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Block getElseBlock() {
    return elseBlock;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.IF_STATEMENT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
    	setThenBlock((miniJava.interpreter.miniJava.Block) newValue);
    return;
    case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
    	setElseBlock((miniJava.interpreter.miniJava.Block) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
    	setThenBlock((miniJava.interpreter.miniJava.Block) null);
    return;
    case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
    	setElseBlock((miniJava.interpreter.miniJava.Block) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
    return getExpression();
    case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
    return getThenBlock();
    case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
    return getElseBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
    	return expression != null;
    case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
    	return thenBlock != null;
    case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
    	return elseBlock != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__EXPRESSION:
    	return basicSetExpression(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
    	return basicSetThenBlock(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
    	return basicSetElseBlock(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void evaluateStatement(State state) {
    miniJava.interpreter.miniJava.BooleanValue booleanValue = ((miniJava.interpreter.miniJava.BooleanValue)this.expression.evaluateExpression(state));
        if(booleanValue.isValue()) {
          this.thenBlock.evaluateStatement(state);
        }
        else {
          if((this.elseBlock) != (null)) {
            this.elseBlock.evaluateStatement(state);
          }
        }
        ;
  }
}
