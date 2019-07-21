package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

@NodeInfo(
		description = "ProcDeclaration"
)
public class ProcDeclarationImpl extends InstructionImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected EList<ParameterImpl> args;

	protected EList<ProcCallImpl> procCall;

	protected EList<InstructionImpl> instructions;

	@Children
	private InstructionImpl[] instructionsArr;

	@CompilationFinal
	private ProcDeclarationDispatchWrapperDeval cachedDeval;

	protected ProcDeclarationImpl() {
		super();
		this.cachedDeval = new kmLogo.interpreter.kmLogo.impl.ProcDeclarationDispatchWrapperDeval(this);
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PROC_DECLARATION;
	}

	@TruffleBoundary
	public String getName() {
		return name;
	}

	@TruffleBoundary
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_DECLARATION__NAME, oldName, name));
	}

	@TruffleBoundary
	public EList<ParameterImpl> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<ParameterImpl>(ParameterImpl.class, this, KmLogoPackage.PROC_DECLARATION__ARGS);
		}
		return args;
	}

	@TruffleBoundary
	public EList<ProcCallImpl> getProcCall() {
		if (procCall == null) {
			procCall = new EObjectWithInverseResolvingEList<ProcCallImpl>(ProcCallImpl.class, this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, KmLogoPackage.PROC_CALL__DECLARATION);
		}
		return procCall;
	}

	@TruffleBoundary
	public EList<InstructionImpl> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<InstructionImpl>(InstructionImpl.class, this, KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS);
		}
		return instructions;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getProcCall()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.PROC_DECLARATION__NAME :
				setName((String) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__ARGS :
				getArgs().clear();
				getArgs().addAll((Collection<? extends ParameterImpl>) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__PROC_CALL :
				getProcCall().clear();
				getProcCall().addAll((Collection<? extends ProcCallImpl>) newValue);
				return;
			case KmLogoPackage.PROC_DECLARATION__INSTRUCTIONS :
				getInstructions().clear();
				getInstructions().addAll((Collection<? extends InstructionImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
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

	public double eval(TurtleImpl turtle) {
		double result;
		if (this.instructionsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.instructions != null) this.instructionsArr = this.instructions.toArray(new InstructionImpl[0]);
			else this.instructionsArr = new InstructionImpl[] {};
		}
		result = (double) (0.0) ;
		for (InstructionImpl instr : this.instructionsArr) {
			result = (double) (((InstructionImpl) (instr)).eval((TurtleImpl) (turtle))) ;
		}

		return result;
	}

	public double deval(TurtleImpl turtle) {
		double result;
		if (this.instructionsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.instructions != null) this.instructionsArr = this.instructions.toArray(new InstructionImpl[0]);
			else this.instructionsArr = new InstructionImpl[] {};
		}
		result = (double) (((ProcDeclarationImpl) (this)).eval((TurtleImpl) (turtle))) ;

		return result;
	}

	public ProcDeclarationDispatchWrapperDeval getCachedDeval() {
		return this.cachedDeval;
	}
}
