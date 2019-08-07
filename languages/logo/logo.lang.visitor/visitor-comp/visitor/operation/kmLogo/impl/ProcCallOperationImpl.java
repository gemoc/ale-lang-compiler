package visitor.operation.kmLogo.impl;

import java.lang.Double;
import java.lang.Integer;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoFactory;
import kmLogo.visitor.kmLogo.ProcCall;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Turtle;
import kmLogo.visitor.kmLogo.Variable;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.ProcCallOperation;
import visitor.operation.kmLogo.ProcDeclarationOperation;

public class ProcCallOperationImpl extends ExpressionOperationImpl implements ProcCallOperation {
	private final ProcCall it;

	private final VisitorInterface vis;

	public ProcCallOperationImpl(ProcCall it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		LogService.log(("Calling ") + (this.it.getDeclaration().getName()));
		StackFrame newFrame = ((StackFrame) (KmLogoFactory.eINSTANCE.createStackFrame()));
		int i = ((int) (0));
		for(Expression exp: this.it.getActualArgs()) {
			Variable newVar = ((Variable) (KmLogoFactory.eINSTANCE.createVariable()));
			newVar.setName(CollectionService.get(this.it.getDeclaration().getArgs(), i).getName());
			newVar.setValue(((ExpressionOperation)exp.accept(vis)).eval((Turtle) (turtle)));
			newFrame.getVariables().add(newVar);
			i = ((Integer) ((i) + (1)));
		}
		turtle.getCallStack().getFrames().add(newFrame);
		result = ((Double) (0.0));
		if(this.it.getDeclaration() instanceof ProcDeclaration) {
			ProcDeclaration decl = ((ProcDeclaration) (this.it.getDeclaration()));
			((ProcDeclarationOperation)decl.accept(vis)).eval((Turtle) (turtle));
		}
		turtle.getCallStack().getFrames().remove(newFrame);
		return result;
	}
}
