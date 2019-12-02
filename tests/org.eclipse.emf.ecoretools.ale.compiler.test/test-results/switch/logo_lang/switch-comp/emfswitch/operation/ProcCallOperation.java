package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Expression;
import kmLogo.KmLogoFactory;
import kmLogo.ProcCall;
import kmLogo.ProcDeclaration;
import kmLogo.StackFrame;
import kmLogo.Turtle;
import kmLogo.Variable;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ProcCallOperation extends ExpressionOperation {
	private final ProcCall it;

	private final SwitchImplementation emfswitch;

	public ProcCallOperation(ProcCall it, SwitchImplementation emfswitch) {
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
			newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.it.getDeclaration().getArgs(), i).getName());
			newVar.setValue(((ExpressionOperation) emfswitch.doSwitch(exp)).eval((Turtle) turtle));
			newFrame.getVariables().add(newVar);
			i = (i) + (1);
		}
		turtle.getCallStack().getFrames().add(newFrame);
		result = 0.0;
		if(this.it.getDeclaration() instanceof ProcDeclaration) {
			ProcDeclaration decl = ((ProcDeclaration) (this.it.getDeclaration()));
			((ProcDeclarationOperation) emfswitch.doSwitch(decl)).deval((Turtle) turtle);
		}
		turtle.getCallStack().getFrames().remove(newFrame);
		return result;
	}
}
