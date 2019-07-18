package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "TypeRef"
)
public class TypeRefImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected TypeRefImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.TYPE_REF;
	}

	public boolean compare(TypeRefImpl other) {
		boolean result;
		result = (boolean) (EqualService.equals((this.eClass()), (other.eClass()))) ;
		return result;
	}
}
