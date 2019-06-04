package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Assignee;
import miniJava.interpreter.miniJava.Assignment;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class AssignmentImpl extends StatementImpl implements Assignment {
  protected Assignee assignee;

  protected Expression value;

  protected AssignmentImpl() {
    super();
  }

  public void setAssignee(Assignee newAssignee) {
    if (newAssignee != assignee) {
    	NotificationChain msgs = null;
    	if (assignee != null)
    		msgs = ((InternalEObject)assignee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__ASSIGNEE, null, msgs);
    	if (newAssignee != null)
    		msgs = ((InternalEObject)newAssignee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__ASSIGNEE, null, msgs);
    	msgs = basicSetAssignee(newAssignee, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__ASSIGNEE, newAssignee, newAssignee));
  }

  public NotificationChain basicSetAssignee(Assignee newAssignee, NotificationChain msgs) {
    Assignee oldAssignee = assignee;
    assignee = newAssignee;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__ASSIGNEE, oldAssignee, newAssignee);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Assignee getAssignee() {
    return assignee;}

  public void setValue(Expression newValue) {
    if (newValue != value) {
    	NotificationChain msgs = null;
    	if (value != null)
    		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__VALUE, null, msgs);
    	if (newValue != null)
    		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__VALUE, null, msgs);
    	msgs = basicSetValue(newValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__VALUE, newValue, newValue));
  }

  public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
    Expression oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__VALUE, oldValue, newValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getValue() {
    return value;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.ASSIGNMENT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.ASSIGNMENT__ASSIGNEE:
    	setAssignee((miniJava.interpreter.miniJava.Assignee) newValue);
    return;
    case MiniJavaPackage.ASSIGNMENT__VALUE:
    	setValue((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ASSIGNMENT__ASSIGNEE:
    	setAssignee((miniJava.interpreter.miniJava.Assignee) null);
    return;
    case MiniJavaPackage.ASSIGNMENT__VALUE:
    	setValue((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.ASSIGNMENT__ASSIGNEE:
    return getAssignee();
    case MiniJavaPackage.ASSIGNMENT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ASSIGNMENT__ASSIGNEE:
    	return assignee != null;
    case MiniJavaPackage.ASSIGNMENT__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__ASSIGNEE:
    	return basicSetAssignee(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.ASSIGNMENT__VALUE:
    	return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void evaluateStatement(State state) {
    miniJava.interpreter.miniJava.Context context = ((miniJava.interpreter.miniJava.Context)state.findCurrentContext());
        miniJava.interpreter.miniJava.Value right = ((miniJava.interpreter.miniJava.Value)this.value.evaluateExpression(state));
        miniJava.interpreter.miniJava.Assignee assignee = ((miniJava.interpreter.miniJava.Assignee)this.assignee);
        if(assignee instanceof miniJava.interpreter.miniJava.SymbolRef) {
          miniJava.interpreter.miniJava.SymbolRef assigneeSymbolRef = ((miniJava.interpreter.miniJava.SymbolRef)assignee);
          context.findBinding(assigneeSymbolRef.getSymbol());
        }
        else {
          if(assignee instanceof miniJava.interpreter.miniJava.VariableDeclaration) {
            miniJava.interpreter.miniJava.VariableDeclaration assigneeVariableDeclaration = ((miniJava.interpreter.miniJava.VariableDeclaration)assignee);
            miniJava.interpreter.miniJava.SymbolBinding binding = ((miniJava.interpreter.miniJava.SymbolBinding)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
            binding.setSymbol(assigneeVariableDeclaration);
            binding.setValue(right);
            context.getBindings().add(binding);
          }
          else {
            if(assignee instanceof miniJava.interpreter.miniJava.FieldAccess) {
              miniJava.interpreter.miniJava.FieldAccess assigneeFieldAccess = ((miniJava.interpreter.miniJava.FieldAccess)assignee);
              miniJava.interpreter.miniJava.Field f = ((miniJava.interpreter.miniJava.Field)assigneeFieldAccess.getField());
              miniJava.interpreter.miniJava.ObjectRefValue realReceiverValue = ((miniJava.interpreter.miniJava.ObjectRefValue)assigneeFieldAccess.getReceiver().evaluateExpression(state));
              miniJava.interpreter.miniJava.ObjectInstance realReceiver = ((miniJava.interpreter.miniJava.ObjectInstance)realReceiverValue.getInstance());
              miniJava.interpreter.miniJava.FieldBinding existingBinding = ((miniJava.interpreter.miniJava.FieldBinding)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(realReceiver.getFieldbindings(), (x) -> java.util.Objects.equals((x.getField()), (f)))));
              if(java.util.Objects.equals((existingBinding), (null))) {
                miniJava.interpreter.miniJava.FieldBinding binding = ((miniJava.interpreter.miniJava.FieldBinding)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createFieldBinding());
                binding.setField(f);
                binding.setValue(right);
                realReceiver.getFieldbindings().add(binding);
              }
              else {
                existingBinding.setValue(right);
              }
            }
            else {
              if(assignee instanceof miniJava.interpreter.miniJava.ArrayAccess) {
                miniJava.interpreter.miniJava.ArrayAccess assigneeArrayAccess = ((miniJava.interpreter.miniJava.ArrayAccess)assignee);
                miniJava.interpreter.miniJava.ArrayRefValue arrayRefValue = ((miniJava.interpreter.miniJava.ArrayRefValue)assigneeArrayAccess.getObject().evaluateExpression(state));
                miniJava.interpreter.miniJava.ArrayInstance array = ((miniJava.interpreter.miniJava.ArrayInstance)arrayRefValue.getInstance());
                miniJava.interpreter.miniJava.IntegerValue integerValue = ((miniJava.interpreter.miniJava.IntegerValue)assigneeArrayAccess.getIndex().evaluateExpression(state));
                int index = ((int)integerValue.getValue());
                array.getValue().set(index,right);
              }
              else {
              }
            }
          }
        }
        ;
  }
}
