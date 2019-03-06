import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import emfswitch.SwitchImplementation;
import emfswitch.operation.FSMOperation;
import emfswitch.operation.SystemOperation;
import fsm.model.fsm.FsmPackage;

public class BenchmarkFSMSwitch {
	public static void main(String[] args) {
//		final String file = args[0];
//		final int itt = Integer.parseInt(args[1]);
//
//		EPackage.Registry.INSTANCE.put("http://kmLogo", FsmPackage.eINSTANCE);
//
//		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//		final Map<String, Object> m = reg.getExtensionToFactoryMap();
//		m.put("xmi", new XMIResourceFactoryImpl());
		SwitchImplementation emfswitch = new SwitchImplementation();
//
//		final long[] times = new long[itt];
//
//		for (int i = 0; i < itt; i++) {
//			final ResourceSetImpl resSet = new ResourceSetImpl();
//			final URI createFileURI = URI.createFileURI(file);
//			final Resource resource = resSet.getResource(createFileURI, true);
//			final FSM result = (FSM) resource.getContents().get(0);
//
//			final long start = System.currentTimeMillis();
//			((FSMOperation) emfswitch.doSwitch(result)).run();
//
//			times[i] = System.currentTimeMillis() - start;
//		}
//
//		System.out.println(Arrays.toString(times));

		final String file = args[0];
//		final String file = "/home/manuel/dev/java/ale-lang/plzoo-workspace/fsm.model/model/System.xmi";
		final int itt = Integer.parseInt(args[1]);
//		final int itt = 1;

//		FsmPackage.eINSTANCE.eClass();

		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.gemoc.org/fsm", FsmPackage.eINSTANCE);

		LogService.MUTE = true;

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("fsm", new XMIResourceFactoryImpl());

		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final fsm.model.fsm.System result = (fsm.model.fsm.System) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
			((SystemOperation) emfswitch.doSwitch(result)).main();
			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
