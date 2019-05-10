package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.visitor.kmLogo.Block;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class BlockImpl extends InstructionImpl implements Block {
	protected EList<Instruction> instructions;

	protected BlockImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BLOCK;
	}

	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this, KmLogoPackage.BLOCK__INSTRUCTIONS);
		}
		return instructions;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				return ((InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				getInstructions().clear();
				getInstructions().addAll((Collection<? extends Instruction>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				getInstructions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BLOCK__INSTRUCTIONS :
				return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Block(this);
	}
}
