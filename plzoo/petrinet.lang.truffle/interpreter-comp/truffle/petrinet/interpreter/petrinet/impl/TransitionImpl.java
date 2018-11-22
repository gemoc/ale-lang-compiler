package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import truffle.petrinet.interpreter.petrinet.Arc;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;
import truffle.petrinet.interpreter.petrinet.Transition;

@NodeInfo(
    description = "Transition"
)
public class TransitionImpl extends NodeImpl implements Transition {
  @Children
  private Arc[] outgoingArr;

  @Children
  private Arc[] incommingArr;

  protected TransitionImpl() {
    super();
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.TRANSITION;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public boolean canFire() {
    boolean result;
    if(this.incommingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.incommingArr = this.incomming.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    result = !(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.incommingArr, (it) -> it.canFire())));
        ;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    if(this.incommingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.incommingArr = this.incomming.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    result = false;
        ;
    return result;
  }

  public void fire() {
    if(this.outgoingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.outgoingArr = this.outgoing.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    if(this.incommingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.incommingArr = this.incomming.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    for(truffle.petrinet.interpreter.petrinet.Arc it: this.incommingArr) {
          it.removeToken();
        }
        for(truffle.petrinet.interpreter.petrinet.Arc it: this.outgoingArr) {
          it.addToken();
        }
        ;
  }

  public void removeToken() {
    if(this.outgoingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.outgoingArr = this.outgoing.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    if(this.incommingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.incommingArr = this.incomming.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    ;
  }

  public void addToken() {
    if(this.outgoingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.outgoingArr = this.outgoing.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    if(this.incommingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.incommingArr = this.incomming.toArray(new truffle.petrinet.interpreter.petrinet.Arc[0]);
        			};
    ;
  }
}
