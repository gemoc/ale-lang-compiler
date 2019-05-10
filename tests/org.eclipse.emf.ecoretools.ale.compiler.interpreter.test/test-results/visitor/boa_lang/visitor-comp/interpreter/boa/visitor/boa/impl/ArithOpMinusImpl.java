package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.ArithOpMinus;
import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ArithOpMinusImpl extends ArithOpImpl implements ArithOpMinus {
	protected ArithOpMinusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_MINUS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__ArithOpMinus(this);
	}
}
