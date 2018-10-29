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
		T__78=1, T__77=2, T__76=3, T__75=4, T__74=5, T__73=6, T__72=7, T__71=8, 
		T__70=9, T__69=10, T__68=11, T__67=12, T__66=13, T__65=14, T__64=15, T__63=16, 
		T__62=17, T__61=18, T__60=19, T__59=20, T__58=21, T__57=22, T__56=23, 
		T__55=24, T__54=25, T__53=26, T__52=27, T__51=28, T__50=29, T__49=30, 
		T__48=31, T__47=32, T__46=33, T__45=34, T__44=35, T__43=36, T__42=37, 
		T__41=38, T__40=39, T__39=40, T__38=41, T__37=42, T__36=43, T__35=44, 
		T__34=45, T__33=46, T__32=47, T__31=48, T__30=49, T__29=50, T__28=51, 
		T__27=52, T__26=53, T__25=54, T__24=55, T__23=56, T__22=57, T__21=58, 
		T__20=59, T__19=60, T__18=61, T__17=62, T__16=63, T__15=64, T__14=65, 
		T__13=66, T__12=67, T__11=68, T__10=69, T__9=70, T__8=71, T__7=72, T__6=73, 
		T__5=74, T__4=75, T__3=76, T__2=77, T__1=78, T__0=79, COMMENT=80, LINECOMMENT=81, 
		STRING=82, WS=83, MultOp=84, Integer=85, Real=86, String=87, ErrorString=88, 
		Ident=89;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'default'", "'+='", "'use'", "'dispatch'", "'!='", 
		"'while'", "'{'", "'::'", "'..'", "'one'", "'='", "'for'", "'OrderedSet('", 
		"'null'", "'override'", "'implies'", "'('", "'closure'", "'-='", "','", 
		"'false'", "'Sequence('", "'Real'", "'unique'", "'reject'", "'>='", "'String'", 
		"'<'", "'forAll'", "']'", "'Sequence{'", "'@'", "'<>'", "'let'", "'+'", 
		"'then'", "'def'", "'as'", "'behavior'", "'true'", "'class'", "';'", "'Integer'", 
		"'any'", "'}'", "'extends'", "'if'", "':='", "'<='", "'sortedBy'", "'isUnique'", 
		"'opposite '", "'collect'", "'switch'", "'exists'", "'.'", "'Boolean'", 
		"'->'", "'case'", "'OrderedSet{'", "'mutable'", "':'", "'['", "'|'", "'=='", 
		"'select'", "'>'", "'contains'", "'xor'", "'or'", "'open'", "'else'", 
		"'in'", "')'", "'and'", "'not'", "'-'", "'import'", "COMMENT", "LINECOMMENT", 
		"STRING", "WS", "MultOp", "Integer", "Real", "String", "ErrorString", 
		"Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImport = 1, RULE_rService = 2, RULE_rClass = 3, 
		RULE_rOpenClass = 4, RULE_rMutableRef = 5, RULE_rNewClass = 6, RULE_rOperation = 7, 
		RULE_rTag = 8, RULE_rParameters = 9, RULE_rVariable = 10, RULE_rAttribute = 11, 
		RULE_rCardinality = 12, RULE_rOpposite = 13, RULE_rStatement = 14, RULE_rVarDecl = 15, 
		RULE_rAssign = 16, RULE_rInsert = 17, RULE_rRemove = 18, RULE_rForEach = 19, 
		RULE_rCollection = 20, RULE_rBlock = 21, RULE_rIf = 22, RULE_rWhile = 23, 
		RULE_rExpressionStmt = 24, RULE_rExpression = 25, RULE_rType = 26, RULE_rQualified = 27, 
		RULE_rSwitch = 28, RULE_rCase = 29, RULE_expression = 30, RULE_binding = 31, 
		RULE_addOp = 32, RULE_compOp = 33, RULE_navigationSegment = 34, RULE_callExp = 35, 
		RULE_lambdaExpression = 36, RULE_collectionIterator = 37, RULE_expressionSequence = 38, 
		RULE_variableDefinition = 39, RULE_literal = 40, RULE_typeLiteral = 41, 
		RULE_classifierTypeRule = 42;
	public static final String[] ruleNames = {
		"rRoot", "rImport", "rService", "rClass", "rOpenClass", "rMutableRef", 
		"rNewClass", "rOperation", "rTag", "rParameters", "rVariable", "rAttribute", 
		"rCardinality", "rOpposite", "rStatement", "rVarDecl", "rAssign", "rInsert", 
		"rRemove", "rForEach", "rCollection", "rBlock", "rIf", "rWhile", "rExpressionStmt", 
		"rExpression", "rType", "rQualified", "rSwitch", "rCase", "expression", 
		"binding", "addOp", "compOp", "navigationSegment", "callExp", "lambdaExpression", 
		"collectionIterator", "expressionSequence", "variableDefinition", "literal", 
		"typeLiteral", "classifierTypeRule"
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
			setState(86); match(T__39);
			setState(87); rQualified();
			setState(88); match(T__36);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(89); rImport();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__75) {
				{
				{
				setState(95); rService();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__37 || _la==T__7) {
				{
				{
				setState(101); rClass();
				}
				}
				setState(106);
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
			setState(107); match(T__0);
			setState(108); rQualified();
			setState(109); match(T__40);
			setState(110); match(Ident);
			setState(111); match(T__36);
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
			setState(113); match(T__75);
			setState(114); match(Ident);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(115); match(T__22);
				setState(116); match(Ident);
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122); match(T__36);
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
			setState(126);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); rOpenClass();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); rNewClass();
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(T__7);
			setState(129); match(T__37);
			setState(130); ((ROpenClassContext)_localctx).name = rQualified();
			setState(140);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(131); match(T__32);
				setState(132); rQualified();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__58) {
					{
					{
					setState(133); match(T__58);
					setState(134); rQualified();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(142); match(T__71);
			setState(150);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(143); match(T__17);
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(144); rMutableRef();
						}
						} 
					}
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__51) | (1L << T__35) | (1L << T__26) | (1L << T__21))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__10 - 69)) | (1L << (Integer - 69)) | (1L << (Ident - 69)))) != 0)) {
				{
				{
				setState(152); rAttribute();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__63) | (1L << T__46) | (1L << T__41))) != 0)) {
				{
				{
				setState(158); rOperation();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164); match(T__33);
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
			setState(166); match(Ident);
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
			setState(168); match(T__37);
			setState(169); ((RNewClassContext)_localctx).name = match(Ident);
			setState(170); match(T__71);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__51) | (1L << T__35) | (1L << T__26) | (1L << T__21))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__10 - 69)) | (1L << (Integer - 69)) | (1L << (Ident - 69)))) != 0)) {
				{
				{
				setState(171); rAttribute();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__63) | (1L << T__46) | (1L << T__41))) != 0)) {
				{
				{
				setState(177); rOperation();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183); match(T__33);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__46) {
				{
				{
				setState(185); rTag();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			_la = _input.LA(1);
			if ( !(_la==T__63 || _la==T__41) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(193);
			_la = _input.LA(1);
			if (_la==T__74) {
				{
				setState(192); ((ROperationContext)_localctx).dispatch = match(T__74);
				}
			}

			setState(195); ((ROperationContext)_localctx).type = rType();
			setState(196); ((ROperationContext)_localctx).name = match(Ident);
			setState(197); match(T__61);
			setState(199);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__35) | (1L << T__21))) != 0) || _la==Ident) {
				{
				setState(198); rParameters();
				}
			}

			setState(201); match(T__4);
			setState(202); rBlock();
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
		enterRule(_localctx, 16, RULE_rTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(T__46);
			setState(205); match(Ident);
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
		enterRule(_localctx, 18, RULE_rParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); rVariable();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__58) {
				{
				{
				setState(208); match(T__58);
				setState(209); rVariable();
				}
				}
				setState(214);
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
		enterRule(_localctx, 20, RULE_rVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); ((RVariableContext)_localctx).type = rType();
			setState(216); match(Ident);
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
		enterRule(_localctx, 22, RULE_rAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if (_la==T__54 || _la==T__10) {
				{
				setState(218);
				((RAttributeContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__54 || _la==T__10) ) {
					((RAttributeContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(222);
			_la = _input.LA(1);
			if (_la==Integer) {
				{
				setState(221); ((RAttributeContext)_localctx).bounds = rCardinality();
				}
			}

			setState(225);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(224); ((RAttributeContext)_localctx).opposite = rOpposite();
				}
			}

			setState(227); ((RAttributeContext)_localctx).type = rType();
			setState(228); match(Ident);
			setState(231);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(229); match(T__30);
				setState(230); rExpression();
				}
			}

			setState(233); match(T__36);
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
		enterRule(_localctx, 24, RULE_rCardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(Integer);
			setState(236); match(T__69);
			setState(237);
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
		enterRule(_localctx, 26, RULE_rOpposite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(T__26);
			setState(240); match(Ident);
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
		enterRule(_localctx, 28, RULE_rStatement);
		try {
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); rVarDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243); rAssign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244); rInsert();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(245); rRemove();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(246); rForEach();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(247); rWhile();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(248); rIf();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(249); rExpressionStmt();
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
		enterRule(_localctx, 30, RULE_rVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); ((RVarDeclContext)_localctx).type = rType();
			setState(253); match(Ident);
			setState(256);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(254); match(T__30);
				setState(255); rExpression();
				}
			}

			setState(258); match(T__36);
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
		enterRule(_localctx, 32, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); expression(0);
			setState(261); match(T__30);
			setState(262); rExpression();
			setState(263); match(T__36);
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
		enterRule(_localctx, 34, RULE_rInsert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); expression(0);
			setState(266); match(T__76);
			setState(267); rExpression();
			setState(268); match(T__36);
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
		enterRule(_localctx, 36, RULE_rRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); expression(0);
			setState(271); match(T__59);
			setState(272); rExpression();
			setState(273); match(T__36);
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
		enterRule(_localctx, 38, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(T__66);
			setState(276); match(T__61);
			setState(277); match(Ident);
			setState(278); match(T__5);
			setState(279); rCollection();
			setState(280); match(T__4);
			setState(281); rBlock();
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
		enterRule(_localctx, 40, RULE_rCollection);
		try {
			setState(289);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(283); match(T__15);
				setState(284); match(Integer);
				setState(285); match(T__69);
				setState(286); match(Integer);
				setState(287); match(T__48);
				}
				break;
			case T__71:
			case T__65:
			case T__64:
			case T__61:
			case T__57:
			case T__56:
			case T__55:
			case T__51:
			case T__47:
			case T__44:
			case T__38:
			case T__35:
			case T__31:
			case T__24:
			case T__21:
			case T__18:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(288); rExpression();
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
		enterRule(_localctx, 42, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(T__71);
			setState(299);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__72) | (1L << T__71) | (1L << T__66) | (1L << T__65) | (1L << T__64) | (1L << T__61) | (1L << T__57) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__47) | (1L << T__44) | (1L << T__38) | (1L << T__35) | (1L << T__31) | (1L << T__24) | (1L << T__21) | (1L << T__18))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (T__2 - 77)) | (1L << (T__1 - 77)) | (1L << (Integer - 77)) | (1L << (Real - 77)) | (1L << (String - 77)) | (1L << (ErrorString - 77)) | (1L << (Ident - 77)))) != 0)) {
				{
				setState(292); rStatement();
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__72) | (1L << T__71) | (1L << T__66) | (1L << T__65) | (1L << T__64) | (1L << T__61) | (1L << T__57) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__47) | (1L << T__44) | (1L << T__38) | (1L << T__35) | (1L << T__31) | (1L << T__24) | (1L << T__21) | (1L << T__18))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (T__2 - 77)) | (1L << (T__1 - 77)) | (1L << (Integer - 77)) | (1L << (Real - 77)) | (1L << (String - 77)) | (1L << (ErrorString - 77)) | (1L << (Ident - 77)))) != 0)) {
					{
					{
					setState(293); rStatement();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(301); match(T__33);
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
		enterRule(_localctx, 44, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); match(T__31);
			setState(304); match(T__61);
			setState(305); rExpression();
			setState(306); match(T__4);
			setState(307); rBlock();
			setState(313);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(308); match(T__6);
				setState(311);
				switch (_input.LA(1)) {
				case T__71:
					{
					setState(309); rBlock();
					}
					break;
				case T__31:
					{
					setState(310); ((RIfContext)_localctx).nestedIf = rIf();
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
		enterRule(_localctx, 46, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(T__72);
			setState(316); match(T__61);
			setState(317); rExpression();
			setState(318); match(T__4);
			setState(319); rBlock();
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
		enterRule(_localctx, 48, RULE_rExpressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321); rExpression();
			setState(322); match(T__36);
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
		enterRule(_localctx, 50, RULE_rExpression);
		try {
			setState(326);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(324); rSwitch();
				}
				break;
			case T__71:
			case T__65:
			case T__64:
			case T__61:
			case T__57:
			case T__56:
			case T__55:
			case T__51:
			case T__47:
			case T__44:
			case T__38:
			case T__35:
			case T__31:
			case T__21:
			case T__18:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(325); expression(0);
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
		enterRule(_localctx, 52, RULE_rType);
		int _la;
		try {
			setState(337);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328); typeLiteral();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329); match(Ident);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__70) {
					{
					{
					setState(330); match(T__70);
					setState(331); match(Ident);
					}
					}
					setState(336);
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
		enterRule(_localctx, 54, RULE_rQualified);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); match(Ident);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(340); match(T__22);
				setState(341); match(Ident);
				}
				}
				setState(346);
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
		enterRule(_localctx, 56, RULE_rSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); match(T__24);
			setState(348); match(T__61);
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(349); ((RSwitchContext)_localctx).paramName = match(Ident);
				setState(350); match(T__16);
				}
				break;
			}
			setState(353); ((RSwitchContext)_localctx).paramVal = rExpression();
			setState(354); match(T__4);
			setState(355); match(T__71);
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356); ((RSwitchContext)_localctx).rCase = rCase();
				((RSwitchContext)_localctx).cases.add(((RSwitchContext)_localctx).rCase);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__35) | (1L << T__21) | (1L << T__19) | (1L << T__16))) != 0) || _la==Ident );
			setState(361); match(T__77);
			setState(362); match(T__16);
			setState(363); ((RSwitchContext)_localctx).other = rExpression();
			setState(364); match(T__33);
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
		enterRule(_localctx, 58, RULE_rCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__35) | (1L << T__21))) != 0) || _la==Ident) {
				{
				setState(366); ((RCaseContext)_localctx).guard = rType();
				}
			}

			setState(371);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(369); match(T__19);
				setState(370); ((RCaseContext)_localctx).match = rExpression();
				}
			}

			setState(373); match(T__16);
			setState(374); ((RCaseContext)_localctx).value = rExpression();
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(377); match(T__2);
				setState(378); expression(14);
				}
				break;

			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(379); match(T__1);
				setState(380); expression(13);
				}
				break;

			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(381); match(T__44);
				setState(382); binding();
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__58) {
					{
					{
					setState(383); match(T__58);
					setState(384); binding();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390); match(T__5);
				setState(391); expression(1);
				}
				break;

			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(393); match(Ident);
				}
				break;

			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(395); match(T__61);
				setState(396); expression(0);
				setState(397); match(T__4);
				}
				break;

			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(399); match(T__31);
				setState(400); expression(0);
				setState(401); match(T__42);
				setState(402); expression(0);
				setState(403); match(T__6);
				setState(404); expression(0);
				setState(405); match(T__78);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(434);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(409);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(410); match(MultOp);
						setState(411); expression(13);
						}
						break;

					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(413); addOp();
						setState(414); expression(12);
						}
						break;

					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(417); compOp();
						setState(418); expression(11);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(420);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(421); match(T__3);
						setState(422); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(423);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(424); match(T__8);
						setState(425); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(426);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(427); match(T__9);
						setState(428); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(429);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(430); match(T__62);
						setState(431); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(432);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(433); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		enterRule(_localctx, 62, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439); match(Ident);
			setState(442);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(440); match(T__16);
				setState(441); typeLiteral();
				}
			}

			setState(444); match(T__67);
			setState(445); expression(0);
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
		enterRule(_localctx, 64, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_la = _input.LA(1);
			if ( !(_la==T__43 || _la==T__1) ) {
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
		enterRule(_localctx, 66, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !(((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (T__73 - 6)) | (1L << (T__67 - 6)) | (1L << (T__52 - 6)) | (1L << (T__50 - 6)) | (1L << (T__45 - 6)) | (1L << (T__29 - 6)) | (1L << (T__13 - 6)) | (1L << (T__11 - 6)))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_navigationSegment);
		try {
			setState(457);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(451); match(T__22);
				setState(452); match(Ident);
				}
				break;

			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(453); match(T__22);
				setState(454); callExp();
				}
				break;

			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(455); match(T__20);
				setState(456); callExp();
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
		enterRule(_localctx, 70, RULE_callExp);
		try {
			setState(470);
			switch (_input.LA(1)) {
			case T__68:
			case T__60:
			case T__53:
			case T__49:
			case T__34:
			case T__28:
			case T__27:
			case T__25:
			case T__23:
			case T__12:
				_localctx = new IterationCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(459); collectionIterator();
				setState(460); match(T__61);
				setState(461); variableDefinition();
				setState(462); lambdaExpression();
				setState(463); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(465); match(Ident);
				setState(466); match(T__61);
				setState(467); expressionSequence();
				setState(468); match(T__4);
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
		enterRule(_localctx, 72, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); expression(0);
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
		enterRule(_localctx, 74, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_la = _input.LA(1);
			if ( !(((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__68 - 11)) | (1L << (T__60 - 11)) | (1L << (T__53 - 11)) | (1L << (T__49 - 11)) | (1L << (T__34 - 11)) | (1L << (T__28 - 11)) | (1L << (T__27 - 11)) | (1L << (T__25 - 11)) | (1L << (T__23 - 11)) | (1L << (T__12 - 11)))) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__65) | (1L << T__64) | (1L << T__61) | (1L << T__57) | (1L << T__56) | (1L << T__55) | (1L << T__51) | (1L << T__47) | (1L << T__44) | (1L << T__38) | (1L << T__35) | (1L << T__31) | (1L << T__21) | (1L << T__18))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (T__2 - 77)) | (1L << (T__1 - 77)) | (1L << (Integer - 77)) | (1L << (Real - 77)) | (1L << (String - 77)) | (1L << (ErrorString - 77)) | (1L << (Ident - 77)))) != 0)) {
				{
				setState(476); expression(0);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__58) {
					{
					{
					setState(477); match(T__58);
					setState(478); expression(0);
					}
					}
					setState(483);
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
		enterRule(_localctx, 78, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486); match(Ident);
			setState(489);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(487); match(T__16);
				setState(488); typeLiteral();
				}
			}

			setState(491); match(T__14);
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
		enterRule(_localctx, 80, RULE_literal);
		try {
			setState(518);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(493); match(String);
				}
				break;

			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(494); match(ErrorString);
				}
				break;

			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(495); match(Integer);
				}
				break;

			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(496); match(Real);
				}
				break;

			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(497); match(T__38);
				}
				break;

			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(498); match(T__57);
				}
				break;

			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(499); match(T__64);
				}
				break;

			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(500); match(T__47);
				setState(501); expressionSequence();
				setState(502); match(T__33);
				}
				break;

			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(504); match(T__18);
				setState(505); expressionSequence();
				setState(506); match(T__33);
				}
				break;

			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(508); match(Ident);
				setState(509); match(T__70);
				setState(510); match(Ident);
				setState(511); match(T__70);
				setState(512); match(Ident);
				}
				break;

			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(513); match(Ident);
				setState(514); match(T__70);
				setState(515); match(Ident);
				setState(516); match(T__16);
				}
				break;

			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(517); typeLiteral();
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
		enterRule(_localctx, 82, RULE_typeLiteral);
		int _la;
		try {
			setState(544);
			switch (_input.LA(1)) {
			case T__51:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(520); match(T__51);
				}
				break;
			case T__35:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(521); match(T__35);
				}
				break;
			case T__55:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(522); match(T__55);
				}
				break;
			case T__21:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(523); match(T__21);
				}
				break;
			case T__56:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(524); match(T__56);
				setState(525); typeLiteral();
				setState(526); match(T__4);
				}
				break;
			case T__65:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(528); match(T__65);
				setState(529); typeLiteral();
				setState(530); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(532); classifierTypeRule();
				}
				break;
			case T__71:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(533); match(T__71);
				setState(534); classifierTypeRule();
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(535); match(T__14);
					setState(536); classifierTypeRule();
					}
					}
					setState(541);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(542); match(T__33);
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
		enterRule(_localctx, 84, RULE_classifierTypeRule);
		try {
			setState(551);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(546); match(Ident);
				setState(547); match(T__70);
				setState(548); match(Ident);
				}
				break;

			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(549); match(Ident);
				setState(550); match(T__16);
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
		case 30: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3[\u022c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\7\2]\n\2\f\2\16\2`\13\2\3\2\7\2c\n\2\f\2\16\2f\13"+
		"\2\3\2\7\2i\n\2\f\2\16\2l\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\7\4x\n\4\f\4\16\4{\13\4\3\4\3\4\3\5\3\5\5\5\u0081\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6\u008a\n\6\f\6\16\6\u008d\13\6\5\6\u008f\n\6\3\6\3\6\3"+
		"\6\7\6\u0094\n\6\f\6\16\6\u0097\13\6\5\6\u0099\n\6\3\6\7\6\u009c\n\6\f"+
		"\6\16\6\u009f\13\6\3\6\7\6\u00a2\n\6\f\6\16\6\u00a5\13\6\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\7\b\u00af\n\b\f\b\16\b\u00b2\13\b\3\b\7\b\u00b5\n\b"+
		"\f\b\16\b\u00b8\13\b\3\b\3\b\3\t\7\t\u00bd\n\t\f\t\16\t\u00c0\13\t\3\t"+
		"\3\t\5\t\u00c4\n\t\3\t\3\t\3\t\3\t\5\t\u00ca\n\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\7\13\u00d5\n\13\f\13\16\13\u00d8\13\13\3\f\3\f\3\f\3"+
		"\r\5\r\u00de\n\r\3\r\5\r\u00e1\n\r\3\r\5\r\u00e4\n\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00ea\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00fd\n\20\3\21\3\21\3\21\3\21\5\21\u0103"+
		"\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0124\n\26\3\27\3\27\3\27\7\27\u0129\n\27\f"+
		"\27\16\27\u012c\13\27\5\27\u012e\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u013a\n\30\5\30\u013c\n\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\5\33\u0149\n\33\3\34\3\34\3\34\3\34"+
		"\7\34\u014f\n\34\f\34\16\34\u0152\13\34\5\34\u0154\n\34\3\35\3\35\3\35"+
		"\7\35\u0159\n\35\f\35\16\35\u015c\13\35\3\36\3\36\3\36\3\36\5\36\u0162"+
		"\n\36\3\36\3\36\3\36\3\36\6\36\u0168\n\36\r\36\16\36\u0169\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\5\37\u0172\n\37\3\37\3\37\5\37\u0176\n\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0184\n \f \16 \u0187\13 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u019a\n \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u01b5"+
		"\n \f \16 \u01b8\13 \3!\3!\3!\5!\u01bd\n!\3!\3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3$\3$\3$\5$\u01cc\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01d9\n"+
		"%\3&\3&\3\'\3\'\3(\3(\3(\7(\u01e2\n(\f(\16(\u01e5\13(\5(\u01e7\n(\3)\3"+
		")\3)\5)\u01ec\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0209\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\7+\u021c\n+\f+\16+\u021f\13+\3+\3+\5+\u0223\n+"+
		"\3,\3,\3,\3,\3,\5,\u022a\n,\3,\2\3>-\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\b\4\2\22\22((\4\2\33\33"+
		"GG\3\2VW\4\2&&PP\n\2\b\b\16\16\35\35\37\37$$\64\64DDFF\13\2\r\r\25\25"+
		"\34\34  //\65\6688::EE\u0254\2X\3\2\2\2\4m\3\2\2\2\6s\3\2\2\2\b\u0080"+
		"\3\2\2\2\n\u0082\3\2\2\2\f\u00a8\3\2\2\2\16\u00aa\3\2\2\2\20\u00be\3\2"+
		"\2\2\22\u00ce\3\2\2\2\24\u00d1\3\2\2\2\26\u00d9\3\2\2\2\30\u00dd\3\2\2"+
		"\2\32\u00ed\3\2\2\2\34\u00f1\3\2\2\2\36\u00fc\3\2\2\2 \u00fe\3\2\2\2\""+
		"\u0106\3\2\2\2$\u010b\3\2\2\2&\u0110\3\2\2\2(\u0115\3\2\2\2*\u0123\3\2"+
		"\2\2,\u0125\3\2\2\2.\u0131\3\2\2\2\60\u013d\3\2\2\2\62\u0143\3\2\2\2\64"+
		"\u0148\3\2\2\2\66\u0153\3\2\2\28\u0155\3\2\2\2:\u015d\3\2\2\2<\u0171\3"+
		"\2\2\2>\u0199\3\2\2\2@\u01b9\3\2\2\2B\u01c1\3\2\2\2D\u01c3\3\2\2\2F\u01cb"+
		"\3\2\2\2H\u01d8\3\2\2\2J\u01da\3\2\2\2L\u01dc\3\2\2\2N\u01e6\3\2\2\2P"+
		"\u01e8\3\2\2\2R\u0208\3\2\2\2T\u0222\3\2\2\2V\u0229\3\2\2\2XY\7*\2\2Y"+
		"Z\58\35\2Z^\7-\2\2[]\5\4\3\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2"+
		"_d\3\2\2\2`^\3\2\2\2ac\5\6\4\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2"+
		"ej\3\2\2\2fd\3\2\2\2gi\5\b\5\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"k\3\3\2\2\2lj\3\2\2\2mn\7Q\2\2no\58\35\2op\7)\2\2pq\7[\2\2qr\7-\2\2r\5"+
		"\3\2\2\2st\7\6\2\2ty\7[\2\2uv\7;\2\2vx\7[\2\2wu\3\2\2\2x{\3\2\2\2yw\3"+
		"\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7-\2\2}\7\3\2\2\2~\u0081\5\n\6"+
		"\2\177\u0081\5\16\b\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\t\3\2\2\2"+
		"\u0082\u0083\7J\2\2\u0083\u0084\7,\2\2\u0084\u008e\58\35\2\u0085\u0086"+
		"\7\61\2\2\u0086\u008b\58\35\2\u0087\u0088\7\27\2\2\u0088\u008a\58\35\2"+
		"\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0085\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0098\7\n\2\2\u0091\u0095\7@"+
		"\2\2\u0092\u0094\5\f\7\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0098\u0091\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009d\3\2\2\2\u009a"+
		"\u009c\5\30\r\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3"+
		"\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a3\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a2\5\20\t\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7\60\2\2\u00a7\13\3\2\2\2\u00a8\u00a9\7[\2\2\u00a9\r\3\2\2\2\u00aa"+
		"\u00ab\7,\2\2\u00ab\u00ac\7[\2\2\u00ac\u00b0\7\n\2\2\u00ad\u00af\5\30"+
		"\r\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b6\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\5\20"+
		"\t\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\60"+
		"\2\2\u00ba\17\3\2\2\2\u00bb\u00bd\5\22\n\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c3\t\2\2\2\u00c2\u00c4\7\7\2\2\u00c3\u00c2\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\5\66\34\2\u00c6"+
		"\u00c7\7[\2\2\u00c7\u00c9\7\24\2\2\u00c8\u00ca\5\24\13\2\u00c9\u00c8\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7M\2\2\u00cc"+
		"\u00cd\5,\27\2\u00cd\21\3\2\2\2\u00ce\u00cf\7#\2\2\u00cf\u00d0\7[\2\2"+
		"\u00d0\23\3\2\2\2\u00d1\u00d6\5\26\f\2\u00d2\u00d3\7\27\2\2\u00d3\u00d5"+
		"\5\26\f\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2"+
		"\u00d6\u00d7\3\2\2\2\u00d7\25\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da"+
		"\5\66\34\2\u00da\u00db\7[\2\2\u00db\27\3\2\2\2\u00dc\u00de\t\3\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\5\32"+
		"\16\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e4\5\34\17\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3"+
		"\2\2\2\u00e5\u00e6\5\66\34\2\u00e6\u00e9\7[\2\2\u00e7\u00e8\7\63\2\2\u00e8"+
		"\u00ea\5\64\33\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3"+
		"\2\2\2\u00eb\u00ec\7-\2\2\u00ec\31\3\2\2\2\u00ed\u00ee\7W\2\2\u00ee\u00ef"+
		"\7\f\2\2\u00ef\u00f0\t\4\2\2\u00f0\33\3\2\2\2\u00f1\u00f2\7\67\2\2\u00f2"+
		"\u00f3\7[\2\2\u00f3\35\3\2\2\2\u00f4\u00fd\5 \21\2\u00f5\u00fd\5\"\22"+
		"\2\u00f6\u00fd\5$\23\2\u00f7\u00fd\5&\24\2\u00f8\u00fd\5(\25\2\u00f9\u00fd"+
		"\5\60\31\2\u00fa\u00fd\5.\30\2\u00fb\u00fd\5\62\32\2\u00fc\u00f4\3\2\2"+
		"\2\u00fc\u00f5\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fc\u00f8"+
		"\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\37\3\2\2\2\u00fe\u00ff\5\66\34\2\u00ff\u0102\7[\2\2\u0100\u0101\7\63"+
		"\2\2\u0101\u0103\5\64\33\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\7-\2\2\u0105!\3\2\2\2\u0106\u0107\5> \2\u0107"+
		"\u0108\7\63\2\2\u0108\u0109\5\64\33\2\u0109\u010a\7-\2\2\u010a#\3\2\2"+
		"\2\u010b\u010c\5> \2\u010c\u010d\7\5\2\2\u010d\u010e\5\64\33\2\u010e\u010f"+
		"\7-\2\2\u010f%\3\2\2\2\u0110\u0111\5> \2\u0111\u0112\7\26\2\2\u0112\u0113"+
		"\5\64\33\2\u0113\u0114\7-\2\2\u0114\'\3\2\2\2\u0115\u0116\7\17\2\2\u0116"+
		"\u0117\7\24\2\2\u0117\u0118\7[\2\2\u0118\u0119\7L\2\2\u0119\u011a\5*\26"+
		"\2\u011a\u011b\7M\2\2\u011b\u011c\5,\27\2\u011c)\3\2\2\2\u011d\u011e\7"+
		"B\2\2\u011e\u011f\7W\2\2\u011f\u0120\7\f\2\2\u0120\u0121\7W\2\2\u0121"+
		"\u0124\7!\2\2\u0122\u0124\5\64\33\2\u0123\u011d\3\2\2\2\u0123\u0122\3"+
		"\2\2\2\u0124+\3\2\2\2\u0125\u012d\7\n\2\2\u0126\u012a\5\36\20\2\u0127"+
		"\u0129\5\36\20\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u0126\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7\60"+
		"\2\2\u0130-\3\2\2\2\u0131\u0132\7\62\2\2\u0132\u0133\7\24\2\2\u0133\u0134"+
		"\5\64\33\2\u0134\u0135\7M\2\2\u0135\u013b\5,\27\2\u0136\u0139\7K\2\2\u0137"+
		"\u013a\5,\27\2\u0138\u013a\5.\30\2\u0139\u0137\3\2\2\2\u0139\u0138\3\2"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u0136\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"/\3\2\2\2\u013d\u013e\7\t\2\2\u013e\u013f\7\24\2\2\u013f\u0140\5\64\33"+
		"\2\u0140\u0141\7M\2\2\u0141\u0142\5,\27\2\u0142\61\3\2\2\2\u0143\u0144"+
		"\5\64\33\2\u0144\u0145\7-\2\2\u0145\63\3\2\2\2\u0146\u0149\5:\36\2\u0147"+
		"\u0149\5> \2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\65\3\2\2\2"+
		"\u014a\u0154\5T+\2\u014b\u0150\7[\2\2\u014c\u014d\7\13\2\2\u014d\u014f"+
		"\7[\2\2\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u014a\3\2"+
		"\2\2\u0153\u014b\3\2\2\2\u0154\67\3\2\2\2\u0155\u015a\7[\2\2\u0156\u0157"+
		"\7;\2\2\u0157\u0159\7[\2\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b9\3\2\2\2\u015c\u015a\3\2\2\2"+
		"\u015d\u015e\79\2\2\u015e\u0161\7\24\2\2\u015f\u0160\7[\2\2\u0160\u0162"+
		"\7A\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\5\64\33\2\u0164\u0165\7M\2\2\u0165\u0167\7\n\2\2\u0166\u0168\5"+
		"<\37\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\4\2\2\u016c\u016d\7A"+
		"\2\2\u016d\u016e\5\64\33\2\u016e\u016f\7\60\2\2\u016f;\3\2\2\2\u0170\u0172"+
		"\5\66\34\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0175\3\2\2\2"+
		"\u0173\u0174\7>\2\2\u0174\u0176\5\64\33\2\u0175\u0173\3\2\2\2\u0175\u0176"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7A\2\2\u0178\u0179\5\64\33\2"+
		"\u0179=\3\2\2\2\u017a\u017b\b \1\2\u017b\u017c\7O\2\2\u017c\u019a\5> "+
		"\20\u017d\u017e\7P\2\2\u017e\u019a\5> \17\u017f\u0180\7%\2\2\u0180\u0185"+
		"\5@!\2\u0181\u0182\7\27\2\2\u0182\u0184\5@!\2\u0183\u0181\3\2\2\2\u0184"+
		"\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7L\2\2\u0189\u018a\5> \3\u018a\u019a"+
		"\3\2\2\2\u018b\u019a\7[\2\2\u018c\u019a\5R*\2\u018d\u018e\7\24\2\2\u018e"+
		"\u018f\5> \2\u018f\u0190\7M\2\2\u0190\u019a\3\2\2\2\u0191\u0192\7\62\2"+
		"\2\u0192\u0193\5> \2\u0193\u0194\7\'\2\2\u0194\u0195\5> \2\u0195\u0196"+
		"\7K\2\2\u0196\u0197\5> \2\u0197\u0198\7\3\2\2\u0198\u019a\3\2\2\2\u0199"+
		"\u017a\3\2\2\2\u0199\u017d\3\2\2\2\u0199\u017f\3\2\2\2\u0199\u018b\3\2"+
		"\2\2\u0199\u018c\3\2\2\2\u0199\u018d\3\2\2\2\u0199\u0191\3\2\2\2\u019a"+
		"\u01b6\3\2\2\2\u019b\u019c\f\16\2\2\u019c\u019d\7V\2\2\u019d\u01b5\5>"+
		" \17\u019e\u019f\f\r\2\2\u019f\u01a0\5B\"\2\u01a0\u01a1\5> \16\u01a1\u01b5"+
		"\3\2\2\2\u01a2\u01a3\f\f\2\2\u01a3\u01a4\5D#\2\u01a4\u01a5\5> \r\u01a5"+
		"\u01b5\3\2\2\2\u01a6\u01a7\f\13\2\2\u01a7\u01a8\7N\2\2\u01a8\u01b5\5>"+
		" \f\u01a9\u01aa\f\n\2\2\u01aa\u01ab\7I\2\2\u01ab\u01b5\5> \13\u01ac\u01ad"+
		"\f\t\2\2\u01ad\u01ae\7H\2\2\u01ae\u01b5\5> \n\u01af\u01b0\f\b\2\2\u01b0"+
		"\u01b1\7\23\2\2\u01b1\u01b5\5> \t\u01b2\u01b3\f\21\2\2\u01b3\u01b5\5F"+
		"$\2\u01b4\u019b\3\2\2\2\u01b4\u019e\3\2\2\2\u01b4\u01a2\3\2\2\2\u01b4"+
		"\u01a6\3\2\2\2\u01b4\u01a9\3\2\2\2\u01b4\u01ac\3\2\2\2\u01b4\u01af\3\2"+
		"\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7?\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\7[\2\2\u01ba"+
		"\u01bb\7A\2\2\u01bb\u01bd\5T+\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2"+
		"\2\u01bd\u01be\3\2\2\2\u01be\u01bf\7\16\2\2\u01bf\u01c0\5> \2\u01c0A\3"+
		"\2\2\2\u01c1\u01c2\t\5\2\2\u01c2C\3\2\2\2\u01c3\u01c4\t\6\2\2\u01c4E\3"+
		"\2\2\2\u01c5\u01c6\7;\2\2\u01c6\u01cc\7[\2\2\u01c7\u01c8\7;\2\2\u01c8"+
		"\u01cc\5H%\2\u01c9\u01ca\7=\2\2\u01ca\u01cc\5H%\2\u01cb\u01c5\3\2\2\2"+
		"\u01cb\u01c7\3\2\2\2\u01cb\u01c9\3\2\2\2\u01ccG\3\2\2\2\u01cd\u01ce\5"+
		"L\'\2\u01ce\u01cf\7\24\2\2\u01cf\u01d0\5P)\2\u01d0\u01d1\5J&\2\u01d1\u01d2"+
		"\7M\2\2\u01d2\u01d9\3\2\2\2\u01d3\u01d4\7[\2\2\u01d4\u01d5\7\24\2\2\u01d5"+
		"\u01d6\5N(\2\u01d6\u01d7\7M\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01cd\3\2\2"+
		"\2\u01d8\u01d3\3\2\2\2\u01d9I\3\2\2\2\u01da\u01db\5> \2\u01dbK\3\2\2\2"+
		"\u01dc\u01dd\t\7\2\2\u01ddM\3\2\2\2\u01de\u01e3\5> \2\u01df\u01e0\7\27"+
		"\2\2\u01e0\u01e2\5> \2\u01e1\u01df\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6"+
		"\u01de\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7O\3\2\2\2\u01e8\u01eb\7[\2\2\u01e9"+
		"\u01ea\7A\2\2\u01ea\u01ec\5T+\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2"+
		"\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\7C\2\2\u01eeQ\3\2\2\2\u01ef\u0209\7"+
		"Y\2\2\u01f0\u0209\7Z\2\2\u01f1\u0209\7W\2\2\u01f2\u0209\7X\2\2\u01f3\u0209"+
		"\7+\2\2\u01f4\u0209\7\30\2\2\u01f5\u0209\7\21\2\2\u01f6\u01f7\7\"\2\2"+
		"\u01f7\u01f8\5N(\2\u01f8\u01f9\7\60\2\2\u01f9\u0209\3\2\2\2\u01fa\u01fb"+
		"\7?\2\2\u01fb\u01fc\5N(\2\u01fc\u01fd\7\60\2\2\u01fd\u0209\3\2\2\2\u01fe"+
		"\u01ff\7[\2\2\u01ff\u0200\7\13\2\2\u0200\u0201\7[\2\2\u0201\u0202\7\13"+
		"\2\2\u0202\u0209\7[\2\2\u0203\u0204\7[\2\2\u0204\u0205\7\13\2\2\u0205"+
		"\u0206\7[\2\2\u0206\u0209\7A\2\2\u0207\u0209\5T+\2\u0208\u01ef\3\2\2\2"+
		"\u0208\u01f0\3\2\2\2\u0208\u01f1\3\2\2\2\u0208\u01f2\3\2\2\2\u0208\u01f3"+
		"\3\2\2\2\u0208\u01f4\3\2\2\2\u0208\u01f5\3\2\2\2\u0208\u01f6\3\2\2\2\u0208"+
		"\u01fa\3\2\2\2\u0208\u01fe\3\2\2\2\u0208\u0203\3\2\2\2\u0208\u0207\3\2"+
		"\2\2\u0209S\3\2\2\2\u020a\u0223\7\36\2\2\u020b\u0223\7.\2\2\u020c\u0223"+
		"\7\32\2\2\u020d\u0223\7<\2\2\u020e\u020f\7\31\2\2\u020f\u0210\5T+\2\u0210"+
		"\u0211\7M\2\2\u0211\u0223\3\2\2\2\u0212\u0213\7\20\2\2\u0213\u0214\5T"+
		"+\2\u0214\u0215\7M\2\2\u0215\u0223\3\2\2\2\u0216\u0223\5V,\2\u0217\u0218"+
		"\7\n\2\2\u0218\u021d\5V,\2\u0219\u021a\7C\2\2\u021a\u021c\5V,\2\u021b"+
		"\u0219\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2"+
		"\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\7\60\2\2\u0221"+
		"\u0223\3\2\2\2\u0222\u020a\3\2\2\2\u0222\u020b\3\2\2\2\u0222\u020c\3\2"+
		"\2\2\u0222\u020d\3\2\2\2\u0222\u020e\3\2\2\2\u0222\u0212\3\2\2\2\u0222"+
		"\u0216\3\2\2\2\u0222\u0217\3\2\2\2\u0223U\3\2\2\2\u0224\u0225\7[\2\2\u0225"+
		"\u0226\7\13\2\2\u0226\u022a\7[\2\2\u0227\u0228\7[\2\2\u0228\u022a\7A\2"+
		"\2\u0229\u0224\3\2\2\2\u0229\u0227\3\2\2\2\u022aW\3\2\2\2\64^djy\u0080"+
		"\u008b\u008e\u0095\u0098\u009d\u00a3\u00b0\u00b6\u00be\u00c3\u00c9\u00d6"+
		"\u00dd\u00e0\u00e3\u00e9\u00fc\u0102\u0123\u012a\u012d\u0139\u013b\u0148"+
		"\u0150\u0153\u015a\u0161\u0169\u0171\u0175\u0185\u0199\u01b4\u01b6\u01bc"+
		"\u01cb\u01d8\u01e3\u01e6\u01eb\u0208\u021d\u0222\u0229";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}