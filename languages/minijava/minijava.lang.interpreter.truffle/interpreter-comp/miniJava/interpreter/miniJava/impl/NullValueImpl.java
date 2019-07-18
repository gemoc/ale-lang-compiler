package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;

public class NullValueImpl extends ValueImpl {
	protected NullValueImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NULL_VALUE;
	}

	@TruffleBoundary
	public ValueImpl copyj() {
		ValueImpl result;
		NullValueImpl tmp = ((NullValueImpl) (MiniJavaFactory.eINSTANCE.createNullValue()));
		result = (ValueImpl) (tmp) ;
		return result;
	}
}
