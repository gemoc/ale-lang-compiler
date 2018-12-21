package org.eclipse.emf.ecoretools.ale.compiler.app;

import java.io.File;
import java.util.HashMap;

import org.eclipse.emf.ecoretools.ale.compiler.ALEImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import minijava.MapService;
import minijava.MathService;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	@Override
	public Object start(final IApplicationContext context) throws Exception {

		final HashMap<String, Class<?>> services = new HashMap<String, Class<?>>();
		services.put("org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices", TrigoServices.class);
		services.put("minijava.MapService", MapService.class);
		services.put("minijava.MathService", MathService.class);
		final String pwd = new File("").getAbsolutePath();
		new ALEImplementationCompiler().compile(
				pwd + "/standaloneminijavainterpreter/src/minijava_exec.dsl",
				new File(pwd + "/standaloneminijavainterpreter/"), "standaloneminijavainterpreter", services);
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
