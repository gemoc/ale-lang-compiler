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
		description = "ForStatement"
)
public class ForStatementImpl extends StatementImpl {
	@Child
	protected AssignmentImpl declaration;

	@Child
	protected ExpressionImpl condition;

	@Child
	protected AssignmentImpl progression;

	@Child
	protected BlockImpl block;

	protected ForStatementImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.FOR_STATEMENT;
	}

	@TruffleBoundary
	public AssignmentImpl getDeclaration() {
		return declaration;
	}

	@TruffleBoundary
	public NotificationChain basicSetDeclaration(AssignmentImpl newDeclaration,
			NotificationChain msgs) {
		AssignmentImpl oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setDeclaration(AssignmentImpl newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject) declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__DECLARATION, null, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject) newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__DECLARATION, null, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__DECLARATION, newDeclaration, newDeclaration));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__CONDITION, newCondition, newCondition));
	}

	@TruffleBoundary
	public AssignmentImpl getProgression() {
		return progression;
	}

	@TruffleBoundary
	public NotificationChain basicSetProgression(AssignmentImpl newProgression,
			NotificationChain msgs) {
		AssignmentImpl oldProgression = progression;
		progression = newProgression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__PROGRESSION, oldProgression, newProgression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setProgression(AssignmentImpl newProgression) {
		if (newProgression != progression) {
			NotificationChain msgs = null;
			if (progression != null)
				msgs = ((InternalEObject) progression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__PROGRESSION, null, msgs);
			if (newProgression != null)
				msgs = ((InternalEObject) newProgression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__PROGRESSION, null, msgs);
			msgs = basicSetProgression(newProgression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__PROGRESSION, newProgression, newProgression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__BLOCK, oldBlock, newBlock);
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
				msgs = ((InternalEObject) block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject) newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FOR_STATEMENT__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FOR_STATEMENT__BLOCK, newBlock, newBlock));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.FOR_STATEMENT__DECLARATION :
				return basicSetDeclaration(null, msgs);
			case MiniJavaPackage.FOR_STATEMENT__CONDITION :
				return basicSetCondition(null, msgs);
			case MiniJavaPackage.FOR_STATEMENT__PROGRESSION :
				return basicSetProgression(null, msgs);
			case MiniJavaPackage.FOR_STATEMENT__BLOCK :
				return basicSetBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.FOR_STATEMENT__DECLARATION :
				return getDeclaration();
			case MiniJavaPackage.FOR_STATEMENT__CONDITION :
				return getCondition();
			case MiniJavaPackage.FOR_STATEMENT__PROGRESSION :
				return getProgression();
			case MiniJavaPackage.FOR_STATEMENT__BLOCK :
				return getBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.FOR_STATEMENT__DECLARATION :
				setDeclaration((AssignmentImpl) newValue);
				return;
			case MiniJavaPackage.FOR_STATEMENT__CONDITION :
				setCondition((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.FOR_STATEMENT__PROGRESSION :
				setProgression((AssignmentImpl) newValue);
				return;
			case MiniJavaPackage.FOR_STATEMENT__BLOCK :
				setBlock((BlockImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FOR_STATEMENT__DECLARATION :
				setDeclaration((AssignmentImpl) null);
				return;
			case MiniJavaPackage.FOR_STATEMENT__CONDITION :
				setCondition((ExpressionImpl) null);
				return;
			case MiniJavaPackage.FOR_STATEMENT__PROGRESSION :
				setProgression((AssignmentImpl) null);
				return;
			case MiniJavaPackage.FOR_STATEMENT__BLOCK :
				setBlock((BlockImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FOR_STATEMENT__DECLARATION :
				return declaration != null;
			case MiniJavaPackage.FOR_STATEMENT__CONDITION :
				return condition != null;
			case MiniJavaPackage.FOR_STATEMENT__PROGRESSION :
				return progression != null;
			case MiniJavaPackage.FOR_STATEMENT__BLOCK :
				return block != null;
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatement(StateImpl state) {
		((StateImpl) (state)).pushNewContext();
		((AssignmentImpl) (this.getDeclaration())).evaluateStatement((StateImpl) (state));
		BooleanValueImpl continueFor = ((BooleanValueImpl) (((BooleanValueImpl) (((ExpressionImpl) (this.getCondition())).evaluateExpression((StateImpl) (state))))));
		while (continueFor.isValue()) {
			((BlockImpl) (this.getBlock())).evaluateStatement((StateImpl) (state));
			((AssignmentImpl) (this.getProgression())).evaluateStatement((StateImpl) (state));
			BooleanValueImpl continueFor2 = ((BooleanValueImpl) (((BooleanValueImpl) (((ExpressionImpl) (this.getCondition())).evaluateExpression((StateImpl) (state))))));
			continueFor = continueFor2;
		}
		((StateImpl) (state)).popCurrentContext();
	}
}
