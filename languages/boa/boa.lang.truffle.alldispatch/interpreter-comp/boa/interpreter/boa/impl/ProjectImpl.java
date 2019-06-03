package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalFunRes;
import boa.interpreter.boa.EvalMapRes;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import boa.interpreter.boa.Project;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Project"
)
public class ProjectImpl extends ExprImpl implements Project {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  @Child
  protected Expr exp;

  @CompilationFinal
  private ProjectDispatchWrapperEval cachedEval;

  @CompilationFinal
  private ProjectDispatchWrapperProject cachedProject;

  private ProjectDispatchProject dispatchProjectProject;

  private ExprDispatchEval dispatchExprEval;

  protected ProjectImpl() {
    super();
    this.cachedEval = new boa.interpreter.boa.impl.ProjectDispatchWrapperEval(this);
    this.cachedProject = new boa.interpreter.boa.impl.ProjectDispatchWrapperProject(this);
    this.dispatchProjectProject = boa.interpreter.boa.impl.ProjectDispatchProjectNodeGen.create(); 
    this.dispatchExprEval = boa.interpreter.boa.impl.ExprDispatchEvalNodeGen.create(); 
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public void setExp(Expr newExp) {
    if (newExp != exp) {
    	NotificationChain msgs = null;
    	if (exp != null)
    		msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.PROJECT__EXP, null, msgs);
    	if (newExp != null)
    		msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.PROJECT__EXP, null, msgs);
    	msgs = basicSetExp(newExp, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.PROJECT__EXP, newExp, newExp));
  }

  @TruffleBoundary
  public NotificationChain basicSetExp(Expr newExp, NotificationChain msgs) {
    Expr oldExp = exp;
    exp = newExp;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.PROJECT__EXP, oldExp, newExp);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getExp() {
    return exp;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.PROJECT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	setExp((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.PROJECT__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	setExp((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.PROJECT__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    return getExp();
    case BoaPackage.PROJECT__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	return exp != null;
    case BoaPackage.PROJECT__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.PROJECT__EXP:
    	return basicSetExp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vexp = ((boa.interpreter.boa.EvalRes)dispatchExprEval.executeDispatch(this.exp.getCachedEval(), new Object[] {ctx}));
        if(vexp instanceof boa.interpreter.boa.EvalMapRes) {
          boa.interpreter.boa.EvalMapRes mvexp = ((boa.interpreter.boa.EvalMapRes)vexp);
          if(execboa.MapService.containsKey(mvexp.getValues(), this.name)) {
            boa.interpreter.boa.EvalRes x = ((boa.interpreter.boa.EvalRes)mvexp.getValues().get(this.name));
            if(x instanceof boa.interpreter.boa.EvalFunRes) {
              boa.interpreter.boa.EvalFunRes func = ((boa.interpreter.boa.EvalFunRes)x);
              result = (EvalRes) dispatchProjectProject.executeDispatch(this.getCachedProject(), new Object[] {func,mvexp});
            }
            else {
              result = x;
            }
          }
          else {
            result = null;
          }
        }
        else {
          result = null;
        }
        ;
    return result;
  }

  public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
    EvalRes result;
    boa.interpreter.boa.EvalBoundFunRes ret = ((boa.interpreter.boa.EvalBoundFunRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
        ret.setExp(func.getExp());
        ret.setCtx(func.getCtx());
        ret.setName(func.getName());
        execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
        result = ret;
        ;
    return result;
  }

  public ProjectDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }

  public ProjectDispatchWrapperProject getCachedProject() {
    return this.cachedProject;
  }
}
