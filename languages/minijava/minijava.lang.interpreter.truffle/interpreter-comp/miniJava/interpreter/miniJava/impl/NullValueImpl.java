package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

public class NullValueImpl extends ValueImpl implements NullValue {
	protected NullValueImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NULL_VALUE;
	}

	@TruffleBoundary
	public Value copyj() {
		Value result;
		NullValue tmp = ((NullValue) (MiniJavaFactory.eINSTANCE.createNullValue()));
		result = (Value) (tmp) ;
		return result;
	}
}
