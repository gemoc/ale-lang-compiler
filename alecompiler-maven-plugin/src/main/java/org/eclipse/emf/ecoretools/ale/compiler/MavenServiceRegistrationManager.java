package org.eclipse.emf.ecoretools.ale.compiler;

import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager;
import java.util.List;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.xtext.xbase.lib.Pair;

import java.util.Map;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.maven.model.Dependency;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolutionException;
import org.apache.maven.artifact.resolver.ArtifactNotFoundException;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.artifact.Artifact;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class MavenServiceRegistrationManager extends ServicesRegistrationManager {

	List<Dependency> dependencies;

	ArtifactRepository localRepository;
	List remoteRepositories;
	ArtifactFactory artifactFactory;
	ArtifactResolver resolver;

	public MavenServiceRegistrationManager(List<Dependency> dependencies, ArtifactRepository localRepository,
			List remoteRepositories, ArtifactFactory artifactFactory, ArtifactResolver resolver) {
		this.dependencies = dependencies;
		this.localRepository = localRepository;
		this.remoteRepositories = remoteRepositories;
		this.artifactFactory = artifactFactory;
		this.resolver = resolver;
	}

	public void registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
		List<String> services = new ArrayList<>();
		for(ParseResult<ModelUnit> semantic : parsedSemantics) {
			if(semantic.getRoot() != null) {
				services.addAll(semantic.getRoot().getServices());
			}
		}
		services.add(TrigoServices.class.getName());
		registerServices(services);
	}

	public void registerServices(List<String> services) {

		ArrayList<URL> urls = new ArrayList<URL>();

		for (Dependency d : dependencies) {
			Artifact artifact = artifactFactory.createArtifactWithClassifier(d.getGroupId(), d.getArtifactId(),
				d.getVersion(), d.getType(), d.getClassifier());
			try {
				resolver.resolve(artifact, remoteRepositories, localRepository);
				urls.add(artifact.getFile().toURL());
			} catch (ArtifactResolutionException e) {
				e.printStackTrace();
			} catch (ArtifactNotFoundException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		URLClassLoader ucl = URLClassLoader.newInstance(urls.toArray(new URL[1]), Thread.currentThread().getContextClassLoader());
		for (String service : services) {
			try {
				Class<?> clazz = Class.forName(service, true, ucl);
				System.out.println("INFO: " + service + " was successfully instantiate");
				String classname = clazz.getSimpleName();
				String packagename = clazz.getPackage().getName();
				Pair<String, String> pair = new Pair<String, String>(packagename, classname);
				for(Method method : clazz.getDeclaredMethods()){
					if(Modifier.isStatic(method.getModifiers())){
						registeredServices.put(method.getName(), pair);
					}
				}
			} catch (Throwable e) {
				System.out.println("WARNING: failed to instantiate " + service);
			}
		}
	}

}
