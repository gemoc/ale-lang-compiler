package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.CmpOpEqual;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class CmpOpEqualImpl extends CmpOpImpl implements CmpOpEqual {
	protected CmpOpEqualImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CMP_OP_EQUAL;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__CmpOpEqual(this);
	}
}
