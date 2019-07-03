package org.eclipse.emf.ecoretools.ale.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import org.eclipse.emf.ecoretools.ale.compiler.common.MavenServiceRegistrationManager;
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "ale-dsl-compile", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class ALEMavenCompiler extends AbstractMojo {
	/**
	 * Location of the file.
	 */
	@Parameter(property = "dslFile", required = true)
	private File dslFile;
	
	@Parameter(defaultValue = "${project}")
    private MavenProject mvnProject;

	@Parameter(defaultValue = "${localRepository}")
    private ArtifactRepository
        localRepository;

    @Parameter(defaultValue="${project.remoteArtifactRepositories}")
    private List remoteRepositories;

    @Component
    private ArtifactFactory artifactFactory;

    @Component
    private ArtifactResolver resolver;

	public void execute() throws MojoExecutionException {
		try {
			String location = this.dslFile.getAbsolutePath();
			String platformLocation = getProject(this.dslFile).getParent() + "/";
			getLog().info(platformLocation);

			BufferedReader reader = new BufferedReader(new FileReader(this.dslFile));

			String line = "";
			String fileContent = "";
			while ((line = reader.readLine()) != null) {
				fileContent += line.replace("platform:/resource/", platformLocation) + "\n";
			}
			reader.close();

			getLog().info(fileContent);
			File dslFileAbsolutePath = new File(location.substring(0, location.length() - 4) + "-Maven.dsl");
			BufferedWriter writer = new BufferedWriter(new FileWriter(dslFileAbsolutePath));
			writer.write(fileContent);
			writer.close();

			File project = getProject(dslFileAbsolutePath);
			
			
			URLClassLoader cl = null;
			try {
				cl = initClassLoader();
			} catch (DependencyResolutionRequiredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ServicesRegistrationManager srm = new MavenServiceRegistrationManager(
					//cl,
					mvnProject.getDependencies(), 
					localRepository, 
					remoteRepositories, 
					artifactFactory, 
					resolver);
			
			new ALEImplementationCompiler().mavenCompile(dslFileAbsolutePath.getAbsolutePath(), project, project.getName(), srm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private URLClassLoader initClassLoader() throws DependencyResolutionRequiredException, MalformedURLException {
		List runtimeClasspathElements = mvnProject.getRuntimeClasspathElements();
		URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
		for (int i = 0; i < runtimeClasspathElements.size(); i++) {
		  String element = (String) runtimeClasspathElements.get(i);
		  runtimeUrls[i] = new File(element).toURI().toURL();
		}
		System.out.println(runtimeClasspathElements);
		URLClassLoader newLoader = new URLClassLoader(runtimeUrls,
		  Thread.currentThread().getContextClassLoader());
		return newLoader;
		
	}

	private File getProject(File dslFile) {
		if (dslFile.getName().equals("src"))
			return dslFile.getParentFile();
		return getProject(dslFile.getParentFile());
	}

	private void generateRevisitor() {
//    	String gmPath = dslFile.fullPath.toString;
//		val gm = loadGenmodel(gmPath);
//		val pkg = gm.getEPackage();
//		val gpkg = gm.genPackage();
//		rnu  = new RevisitorNamingUtils(gpkg);
//		this.generator = new RevisitorInterfaceGenerator(gpkg);
//
//		if (gm == null) {
//			MessageDialog.openError(shell, "Error", "Cannot find GenModel for " + gmPath);
//			return;
//		}
//
//		if (pkg == null) {
//			MessageDialog.openError(shell, "Error", "Cannot find EPackage for " + gmPath);
//			return;
//		}
//
//		val project = dslFile.getProject()
//		val path = project.location.append(new Path(gpkg.revisitorInterfacePath))
//		path.toFile().mkdirs()
//		val file = path.append(new Path(gpkg.revisitorInterfaceName)).addFileExtension("java")
//
//		try {
//			val content = generator.generateInterface(pkg, gm, gpkg)
//			val fileWriter = new FileWriter(file.toFile())
//			fileWriter.write(content)
//			fileWriter.close()
//			project.refreshLocal(IResource::DEPTH_INFINITE, new NullProgressMonitor())
//		} catch (AlexException | IOException | CoreException e) {
//			MessageDialog.openError(shell, "Error",
//				"Couldn't generate Revisitor interface. Check Error Log for details.");
//			val logger = PlatformUI.getWorkbench().getService(typeof(Logger));
//			logger.error(e, e.message)
//		}
	}
}
