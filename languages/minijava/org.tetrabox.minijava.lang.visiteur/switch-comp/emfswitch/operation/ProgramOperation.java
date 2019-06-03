package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Member;
import miniJava.Method;
import miniJava.Program;
import miniJava.State;
import miniJava.TypeDeclaration;
import org.eclipse.emf.common.util.EList;

public class ProgramOperation {
  private final Program it;

  private final SwitchImplementation emfswitch;

  public ProgramOperation(Program it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void main() {
    /*CASEA*/((emfswitch.operation.ProgramOperation) emfswitch.doSwitch(this.it)).initialize(null);
    /*CASEA*/((emfswitch.operation.ProgramOperation) emfswitch.doSwitch(this.it)).execute();
  }

  public void initialize(EList args) {
    Context rootCont = ((Context)miniJava.MiniJavaFactory.eINSTANCE.createContext());
    State state = ((State)miniJava.MiniJavaFactory.eINSTANCE.createState());
    state.setOutputStream(miniJava.MiniJavaFactory.eINSTANCE.createOutputStream());
    state.setRootFrame(miniJava.MiniJavaFactory.eINSTANCE.createFrame());
    state.getRootFrame().setRootContext(rootCont);
    this.it.setState(state);
  }

  public State execute() {
    State result;
    Method main = ((Method)/*CASEA*/((emfswitch.operation.ProgramOperation) emfswitch.doSwitch(this.it)).findMain());
    /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(main.getBody())).evaluateStatementKeepContext(this.it.getState());
    result = this.it.getState();
    return result;
  }

  public Method findMain() {
    Method result;
    result = null;
    for(TypeDeclaration clazz: this.it.getClasses()) {
      for(Member member: clazz.getMembers()) {
        if(member instanceof miniJava.Method) {
          Method method = ((Method)member);
          if(java.util.Objects.equals((method.getName()), ("main"))) {
            result = method;
          }
        }
      }
    }
    return result;
  }
}
