package org.eclipse.emf.ecoretools.ale.compiler.generic;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.AleStandaloneSetup;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class SummaryUtil {

	@Inject
	private XtextResourceSet resourceSet;

	public static void main(String[] args) {
		new SummaryUtil()
				.run("/home/manuel/dev/java/ale-lang/genetics/workspace/standaloneboainterpreter/src/boa_exec.ale");

	}

	private void run(String alePath) {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		final Injector injector = new AleStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		final Resource res = resourceSet.getResource(URI.createFileURI(alePath), true);

		final Unit u = ((Unit) res.getContents().get(0));
		String r = u.getXtendedClasses().stream().flatMap(c -> {
			return c.getOperations().stream().map(o -> {
				return "new MethodRef(\"" + c.getName() + "\",\"" + o.getName() + "\")";
			});
		}).collect(Collectors.joining(","));
		System.out.println(r);
	}
}
