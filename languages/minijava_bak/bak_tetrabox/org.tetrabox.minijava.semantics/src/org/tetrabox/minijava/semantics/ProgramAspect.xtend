package org.tetrabox.minijava.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Main
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.Program

import static extension org.tetrabox.minijava.semantics.BlockAspect.*
import java.util.List
import org.tetrabox.minijava.xtext.miniJava.ArrayTypeRef
import org.tetrabox.minijava.xtext.miniJava.StringTypeRef
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel
import fr.inria.diverse.melange.annotation.Containment

@Aspect(className=Program)
class ProgramAspect {

	@Containment
	public State state

	@Main
	@Step
	def void main() {
		_self.execute
	}


	

	@InitializeModel
	def void initialize(List<String> args) {
		val main = _self.classes.map[members].flatten.filter(Method).findFirst [
			it.name == "main" && it.static && it.params.size == 1 && it.params.head.typeRef instanceof ArrayTypeRef &&
				(it.params.head.typeRef as ArrayTypeRef).typeRef instanceof StringTypeRef
		]

		if (main !== null) {

			// Prepare args array
			val argsArray = MinijavadynamicdataFactory::eINSTANCE.createArrayInstance
			argsArray.size = args.size
			for (arg : args) {
				val stringVal = MinijavadynamicdataFactory::eINSTANCE.createStringValue => [value = arg]
				argsArray.value.add(stringVal)
			}

			// Prepare binding for args param
			val argsBinding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
				symbol = main.params.head
				value = MinijavadynamicdataFactory::eINSTANCE.createArrayRefValue => [
					instance = argsArray
				]
			]

			// Prepare root context with args binding
			val rootCont = MinijavadynamicdataFactory::eINSTANCE.createContext
			rootCont.bindings.add(argsBinding)

			// Prepare initial state
			 
			val state = MinijavadynamicdataFactory::eINSTANCE.createState => [
				outputStream = MinijavadynamicdataFactory::eINSTANCE.createOutputStream
				rootFrame = MinijavadynamicdataFactory::eINSTANCE.createFrame => [
					rootContext = rootCont
				]
			]
			state.arraysHeap.add(argsArray)
			_self.state = state

		} else
			throw new RuntimeException("No main method found.")
	}

	def State execute() {
		
		val main = _self.classes.map[members].flatten.filter(Method).findFirst [
			it.name == "main" && it.static && it.params.size == 1 && it.params.head.typeRef instanceof ArrayTypeRef &&
				(it.params.head.typeRef as ArrayTypeRef).typeRef instanceof StringTypeRef
		]
		// Start the main method
		main.body.evaluateStatementKeepContext(_self.state)
		return _self.state
	}

}
