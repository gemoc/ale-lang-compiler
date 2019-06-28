package fsm.benchmark.truffle;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;

import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.impl.SystemImpl;

@TruffleLanguage.Registration(id = "fsm", name = "fsm", mimeType = "application/fsm", contextPolicy = ContextPolicy.SHARED)
public class FsmLang extends TruffleLanguage<Void> {

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
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final ResourceSetImpl resSet = new ResourceSetImpl();
		final URI createFileURI = URI.createFileURI(FsmBenchmarkTruffle.file);
		final Resource resource = resSet.getResource(createFileURI, true);
		SystemImpl result = (SystemImpl) resource.getContents().get(0);
				

		return Truffle.getRuntime().createCallTarget(new MainRootNodeExtension(FsmLang.this, result));
	}

}
