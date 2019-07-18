package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "IfStatement"
)
public class IfStatementImpl extends StatementImpl {
	@Child
	protected ExpressionImpl expression;

	@Child
	protected BlockImpl thenBlock;

	@Child
	protected BlockImpl elseBlock;

	protected IfStatementImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.IF_STATEMENT;
	}

	@TruffleBoundary
	public ExpressionImpl getExpression() {
		return expression;
	}

	@TruffleBoundary
	public NotificationChain basicSetExpression(ExpressionImpl newExpression, NotificationChain msgs) {
		ExpressionImpl oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setExpression(ExpressionImpl newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__EXPRESSION, newExpression, newExpression));
	}

	@TruffleBoundary
	public BlockImpl getThenBlock() {
		return thenBlock;
	}

	@TruffleBoundary
	public NotificationChain basicSetThenBlock(BlockImpl newThenBlock, NotificationChain msgs) {
		BlockImpl oldThenBlock = thenBlock;
		thenBlock = newThenBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, oldThenBlock, newThenBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setThenBlock(BlockImpl newThenBlock) {
		if (newThenBlock != thenBlock) {
			NotificationChain msgs = null;
			if (thenBlock != null)
				msgs = ((InternalEObject) thenBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
			if (newThenBlock != null)
				msgs = ((InternalEObject) newThenBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, null, msgs);
			msgs = basicSetThenBlock(newThenBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__THEN_BLOCK, newThenBlock, newThenBlock));
	}

	@TruffleBoundary
	public BlockImpl getElseBlock() {
		return elseBlock;
	}

	@TruffleBoundary
	public NotificationChain basicSetElseBlock(BlockImpl newElseBlock, NotificationChain msgs) {
		BlockImpl oldElseBlock = elseBlock;
		elseBlock = newElseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, oldElseBlock, newElseBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setElseBlock(BlockImpl newElseBlock) {
		if (newElseBlock != elseBlock) {
			NotificationChain msgs = null;
			if (elseBlock != null)
				msgs = ((InternalEObject) elseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
			if (newElseBlock != null)
				msgs = ((InternalEObject) newElseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
			msgs = basicSetElseBlock(newElseBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK, newElseBlock, newElseBlock));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.IF_STATEMENT__EXPRESSION :
				return basicSetExpression(null, msgs);
			case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK :
				return basicSetThenBlock(null, msgs);
			case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK :
				return basicSetElseBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.IF_STATEMENT__EXPRESSION :
				return getExpression();
			case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK :
				return getThenBlock();
			case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK :
				return getElseBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.IF_STATEMENT__EXPRESSION :
				setExpression((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK :
				setThenBlock((BlockImpl) newValue);
				return;
			case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK :
				setElseBlock((BlockImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.IF_STATEMENT__EXPRESSION :
				setExpression((ExpressionImpl) null);
				return;
			case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK :
				setThenBlock((BlockImpl) null);
				return;
			case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK :
				setElseBlock((BlockImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.IF_STATEMENT__EXPRESSION :
				return expression != null;
			case MiniJavaPackage.IF_STATEMENT__THEN_BLOCK :
				return thenBlock != null;
			case MiniJavaPackage.IF_STATEMENT__ELSE_BLOCK :
				return elseBlock != null;
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatement(StateImpl state) {
		BooleanValueImpl booleanValue = ((BooleanValueImpl) (((BooleanValueImpl) (((ExpressionImpl) (this.getExpression())).evaluateExpression((StateImpl) (state))))));
		if (booleanValue.isValue()) {
			((BlockImpl) (this.getThenBlock())).evaluateStatement((StateImpl) (state));
		}
		else {
			if (!EqualService.equals((this.getElseBlock()), (null))) {
				((BlockImpl) (this.getElseBlock())).evaluateStatement((StateImpl) (state));
			}
		}
	}
}
