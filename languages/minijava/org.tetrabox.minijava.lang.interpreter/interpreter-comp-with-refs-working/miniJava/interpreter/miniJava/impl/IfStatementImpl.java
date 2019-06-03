package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IfStatement;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;

public class IfStatementImpl extends StatementImpl implements IfStatement {
	protected Block elseBlock;

	protected Expression expression;

	protected Block thenBlock;

	protected IfStatementImpl() {
		super();
	}

	public NotificationChain basicSetElseBlock(Block newElseBlock, NotificationChain msgs) {
		Block oldElseBlock = elseBlock;
		elseBlock = newElseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, oldElseBlock, newElseBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.IF_STATEMENT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public NotificationChain basicSetThenBlock(Block newThenBlock, NotificationChain msgs) {
		Block oldThenBlock = thenBlock;
		thenBlock = newThenBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, oldThenBlock, newThenBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

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

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
			return basicSetExpression(null, msgs);
		case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
			return basicSetThenBlock(null, msgs);
		case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
			return basicSetElseBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

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

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
			setExpression((Expression) newValue);
			return;
		case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
			setThenBlock((Block) newValue);
			return;
		case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
			setElseBlock((Block) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.IF_STATEMENT;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.IF_STATEMENT__EXPRESSION:
			setExpression((Expression) null);
			return;
		case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK:
			setThenBlock((Block) null);
			return;
		case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK:
			setElseBlock((Block) null);
			return;
		}
		super.eUnset(featureID);
	}

	public void evaluateStatement(State state) {
		BooleanValue booleanValue = ((BooleanValue) this.expression.evaluateExpression(state));
		if (booleanValue.isValue()) {
			this.thenBlock.evaluateStatement(state);
		} else {
			if ((this.elseBlock) != (null)) {
				this.elseBlock.evaluateStatement(state);
			}
		}
		;
	}

	public Block getElseBlock() {
		return elseBlock;
	}

	public Expression getExpression() {
		return expression;
	}

	public Block getThenBlock() {
		return thenBlock;
	}

	public void setElseBlock(Block newElseBlock) {
		if (newElseBlock != elseBlock) {
			NotificationChain msgs = null;
			if (elseBlock != null)
				msgs = ((InternalEObject) elseBlock).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
			if (newElseBlock != null)
				msgs = ((InternalEObject) newElseBlock).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
			msgs = basicSetElseBlock(newElseBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK,
					newElseBlock, newElseBlock));
	}

	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__EXPRESSION,
					newExpression, newExpression));
	}

	public void setThenBlock(Block newThenBlock) {
		if (newThenBlock != thenBlock) {
			NotificationChain msgs = null;
			if (thenBlock != null)
				msgs = ((InternalEObject) thenBlock).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
			if (newThenBlock != null)
				msgs = ((InternalEObject) newThenBlock).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
			msgs = basicSetThenBlock(newThenBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__THEN_BLOCK,
					newThenBlock, newThenBlock));
	}
}
