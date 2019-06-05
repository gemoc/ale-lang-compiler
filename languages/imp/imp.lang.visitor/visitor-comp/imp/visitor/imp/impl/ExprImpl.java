package imp.visitor.imp.impl;

import imp.visitor.imp.Expr;
import imp.visitor.imp.ImpPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class ExprImpl extends MinimalEObjectImpl.Container implements Expr {
	protected ExprImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.EXPR;
	}
}
