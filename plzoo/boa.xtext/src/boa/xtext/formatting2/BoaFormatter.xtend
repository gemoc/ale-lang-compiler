/*
 * generated by Xtext 2.14.0
 */
package boa.xtext.formatting2

import boa.Def
import boa.File
import boa.xtext.services.BoaGrammarAccess
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class BoaFormatter extends AbstractFormatter2 {
	
	@Inject extension BoaGrammarAccess

	def dispatch void format(File file, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (topLevelCmd : file.commands) {
			topLevelCmd.format
		}
	}

	def dispatch void format(Def _def, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		_def.expr.format
	}
	
	// TODO: implement for App, Project, BObject, Copy, With, Not, If, Let, Fun, Assign, ArithOpPlus, ArithOpMinus, ArithOpTimes, ArithOpDivide, ArithOpRemainder, BoolOpAnd, BoolOpOr, Seq, CmpOpEqual, CmpOpUnequal, CmpOpLess, Field
}
