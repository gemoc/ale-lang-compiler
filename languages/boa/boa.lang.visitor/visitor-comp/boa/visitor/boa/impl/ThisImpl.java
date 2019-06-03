package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.This;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

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
