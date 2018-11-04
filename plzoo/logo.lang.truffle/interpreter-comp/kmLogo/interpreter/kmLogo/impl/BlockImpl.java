package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.extra.ArrayService;

@NodeInfo(description = "Block")
public class BlockImpl extends InstructionImpl implements Block {
	protected EList<Instruction> instructions;
	@CompilationFinal
	private BlockStableImpl blockStableImpl;

	protected BlockImpl() {
		super();
	}

	@TruffleBoundary
	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(kmLogo.interpreter.kmLogo.Instruction.class, this,
					KmLogoPackage.BLOCK__INSTRUCTIONS);
//			this.toArrayInstructions();
		}
		return instructions;
	}

	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BLOCK;
	}

	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			getInstructions().clear();
			getInstructions().addAll((java.util.Collection<? extends Instruction>) newValue);
//			this.toArrayInstructions();
			return;
		}
		super.eSet(featureID, newValue);
	}

	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			getInstructions().clear();
//			this.toArrayInstructions();
			return;
		}
		super.eUnset(featureID);
	}

	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case kmLogo.interpreter.kmLogo.KmLogoPackage.BLOCK__INSTRUCTIONS:
			NotificationChain basicRemove = ((org.eclipse.emf.ecore.util.InternalEList<?>) getInstructions())
					.basicRemove(otherEnd, msgs);
//			this.toArrayInstructions();
			return basicRemove;
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

//	@ExplodeLoop
//	@TruffleBoundary
	public double eval(Turtle turtle) {
		double result;
		if (blockStableImpl == null) {
			blockStableImpl = new BlockStableImpl(this.instructions);
		}
		blockStableImpl.execte(turtle);
		result = 0.0;
		return result;
	}

//	@TruffleBoundary
//	private Instruction[] toArray() {
//		return ArrayService.toArray(Instruction.class, this.getInstructions());
//	}

}
