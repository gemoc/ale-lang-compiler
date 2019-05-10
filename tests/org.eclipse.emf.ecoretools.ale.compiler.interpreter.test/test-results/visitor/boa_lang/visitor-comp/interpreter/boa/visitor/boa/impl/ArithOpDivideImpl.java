package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.ArithOpDivide;
import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ArithOpDivideImpl extends ArithOpImpl implements ArithOpDivide {
	protected ArithOpDivideImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_DIVIDE;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__ArithOpDivide(this);
	}
}
