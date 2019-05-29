package miniJava.interpreter.miniJava.impl;

import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Parameter;
import org.eclipse.emf.ecore.EClass;

public class ParameterImpl extends SymbolImpl implements Parameter {
	protected ParameterImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.PARAMETER;
	}

	public boolean compare(Parameter other) {
		boolean result;
		result = (boolean) (((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.name), (other.getName()))) && (((miniJava.interpreter.miniJava.TypeRef) (this.typeRef)).compare((miniJava.interpreter.miniJava.TypeRef) (other.getTypeRef()))))) ;
		return result;
	}
}
