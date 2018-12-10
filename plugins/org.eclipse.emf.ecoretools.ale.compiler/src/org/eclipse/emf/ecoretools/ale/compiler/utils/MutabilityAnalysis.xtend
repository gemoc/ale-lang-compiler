package org.eclipse.emf.ecoretools.ale.compiler.utils

import java.util.List
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.Attribute
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
import org.eclipse.emf.ecoretools.ale.implementation.ForEach
import org.eclipse.emf.ecoretools.ale.implementation.If
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

/**
 * Mark every field mutated potentialy mutated during the language execution to mutable.
 * Based on closed world hypothesis.
 */
class MutabilityAnalysis {

	/**
	 * @param behavior: the language to analyze
	 * @param baseValidator: the resolved types for the language
	 */
	def analyse(ModelUnit unit, BaseValidator baseValidator) {
		val weavedAttributes = unit.classExtensions.map[it.attributes].flatten
		val metamodelAttributes = unit.classExtensions.map[it.baseClass.EAttributes].flatten

		val allAttributes = weavedAttributes + metamodelAttributes

		val cds = unit.classDefinitions + unit.classExtensions
		val ret = cds.map [
			it.methods.map [
				it.body.statements.map [
					println('STMT')
					it.mutatedAttributes(baseValidator)
				]
			]
		].flatten.flatten.flatten.toSet

		ret.toList

	}

	def dispatch List<Attribute> mutatedAttributes(FeatureAssignment s, BaseValidator baseValidator) {
		// s.target <- the mutated thing
//			s.targetFeature
		println(baseValidator.getPossibleTypes(s.target)) // type of the parent element;
		println(baseValidator.getPossibleTypes(s.value))
		println(s.target + '.' + s.targetFeature) // targetFeature = name of the field
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(FeatureInsert s, BaseValidator baseValidator) {
		println(baseValidator.getPossibleTypes(s.target)) // type of the parent element;
		println(baseValidator.getPossibleTypes(s.value))
		println(s.target + '.' + s.targetFeature) // targetFeature = name of the field
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(FeatureRemove s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(VariableAssignment s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(Block s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(ConditionalBlock s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(ExpressionStatement s, BaseValidator baseValidator) {
		println(baseValidator.getPossibleTypes((s.expression as Call).arguments.head))
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(FeaturePut s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(ForEach s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(If s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(VariableDeclaration s, BaseValidator baseValidator) {
		println(s)
		#[]
	}

	def dispatch List<Attribute> mutatedAttributes(While s, BaseValidator baseValidator) {
		println(s)
		#[]
	}
}
