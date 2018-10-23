package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Block;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Repeat;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class RepeatImpl extends ControlStructureImpl implements Repeat {
  private Block block;

  public void setBlock(Block newBlock) {
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

  private NotificationChain basicSetBlock(Block newBlock, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Block oldBlock = block;
    block = newBlock;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.REPEAT__BLOCK,
    			oldBlock, newBlock);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Block getBlock() {
    return block;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.REPEAT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	setBlock((kmlogo.interpreter.impl.BlockImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	setBlock((kmlogo.interpreter.impl.BlockImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	return getBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	return block != null;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    double time = ((double)this.getCondition().eval(turtle));
    while ((time) > (0.0)) {
      this.getBlock().eval(turtle);
      time = (time) - (1.0);
    }
    result = 0.0;
    return result;
  }
}
