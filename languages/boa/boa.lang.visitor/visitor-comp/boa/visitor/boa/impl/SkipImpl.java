package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.Skip;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class SkipImpl extends ExprImpl implements Skip {
	protected SkipImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.SKIP;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__Skip(this);
	}
}
