package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Parameter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "Parameter"
)
public class ParameterImpl extends SymbolImpl implements Parameter {
  @CompilationFinal
  private ParameterDispatchWrapperCompare cachedCompare;

  @Child
  private TypeRefDispatchCompare dispatchTypeRefCompare;

  protected ParameterImpl() {
    super();
    this.cachedCompare = new miniJava.interpreter.miniJava.impl.ParameterDispatchWrapperCompare(this);
    this.dispatchTypeRefCompare = miniJava.interpreter.miniJava.impl.TypeRefDispatchCompareNodeGen.create(); 
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.PARAMETER;}

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

  public boolean compare(Parameter other) {
    boolean result;
    result = ((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.name), (other.getName()))) && (((boolean)dispatchTypeRefCompare.executeDispatch(this.typeRef.getCachedCompare(), new Object[] {other.getTypeRef()}))));
        ;
    return result;
  }

  public ParameterDispatchWrapperCompare getCachedCompare() {
    return this.cachedCompare;
  }
}
