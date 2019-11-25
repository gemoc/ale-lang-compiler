
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.LogoProgram;

@TruffleLanguage.Registration(id = "logo", name = "logo", mimeType = "application/boa", contextPolicy = ContextPolicy.SHARED)
public class LogoLang extends TruffleLanguage<Void> {

	public LogoLang() {
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
			return eObject.eClass().getEPackage().getNsURI().equals(KmLogoPackage.eINSTANCE.getNsURI());
		} else {
			return false;
		}
	}

	@Override
	public CallTarget parse(final TruffleLanguage.ParsingRequest request) throws Exception {

		LogoProgram model = init();
		return Truffle.getRuntime().createCallTarget(new RootNode(LogoLang.this) {

			@Override
			public Object execute(final VirtualFrame frame) {
				final long start = System.currentTimeMillis();
				model.eval();
				return System.currentTimeMillis() - start;
			}
		});
	}

	@TruffleBoundary
	private LogoProgram init() {
		KmLogoPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createFileURI(CompiledInterpreterTruffleLogoAlLDispatch.file);
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final LogoProgram model = (LogoProgram) resource.getContents().get(0);
		return model;
	}

}
