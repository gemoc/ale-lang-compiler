package org.eclipse.emf.ecoretools.ale.compiler.app;

import java.io.File;
import java.util.HashMap;

import org.eclipse.emf.ecoretools.ale.compiler.ALEImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import execboa.MapService;
import execboa.MathService;
import execboa.SerializeService;
import execboa.ToStringService;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	@Override
	public Object start(final IApplicationContext context) throws Exception {

		final HashMap<String, Class<?>> services = new HashMap<String, Class<?>>();
		services.put("org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices", TrigoServices.class);
		services.put("execboa.SerializeService", SerializeService.class);
		services.put("execboa.MapService", MapService.class);
		services.put("execboa.MathService", MathService.class);
		services.put("execboa.ToString", ToStringService.class);
		final String pwd = new File("").getAbsolutePath();
		new ALEImplementationCompiler().compile(
				pwd + "/workspace/standaloneboainterpreter/src/boa_exec_interpreter_truffle.dsl",
				new File(pwd + "/workspace/standaloneboainterpreter/"), "standaloneboainterpreter", services);
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
