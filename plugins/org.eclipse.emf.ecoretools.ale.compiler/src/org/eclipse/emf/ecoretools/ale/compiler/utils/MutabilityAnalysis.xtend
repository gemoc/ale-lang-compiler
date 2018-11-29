package org.eclipse.emf.ecoretools.ale.compiler.utils

import java.util.List
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
import org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

/**
 * Mark every field mutated potentialy mutated during the language execution to mutable.
 * Based on closed world hypothesis.
 */
class MutabilityAnalysis {
	def analyse(ModelBehavior behavior) {
		val weavedAttributes = behavior.units.map[it.classExtensions.map[it.attributes]].flatten.flatten
		val metamodelAttributes = behavior.units.map[it.classExtensions.map[it.baseClass.EAttributes]].flatten.flatten

		val allAttributes = weavedAttributes + metamodelAttributes

		behavior.units.map[it.classDefinitions.map[it.methods.map[it.body.statements.map[it.mutatedAttributes]]]]
	
	}

	def dispatch List<Attribute> mutatedAttributes(FeatureAssignment s) {
//		s.get
	}

	def dispatch List<Attribute> mutatedAttributes(FeatureInsert s) {
	}

	def dispatch List<Attribute> mutatedAttributes(FeatureRemove s) {
	}

	def dispatch List<Attribute> mutatedAttributes(VariableAssignment s) {
	}

	def dispatch List<Attribute> mutatedAttributes(Block s) {
	}

	def dispatch List<Attribute> mutatedAttributes(ConditionalBlock s) {
	}

	def dispatch List<Attribute> mutatedAttributes(ExpressionStatement s) {
	}

	def dispatch List<Attribute> mutatedAttributes(FeaturePut s) {
	}

	def dispatch List<Attribute> mutatedAttributes(ForEach s) {
	}

	def dispatch List<Attribute> mutatedAttributes(If s) {
	}

	def dispatch List<Attribute> mutatedAttributes(VariableDeclaration s) {
	}

	def dispatch List<Attribute> mutatedAttributes(While s) {
	}
}
