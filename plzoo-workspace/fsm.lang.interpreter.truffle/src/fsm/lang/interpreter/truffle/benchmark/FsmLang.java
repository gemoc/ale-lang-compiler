package fsm.lang.interpreter.truffle.benchmark;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import fsm.interpreter.fsm.FsmPackage;

@TruffleLanguage.Registration(id = "fsm", name = "fsm", mimeType = "application/fsm", contextPolicy = ContextPolicy.SHARED)
public class FsmLang extends com.oracle.truffle.api.TruffleLanguage<Void> {
	public FsmLang() {
		super();
	}

	@Override
	protected Void createContext(final Env env) {
		return null;
	}

	@Override
	protected boolean isObjectOfLanguage(final Object object) {
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			return eObject.eClass().getEPackage().getNsURI().equals(FsmPackage.eINSTANCE.getNsURI());
		} else {
			return false;
		}
	}

	@Override
	public CallTarget parse(final TruffleLanguage.ParsingRequest request) throws Exception {

		fsm.interpreter.fsm.System model = init();
		return Truffle.getRuntime().createCallTarget(new RootNode(FsmLang.this) {

			@Override
			public Object execute(final VirtualFrame frame) {
				final long start = System.currentTimeMillis();
				model.main();
				return System.currentTimeMillis() - start;
			}
		});
	}

	@TruffleBoundary
	private fsm.interpreter.fsm.System init() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.gemoc.org/fsm", FsmPackage.eINSTANCE);

		LogService.MUTE = true;

		final ResourceSet resSet = new ResourceSetImpl();
		Map<String, Object> m = resSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("fsm", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createFileURI(FsmBenchmark.file);
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		return (fsm.interpreter.fsm.System) resource.getContents().get(0);
	}
}
