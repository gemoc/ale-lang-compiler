package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Member;
import miniJava.Method;
import miniJava.MiniJavaFactory;
import miniJava.Program;
import miniJava.State;
import miniJava.TypeDeclaration;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class ProgramOperation {
	private final Program it;

	private final SwitchImplementation emfswitch;

	public ProgramOperation(Program it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void main() {
		((ProgramOperation) emfswitch.doSwitch(this.it)).initialize((null));
		((ProgramOperation) emfswitch.doSwitch(this.it)).execute();
	}

	public void initialize(EList args) {
		Context rootCont = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
		State state = ((State) (MiniJavaFactory.eINSTANCE.createState()));
		state.setOutputStream(MiniJavaFactory.eINSTANCE.createOutputStream());
		state.setRootFrame(MiniJavaFactory.eINSTANCE.createFrame());
		state.getRootFrame().setRootContext(rootCont);
		this.it.setState(state);
	}

	public State execute() {
		State result;
		Method main = ((Method) (((ProgramOperation) emfswitch.doSwitch(this.it)).findMain()));
		((BlockOperation) emfswitch.doSwitch(main.getBody())).evaluateStatementKeepContext((State) (this.it.getState()));
		result = ((State) (this.it.getState()));
		return result;
	}

	public Method findMain() {
		Method result;
		result = ((Method) (null));
		for (TypeDeclaration clazz: this.it.getClasses()) {
			for (Member member: clazz.getMembers()) {
				if(member instanceof Method) {
					Method method = ((Method) (member));
					if(EqualService.equals((method.getName()), ("main"))) {
						result = ((Method) (method));
					}
				}
			}
		}
		return result;
	}
}
