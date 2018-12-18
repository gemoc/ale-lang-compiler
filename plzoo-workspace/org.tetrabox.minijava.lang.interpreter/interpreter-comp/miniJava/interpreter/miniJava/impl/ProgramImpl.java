package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Program;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.TypeDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ProgramImpl extends MinimalEObjectImpl.Container implements Program {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Import> imports;

  protected EList<TypeDeclaration> classes;

  protected State state;

  protected ProgramImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public EList<Import> getImports() {
    if(imports == null) {
    	imports = new EObjectContainmentEList<Import>(miniJava.interpreter.miniJava.Import.class, this, MiniJavaPackage.PROGRAM__IMPORTS);
    }
    return imports;
  }

  public EList<TypeDeclaration> getClasses() {
    if(classes == null) {
    	classes = new EObjectContainmentEList<TypeDeclaration>(miniJava.interpreter.miniJava.TypeDeclaration.class, this, MiniJavaPackage.PROGRAM__CLASSES);
    }
    return classes;
  }

  public void setState(State newState) {
    State oldState = state;
    state = newState;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.PROGRAM__STATE, oldState, state));
  }

  public State getState() {
    if (state != null && state.eIsProxy()) {
    	InternalEObject oldstate = (InternalEObject) state;
    	state = (State) eResolveProxy(oldstate);
    	if (state != oldstate) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.PROGRAM__STATE,
    					oldstate, state));
    	}
    }
    return state;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.PROGRAM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.PROGRAM__NAME:
    	setName((java.lang.String) newValue);
    return;
    case MiniJavaPackage.PROGRAM__IMPORTS:
    	getImports().clear();
    	getImports().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Import>) newValue);
    return;
    case MiniJavaPackage.PROGRAM__CLASSES:
    	getClasses().clear();
    	getClasses().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.TypeDeclaration>) newValue);
    return;
    case MiniJavaPackage.PROGRAM__STATE:
    	setState((miniJava.interpreter.miniJava.State) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.PROGRAM__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case MiniJavaPackage.PROGRAM__IMPORTS:
    	getImports().clear();
    return;
    case MiniJavaPackage.PROGRAM__CLASSES:
    	getClasses().clear();
    return;
    case MiniJavaPackage.PROGRAM__STATE:
    	setState((miniJava.interpreter.miniJava.State) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.PROGRAM__NAME:
    return getName();
    case MiniJavaPackage.PROGRAM__IMPORTS:
    return getImports();
    case MiniJavaPackage.PROGRAM__CLASSES:
    return getClasses();
    case MiniJavaPackage.PROGRAM__STATE:
    return getState();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.PROGRAM__NAME:
    	return name != NAME_EDEFAULT;
    case MiniJavaPackage.PROGRAM__IMPORTS:
    	return imports != null && !imports.isEmpty();
    case MiniJavaPackage.PROGRAM__CLASSES:
    	return classes != null && !classes.isEmpty();
    case MiniJavaPackage.PROGRAM__STATE:
    	return state != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.PROGRAM__IMPORTS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.PROGRAM__CLASSES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void main() {
    this.initialize(null);
        this.execute();
        ;
  }

  public void initialize(EList args) {
    miniJava.interpreter.miniJava.Context rootCont = ((miniJava.interpreter.miniJava.Context)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createContext());
        miniJava.interpreter.miniJava.State state = ((miniJava.interpreter.miniJava.State)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createState());
        state.setOutputStream(miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createOutputStream());
        state.setRootFrame(miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createFrame());
        state.getRootFrame().setRootContext(rootCont);
        this.setState(state);
        ;
  }

  public State execute() {
    State result;
    miniJava.interpreter.miniJava.Method main = ((miniJava.interpreter.miniJava.Method)this.findMain());
        main.getBody().evaluateStatementKeepContext(this.state);
        result = this.state;
        ;
    return result;
  }

  public Method findMain() {
    Method result;
    result = null;
        for(miniJava.interpreter.miniJava.TypeDeclaration clazz: this.getClasses()) {
          for(miniJava.interpreter.miniJava.Member member: clazz.getMembers()) {
            if(member instanceof miniJava.interpreter.miniJava.Method) {
              miniJava.interpreter.miniJava.Method method = ((miniJava.interpreter.miniJava.Method)member);
              result = method;
            }
          }
        }
        ;
    return result;
  }
}
