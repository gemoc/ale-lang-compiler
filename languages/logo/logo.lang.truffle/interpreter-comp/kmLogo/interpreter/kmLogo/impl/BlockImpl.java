package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

@NodeInfo(
		description = "Block"
)
public class BlockImpl extends InstructionImpl {
	protected EList<InstructionImpl> instructions;

	@Children
	private InstructionImpl[] instructionsArr;

	protected BlockImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BLOCK;
	}

	@TruffleBoundary
	public EList<InstructionImpl> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<InstructionImpl>(InstructionImpl.class, this, KmLogoPackage.BLOCK__INSTRUCTIONS);
		}
		return instructions;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				return ((InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
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
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				getInstructions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
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
		for (InstructionImpl inst : this.instructionsArr) {
			((InstructionImpl) (inst)).eval((TurtleImpl) (turtle));
		}
		result = (double) (0.0) ;

		return result;
	}
}
