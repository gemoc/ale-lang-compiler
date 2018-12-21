package minijava;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleRuntime;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Program;

@TruffleLanguage.Registration(id = "miniJava", name = "miniJava", mimeType = "application/miniJava", contextPolicy = TruffleLanguage.ContextPolicy.SHARED)
@SuppressWarnings("all")
public class MiniJavaLang extends TruffleLanguage<Void> {
	public MiniJavaLang() {
		super();
	}

	@Override
	protected Void createContext(final TruffleLanguage.Env env) {
		return null;
	}

	@Override
	protected boolean isObjectOfLanguage(final Object object) {
		if ((object instanceof EObject)) {
			final EObject eObject = ((EObject) object);
			return eObject.eClass().getEPackage().getNsURI().equals(MiniJavaPackage.eINSTANCE.getNsURI());
		} else {
			return false;
		}
	}

	@Override
	public CallTarget parse(final TruffleLanguage.ParsingRequest request) throws Exception {
		final ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put("http://miniJava.miniJava.miniJava/", MiniJavaPackage.eINSTANCE);
		final Resource resource = rs.getResource(URI.createURI(MiniJavaPerfTest.file), true);
		EObject _get = resource.getContents().get(0);
		final Program result = ((Program) _get);
		EcoreUtil.resolveAll(rs);
		TruffleRuntime _runtime = Truffle.getRuntime();
		return _runtime.createCallTarget(new RootNode(null) {
			@Override
			public Object execute(final VirtualFrame frame) {
				BasicEList<Object> _basicEList = new BasicEList<Object>();
				result.initialize(_basicEList);
				final long start = System.currentTimeMillis();
				result.execute();
				long _currentTimeMillis = System.currentTimeMillis();
				return Long.valueOf((_currentTimeMillis - start));
			}
		});
	}
}
