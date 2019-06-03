package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class StmtImpl extends MinimalEObjectImpl.Container implements Stmt {
	protected StmtImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.STMT;
	}

	public Store execute(Store s) {
		Store result;
		result = (Store) (s) ;
		return result;
	}
}
