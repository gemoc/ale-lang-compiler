package org.eclipse.emf.ecoretools.ale.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.RevisitorNamingUtils;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils;

@Mojo(name = "ale-revisitor-compile", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class ALERevisitorCompiler extends AbstractMojo {

	@Parameter(property = "genmodelFile", required = true)
	private File genmodelFile;
	
	@Parameter(defaultValue = "${project.basedir}")
	private File root;
	
	private RevisitorInterfaceGenerator generator;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		final EcoreUtils eu = new EcoreUtils();
		generateRevisitor(eu);
	}

	private void generateRevisitor(final EcoreUtils eu) {
		final String gmPath = genmodelFile.getAbsolutePath();
		final GenModel gm = eu.loadGenmodel(gmPath);

		if (gm == null) {
			getLog().error("Error: Cannot find GenModel for " + gmPath);
			return;
		}

		final String ecorePath = gmPath.replaceAll("\\.genmodel$", ".ecore");
		final EPackage epackage = eu.loadEPackage(ecorePath);

		if (epackage == null) {
			getLog().error("Error: Cannot find EPackage for " + ecorePath);
			return;
		}

		final GenPackage gpkg = gm.getGenPackages().get(0);
		this.generator = new RevisitorInterfaceGenerator(gpkg);
		final RevisitorNamingUtils rnu = new RevisitorNamingUtils(gpkg);

		final File path = new File(root, rnu.getRevisitorInterfacePath(gpkg));
		path.mkdirs();
		final File file = new File(path, rnu.getRevisitorInterfaceName(gpkg) + ".java");

		try {
			final String content = generator.generateInterface(epackage, gm, gpkg);
			final FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (final IOException e) {
			getLog().error("Error: Couldn't generate Revisitor interface. Check Error Log for details.", (Throwable) e);
		}
	}
}
