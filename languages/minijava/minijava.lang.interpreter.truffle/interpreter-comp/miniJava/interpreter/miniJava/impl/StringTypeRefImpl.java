package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.StringTypeRef;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "StringTypeRef"
)
public class StringTypeRefImpl extends SingleTypeRefImpl implements StringTypeRef {
	protected StringTypeRefImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.STRING_TYPE_REF;
	}
}
