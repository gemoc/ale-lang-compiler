package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.ArithOpTimes;
import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

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
