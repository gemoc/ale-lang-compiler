package org.tetrabox.minijava.lang.visiteur;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import emfswitch.SwitchImplementation;
import emfswitch.operation.ProgramOperation;
import miniJava.MiniJavaPackage;
import miniJava.Program;

public class MiniJavaSwitchBenchmark {
	public static void main(String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);

		EPackage.Registry.INSTANCE.put("http://miniJava.miniJava.miniJava/", MiniJavaPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		SwitchImplementation emfswitch = new SwitchImplementation();

		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final Program result = (Program) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
			((ProgramOperation) emfswitch.caseProgram(result)).execute();

			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
