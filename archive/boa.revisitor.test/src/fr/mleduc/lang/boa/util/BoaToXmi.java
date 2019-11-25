package fr.mleduc.lang.boa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import boa.BoaPackage;
import boa.File;
import boa.xtext.BoaStandaloneSetup;

public class BoaToXmi {
	public static void main(final String[] args) throws IOException {

		final java.io.File program = new java.io.File("/home/manuel/dev/java/ale-lang/plzoo/boa.revisitor.test/programs");

		BoaPackage.eINSTANCE.eClass();

		final Injector injector = new BoaStandaloneSetup().createInjectorAndDoEMFRegistration();

		// java.io.File file = new java.io.File(pathname);

		Arrays.asList(program.listFiles()).forEach(p -> {
			try {
				final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
				resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
						new XMIResourceFactoryImpl());
				final InputStream stream = new FileInputStream(p);
				final Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.boa"));
				resource.load(stream, resourceSet.getLoadOptions());
				final File result = (File) resource.getContents().get(0);

				final Resource out = resourceSet.createResource(URI
						.createFileURI("/home/manuel/dev/java/ale-lang/plzoo/boa.revisitor.test/xmi/" + p.getName() + ".xmi"));

				out.getContents().add(result);
				out.save(null);

			} catch (final FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
}
