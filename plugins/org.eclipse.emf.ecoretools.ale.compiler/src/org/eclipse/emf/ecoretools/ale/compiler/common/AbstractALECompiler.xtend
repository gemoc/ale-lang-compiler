package org.eclipse.emf.ecoretools.ale.compiler.common

import java.io.File
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback

abstract class AbstractALECompiler {
	protected val ServicesRegistrationManager srm
	protected extension EcoreUtils eu
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	val Dsl dsl
	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	var List<ResolvedClass> resolved
	protected val String projectName
	protected val File projectRoot

	protected def getParsedSemantics() {
		parsedSemantics
	}

	protected def getSyntaxes() {
		syntaxes
	}

	protected def getQueryEnvironment() {
		queryEnvironment
	}

	protected def getDsl() {
		dsl
	}

	protected def getRegisteredServices() {
		srm.registeredServices
	}

	protected def getResolved() {
		resolved
	}
	
	new(String projectName, File projectRoot, Dsl dsl, EcoreUtils eu, ServicesRegistrationManager srm) {
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
		this.srm = srm
		this.srm.registeredServices = this.registeredServices
		this.eu = eu
		this.projectName = projectName
		this.projectRoot = projectRoot
		this.dsl = dsl
	}
	
	new(String projectName, File projectRoot, Dsl dsl, Map<String, Pair<String, String>> services, EcoreUtils eu, ServicesRegistrationManager srm) {
		this(projectName, projectRoot, dsl, eu, srm);

		registeredServices.putAll(services)
	}

	def registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
		srm.registerServices(projectName, parsedSemantics)
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax,
		Map<String, Pair<EPackage, GenModel>> syntaxes) {
		syntax.allClasses.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			val GenClass gl = syntaxes.filter[k, v|v.key.allClasses.contains(eClass)].values.map[value].map [
				it.genPackages.map [
					it.genClasses
				].flatten
			].flatten.filter[it.ecoreClass == eClass].head
			if(gl === null) throw new RuntimeException('''gl is null''')
			new ResolvedClass(aleClass, eClass, gl)
		]
	}

	def IStatus compile() {
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

//		if (services !== null && !services.empty) {
//			this.registeredServices.putAll(services)
//		} 
		registerServices(projectName, parsedSemantics)

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		syntaxes = dsl.allSyntaxes.toMap([it], [
			return (loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)
		])
		val syntax = syntaxes.get(dsl.allSyntaxes.head).key
		resolved = resolve(aleClasses, syntax, syntaxes)

		// must be last !
		compile(projectRoot, projectName)

		Status.OK_STATUS
	}

	def private IQueryEnvironment createQueryEnvironment(boolean b, Object object) {
		val IQueryEnvironment newEnv = new ExtensionEnvironment()
		newEnv.registerEPackage(EcorePackage.eINSTANCE)
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
			EStringToStringMapEntryImpl)
		newEnv
	}

	abstract def void compile(File projectRoot, String projectName)

}
