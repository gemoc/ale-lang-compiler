package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.CmpOpUnequal;
import interpreter.visitor.VisitorInterface;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class CmpOpUnequalImpl extends CmpOpImpl implements CmpOpUnequal {
	protected CmpOpUnequalImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CMP_OP_UNEQUAL;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__CmpOpUnequal(this);
	}
}
