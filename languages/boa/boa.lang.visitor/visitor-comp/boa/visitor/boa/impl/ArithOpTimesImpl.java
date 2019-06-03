package boa.visitor.boa.impl;

import boa.visitor.boa.ArithOpTimes;
import boa.visitor.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class ArithOpTimesImpl extends ArithOpImpl implements ArithOpTimes {
	protected ArithOpTimesImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_TIMES;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__ArithOpTimes(this);
	}
}
