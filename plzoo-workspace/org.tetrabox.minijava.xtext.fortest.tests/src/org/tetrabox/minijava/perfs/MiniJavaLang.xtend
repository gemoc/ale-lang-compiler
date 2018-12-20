package org.tetrabox.minijava.perfs

import com.oracle.truffle.api.CallTarget
import com.oracle.truffle.api.Truffle
import com.oracle.truffle.api.TruffleLanguage
import com.oracle.truffle.api.frame.VirtualFrame
import com.oracle.truffle.api.nodes.RootNode
import miniJava.interpreter.miniJava.MiniJavaPackage
import miniJava.interpreter.miniJava.Program
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.tetrabox.minijava.xtext.fortest.MiniJavaStandaloneSetup

@TruffleLanguage.Registration(id="miniJava", name="miniJava", mimeType="application/miniJava", contextPolicy=ContextPolicy.
	SHARED) class MiniJavaLang extends TruffleLanguage<Void> {
	new() {
		super()
	}

	override protected Void createContext(Env env) {
		return null
	}

	override protected boolean isObjectOfLanguage(Object object) {
		if (object instanceof EObject) {
			val EObject eObject = (object as EObject)
			return eObject.eClass().getEPackage().getNsURI().equals(MiniJavaPackage.eINSTANCE.getNsURI())
		} else {
			return false
		}
	}

	override CallTarget parse(TruffleLanguage.ParsingRequest request) throws Exception {
		val injector = new MiniJavaStandaloneSetup().createInjectorAndDoEMFRegistration();
		val rs = injector.getInstance(XtextResourceSet)
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		val resource = rs.getResource(
			URI.createURI("/home/manuel/dev/java/ale-lang/runtime-New_configuration/test/src/binarytree.minijava"),
			true)
		val result = resource.getContents().get(0) as Program
		EcoreUtil.resolveAll(rs)
		return Truffle.getRuntime().createCallTarget(new RootNode(null) {

			override execute(VirtualFrame frame) {
				result.initialize(new BasicEList())
				val start = System.currentTimeMillis;
				result.execute;
				return System.currentTimeMillis - start;
			}

		})
	}
}
