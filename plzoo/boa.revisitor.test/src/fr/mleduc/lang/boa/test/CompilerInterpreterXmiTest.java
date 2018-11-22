package fr.mleduc.lang.boa.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.junit.Assert;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.File;

public class CompilerInterpreterXmiTest extends AbstractBoaTest {

	@Override
	protected String getName() {
		return "notruffle";
	}

	@Override
	void eval(final String pathname, final String expected) throws FileNotFoundException, IOException {
		// BoaFactory.eINSTANCE.getClass();
		BoaPackage.eINSTANCE.eClass();

		// TODO: replace with loading of XMI from program_xmi. Or from program if their
		// is a way to change the factory used at runtime.
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xmi", new XMIResourceFactoryImpl());

		final ResourceSetImpl resSet = new ResourceSetImpl();
//		final java.io.File file = new java.io.File();
//		final InputStream stream = new FileInputStream(file);
		URI createFileURI = URI.createFileURI("/home/manuel/runtime-ale-lang/boa.revisitor.test/xmi_interpreter/" + pathname + ".boa.xmi");
		final Resource resource = resSet.getResource(createFileURI, true);
//		resource.load(stream, resSet.getLoadOptions());
		final File result = (File) resource.getContents().get(0);

		Assert.assertNotNull(result);

		final EList<Diagnostic> errors = result.eResource().getErrors();

		Assert.assertTrue(errors.isEmpty());

		try {
			timer.before();
			result.eval();
			timer.after(pathname);
		} catch (final Exception e) {
			// throw new RuntimeException(Sideeffects.SB.toString() + e.getMessage());
			Assert.fail(e.getMessage());
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
