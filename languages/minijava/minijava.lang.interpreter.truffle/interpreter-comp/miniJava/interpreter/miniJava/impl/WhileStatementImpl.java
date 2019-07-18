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

@NodeInfo(
		description = "WhileStatement"
)
public class WhileStatementImpl extends StatementImpl {
	@Child
	protected ExpressionImpl condition;

	@Child
	protected BlockImpl block;

	protected WhileStatementImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.WHILE_STATEMENT;
	}

	@TruffleBoundary
	public ExpressionImpl getCondition() {
		return condition;
	}

	@TruffleBoundary
	public NotificationChain basicSetCondition(ExpressionImpl newCondition, NotificationChain msgs) {
		ExpressionImpl oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.WHILE_STATEMENT__CONDITION, oldCondition, newCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setCondition(ExpressionImpl newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.WHILE_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.WHILE_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.WHILE_STATEMENT__CONDITION, newCondition, newCondition));
	}

	@TruffleBoundary
	public BlockImpl getBlock() {
		return block;
	}

	@TruffleBoundary
	public NotificationChain basicSetBlock(BlockImpl newBlock, NotificationChain msgs) {
		BlockImpl oldBlock = block;
		block = newBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.WHILE_STATEMENT__BLOCK, oldBlock, newBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setBlock(BlockImpl newBlock) {
		if (newBlock != block) {
			NotificationChain msgs = null;
			if (block != null)
				msgs = ((InternalEObject) block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.WHILE_STATEMENT__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject) newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.WHILE_STATEMENT__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.WHILE_STATEMENT__BLOCK, newBlock, newBlock));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.WHILE_STATEMENT__CONDITION :
				return basicSetCondition(null, msgs);
			case MiniJavaPackage.WHILE_STATEMENT__BLOCK :
				return basicSetBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.WHILE_STATEMENT__CONDITION :
				return getCondition();
			case MiniJavaPackage.WHILE_STATEMENT__BLOCK :
				return getBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.WHILE_STATEMENT__CONDITION :
				setCondition((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.WHILE_STATEMENT__BLOCK :
				setBlock((BlockImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.WHILE_STATEMENT__CONDITION :
				setCondition((ExpressionImpl) null);
				return;
			case MiniJavaPackage.WHILE_STATEMENT__BLOCK :
				setBlock((BlockImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.WHILE_STATEMENT__CONDITION :
				return condition != null;
			case MiniJavaPackage.WHILE_STATEMENT__BLOCK :
				return block != null;
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatement(StateImpl state) {
		BooleanValueImpl continueWhile = ((BooleanValueImpl) (((BooleanValueImpl) (((ExpressionImpl) (this.getCondition())).evaluateExpression((StateImpl) (state))))));
		while (continueWhile.isValue()) {
			((BlockImpl) (this.getBlock())).evaluateStatement((StateImpl) (state));
			BooleanValueImpl continueWhile2 = ((BooleanValueImpl) (((BooleanValueImpl) (((ExpressionImpl) (this.getCondition())).evaluateExpression((StateImpl) (state))))));
			continueWhile = continueWhile2;
		}
	}
}
