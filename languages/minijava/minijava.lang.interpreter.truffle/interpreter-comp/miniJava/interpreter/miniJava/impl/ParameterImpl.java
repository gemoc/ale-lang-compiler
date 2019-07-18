package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Parameter"
)
public class ParameterImpl extends SymbolImpl {
	protected ParameterImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.PARAMETER;
	}

	public boolean compare(ParameterImpl other) {
		boolean result;
		result = (boolean) (((EqualService.equals((this.name), (other.getName()))) && (((TypeRefImpl) (this.typeRef)).compare((TypeRefImpl) (other.getTypeRef()))))) ;
		return result;
	}
}
