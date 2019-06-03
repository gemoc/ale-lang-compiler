package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Program;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.TypeDeclaration;

public class ProgramImpl extends MinimalEObjectImpl.Container implements Program {
	protected static final String NAME_EDEFAULT = null;

	protected EList<TypeDeclaration> classes;

	protected EList<Import> imports;

	protected String name = NAME_EDEFAULT;

	protected State state;

	protected ProgramImpl() {
		super();
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

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.PROGRAM__IMPORTS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
		case MiniJavaPackage.PROGRAM__CLASSES:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.PROGRAM__NAME:
			setName((java.lang.String) newValue);
			return;
		case MiniJavaPackage.PROGRAM__IMPORTS:
			getImports().clear();
			getImports().addAll((java.util.Collection<? extends Import>) newValue);
			return;
		case MiniJavaPackage.PROGRAM__CLASSES:
			getClasses().clear();
			getClasses().addAll((java.util.Collection<? extends TypeDeclaration>) newValue);
			return;
		case MiniJavaPackage.PROGRAM__STATE:
			setState((State) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.PROGRAM;
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
			setState((State) null);
			return;
		}
		super.eUnset(featureID);
	}

	public State execute() {
		State result;
		Method main = ((Method) this.findMain());
		main.getBody().evaluateStatementKeepContext(this.state);
		result = this.state;
		;
		return result;
	}

	public Method findMain() {
		Method result;
		result = null;
		for (TypeDeclaration clazz : this.getClasses()) {
			for (Member member : clazz.getMembers()) {
				if (member instanceof Method) {
					Method method = ((Method) member);
					result = method;
				}
			}
		}
		;
		return result;
	}

	public EList<TypeDeclaration> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<TypeDeclaration>(TypeDeclaration.class, this,
					MiniJavaPackage.PROGRAM__CLASSES);
		}
		return classes;
	}

	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, MiniJavaPackage.PROGRAM__IMPORTS);
		}
		return imports;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

	public void initialize(EList args) {
		Context rootCont = ((Context) MiniJavaFactory.eINSTANCE.createContext());
		State state = ((State) MiniJavaFactory.eINSTANCE.createState());
		state.setOutputStream(MiniJavaFactory.eINSTANCE.createOutputStream());
		state.setRootFrame(MiniJavaFactory.eINSTANCE.createFrame());
		state.getRootFrame().setRootContext(rootCont);
		this.setState(state);
		;
	}

	public void main() {
		this.initialize(null);
		this.execute();
		;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(State newState) {
		State oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.PROGRAM__STATE, oldState, state));
	}
}
