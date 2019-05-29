package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Comparator
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Statement
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.lib.Functions.Function2

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.TruffleHelper

class InterpreterEClassImplementationCompiler {
	extension InterpreterNamingUtils namingUtils
	extension JavaPoetUtils jpu = new JavaPoetUtils
	extension InterpreterTypeSystemUtils tsu
	extension AleBodyCompiler abc
	extension EClassImplementationCompiler ecic
	extension TruffleHelper th

	var Dsl dsl
	val String packageRoot
	var Set<Method> registreredDispatch = newHashSet
	var Set<String> registreredArrays = newHashSet
	val List<ResolvedClass> resolved

	new(String packageRoot, List<ResolvedClass> resolved, CommonCompilerUtils ccu, EnumeratorService es, TruffleHelper th) {
		this.packageRoot = packageRoot
		this.resolved = resolved
		this.namingUtils = new InterpreterNamingUtils
		this.ecic = new EClassImplementationCompiler(ccu, namingUtils,
			new EClassGetterCompiler(namingUtils, ccu, resolved, dsl, th), jpu, resolved, es, th)
			this.th = th
	}
	

	def dispatch compileEClassImplementation(EClassifier eClass, ExtendedClass aleClass, File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, Dsl dsl, BaseValidator base, InterpreterTypeSystemUtils tsu, InterpreterNamingUtils inu) {
	}

	def dispatch compileEClassImplementation(EClass eClass, ExtendedClass aleClass, File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, Dsl dsl, BaseValidator base, InterpreterTypeSystemUtils tsu, InterpreterNamingUtils inu) {
		this.dsl = dsl
		val isTruffle = dsl.dslProp.getOrDefault("truffle", "false") == "true"
		this.tsu = tsu
		abc = new AleBodyCompiler(syntaxes, packageRoot, base, resolved, registreredDispatch, registreredArrays,
			registeredServices, isTruffle, new CommonTypeInferer(base), new EnumeratorService, inu)

		val implPackage = eClass.classImplementationPackageName(packageRoot)

		val aleMethods = if (aleClass !== null) {
				val ret = newArrayList
				for (x : aleClass.methods) {
					ret += x.compile(aleClass, eClass, isTruffle)
				}
				ret
			} else
				#[]

		val whileOps = if (aleClass !== null) {
				EcoreUtil2.getAllContentsOfType(aleClass, While)
			} else
				#[]
				
		val Function2<FieldSpec.Builder, EReference, FieldSpec.Builder> f2 = [ builderTmp, field |
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val isMutable = aleClass !== null && aleClass.mutable.exists[it == field.name]
			builderTmp.applyIfTrue(
				dsl.dslProp.getOrDefault("child", "false").equals("true") && !isMultiple && !isMutable &&
					field.containment && !field.EType.EAnnotations.exists[it.source == 'RuntimeData'], [
					addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child"))
				])
		]

		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName)
			.compileEcoreRelated(eClass, aleClass, packageRoot, dsl, f2)
			.applyIfTrue(aleClass !== null, [addMethods(aleMethods)])
			.applyIfTrue(isTruffle, [
				addFields(registreredArrays.map [ fieldName |
					val x = eClass.EAllReferences.filter[it.name == fieldName].head.EType.resolveType
					val xa = ArrayTypeName.of(x)
					FieldSpec.builder(xa, '''«fieldName»Arr''', PRIVATE).applyIfTrue(isTruffle &&
						!eClass.EAnnotations.exists[it.source == 'RuntimeData'], [
						addAnnotation(ClassName.get('com.oracle.truffle.api.nodes.Node', 'Children'))
					]).build
				])
			]).applyIfTrue(isTruffle && !eClass.EAnnotations.exists[it.source == 'RuntimeData'], [
				addAnnotation(
					AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "NodeInfo")).addMember(
						"description", '$S', eClass.name).build
				)
			]).applyIfTrue(aleClass !== null, [
				addFields(aleClass.methods.filter [
					it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'
				].map [
					FieldSpec.builder(
						ClassName.get(
							eClass.
								classImplementationPackageName(
									packageRoot), '''«eClass.name»DispatchWrapper«it.operationRef.name.toFirstUpper»'''), '''cached«it.operationRef.name.toFirstUpper»''').
						addModifiers(PRIVATE).addAnnotation(
							ClassName.get('com.oracle.truffle.api.CompilerDirectives', 'CompilationFinal')).build
				])
			]).applyIfTrue(aleClass !== null, [
				addMethods(aleClass.methods.filter [
					it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'
				].map [
					MethodSpec.methodBuilder('''getCached«it.operationRef.name.toFirstUpper»''').returns(
						ClassName.get(
							eClass.
								classImplementationPackageName(
									packageRoot), '''«eClass.name»DispatchWrapper«it.operationRef.name.toFirstUpper»''')).
						addModifiers(PUBLIC).addCode('''
							return this.cached«it.operationRef.name.toFirstUpper»;
						''').build
				])
			]).applyIfTrue(isTruffle, [
				addFields(registreredDispatch.toList.map [ method |
					FieldSpec.builder(
						ClassName.get(
							implPackage, '''«(method.eContainer as ExtendedClass).normalizeExtendedClassName»Dispatch«method.operationRef.name.toFirstUpper»'''), '''dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper»''',
						PRIVATE).addAnnotation(ClassName.get('com.oracle.truffle.api.nodes.Node', 'Child')).build
				])
			]).addMethod(
				MethodSpec.constructorBuilder.addCode('''
					super();
					«IF aleClass !== null»
						«FOR method: aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true']»
							this.cached«method.operationRef.name.toFirstUpper» = new «eClass.classImplementationPackageName(packageRoot)».«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»(this);
						«ENDFOR»
						«FOR w:whileOps»
						«ENDFOR»
					«ENDIF»
					«IF isTruffle»
						«FOR method: registreredDispatch.toList»
							this.dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper» = «implPackage».«(method.eContainer as ExtendedClass).normalizeExtendedClassName»Dispatch«method.operationRef.name.toFirstUpper»NodeGen.create(); 
						«ENDFOR»
					«ENDIF»
				''').addModifiers(PROTECTED).build
			).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory).indent('\t').build
		javaFile.writeTo(directory)

		generateDispatchClasses(aleClass, directory, eClass)
		generateDispatchWrapperClasses(aleClass, directory, eClass)
		generateRootNodes(aleClass, directory, eClass)

		registreredArrays = newHashSet
		registreredDispatch = newHashSet
	}

	def generateRootNodes(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val packageFQN = eClass.classImplementationPackageName(packageRoot)
				val rootNodeName = '''«eClass.name»«method.operationRef.name.toFirstUpper»RootNode'''
				val eClassInterfaceType = ClassName.get(eClass.classInterfacePackageName(packageRoot),
					eClass.classInterfaceClassName)
				val virtualFrameType = ClassName.get('com.oracle.truffle.api.frame', 'VirtualFrame')

				val factoryDispatch = TypeSpec.classBuilder(rootNodeName).superclass(
					ClassName.get('com.oracle.truffle.api.nodes', 'RootNode'))// TODO: add conditional, must be a child only if it type is a Node
				.addField(
					FieldSpec.builder(eClassInterfaceType, 'it', PRIVATE).addAnnotation(
						ClassName.get('com.oracle.truffle.api.nodes.Node', 'Child')).build).addMethod(
					MethodSpec.constructorBuilder.addParameter(eClassInterfaceType, 'it').addCode('''
						super(null);
						this.it = it;
					''').addModifiers(PUBLIC).build
				).addMethod(
					MethodSpec.methodBuilder('execute').addAnnotation(Override).addParameter(virtualFrameType, 'frame').
						returns(Object).mapParameters(method).addCode('''
							«IF method.operationRef.EType !== null»return «ENDIF»it.«method.operationRef.name»(«FOR p : method.operationRef.EParameters SEPARATOR ', '»«p.name»«ENDFOR»);
							«IF method.operationRef.EType === null»return null;«ENDIF»
						''').addModifiers(PUBLIC).build
				).addModifiers(PUBLIC).build

				val javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch).indent('\t').build
				javaFileDispatch.writeTo(directory)

			]
		}
	}

	def generateDispatchWrapperClasses(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val packageFQN = eClass.classImplementationPackageName(packageRoot)
				val cyclicAssumptionType = ClassName.get('com.oracle.truffle.api.utilities', 'CyclicAssumption')
				val rootCalltargetType = ClassName.get('com.oracle.truffle.api', 'RootCallTarget')
				val assumptionType = ClassName.get('com.oracle.truffle.api', 'Assumption')
				val truffleType = ClassName.get('com.oracle.truffle.api', 'Truffle')
				val rootNodeName = '''«eClass.name»«method.operationRef.name.toFirstUpper»RootNode'''
				val rootNodeType = ClassName.get(packageFQN, rootNodeName)
				val eClassInterfaceType = ClassName.get(eClass.classInterfacePackageName(packageRoot),
					eClass.classInterfaceClassName)

				val name = '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»_«Math.random * 99999999»'''

				/* Look for the closest method that is overriden by the current method and that also has a dispatch annotation */
				val s0 = resolved.filter[eClass.EAllSuperTypes.contains(it.eCls)]
				val s1 = s0.filter[it.aleCls !== null]
				val s2 = s1.map [ resolved |
					resolved.aleCls.allMethods.filter [
						it.operationRef.name == method.operationRef.name && method.dispatch
					].map[resolved -> it]
				].flatten

				val overridenMethods = s2.filter[x|x.value.dispatch].sortWith(
					new Comparator<Pair<ResolvedClass, Method>>() {
						override compare(Pair<ResolvedClass, Method> arg0, Pair<ResolvedClass, Method> arg1) {
							if (arg0.key.eCls instanceof EClass) {
								val eCls = arg0.key.eCls as EClass
								if (eCls.EAllSuperTypes.contains(arg1.key.eCls)) {
									-1
								} else {
									1
								}
							} else {
								0
							}
						}
					}).head

				val factoryDispatch = TypeSpec.classBuilder(namingUtils.dispatchWrapperClassName(eClass, method)).
					applyIfTrue(overridenMethods !== null, [
						it.superclass(
							ClassName.get(packageFQN,
								namingUtils.dispatchWrapperClassName(overridenMethods.key.eCls as EClass,
									overridenMethods.value)))
					]).addField(ClassName.get('com.oracle.truffle.api', 'RootCallTarget'), 'callTarget', PRIVATE).
					addField(cyclicAssumptionType, 'callTargetStable', PRIVATE, FINAL).addMethod(
						MethodSpec.constructorBuilder.addParameter(eClassInterfaceType, 'it').addCode('''
							«IF overridenMethods !== null»super(it);«ENDIF»
							this.callTargetStable = new $T($S);
							this.callTarget = $T.getRuntime().createCallTarget(new $T(it));
						''', cyclicAssumptionType, name, truffleType, rootNodeType).addModifiers(PROTECTED).build).
					addMethod(
						MethodSpec.methodBuilder('getCallTarget').returns(rootCalltargetType).
							addCode('''return callTarget;''').addModifiers(PUBLIC).build
					).addMethod(
						MethodSpec.methodBuilder('getCallTargetStable').returns(assumptionType).
							addCode('''return callTargetStable.getAssumption();''').addModifiers(PUBLIC).build
					).addModifiers(PUBLIC).build

				val javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch).indent('\t').build
				javaFileDispatch.writeTo(directory)

			]
		}
	}

	def generateDispatchClasses(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val specializationType = ClassName.get('com.oracle.truffle.api.dsl', 'Specialization')
				val cachedType = ClassName.get('com.oracle.truffle.api.dsl', 'Cached')

				val factoryDispatch = TypeSpec.
					classBuilder('''«eClass.name»Dispatch«method.operationRef.name.toFirstUpper»''').superclass(
						ClassName.get("com.oracle.truffle.api.nodes", "Node")).addField(
						FieldSpec.builder(int, 'INLINE_CACHE_SIZE', PUBLIC, STATIC, FINAL).initializer('3').build).
					addMethod(
						MethodSpec.methodBuilder('''executeDispatch''').addModifiers(PUBLIC, ABSTRACT).
							addParameter(Object, 'function').addParameter(typeof(Object[]), 'arguments').
							returns(Object).build).addMethod(
						MethodSpec.methodBuilder('doDirect').addAnnotation(
							AnnotationSpec.builder(specializationType).addMember('limit', '"INLINE_CACHE_SIZE"').
								addMember('guards', '"function.getCallTarget() == cachedTarget"').addMember(
									'assumptions', '"callTargetStable"').build
						).addModifiers(PROTECTED, STATIC).returns(Object).addParameter(
							ParameterSpec.builder(
								ClassName.get(
									eClass.
										classImplementationPackageName(
											packageRoot), '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''),
								'function').build
						).addParameter(typeof(Object[]), 'arguments').addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'Assumption'),
								'callTargetStable').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTargetStable()"').build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'RootCallTarget'),
								'cachedTarget').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTarget()"').build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api.nodes', 'DirectCallNode'),
								'callNode').addAnnotation(
								AnnotationSpec.builder(cachedType).addMember('value', '"create(cachedTarget)"').build
							).build
						).addCode("return callNode.call(arguments);").build
					).addMethod(
						MethodSpec.methodBuilder('doIndirect').addAnnotation(
							AnnotationSpec.builder(specializationType).addMember('replaces', '"doDirect"').build
						).addParameter(
							ParameterSpec.builder(
								ClassName.get(
									eClass.
										classImplementationPackageName(
											packageRoot), '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''),
								'function').build
						).addParameter(typeof(Object[]), 'arguments').addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api.nodes', 'IndirectCallNode'),
								'callNode').addAnnotation(
								AnnotationSpec.builder(cachedType).addMember('value', '"create()"').build).build
						).addCode('''return callNode.call(function.getCallTarget(), arguments);''').returns(Object).
							addModifiers(PROTECTED, STATIC).build
					).addModifiers(PUBLIC, ABSTRACT).build

				val javaFileDispatch = JavaFile.builder(eClass.classImplementationPackageName(packageRoot),
					factoryDispatch).indent('\t').build
				javaFileDispatch.writeTo(directory)

			]
		}
	}

	def MethodSpec compile(Method method, ExtendedClass aleClass, EClass aClass, boolean isTruffle) {
		val retType = method.operationRef.EType?.resolveType2 // TODO: DEBUG & correct !!!
		MethodSpec.methodBuilder(method.operationRef.name).addModifiers(PUBLIC).applyIfTrue(retType !== null, [
			returns(retType)
		])
		.addTruffleBoundaryAnnotation(aClass.EAnnotations.exists[it.source == 'RuntimeData'] && dsl.dslProp.getProperty('truffle', "false") == "true")
		.addParameters(method.operationRef.EParameters.map [
			if (it.EType.instanceClass !== null) {
				if (it.EType instanceof EClass && !(it.EType.EPackage == EcorePackage.eINSTANCE)) {
					ParameterSpec.builder(
						ClassName.get((it.EType as EClass).classInterfacePackageName(packageRoot),
							(it.EType as EClass).name), it.name).build
				} else {
					ParameterSpec.builder(it.EType.instanceClass, it.name).build

				}
			} else {
				ParameterSpec.builder(it.EType.resolveType, it.name).build
			}
		]).openMethod(method.operationRef.EType?.resolveType2).compileBodyAndPrefix(method.body,
			new CompilerExpressionCtx('this', aleClass, aClass), isTruffle).closeMethod(method.operationRef.EType).build

	}

	def MethodSpec.Builder compileBodyAndPrefix(MethodSpec.Builder builder, Statement body, CompilerExpressionCtx ctx,
		boolean isTruffle) {
		val cbb = compileBody(CodeBlock.builder, body, ctx)
		if (isTruffle) {
			registreredArrays.fold(builder, [ b, array |
				val x = ctx.EClass.EAllReferences.filter[it.name == array].head.EType.resolveType
				b.addStatement(CodeBlock.builder.addNamed('''
					if (this.«array»Arr == null) {
						$cd:T.transferToInterpreterAndInvalidate();
						if (this.«array» != null) this.«array»Arr = this.«array».toArray(new «x»[0]);
						else this.«array»Arr = new «x»[] {};
						
					}
				''', newHashMap("cd" -> ClassName.get("com.oracle.truffle.api", "CompilerDirectives"))).build)
			]).addStatement(cbb.build)

		} else {
			builder.addCode(cbb.build)
		}

	}

	def MethodSpec.Builder mapParameters(MethodSpec.Builder builderSeed, Method method) {
		var builder = builderSeed
		for (var i = 0; i < method.operationRef.EParameters.size; i = i + 1) {

			val parameter = method.operationRef.EParameters.get(i)

			val type = if (parameter.EType.instanceClass !== null) {
					if (parameter.EType instanceof EClass && !(parameter.EType.EPackage == EcorePackage.eINSTANCE)) {
						ClassName.get((parameter.EType as EClass).classInterfacePackageName(packageRoot),
							(parameter.EType as EClass).name)
					} else {
						ClassName.get(parameter.EType.instanceClass)
					}
				} else {
					parameter.EType.resolveType
				}
			builder = builder.addStatement('''«type» «parameter.name» = («type») frame.getArguments()[«i»]''')
		}

		return builder
	}
}
