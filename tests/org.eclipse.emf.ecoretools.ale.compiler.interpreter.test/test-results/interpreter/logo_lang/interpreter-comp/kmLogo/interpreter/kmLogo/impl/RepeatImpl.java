package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Repeat;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class RepeatImpl extends ControlStructureImpl implements Repeat {
	protected Block block;

	protected RepeatImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.REPEAT;
	}

	public void setBlock(Block newBlock) {
		if (newBlock != block) {
			NotificationChain msgs = null;
			if (block != null)
				msgs = ((InternalEObject) block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.REPEAT__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.REPEAT__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.REPEAT__BLOCK, newBlock, newBlock));
	}

	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		Block oldBlock = block;
		block = newBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.REPEAT__BLOCK, oldBlock, newBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public Block getBlock() {
		return block;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return basicSetBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return getBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				setBlock((Block) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				setBlock((Block) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return block != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(Turtle turtle) {
		double result;
		double time = ((double) (((Expression) this.condition).eval((Turtle) (turtle))));
		while ((time) > (0.0)) {
			((Block) this.block).eval((Turtle) (turtle));
			time = (time) - (1.0);
		}
		result = 0.0;
		return result;
	}
}
