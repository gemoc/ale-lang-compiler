package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Repeat"
)
public class RepeatImpl extends ControlStructureImpl {
	@Child
	protected BlockImpl block;

	protected RepeatImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.REPEAT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.REPEAT__BLOCK, oldBlock, newBlock);
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
				msgs = ((InternalEObject) block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.REPEAT__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject) newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.REPEAT__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.REPEAT__BLOCK, newBlock, newBlock));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return basicSetBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return getBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				setBlock((BlockImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				setBlock((BlockImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.REPEAT__BLOCK :
				return block != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(TurtleImpl turtle) {
		double result;
		double time = ((double) (((ExpressionImpl) (this.condition)).eval((TurtleImpl) (turtle))));
		while ((time) > (0.0)) {
			((BlockImpl) (this.getBlock())).eval((TurtleImpl) (turtle));
			time = (time) - (1.0);
		}
		result = (double) (0.0) ;
		return result;
	}
}
