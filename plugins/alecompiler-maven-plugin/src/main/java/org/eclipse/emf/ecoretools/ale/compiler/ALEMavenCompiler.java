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

			File project = getProject(dslFile);
			
			ServicesRegistrationManager srm =
					new MavenServiceRegistrationManager(
					mvnProject.getDependencies(), 
					localRepository, 
					remoteRepositories, 
					artifactFactory, 
					resolver);
			
			new ALEImplementationCompiler().mavenCompile(location, project, project.getName(), srm, platformLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getProject(File dslFile) {
		if (dslFile.getName().equals("src"))
			return dslFile.getParentFile();
		return getProject(dslFile.getParentFile());
	}
}
