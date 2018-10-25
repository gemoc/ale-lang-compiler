/**
 */
package kmLogo.impl;

import java.util.Collection;

import kmLogo.Block;
import kmLogo.Instruction;
import kmLogo.KmLogoPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class BlockImpl extends InstructionImpl implements Block {
	protected EList<Instruction> instructions;

	protected BlockImpl() {
		super();
	}

	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this,
					KmLogoPackage.BLOCK__INSTRUCTIONS);
		}
		return instructions;
	}

	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BLOCK;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			getInstructions().clear();
			getInstructions().addAll((Collection<? extends Instruction>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			getInstructions().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KmLogoPackage.BLOCK__INSTRUCTIONS:
			return ((InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

} // BlockImpl
