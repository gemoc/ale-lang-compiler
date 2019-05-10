package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.Expr;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public abstract class ExprImpl extends TopLevelCmdImpl implements Expr {
	protected ExprImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EXPR;
	}
}
