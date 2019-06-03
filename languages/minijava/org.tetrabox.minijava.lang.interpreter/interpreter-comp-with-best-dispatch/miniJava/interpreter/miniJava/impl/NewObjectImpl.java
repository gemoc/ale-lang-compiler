package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewObject;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

@NodeInfo(
    description = "NewObject"
)
public class NewObjectImpl extends ExpressionImpl implements NewObject {
  protected Clazz type;

  protected EList<Expression> args;

  @Children
  private Expression[] argsArr;

  @Child
  private StateDispatchPushNewFrame dispatchStatePushNewFrame;

  protected NewObjectImpl() {
    super();
    this.dispatchStatePushNewFrame = miniJava.interpreter.miniJava.impl.StateDispatchPushNewFrameNodeGen.create(); 
  }

  @TruffleBoundary
  public void setType(Clazz newType) {
    Clazz oldType = type;
    type = newType;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_OBJECT__TYPE, oldType, type));
  }

  @TruffleBoundary
  public Clazz getType() {
    if (type != null && type.eIsProxy()) {
    	InternalEObject oldtype = (InternalEObject) type;
    	type = (Clazz) eResolveProxy(oldtype);
    	if (type != oldtype) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.NEW_OBJECT__TYPE,
    					oldtype, type));
    	}
    }
    return type;
  }

  @TruffleBoundary
  public EList<Expression> getArgs() {
    if(args == null) {
    	args = new EObjectContainmentEList<Expression>(miniJava.interpreter.miniJava.Expression.class, this, MiniJavaPackage.NEW_OBJECT__ARGS);
    }
    return args;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NEW_OBJECT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) newValue);
    return;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	getArgs().clear();
    	getArgs().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Expression>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) null);
    return;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	getArgs().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    return getType();
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    return getArgs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_OBJECT__TYPE:
    	return type != null;
    case MiniJavaPackage.NEW_OBJECT__ARGS:
    	return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.NEW_OBJECT__ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    if(this.argsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.args != null) this.argsArr = this.args.toArray(new miniJava.interpreter.miniJava.Expression[0]);
        				else this.argsArr = new miniJava.interpreter.miniJava.Expression[] {};
        				
        			};
    miniJava.interpreter.miniJava.ObjectInstance res = ((miniJava.interpreter.miniJava.ObjectInstance)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createObjectInstance());
        res.setType(this.getType());
        state.getObjectsHeap().add(res);
        int i = ((int)0);
        int z = ((int)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(res.getType().getMembers()));
        while ((i) < (z)) {
          miniJava.interpreter.miniJava.Member m = ((miniJava.interpreter.miniJava.Member)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(res.getType().getMembers(), i));
          if(m instanceof miniJava.interpreter.miniJava.Field) {
            miniJava.interpreter.miniJava.Field f = ((miniJava.interpreter.miniJava.Field)m);
            if((f.getDefaultValue()) != (null)) {
              miniJava.interpreter.miniJava.Value v = ((miniJava.interpreter.miniJava.Value)f.getDefaultValue().evaluateExpression(state));
              miniJava.interpreter.miniJava.FieldBinding fb = ((miniJava.interpreter.miniJava.FieldBinding)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createFieldBinding());
              fb.setField(f);
              fb.setValue(v);
              res.getFieldbindings().add(fb);
            }
          }
          i = (i) + (1);
        }
        i = 0;
        miniJava.interpreter.miniJava.Method constructor = ((miniJava.interpreter.miniJava.Method)null);
        while ((((i) < (z)) && (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((constructor), (null))))) {
          miniJava.interpreter.miniJava.Member m = ((miniJava.interpreter.miniJava.Member)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(res.getType().getMembers(), i));
          if(m instanceof miniJava.interpreter.miniJava.Method) {
            miniJava.interpreter.miniJava.Method mtd = ((miniJava.interpreter.miniJava.Method)m);
            if(((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((mtd.getName()), (null))) && (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(mtd.getParams())), (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.argsArr)))))) {
              constructor = mtd;
            }
          }
          i = (i) + (1);
        }
        if((constructor) != (null)) {
          miniJava.interpreter.miniJava.Context newContext = ((miniJava.interpreter.miniJava.Context)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createContext());
          i = 0;
          z = org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.argsArr);
          while ((i) < (z)) {
            miniJava.interpreter.miniJava.Expression arg = ((miniJava.interpreter.miniJava.Expression)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.argsArr, i));
            miniJava.interpreter.miniJava.Parameter param = ((miniJava.interpreter.miniJava.Parameter)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(constructor.getParams(), i));
            miniJava.interpreter.miniJava.SymbolBinding binding = ((miniJava.interpreter.miniJava.SymbolBinding)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
            binding.setSymbol(param);
            binding.setValue(arg.evaluateExpression(state));
            i = (i) + (1);
            newContext.getBindings().add(binding);
          }
          miniJava.interpreter.miniJava.NewCall call = ((miniJava.interpreter.miniJava.NewCall)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createNewCall());
          call.setNewz(this);
          dispatchStatePushNewFrame.executeDispatch(state.getCachedPushNewFrame(), new Object[] {res,call,newContext});
          constructor.getBody().evaluateStatement(state);
          state.popCurrentFrame();
        }
        miniJava.interpreter.miniJava.ObjectRefValue tmp = ((miniJava.interpreter.miniJava.ObjectRefValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createObjectRefValue());
        tmp.setInstance(res);
        result = tmp;
        ;
    return result;
  }
}
