package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Assignment"
)
public class AssignmentImpl extends StatementImpl {
	@Child
	protected AssigneeImpl assignee;

	@Child
	protected ExpressionImpl value;

	protected AssignmentImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ASSIGNMENT;
	}

	@TruffleBoundary
	public AssigneeImpl getAssignee() {
		return assignee;
	}

	@TruffleBoundary
	public NotificationChain basicSetAssignee(AssigneeImpl newAssignee, NotificationChain msgs) {
		AssigneeImpl oldAssignee = assignee;
		assignee = newAssignee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ASSIGNMENT__ASSIGNEE, oldAssignee, newAssignee);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setAssignee(AssigneeImpl newAssignee) {
		if (newAssignee != assignee) {
			NotificationChain msgs = null;
			if (assignee != null)
				msgs = ((InternalEObject) assignee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ASSIGNMENT__ASSIGNEE, null, msgs);
			if (newAssignee != null)
				msgs = ((InternalEObject) newAssignee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ASSIGNMENT__ASSIGNEE, null, msgs);
			msgs = basicSetAssignee(newAssignee, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ASSIGNMENT__ASSIGNEE, newAssignee, newAssignee));
	}

	@TruffleBoundary
	public ExpressionImpl getValue() {
		return value;
	}

	@TruffleBoundary
	public NotificationChain basicSetValue(ExpressionImpl newValue, NotificationChain msgs) {
		ExpressionImpl oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ASSIGNMENT__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setValue(ExpressionImpl newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ASSIGNMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ASSIGNMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ASSIGNMENT__VALUE, newValue, newValue));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.ASSIGNMENT__ASSIGNEE :
				return basicSetAssignee(null, msgs);
			case MiniJavaPackage.ASSIGNMENT__VALUE :
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.ASSIGNMENT__ASSIGNEE :
				return getAssignee();
			case MiniJavaPackage.ASSIGNMENT__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.ASSIGNMENT__ASSIGNEE :
				setAssignee((AssigneeImpl) newValue);
				return;
			case MiniJavaPackage.ASSIGNMENT__VALUE :
				setValue((ExpressionImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ASSIGNMENT__ASSIGNEE :
				setAssignee((AssigneeImpl) null);
				return;
			case MiniJavaPackage.ASSIGNMENT__VALUE :
				setValue((ExpressionImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ASSIGNMENT__ASSIGNEE :
				return assignee != null;
			case MiniJavaPackage.ASSIGNMENT__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatement(StateImpl state) {
		ContextImpl context = ((ContextImpl) (((StateImpl) (state)).findCurrentContext()));
		ValueImpl right = ((ValueImpl) (((ExpressionImpl) (this.getValue())).evaluateExpression((StateImpl) (state))));
		AssigneeImpl assignee = ((AssigneeImpl) (this.getAssignee()));
		if (assignee instanceof SymbolRefImpl) {
			SymbolRefImpl assigneeSymbolRef = ((SymbolRefImpl) (assignee));
			SymbolBindingImpl existingBinding = ((SymbolBindingImpl) (((ContextImpl) (context)).findBinding((SymbolImpl) (assigneeSymbolRef.getSymbol()))));
			existingBinding.setValue(right);
		}
		else {
			if (assignee instanceof VariableDeclarationImpl) {
				VariableDeclarationImpl assigneeVariableDeclaration = ((VariableDeclarationImpl) (assignee));
				SymbolBindingImpl binding = ((SymbolBindingImpl) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(assigneeVariableDeclaration);
				binding.setValue(right);
				context.getBindings().add(binding);
			}
			else {
				if (assignee instanceof FieldAccessImpl) {
					FieldAccessImpl assigneeFieldAccess = ((FieldAccessImpl) (assignee));
					FieldImpl f = ((FieldImpl) (assigneeFieldAccess.getField()));
					ObjectRefValueImpl realReceiverValue = ((ObjectRefValueImpl) (((ObjectRefValueImpl) (((ExpressionImpl) (assigneeFieldAccess.getReceiver())).evaluateExpression((StateImpl) (state))))));
					ObjectInstanceImpl realReceiver = ((ObjectInstanceImpl) (realReceiverValue.getInstance()));
					FieldBindingImpl existingBinding = ((FieldBindingImpl) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (f))))));
					if (EqualService.equals((existingBinding), (null))) {
						FieldBindingImpl binding = ((FieldBindingImpl) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
						binding.setField(f);
						binding.setValue(right);
						realReceiver.getFieldbindings().add(binding);
					}
					else {
						existingBinding.setValue(right);
					}
				}
				else {
					if (assignee instanceof ArrayAccessImpl) {
						ArrayAccessImpl assigneeArrayAccess = ((ArrayAccessImpl) (assignee));
						ArrayRefValueImpl arrayRefValue = ((ArrayRefValueImpl) (((ArrayRefValueImpl) (((ExpressionImpl) (assigneeArrayAccess.getObject())).evaluateExpression((StateImpl) (state))))));
						ArrayInstanceImpl array = ((ArrayInstanceImpl) (arrayRefValue.getInstance()));
						IntegerValueImpl integerValue = ((IntegerValueImpl) (((IntegerValueImpl) (((ExpressionImpl) (assigneeArrayAccess.getIndex())).evaluateExpression((StateImpl) (state))))));
						int index = ((int) (integerValue.getValue()));
						CollectionService.set(array.getValue(), index, right);
					}
					else {
					}
				}
			}
		}
	}
}
