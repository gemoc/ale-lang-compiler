package org.eclipse.emf.ecoretools.ale.compiler

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.function.Function
import javax.lang.model.element.Modifier
import org.eclipse.acceleo.query.ast.And
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.ast.BooleanLiteral
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.EnumLiteral
import org.eclipse.acceleo.query.ast.ErrorBinding
import org.eclipse.acceleo.query.ast.ErrorCall
import org.eclipse.acceleo.query.ast.ErrorConditional
import org.eclipse.acceleo.query.ast.ErrorExpression
import org.eclipse.acceleo.query.ast.ErrorStringLiteral
import org.eclipse.acceleo.query.ast.ErrorTypeLiteral
import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.Implies
import org.eclipse.acceleo.query.ast.IntegerLiteral
import org.eclipse.acceleo.query.ast.Lambda
import org.eclipse.acceleo.query.ast.Let
import org.eclipse.acceleo.query.ast.NullLiteral
import org.eclipse.acceleo.query.ast.Or
import org.eclipse.acceleo.query.ast.RealLiteral
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral
import org.eclipse.acceleo.query.ast.SetInExtensionLiteral
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.ast.TypeLiteral
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
import org.eclipse.emf.ecoretools.ale.implementation.ForEach
import org.eclipse.emf.ecoretools.ale.implementation.If
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.xtend.lib.annotations.Data
import com.squareup.javapoet.TypeName
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function0
import org.eclipse.acceleo.query.validation.type.EClassifierType

class ALERevisitorImplementationCompiler {
	val IQueryEnvironment queryEnvironment

	extension NamingUtils = new NamingUtils
	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics

	var WorkbenchDsl dsl

	@Data
	static class ResolvedClass {
		ExtendedClass alexCls
		public EClass eCls
		GenClass genCls
	}

	new() {
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
	}

	def private IQueryEnvironment createQueryEnvironment(boolean b, Object object) {
		val IQueryEnvironment newEnv = new ExtensionEnvironment()
		newEnv.registerEPackage(EcorePackage.eINSTANCE)
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
			EStringToStringMapEntryImpl)
		newEnv
	}

	def void compile(String dslStr, File projectRoot) throws FileNotFoundException {
		dsl = new WorkbenchDsl(dslStr)
		this.parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)
		this.compile(projectRoot)
	}

	def private void compile(File projectRoot) {

		val compileDirectory = new File(projectRoot, "revisitor-comp")

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		val syntax = dsl.allSyntaxes.head.loadEPackage

		val resolved = resolve(aleClasses, syntax)

		val interfaceName = dsl.revisitorImplementationClass

		val comparator = Comparator.comparing(new Function<ResolvedClass, String>() {
			override apply(ResolvedClass arg0) {
				arg0.eCls.name
			}
		}).thenComparing(new Function<ResolvedClass, String>() {
			override apply(ResolvedClass arg0) {
				arg0.eCls.EPackage.name
			}
		})
		val typeParams = resolved.sortWith(comparator).map [
			ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.eCls.name)
		]
		val fullInterfaceType = ParameterizedTypeName.get(
			ClassName.get(syntax.revisitorPackageFqn, syntax.revisitorInterfaceName), typeParams)

		val revisitorInterface = TypeSpec.interfaceBuilder(interfaceName).addSuperinterface(fullInterfaceType).
			addModifiers(Modifier.PUBLIC).addMethods(syntax.allClasses.map [
				MethodSpec.methodBuilder(it.denotationName).returns(
					ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.name)).addParameter(
					it.solveType as TypeName, "it").addStatement('''return new $T(it, this)''',
					ClassName.get('''«dsl.revisitorImplementationPackage».operation.impl''', '''«it.name»Impl''')).
					addModifiers(Modifier.DEFAULT, Modifier.PUBLIC).build
			]).build

		val javaFile = JavaFile.builder(dsl.revisitorImplementationPackage, revisitorInterface).build

		javaFile.writeTo(compileDirectory)

		resolved.forEach [
			try {
				val operationInterface = TypeSpec.interfaceBuilder(it.eCls.name).addSuperinterfaces(eCls.ESuperTypes.map [
					ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.name)
				]).addModifiers(Modifier.PUBLIC).addMethods(it.alexCls?.methods?.map [
					MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).
						returnType(it.operationRef.EType).addParameters(it.operationRef.EParameters.map [
							if (it.EType.instanceClass !== null) {
								ParameterSpec.builder(it.EType.instanceClass, it.name).build
							} else {
								ParameterSpec.builder(it.EType.resolveType, it.name).build
							}
						]).build
				] ?: newArrayList).build
				val operationInterfaceFile = JavaFile.builder('''«dsl.revisitorImplementationPackage».operation''',
					operationInterface).build
				operationInterfaceFile.writeTo(compileDirectory)

				val revField = FieldSpec.builder(fullInterfaceType, "rev", Modifier.PRIVATE).build

				val objField = FieldSpec.builder(ClassName.get(getEcoreInterfacesPackage, it.eCls.name), "obj",
					Modifier.PRIVATE).build

				val operationImplementation = TypeSpec.classBuilder('''«it.eCls.name»Impl''').addSuperinterfaces(
					#[ClassName.get(operationInterfaceFile.packageName, operationInterface.name)]).superOperationImpl(
					it.eCls.ESuperTypes.head).addField(revField).addField(objField).addModifiers(Modifier.PUBLIC).
					addMethod(
						MethodSpec.constructorBuilder.addParameter(objField.type, "obj").addParameter(revField.type,
							"rev").addConditionalStatement([!it.ECls.ESuperTypes.empty], 'super(obj, rev)').
							addStatement('''this.obj = obj''').addStatement('''this.rev = rev''').addModifiers(
								Modifier.PUBLIC).build).addModifiers(Modifier.PUBLIC).addMethods(
						it.alexCls?.methods?.map [
							MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC).returnType(
								it.operationRef.EType).addParameters(it.operationRef.EParameters.map [
								if (it.EType.instanceClass !== null) {
									ParameterSpec.builder(it.EType.instanceClass, it.name).build
								} else {
									ParameterSpec.builder(it.EType.resolveType, it.name).build
								}
							]).openMethod(it.operationRef.EType).compileBody(it.body).closeMethod(
								it.operationRef.EType).build
						] ?: newArrayList).build
				val operationImplementationFile = JavaFile.
					builder('''«dsl.revisitorImplementationPackage».operation.impl''', operationImplementation).build
				operationImplementationFile.writeTo(compileDirectory)

			} catch (IllegalArgumentException | NullPointerException e) {
				println(it)
				e.printStackTrace
			}
		]
	}

	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type.solveType)
		} else {
			builder
		}
	}

	def MethodSpec.Builder closeMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement("return result")
		} else {
			builder
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.
				addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression»)''')
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''«body.target.compileExpression.escapeDollar».set«body.targetFeature.toFirstUpper»(«body.value.compileExpression.escapeDollar»)''')
		} else {
			builderSeed.
				addStatement('''«body.target.compileExpression».«body.targetFeature» = «body.value.compileExpression»''')

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body) {
		builderSeed.addStatement('''throw new $T("FeatureInsert not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body) {
		builderSeed.addStatement('''throw new $T("FeatureRemove not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body) {
		builderSeed.addStatement('''«body.name» = «body.value.compileExpression.escapeDollar»''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {
		val t = body.type.solveType
		// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
		builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression.escapeDollar»)''', t, body.name,
			t)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body) {
		builderSeed.addStatement(body.expression.compileExpression.escapeDollar)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeaturePut body) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ForEach body) {
		val lt = infereType(body.collectionExpression).head as SequenceType

		builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression»)''',
			(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body).endControlFlow
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, If body) {
		var ret = builderSeed.beginControlFlow('''if($L)''', body.blocks.head.condition.compileExpression).compileBody(
			body.blocks.head.block).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression).compileBody(x.block).
				endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else).endControlFlow
		ret
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ConditionalBlock body) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, While body) {
		val a = builderSeed.beginControlFlow("while ($L)", body.condition.compileExpression)
		a.compileBody(body.body).endControlFlow
	}

	def dispatch String compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": '''!(«call.arguments.get(0).compileExpression»)'''
			case "greaterThan": '''(«call.arguments.get(0).compileExpression») > («call.arguments.get(1).compileExpression»)'''
			case "differs": '''(«call.arguments.get(0).compileExpression») != («call.arguments.get(1).compileExpression»)'''
			case "sub": '''(«call.arguments.get(0).compileExpression») - («call.arguments.get(1).compileExpression»)'''
			case "add": '''(«call.arguments.get(0).compileExpression») + («call.arguments.get(1).compileExpression»)'''
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					'''«call.arguments.get(0).compileExpression» instanceof «call.arguments.get(1).compileExpression»'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else {
							'''«call.arguments.head.compileExpression».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»'''

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val gm = findGenModelFromExpression(e)
						'''«gm.genPackages.head.qualifiedPackageName».«gm.EPackage.name.toFirstUpper»Factory.eINSTANCE.create«(t.type as EClass).name»()'''
					} else {

						val t = call.arguments.head.infereType.head
						if (t instanceof EClassifierType)
							'''rev.$(«call.arguments.head.compileExpression»).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
						else
							'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
					}
				else
					'''/*Call «call»*/'''
		}

	}

	def dispatch String compileExpression(And call) {
		'''/*AND*/'''
	}

	def dispatch String compileExpression(ErrorCall call) {
		'''/*ERRORCALL*/'''
	}

	def dispatch String compileExpression(Implies call) {
		'''/*IMPLIES*/'''
	}

	def dispatch String compileExpression(Or call) {
		'''/*OR*/'''
	}

	def dispatch String compileExpression(ErrorConditional call) {
		'''/*ERRORCONDITIONAL*/'''
	}

	def dispatch String compileExpression(ErrorBinding call) {
		'''/*ERRORBINDING*/'''
	}

	def dispatch String compileExpression(EEnumLiteral call) {
		'''/*EENUMLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorExpression call) {
		'''/*ERROREXPRESSION*/'''
	}

	def dispatch String compileExpression(ErrorStringLiteral call) {
		'''/*ERRORSTRINGLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorTypeLiteral call) {
		'''/*ERRORTYPELITERAL*/'''
	}

	def dispatch String compileExpression(ErrorVariableDeclaration call) {
		'''/*ERRORVARIABLEDECLARATION*/'''
	}

	def dispatch String compileExpression(Let call) {
		'''/*let*/'''
	}

	def dispatch String compileExpression(BooleanLiteral call) {
		if(call.value) 'true' else 'false'
	}

	def dispatch String compileExpression(EnumLiteral call) {
		'''/*ENUMLITERAL*/'''
	}

	def dispatch String compileExpression(IntegerLiteral call) {
		call.value.toString
	}

	def dispatch String compileExpression(Lambda call) {
		'''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression»'''
	}

	def dispatch String compileExpression(NullLiteral call) {
		'null'
	}

	def dispatch String compileExpression(RealLiteral call) {
		'''/*REALLITERAL*/'''
	}

	def dispatch String compileExpression(SequenceInExtensionLiteral call) {
		'''/*SEQUENNCEINEXTNESIONLITERAL*/'''
	}

	def dispatch String compileExpression(SetInExtensionLiteral call) {
		'''/*SETINEXTENSIONLITERAL*/'''
	}

	def dispatch String compileExpression(StringLiteral call) {
		'''"«call.value»"'''
	}

	def dispatch String compileExpression(TypeLiteral call) {
		'''«(call.value as EClass).solveType»'''
	}

	def dispatch String compileExpression(Switch call) {
		'''/*SWITCH*/'''
	}

	def getEcoreInterfacesPackage() {
		val gm = dsl.allSyntaxes.head.replaceAll(".ecore$", ".genmodel").loadGenmodel
		gm.genPackages.head.qualifiedPackageName
	}

	def dispatch String compileExpression(VarRef call) {
		if(call.variableName == 'self') 'this.obj' else call.variableName
	}

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
	}

	def returnType(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.returns(type.instanceClass)
		} else {
			builder
		}
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax) {
		syntax.allClasses.map [ eClass |
			val aleClass = aleClasses.filter[it.name == eClass.name].head
			new ResolvedClass(aleClass, eClass, null)
		]
	}

	def infereType(Expression exp) {
		val base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		base.getPossibleTypes(exp)
	}

	def resolveType(EClassifier e) {
		val stxs = (dsl.allSyntaxes.map[loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel] +
			#[(EcorePackage.eINSTANCE -> null)])
		val stx = stxs.filter [
			it.key.allClasses.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			val GenClass gclass = gm.allGenPkgs.map [
				it.genClasses.filter [
					it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
				]
			].flatten.head
			val split = gclass.qualifiedInterfaceName.split("\\.")
			val pkg = newArrayList(split).reverse.tail.toList.reverse.join(".")
			val cn = split.last
			ClassName.get(pkg, cn)
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

	}

	def findGenModelFromExpression(Expression e) {
		val t = infereType(e).head
		val stx = dsl.allSyntaxes.filter [
			it.loadEPackage.allClasses.exists [
				it.name == (t.type as EClassifier).name && it.EPackage.name == (t.type as EClassifier).EPackage.name
			]
		].head
		stx.replaceAll(".ecore$", ".genmodel").loadGenmodel
	}

	def escapeDollar(String s) {
		s.replaceAll("\\$\\(", "\\$\\$(")
	}

	def TypeSpec.Builder superOperationImpl(TypeSpec.Builder builder, EClass clazz) {
		if (clazz !== null) {
			builder.superclass(
				ClassName.get('''«dsl.revisitorImplementationPackage».operation.impl''', '''«clazz.name»Impl'''))
		} else {
			builder
		}
	}

	def <F> MethodSpec.Builder addConditionalStatement(MethodSpec.Builder builder, Function0<Boolean> f, String s) {
		if (f.apply()) {
			builder.addStatement(s)
		} else {
			builder
		}
	}
}
