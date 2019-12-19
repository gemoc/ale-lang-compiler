package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.CmpOpEqual;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

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
