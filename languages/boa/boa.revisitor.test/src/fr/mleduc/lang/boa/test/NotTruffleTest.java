package fr.mleduc.lang.boa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Assert;

import com.google.inject.Injector;

import boa.BoaPackage;
import boa.File;
import boa.xtext.BoaStandaloneSetup;
import boa_exec.impl.Boa_execImplementation;

public class NotTruffleTest extends AbstractBoaTest {

	@Override
	protected String getName() {
		return "notruffle";
	}

	@Override
	void eval(String pathname, String expected) throws FileNotFoundException, IOException {
		// BoaFactory.eINSTANCE.getClass();
		BoaPackage.eINSTANCE.eClass();

		final Injector injector = new BoaStandaloneSetup().createInjectorAndDoEMFRegistration();
		final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		final Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.boa"));

		java.io.File file = new java.io.File("programs/" + pathname + ".boa");
		final InputStream stream = new FileInputStream(file);
		resource.load(stream, resourceSet.getLoadOptions());
		final File result = (File) resource.getContents().get(0);

		Assert.assertNotNull(result);

		final EList<Diagnostic> errors = result.eResource().getErrors();

		Assert.assertTrue(errors.isEmpty());

		try {
			timer.before();
//			new Boa_execImplementation() {
//			}.$(result).eval();
			timer.after(pathname);
		} catch (RuntimeException e) {
			// throw new RuntimeException(Sideeffects.SB.toString() + e.getMessage());
		}

		Assert.assertEquals(expected, LogService.sb.toString());
	}

//    @Test
//    public void fib2() throws IOException {
//
//        final ExecboatruffleFactory einstance = ExecboatruffleFactory.eINSTANCE;
//        final ExecboatrufflePackage einstance2 = ExecboatrufflePackage.eINSTANCE;
//
//        final Injector injector = new fr.mleduc.lang.boa.BoaStandaloneSetup().createInjectorAndDoEMFRegistration();
//        final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
//        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
//        final Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.boa"));
//
//        java.io.File file = new java.io.File("programs/fib2.boa");
//        final InputStream stream = new FileInputStream(file);
//        resource.load(stream, resourceSet.getLoadOptions());
//        final File result = (File) resource.getContents().get(0);
//
//        timer.before();
//        for (int i = 0; i < 2000; i++) {
//            result.eval(null);
//        }
//        timer.after("programs/fib2.boa");
//
//
//    }
//
//
//    @Test
//    @Ignore
//    public void longfib() throws IOException {
//
//        final ExecboatruffleFactory einstance = ExecboatruffleFactory.eINSTANCE;
//        final ExecboatrufflePackage einstance2 = ExecboatrufflePackage.eINSTANCE;
//
//        final Injector injector = new fr.mleduc.lang.boa.BoaStandaloneSetup().createInjectorAndDoEMFRegistration();
//        final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
//        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
//        final Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.boa"));
//
//        java.io.File file = new java.io.File("programs/longfib.boa");
//        final InputStream stream = new FileInputStream(file);
//        resource.load(stream, resourceSet.getLoadOptions());
//        final File result = (File) resource.getContents().get(0);
//
//        timer.before();
//        for (int i = 0; i < 2000; i++) {
//            result.eval(null);
//        }
//        timer.after("programs/longfib.boa");
//
//
//    }

}
