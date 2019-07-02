package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import java.util.List
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import java.util.Map
import org.apache.maven.model.Dependency
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.apache.maven.project.MavenProject
import org.apache.maven.artifact.repository.ArtifactRepository
import org.apache.maven.artifact.resolver.ArtifactResolutionException
import org.apache.maven.artifact.resolver.ArtifactNotFoundException
import java.io.File

class MavenServiceRegistrationManager extends ServicesRegistrationManager {
	
	List<Dependency> dependencies
	

    private MavenProject project;
    protected ArtifactRepository m_localRepository;
    private org.apache.maven.artifact.repository.ArtifactRepository localRepository;
    private java.util.List remoteRepositories;
    private org.apache.maven.artifact.factory.ArtifactFactory artifactFactory;
    private org.apache.maven.artifact.resolver.ArtifactResolver resolver;
	
	new(Map<String, Class<?>> rs) {
		super(rs)
	}
	
	new(Map<String, Class<?>> rs, List<Dependency> dependencies) {
		super(rs)
		this.dependencies = dependencies
	}
	
	override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
			registerServices(services.toList)
	}
	
	def registerServices(List<String> services) {
		for (Dependency d : dependencies) {
	        val artifact = artifactFactory.createArtifactWithClassifier(d.getGroupId(),
	                d.getArtifactId(), d.getVersion(), d.getType(),
	                d.getClassifier());
	
	        try {
	            resolver.resolve(artifact, remoteRepositories,
	                    localRepository );
	        } catch (ArtifactResolutionException e) {
	            e.printStackTrace();
	        } catch (ArtifactNotFoundException e) {
	            e.printStackTrace();
	        }
	
	        val artifactFile = artifact.file;
	        println(artifactFile.getAbsolutePath());
	    }
	}
	
}