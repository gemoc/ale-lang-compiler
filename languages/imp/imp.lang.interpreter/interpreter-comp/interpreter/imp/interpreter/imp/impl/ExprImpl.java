package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
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

	public Value evaluate(Store s) {
		Value result;
		result = (Value) (ImpFactory.eINSTANCE.createIntValue()) ;
		return result;
	}
}
