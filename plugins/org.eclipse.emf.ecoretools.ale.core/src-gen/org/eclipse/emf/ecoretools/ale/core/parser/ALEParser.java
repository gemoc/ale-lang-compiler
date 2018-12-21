// Generated from src/org/eclipse/emf/ecoretools/ale/core/parser/ALE.g4 by ANTLR 4.3

/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__80=1, T__79=2, T__78=3, T__77=4, T__76=5, T__75=6, T__74=7, T__73=8, 
		T__72=9, T__71=10, T__70=11, T__69=12, T__68=13, T__67=14, T__66=15, T__65=16, 
		T__64=17, T__63=18, T__62=19, T__61=20, T__60=21, T__59=22, T__58=23, 
		T__57=24, T__56=25, T__55=26, T__54=27, T__53=28, T__52=29, T__51=30, 
		T__50=31, T__49=32, T__48=33, T__47=34, T__46=35, T__45=36, T__44=37, 
		T__43=38, T__42=39, T__41=40, T__40=41, T__39=42, T__38=43, T__37=44, 
		T__36=45, T__35=46, T__34=47, T__33=48, T__32=49, T__31=50, T__30=51, 
		T__29=52, T__28=53, T__27=54, T__26=55, T__25=56, T__24=57, T__23=58, 
		T__22=59, T__21=60, T__20=61, T__19=62, T__18=63, T__17=64, T__16=65, 
		T__15=66, T__14=67, T__13=68, T__12=69, T__11=70, T__10=71, T__9=72, T__8=73, 
		T__7=74, T__6=75, T__5=76, T__4=77, T__3=78, T__2=79, T__1=80, T__0=81, 
		COMMENT=82, LINECOMMENT=83, STRING=84, WS=85, MultOp=86, Integer=87, Real=88, 
		String=89, ErrorString=90, Ident=91;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'default'", "'+='", "'use'", "'dispatch'", "'!='", 
		"'while'", "'{'", "'::'", "'..'", "'one'", "'='", "'for'", "'OrderedSet('", 
		"'null'", "'override'", "'implies'", "'('", "'closure'", "'-='", "','", 
		"'false'", "'Sequence('", "'Real'", "'abstract'", "'unique'", "'reject'", 
		"'>='", "'String'", "'<'", "'forAll'", "']'", "'Sequence{'", "'@'", "'<>'", 
		"'let'", "'+'", "'then'", "'def'", "'as'", "'behavior'", "'true'", "'class'", 
		"';'", "'Integer'", "'any'", "'}'", "'extends'", "'if'", "':='", "'<='", 
		"'sortedBy'", "'isUnique'", "'opposite '", "'collect'", "'switch'", "'exists'", 
		"'.'", "'Boolean'", "'->'", "'case'", "'OrderedSet{'", "'mutable'", "':'", 
		"'['", "'|'", "'=='", "'select'", "'>'", "'contains'", "'xor'", "'or'", 
		"'open'", "'else'", "'in'", "'[ '", "')'", "'and'", "'not'", "'-'", "'import'", 
		"COMMENT", "LINECOMMENT", "STRING", "WS", "MultOp", "Integer", "Real", 
		"String", "ErrorString", "Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImport = 1, RULE_rService = 2, RULE_rClass = 3, 
		RULE_rOpenClass = 4, RULE_rMutableRef = 5, RULE_rNewClass = 6, RULE_rOperation = 7, 
		RULE_rConcreteOperation = 8, RULE_rAbstractOperation = 9, RULE_rTag = 10, 
		RULE_rParameters = 11, RULE_rVariable = 12, RULE_rAttribute = 13, RULE_rCardinality = 14, 
		RULE_rOpposite = 15, RULE_rStatement = 16, RULE_rVarDecl = 17, RULE_rAssign = 18, 
		RULE_rInsert = 19, RULE_rRemove = 20, RULE_rForEach = 21, RULE_rCollection = 22, 
		RULE_rBlock = 23, RULE_rIf = 24, RULE_rWhile = 25, RULE_rExpressionStmt = 26, 
		RULE_rExpression = 27, RULE_rType = 28, RULE_rQualified = 29, RULE_rSwitch = 30, 
		RULE_rCase = 31, RULE_expression = 32, RULE_binding = 33, RULE_addOp = 34, 
		RULE_compOp = 35, RULE_navigationSegment = 36, RULE_callExp = 37, RULE_lambdaExpression = 38, 
		RULE_collectionIterator = 39, RULE_expressionSequence = 40, RULE_variableDefinition = 41, 
		RULE_literal = 42, RULE_typeLiteral = 43, RULE_classifierTypeRule = 44;
	public static final String[] ruleNames = {
		"rRoot", "rImport", "rService", "rClass", "rOpenClass", "rMutableRef", 
		"rNewClass", "rOperation", "rConcreteOperation", "rAbstractOperation", 
		"rTag", "rParameters", "rVariable", "rAttribute", "rCardinality", "rOpposite", 
		"rStatement", "rVarDecl", "rAssign", "rInsert", "rRemove", "rForEach", 
		"rCollection", "rBlock", "rIf", "rWhile", "rExpressionStmt", "rExpression", 
		"rType", "rQualified", "rSwitch", "rCase", "expression", "binding", "addOp", 
		"compOp", "navigationSegment", "callExp", "lambdaExpression", "collectionIterator", 
		"expressionSequence", "variableDefinition", "literal", "typeLiteral", 
		"classifierTypeRule"
	};

	@Override
	public String getGrammarFileName() { return "ALE.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ALEParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RRootContext extends ParserRuleContext {
		public List<RImportContext> rImport() {
			return getRuleContexts(RImportContext.class);
		}
		public RImportContext rImport(int i) {
			return getRuleContext(RImportContext.class,i);
		}
		public RServiceContext rService(int i) {
			return getRuleContext(RServiceContext.class,i);
		}
		public List<RServiceContext> rService() {
			return getRuleContexts(RServiceContext.class);
		}
		public RClassContext rClass(int i) {
			return getRuleContext(RClassContext.class,i);
		}
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public List<RClassContext> rClass() {
			return getRuleContexts(RClassContext.class);
		}
		public RRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RRootContext rRoot() throws RecognitionException {
		RRootContext _localctx = new RRootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rRoot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(T__40);
			setState(91); rQualified();
			setState(92); match(T__37);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(93); rImport();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__77) {
				{
				{
				setState(99); rService();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38 || _la==T__8) {
				{
				{
				setState(105); rClass();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RImportContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public RImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RImportContext rImport() throws RecognitionException {
		RImportContext _localctx = new RImportContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(T__0);
			setState(112); rQualified();
			setState(113); match(T__41);
			setState(114); match(Ident);
			setState(115); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RServiceContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public RServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rService; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RServiceContext rService() throws RecognitionException {
		RServiceContext _localctx = new RServiceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rService);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(T__77);
			setState(118); match(Ident);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(119); match(T__23);
				setState(120); match(Ident);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RClassContext extends ParserRuleContext {
		public ROpenClassContext rOpenClass() {
			return getRuleContext(ROpenClassContext.class,0);
		}
		public RNewClassContext rNewClass() {
			return getRuleContext(RNewClassContext.class,0);
		}
		public RClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RClassContext rClass() throws RecognitionException {
		RClassContext _localctx = new RClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rClass);
		try {
			setState(130);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); rOpenClass();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); rNewClass();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ROpenClassContext extends ParserRuleContext {
		public Token abstr;
		public RQualifiedContext name;
		public List<RMutableRefContext> rMutableRef() {
			return getRuleContexts(RMutableRefContext.class);
		}
		public RQualifiedContext rQualified(int i) {
			return getRuleContext(RQualifiedContext.class,i);
		}
		public ROperationContext rOperation(int i) {
			return getRuleContext(ROperationContext.class,i);
		}
		public List<ROperationContext> rOperation() {
			return getRuleContexts(ROperationContext.class);
		}
		public List<RAttributeContext> rAttribute() {
			return getRuleContexts(RAttributeContext.class);
		}
		public RMutableRefContext rMutableRef(int i) {
			return getRuleContext(RMutableRefContext.class,i);
		}
		public List<RQualifiedContext> rQualified() {
			return getRuleContexts(RQualifiedContext.class);
		}
		public RAttributeContext rAttribute(int i) {
			return getRuleContext(RAttributeContext.class,i);
		}
		public ROpenClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOpenClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROpenClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROpenClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROpenClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROpenClassContext rOpenClass() throws RecognitionException {
		ROpenClassContext _localctx = new ROpenClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rOpenClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(T__8);
			setState(134);
			_la = _input.LA(1);
			if (_la==T__56) {
				{
				setState(133); ((ROpenClassContext)_localctx).abstr = match(T__56);
				}
			}

			setState(136); match(T__38);
			setState(137); ((ROpenClassContext)_localctx).name = rQualified();
			setState(147);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(138); match(T__33);
				setState(139); rQualified();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__60) {
					{
					{
					setState(140); match(T__60);
					setState(141); rQualified();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(149); match(T__73);
			setState(159);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(150); match(T__5);
				setState(151); match(T__18);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Ident) {
					{
					{
					setState(152); rMutableRef();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158); match(T__49);
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__55) | (1L << T__52) | (1L << T__36) | (1L << T__27) | (1L << T__22))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__11 - 70)) | (1L << (Integer - 70)) | (1L << (Ident - 70)))) != 0)) {
				{
				{
				setState(161); rAttribute();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__47) | (1L << T__42))) != 0)) {
				{
				{
				setState(167); rOperation();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173); match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RMutableRefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RMutableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rMutableRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRMutableRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRMutableRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRMutableRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RMutableRefContext rMutableRef() throws RecognitionException {
		RMutableRefContext _localctx = new RMutableRefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rMutableRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RNewClassContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ROperationContext rOperation(int i) {
			return getRuleContext(ROperationContext.class,i);
		}
		public List<ROperationContext> rOperation() {
			return getRuleContexts(ROperationContext.class);
		}
		public List<RAttributeContext> rAttribute() {
			return getRuleContexts(RAttributeContext.class);
		}
		public RAttributeContext rAttribute(int i) {
			return getRuleContext(RAttributeContext.class,i);
		}
		public RNewClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rNewClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRNewClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RNewClassContext rNewClass() throws RecognitionException {
		RNewClassContext _localctx = new RNewClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rNewClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(T__38);
			setState(178); ((RNewClassContext)_localctx).name = match(Ident);
			setState(179); match(T__73);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__55) | (1L << T__52) | (1L << T__36) | (1L << T__27) | (1L << T__22))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__11 - 70)) | (1L << (Integer - 70)) | (1L << (Ident - 70)))) != 0)) {
				{
				{
				setState(180); rAttribute();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__47) | (1L << T__42))) != 0)) {
				{
				{
				setState(186); rOperation();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192); match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ROperationContext extends ParserRuleContext {
		public RConcreteOperationContext rConcreteOperation() {
			return getRuleContext(RConcreteOperationContext.class,0);
		}
		public RAbstractOperationContext rAbstractOperation() {
			return getRuleContext(RAbstractOperationContext.class,0);
		}
		public ROperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROperationContext rOperation() throws RecognitionException {
		ROperationContext _localctx = new ROperationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rOperation);
		try {
			setState(196);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194); rConcreteOperation();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); rAbstractOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RConcreteOperationContext extends ParserRuleContext {
		public Token dispatch;
		public RTypeContext type;
		public Token name;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RParametersContext rParameters() {
			return getRuleContext(RParametersContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RTagContext rTag(int i) {
			return getRuleContext(RTagContext.class,i);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public List<RTagContext> rTag() {
			return getRuleContexts(RTagContext.class);
		}
		public RConcreteOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rConcreteOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRConcreteOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRConcreteOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRConcreteOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RConcreteOperationContext rConcreteOperation() throws RecognitionException {
		RConcreteOperationContext _localctx = new RConcreteOperationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rConcreteOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__47) {
				{
				{
				setState(198); rTag();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==T__65 || _la==T__42) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(206);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(205); ((RConcreteOperationContext)_localctx).dispatch = match(T__76);
				}
			}

			setState(208); ((RConcreteOperationContext)_localctx).type = rType();
			setState(209); ((RConcreteOperationContext)_localctx).name = match(Ident);
			setState(210); match(T__63);
			setState(212);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__36) | (1L << T__22))) != 0) || _la==Ident) {
				{
				setState(211); rParameters();
				}
			}

			setState(214); match(T__4);
			setState(215); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAbstractOperationContext extends ParserRuleContext {
		public RTypeContext type;
		public Token name;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RParametersContext rParameters() {
			return getRuleContext(RParametersContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RTagContext rTag(int i) {
			return getRuleContext(RTagContext.class,i);
		}
		public List<RTagContext> rTag() {
			return getRuleContexts(RTagContext.class);
		}
		public RAbstractOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAbstractOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRAbstractOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRAbstractOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRAbstractOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAbstractOperationContext rAbstractOperation() throws RecognitionException {
		RAbstractOperationContext _localctx = new RAbstractOperationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rAbstractOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__47) {
				{
				{
				setState(217); rTag();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223); match(T__42);
			setState(224); match(T__56);
			setState(225); ((RAbstractOperationContext)_localctx).type = rType();
			setState(226); ((RAbstractOperationContext)_localctx).name = match(Ident);
			setState(227); match(T__63);
			setState(229);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__36) | (1L << T__22))) != 0) || _la==Ident) {
				{
				setState(228); rParameters();
				}
			}

			setState(231); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RTagContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RTagContext rTag() throws RecognitionException {
		RTagContext _localctx = new RTagContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(T__47);
			setState(234); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RParametersContext extends ParserRuleContext {
		public RVariableContext rVariable(int i) {
			return getRuleContext(RVariableContext.class,i);
		}
		public List<RVariableContext> rVariable() {
			return getRuleContexts(RVariableContext.class);
		}
		public RParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RParametersContext rParameters() throws RecognitionException {
		RParametersContext _localctx = new RParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); rVariable();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__60) {
				{
				{
				setState(237); match(T__60);
				setState(238); rVariable();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RVariableContext extends ParserRuleContext {
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVariableContext rVariable() throws RecognitionException {
		RVariableContext _localctx = new RVariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); ((RVariableContext)_localctx).type = rType();
			setState(245); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAttributeContext extends ParserRuleContext {
		public Token modifier;
		public RCardinalityContext bounds;
		public ROppositeContext opposite;
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public ROppositeContext rOpposite() {
			return getRuleContext(ROppositeContext.class,0);
		}
		public RCardinalityContext rCardinality() {
			return getRuleContext(RCardinalityContext.class,0);
		}
		public RAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAttributeContext rAttribute() throws RecognitionException {
		RAttributeContext _localctx = new RAttributeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if (_la==T__55 || _la==T__11) {
				{
				setState(247);
				((RAttributeContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__55 || _la==T__11) ) {
					((RAttributeContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(251);
			_la = _input.LA(1);
			if (_la==Integer) {
				{
				setState(250); ((RAttributeContext)_localctx).bounds = rCardinality();
				}
			}

			setState(254);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(253); ((RAttributeContext)_localctx).opposite = rOpposite();
				}
			}

			setState(256); ((RAttributeContext)_localctx).type = rType();
			setState(257); match(Ident);
			setState(260);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(258); match(T__31);
				setState(259); rExpression();
				}
			}

			setState(262); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RCardinalityContext extends ParserRuleContext {
		public TerminalNode Integer(int i) {
			return getToken(ALEParser.Integer, i);
		}
		public List<TerminalNode> Integer() { return getTokens(ALEParser.Integer); }
		public TerminalNode MultOp() { return getToken(ALEParser.MultOp, 0); }
		public RCardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCardinalityContext rCardinality() throws RecognitionException {
		RCardinalityContext _localctx = new RCardinalityContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rCardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(Integer);
			setState(265); match(T__71);
			setState(266);
			_la = _input.LA(1);
			if ( !(_la==MultOp || _la==Integer) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ROppositeContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ROppositeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOpposite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROpposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROpposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROpposite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROppositeContext rOpposite() throws RecognitionException {
		ROppositeContext _localctx = new ROppositeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rOpposite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(T__27);
			setState(269); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RStatementContext extends ParserRuleContext {
		public RAssignContext rAssign() {
			return getRuleContext(RAssignContext.class,0);
		}
		public RWhileContext rWhile() {
			return getRuleContext(RWhileContext.class,0);
		}
		public RInsertContext rInsert() {
			return getRuleContext(RInsertContext.class,0);
		}
		public RIfContext rIf() {
			return getRuleContext(RIfContext.class,0);
		}
		public RExpressionStmtContext rExpressionStmt() {
			return getRuleContext(RExpressionStmtContext.class,0);
		}
		public RRemoveContext rRemove() {
			return getRuleContext(RRemoveContext.class,0);
		}
		public RVarDeclContext rVarDecl() {
			return getRuleContext(RVarDeclContext.class,0);
		}
		public RForEachContext rForEach() {
			return getRuleContext(RForEachContext.class,0);
		}
		public RStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RStatementContext rStatement() throws RecognitionException {
		RStatementContext _localctx = new RStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rStatement);
		try {
			setState(279);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); rVarDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272); rAssign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(273); rInsert();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(274); rRemove();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(275); rForEach();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(276); rWhile();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(277); rIf();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(278); rExpressionStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RVarDeclContext extends ParserRuleContext {
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVarDeclContext rVarDecl() throws RecognitionException {
		RVarDeclContext _localctx = new RVarDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); ((RVarDeclContext)_localctx).type = rType();
			setState(282); match(Ident);
			setState(285);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(283); match(T__31);
				setState(284); rExpression();
				}
			}

			setState(287); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAssignContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAssignContext rAssign() throws RecognitionException {
		RAssignContext _localctx = new RAssignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); expression(0);
			setState(290); match(T__31);
			setState(291); rExpression();
			setState(292); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RInsertContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RInsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rInsert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RInsertContext rInsert() throws RecognitionException {
		RInsertContext _localctx = new RInsertContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rInsert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); expression(0);
			setState(295); match(T__78);
			setState(296); rExpression();
			setState(297); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RRemoveContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RRemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rRemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RRemoveContext rRemove() throws RecognitionException {
		RRemoveContext _localctx = new RRemoveContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); expression(0);
			setState(300); match(T__61);
			setState(301); rExpression();
			setState(302); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RForEachContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RCollectionContext rCollection() {
			return getRuleContext(RCollectionContext.class,0);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public RForEachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rForEach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRForEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRForEach(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRForEach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RForEachContext rForEach() throws RecognitionException {
		RForEachContext _localctx = new RForEachContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304); match(T__68);
			setState(305); match(T__63);
			setState(306); match(Ident);
			setState(307); match(T__6);
			setState(308); rCollection();
			setState(309); match(T__4);
			setState(310); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RCollectionContext extends ParserRuleContext {
		public TerminalNode Integer(int i) {
			return getToken(ALEParser.Integer, i);
		}
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public List<TerminalNode> Integer() { return getTokens(ALEParser.Integer); }
		public RCollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCollection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCollectionContext rCollection() throws RecognitionException {
		RCollectionContext _localctx = new RCollectionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rCollection);
		try {
			setState(318);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(312); match(T__16);
				setState(313); match(Integer);
				setState(314); match(T__71);
				setState(315); match(Integer);
				setState(316); match(T__49);
				}
				break;
			case T__73:
			case T__67:
			case T__66:
			case T__63:
			case T__59:
			case T__58:
			case T__57:
			case T__52:
			case T__48:
			case T__45:
			case T__39:
			case T__36:
			case T__32:
			case T__25:
			case T__22:
			case T__19:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(317); rExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RBlockContext extends ParserRuleContext {
		public List<RStatementContext> rStatement() {
			return getRuleContexts(RStatementContext.class);
		}
		public RStatementContext rStatement(int i) {
			return getRuleContext(RStatementContext.class,i);
		}
		public RBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RBlockContext rBlock() throws RecognitionException {
		RBlockContext _localctx = new RBlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(T__73);
			setState(328);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__74) | (1L << T__73) | (1L << T__68) | (1L << T__67) | (1L << T__66) | (1L << T__63) | (1L << T__59) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__48) | (1L << T__45) | (1L << T__39) | (1L << T__36) | (1L << T__32) | (1L << T__25) | (1L << T__22) | (1L << T__19))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__2 - 79)) | (1L << (T__1 - 79)) | (1L << (Integer - 79)) | (1L << (Real - 79)) | (1L << (String - 79)) | (1L << (ErrorString - 79)) | (1L << (Ident - 79)))) != 0)) {
				{
				setState(321); rStatement();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__74) | (1L << T__73) | (1L << T__68) | (1L << T__67) | (1L << T__66) | (1L << T__63) | (1L << T__59) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__48) | (1L << T__45) | (1L << T__39) | (1L << T__36) | (1L << T__32) | (1L << T__25) | (1L << T__22) | (1L << T__19))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__2 - 79)) | (1L << (T__1 - 79)) | (1L << (Integer - 79)) | (1L << (Real - 79)) | (1L << (String - 79)) | (1L << (ErrorString - 79)) | (1L << (Ident - 79)))) != 0)) {
					{
					{
					setState(322); rStatement();
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(330); match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RIfContext extends ParserRuleContext {
		public RIfContext nestedIf;
		public RBlockContext rBlock(int i) {
			return getRuleContext(RBlockContext.class,i);
		}
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RIfContext rIf() {
			return getRuleContext(RIfContext.class,0);
		}
		public List<RBlockContext> rBlock() {
			return getRuleContexts(RBlockContext.class);
		}
		public RIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RIfContext rIf() throws RecognitionException {
		RIfContext _localctx = new RIfContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(T__32);
			setState(333); match(T__63);
			setState(334); rExpression();
			setState(335); match(T__4);
			setState(336); rBlock();
			setState(342);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(337); match(T__7);
				setState(340);
				switch (_input.LA(1)) {
				case T__73:
					{
					setState(338); rBlock();
					}
					break;
				case T__32:
					{
					setState(339); ((RIfContext)_localctx).nestedIf = rIf();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RWhileContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public RWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RWhileContext rWhile() throws RecognitionException {
		RWhileContext _localctx = new RWhileContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344); match(T__74);
			setState(345); match(T__63);
			setState(346); rExpression();
			setState(347); match(T__4);
			setState(348); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RExpressionStmtContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpressionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExpressionStmtContext rExpressionStmt() throws RecognitionException {
		RExpressionStmtContext _localctx = new RExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rExpressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); rExpression();
			setState(351); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RExpressionContext extends ParserRuleContext {
		public RSwitchContext rSwitch() {
			return getRuleContext(RSwitchContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExpressionContext rExpression() throws RecognitionException {
		RExpressionContext _localctx = new RExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rExpression);
		try {
			setState(355);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(353); rSwitch();
				}
				break;
			case T__73:
			case T__67:
			case T__66:
			case T__63:
			case T__59:
			case T__58:
			case T__57:
			case T__52:
			case T__48:
			case T__45:
			case T__39:
			case T__36:
			case T__32:
			case T__22:
			case T__19:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(354); expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RTypeContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public RTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RTypeContext rType() throws RecognitionException {
		RTypeContext _localctx = new RTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_rType);
		int _la;
		try {
			setState(366);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(357); typeLiteral();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(358); match(Ident);
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__72) {
					{
					{
					setState(359); match(T__72);
					setState(360); match(Ident);
					}
					}
					setState(365);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RQualifiedContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public RQualifiedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rQualified; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRQualified(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRQualified(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRQualified(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RQualifiedContext rQualified() throws RecognitionException {
		RQualifiedContext _localctx = new RQualifiedContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_rQualified);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); match(Ident);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(369); match(T__23);
				setState(370); match(Ident);
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RSwitchContext extends ParserRuleContext {
		public Token paramName;
		public RExpressionContext paramVal;
		public RCaseContext rCase;
		public List<RCaseContext> cases = new ArrayList<RCaseContext>();
		public RExpressionContext other;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RCaseContext rCase(int i) {
			return getRuleContext(RCaseContext.class,i);
		}
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public List<RCaseContext> rCase() {
			return getRuleContexts(RCaseContext.class);
		}
		public RSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRSwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RSwitchContext rSwitch() throws RecognitionException {
		RSwitchContext _localctx = new RSwitchContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_rSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376); match(T__25);
			setState(377); match(T__63);
			setState(380);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(378); ((RSwitchContext)_localctx).paramName = match(Ident);
				setState(379); match(T__17);
				}
				break;
			}
			setState(382); ((RSwitchContext)_localctx).paramVal = rExpression();
			setState(383); match(T__4);
			setState(384); match(T__73);
			setState(386); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(385); ((RSwitchContext)_localctx).rCase = rCase();
				((RSwitchContext)_localctx).cases.add(((RSwitchContext)_localctx).rCase);
				}
				}
				setState(388); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__36) | (1L << T__22) | (1L << T__20))) != 0) || _la==T__17 || _la==Ident );
			setState(390); match(T__79);
			setState(391); match(T__17);
			setState(392); ((RSwitchContext)_localctx).other = rExpression();
			setState(393); match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RCaseContext extends ParserRuleContext {
		public RTypeContext guard;
		public RExpressionContext match;
		public RExpressionContext value;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCaseContext rCase() throws RecognitionException {
		RCaseContext _localctx = new RCaseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_rCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__36) | (1L << T__22))) != 0) || _la==Ident) {
				{
				setState(395); ((RCaseContext)_localctx).guard = rType();
				}
			}

			setState(400);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(398); match(T__20);
				setState(399); ((RCaseContext)_localctx).match = rExpression();
				}
			}

			setState(402); match(T__17);
			setState(403); ((RCaseContext)_localctx).value = rExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarRefContext extends ExpressionContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public VarRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NavContext extends ExpressionContext {
		public NavigationSegmentContext navigationSegment() {
			return getRuleContext(NavigationSegmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NavContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNav(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNav(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNav(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetExprContext extends ExpressionContext {
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public LetExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLetExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompContext extends ExpressionContext {
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitMin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitMin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ImpliesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MultOp() { return getToken(ALEParser.MultOp, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XorContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public XorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitXor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(406); match(T__2);
				setState(407); expression(14);
				}
				break;

			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408); match(T__1);
				setState(409); expression(13);
				}
				break;

			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410); match(T__45);
				setState(411); binding();
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__60) {
					{
					{
					setState(412); match(T__60);
					setState(413); binding();
					}
					}
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(419); match(T__6);
				setState(420); expression(1);
				}
				break;

			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(422); match(Ident);
				}
				break;

			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(423); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(424); match(T__63);
				setState(425); expression(0);
				setState(426); match(T__4);
				}
				break;

			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(428); match(T__32);
				setState(429); expression(0);
				setState(430); match(T__43);
				setState(431); expression(0);
				setState(432); match(T__7);
				setState(433); expression(0);
				setState(434); match(T__80);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(463);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(438);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(439); match(MultOp);
						setState(440); expression(13);
						}
						break;

					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(441);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(442); addOp();
						setState(443); expression(12);
						}
						break;

					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(445);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(446); compOp();
						setState(447); expression(11);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(449);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(450); match(T__3);
						setState(451); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(453); match(T__9);
						setState(454); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(455);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(456); match(T__10);
						setState(457); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(458);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(459); match(T__64);
						setState(460); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(462); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BindingContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468); match(Ident);
			setState(471);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(469); match(T__17);
				setState(470); typeLiteral();
				}
			}

			setState(473); match(T__69);
			setState(474); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_la = _input.LA(1);
			if ( !(_la==T__44 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_la = _input.LA(1);
			if ( !(((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (T__75 - 6)) | (1L << (T__69 - 6)) | (1L << (T__53 - 6)) | (1L << (T__51 - 6)) | (1L << (T__46 - 6)) | (1L << (T__30 - 6)) | (1L << (T__14 - 6)) | (1L << (T__12 - 6)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NavigationSegmentContext extends ParserRuleContext {
		public NavigationSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_navigationSegment; }
	 
		public NavigationSegmentContext() { }
		public void copyFrom(NavigationSegmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallOrApplyContext extends NavigationSegmentContext {
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public CallOrApplyContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCallOrApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCallOrApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCallOrApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CollectionCallContext extends NavigationSegmentContext {
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public CollectionCallContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCollectionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCollectionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCollectionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureContext extends NavigationSegmentContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public FeatureContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NavigationSegmentContext navigationSegment() throws RecognitionException {
		NavigationSegmentContext _localctx = new NavigationSegmentContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_navigationSegment);
		try {
			setState(486);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(480); match(T__23);
				setState(481); match(Ident);
				}
				break;

			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(482); match(T__23);
				setState(483); callExp();
				}
				break;

			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(484); match(T__21);
				setState(485); callExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallExpContext extends ParserRuleContext {
		public CallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExp; }
	 
		public CallExpContext() { }
		public void copyFrom(CallExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ServiceCallContext extends CallExpContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ServiceCallContext(CallExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterServiceCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitServiceCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitServiceCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterationCallContext extends CallExpContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public CollectionIteratorContext collectionIterator() {
			return getRuleContext(CollectionIteratorContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public IterationCallContext(CallExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIterationCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIterationCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIterationCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExpContext callExp() throws RecognitionException {
		CallExpContext _localctx = new CallExpContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_callExp);
		try {
			setState(499);
			switch (_input.LA(1)) {
			case T__70:
			case T__62:
			case T__54:
			case T__50:
			case T__35:
			case T__29:
			case T__28:
			case T__26:
			case T__24:
			case T__13:
				_localctx = new IterationCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(488); collectionIterator();
				setState(489); match(T__63);
				setState(490); variableDefinition();
				setState(491); lambdaExpression();
				setState(492); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(494); match(Ident);
				setState(495); match(T__63);
				setState(496); expressionSequence();
				setState(497); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionIteratorContext extends ParserRuleContext {
		public CollectionIteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionIterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCollectionIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCollectionIterator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCollectionIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionIteratorContext collectionIterator() throws RecognitionException {
		CollectionIteratorContext _localctx = new CollectionIteratorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !(((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__70 - 11)) | (1L << (T__62 - 11)) | (1L << (T__54 - 11)) | (1L << (T__50 - 11)) | (1L << (T__35 - 11)) | (1L << (T__29 - 11)) | (1L << (T__28 - 11)) | (1L << (T__26 - 11)) | (1L << (T__24 - 11)) | (1L << (T__13 - 11)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExpressionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__73) | (1L << T__67) | (1L << T__66) | (1L << T__63) | (1L << T__59) | (1L << T__58) | (1L << T__57) | (1L << T__52) | (1L << T__48) | (1L << T__45) | (1L << T__39) | (1L << T__36) | (1L << T__32) | (1L << T__22) | (1L << T__19))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__2 - 79)) | (1L << (T__1 - 79)) | (1L << (Integer - 79)) | (1L << (Real - 79)) | (1L << (String - 79)) | (1L << (ErrorString - 79)) | (1L << (Ident - 79)))) != 0)) {
				{
				setState(505); expression(0);
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__60) {
					{
					{
					setState(506); match(T__60);
					setState(507); expression(0);
					}
					}
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515); match(Ident);
			setState(518);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(516); match(T__17);
				setState(517); typeLiteral();
				}
			}

			setState(520); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EnumLitContext extends LiteralContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public EnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitEnumLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitEnumLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLitContext extends LiteralContext {
		public NullLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNullLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNullLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNullLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeLitContext extends LiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TypeLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterTypeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitTypeLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitTypeLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLitContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(ALEParser.Integer, 0); }
		public IntegerLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIntegerLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIntegerLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIntegerLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealLitContext extends LiteralContext {
		public TerminalNode Real() { return getToken(ALEParser.Real, 0); }
		public RealLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRealLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRealLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRealLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorEnumLitContext extends LiteralContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public ErrorEnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorEnumLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorEnumLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseLitContext extends LiteralContext {
		public FalseLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterFalseLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitFalseLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitFalseLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueLitContext extends LiteralContext {
		public TrueLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterTrueLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitTrueLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitTrueLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitSetLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSetLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExplicitSetLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExplicitSetLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExplicitSetLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitSeqLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSeqLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExplicitSeqLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExplicitSeqLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExplicitSeqLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorStringLitContext extends LiteralContext {
		public TerminalNode ErrorString() { return getToken(ALEParser.ErrorString, 0); }
		public ErrorStringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorStringLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorStringLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLitContext extends LiteralContext {
		public TerminalNode String() { return getToken(ALEParser.String, 0); }
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitStringLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_literal);
		try {
			setState(547);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(522); match(String);
				}
				break;

			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(523); match(ErrorString);
				}
				break;

			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(524); match(Integer);
				}
				break;

			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(525); match(Real);
				}
				break;

			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(526); match(T__39);
				}
				break;

			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(527); match(T__59);
				}
				break;

			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(528); match(T__66);
				}
				break;

			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(529); match(T__48);
				setState(530); expressionSequence();
				setState(531); match(T__34);
				}
				break;

			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(533); match(T__19);
				setState(534); expressionSequence();
				setState(535); match(T__34);
				}
				break;

			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(537); match(Ident);
				setState(538); match(T__72);
				setState(539); match(Ident);
				setState(540); match(T__72);
				setState(541); match(Ident);
				}
				break;

			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(542); match(Ident);
				setState(543); match(T__72);
				setState(544); match(Ident);
				setState(545); match(T__17);
				}
				break;

			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(546); typeLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeLiteralContext extends ParserRuleContext {
		public TypeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLiteral; }
	 
		public TypeLiteralContext() { }
		public void copyFrom(TypeLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassifierSetTypeContext extends TypeLiteralContext {
		public List<ClassifierTypeRuleContext> classifierTypeRule() {
			return getRuleContexts(ClassifierTypeRuleContext.class);
		}
		public ClassifierTypeRuleContext classifierTypeRule(int i) {
			return getRuleContext(ClassifierTypeRuleContext.class,i);
		}
		public ClassifierSetTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClassifierSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClassifierSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClassifierSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SetTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SeqTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterSeqType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitSeqType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitSeqType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTypeContext extends TypeLiteralContext {
		public BooleanTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealTypeContext extends TypeLiteralContext {
		public RealTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRealType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRealType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClsTypeContext extends TypeLiteralContext {
		public ClassifierTypeRuleContext classifierTypeRule() {
			return getRuleContext(ClassifierTypeRuleContext.class,0);
		}
		public ClsTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClsType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClsType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClsType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrTypeContext extends TypeLiteralContext {
		public StrTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterStrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitStrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitStrType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeLiteralContext {
		public IntTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeLiteral);
		int _la;
		try {
			setState(573);
			switch (_input.LA(1)) {
			case T__52:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(549); match(T__52);
				}
				break;
			case T__36:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(550); match(T__36);
				}
				break;
			case T__57:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(551); match(T__57);
				}
				break;
			case T__22:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(552); match(T__22);
				}
				break;
			case T__58:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(553); match(T__58);
				setState(554); typeLiteral();
				setState(555); match(T__4);
				}
				break;
			case T__67:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(557); match(T__67);
				setState(558); typeLiteral();
				setState(559); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(561); classifierTypeRule();
				}
				break;
			case T__73:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(562); match(T__73);
				setState(563); classifierTypeRule();
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(564); match(T__15);
					setState(565); classifierTypeRule();
					}
					}
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(571); match(T__34);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassifierTypeRuleContext extends ParserRuleContext {
		public ClassifierTypeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classifierTypeRule; }
	 
		public ClassifierTypeRuleContext() { }
		public void copyFrom(ClassifierTypeRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassifierTypeContext extends ClassifierTypeRuleContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public ClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClassifierType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClassifierType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorClassifierTypeContext extends ClassifierTypeRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ErrorClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorClassifierType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorClassifierType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassifierTypeRuleContext classifierTypeRule() throws RecognitionException {
		ClassifierTypeRuleContext _localctx = new ClassifierTypeRuleContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_classifierTypeRule);
		try {
			setState(580);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(575); match(Ident);
				setState(576); match(T__72);
				setState(577); match(Ident);
				}
				break;

			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(578); match(Ident);
				setState(579); match(T__17);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);

		case 1: return precpred(_ctx, 11);

		case 2: return precpred(_ctx, 10);

		case 3: return precpred(_ctx, 9);

		case 4: return precpred(_ctx, 8);

		case 5: return precpred(_ctx, 7);

		case 6: return precpred(_ctx, 6);

		case 7: return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3]\u0249\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\2\7\2g\n\2"+
		"\f\2\16\2j\13\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\7\4|\n\4\f\4\16\4\177\13\4\3\4\3\4\3\5\3\5\5\5\u0085\n"+
		"\5\3\6\3\6\5\6\u0089\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0091\n\6\f\6\16"+
		"\6\u0094\13\6\5\6\u0096\n\6\3\6\3\6\3\6\3\6\7\6\u009c\n\6\f\6\16\6\u009f"+
		"\13\6\3\6\5\6\u00a2\n\6\3\6\7\6\u00a5\n\6\f\6\16\6\u00a8\13\6\3\6\7\6"+
		"\u00ab\n\6\f\6\16\6\u00ae\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00b8"+
		"\n\b\f\b\16\b\u00bb\13\b\3\b\7\b\u00be\n\b\f\b\16\b\u00c1\13\b\3\b\3\b"+
		"\3\t\3\t\5\t\u00c7\n\t\3\n\7\n\u00ca\n\n\f\n\16\n\u00cd\13\n\3\n\3\n\5"+
		"\n\u00d1\n\n\3\n\3\n\3\n\3\n\5\n\u00d7\n\n\3\n\3\n\3\n\3\13\7\13\u00dd"+
		"\n\13\f\13\16\13\u00e0\13\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e8"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00f2\n\r\f\r\16\r\u00f5\13"+
		"\r\3\16\3\16\3\16\3\17\5\17\u00fb\n\17\3\17\5\17\u00fe\n\17\3\17\5\17"+
		"\u0101\n\17\3\17\3\17\3\17\3\17\5\17\u0107\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011a"+
		"\n\22\3\23\3\23\3\23\3\23\5\23\u0120\n\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0141\n\30"+
		"\3\31\3\31\3\31\7\31\u0146\n\31\f\31\16\31\u0149\13\31\5\31\u014b\n\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0157\n\32\5\32"+
		"\u0159\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\5\35"+
		"\u0166\n\35\3\36\3\36\3\36\3\36\7\36\u016c\n\36\f\36\16\36\u016f\13\36"+
		"\5\36\u0171\n\36\3\37\3\37\3\37\7\37\u0176\n\37\f\37\16\37\u0179\13\37"+
		"\3 \3 \3 \3 \5 \u017f\n \3 \3 \3 \3 \6 \u0185\n \r \16 \u0186\3 \3 \3"+
		" \3 \3 \3!\5!\u018f\n!\3!\3!\5!\u0193\n!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\7\"\u01a1\n\"\f\"\16\"\u01a4\13\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01b7\n\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\7\"\u01d2\n\"\f\"\16\"\u01d5\13\"\3#\3#\3#\5#\u01da"+
		"\n#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\5&\u01e9\n&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01f6\n\'\3(\3(\3)\3)\3*\3*\3*\7*\u01ff"+
		"\n*\f*\16*\u0202\13*\5*\u0204\n*\3+\3+\3+\5+\u0209\n+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0226"+
		"\n,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0239\n-\f-"+
		"\16-\u023c\13-\3-\3-\5-\u0240\n-\3.\3.\3.\3.\3.\5.\u0247\n.\3.\2\3B/\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\2\b\4\2\22\22))\4\2\34\34HH\3\2XY\4\2\'\'RR\n\2\b\b\16\16\36\36"+
		"  %%\65\65EEGG\13\2\r\r\25\25\35\35!!\60\60\66\6799;;FF\u0273\2\\\3\2"+
		"\2\2\4q\3\2\2\2\6w\3\2\2\2\b\u0084\3\2\2\2\n\u0086\3\2\2\2\f\u00b1\3\2"+
		"\2\2\16\u00b3\3\2\2\2\20\u00c6\3\2\2\2\22\u00cb\3\2\2\2\24\u00de\3\2\2"+
		"\2\26\u00eb\3\2\2\2\30\u00ee\3\2\2\2\32\u00f6\3\2\2\2\34\u00fa\3\2\2\2"+
		"\36\u010a\3\2\2\2 \u010e\3\2\2\2\"\u0119\3\2\2\2$\u011b\3\2\2\2&\u0123"+
		"\3\2\2\2(\u0128\3\2\2\2*\u012d\3\2\2\2,\u0132\3\2\2\2.\u0140\3\2\2\2\60"+
		"\u0142\3\2\2\2\62\u014e\3\2\2\2\64\u015a\3\2\2\2\66\u0160\3\2\2\28\u0165"+
		"\3\2\2\2:\u0170\3\2\2\2<\u0172\3\2\2\2>\u017a\3\2\2\2@\u018e\3\2\2\2B"+
		"\u01b6\3\2\2\2D\u01d6\3\2\2\2F\u01de\3\2\2\2H\u01e0\3\2\2\2J\u01e8\3\2"+
		"\2\2L\u01f5\3\2\2\2N\u01f7\3\2\2\2P\u01f9\3\2\2\2R\u0203\3\2\2\2T\u0205"+
		"\3\2\2\2V\u0225\3\2\2\2X\u023f\3\2\2\2Z\u0246\3\2\2\2\\]\7+\2\2]^\5<\37"+
		"\2^b\7.\2\2_a\5\4\3\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ch\3\2\2"+
		"\2db\3\2\2\2eg\5\6\4\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2in\3\2\2"+
		"\2jh\3\2\2\2km\5\b\5\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\3\3\2"+
		"\2\2pn\3\2\2\2qr\7S\2\2rs\5<\37\2st\7*\2\2tu\7]\2\2uv\7.\2\2v\5\3\2\2"+
		"\2wx\7\6\2\2x}\7]\2\2yz\7<\2\2z|\7]\2\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2"+
		"\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7.\2\2\u0081\7\3"+
		"\2\2\2\u0082\u0085\5\n\6\2\u0083\u0085\5\16\b\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0083\3\2\2\2\u0085\t\3\2\2\2\u0086\u0088\7K\2\2\u0087\u0089\7\33\2\2"+
		"\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b"+
		"\7-\2\2\u008b\u0095\5<\37\2\u008c\u008d\7\62\2\2\u008d\u0092\5<\37\2\u008e"+
		"\u008f\7\27\2\2\u008f\u0091\5<\37\2\u0090\u008e\3\2\2\2\u0091\u0094\3"+
		"\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u00a1\7\n\2\2\u0098\u0099\7N\2\2\u0099\u009d\7A\2\2\u009a\u009c"+
		"\5\f\7\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7\""+
		"\2\2\u00a1\u0098\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a6\3\2\2\2\u00a3"+
		"\u00a5\5\34\17\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ac\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00ab\5\20\t\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b0\7\61\2\2\u00b0\13\3\2\2\2\u00b1\u00b2\7]\2\2\u00b2\r\3\2\2\2\u00b3"+
		"\u00b4\7-\2\2\u00b4\u00b5\7]\2\2\u00b5\u00b9\7\n\2\2\u00b6\u00b8\5\34"+
		"\17\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bf\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\5\20"+
		"\t\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\61"+
		"\2\2\u00c3\17\3\2\2\2\u00c4\u00c7\5\22\n\2\u00c5\u00c7\5\24\13\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\21\3\2\2\2\u00c8\u00ca\5\26\f"+
		"\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\t\2\2\2\u00cf"+
		"\u00d1\7\7\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\5:\36\2\u00d3\u00d4\7]\2\2\u00d4\u00d6\7\24\2\2\u00d5"+
		"\u00d7\5\30\r\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3"+
		"\2\2\2\u00d8\u00d9\7O\2\2\u00d9\u00da\5\60\31\2\u00da\23\3\2\2\2\u00db"+
		"\u00dd\5\26\f\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3"+
		"\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e2\7)\2\2\u00e2\u00e3\7\33\2\2\u00e3\u00e4\5:\36\2\u00e4\u00e5\7]"+
		"\2\2\u00e5\u00e7\7\24\2\2\u00e6\u00e8\5\30\r\2\u00e7\u00e6\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7O\2\2\u00ea\25\3\2\2\2"+
		"\u00eb\u00ec\7$\2\2\u00ec\u00ed\7]\2\2\u00ed\27\3\2\2\2\u00ee\u00f3\5"+
		"\32\16\2\u00ef\u00f0\7\27\2\2\u00f0\u00f2\5\32\16\2\u00f1\u00ef\3\2\2"+
		"\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\31"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\5:\36\2\u00f7\u00f8\7]\2\2\u00f8"+
		"\33\3\2\2\2\u00f9\u00fb\t\3\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2"+
		"\2\u00fb\u00fd\3\2\2\2\u00fc\u00fe\5\36\20\2\u00fd\u00fc\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u0101\5 \21\2\u0100\u00ff\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\5:\36\2\u0103"+
		"\u0106\7]\2\2\u0104\u0105\7\64\2\2\u0105\u0107\58\35\2\u0106\u0104\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7.\2\2\u0109"+
		"\35\3\2\2\2\u010a\u010b\7Y\2\2\u010b\u010c\7\f\2\2\u010c\u010d\t\4\2\2"+
		"\u010d\37\3\2\2\2\u010e\u010f\78\2\2\u010f\u0110\7]\2\2\u0110!\3\2\2\2"+
		"\u0111\u011a\5$\23\2\u0112\u011a\5&\24\2\u0113\u011a\5(\25\2\u0114\u011a"+
		"\5*\26\2\u0115\u011a\5,\27\2\u0116\u011a\5\64\33\2\u0117\u011a\5\62\32"+
		"\2\u0118\u011a\5\66\34\2\u0119\u0111\3\2\2\2\u0119\u0112\3\2\2\2\u0119"+
		"\u0113\3\2\2\2\u0119\u0114\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2"+
		"\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a#\3\2\2\2\u011b\u011c"+
		"\5:\36\2\u011c\u011f\7]\2\2\u011d\u011e\7\64\2\2\u011e\u0120\58\35\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7."+
		"\2\2\u0122%\3\2\2\2\u0123\u0124\5B\"\2\u0124\u0125\7\64\2\2\u0125\u0126"+
		"\58\35\2\u0126\u0127\7.\2\2\u0127\'\3\2\2\2\u0128\u0129\5B\"\2\u0129\u012a"+
		"\7\5\2\2\u012a\u012b\58\35\2\u012b\u012c\7.\2\2\u012c)\3\2\2\2\u012d\u012e"+
		"\5B\"\2\u012e\u012f\7\26\2\2\u012f\u0130\58\35\2\u0130\u0131\7.\2\2\u0131"+
		"+\3\2\2\2\u0132\u0133\7\17\2\2\u0133\u0134\7\24\2\2\u0134\u0135\7]\2\2"+
		"\u0135\u0136\7M\2\2\u0136\u0137\5.\30\2\u0137\u0138\7O\2\2\u0138\u0139"+
		"\5\60\31\2\u0139-\3\2\2\2\u013a\u013b\7C\2\2\u013b\u013c\7Y\2\2\u013c"+
		"\u013d\7\f\2\2\u013d\u013e\7Y\2\2\u013e\u0141\7\"\2\2\u013f\u0141\58\35"+
		"\2\u0140\u013a\3\2\2\2\u0140\u013f\3\2\2\2\u0141/\3\2\2\2\u0142\u014a"+
		"\7\n\2\2\u0143\u0147\5\"\22\2\u0144\u0146\5\"\22\2\u0145\u0144\3\2\2\2"+
		"\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014b"+
		"\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u0143\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\7\61\2\2\u014d\61\3\2\2\2\u014e\u014f\7\63"+
		"\2\2\u014f\u0150\7\24\2\2\u0150\u0151\58\35\2\u0151\u0152\7O\2\2\u0152"+
		"\u0158\5\60\31\2\u0153\u0156\7L\2\2\u0154\u0157\5\60\31\2\u0155\u0157"+
		"\5\62\32\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u0159\3\2\2\2"+
		"\u0158\u0153\3\2\2\2\u0158\u0159\3\2\2\2\u0159\63\3\2\2\2\u015a\u015b"+
		"\7\t\2\2\u015b\u015c\7\24\2\2\u015c\u015d\58\35\2\u015d\u015e\7O\2\2\u015e"+
		"\u015f\5\60\31\2\u015f\65\3\2\2\2\u0160\u0161\58\35\2\u0161\u0162\7.\2"+
		"\2\u0162\67\3\2\2\2\u0163\u0166\5> \2\u0164\u0166\5B\"\2\u0165\u0163\3"+
		"\2\2\2\u0165\u0164\3\2\2\2\u01669\3\2\2\2\u0167\u0171\5X-\2\u0168\u016d"+
		"\7]\2\2\u0169\u016a\7\13\2\2\u016a\u016c\7]\2\2\u016b\u0169\3\2\2\2\u016c"+
		"\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0171\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u0170\u0167\3\2\2\2\u0170\u0168\3\2\2\2\u0171"+
		";\3\2\2\2\u0172\u0177\7]\2\2\u0173\u0174\7<\2\2\u0174\u0176\7]\2\2\u0175"+
		"\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178=\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7:\2\2\u017b\u017e"+
		"\7\24\2\2\u017c\u017d\7]\2\2\u017d\u017f\7B\2\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\58\35\2\u0181\u0182\7O"+
		"\2\2\u0182\u0184\7\n\2\2\u0183\u0185\5@!\2\u0184\u0183\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u0189\7\4\2\2\u0189\u018a\7B\2\2\u018a\u018b\58\35\2\u018b\u018c\7\61"+
		"\2\2\u018c?\3\2\2\2\u018d\u018f\5:\36\2\u018e\u018d\3\2\2\2\u018e\u018f"+
		"\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u0191\7?\2\2\u0191\u0193\58\35\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\7B"+
		"\2\2\u0195\u0196\58\35\2\u0196A\3\2\2\2\u0197\u0198\b\"\1\2\u0198\u0199"+
		"\7Q\2\2\u0199\u01b7\5B\"\20\u019a\u019b\7R\2\2\u019b\u01b7\5B\"\17\u019c"+
		"\u019d\7&\2\2\u019d\u01a2\5D#\2\u019e\u019f\7\27\2\2\u019f\u01a1\5D#\2"+
		"\u01a0\u019e\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7M\2\2\u01a6"+
		"\u01a7\5B\"\3\u01a7\u01b7\3\2\2\2\u01a8\u01b7\7]\2\2\u01a9\u01b7\5V,\2"+
		"\u01aa\u01ab\7\24\2\2\u01ab\u01ac\5B\"\2\u01ac\u01ad\7O\2\2\u01ad\u01b7"+
		"\3\2\2\2\u01ae\u01af\7\63\2\2\u01af\u01b0\5B\"\2\u01b0\u01b1\7(\2\2\u01b1"+
		"\u01b2\5B\"\2\u01b2\u01b3\7L\2\2\u01b3\u01b4\5B\"\2\u01b4\u01b5\7\3\2"+
		"\2\u01b5\u01b7\3\2\2\2\u01b6\u0197\3\2\2\2\u01b6\u019a\3\2\2\2\u01b6\u019c"+
		"\3\2\2\2\u01b6\u01a8\3\2\2\2\u01b6\u01a9\3\2\2\2\u01b6\u01aa\3\2\2\2\u01b6"+
		"\u01ae\3\2\2\2\u01b7\u01d3\3\2\2\2\u01b8\u01b9\f\16\2\2\u01b9\u01ba\7"+
		"X\2\2\u01ba\u01d2\5B\"\17\u01bb\u01bc\f\r\2\2\u01bc\u01bd\5F$\2\u01bd"+
		"\u01be\5B\"\16\u01be\u01d2\3\2\2\2\u01bf\u01c0\f\f\2\2\u01c0\u01c1\5H"+
		"%\2\u01c1\u01c2\5B\"\r\u01c2\u01d2\3\2\2\2\u01c3\u01c4\f\13\2\2\u01c4"+
		"\u01c5\7P\2\2\u01c5\u01d2\5B\"\f\u01c6\u01c7\f\n\2\2\u01c7\u01c8\7J\2"+
		"\2\u01c8\u01d2\5B\"\13\u01c9\u01ca\f\t\2\2\u01ca\u01cb\7I\2\2\u01cb\u01d2"+
		"\5B\"\n\u01cc\u01cd\f\b\2\2\u01cd\u01ce\7\23\2\2\u01ce\u01d2\5B\"\t\u01cf"+
		"\u01d0\f\21\2\2\u01d0\u01d2\5J&\2\u01d1\u01b8\3\2\2\2\u01d1\u01bb\3\2"+
		"\2\2\u01d1\u01bf\3\2\2\2\u01d1\u01c3\3\2\2\2\u01d1\u01c6\3\2\2\2\u01d1"+
		"\u01c9\3\2\2\2\u01d1\u01cc\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2"+
		"\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4C\3\2\2\2\u01d5\u01d3"+
		"\3\2\2\2\u01d6\u01d9\7]\2\2\u01d7\u01d8\7B\2\2\u01d8\u01da\5X-\2\u01d9"+
		"\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\7\16"+
		"\2\2\u01dc\u01dd\5B\"\2\u01ddE\3\2\2\2\u01de\u01df\t\5\2\2\u01dfG\3\2"+
		"\2\2\u01e0\u01e1\t\6\2\2\u01e1I\3\2\2\2\u01e2\u01e3\7<\2\2\u01e3\u01e9"+
		"\7]\2\2\u01e4\u01e5\7<\2\2\u01e5\u01e9\5L\'\2\u01e6\u01e7\7>\2\2\u01e7"+
		"\u01e9\5L\'\2\u01e8\u01e2\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e8\u01e6\3\2"+
		"\2\2\u01e9K\3\2\2\2\u01ea\u01eb\5P)\2\u01eb\u01ec\7\24\2\2\u01ec\u01ed"+
		"\5T+\2\u01ed\u01ee\5N(\2\u01ee\u01ef\7O\2\2\u01ef\u01f6\3\2\2\2\u01f0"+
		"\u01f1\7]\2\2\u01f1\u01f2\7\24\2\2\u01f2\u01f3\5R*\2\u01f3\u01f4\7O\2"+
		"\2\u01f4\u01f6\3\2\2\2\u01f5\u01ea\3\2\2\2\u01f5\u01f0\3\2\2\2\u01f6M"+
		"\3\2\2\2\u01f7\u01f8\5B\"\2\u01f8O\3\2\2\2\u01f9\u01fa\t\7\2\2\u01faQ"+
		"\3\2\2\2\u01fb\u0200\5B\"\2\u01fc\u01fd\7\27\2\2\u01fd\u01ff\5B\"\2\u01fe"+
		"\u01fc\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u01fb\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204S\3\2\2\2\u0205\u0208\7]\2\2\u0206\u0207\7B\2\2\u0207"+
		"\u0209\5X-\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\3\2\2"+
		"\2\u020a\u020b\7D\2\2\u020bU\3\2\2\2\u020c\u0226\7[\2\2\u020d\u0226\7"+
		"\\\2\2\u020e\u0226\7Y\2\2\u020f\u0226\7Z\2\2\u0210\u0226\7,\2\2\u0211"+
		"\u0226\7\30\2\2\u0212\u0226\7\21\2\2\u0213\u0214\7#\2\2\u0214\u0215\5"+
		"R*\2\u0215\u0216\7\61\2\2\u0216\u0226\3\2\2\2\u0217\u0218\7@\2\2\u0218"+
		"\u0219\5R*\2\u0219\u021a\7\61\2\2\u021a\u0226\3\2\2\2\u021b\u021c\7]\2"+
		"\2\u021c\u021d\7\13\2\2\u021d\u021e\7]\2\2\u021e\u021f\7\13\2\2\u021f"+
		"\u0226\7]\2\2\u0220\u0221\7]\2\2\u0221\u0222\7\13\2\2\u0222\u0223\7]\2"+
		"\2\u0223\u0226\7B\2\2\u0224\u0226\5X-\2\u0225\u020c\3\2\2\2\u0225\u020d"+
		"\3\2\2\2\u0225\u020e\3\2\2\2\u0225\u020f\3\2\2\2\u0225\u0210\3\2\2\2\u0225"+
		"\u0211\3\2\2\2\u0225\u0212\3\2\2\2\u0225\u0213\3\2\2\2\u0225\u0217\3\2"+
		"\2\2\u0225\u021b\3\2\2\2\u0225\u0220\3\2\2\2\u0225\u0224\3\2\2\2\u0226"+
		"W\3\2\2\2\u0227\u0240\7\37\2\2\u0228\u0240\7/\2\2\u0229\u0240\7\32\2\2"+
		"\u022a\u0240\7=\2\2\u022b\u022c\7\31\2\2\u022c\u022d\5X-\2\u022d\u022e"+
		"\7O\2\2\u022e\u0240\3\2\2\2\u022f\u0230\7\20\2\2\u0230\u0231\5X-\2\u0231"+
		"\u0232\7O\2\2\u0232\u0240\3\2\2\2\u0233\u0240\5Z.\2\u0234\u0235\7\n\2"+
		"\2\u0235\u023a\5Z.\2\u0236\u0237\7D\2\2\u0237\u0239\5Z.\2\u0238\u0236"+
		"\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b"+
		"\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023e\7\61\2\2\u023e\u0240\3"+
		"\2\2\2\u023f\u0227\3\2\2\2\u023f\u0228\3\2\2\2\u023f\u0229\3\2\2\2\u023f"+
		"\u022a\3\2\2\2\u023f\u022b\3\2\2\2\u023f\u022f\3\2\2\2\u023f\u0233\3\2"+
		"\2\2\u023f\u0234\3\2\2\2\u0240Y\3\2\2\2\u0241\u0242\7]\2\2\u0242\u0243"+
		"\7\13\2\2\u0243\u0247\7]\2\2\u0244\u0245\7]\2\2\u0245\u0247\7B\2\2\u0246"+
		"\u0241\3\2\2\2\u0246\u0244\3\2\2\2\u0247[\3\2\2\28bhn}\u0084\u0088\u0092"+
		"\u0095\u009d\u00a1\u00a6\u00ac\u00b9\u00bf\u00c6\u00cb\u00d0\u00d6\u00de"+
		"\u00e7\u00f3\u00fa\u00fd\u0100\u0106\u0119\u011f\u0140\u0147\u014a\u0156"+
		"\u0158\u0165\u016d\u0170\u0177\u017e\u0186\u018e\u0192\u01a2\u01b6\u01d1"+
		"\u01d3\u01d9\u01e8\u01f5\u0200\u0203\u0208\u0225\u023a\u023f\u0246";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}