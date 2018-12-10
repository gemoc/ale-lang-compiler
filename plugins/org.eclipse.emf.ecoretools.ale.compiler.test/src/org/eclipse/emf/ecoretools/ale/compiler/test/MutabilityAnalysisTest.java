package org.eclipse.emf.ecoretools.ale.compiler.test;

import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.utils.MutabilityAnalysis;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.junit.Test;

public class MutabilityAnalysisTest {

	private IQueryEnvironment createQueryEnvironment(final boolean isDebug, final CrossReferenceProvider xRefProvider) {

		final IQueryEnvironment newEnv = new ExtensionEnvironment();
		newEnv.registerEPackage(EcorePackage.eINSTANCE);
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
				EStringToStringMapEntryImpl.class);
		return newEnv;
	}

	@Test
	public void test() throws Exception {
		final Dsl res = new Dsl("./data/Test0.dsl");

		final IQueryEnvironment queryEnvironment = createQueryEnvironment(false, null);
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);

		final MutabilityAnalysis ma = new MutabilityAnalysis();

		final DslBuilder dslBuilder = new DslBuilder(queryEnvironment);
		final List<ParseResult<ModelUnit>> parsedSemantics = dslBuilder.parse(res);

		final ModelUnit parseResult = parsedSemantics.get(0).getRoot();

		final BaseValidator base = new BaseValidator(queryEnvironment, Arrays.asList(new TypeValidator()));

		base.validate(parsedSemantics);

		ma.analyse(parseResult, base);
	}
}
