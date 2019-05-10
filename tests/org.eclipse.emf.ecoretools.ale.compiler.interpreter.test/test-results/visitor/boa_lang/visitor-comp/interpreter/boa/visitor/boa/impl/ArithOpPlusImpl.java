package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.ArithOpPlus;
import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ArithOpPlusImpl extends ArithOpImpl implements ArithOpPlus {
	protected ArithOpPlusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_PLUS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__ArithOpPlus(this);
	}
}
