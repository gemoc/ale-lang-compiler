package imp.benchmark.truffle;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import interpreter.imp.interpreter.imp.ArrayValue;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntValue;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;

@TruffleLanguage.Registration(id = "imp", name = "imp", mimeType = "application/boa", contextPolicy = ContextPolicy.SHARED)
public class ImpLang extends TruffleLanguage<Void> {

	public ImpLang() {
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
			return eObject.eClass().getEPackage().getNsURI().equals(ImpPackage.eINSTANCE.getNsURI());
		} else {
			return false;
		}
	}

	@Override
	public CallTarget parse(final TruffleLanguage.ParsingRequest request) throws Exception {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE);
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		final ResourceSetImpl resSet = new ResourceSetImpl();
		final URI createFileURI = URI.createFileURI(ImpBenchmarkTruffle.file);
		final Resource resource = resSet.getResource(createFileURI, true);
		final Stmt result = (Stmt) resource.getContents().get(0);

		final Store s = ImpBenchmarkTruffle.initState(500);

//		final ArrayValue arrayValue = (ArrayValue) sorted.getValues().get("a");
//		final List<Integer> arr = arrayValue.getValues().stream().map(x -> ((IntValue) x).getValue())
//				.collect(Collectors.toList());

		return Truffle.getRuntime().createCallTarget(new RootNode(this) {

			@Override
			public Object execute(VirtualFrame frame) {
				final long start = System.currentTimeMillis();
				final Store sorted = result.execute(s);
				return System.currentTimeMillis() - start;
			}
		});
	}

}
