package boa.visitor.boa.impl;

import boa.visitor.boa.ArithOpPlus;
import boa.visitor.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

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
