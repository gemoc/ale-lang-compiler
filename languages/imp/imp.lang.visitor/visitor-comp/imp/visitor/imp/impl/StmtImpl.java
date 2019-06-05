package imp.visitor.imp.impl;

import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.Stmt;
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
}
