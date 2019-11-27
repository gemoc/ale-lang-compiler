package org.eclipse.emf.ecoretools.ale.compiler.generic;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class FindUsedConcepts {
	private final static String program = "/home/manuel/dev/java/ale-lang/genetics-minijava/fib.minijava.xmi";
	private final static String metamodel = "/home/manuel/dev/java/ale-lang/minijava/org.tetrabox.minijava.xtext/model/MiniJava.ecore";

	public static void main(final String[] args) throws IOException {
		final ResourceSetImpl rs = new ResourceSetImpl();

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("ecore", new EcoreResourceFactoryImpl());

		final Resource metares = rs.getResource(URI.createURI(metamodel), true);

		final EPackage metapackage = (EPackage) metares.getContents().get(0);

		EPackage.Registry.INSTANCE.put("http://miniJava.miniJava.miniJava/", metapackage);

		final Resource res = rs.getResource(URI.createURI(program), true);

		final Set<EClass> distinctEClasses = addParents(initWithBaseClasses(res));

		System.out.println(distinctEClasses.stream().map(x -> x.getName()).map(x -> "'" + x + "'")
				.collect(Collectors.joining(", ", "[", "]")));

	}

	private static Set<EClass> addParents(final Set<EClass> distinctEClasses) {
		final Set<EClass> distinctEClasses2 = new HashSet<>();
		distinctEClasses2.addAll(distinctEClasses);
		distinctEClasses.forEach(dec -> {
			distinctEClasses2.addAll(dec.getEAllSuperTypes());
		});
		return distinctEClasses2;
	}

	private static Set<EClass> initWithBaseClasses(final Resource res) {
		final Set<EClass> distinctEClasses = new HashSet<>();

		res.getAllContents().forEachRemaining(c -> {
			distinctEClasses.add(c.eClass());
		});
		return distinctEClasses;
	}
}
