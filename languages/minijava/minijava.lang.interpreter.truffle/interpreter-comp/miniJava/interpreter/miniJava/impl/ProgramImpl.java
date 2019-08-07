package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaFactory;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "Program"
)
public class ProgramImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Program {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected EList<Import> imports;

	protected EList<TypeDeclaration> classes;

	protected State state;

	@Children
	private TypeDeclaration[] classesArr;

	protected ProgramImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.PROGRAM;
	}

	@TruffleBoundary
	public String getName() {
		return name;
	}

	@TruffleBoundary
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.PROGRAM__NAME, oldName, name));
	}

	@TruffleBoundary
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, MiniJavaPackage.PROGRAM__IMPORTS);
		}
		return imports;
	}

	@TruffleBoundary
	public EList<TypeDeclaration> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<TypeDeclaration>(TypeDeclaration.class, this, MiniJavaPackage.PROGRAM__CLASSES);
		}
		return classes;
	}

	@TruffleBoundary
	public State getState() {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject) state;
			state = (State) eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.PROGRAM__STATE, oldState, state));
			}
		}
		return state;
	}

	public State basicGetState() {
		return state;
	}

	@TruffleBoundary
	public void setState(State newState) {
		State oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.PROGRAM__STATE, oldState, state));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.PROGRAM__IMPORTS :
				return ((InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
			case MiniJavaPackage.PROGRAM__CLASSES :
				return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.PROGRAM__NAME :
				return getName();
			case MiniJavaPackage.PROGRAM__IMPORTS :
				return getImports();
			case MiniJavaPackage.PROGRAM__CLASSES :
				return getClasses();
			case MiniJavaPackage.PROGRAM__STATE :
				if (resolve)
					return getState();
				return basicGetState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.PROGRAM__NAME :
				setName((String) newValue);
				return;
			case MiniJavaPackage.PROGRAM__IMPORTS :
				getImports().clear();
				getImports().addAll((Collection<? extends Import>) newValue);
				return;
			case MiniJavaPackage.PROGRAM__CLASSES :
				getClasses().clear();
				getClasses().addAll((Collection<? extends TypeDeclaration>) newValue);
				return;
			case MiniJavaPackage.PROGRAM__STATE :
				setState((State) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.PROGRAM__NAME :
				setName(NAME_EDEFAULT);
				return;
			case MiniJavaPackage.PROGRAM__IMPORTS :
				getImports().clear();
				return;
			case MiniJavaPackage.PROGRAM__CLASSES :
				getClasses().clear();
				return;
			case MiniJavaPackage.PROGRAM__STATE :
				setState((State) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.PROGRAM__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MiniJavaPackage.PROGRAM__IMPORTS :
				return imports != null && !imports.isEmpty();
			case MiniJavaPackage.PROGRAM__CLASSES :
				return classes != null && !classes.isEmpty();
			case MiniJavaPackage.PROGRAM__STATE :
				return state != null;
		}
		return super.eIsSet(featureID);
	}

	public void main() {
		((Program) (this)).initialize(null);
		((Program) (this)).execute();
	}

	public void initialize(EList args) {
		Context rootCont = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
		State state = ((State) (MiniJavaFactory.eINSTANCE.createState()));
		state.setOutputStream(MiniJavaFactory.eINSTANCE.createOutputStream());
		state.setRootFrame(MiniJavaFactory.eINSTANCE.createFrame());
		state.getRootFrame().setRootContext(rootCont);
		this.setState(state);
	}

	public State execute() {
		State result;
		Method main = ((Method) (((Program) (this)).findMain()));
		((Block) (main.getBody())).evaluateStatementKeepContext((State) (this.getState()));
		result = (State) (this.getState()) ;
		return result;
	}

	public Method findMain() {
		Method result;
		if (this.classesArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.classes != null) this.classesArr = this.classes.toArray(new TypeDeclaration[0]);
			else this.classesArr = new TypeDeclaration[] {};
		}
		result = (Method) (null) ;
		for (TypeDeclaration clazz : this.classesArr) {
			for (Member member : clazz.getMembers()) {
				if (member instanceof Method) {
					Method method = ((Method) (member));
					if (EqualService.equals((method.getName()), ("main"))) {
						result = (Method) (method) ;
					}
				}
			}
		}

		return result;
	}
}
