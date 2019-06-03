package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.CmpOpLess;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class CmpOpLessImpl extends CmpOpImpl implements CmpOpLess {
	protected CmpOpLessImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CMP_OP_LESS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__CmpOpLess(this);
	}
}
