package org.tetrabox.minijava.perfs

import miniJava.interpreter.miniJava.Program
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.tetrabox.minijava.xtext.fortest.MiniJavaStandaloneSetup

class BaselineExec {
	def static void main(String[] args) {
		val file = args.get(0);
		val itt = Integer.parseInt(args.get(1));

		val results = newArrayList

		val reg = Resource.Factory.Registry.INSTANCE
		val m = reg.extensionToFactoryMap
		m.put("xmi", new XMIResourceFactoryImpl)

		val injector = new MiniJavaStandaloneSetup().createInjectorAndDoEMFRegistration();
		val rs = injector.getInstance(XtextResourceSet)
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		val resource = rs.getResource(URI.createURI(file), true)
		val result = resource.getContents().get(0) as Program
		EcoreUtil.resolveAll(rs)

		if (itt == 0) {
			val nrs = new ResourceSetImpl

			val nres = nrs.createResource(URI.createURI(resource.URI + '.xmi'))

			nres.contents += EcoreUtil.copy(result)
			nres.save(null);

		}

		for (var i = 0; i < itt; i++) {
			result.initialize(new BasicEList())
			val start = System.currentTimeMillis;
			result.execute;
			val res = System.currentTimeMillis - start;
			results.add(res)
		}
		println('''«FOR i : results BEFORE '[' SEPARATOR ', ' AFTER ']'»«i»«ENDFOR»''')
	}
}
