package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.BoolOp;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public abstract class BoolOpImpl extends ExprImpl implements BoolOp {
	protected BoolOpImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.BOOL_OP;
	}
}
