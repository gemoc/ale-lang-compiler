package org.eclipse.emf.ecoretools.ale.compiler;

import java.util.List;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class ALECompiler {

	private IQueryEnvironment queryEnvironment;

	public ALECompiler() {
		this.queryEnvironment = createQueryEnvironment(false, null);
	}

	private IQueryEnvironment createQueryEnvironment(final boolean b, final Object object) {

		final IQueryEnvironment newEnv = new ExtensionEnvironment();
		newEnv.registerEPackage(EcorePackage.eINSTANCE);
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
				EStringToStringMapEntryImpl.class);
		return newEnv;
	}

	public void compile(final String modelURI, final Dsl dsl) {
		final List<ParseResult<ModelUnit>> parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl);
		final Resource model = loadModel(modelURI);
		final EObject caller = model.getContents().get(0);
		this.compile(parsedSemantics, model);
	}

	private void compile(List<ParseResult<ModelUnit>> parsedSemantics, Resource model) {
		// TODO Auto-generated method stub

	}

	private Resource loadModel(final String modelURI) {
		final ResourceSet modelRs = new ResourceSetImpl();
		modelRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		queryEnvironment.getEPackageProvider().getRegisteredEPackages().stream().forEach(pkg -> {
			modelRs.getPackageRegistry().put(pkg.getNsURI(), pkg);
		});
		final URI uri = URI.createURI(modelURI);
		return modelRs.getResource(uri, true);
	}
}
