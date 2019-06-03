package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Skip;
import interpreter.imp.interpreter.imp.Store;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class SkipImpl extends StmtImpl implements Skip {
	protected SkipImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.SKIP;
	}

	public Store execute(Store s) {
		Store result;
		result = (Store) (s) ;
		return result;
	}
}
