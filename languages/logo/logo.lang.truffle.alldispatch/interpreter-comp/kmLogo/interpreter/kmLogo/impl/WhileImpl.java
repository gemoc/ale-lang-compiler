package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.While;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "While"
)
public class WhileImpl extends ControlStructureImpl implements While {
  @Child
  protected Block block;

  @CompilationFinal
  private WhileDispatchWrapperEval cachedEval;

  private BlockDispatchEval dispatchBlockEval;

  private ExpressionDispatchEval dispatchExpressionEval;

  protected WhileImpl() {
    super();
    this.cachedEval = new kmLogo.interpreter.kmLogo.impl.WhileDispatchWrapperEval(this);
    this.dispatchBlockEval = kmLogo.interpreter.kmLogo.impl.BlockDispatchEvalNodeGen.create(); 
    this.dispatchExpressionEval = kmLogo.interpreter.kmLogo.impl.ExpressionDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  public void setBlock(Block newBlock) {
    if (newBlock != block) {
    	NotificationChain msgs = null;
    	if (block != null)
    		msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.WHILE__BLOCK, null, msgs);
    	if (newBlock != null)
    		msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.WHILE__BLOCK, null, msgs);
    	msgs = basicSetBlock(newBlock, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.WHILE__BLOCK, newBlock, newBlock));
  }

  @TruffleBoundary
  public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
    Block oldBlock = block;
    block = newBlock;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.WHILE__BLOCK, oldBlock, newBlock);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Block getBlock() {
    return block;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.WHILE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.WHILE__BLOCK:
    	setBlock((kmLogo.interpreter.kmLogo.Block) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.WHILE__BLOCK:
    	setBlock((kmLogo.interpreter.kmLogo.Block) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.WHILE__BLOCK:
    return getBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.WHILE__BLOCK:
    	return block != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.WHILE__BLOCK:
    	return basicSetBlock(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public double eval(Turtle turtle) {
    double result;
    while ((((double)dispatchExpressionEval.executeDispatch(this.condition.getCachedEval(), new Object[] {turtle}))) > (0.0)) {
          dispatchBlockEval.executeDispatch(this.block.getCachedEval(), new Object[] {turtle});
        }
        result = 0.0;
        ;
    return result;
  }

  public WhileDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
