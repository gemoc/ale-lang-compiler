package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.This;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ThisImpl extends ExprImpl implements This {
	protected ThisImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.THIS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__This(this);
	}
}
