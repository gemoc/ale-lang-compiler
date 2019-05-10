package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.Skip;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

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
