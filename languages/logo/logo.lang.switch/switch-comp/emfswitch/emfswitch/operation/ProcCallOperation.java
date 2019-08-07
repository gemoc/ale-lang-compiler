package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import java.lang.Integer;
import kmLogo.Expression;
import kmLogo.KmLogoFactory;
import kmLogo.ProcCall;
import kmLogo.ProcDeclaration;
import kmLogo.StackFrame;
import kmLogo.Turtle;
import kmLogo.Variable;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ProcCallOperation extends ExpressionOperation {
	private final ProcCall it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ProcCallOperation(ProcCall it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		LogService.log(("Calling ") + (this.it.getDeclaration().getName()));
		StackFrame newFrame = ((StackFrame) (KmLogoFactory.eINSTANCE.createStackFrame()));
		int i = ((int) (0));
		for (Expression exp: this.it.getActualArgs()) {
			Variable newVar = ((Variable) (KmLogoFactory.eINSTANCE.createVariable()));
			newVar.setName(CollectionService.get(this.it.getDeclaration().getArgs(), i).getName());
			newVar.setValue(((ExpressionOperation) emfswitch.doSwitch(exp)).eval((Turtle) (turtle)));
			newFrame.getVariables().add(newVar);
			i = ((Integer) ((i) + (1)));
		}
		turtle.getCallStack().getFrames().add(newFrame);
		result = ((Double) (0.0));
		if(this.it.getDeclaration() instanceof ProcDeclaration) {
			ProcDeclaration decl = ((ProcDeclaration) (this.it.getDeclaration()));
			((ProcDeclarationOperation) emfswitch.doSwitch(decl)).eval((Turtle) (turtle));
		}
		turtle.getCallStack().getFrames().remove(newFrame);
		return result;
	}
}
