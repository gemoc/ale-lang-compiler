package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
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
public class ProgramImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected EList<ImportImpl> imports;

	protected EList<TypeDeclarationImpl> classes;

	protected StateImpl state;

	@Children
	private TypeDeclarationImpl[] classesArr;

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
	public EList<ImportImpl> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportImpl>(ImportImpl.class, this, MiniJavaPackage.PROGRAM__IMPORTS);
		}
		return imports;
	}

	@TruffleBoundary
	public EList<TypeDeclarationImpl> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<TypeDeclarationImpl>(TypeDeclarationImpl.class, this, MiniJavaPackage.PROGRAM__CLASSES);
		}
		return classes;
	}

	@TruffleBoundary
	public StateImpl getState() {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject) state;
			state = (StateImpl) eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.PROGRAM__STATE, oldState, state));
			}
		}
		return state;
	}

	public StateImpl basicGetState() {
		return state;
	}

	@TruffleBoundary
	public void setState(StateImpl newState) {
		StateImpl oldState = state;
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
				getImports().addAll((Collection<? extends ImportImpl>) newValue);
				return;
			case MiniJavaPackage.PROGRAM__CLASSES :
				getClasses().clear();
				getClasses().addAll((Collection<? extends TypeDeclarationImpl>) newValue);
				return;
			case MiniJavaPackage.PROGRAM__STATE :
				setState((StateImpl) newValue);
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
				setState((StateImpl) null);
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
		((ProgramImpl) (this)).initialize(null);
		((ProgramImpl) (this)).execute();
	}

	public void initialize(EList args) {
		ContextImpl rootCont = ((ContextImpl) (MiniJavaFactory.eINSTANCE.createContext()));
		StateImpl state = ((StateImpl) (MiniJavaFactory.eINSTANCE.createState()));
		state.setOutputStream(MiniJavaFactory.eINSTANCE.createOutputStream());
		state.setRootFrame(MiniJavaFactory.eINSTANCE.createFrame());
		state.getRootFrame().setRootContext(rootCont);
		this.setState(state);
	}

	public StateImpl execute() {
		StateImpl result;
		MethodImpl main = ((MethodImpl) (((ProgramImpl) (this)).findMain()));
		((BlockImpl) (main.getBody())).evaluateStatementKeepContext((StateImpl) (this.getState()));
		result = (StateImpl) (this.getState()) ;
		return result;
	}

	public MethodImpl findMain() {
		MethodImpl result;
		if (this.classesArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.classes != null) this.classesArr = this.classes.toArray(new TypeDeclarationImpl[0]);
			else this.classesArr = new TypeDeclarationImpl[] {};
		}
		result = (MethodImpl) (null) ;
		for (TypeDeclarationImpl clazz : this.classesArr) {
			for (MemberImpl member : clazz.getMembers()) {
				if (member instanceof MethodImpl) {
					MethodImpl method = ((MethodImpl) (member));
					if (EqualService.equals((method.getName()), ("main"))) {
						result = (MethodImpl) (method) ;
					}
				}
			}
		}

		return result;
	}
}
