package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import java.util.List
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import java.util.Map
import org.apache.maven.model.Dependency
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.apache.maven.artifact.repository.ArtifactRepository
import org.apache.maven.artifact.resolver.ArtifactResolutionException
import org.apache.maven.artifact.resolver.ArtifactNotFoundException
import org.apache.maven.artifact.factory.ArtifactFactory
import org.apache.maven.artifact.resolver.ArtifactResolver
import java.net.URLClassLoader
import java.lang.reflect.Modifier

class MavenServiceRegistrationManager extends ServicesRegistrationManager {

	List<Dependency> dependencies

	ArtifactRepository localRepository
	List remoteRepositories
	ArtifactFactory artifactFactory
	ArtifactResolver resolver

	new(
		List<Dependency> dependencies,
		ArtifactRepository localRepository,
		List remoteRepositories,
		ArtifactFactory artifactFactory,
		ArtifactResolver resolver
	) {
		this.dependencies = dependencies
		this.localRepository = localRepository
		this.remoteRepositories = remoteRepositories
		this.artifactFactory = artifactFactory
		this.resolver = resolver
	}

	override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
		registerServices(services.toList)
	}

	def registerServices(List<String> services) {
		println("\n\nServices to register :")
		println(services)

		val urls = newArrayList

		for (Dependency d : dependencies) {
			val artifact = artifactFactory.createArtifactWithClassifier(d.getGroupId(), d.getArtifactId(),
				d.getVersion(), d.getType(), d.getClassifier());
			try {
				resolver.resolve(artifact, remoteRepositories, localRepository)
				urls.add(artifact.file.toURL)
			} catch (ArtifactResolutionException e) {
				e.printStackTrace();
			} catch (ArtifactNotFoundException e) {
				e.printStackTrace();
			}
		}

		val ucl = URLClassLoader.newInstance(urls, Thread.currentThread().getContextClassLoader());
		for (service : services) {
			try {
				val clazz = Class.forName(service, false, ucl)
				println("INFO: " + service + " was successfully instantiate")
				val classname = clazz.name
				val packagename = clazz.package.name
				val pair = packagename -> classname
				for(method : clazz.declaredMethods){
					if(Modifier.isStatic(method.modifiers)){
						registeredServices.put(method.name, pair)
					}
				}
			} catch (Throwable e) {
				println("WARNING: failed to instantiate " + service)
			}
		}
	}

}
