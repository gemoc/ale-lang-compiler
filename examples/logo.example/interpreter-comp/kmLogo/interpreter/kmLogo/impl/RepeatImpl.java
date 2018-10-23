package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Repeat;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class RepeatImpl extends ControlStructureImpl implements Repeat {
  private Block block;

  public void setBlock(Block newBlock) {
    Block oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.REPEAT__BLOCK, oldBlock, block));
  }

  public Block getBlock() {
    return block;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.REPEAT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	setBlock((kmLogo.interpreter.kmLogo.impl.BlockImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.REPEAT__BLOCK:
    	setBlock((kmLogo.interpreter.kmLogo.impl.BlockImpl) null);
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
