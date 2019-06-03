package boa.visitor.boa.impl;

import boa.visitor.boa.ArithOpRemainder;
import boa.visitor.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class ArithOpRemainderImpl extends ArithOpImpl implements ArithOpRemainder {
	protected ArithOpRemainderImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_REMAINDER;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__ArithOpRemainder(this);
	}
}
