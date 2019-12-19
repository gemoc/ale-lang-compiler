package interpreter.boa.interpreter.boa.impl;

import execboa.SerializeService;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public abstract class ExprImpl extends TopLevelCmdImpl implements Expr {
	protected ExprImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EXPR;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = (EvalRes) (null) ;
		return result;
	}

	public void nextLine(Ctx ctx) {
		LogService.log(SerializeService.serialize((EvalRes) (((Expr) (this)).eval((Ctx) (ctx)))));
	}
}
