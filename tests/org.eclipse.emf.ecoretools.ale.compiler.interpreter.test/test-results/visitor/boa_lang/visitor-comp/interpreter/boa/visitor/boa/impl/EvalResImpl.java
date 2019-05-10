package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.EvalRes;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class EvalResImpl extends MinimalEObjectImpl.Container implements EvalRes {
	protected EvalResImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EVAL_RES;
	}
}
