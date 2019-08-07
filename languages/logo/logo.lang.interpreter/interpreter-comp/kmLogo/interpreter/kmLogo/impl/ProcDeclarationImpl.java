package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Parameter;
import kmLogo.interpreter.kmLogo.ProcCall;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class ProcDeclarationImpl extends InstructionImpl implements ProcDeclaration {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected EList<Parameter> args;

	protected EList<ProcCall> procCall;

	protected EList<Instruction> instructions;

	protected ProcDeclarationImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PROC_DECLARATION;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_DECLARATION__NAME, oldName, name));
	}

	public EList<Parameter> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Parameter>(Parameter.class, this, KmLogoPackage.PROC_DECLARATION__ARGS);
		}
		return args;
	}

	public EList<ProcCall> getProcCall() {
		if (procCall == null) {
			procCall = new EObjectWithInverseResolvingEList<ProcCall>(ProcCall.class, this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, KmLogoPackage.PROC_CALL__DECLARATION);
		}
		return procCall;
	}

	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this, KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS);
		}
		return instructions;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getProcCall()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				return ((InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				return ((InternalEList<?>) getProcCall()).basicRemove(otherEnd, msgs);
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				return ((InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__NAME :
				return getName();
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				return getArgs();
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				return getProcCall();
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__NAME :
				setName((String) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				getArgs().clear();
				getArgs().addAll((Collection<? extends Parameter>) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				getProcCall().clear();
				getProcCall().addAll((Collection<? extends ProcCall>) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				getInstructions().clear();
				getInstructions().addAll((Collection<? extends Instruction>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__NAME :
				setName(NAME_EDEFAULT);
				return;
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				getArgs().clear();
				return;
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				getProcCall().clear();
				return;
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				getInstructions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				return args != null && !args.isEmpty();
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				return procCall != null && !procCall.isEmpty();
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (0.0) ;
		for (Instruction instr : this.getInstructions()) {
			result = (double) (((Instruction) (instr)).eval((Turtle) (turtle))) ;
		}
		return result;
	}
}
