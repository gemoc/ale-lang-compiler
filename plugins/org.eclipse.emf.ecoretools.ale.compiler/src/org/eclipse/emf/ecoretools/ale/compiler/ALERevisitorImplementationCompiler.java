package org.eclipse.emf.ecoretools.ale.compiler;

import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class ALERevisitorImplementationCompiler {

	private IQueryEnvironment queryEnvironment;

	public ALERevisitorImplementationCompiler() {
		this.queryEnvironment = createQueryEnvironment(false, null);
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
	}

	private IQueryEnvironment createQueryEnvironment(final boolean b, final Object object) {

		final IQueryEnvironment newEnv = new ExtensionEnvironment();
		newEnv.registerEPackage(EcorePackage.eINSTANCE);
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
				EStringToStringMapEntryImpl.class);
		return newEnv;
	}

	public void compile(final String dsl) throws FileNotFoundException {
		final List<ParseResult<ModelUnit>> parsedSemantics = new DslBuilder(queryEnvironment)
				.parse(new WorkbenchDsl(dsl));
		this.compile(parsedSemantics);
	}

	private void compile(List<ParseResult<ModelUnit>> parsedSemantics) {
		for(ParseResult<ModelUnit> pr: parsedSemantics) {
			System.out.println(pr.getDiagnostic());
			ModelUnit root = pr.getRoot();
			System.out.println(root);
		}
		
		
		
		
		
		
		/**
		 * 
		 * Generate 
		 * 
		 * */
	}
}

