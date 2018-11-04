package petrinet.benchmark.truffle;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;

import truffle.petrinet.interpreter.petrinet.Petrinet;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;

@TruffleLanguage.Registration(id = "petrinet", name = "petrinet", mimeType = "application/boa", contextPolicy = ContextPolicy.SHARED)
public class PetrinetLang extends TruffleLanguage<Void> {
	public PetrinetLang() {
		super();
	}

	@Override
	protected Void createContext(Env env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isObjectOfLanguage(Object object) {
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			return eObject.eClass().getEPackage().getNsURI().equals(PetrinetPackage.eINSTANCE.getNsURI());
		} else {
			return false;
		}
	}

	@Override
	public CallTarget parse(final TruffleLanguage.ParsingRequest request) throws Exception {
		PetrinetPackage.eINSTANCE.eClass();

		Petrinet result = ModelFactory.chainOfOne(1000);

		return Truffle.getRuntime().createCallTarget(new SLEvalRootNode(PetrinetLang.this, result));
	}
}
