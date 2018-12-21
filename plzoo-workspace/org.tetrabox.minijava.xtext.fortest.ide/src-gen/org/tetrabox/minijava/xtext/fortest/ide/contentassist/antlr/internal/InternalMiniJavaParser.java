package org.tetrabox.minijava.xtext.fortest.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.tetrabox.minijava.xtext.fortest.services.MiniJavaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMiniJavaParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'true'", "'false'", "'private'", "'protected'", "'public'", "'package'", "'import'", "'.'", "'.*'", "'class'", "'{'", "'}'", "'extends'", "'implements'", "','", "'interface'", "'('", "')'", "'='", "'System'", "'out'", "'println'", "'return'", "'if'", "'else'", "'while'", "'for'", "'['", "']'", "'int'", "'boolean'", "'String'", "'void'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'%'", "'+'", "'-'", "'*'", "'/'", "'length'", "'!'", "'this'", "'super'", "'null'", "'new'", "'abstract'", "'static'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMiniJavaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMiniJavaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMiniJavaParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMiniJava.g"; }


    	private MiniJavaGrammarAccess grammarAccess;

    	public void setGrammarAccess(MiniJavaGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProgram"
    // InternalMiniJava.g:54:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // InternalMiniJava.g:55:1: ( ruleProgram EOF )
            // InternalMiniJava.g:56:1: ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalMiniJava.g:63:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:67:2: ( ( ( rule__Program__Group__0 ) ) )
            // InternalMiniJava.g:68:2: ( ( rule__Program__Group__0 ) )
            {
            // InternalMiniJava.g:68:2: ( ( rule__Program__Group__0 ) )
            // InternalMiniJava.g:69:3: ( rule__Program__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup()); 
            }
            // InternalMiniJava.g:70:3: ( rule__Program__Group__0 )
            // InternalMiniJava.g:70:4: rule__Program__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleImport"
    // InternalMiniJava.g:79:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalMiniJava.g:80:1: ( ruleImport EOF )
            // InternalMiniJava.g:81:1: ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMiniJava.g:88:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:92:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalMiniJava.g:93:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalMiniJava.g:93:2: ( ( rule__Import__Group__0 ) )
            // InternalMiniJava.g:94:3: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // InternalMiniJava.g:95:3: ( rule__Import__Group__0 )
            // InternalMiniJava.g:95:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalMiniJava.g:104:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalMiniJava.g:105:1: ( ruleQualifiedName EOF )
            // InternalMiniJava.g:106:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalMiniJava.g:113:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:117:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalMiniJava.g:118:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalMiniJava.g:118:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalMiniJava.g:119:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalMiniJava.g:120:3: ( rule__QualifiedName__Group__0 )
            // InternalMiniJava.g:120:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalMiniJava.g:129:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // InternalMiniJava.g:130:1: ( ruleQualifiedNameWithWildcard EOF )
            // InternalMiniJava.g:131:1: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalMiniJava.g:138:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:142:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // InternalMiniJava.g:143:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // InternalMiniJava.g:143:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // InternalMiniJava.g:144:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            }
            // InternalMiniJava.g:145:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            // InternalMiniJava.g:145:4: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalMiniJava.g:154:1: entryRuleTypeDeclaration : ruleTypeDeclaration EOF ;
    public final void entryRuleTypeDeclaration() throws RecognitionException {
        try {
            // InternalMiniJava.g:155:1: ( ruleTypeDeclaration EOF )
            // InternalMiniJava.g:156:1: ruleTypeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // InternalMiniJava.g:163:1: ruleTypeDeclaration : ( ( rule__TypeDeclaration__Alternatives ) ) ;
    public final void ruleTypeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:167:2: ( ( ( rule__TypeDeclaration__Alternatives ) ) )
            // InternalMiniJava.g:168:2: ( ( rule__TypeDeclaration__Alternatives ) )
            {
            // InternalMiniJava.g:168:2: ( ( rule__TypeDeclaration__Alternatives ) )
            // InternalMiniJava.g:169:3: ( rule__TypeDeclaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclarationAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:170:3: ( rule__TypeDeclaration__Alternatives )
            // InternalMiniJava.g:170:4: rule__TypeDeclaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclarationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleClazz"
    // InternalMiniJava.g:179:1: entryRuleClazz : ruleClazz EOF ;
    public final void entryRuleClazz() throws RecognitionException {
        try {
            // InternalMiniJava.g:180:1: ( ruleClazz EOF )
            // InternalMiniJava.g:181:1: ruleClazz EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClazz();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClazz"


    // $ANTLR start "ruleClazz"
    // InternalMiniJava.g:188:1: ruleClazz : ( ( rule__Clazz__Group__0 ) ) ;
    public final void ruleClazz() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:192:2: ( ( ( rule__Clazz__Group__0 ) ) )
            // InternalMiniJava.g:193:2: ( ( rule__Clazz__Group__0 ) )
            {
            // InternalMiniJava.g:193:2: ( ( rule__Clazz__Group__0 ) )
            // InternalMiniJava.g:194:3: ( rule__Clazz__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getGroup()); 
            }
            // InternalMiniJava.g:195:3: ( rule__Clazz__Group__0 )
            // InternalMiniJava.g:195:4: rule__Clazz__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClazz"


    // $ANTLR start "entryRuleInterface"
    // InternalMiniJava.g:204:1: entryRuleInterface : ruleInterface EOF ;
    public final void entryRuleInterface() throws RecognitionException {
        try {
            // InternalMiniJava.g:205:1: ( ruleInterface EOF )
            // InternalMiniJava.g:206:1: ruleInterface EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInterface();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInterface"


    // $ANTLR start "ruleInterface"
    // InternalMiniJava.g:213:1: ruleInterface : ( ( rule__Interface__Group__0 ) ) ;
    public final void ruleInterface() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:217:2: ( ( ( rule__Interface__Group__0 ) ) )
            // InternalMiniJava.g:218:2: ( ( rule__Interface__Group__0 ) )
            {
            // InternalMiniJava.g:218:2: ( ( rule__Interface__Group__0 ) )
            // InternalMiniJava.g:219:3: ( rule__Interface__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getGroup()); 
            }
            // InternalMiniJava.g:220:3: ( rule__Interface__Group__0 )
            // InternalMiniJava.g:220:4: rule__Interface__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Interface__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInterface"


    // $ANTLR start "entryRuleMember"
    // InternalMiniJava.g:229:1: entryRuleMember : ruleMember EOF ;
    public final void entryRuleMember() throws RecognitionException {
        try {
            // InternalMiniJava.g:230:1: ( ruleMember EOF )
            // InternalMiniJava.g:231:1: ruleMember EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMember();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMemberRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // InternalMiniJava.g:238:1: ruleMember : ( ( rule__Member__Alternatives ) ) ;
    public final void ruleMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:242:2: ( ( ( rule__Member__Alternatives ) ) )
            // InternalMiniJava.g:243:2: ( ( rule__Member__Alternatives ) )
            {
            // InternalMiniJava.g:243:2: ( ( rule__Member__Alternatives ) )
            // InternalMiniJava.g:244:3: ( rule__Member__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMemberAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:245:3: ( rule__Member__Alternatives )
            // InternalMiniJava.g:245:4: rule__Member__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Member__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMemberAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleMethod"
    // InternalMiniJava.g:254:1: entryRuleMethod : ruleMethod EOF ;
    public final void entryRuleMethod() throws RecognitionException {
        try {
            // InternalMiniJava.g:255:1: ( ruleMethod EOF )
            // InternalMiniJava.g:256:1: ruleMethod EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMethod();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // InternalMiniJava.g:263:1: ruleMethod : ( ( rule__Method__Group__0 ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:267:2: ( ( ( rule__Method__Group__0 ) ) )
            // InternalMiniJava.g:268:2: ( ( rule__Method__Group__0 ) )
            {
            // InternalMiniJava.g:268:2: ( ( rule__Method__Group__0 ) )
            // InternalMiniJava.g:269:3: ( rule__Method__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup()); 
            }
            // InternalMiniJava.g:270:3: ( rule__Method__Group__0 )
            // InternalMiniJava.g:270:4: rule__Method__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Method__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleParameter"
    // InternalMiniJava.g:279:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalMiniJava.g:280:1: ( ruleParameter EOF )
            // InternalMiniJava.g:281:1: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMiniJava.g:288:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:292:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalMiniJava.g:293:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalMiniJava.g:293:2: ( ( rule__Parameter__Group__0 ) )
            // InternalMiniJava.g:294:3: ( rule__Parameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // InternalMiniJava.g:295:3: ( rule__Parameter__Group__0 )
            // InternalMiniJava.g:295:4: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleField"
    // InternalMiniJava.g:304:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalMiniJava.g:305:1: ( ruleField EOF )
            // InternalMiniJava.g:306:1: ruleField EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalMiniJava.g:313:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:317:2: ( ( ( rule__Field__Group__0 ) ) )
            // InternalMiniJava.g:318:2: ( ( rule__Field__Group__0 ) )
            {
            // InternalMiniJava.g:318:2: ( ( rule__Field__Group__0 ) )
            // InternalMiniJava.g:319:3: ( rule__Field__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup()); 
            }
            // InternalMiniJava.g:320:3: ( rule__Field__Group__0 )
            // InternalMiniJava.g:320:4: rule__Field__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleBlock"
    // InternalMiniJava.g:329:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // InternalMiniJava.g:330:1: ( ruleBlock EOF )
            // InternalMiniJava.g:331:1: ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalMiniJava.g:338:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:342:2: ( ( ( rule__Block__Group__0 ) ) )
            // InternalMiniJava.g:343:2: ( ( rule__Block__Group__0 ) )
            {
            // InternalMiniJava.g:343:2: ( ( rule__Block__Group__0 ) )
            // InternalMiniJava.g:344:3: ( rule__Block__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getGroup()); 
            }
            // InternalMiniJava.g:345:3: ( rule__Block__Group__0 )
            // InternalMiniJava.g:345:4: rule__Block__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // InternalMiniJava.g:354:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalMiniJava.g:355:1: ( ruleStatement EOF )
            // InternalMiniJava.g:356:1: ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalMiniJava.g:363:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:367:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalMiniJava.g:368:2: ( ( rule__Statement__Alternatives ) )
            {
            // InternalMiniJava.g:368:2: ( ( rule__Statement__Alternatives ) )
            // InternalMiniJava.g:369:3: ( rule__Statement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:370:3: ( rule__Statement__Alternatives )
            // InternalMiniJava.g:370:4: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePrintStatement"
    // InternalMiniJava.g:379:1: entryRulePrintStatement : rulePrintStatement EOF ;
    public final void entryRulePrintStatement() throws RecognitionException {
        try {
            // InternalMiniJava.g:380:1: ( rulePrintStatement EOF )
            // InternalMiniJava.g:381:1: rulePrintStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrintStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrintStatement"


    // $ANTLR start "rulePrintStatement"
    // InternalMiniJava.g:388:1: rulePrintStatement : ( ( rule__PrintStatement__Group__0 ) ) ;
    public final void rulePrintStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:392:2: ( ( ( rule__PrintStatement__Group__0 ) ) )
            // InternalMiniJava.g:393:2: ( ( rule__PrintStatement__Group__0 ) )
            {
            // InternalMiniJava.g:393:2: ( ( rule__PrintStatement__Group__0 ) )
            // InternalMiniJava.g:394:3: ( rule__PrintStatement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getGroup()); 
            }
            // InternalMiniJava.g:395:3: ( rule__PrintStatement__Group__0 )
            // InternalMiniJava.g:395:4: rule__PrintStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrintStatement"


    // $ANTLR start "entryRuleReturn"
    // InternalMiniJava.g:404:1: entryRuleReturn : ruleReturn EOF ;
    public final void entryRuleReturn() throws RecognitionException {
        try {
            // InternalMiniJava.g:405:1: ( ruleReturn EOF )
            // InternalMiniJava.g:406:1: ruleReturn EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReturnRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleReturn();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReturnRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReturn"


    // $ANTLR start "ruleReturn"
    // InternalMiniJava.g:413:1: ruleReturn : ( ( rule__Return__Group__0 ) ) ;
    public final void ruleReturn() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:417:2: ( ( ( rule__Return__Group__0 ) ) )
            // InternalMiniJava.g:418:2: ( ( rule__Return__Group__0 ) )
            {
            // InternalMiniJava.g:418:2: ( ( rule__Return__Group__0 ) )
            // InternalMiniJava.g:419:3: ( rule__Return__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReturnAccess().getGroup()); 
            }
            // InternalMiniJava.g:420:3: ( rule__Return__Group__0 )
            // InternalMiniJava.g:420:4: rule__Return__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Return__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReturnAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReturn"


    // $ANTLR start "entryRuleIfStatement"
    // InternalMiniJava.g:429:1: entryRuleIfStatement : ruleIfStatement EOF ;
    public final void entryRuleIfStatement() throws RecognitionException {
        try {
            // InternalMiniJava.g:430:1: ( ruleIfStatement EOF )
            // InternalMiniJava.g:431:1: ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIfStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalMiniJava.g:438:1: ruleIfStatement : ( ( rule__IfStatement__Group__0 ) ) ;
    public final void ruleIfStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:442:2: ( ( ( rule__IfStatement__Group__0 ) ) )
            // InternalMiniJava.g:443:2: ( ( rule__IfStatement__Group__0 ) )
            {
            // InternalMiniJava.g:443:2: ( ( rule__IfStatement__Group__0 ) )
            // InternalMiniJava.g:444:3: ( rule__IfStatement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getGroup()); 
            }
            // InternalMiniJava.g:445:3: ( rule__IfStatement__Group__0 )
            // InternalMiniJava.g:445:4: rule__IfStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // InternalMiniJava.g:454:1: entryRuleWhileStatement : ruleWhileStatement EOF ;
    public final void entryRuleWhileStatement() throws RecognitionException {
        try {
            // InternalMiniJava.g:455:1: ( ruleWhileStatement EOF )
            // InternalMiniJava.g:456:1: ruleWhileStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleWhileStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // InternalMiniJava.g:463:1: ruleWhileStatement : ( ( rule__WhileStatement__Group__0 ) ) ;
    public final void ruleWhileStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:467:2: ( ( ( rule__WhileStatement__Group__0 ) ) )
            // InternalMiniJava.g:468:2: ( ( rule__WhileStatement__Group__0 ) )
            {
            // InternalMiniJava.g:468:2: ( ( rule__WhileStatement__Group__0 ) )
            // InternalMiniJava.g:469:3: ( rule__WhileStatement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getGroup()); 
            }
            // InternalMiniJava.g:470:3: ( rule__WhileStatement__Group__0 )
            // InternalMiniJava.g:470:4: rule__WhileStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleForStatement"
    // InternalMiniJava.g:479:1: entryRuleForStatement : ruleForStatement EOF ;
    public final void entryRuleForStatement() throws RecognitionException {
        try {
            // InternalMiniJava.g:480:1: ( ruleForStatement EOF )
            // InternalMiniJava.g:481:1: ruleForStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleForStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalMiniJava.g:488:1: ruleForStatement : ( ( rule__ForStatement__Group__0 ) ) ;
    public final void ruleForStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:492:2: ( ( ( rule__ForStatement__Group__0 ) ) )
            // InternalMiniJava.g:493:2: ( ( rule__ForStatement__Group__0 ) )
            {
            // InternalMiniJava.g:493:2: ( ( rule__ForStatement__Group__0 ) )
            // InternalMiniJava.g:494:3: ( rule__ForStatement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getGroup()); 
            }
            // InternalMiniJava.g:495:3: ( rule__ForStatement__Group__0 )
            // InternalMiniJava.g:495:4: rule__ForStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleTypeRef"
    // InternalMiniJava.g:504:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalMiniJava.g:505:1: ( ruleTypeRef EOF )
            // InternalMiniJava.g:506:1: ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalMiniJava.g:513:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:517:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalMiniJava.g:518:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalMiniJava.g:518:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalMiniJava.g:519:3: ( rule__TypeRef__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getGroup()); 
            }
            // InternalMiniJava.g:520:3: ( rule__TypeRef__Group__0 )
            // InternalMiniJava.g:520:4: rule__TypeRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSingleTypeRef"
    // InternalMiniJava.g:529:1: entryRuleSingleTypeRef : ruleSingleTypeRef EOF ;
    public final void entryRuleSingleTypeRef() throws RecognitionException {
        try {
            // InternalMiniJava.g:530:1: ( ruleSingleTypeRef EOF )
            // InternalMiniJava.g:531:1: ruleSingleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSingleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSingleTypeRef"


    // $ANTLR start "ruleSingleTypeRef"
    // InternalMiniJava.g:538:1: ruleSingleTypeRef : ( ( rule__SingleTypeRef__Alternatives ) ) ;
    public final void ruleSingleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:542:2: ( ( ( rule__SingleTypeRef__Alternatives ) ) )
            // InternalMiniJava.g:543:2: ( ( rule__SingleTypeRef__Alternatives ) )
            {
            // InternalMiniJava.g:543:2: ( ( rule__SingleTypeRef__Alternatives ) )
            // InternalMiniJava.g:544:3: ( rule__SingleTypeRef__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:545:3: ( rule__SingleTypeRef__Alternatives )
            // InternalMiniJava.g:545:4: rule__SingleTypeRef__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSingleTypeRef"


    // $ANTLR start "entryRuleClassRef"
    // InternalMiniJava.g:554:1: entryRuleClassRef : ruleClassRef EOF ;
    public final void entryRuleClassRef() throws RecognitionException {
        try {
            // InternalMiniJava.g:555:1: ( ruleClassRef EOF )
            // InternalMiniJava.g:556:1: ruleClassRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassRef"


    // $ANTLR start "ruleClassRef"
    // InternalMiniJava.g:563:1: ruleClassRef : ( ( rule__ClassRef__ReferencedClassAssignment ) ) ;
    public final void ruleClassRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:567:2: ( ( ( rule__ClassRef__ReferencedClassAssignment ) ) )
            // InternalMiniJava.g:568:2: ( ( rule__ClassRef__ReferencedClassAssignment ) )
            {
            // InternalMiniJava.g:568:2: ( ( rule__ClassRef__ReferencedClassAssignment ) )
            // InternalMiniJava.g:569:3: ( rule__ClassRef__ReferencedClassAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassRefAccess().getReferencedClassAssignment()); 
            }
            // InternalMiniJava.g:570:3: ( rule__ClassRef__ReferencedClassAssignment )
            // InternalMiniJava.g:570:4: rule__ClassRef__ReferencedClassAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ClassRef__ReferencedClassAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassRefAccess().getReferencedClassAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassRef"


    // $ANTLR start "entryRuleTypedDeclaration"
    // InternalMiniJava.g:579:1: entryRuleTypedDeclaration : ruleTypedDeclaration EOF ;
    public final void entryRuleTypedDeclaration() throws RecognitionException {
        try {
            // InternalMiniJava.g:580:1: ( ruleTypedDeclaration EOF )
            // InternalMiniJava.g:581:1: ruleTypedDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypedDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypedDeclaration"


    // $ANTLR start "ruleTypedDeclaration"
    // InternalMiniJava.g:588:1: ruleTypedDeclaration : ( ( rule__TypedDeclaration__Alternatives ) ) ;
    public final void ruleTypedDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:592:2: ( ( ( rule__TypedDeclaration__Alternatives ) ) )
            // InternalMiniJava.g:593:2: ( ( rule__TypedDeclaration__Alternatives ) )
            {
            // InternalMiniJava.g:593:2: ( ( rule__TypedDeclaration__Alternatives ) )
            // InternalMiniJava.g:594:3: ( rule__TypedDeclaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDeclarationAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:595:3: ( rule__TypedDeclaration__Alternatives )
            // InternalMiniJava.g:595:4: rule__TypedDeclaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypedDeclaration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDeclarationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedDeclaration"


    // $ANTLR start "entryRuleSymbol"
    // InternalMiniJava.g:604:1: entryRuleSymbol : ruleSymbol EOF ;
    public final void entryRuleSymbol() throws RecognitionException {
        try {
            // InternalMiniJava.g:605:1: ( ruleSymbol EOF )
            // InternalMiniJava.g:606:1: ruleSymbol EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSymbolRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSymbol();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSymbolRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSymbol"


    // $ANTLR start "ruleSymbol"
    // InternalMiniJava.g:613:1: ruleSymbol : ( ( rule__Symbol__Alternatives ) ) ;
    public final void ruleSymbol() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:617:2: ( ( ( rule__Symbol__Alternatives ) ) )
            // InternalMiniJava.g:618:2: ( ( rule__Symbol__Alternatives ) )
            {
            // InternalMiniJava.g:618:2: ( ( rule__Symbol__Alternatives ) )
            // InternalMiniJava.g:619:3: ( rule__Symbol__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSymbolAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:620:3: ( rule__Symbol__Alternatives )
            // InternalMiniJava.g:620:4: rule__Symbol__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Symbol__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSymbolAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSymbol"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalMiniJava.g:629:1: entryRuleVariableDeclaration : ruleVariableDeclaration EOF ;
    public final void entryRuleVariableDeclaration() throws RecognitionException {
        try {
            // InternalMiniJava.g:630:1: ( ruleVariableDeclaration EOF )
            // InternalMiniJava.g:631:1: ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalMiniJava.g:638:1: ruleVariableDeclaration : ( ( rule__VariableDeclaration__Group__0 ) ) ;
    public final void ruleVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:642:2: ( ( ( rule__VariableDeclaration__Group__0 ) ) )
            // InternalMiniJava.g:643:2: ( ( rule__VariableDeclaration__Group__0 ) )
            {
            // InternalMiniJava.g:643:2: ( ( rule__VariableDeclaration__Group__0 ) )
            // InternalMiniJava.g:644:3: ( rule__VariableDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            }
            // InternalMiniJava.g:645:3: ( rule__VariableDeclaration__Group__0 )
            // InternalMiniJava.g:645:4: rule__VariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleAssignment"
    // InternalMiniJava.g:654:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalMiniJava.g:655:1: ( ruleAssignment EOF )
            // InternalMiniJava.g:656:1: ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalMiniJava.g:663:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:667:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalMiniJava.g:668:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalMiniJava.g:668:2: ( ( rule__Assignment__Group__0 ) )
            // InternalMiniJava.g:669:3: ( rule__Assignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getGroup()); 
            }
            // InternalMiniJava.g:670:3: ( rule__Assignment__Group__0 )
            // InternalMiniJava.g:670:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignee"
    // InternalMiniJava.g:679:1: entryRuleAssignee : ruleAssignee EOF ;
    public final void entryRuleAssignee() throws RecognitionException {
        try {
            // InternalMiniJava.g:680:1: ( ruleAssignee EOF )
            // InternalMiniJava.g:681:1: ruleAssignee EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssigneeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAssignee();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssigneeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignee"


    // $ANTLR start "ruleAssignee"
    // InternalMiniJava.g:688:1: ruleAssignee : ( ( rule__Assignee__Alternatives ) ) ;
    public final void ruleAssignee() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:692:2: ( ( ( rule__Assignee__Alternatives ) ) )
            // InternalMiniJava.g:693:2: ( ( rule__Assignee__Alternatives ) )
            {
            // InternalMiniJava.g:693:2: ( ( rule__Assignee__Alternatives ) )
            // InternalMiniJava.g:694:3: ( rule__Assignee__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssigneeAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:695:3: ( rule__Assignee__Alternatives )
            // InternalMiniJava.g:695:4: rule__Assignee__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Assignee__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssigneeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignee"


    // $ANTLR start "entryRuleExpression"
    // InternalMiniJava.g:704:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalMiniJava.g:705:1: ( ruleExpression EOF )
            // InternalMiniJava.g:706:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMiniJava.g:713:1: ruleExpression : ( ruleOr ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:717:2: ( ( ruleOr ) )
            // InternalMiniJava.g:718:2: ( ruleOr )
            {
            // InternalMiniJava.g:718:2: ( ruleOr )
            // InternalMiniJava.g:719:3: ruleOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalMiniJava.g:729:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalMiniJava.g:730:1: ( ruleOr EOF )
            // InternalMiniJava.g:731:1: ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalMiniJava.g:738:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:742:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalMiniJava.g:743:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalMiniJava.g:743:2: ( ( rule__Or__Group__0 ) )
            // InternalMiniJava.g:744:3: ( rule__Or__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup()); 
            }
            // InternalMiniJava.g:745:3: ( rule__Or__Group__0 )
            // InternalMiniJava.g:745:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalMiniJava.g:754:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalMiniJava.g:755:1: ( ruleAnd EOF )
            // InternalMiniJava.g:756:1: ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalMiniJava.g:763:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:767:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalMiniJava.g:768:2: ( ( rule__And__Group__0 ) )
            {
            // InternalMiniJava.g:768:2: ( ( rule__And__Group__0 ) )
            // InternalMiniJava.g:769:3: ( rule__And__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup()); 
            }
            // InternalMiniJava.g:770:3: ( rule__And__Group__0 )
            // InternalMiniJava.g:770:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalMiniJava.g:779:1: entryRuleEquality : ruleEquality EOF ;
    public final void entryRuleEquality() throws RecognitionException {
        try {
            // InternalMiniJava.g:780:1: ( ruleEquality EOF )
            // InternalMiniJava.g:781:1: ruleEquality EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalMiniJava.g:788:1: ruleEquality : ( ( rule__Equality__Group__0 ) ) ;
    public final void ruleEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:792:2: ( ( ( rule__Equality__Group__0 ) ) )
            // InternalMiniJava.g:793:2: ( ( rule__Equality__Group__0 ) )
            {
            // InternalMiniJava.g:793:2: ( ( rule__Equality__Group__0 ) )
            // InternalMiniJava.g:794:3: ( rule__Equality__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getGroup()); 
            }
            // InternalMiniJava.g:795:3: ( rule__Equality__Group__0 )
            // InternalMiniJava.g:795:4: rule__Equality__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalMiniJava.g:804:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalMiniJava.g:805:1: ( ruleComparison EOF )
            // InternalMiniJava.g:806:1: ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalMiniJava.g:813:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:817:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalMiniJava.g:818:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalMiniJava.g:818:2: ( ( rule__Comparison__Group__0 ) )
            // InternalMiniJava.g:819:3: ( rule__Comparison__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup()); 
            }
            // InternalMiniJava.g:820:3: ( rule__Comparison__Group__0 )
            // InternalMiniJava.g:820:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleModulo"
    // InternalMiniJava.g:829:1: entryRuleModulo : ruleModulo EOF ;
    public final void entryRuleModulo() throws RecognitionException {
        try {
            // InternalMiniJava.g:830:1: ( ruleModulo EOF )
            // InternalMiniJava.g:831:1: ruleModulo EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModulo"


    // $ANTLR start "ruleModulo"
    // InternalMiniJava.g:838:1: ruleModulo : ( ( rule__Modulo__Group__0 ) ) ;
    public final void ruleModulo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:842:2: ( ( ( rule__Modulo__Group__0 ) ) )
            // InternalMiniJava.g:843:2: ( ( rule__Modulo__Group__0 ) )
            {
            // InternalMiniJava.g:843:2: ( ( rule__Modulo__Group__0 ) )
            // InternalMiniJava.g:844:3: ( rule__Modulo__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getGroup()); 
            }
            // InternalMiniJava.g:845:3: ( rule__Modulo__Group__0 )
            // InternalMiniJava.g:845:4: rule__Modulo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModulo"


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalMiniJava.g:854:1: entryRulePlusOrMinus : rulePlusOrMinus EOF ;
    public final void entryRulePlusOrMinus() throws RecognitionException {
        try {
            // InternalMiniJava.g:855:1: ( rulePlusOrMinus EOF )
            // InternalMiniJava.g:856:1: rulePlusOrMinus EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalMiniJava.g:863:1: rulePlusOrMinus : ( ( rule__PlusOrMinus__Group__0 ) ) ;
    public final void rulePlusOrMinus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:867:2: ( ( ( rule__PlusOrMinus__Group__0 ) ) )
            // InternalMiniJava.g:868:2: ( ( rule__PlusOrMinus__Group__0 ) )
            {
            // InternalMiniJava.g:868:2: ( ( rule__PlusOrMinus__Group__0 ) )
            // InternalMiniJava.g:869:3: ( rule__PlusOrMinus__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getGroup()); 
            }
            // InternalMiniJava.g:870:3: ( rule__PlusOrMinus__Group__0 )
            // InternalMiniJava.g:870:4: rule__PlusOrMinus__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalMiniJava.g:879:1: entryRuleMulOrDiv : ruleMulOrDiv EOF ;
    public final void entryRuleMulOrDiv() throws RecognitionException {
        try {
            // InternalMiniJava.g:880:1: ( ruleMulOrDiv EOF )
            // InternalMiniJava.g:881:1: ruleMulOrDiv EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalMiniJava.g:888:1: ruleMulOrDiv : ( ( rule__MulOrDiv__Group__0 ) ) ;
    public final void ruleMulOrDiv() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:892:2: ( ( ( rule__MulOrDiv__Group__0 ) ) )
            // InternalMiniJava.g:893:2: ( ( rule__MulOrDiv__Group__0 ) )
            {
            // InternalMiniJava.g:893:2: ( ( rule__MulOrDiv__Group__0 ) )
            // InternalMiniJava.g:894:3: ( rule__MulOrDiv__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getGroup()); 
            }
            // InternalMiniJava.g:895:3: ( rule__MulOrDiv__Group__0 )
            // InternalMiniJava.g:895:4: rule__MulOrDiv__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleArrayAccess"
    // InternalMiniJava.g:904:1: entryRuleArrayAccess : ruleArrayAccess EOF ;
    public final void entryRuleArrayAccess() throws RecognitionException {
        try {
            // InternalMiniJava.g:905:1: ( ruleArrayAccess EOF )
            // InternalMiniJava.g:906:1: ruleArrayAccess EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrayAccess"


    // $ANTLR start "ruleArrayAccess"
    // InternalMiniJava.g:913:1: ruleArrayAccess : ( ( rule__ArrayAccess__Group__0 ) ) ;
    public final void ruleArrayAccess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:917:2: ( ( ( rule__ArrayAccess__Group__0 ) ) )
            // InternalMiniJava.g:918:2: ( ( rule__ArrayAccess__Group__0 ) )
            {
            // InternalMiniJava.g:918:2: ( ( rule__ArrayAccess__Group__0 ) )
            // InternalMiniJava.g:919:3: ( rule__ArrayAccess__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getGroup()); 
            }
            // InternalMiniJava.g:920:3: ( rule__ArrayAccess__Group__0 )
            // InternalMiniJava.g:920:4: rule__ArrayAccess__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrayAccess"


    // $ANTLR start "entryRuleArrayLength"
    // InternalMiniJava.g:929:1: entryRuleArrayLength : ruleArrayLength EOF ;
    public final void entryRuleArrayLength() throws RecognitionException {
        try {
            // InternalMiniJava.g:930:1: ( ruleArrayLength EOF )
            // InternalMiniJava.g:931:1: ruleArrayLength EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayLength();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrayLength"


    // $ANTLR start "ruleArrayLength"
    // InternalMiniJava.g:938:1: ruleArrayLength : ( ( rule__ArrayLength__Group__0 ) ) ;
    public final void ruleArrayLength() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:942:2: ( ( ( rule__ArrayLength__Group__0 ) ) )
            // InternalMiniJava.g:943:2: ( ( rule__ArrayLength__Group__0 ) )
            {
            // InternalMiniJava.g:943:2: ( ( rule__ArrayLength__Group__0 ) )
            // InternalMiniJava.g:944:3: ( rule__ArrayLength__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getGroup()); 
            }
            // InternalMiniJava.g:945:3: ( rule__ArrayLength__Group__0 )
            // InternalMiniJava.g:945:4: rule__ArrayLength__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrayLength"


    // $ANTLR start "entryRulePrimary"
    // InternalMiniJava.g:954:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalMiniJava.g:955:1: ( rulePrimary EOF )
            // InternalMiniJava.g:956:1: rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalMiniJava.g:963:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:967:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalMiniJava.g:968:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalMiniJava.g:968:2: ( ( rule__Primary__Alternatives ) )
            // InternalMiniJava.g:969:3: ( rule__Primary__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:970:3: ( rule__Primary__Alternatives )
            // InternalMiniJava.g:970:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleSelectionExpression"
    // InternalMiniJava.g:979:1: entryRuleSelectionExpression : ruleSelectionExpression EOF ;
    public final void entryRuleSelectionExpression() throws RecognitionException {
        try {
            // InternalMiniJava.g:980:1: ( ruleSelectionExpression EOF )
            // InternalMiniJava.g:981:1: ruleSelectionExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSelectionExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelectionExpression"


    // $ANTLR start "ruleSelectionExpression"
    // InternalMiniJava.g:988:1: ruleSelectionExpression : ( ( rule__SelectionExpression__Group__0 ) ) ;
    public final void ruleSelectionExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:992:2: ( ( ( rule__SelectionExpression__Group__0 ) ) )
            // InternalMiniJava.g:993:2: ( ( rule__SelectionExpression__Group__0 ) )
            {
            // InternalMiniJava.g:993:2: ( ( rule__SelectionExpression__Group__0 ) )
            // InternalMiniJava.g:994:3: ( rule__SelectionExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getGroup()); 
            }
            // InternalMiniJava.g:995:3: ( rule__SelectionExpression__Group__0 )
            // InternalMiniJava.g:995:4: rule__SelectionExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelectionExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalMiniJava.g:1004:1: entryRuleTerminalExpression : ruleTerminalExpression EOF ;
    public final void entryRuleTerminalExpression() throws RecognitionException {
        try {
            // InternalMiniJava.g:1005:1: ( ruleTerminalExpression EOF )
            // InternalMiniJava.g:1006:1: ruleTerminalExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalMiniJava.g:1013:1: ruleTerminalExpression : ( ( rule__TerminalExpression__Alternatives ) ) ;
    public final void ruleTerminalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1017:2: ( ( ( rule__TerminalExpression__Alternatives ) ) )
            // InternalMiniJava.g:1018:2: ( ( rule__TerminalExpression__Alternatives ) )
            {
            // InternalMiniJava.g:1018:2: ( ( rule__TerminalExpression__Alternatives ) )
            // InternalMiniJava.g:1019:3: ( rule__TerminalExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:1020:3: ( rule__TerminalExpression__Alternatives )
            // InternalMiniJava.g:1020:4: rule__TerminalExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "ruleAccessLevel"
    // InternalMiniJava.g:1029:1: ruleAccessLevel : ( ( rule__AccessLevel__Alternatives ) ) ;
    public final void ruleAccessLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1033:1: ( ( ( rule__AccessLevel__Alternatives ) ) )
            // InternalMiniJava.g:1034:2: ( ( rule__AccessLevel__Alternatives ) )
            {
            // InternalMiniJava.g:1034:2: ( ( rule__AccessLevel__Alternatives ) )
            // InternalMiniJava.g:1035:3: ( rule__AccessLevel__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccessLevelAccess().getAlternatives()); 
            }
            // InternalMiniJava.g:1036:3: ( rule__AccessLevel__Alternatives )
            // InternalMiniJava.g:1036:4: rule__AccessLevel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AccessLevel__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccessLevelAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAccessLevel"


    // $ANTLR start "rule__TypeDeclaration__Alternatives"
    // InternalMiniJava.g:1044:1: rule__TypeDeclaration__Alternatives : ( ( ruleClazz ) | ( ruleInterface ) );
    public final void rule__TypeDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1048:1: ( ( ruleClazz ) | ( ruleInterface ) )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 14:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==21||LA1_1==64) ) {
                    alt1=1;
                }
                else if ( (LA1_1==27) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==27) ) {
                    alt1=2;
                }
                else if ( (LA1_2==21||LA1_2==64) ) {
                    alt1=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==21||LA1_3==64) ) {
                    alt1=1;
                }
                else if ( (LA1_3==27) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
            case 64:
                {
                alt1=1;
                }
                break;
            case 27:
                {
                alt1=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMiniJava.g:1049:2: ( ruleClazz )
                    {
                    // InternalMiniJava.g:1049:2: ( ruleClazz )
                    // InternalMiniJava.g:1050:3: ruleClazz
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeDeclarationAccess().getClazzParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleClazz();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeDeclarationAccess().getClazzParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1055:2: ( ruleInterface )
                    {
                    // InternalMiniJava.g:1055:2: ( ruleInterface )
                    // InternalMiniJava.g:1056:3: ruleInterface
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeDeclarationAccess().getInterfaceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleInterface();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeDeclarationAccess().getInterfaceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Alternatives"


    // $ANTLR start "rule__Member__Alternatives"
    // InternalMiniJava.g:1065:1: rule__Member__Alternatives : ( ( ruleField ) | ( ruleMethod ) );
    public final void rule__Member__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1069:1: ( ( ruleField ) | ( ruleMethod ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalMiniJava.g:1070:2: ( ruleField )
                    {
                    // InternalMiniJava.g:1070:2: ( ruleField )
                    // InternalMiniJava.g:1071:3: ruleField
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMemberAccess().getFieldParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleField();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMemberAccess().getFieldParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1076:2: ( ruleMethod )
                    {
                    // InternalMiniJava.g:1076:2: ( ruleMethod )
                    // InternalMiniJava.g:1077:3: ruleMethod
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMemberAccess().getMethodParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMethod();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMemberAccess().getMethodParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Alternatives"


    // $ANTLR start "rule__Method__Alternatives_8"
    // InternalMiniJava.g:1086:1: rule__Method__Alternatives_8 : ( ( ( rule__Method__BodyAssignment_8_0 ) ) | ( ';' ) );
    public final void rule__Method__Alternatives_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1090:1: ( ( ( rule__Method__BodyAssignment_8_0 ) ) | ( ';' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMiniJava.g:1091:2: ( ( rule__Method__BodyAssignment_8_0 ) )
                    {
                    // InternalMiniJava.g:1091:2: ( ( rule__Method__BodyAssignment_8_0 ) )
                    // InternalMiniJava.g:1092:3: ( rule__Method__BodyAssignment_8_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMethodAccess().getBodyAssignment_8_0()); 
                    }
                    // InternalMiniJava.g:1093:3: ( rule__Method__BodyAssignment_8_0 )
                    // InternalMiniJava.g:1093:4: rule__Method__BodyAssignment_8_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__BodyAssignment_8_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMethodAccess().getBodyAssignment_8_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1097:2: ( ';' )
                    {
                    // InternalMiniJava.g:1097:2: ( ';' )
                    // InternalMiniJava.g:1098:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMethodAccess().getSemicolonKeyword_8_1()); 
                    }
                    match(input,11,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMethodAccess().getSemicolonKeyword_8_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Alternatives_8"


    // $ANTLR start "rule__Statement__Alternatives"
    // InternalMiniJava.g:1107:1: rule__Statement__Alternatives : ( ( ( rule__Statement__Group_0__0 ) ) | ( ( rule__Statement__Group_1__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleForStatement ) | ( ( rule__Statement__Group_5__0 ) ) | ( ruleBlock ) | ( ( rule__Statement__Group_7__0 ) ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1111:1: ( ( ( rule__Statement__Group_0__0 ) ) | ( ( rule__Statement__Group_1__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleForStatement ) | ( ( rule__Statement__Group_5__0 ) ) | ( ruleBlock ) | ( ( rule__Statement__Group_7__0 ) ) )
            int alt4=8;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalMiniJava.g:1112:2: ( ( rule__Statement__Group_0__0 ) )
                    {
                    // InternalMiniJava.g:1112:2: ( ( rule__Statement__Group_0__0 ) )
                    // InternalMiniJava.g:1113:3: ( rule__Statement__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_0()); 
                    }
                    // InternalMiniJava.g:1114:3: ( rule__Statement__Group_0__0 )
                    // InternalMiniJava.g:1114:4: rule__Statement__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1118:2: ( ( rule__Statement__Group_1__0 ) )
                    {
                    // InternalMiniJava.g:1118:2: ( ( rule__Statement__Group_1__0 ) )
                    // InternalMiniJava.g:1119:3: ( rule__Statement__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_1()); 
                    }
                    // InternalMiniJava.g:1120:3: ( rule__Statement__Group_1__0 )
                    // InternalMiniJava.g:1120:4: rule__Statement__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1124:2: ( ruleIfStatement )
                    {
                    // InternalMiniJava.g:1124:2: ( ruleIfStatement )
                    // InternalMiniJava.g:1125:3: ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniJava.g:1130:2: ( ruleWhileStatement )
                    {
                    // InternalMiniJava.g:1130:2: ( ruleWhileStatement )
                    // InternalMiniJava.g:1131:3: ruleWhileStatement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleWhileStatement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMiniJava.g:1136:2: ( ruleForStatement )
                    {
                    // InternalMiniJava.g:1136:2: ( ruleForStatement )
                    // InternalMiniJava.g:1137:3: ruleForStatement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getForStatementParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleForStatement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getForStatementParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMiniJava.g:1142:2: ( ( rule__Statement__Group_5__0 ) )
                    {
                    // InternalMiniJava.g:1142:2: ( ( rule__Statement__Group_5__0 ) )
                    // InternalMiniJava.g:1143:3: ( rule__Statement__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_5()); 
                    }
                    // InternalMiniJava.g:1144:3: ( rule__Statement__Group_5__0 )
                    // InternalMiniJava.g:1144:4: rule__Statement__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMiniJava.g:1148:2: ( ruleBlock )
                    {
                    // InternalMiniJava.g:1148:2: ( ruleBlock )
                    // InternalMiniJava.g:1149:3: ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getBlockParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBlock();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getBlockParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMiniJava.g:1154:2: ( ( rule__Statement__Group_7__0 ) )
                    {
                    // InternalMiniJava.g:1154:2: ( ( rule__Statement__Group_7__0 ) )
                    // InternalMiniJava.g:1155:3: ( rule__Statement__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_7()); 
                    }
                    // InternalMiniJava.g:1156:3: ( rule__Statement__Group_7__0 )
                    // InternalMiniJava.g:1156:4: rule__Statement__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__SingleTypeRef__Alternatives"
    // InternalMiniJava.g:1164:1: rule__SingleTypeRef__Alternatives : ( ( ruleClassRef ) | ( ( rule__SingleTypeRef__Group_1__0 ) ) | ( ( rule__SingleTypeRef__Group_2__0 ) ) | ( ( rule__SingleTypeRef__Group_3__0 ) ) | ( ( rule__SingleTypeRef__Group_4__0 ) ) );
    public final void rule__SingleTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1168:1: ( ( ruleClassRef ) | ( ( rule__SingleTypeRef__Group_1__0 ) ) | ( ( rule__SingleTypeRef__Group_2__0 ) ) | ( ( rule__SingleTypeRef__Group_3__0 ) ) | ( ( rule__SingleTypeRef__Group_4__0 ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 41:
                {
                alt5=2;
                }
                break;
            case 42:
                {
                alt5=3;
                }
                break;
            case 43:
                {
                alt5=4;
                }
                break;
            case 44:
                {
                alt5=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMiniJava.g:1169:2: ( ruleClassRef )
                    {
                    // InternalMiniJava.g:1169:2: ( ruleClassRef )
                    // InternalMiniJava.g:1170:3: ruleClassRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSingleTypeRefAccess().getClassRefParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleClassRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSingleTypeRefAccess().getClassRefParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1175:2: ( ( rule__SingleTypeRef__Group_1__0 ) )
                    {
                    // InternalMiniJava.g:1175:2: ( ( rule__SingleTypeRef__Group_1__0 ) )
                    // InternalMiniJava.g:1176:3: ( rule__SingleTypeRef__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSingleTypeRefAccess().getGroup_1()); 
                    }
                    // InternalMiniJava.g:1177:3: ( rule__SingleTypeRef__Group_1__0 )
                    // InternalMiniJava.g:1177:4: rule__SingleTypeRef__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleTypeRef__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSingleTypeRefAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1181:2: ( ( rule__SingleTypeRef__Group_2__0 ) )
                    {
                    // InternalMiniJava.g:1181:2: ( ( rule__SingleTypeRef__Group_2__0 ) )
                    // InternalMiniJava.g:1182:3: ( rule__SingleTypeRef__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSingleTypeRefAccess().getGroup_2()); 
                    }
                    // InternalMiniJava.g:1183:3: ( rule__SingleTypeRef__Group_2__0 )
                    // InternalMiniJava.g:1183:4: rule__SingleTypeRef__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleTypeRef__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSingleTypeRefAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniJava.g:1187:2: ( ( rule__SingleTypeRef__Group_3__0 ) )
                    {
                    // InternalMiniJava.g:1187:2: ( ( rule__SingleTypeRef__Group_3__0 ) )
                    // InternalMiniJava.g:1188:3: ( rule__SingleTypeRef__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSingleTypeRefAccess().getGroup_3()); 
                    }
                    // InternalMiniJava.g:1189:3: ( rule__SingleTypeRef__Group_3__0 )
                    // InternalMiniJava.g:1189:4: rule__SingleTypeRef__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleTypeRef__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSingleTypeRefAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMiniJava.g:1193:2: ( ( rule__SingleTypeRef__Group_4__0 ) )
                    {
                    // InternalMiniJava.g:1193:2: ( ( rule__SingleTypeRef__Group_4__0 ) )
                    // InternalMiniJava.g:1194:3: ( rule__SingleTypeRef__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSingleTypeRefAccess().getGroup_4()); 
                    }
                    // InternalMiniJava.g:1195:3: ( rule__SingleTypeRef__Group_4__0 )
                    // InternalMiniJava.g:1195:4: rule__SingleTypeRef__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleTypeRef__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSingleTypeRefAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Alternatives"


    // $ANTLR start "rule__TypedDeclaration__Alternatives"
    // InternalMiniJava.g:1203:1: rule__TypedDeclaration__Alternatives : ( ( ruleSymbol ) | ( ruleMember ) );
    public final void rule__TypedDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1207:1: ( ( ruleSymbol ) | ( ruleMember ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalMiniJava.g:1208:2: ( ruleSymbol )
                    {
                    // InternalMiniJava.g:1208:2: ( ruleSymbol )
                    // InternalMiniJava.g:1209:3: ruleSymbol
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypedDeclarationAccess().getSymbolParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSymbol();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypedDeclarationAccess().getSymbolParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1214:2: ( ruleMember )
                    {
                    // InternalMiniJava.g:1214:2: ( ruleMember )
                    // InternalMiniJava.g:1215:3: ruleMember
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypedDeclarationAccess().getMemberParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMember();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypedDeclarationAccess().getMemberParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDeclaration__Alternatives"


    // $ANTLR start "rule__Symbol__Alternatives"
    // InternalMiniJava.g:1224:1: rule__Symbol__Alternatives : ( ( ( ruleParameter ) ) | ( ruleVariableDeclaration ) );
    public final void rule__Symbol__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1228:1: ( ( ( ruleParameter ) ) | ( ruleVariableDeclaration ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalMiniJava.g:1229:2: ( ( ruleParameter ) )
                    {
                    // InternalMiniJava.g:1229:2: ( ( ruleParameter ) )
                    // InternalMiniJava.g:1230:3: ( ruleParameter )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSymbolAccess().getParameterParserRuleCall_0()); 
                    }
                    // InternalMiniJava.g:1231:3: ( ruleParameter )
                    // InternalMiniJava.g:1231:4: ruleParameter
                    {
                    pushFollow(FOLLOW_2);
                    ruleParameter();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSymbolAccess().getParameterParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1235:2: ( ruleVariableDeclaration )
                    {
                    // InternalMiniJava.g:1235:2: ( ruleVariableDeclaration )
                    // InternalMiniJava.g:1236:3: ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSymbolAccess().getVariableDeclarationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSymbolAccess().getVariableDeclarationParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Symbol__Alternatives"


    // $ANTLR start "rule__Assignee__Alternatives"
    // InternalMiniJava.g:1245:1: rule__Assignee__Alternatives : ( ( ( ruleArrayAccess ) ) | ( ruleVariableDeclaration ) );
    public final void rule__Assignee__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1249:1: ( ( ( ruleArrayAccess ) ) | ( ruleVariableDeclaration ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalMiniJava.g:1250:2: ( ( ruleArrayAccess ) )
                    {
                    // InternalMiniJava.g:1250:2: ( ( ruleArrayAccess ) )
                    // InternalMiniJava.g:1251:3: ( ruleArrayAccess )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssigneeAccess().getArrayAccessParserRuleCall_0()); 
                    }
                    // InternalMiniJava.g:1252:3: ( ruleArrayAccess )
                    // InternalMiniJava.g:1252:4: ruleArrayAccess
                    {
                    pushFollow(FOLLOW_2);
                    ruleArrayAccess();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssigneeAccess().getArrayAccessParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1256:2: ( ruleVariableDeclaration )
                    {
                    // InternalMiniJava.g:1256:2: ( ruleVariableDeclaration )
                    // InternalMiniJava.g:1257:3: ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssigneeAccess().getVariableDeclarationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssigneeAccess().getVariableDeclarationParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignee__Alternatives"


    // $ANTLR start "rule__Equality__Alternatives_1_0"
    // InternalMiniJava.g:1266:1: rule__Equality__Alternatives_1_0 : ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) );
    public final void rule__Equality__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1270:1: ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==47) ) {
                alt9=1;
            }
            else if ( (LA9_0==48) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalMiniJava.g:1271:2: ( ( rule__Equality__Group_1_0_0__0 ) )
                    {
                    // InternalMiniJava.g:1271:2: ( ( rule__Equality__Group_1_0_0__0 ) )
                    // InternalMiniJava.g:1272:3: ( rule__Equality__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 
                    }
                    // InternalMiniJava.g:1273:3: ( rule__Equality__Group_1_0_0__0 )
                    // InternalMiniJava.g:1273:4: rule__Equality__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Equality__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1277:2: ( ( rule__Equality__Group_1_0_1__0 ) )
                    {
                    // InternalMiniJava.g:1277:2: ( ( rule__Equality__Group_1_0_1__0 ) )
                    // InternalMiniJava.g:1278:3: ( rule__Equality__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 
                    }
                    // InternalMiniJava.g:1279:3: ( rule__Equality__Group_1_0_1__0 )
                    // InternalMiniJava.g:1279:4: rule__Equality__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Equality__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Alternatives_1_0"


    // $ANTLR start "rule__Comparison__Alternatives_1_0"
    // InternalMiniJava.g:1287:1: rule__Comparison__Alternatives_1_0 : ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) );
    public final void rule__Comparison__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1291:1: ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt10=1;
                }
                break;
            case 50:
                {
                alt10=2;
                }
                break;
            case 51:
                {
                alt10=3;
                }
                break;
            case 52:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalMiniJava.g:1292:2: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    {
                    // InternalMiniJava.g:1292:2: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    // InternalMiniJava.g:1293:3: ( rule__Comparison__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 
                    }
                    // InternalMiniJava.g:1294:3: ( rule__Comparison__Group_1_0_0__0 )
                    // InternalMiniJava.g:1294:4: rule__Comparison__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1298:2: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    {
                    // InternalMiniJava.g:1298:2: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    // InternalMiniJava.g:1299:3: ( rule__Comparison__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 
                    }
                    // InternalMiniJava.g:1300:3: ( rule__Comparison__Group_1_0_1__0 )
                    // InternalMiniJava.g:1300:4: rule__Comparison__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1304:2: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    {
                    // InternalMiniJava.g:1304:2: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    // InternalMiniJava.g:1305:3: ( rule__Comparison__Group_1_0_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 
                    }
                    // InternalMiniJava.g:1306:3: ( rule__Comparison__Group_1_0_2__0 )
                    // InternalMiniJava.g:1306:4: rule__Comparison__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__Group_1_0_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniJava.g:1310:2: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    {
                    // InternalMiniJava.g:1310:2: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    // InternalMiniJava.g:1311:3: ( rule__Comparison__Group_1_0_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 
                    }
                    // InternalMiniJava.g:1312:3: ( rule__Comparison__Group_1_0_3__0 )
                    // InternalMiniJava.g:1312:4: rule__Comparison__Group_1_0_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__Group_1_0_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Alternatives_1_0"


    // $ANTLR start "rule__PlusOrMinus__Alternatives_1_0"
    // InternalMiniJava.g:1320:1: rule__PlusOrMinus__Alternatives_1_0 : ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) );
    public final void rule__PlusOrMinus__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1324:1: ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==54) ) {
                alt11=1;
            }
            else if ( (LA11_0==55) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMiniJava.g:1325:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    {
                    // InternalMiniJava.g:1325:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    // InternalMiniJava.g:1326:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 
                    }
                    // InternalMiniJava.g:1327:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    // InternalMiniJava.g:1327:4: rule__PlusOrMinus__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1331:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    {
                    // InternalMiniJava.g:1331:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    // InternalMiniJava.g:1332:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 
                    }
                    // InternalMiniJava.g:1333:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    // InternalMiniJava.g:1333:4: rule__PlusOrMinus__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Alternatives_1_0"


    // $ANTLR start "rule__MulOrDiv__Alternatives_1_0"
    // InternalMiniJava.g:1341:1: rule__MulOrDiv__Alternatives_1_0 : ( ( ( rule__MulOrDiv__Group_1_0_0__0 ) ) | ( ( rule__MulOrDiv__Group_1_0_1__0 ) ) );
    public final void rule__MulOrDiv__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1345:1: ( ( ( rule__MulOrDiv__Group_1_0_0__0 ) ) | ( ( rule__MulOrDiv__Group_1_0_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==56) ) {
                alt12=1;
            }
            else if ( (LA12_0==57) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMiniJava.g:1346:2: ( ( rule__MulOrDiv__Group_1_0_0__0 ) )
                    {
                    // InternalMiniJava.g:1346:2: ( ( rule__MulOrDiv__Group_1_0_0__0 ) )
                    // InternalMiniJava.g:1347:3: ( rule__MulOrDiv__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMulOrDivAccess().getGroup_1_0_0()); 
                    }
                    // InternalMiniJava.g:1348:3: ( rule__MulOrDiv__Group_1_0_0__0 )
                    // InternalMiniJava.g:1348:4: rule__MulOrDiv__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MulOrDiv__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMulOrDivAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1352:2: ( ( rule__MulOrDiv__Group_1_0_1__0 ) )
                    {
                    // InternalMiniJava.g:1352:2: ( ( rule__MulOrDiv__Group_1_0_1__0 ) )
                    // InternalMiniJava.g:1353:3: ( rule__MulOrDiv__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMulOrDivAccess().getGroup_1_0_1()); 
                    }
                    // InternalMiniJava.g:1354:3: ( rule__MulOrDiv__Group_1_0_1__0 )
                    // InternalMiniJava.g:1354:4: rule__MulOrDiv__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MulOrDiv__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMulOrDivAccess().getGroup_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Alternatives_1_0"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalMiniJava.g:1362:1: rule__Primary__Alternatives : ( ( ( rule__Primary__Group_0__0 ) ) | ( ( rule__Primary__Group_1__0 ) ) | ( ( rule__Primary__Group_2__0 ) ) | ( ruleSelectionExpression ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1366:1: ( ( ( rule__Primary__Group_0__0 ) ) | ( ( rule__Primary__Group_1__0 ) ) | ( ( rule__Primary__Group_2__0 ) ) | ( ruleSelectionExpression ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt13=1;
                }
                break;
            case 59:
                {
                alt13=2;
                }
                break;
            case 55:
                {
                alt13=3;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 12:
            case 13:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalMiniJava.g:1367:2: ( ( rule__Primary__Group_0__0 ) )
                    {
                    // InternalMiniJava.g:1367:2: ( ( rule__Primary__Group_0__0 ) )
                    // InternalMiniJava.g:1368:3: ( rule__Primary__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    }
                    // InternalMiniJava.g:1369:3: ( rule__Primary__Group_0__0 )
                    // InternalMiniJava.g:1369:4: rule__Primary__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1373:2: ( ( rule__Primary__Group_1__0 ) )
                    {
                    // InternalMiniJava.g:1373:2: ( ( rule__Primary__Group_1__0 ) )
                    // InternalMiniJava.g:1374:3: ( rule__Primary__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getGroup_1()); 
                    }
                    // InternalMiniJava.g:1375:3: ( rule__Primary__Group_1__0 )
                    // InternalMiniJava.g:1375:4: rule__Primary__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1379:2: ( ( rule__Primary__Group_2__0 ) )
                    {
                    // InternalMiniJava.g:1379:2: ( ( rule__Primary__Group_2__0 ) )
                    // InternalMiniJava.g:1380:3: ( rule__Primary__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getGroup_2()); 
                    }
                    // InternalMiniJava.g:1381:3: ( rule__Primary__Group_2__0 )
                    // InternalMiniJava.g:1381:4: rule__Primary__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniJava.g:1385:2: ( ruleSelectionExpression )
                    {
                    // InternalMiniJava.g:1385:2: ( ruleSelectionExpression )
                    // InternalMiniJava.g:1386:3: ruleSelectionExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getSelectionExpressionParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSelectionExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getSelectionExpressionParserRuleCall_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__SelectionExpression__Alternatives_1"
    // InternalMiniJava.g:1395:1: rule__SelectionExpression__Alternatives_1 : ( ( ( rule__SelectionExpression__Group_1_0__0 ) ) | ( ( rule__SelectionExpression__Group_1_1__0 ) ) );
    public final void rule__SelectionExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1399:1: ( ( ( rule__SelectionExpression__Group_1_0__0 ) ) | ( ( rule__SelectionExpression__Group_1_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_ID) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==EOF||LA14_2==11||LA14_2==19||LA14_2==26||(LA14_2>=29 && LA14_2<=30)||(LA14_2>=39 && LA14_2<=40)||(LA14_2>=45 && LA14_2<=57)) ) {
                        alt14=1;
                    }
                    else if ( (LA14_2==28) ) {
                        alt14=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMiniJava.g:1400:2: ( ( rule__SelectionExpression__Group_1_0__0 ) )
                    {
                    // InternalMiniJava.g:1400:2: ( ( rule__SelectionExpression__Group_1_0__0 ) )
                    // InternalMiniJava.g:1401:3: ( rule__SelectionExpression__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelectionExpressionAccess().getGroup_1_0()); 
                    }
                    // InternalMiniJava.g:1402:3: ( rule__SelectionExpression__Group_1_0__0 )
                    // InternalMiniJava.g:1402:4: rule__SelectionExpression__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SelectionExpression__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSelectionExpressionAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1406:2: ( ( rule__SelectionExpression__Group_1_1__0 ) )
                    {
                    // InternalMiniJava.g:1406:2: ( ( rule__SelectionExpression__Group_1_1__0 ) )
                    // InternalMiniJava.g:1407:3: ( rule__SelectionExpression__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelectionExpressionAccess().getGroup_1_1()); 
                    }
                    // InternalMiniJava.g:1408:3: ( rule__SelectionExpression__Group_1_1__0 )
                    // InternalMiniJava.g:1408:4: rule__SelectionExpression__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SelectionExpression__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSelectionExpressionAccess().getGroup_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Alternatives_1"


    // $ANTLR start "rule__TerminalExpression__Alternatives"
    // InternalMiniJava.g:1416:1: rule__TerminalExpression__Alternatives : ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__Group_1__0 ) ) | ( ( rule__TerminalExpression__Group_2__0 ) ) | ( ( rule__TerminalExpression__Group_3__0 ) ) | ( ( rule__TerminalExpression__Group_4__0 ) ) | ( ( rule__TerminalExpression__Group_5__0 ) ) | ( ( rule__TerminalExpression__Group_6__0 ) ) | ( ( rule__TerminalExpression__Group_7__0 ) ) | ( ( rule__TerminalExpression__Group_8__0 ) ) );
    public final void rule__TerminalExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1420:1: ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__Group_1__0 ) ) | ( ( rule__TerminalExpression__Group_2__0 ) ) | ( ( rule__TerminalExpression__Group_3__0 ) ) | ( ( rule__TerminalExpression__Group_4__0 ) ) | ( ( rule__TerminalExpression__Group_5__0 ) ) | ( ( rule__TerminalExpression__Group_6__0 ) ) | ( ( rule__TerminalExpression__Group_7__0 ) ) | ( ( rule__TerminalExpression__Group_8__0 ) ) )
            int alt15=9;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalMiniJava.g:1421:2: ( ( rule__TerminalExpression__Group_0__0 ) )
                    {
                    // InternalMiniJava.g:1421:2: ( ( rule__TerminalExpression__Group_0__0 ) )
                    // InternalMiniJava.g:1422:3: ( rule__TerminalExpression__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 
                    }
                    // InternalMiniJava.g:1423:3: ( rule__TerminalExpression__Group_0__0 )
                    // InternalMiniJava.g:1423:4: rule__TerminalExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1427:2: ( ( rule__TerminalExpression__Group_1__0 ) )
                    {
                    // InternalMiniJava.g:1427:2: ( ( rule__TerminalExpression__Group_1__0 ) )
                    // InternalMiniJava.g:1428:3: ( rule__TerminalExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_1()); 
                    }
                    // InternalMiniJava.g:1429:3: ( rule__TerminalExpression__Group_1__0 )
                    // InternalMiniJava.g:1429:4: rule__TerminalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1433:2: ( ( rule__TerminalExpression__Group_2__0 ) )
                    {
                    // InternalMiniJava.g:1433:2: ( ( rule__TerminalExpression__Group_2__0 ) )
                    // InternalMiniJava.g:1434:3: ( rule__TerminalExpression__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_2()); 
                    }
                    // InternalMiniJava.g:1435:3: ( rule__TerminalExpression__Group_2__0 )
                    // InternalMiniJava.g:1435:4: rule__TerminalExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniJava.g:1439:2: ( ( rule__TerminalExpression__Group_3__0 ) )
                    {
                    // InternalMiniJava.g:1439:2: ( ( rule__TerminalExpression__Group_3__0 ) )
                    // InternalMiniJava.g:1440:3: ( rule__TerminalExpression__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_3()); 
                    }
                    // InternalMiniJava.g:1441:3: ( rule__TerminalExpression__Group_3__0 )
                    // InternalMiniJava.g:1441:4: rule__TerminalExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMiniJava.g:1445:2: ( ( rule__TerminalExpression__Group_4__0 ) )
                    {
                    // InternalMiniJava.g:1445:2: ( ( rule__TerminalExpression__Group_4__0 ) )
                    // InternalMiniJava.g:1446:3: ( rule__TerminalExpression__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_4()); 
                    }
                    // InternalMiniJava.g:1447:3: ( rule__TerminalExpression__Group_4__0 )
                    // InternalMiniJava.g:1447:4: rule__TerminalExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMiniJava.g:1451:2: ( ( rule__TerminalExpression__Group_5__0 ) )
                    {
                    // InternalMiniJava.g:1451:2: ( ( rule__TerminalExpression__Group_5__0 ) )
                    // InternalMiniJava.g:1452:3: ( rule__TerminalExpression__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_5()); 
                    }
                    // InternalMiniJava.g:1453:3: ( rule__TerminalExpression__Group_5__0 )
                    // InternalMiniJava.g:1453:4: rule__TerminalExpression__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMiniJava.g:1457:2: ( ( rule__TerminalExpression__Group_6__0 ) )
                    {
                    // InternalMiniJava.g:1457:2: ( ( rule__TerminalExpression__Group_6__0 ) )
                    // InternalMiniJava.g:1458:3: ( rule__TerminalExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_6()); 
                    }
                    // InternalMiniJava.g:1459:3: ( rule__TerminalExpression__Group_6__0 )
                    // InternalMiniJava.g:1459:4: rule__TerminalExpression__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMiniJava.g:1463:2: ( ( rule__TerminalExpression__Group_7__0 ) )
                    {
                    // InternalMiniJava.g:1463:2: ( ( rule__TerminalExpression__Group_7__0 ) )
                    // InternalMiniJava.g:1464:3: ( rule__TerminalExpression__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_7()); 
                    }
                    // InternalMiniJava.g:1465:3: ( rule__TerminalExpression__Group_7__0 )
                    // InternalMiniJava.g:1465:4: rule__TerminalExpression__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMiniJava.g:1469:2: ( ( rule__TerminalExpression__Group_8__0 ) )
                    {
                    // InternalMiniJava.g:1469:2: ( ( rule__TerminalExpression__Group_8__0 ) )
                    // InternalMiniJava.g:1470:3: ( rule__TerminalExpression__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getGroup_8()); 
                    }
                    // InternalMiniJava.g:1471:3: ( rule__TerminalExpression__Group_8__0 )
                    // InternalMiniJava.g:1471:4: rule__TerminalExpression__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getGroup_8()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Alternatives"


    // $ANTLR start "rule__TerminalExpression__ValueAlternatives_2_1_0"
    // InternalMiniJava.g:1479:1: rule__TerminalExpression__ValueAlternatives_2_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__TerminalExpression__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1483:1: ( ( 'true' ) | ( 'false' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==12) ) {
                alt16=1;
            }
            else if ( (LA16_0==13) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMiniJava.g:1484:2: ( 'true' )
                    {
                    // InternalMiniJava.g:1484:2: ( 'true' )
                    // InternalMiniJava.g:1485:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1490:2: ( 'false' )
                    {
                    // InternalMiniJava.g:1490:2: ( 'false' )
                    // InternalMiniJava.g:1491:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__AccessLevel__Alternatives"
    // InternalMiniJava.g:1500:1: rule__AccessLevel__Alternatives : ( ( ( 'private' ) ) | ( ( 'protected' ) ) | ( ( 'public' ) ) );
    public final void rule__AccessLevel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1504:1: ( ( ( 'private' ) ) | ( ( 'protected' ) ) | ( ( 'public' ) ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt17=1;
                }
                break;
            case 15:
                {
                alt17=2;
                }
                break;
            case 16:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalMiniJava.g:1505:2: ( ( 'private' ) )
                    {
                    // InternalMiniJava.g:1505:2: ( ( 'private' ) )
                    // InternalMiniJava.g:1506:3: ( 'private' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAccessLevelAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                    }
                    // InternalMiniJava.g:1507:3: ( 'private' )
                    // InternalMiniJava.g:1507:4: 'private'
                    {
                    match(input,14,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAccessLevelAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniJava.g:1511:2: ( ( 'protected' ) )
                    {
                    // InternalMiniJava.g:1511:2: ( ( 'protected' ) )
                    // InternalMiniJava.g:1512:3: ( 'protected' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAccessLevelAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    }
                    // InternalMiniJava.g:1513:3: ( 'protected' )
                    // InternalMiniJava.g:1513:4: 'protected'
                    {
                    match(input,15,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAccessLevelAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniJava.g:1517:2: ( ( 'public' ) )
                    {
                    // InternalMiniJava.g:1517:2: ( ( 'public' ) )
                    // InternalMiniJava.g:1518:3: ( 'public' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAccessLevelAccess().getPUBLICEnumLiteralDeclaration_2()); 
                    }
                    // InternalMiniJava.g:1519:3: ( 'public' )
                    // InternalMiniJava.g:1519:4: 'public'
                    {
                    match(input,16,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAccessLevelAccess().getPUBLICEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AccessLevel__Alternatives"


    // $ANTLR start "rule__Program__Group__0"
    // InternalMiniJava.g:1527:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1531:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalMiniJava.g:1532:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Program__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Program__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0"


    // $ANTLR start "rule__Program__Group__0__Impl"
    // InternalMiniJava.g:1539:1: rule__Program__Group__0__Impl : ( ( rule__Program__Group_0__0 )? ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1543:1: ( ( ( rule__Program__Group_0__0 )? ) )
            // InternalMiniJava.g:1544:1: ( ( rule__Program__Group_0__0 )? )
            {
            // InternalMiniJava.g:1544:1: ( ( rule__Program__Group_0__0 )? )
            // InternalMiniJava.g:1545:2: ( rule__Program__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup_0()); 
            }
            // InternalMiniJava.g:1546:2: ( rule__Program__Group_0__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMiniJava.g:1546:3: rule__Program__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Program__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0__Impl"


    // $ANTLR start "rule__Program__Group__1"
    // InternalMiniJava.g:1554:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1558:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // InternalMiniJava.g:1559:2: rule__Program__Group__1__Impl rule__Program__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Program__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Program__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1"


    // $ANTLR start "rule__Program__Group__1__Impl"
    // InternalMiniJava.g:1566:1: rule__Program__Group__1__Impl : ( ( rule__Program__ImportsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1570:1: ( ( ( rule__Program__ImportsAssignment_1 )* ) )
            // InternalMiniJava.g:1571:1: ( ( rule__Program__ImportsAssignment_1 )* )
            {
            // InternalMiniJava.g:1571:1: ( ( rule__Program__ImportsAssignment_1 )* )
            // InternalMiniJava.g:1572:2: ( rule__Program__ImportsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getImportsAssignment_1()); 
            }
            // InternalMiniJava.g:1573:2: ( rule__Program__ImportsAssignment_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==18) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMiniJava.g:1573:3: rule__Program__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Program__ImportsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getImportsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1__Impl"


    // $ANTLR start "rule__Program__Group__2"
    // InternalMiniJava.g:1581:1: rule__Program__Group__2 : rule__Program__Group__2__Impl ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1585:1: ( rule__Program__Group__2__Impl )
            // InternalMiniJava.g:1586:2: rule__Program__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__2"


    // $ANTLR start "rule__Program__Group__2__Impl"
    // InternalMiniJava.g:1592:1: rule__Program__Group__2__Impl : ( ( rule__Program__ClassesAssignment_2 )* ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1596:1: ( ( ( rule__Program__ClassesAssignment_2 )* ) )
            // InternalMiniJava.g:1597:1: ( ( rule__Program__ClassesAssignment_2 )* )
            {
            // InternalMiniJava.g:1597:1: ( ( rule__Program__ClassesAssignment_2 )* )
            // InternalMiniJava.g:1598:2: ( rule__Program__ClassesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClassesAssignment_2()); 
            }
            // InternalMiniJava.g:1599:2: ( rule__Program__ClassesAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=14 && LA20_0<=16)||LA20_0==21||LA20_0==27||LA20_0==64) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMiniJava.g:1599:3: rule__Program__ClassesAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Program__ClassesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClassesAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__2__Impl"


    // $ANTLR start "rule__Program__Group_0__0"
    // InternalMiniJava.g:1608:1: rule__Program__Group_0__0 : rule__Program__Group_0__0__Impl rule__Program__Group_0__1 ;
    public final void rule__Program__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1612:1: ( rule__Program__Group_0__0__Impl rule__Program__Group_0__1 )
            // InternalMiniJava.g:1613:2: rule__Program__Group_0__0__Impl rule__Program__Group_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Program__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Program__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__0"


    // $ANTLR start "rule__Program__Group_0__0__Impl"
    // InternalMiniJava.g:1620:1: rule__Program__Group_0__0__Impl : ( 'package' ) ;
    public final void rule__Program__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1624:1: ( ( 'package' ) )
            // InternalMiniJava.g:1625:1: ( 'package' )
            {
            // InternalMiniJava.g:1625:1: ( 'package' )
            // InternalMiniJava.g:1626:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getPackageKeyword_0_0()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getPackageKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__0__Impl"


    // $ANTLR start "rule__Program__Group_0__1"
    // InternalMiniJava.g:1635:1: rule__Program__Group_0__1 : rule__Program__Group_0__1__Impl rule__Program__Group_0__2 ;
    public final void rule__Program__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1639:1: ( rule__Program__Group_0__1__Impl rule__Program__Group_0__2 )
            // InternalMiniJava.g:1640:2: rule__Program__Group_0__1__Impl rule__Program__Group_0__2
            {
            pushFollow(FOLLOW_7);
            rule__Program__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Program__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__1"


    // $ANTLR start "rule__Program__Group_0__1__Impl"
    // InternalMiniJava.g:1647:1: rule__Program__Group_0__1__Impl : ( ( rule__Program__NameAssignment_0_1 ) ) ;
    public final void rule__Program__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1651:1: ( ( ( rule__Program__NameAssignment_0_1 ) ) )
            // InternalMiniJava.g:1652:1: ( ( rule__Program__NameAssignment_0_1 ) )
            {
            // InternalMiniJava.g:1652:1: ( ( rule__Program__NameAssignment_0_1 ) )
            // InternalMiniJava.g:1653:2: ( rule__Program__NameAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getNameAssignment_0_1()); 
            }
            // InternalMiniJava.g:1654:2: ( rule__Program__NameAssignment_0_1 )
            // InternalMiniJava.g:1654:3: rule__Program__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Program__NameAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getNameAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__1__Impl"


    // $ANTLR start "rule__Program__Group_0__2"
    // InternalMiniJava.g:1662:1: rule__Program__Group_0__2 : rule__Program__Group_0__2__Impl ;
    public final void rule__Program__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1666:1: ( rule__Program__Group_0__2__Impl )
            // InternalMiniJava.g:1667:2: rule__Program__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__2"


    // $ANTLR start "rule__Program__Group_0__2__Impl"
    // InternalMiniJava.g:1673:1: rule__Program__Group_0__2__Impl : ( ';' ) ;
    public final void rule__Program__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1677:1: ( ( ';' ) )
            // InternalMiniJava.g:1678:1: ( ';' )
            {
            // InternalMiniJava.g:1678:1: ( ';' )
            // InternalMiniJava.g:1679:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getSemicolonKeyword_0_2()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getSemicolonKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_0__2__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalMiniJava.g:1689:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1693:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalMiniJava.g:1694:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalMiniJava.g:1701:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1705:1: ( ( 'import' ) )
            // InternalMiniJava.g:1706:1: ( 'import' )
            {
            // InternalMiniJava.g:1706:1: ( 'import' )
            // InternalMiniJava.g:1707:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalMiniJava.g:1716:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1720:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalMiniJava.g:1721:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Import__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Import__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalMiniJava.g:1728:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1732:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalMiniJava.g:1733:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalMiniJava.g:1733:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalMiniJava.g:1734:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // InternalMiniJava.g:1735:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalMiniJava.g:1735:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // InternalMiniJava.g:1743:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1747:1: ( rule__Import__Group__2__Impl )
            // InternalMiniJava.g:1748:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // InternalMiniJava.g:1754:1: rule__Import__Group__2__Impl : ( ';' ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1758:1: ( ( ';' ) )
            // InternalMiniJava.g:1759:1: ( ';' )
            {
            // InternalMiniJava.g:1759:1: ( ';' )
            // InternalMiniJava.g:1760:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getSemicolonKeyword_2()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalMiniJava.g:1770:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1774:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalMiniJava.g:1775:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalMiniJava.g:1782:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1786:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:1787:1: ( RULE_ID )
            {
            // InternalMiniJava.g:1787:1: ( RULE_ID )
            // InternalMiniJava.g:1788:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalMiniJava.g:1797:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1801:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalMiniJava.g:1802:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalMiniJava.g:1808:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1812:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalMiniJava.g:1813:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalMiniJava.g:1813:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalMiniJava.g:1814:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:1815:2: ( rule__QualifiedName__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==19) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMiniJava.g:1815:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalMiniJava.g:1824:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1828:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalMiniJava.g:1829:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalMiniJava.g:1836:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1840:1: ( ( '.' ) )
            // InternalMiniJava.g:1841:1: ( '.' )
            {
            // InternalMiniJava.g:1841:1: ( '.' )
            // InternalMiniJava.g:1842:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalMiniJava.g:1851:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1855:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalMiniJava.g:1856:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalMiniJava.g:1862:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1866:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:1867:1: ( RULE_ID )
            {
            // InternalMiniJava.g:1867:1: ( RULE_ID )
            // InternalMiniJava.g:1868:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // InternalMiniJava.g:1878:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1882:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // InternalMiniJava.g:1883:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // InternalMiniJava.g:1890:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1894:1: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:1895:1: ( ruleQualifiedName )
            {
            // InternalMiniJava.g:1895:1: ( ruleQualifiedName )
            // InternalMiniJava.g:1896:2: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // InternalMiniJava.g:1905:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1909:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // InternalMiniJava.g:1910:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // InternalMiniJava.g:1916:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1920:1: ( ( ( '.*' )? ) )
            // InternalMiniJava.g:1921:1: ( ( '.*' )? )
            {
            // InternalMiniJava.g:1921:1: ( ( '.*' )? )
            // InternalMiniJava.g:1922:2: ( '.*' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            }
            // InternalMiniJava.g:1923:2: ( '.*' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMiniJava.g:1923:3: '.*'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__Clazz__Group__0"
    // InternalMiniJava.g:1932:1: rule__Clazz__Group__0 : rule__Clazz__Group__0__Impl rule__Clazz__Group__1 ;
    public final void rule__Clazz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1936:1: ( rule__Clazz__Group__0__Impl rule__Clazz__Group__1 )
            // InternalMiniJava.g:1937:2: rule__Clazz__Group__0__Impl rule__Clazz__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Clazz__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__0"


    // $ANTLR start "rule__Clazz__Group__0__Impl"
    // InternalMiniJava.g:1944:1: rule__Clazz__Group__0__Impl : ( ( rule__Clazz__AccessLevelAssignment_0 )? ) ;
    public final void rule__Clazz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1948:1: ( ( ( rule__Clazz__AccessLevelAssignment_0 )? ) )
            // InternalMiniJava.g:1949:1: ( ( rule__Clazz__AccessLevelAssignment_0 )? )
            {
            // InternalMiniJava.g:1949:1: ( ( rule__Clazz__AccessLevelAssignment_0 )? )
            // InternalMiniJava.g:1950:2: ( rule__Clazz__AccessLevelAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getAccessLevelAssignment_0()); 
            }
            // InternalMiniJava.g:1951:2: ( rule__Clazz__AccessLevelAssignment_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=14 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMiniJava.g:1951:3: rule__Clazz__AccessLevelAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clazz__AccessLevelAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getAccessLevelAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__0__Impl"


    // $ANTLR start "rule__Clazz__Group__1"
    // InternalMiniJava.g:1959:1: rule__Clazz__Group__1 : rule__Clazz__Group__1__Impl rule__Clazz__Group__2 ;
    public final void rule__Clazz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1963:1: ( rule__Clazz__Group__1__Impl rule__Clazz__Group__2 )
            // InternalMiniJava.g:1964:2: rule__Clazz__Group__1__Impl rule__Clazz__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Clazz__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__1"


    // $ANTLR start "rule__Clazz__Group__1__Impl"
    // InternalMiniJava.g:1971:1: rule__Clazz__Group__1__Impl : ( ( rule__Clazz__IsabstractAssignment_1 )? ) ;
    public final void rule__Clazz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1975:1: ( ( ( rule__Clazz__IsabstractAssignment_1 )? ) )
            // InternalMiniJava.g:1976:1: ( ( rule__Clazz__IsabstractAssignment_1 )? )
            {
            // InternalMiniJava.g:1976:1: ( ( rule__Clazz__IsabstractAssignment_1 )? )
            // InternalMiniJava.g:1977:2: ( rule__Clazz__IsabstractAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getIsabstractAssignment_1()); 
            }
            // InternalMiniJava.g:1978:2: ( rule__Clazz__IsabstractAssignment_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==64) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMiniJava.g:1978:3: rule__Clazz__IsabstractAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clazz__IsabstractAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getIsabstractAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__1__Impl"


    // $ANTLR start "rule__Clazz__Group__2"
    // InternalMiniJava.g:1986:1: rule__Clazz__Group__2 : rule__Clazz__Group__2__Impl rule__Clazz__Group__3 ;
    public final void rule__Clazz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:1990:1: ( rule__Clazz__Group__2__Impl rule__Clazz__Group__3 )
            // InternalMiniJava.g:1991:2: rule__Clazz__Group__2__Impl rule__Clazz__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Clazz__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__2"


    // $ANTLR start "rule__Clazz__Group__2__Impl"
    // InternalMiniJava.g:1998:1: rule__Clazz__Group__2__Impl : ( 'class' ) ;
    public final void rule__Clazz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2002:1: ( ( 'class' ) )
            // InternalMiniJava.g:2003:1: ( 'class' )
            {
            // InternalMiniJava.g:2003:1: ( 'class' )
            // InternalMiniJava.g:2004:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getClassKeyword_2()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getClassKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__2__Impl"


    // $ANTLR start "rule__Clazz__Group__3"
    // InternalMiniJava.g:2013:1: rule__Clazz__Group__3 : rule__Clazz__Group__3__Impl rule__Clazz__Group__4 ;
    public final void rule__Clazz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2017:1: ( rule__Clazz__Group__3__Impl rule__Clazz__Group__4 )
            // InternalMiniJava.g:2018:2: rule__Clazz__Group__3__Impl rule__Clazz__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Clazz__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__3"


    // $ANTLR start "rule__Clazz__Group__3__Impl"
    // InternalMiniJava.g:2025:1: rule__Clazz__Group__3__Impl : ( ( rule__Clazz__NameAssignment_3 ) ) ;
    public final void rule__Clazz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2029:1: ( ( ( rule__Clazz__NameAssignment_3 ) ) )
            // InternalMiniJava.g:2030:1: ( ( rule__Clazz__NameAssignment_3 ) )
            {
            // InternalMiniJava.g:2030:1: ( ( rule__Clazz__NameAssignment_3 ) )
            // InternalMiniJava.g:2031:2: ( rule__Clazz__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getNameAssignment_3()); 
            }
            // InternalMiniJava.g:2032:2: ( rule__Clazz__NameAssignment_3 )
            // InternalMiniJava.g:2032:3: rule__Clazz__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__3__Impl"


    // $ANTLR start "rule__Clazz__Group__4"
    // InternalMiniJava.g:2040:1: rule__Clazz__Group__4 : rule__Clazz__Group__4__Impl rule__Clazz__Group__5 ;
    public final void rule__Clazz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2044:1: ( rule__Clazz__Group__4__Impl rule__Clazz__Group__5 )
            // InternalMiniJava.g:2045:2: rule__Clazz__Group__4__Impl rule__Clazz__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Clazz__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__4"


    // $ANTLR start "rule__Clazz__Group__4__Impl"
    // InternalMiniJava.g:2052:1: rule__Clazz__Group__4__Impl : ( ( rule__Clazz__Group_4__0 )? ) ;
    public final void rule__Clazz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2056:1: ( ( ( rule__Clazz__Group_4__0 )? ) )
            // InternalMiniJava.g:2057:1: ( ( rule__Clazz__Group_4__0 )? )
            {
            // InternalMiniJava.g:2057:1: ( ( rule__Clazz__Group_4__0 )? )
            // InternalMiniJava.g:2058:2: ( rule__Clazz__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getGroup_4()); 
            }
            // InternalMiniJava.g:2059:2: ( rule__Clazz__Group_4__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==24) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMiniJava.g:2059:3: rule__Clazz__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clazz__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__4__Impl"


    // $ANTLR start "rule__Clazz__Group__5"
    // InternalMiniJava.g:2067:1: rule__Clazz__Group__5 : rule__Clazz__Group__5__Impl rule__Clazz__Group__6 ;
    public final void rule__Clazz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2071:1: ( rule__Clazz__Group__5__Impl rule__Clazz__Group__6 )
            // InternalMiniJava.g:2072:2: rule__Clazz__Group__5__Impl rule__Clazz__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__Clazz__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__5"


    // $ANTLR start "rule__Clazz__Group__5__Impl"
    // InternalMiniJava.g:2079:1: rule__Clazz__Group__5__Impl : ( ( rule__Clazz__Group_5__0 )? ) ;
    public final void rule__Clazz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2083:1: ( ( ( rule__Clazz__Group_5__0 )? ) )
            // InternalMiniJava.g:2084:1: ( ( rule__Clazz__Group_5__0 )? )
            {
            // InternalMiniJava.g:2084:1: ( ( rule__Clazz__Group_5__0 )? )
            // InternalMiniJava.g:2085:2: ( rule__Clazz__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getGroup_5()); 
            }
            // InternalMiniJava.g:2086:2: ( rule__Clazz__Group_5__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMiniJava.g:2086:3: rule__Clazz__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clazz__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__5__Impl"


    // $ANTLR start "rule__Clazz__Group__6"
    // InternalMiniJava.g:2094:1: rule__Clazz__Group__6 : rule__Clazz__Group__6__Impl rule__Clazz__Group__7 ;
    public final void rule__Clazz__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2098:1: ( rule__Clazz__Group__6__Impl rule__Clazz__Group__7 )
            // InternalMiniJava.g:2099:2: rule__Clazz__Group__6__Impl rule__Clazz__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__Clazz__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__6"


    // $ANTLR start "rule__Clazz__Group__6__Impl"
    // InternalMiniJava.g:2106:1: rule__Clazz__Group__6__Impl : ( '{' ) ;
    public final void rule__Clazz__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2110:1: ( ( '{' ) )
            // InternalMiniJava.g:2111:1: ( '{' )
            {
            // InternalMiniJava.g:2111:1: ( '{' )
            // InternalMiniJava.g:2112:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getLeftCurlyBracketKeyword_6()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getLeftCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__6__Impl"


    // $ANTLR start "rule__Clazz__Group__7"
    // InternalMiniJava.g:2121:1: rule__Clazz__Group__7 : rule__Clazz__Group__7__Impl rule__Clazz__Group__8 ;
    public final void rule__Clazz__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2125:1: ( rule__Clazz__Group__7__Impl rule__Clazz__Group__8 )
            // InternalMiniJava.g:2126:2: rule__Clazz__Group__7__Impl rule__Clazz__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Clazz__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__7"


    // $ANTLR start "rule__Clazz__Group__7__Impl"
    // InternalMiniJava.g:2133:1: rule__Clazz__Group__7__Impl : ( ( rule__Clazz__MembersAssignment_7 )* ) ;
    public final void rule__Clazz__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2137:1: ( ( ( rule__Clazz__MembersAssignment_7 )* ) )
            // InternalMiniJava.g:2138:1: ( ( rule__Clazz__MembersAssignment_7 )* )
            {
            // InternalMiniJava.g:2138:1: ( ( rule__Clazz__MembersAssignment_7 )* )
            // InternalMiniJava.g:2139:2: ( rule__Clazz__MembersAssignment_7 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getMembersAssignment_7()); 
            }
            // InternalMiniJava.g:2140:2: ( rule__Clazz__MembersAssignment_7 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID||(LA27_0>=14 && LA27_0<=16)||(LA27_0>=41 && LA27_0<=44)||(LA27_0>=64 && LA27_0<=65)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMiniJava.g:2140:3: rule__Clazz__MembersAssignment_7
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Clazz__MembersAssignment_7();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getMembersAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__7__Impl"


    // $ANTLR start "rule__Clazz__Group__8"
    // InternalMiniJava.g:2148:1: rule__Clazz__Group__8 : rule__Clazz__Group__8__Impl ;
    public final void rule__Clazz__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2152:1: ( rule__Clazz__Group__8__Impl )
            // InternalMiniJava.g:2153:2: rule__Clazz__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__8"


    // $ANTLR start "rule__Clazz__Group__8__Impl"
    // InternalMiniJava.g:2159:1: rule__Clazz__Group__8__Impl : ( '}' ) ;
    public final void rule__Clazz__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2163:1: ( ( '}' ) )
            // InternalMiniJava.g:2164:1: ( '}' )
            {
            // InternalMiniJava.g:2164:1: ( '}' )
            // InternalMiniJava.g:2165:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getRightCurlyBracketKeyword_8()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getRightCurlyBracketKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group__8__Impl"


    // $ANTLR start "rule__Clazz__Group_4__0"
    // InternalMiniJava.g:2175:1: rule__Clazz__Group_4__0 : rule__Clazz__Group_4__0__Impl rule__Clazz__Group_4__1 ;
    public final void rule__Clazz__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2179:1: ( rule__Clazz__Group_4__0__Impl rule__Clazz__Group_4__1 )
            // InternalMiniJava.g:2180:2: rule__Clazz__Group_4__0__Impl rule__Clazz__Group_4__1
            {
            pushFollow(FOLLOW_6);
            rule__Clazz__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_4__0"


    // $ANTLR start "rule__Clazz__Group_4__0__Impl"
    // InternalMiniJava.g:2187:1: rule__Clazz__Group_4__0__Impl : ( 'extends' ) ;
    public final void rule__Clazz__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2191:1: ( ( 'extends' ) )
            // InternalMiniJava.g:2192:1: ( 'extends' )
            {
            // InternalMiniJava.g:2192:1: ( 'extends' )
            // InternalMiniJava.g:2193:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getExtendsKeyword_4_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getExtendsKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_4__0__Impl"


    // $ANTLR start "rule__Clazz__Group_4__1"
    // InternalMiniJava.g:2202:1: rule__Clazz__Group_4__1 : rule__Clazz__Group_4__1__Impl ;
    public final void rule__Clazz__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2206:1: ( rule__Clazz__Group_4__1__Impl )
            // InternalMiniJava.g:2207:2: rule__Clazz__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_4__1"


    // $ANTLR start "rule__Clazz__Group_4__1__Impl"
    // InternalMiniJava.g:2213:1: rule__Clazz__Group_4__1__Impl : ( ( rule__Clazz__SuperClassAssignment_4_1 ) ) ;
    public final void rule__Clazz__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2217:1: ( ( ( rule__Clazz__SuperClassAssignment_4_1 ) ) )
            // InternalMiniJava.g:2218:1: ( ( rule__Clazz__SuperClassAssignment_4_1 ) )
            {
            // InternalMiniJava.g:2218:1: ( ( rule__Clazz__SuperClassAssignment_4_1 ) )
            // InternalMiniJava.g:2219:2: ( rule__Clazz__SuperClassAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getSuperClassAssignment_4_1()); 
            }
            // InternalMiniJava.g:2220:2: ( rule__Clazz__SuperClassAssignment_4_1 )
            // InternalMiniJava.g:2220:3: rule__Clazz__SuperClassAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__SuperClassAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getSuperClassAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_4__1__Impl"


    // $ANTLR start "rule__Clazz__Group_5__0"
    // InternalMiniJava.g:2229:1: rule__Clazz__Group_5__0 : rule__Clazz__Group_5__0__Impl rule__Clazz__Group_5__1 ;
    public final void rule__Clazz__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2233:1: ( rule__Clazz__Group_5__0__Impl rule__Clazz__Group_5__1 )
            // InternalMiniJava.g:2234:2: rule__Clazz__Group_5__0__Impl rule__Clazz__Group_5__1
            {
            pushFollow(FOLLOW_6);
            rule__Clazz__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__0"


    // $ANTLR start "rule__Clazz__Group_5__0__Impl"
    // InternalMiniJava.g:2241:1: rule__Clazz__Group_5__0__Impl : ( 'implements' ) ;
    public final void rule__Clazz__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2245:1: ( ( 'implements' ) )
            // InternalMiniJava.g:2246:1: ( 'implements' )
            {
            // InternalMiniJava.g:2246:1: ( 'implements' )
            // InternalMiniJava.g:2247:2: 'implements'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementsKeyword_5_0()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementsKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__0__Impl"


    // $ANTLR start "rule__Clazz__Group_5__1"
    // InternalMiniJava.g:2256:1: rule__Clazz__Group_5__1 : rule__Clazz__Group_5__1__Impl rule__Clazz__Group_5__2 ;
    public final void rule__Clazz__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2260:1: ( rule__Clazz__Group_5__1__Impl rule__Clazz__Group_5__2 )
            // InternalMiniJava.g:2261:2: rule__Clazz__Group_5__1__Impl rule__Clazz__Group_5__2
            {
            pushFollow(FOLLOW_15);
            rule__Clazz__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__1"


    // $ANTLR start "rule__Clazz__Group_5__1__Impl"
    // InternalMiniJava.g:2268:1: rule__Clazz__Group_5__1__Impl : ( ( rule__Clazz__ImplementzAssignment_5_1 ) ) ;
    public final void rule__Clazz__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2272:1: ( ( ( rule__Clazz__ImplementzAssignment_5_1 ) ) )
            // InternalMiniJava.g:2273:1: ( ( rule__Clazz__ImplementzAssignment_5_1 ) )
            {
            // InternalMiniJava.g:2273:1: ( ( rule__Clazz__ImplementzAssignment_5_1 ) )
            // InternalMiniJava.g:2274:2: ( rule__Clazz__ImplementzAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzAssignment_5_1()); 
            }
            // InternalMiniJava.g:2275:2: ( rule__Clazz__ImplementzAssignment_5_1 )
            // InternalMiniJava.g:2275:3: rule__Clazz__ImplementzAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__ImplementzAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__1__Impl"


    // $ANTLR start "rule__Clazz__Group_5__2"
    // InternalMiniJava.g:2283:1: rule__Clazz__Group_5__2 : rule__Clazz__Group_5__2__Impl ;
    public final void rule__Clazz__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2287:1: ( rule__Clazz__Group_5__2__Impl )
            // InternalMiniJava.g:2288:2: rule__Clazz__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__2"


    // $ANTLR start "rule__Clazz__Group_5__2__Impl"
    // InternalMiniJava.g:2294:1: rule__Clazz__Group_5__2__Impl : ( ( rule__Clazz__Group_5_2__0 )* ) ;
    public final void rule__Clazz__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2298:1: ( ( ( rule__Clazz__Group_5_2__0 )* ) )
            // InternalMiniJava.g:2299:1: ( ( rule__Clazz__Group_5_2__0 )* )
            {
            // InternalMiniJava.g:2299:1: ( ( rule__Clazz__Group_5_2__0 )* )
            // InternalMiniJava.g:2300:2: ( rule__Clazz__Group_5_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getGroup_5_2()); 
            }
            // InternalMiniJava.g:2301:2: ( rule__Clazz__Group_5_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMiniJava.g:2301:3: rule__Clazz__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Clazz__Group_5_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getGroup_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5__2__Impl"


    // $ANTLR start "rule__Clazz__Group_5_2__0"
    // InternalMiniJava.g:2310:1: rule__Clazz__Group_5_2__0 : rule__Clazz__Group_5_2__0__Impl rule__Clazz__Group_5_2__1 ;
    public final void rule__Clazz__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2314:1: ( rule__Clazz__Group_5_2__0__Impl rule__Clazz__Group_5_2__1 )
            // InternalMiniJava.g:2315:2: rule__Clazz__Group_5_2__0__Impl rule__Clazz__Group_5_2__1
            {
            pushFollow(FOLLOW_6);
            rule__Clazz__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5_2__0"


    // $ANTLR start "rule__Clazz__Group_5_2__0__Impl"
    // InternalMiniJava.g:2322:1: rule__Clazz__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Clazz__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2326:1: ( ( ',' ) )
            // InternalMiniJava.g:2327:1: ( ',' )
            {
            // InternalMiniJava.g:2327:1: ( ',' )
            // InternalMiniJava.g:2328:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getCommaKeyword_5_2_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getCommaKeyword_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5_2__0__Impl"


    // $ANTLR start "rule__Clazz__Group_5_2__1"
    // InternalMiniJava.g:2337:1: rule__Clazz__Group_5_2__1 : rule__Clazz__Group_5_2__1__Impl ;
    public final void rule__Clazz__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2341:1: ( rule__Clazz__Group_5_2__1__Impl )
            // InternalMiniJava.g:2342:2: rule__Clazz__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5_2__1"


    // $ANTLR start "rule__Clazz__Group_5_2__1__Impl"
    // InternalMiniJava.g:2348:1: rule__Clazz__Group_5_2__1__Impl : ( ( rule__Clazz__ImplementzAssignment_5_2_1 ) ) ;
    public final void rule__Clazz__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2352:1: ( ( ( rule__Clazz__ImplementzAssignment_5_2_1 ) ) )
            // InternalMiniJava.g:2353:1: ( ( rule__Clazz__ImplementzAssignment_5_2_1 ) )
            {
            // InternalMiniJava.g:2353:1: ( ( rule__Clazz__ImplementzAssignment_5_2_1 ) )
            // InternalMiniJava.g:2354:2: ( rule__Clazz__ImplementzAssignment_5_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzAssignment_5_2_1()); 
            }
            // InternalMiniJava.g:2355:2: ( rule__Clazz__ImplementzAssignment_5_2_1 )
            // InternalMiniJava.g:2355:3: rule__Clazz__ImplementzAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Clazz__ImplementzAssignment_5_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzAssignment_5_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__Group_5_2__1__Impl"


    // $ANTLR start "rule__Interface__Group__0"
    // InternalMiniJava.g:2364:1: rule__Interface__Group__0 : rule__Interface__Group__0__Impl rule__Interface__Group__1 ;
    public final void rule__Interface__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2368:1: ( rule__Interface__Group__0__Impl rule__Interface__Group__1 )
            // InternalMiniJava.g:2369:2: rule__Interface__Group__0__Impl rule__Interface__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Interface__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__0"


    // $ANTLR start "rule__Interface__Group__0__Impl"
    // InternalMiniJava.g:2376:1: rule__Interface__Group__0__Impl : ( ( rule__Interface__AccessLevelAssignment_0 )? ) ;
    public final void rule__Interface__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2380:1: ( ( ( rule__Interface__AccessLevelAssignment_0 )? ) )
            // InternalMiniJava.g:2381:1: ( ( rule__Interface__AccessLevelAssignment_0 )? )
            {
            // InternalMiniJava.g:2381:1: ( ( rule__Interface__AccessLevelAssignment_0 )? )
            // InternalMiniJava.g:2382:2: ( rule__Interface__AccessLevelAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getAccessLevelAssignment_0()); 
            }
            // InternalMiniJava.g:2383:2: ( rule__Interface__AccessLevelAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=14 && LA29_0<=16)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMiniJava.g:2383:3: rule__Interface__AccessLevelAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interface__AccessLevelAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getAccessLevelAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__0__Impl"


    // $ANTLR start "rule__Interface__Group__1"
    // InternalMiniJava.g:2391:1: rule__Interface__Group__1 : rule__Interface__Group__1__Impl rule__Interface__Group__2 ;
    public final void rule__Interface__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2395:1: ( rule__Interface__Group__1__Impl rule__Interface__Group__2 )
            // InternalMiniJava.g:2396:2: rule__Interface__Group__1__Impl rule__Interface__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Interface__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__1"


    // $ANTLR start "rule__Interface__Group__1__Impl"
    // InternalMiniJava.g:2403:1: rule__Interface__Group__1__Impl : ( 'interface' ) ;
    public final void rule__Interface__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2407:1: ( ( 'interface' ) )
            // InternalMiniJava.g:2408:1: ( 'interface' )
            {
            // InternalMiniJava.g:2408:1: ( 'interface' )
            // InternalMiniJava.g:2409:2: 'interface'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getInterfaceKeyword_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getInterfaceKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__1__Impl"


    // $ANTLR start "rule__Interface__Group__2"
    // InternalMiniJava.g:2418:1: rule__Interface__Group__2 : rule__Interface__Group__2__Impl rule__Interface__Group__3 ;
    public final void rule__Interface__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2422:1: ( rule__Interface__Group__2__Impl rule__Interface__Group__3 )
            // InternalMiniJava.g:2423:2: rule__Interface__Group__2__Impl rule__Interface__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Interface__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__2"


    // $ANTLR start "rule__Interface__Group__2__Impl"
    // InternalMiniJava.g:2430:1: rule__Interface__Group__2__Impl : ( ( rule__Interface__NameAssignment_2 ) ) ;
    public final void rule__Interface__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2434:1: ( ( ( rule__Interface__NameAssignment_2 ) ) )
            // InternalMiniJava.g:2435:1: ( ( rule__Interface__NameAssignment_2 ) )
            {
            // InternalMiniJava.g:2435:1: ( ( rule__Interface__NameAssignment_2 ) )
            // InternalMiniJava.g:2436:2: ( rule__Interface__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getNameAssignment_2()); 
            }
            // InternalMiniJava.g:2437:2: ( rule__Interface__NameAssignment_2 )
            // InternalMiniJava.g:2437:3: rule__Interface__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Interface__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__2__Impl"


    // $ANTLR start "rule__Interface__Group__3"
    // InternalMiniJava.g:2445:1: rule__Interface__Group__3 : rule__Interface__Group__3__Impl rule__Interface__Group__4 ;
    public final void rule__Interface__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2449:1: ( rule__Interface__Group__3__Impl rule__Interface__Group__4 )
            // InternalMiniJava.g:2450:2: rule__Interface__Group__3__Impl rule__Interface__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Interface__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__3"


    // $ANTLR start "rule__Interface__Group__3__Impl"
    // InternalMiniJava.g:2457:1: rule__Interface__Group__3__Impl : ( ( rule__Interface__Group_3__0 )? ) ;
    public final void rule__Interface__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2461:1: ( ( ( rule__Interface__Group_3__0 )? ) )
            // InternalMiniJava.g:2462:1: ( ( rule__Interface__Group_3__0 )? )
            {
            // InternalMiniJava.g:2462:1: ( ( rule__Interface__Group_3__0 )? )
            // InternalMiniJava.g:2463:2: ( rule__Interface__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getGroup_3()); 
            }
            // InternalMiniJava.g:2464:2: ( rule__Interface__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==24) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMiniJava.g:2464:3: rule__Interface__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interface__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__3__Impl"


    // $ANTLR start "rule__Interface__Group__4"
    // InternalMiniJava.g:2472:1: rule__Interface__Group__4 : rule__Interface__Group__4__Impl rule__Interface__Group__5 ;
    public final void rule__Interface__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2476:1: ( rule__Interface__Group__4__Impl rule__Interface__Group__5 )
            // InternalMiniJava.g:2477:2: rule__Interface__Group__4__Impl rule__Interface__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__Interface__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__4"


    // $ANTLR start "rule__Interface__Group__4__Impl"
    // InternalMiniJava.g:2484:1: rule__Interface__Group__4__Impl : ( '{' ) ;
    public final void rule__Interface__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2488:1: ( ( '{' ) )
            // InternalMiniJava.g:2489:1: ( '{' )
            {
            // InternalMiniJava.g:2489:1: ( '{' )
            // InternalMiniJava.g:2490:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__4__Impl"


    // $ANTLR start "rule__Interface__Group__5"
    // InternalMiniJava.g:2499:1: rule__Interface__Group__5 : rule__Interface__Group__5__Impl rule__Interface__Group__6 ;
    public final void rule__Interface__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2503:1: ( rule__Interface__Group__5__Impl rule__Interface__Group__6 )
            // InternalMiniJava.g:2504:2: rule__Interface__Group__5__Impl rule__Interface__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Interface__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__5"


    // $ANTLR start "rule__Interface__Group__5__Impl"
    // InternalMiniJava.g:2511:1: rule__Interface__Group__5__Impl : ( ( rule__Interface__MembersAssignment_5 )* ) ;
    public final void rule__Interface__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2515:1: ( ( ( rule__Interface__MembersAssignment_5 )* ) )
            // InternalMiniJava.g:2516:1: ( ( rule__Interface__MembersAssignment_5 )* )
            {
            // InternalMiniJava.g:2516:1: ( ( rule__Interface__MembersAssignment_5 )* )
            // InternalMiniJava.g:2517:2: ( rule__Interface__MembersAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getMembersAssignment_5()); 
            }
            // InternalMiniJava.g:2518:2: ( rule__Interface__MembersAssignment_5 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||(LA31_0>=14 && LA31_0<=16)||(LA31_0>=41 && LA31_0<=44)||(LA31_0>=64 && LA31_0<=65)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMiniJava.g:2518:3: rule__Interface__MembersAssignment_5
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Interface__MembersAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getMembersAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__5__Impl"


    // $ANTLR start "rule__Interface__Group__6"
    // InternalMiniJava.g:2526:1: rule__Interface__Group__6 : rule__Interface__Group__6__Impl ;
    public final void rule__Interface__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2530:1: ( rule__Interface__Group__6__Impl )
            // InternalMiniJava.g:2531:2: rule__Interface__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interface__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__6"


    // $ANTLR start "rule__Interface__Group__6__Impl"
    // InternalMiniJava.g:2537:1: rule__Interface__Group__6__Impl : ( '}' ) ;
    public final void rule__Interface__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2541:1: ( ( '}' ) )
            // InternalMiniJava.g:2542:1: ( '}' )
            {
            // InternalMiniJava.g:2542:1: ( '}' )
            // InternalMiniJava.g:2543:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group__6__Impl"


    // $ANTLR start "rule__Interface__Group_3__0"
    // InternalMiniJava.g:2553:1: rule__Interface__Group_3__0 : rule__Interface__Group_3__0__Impl rule__Interface__Group_3__1 ;
    public final void rule__Interface__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2557:1: ( rule__Interface__Group_3__0__Impl rule__Interface__Group_3__1 )
            // InternalMiniJava.g:2558:2: rule__Interface__Group_3__0__Impl rule__Interface__Group_3__1
            {
            pushFollow(FOLLOW_6);
            rule__Interface__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__0"


    // $ANTLR start "rule__Interface__Group_3__0__Impl"
    // InternalMiniJava.g:2565:1: rule__Interface__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__Interface__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2569:1: ( ( 'extends' ) )
            // InternalMiniJava.g:2570:1: ( 'extends' )
            {
            // InternalMiniJava.g:2570:1: ( 'extends' )
            // InternalMiniJava.g:2571:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getExtendsKeyword_3_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getExtendsKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__0__Impl"


    // $ANTLR start "rule__Interface__Group_3__1"
    // InternalMiniJava.g:2580:1: rule__Interface__Group_3__1 : rule__Interface__Group_3__1__Impl rule__Interface__Group_3__2 ;
    public final void rule__Interface__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2584:1: ( rule__Interface__Group_3__1__Impl rule__Interface__Group_3__2 )
            // InternalMiniJava.g:2585:2: rule__Interface__Group_3__1__Impl rule__Interface__Group_3__2
            {
            pushFollow(FOLLOW_15);
            rule__Interface__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__1"


    // $ANTLR start "rule__Interface__Group_3__1__Impl"
    // InternalMiniJava.g:2592:1: rule__Interface__Group_3__1__Impl : ( ( rule__Interface__ImplementzAssignment_3_1 ) ) ;
    public final void rule__Interface__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2596:1: ( ( ( rule__Interface__ImplementzAssignment_3_1 ) ) )
            // InternalMiniJava.g:2597:1: ( ( rule__Interface__ImplementzAssignment_3_1 ) )
            {
            // InternalMiniJava.g:2597:1: ( ( rule__Interface__ImplementzAssignment_3_1 ) )
            // InternalMiniJava.g:2598:2: ( rule__Interface__ImplementzAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzAssignment_3_1()); 
            }
            // InternalMiniJava.g:2599:2: ( rule__Interface__ImplementzAssignment_3_1 )
            // InternalMiniJava.g:2599:3: rule__Interface__ImplementzAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Interface__ImplementzAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__1__Impl"


    // $ANTLR start "rule__Interface__Group_3__2"
    // InternalMiniJava.g:2607:1: rule__Interface__Group_3__2 : rule__Interface__Group_3__2__Impl ;
    public final void rule__Interface__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2611:1: ( rule__Interface__Group_3__2__Impl )
            // InternalMiniJava.g:2612:2: rule__Interface__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interface__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__2"


    // $ANTLR start "rule__Interface__Group_3__2__Impl"
    // InternalMiniJava.g:2618:1: rule__Interface__Group_3__2__Impl : ( ( rule__Interface__Group_3_2__0 )* ) ;
    public final void rule__Interface__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2622:1: ( ( ( rule__Interface__Group_3_2__0 )* ) )
            // InternalMiniJava.g:2623:1: ( ( rule__Interface__Group_3_2__0 )* )
            {
            // InternalMiniJava.g:2623:1: ( ( rule__Interface__Group_3_2__0 )* )
            // InternalMiniJava.g:2624:2: ( rule__Interface__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getGroup_3_2()); 
            }
            // InternalMiniJava.g:2625:2: ( rule__Interface__Group_3_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==26) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMiniJava.g:2625:3: rule__Interface__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Interface__Group_3_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getGroup_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3__2__Impl"


    // $ANTLR start "rule__Interface__Group_3_2__0"
    // InternalMiniJava.g:2634:1: rule__Interface__Group_3_2__0 : rule__Interface__Group_3_2__0__Impl rule__Interface__Group_3_2__1 ;
    public final void rule__Interface__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2638:1: ( rule__Interface__Group_3_2__0__Impl rule__Interface__Group_3_2__1 )
            // InternalMiniJava.g:2639:2: rule__Interface__Group_3_2__0__Impl rule__Interface__Group_3_2__1
            {
            pushFollow(FOLLOW_6);
            rule__Interface__Group_3_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Interface__Group_3_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3_2__0"


    // $ANTLR start "rule__Interface__Group_3_2__0__Impl"
    // InternalMiniJava.g:2646:1: rule__Interface__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Interface__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2650:1: ( ( ',' ) )
            // InternalMiniJava.g:2651:1: ( ',' )
            {
            // InternalMiniJava.g:2651:1: ( ',' )
            // InternalMiniJava.g:2652:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getCommaKeyword_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3_2__0__Impl"


    // $ANTLR start "rule__Interface__Group_3_2__1"
    // InternalMiniJava.g:2661:1: rule__Interface__Group_3_2__1 : rule__Interface__Group_3_2__1__Impl ;
    public final void rule__Interface__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2665:1: ( rule__Interface__Group_3_2__1__Impl )
            // InternalMiniJava.g:2666:2: rule__Interface__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interface__Group_3_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3_2__1"


    // $ANTLR start "rule__Interface__Group_3_2__1__Impl"
    // InternalMiniJava.g:2672:1: rule__Interface__Group_3_2__1__Impl : ( ( rule__Interface__ImplementzAssignment_3_2_1 ) ) ;
    public final void rule__Interface__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2676:1: ( ( ( rule__Interface__ImplementzAssignment_3_2_1 ) ) )
            // InternalMiniJava.g:2677:1: ( ( rule__Interface__ImplementzAssignment_3_2_1 ) )
            {
            // InternalMiniJava.g:2677:1: ( ( rule__Interface__ImplementzAssignment_3_2_1 ) )
            // InternalMiniJava.g:2678:2: ( rule__Interface__ImplementzAssignment_3_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzAssignment_3_2_1()); 
            }
            // InternalMiniJava.g:2679:2: ( rule__Interface__ImplementzAssignment_3_2_1 )
            // InternalMiniJava.g:2679:3: rule__Interface__ImplementzAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Interface__ImplementzAssignment_3_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzAssignment_3_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__Group_3_2__1__Impl"


    // $ANTLR start "rule__Method__Group__0"
    // InternalMiniJava.g:2688:1: rule__Method__Group__0 : rule__Method__Group__0__Impl rule__Method__Group__1 ;
    public final void rule__Method__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2692:1: ( rule__Method__Group__0__Impl rule__Method__Group__1 )
            // InternalMiniJava.g:2693:2: rule__Method__Group__0__Impl rule__Method__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Method__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__0"


    // $ANTLR start "rule__Method__Group__0__Impl"
    // InternalMiniJava.g:2700:1: rule__Method__Group__0__Impl : ( ( rule__Method__AccessAssignment_0 )? ) ;
    public final void rule__Method__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2704:1: ( ( ( rule__Method__AccessAssignment_0 )? ) )
            // InternalMiniJava.g:2705:1: ( ( rule__Method__AccessAssignment_0 )? )
            {
            // InternalMiniJava.g:2705:1: ( ( rule__Method__AccessAssignment_0 )? )
            // InternalMiniJava.g:2706:2: ( rule__Method__AccessAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getAccessAssignment_0()); 
            }
            // InternalMiniJava.g:2707:2: ( rule__Method__AccessAssignment_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=14 && LA33_0<=16)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMiniJava.g:2707:3: rule__Method__AccessAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__AccessAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getAccessAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__0__Impl"


    // $ANTLR start "rule__Method__Group__1"
    // InternalMiniJava.g:2715:1: rule__Method__Group__1 : rule__Method__Group__1__Impl rule__Method__Group__2 ;
    public final void rule__Method__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2719:1: ( rule__Method__Group__1__Impl rule__Method__Group__2 )
            // InternalMiniJava.g:2720:2: rule__Method__Group__1__Impl rule__Method__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__Method__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__1"


    // $ANTLR start "rule__Method__Group__1__Impl"
    // InternalMiniJava.g:2727:1: rule__Method__Group__1__Impl : ( ( rule__Method__IsabstractAssignment_1 )? ) ;
    public final void rule__Method__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2731:1: ( ( ( rule__Method__IsabstractAssignment_1 )? ) )
            // InternalMiniJava.g:2732:1: ( ( rule__Method__IsabstractAssignment_1 )? )
            {
            // InternalMiniJava.g:2732:1: ( ( rule__Method__IsabstractAssignment_1 )? )
            // InternalMiniJava.g:2733:2: ( rule__Method__IsabstractAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsabstractAssignment_1()); 
            }
            // InternalMiniJava.g:2734:2: ( rule__Method__IsabstractAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==64) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMiniJava.g:2734:3: rule__Method__IsabstractAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__IsabstractAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsabstractAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__1__Impl"


    // $ANTLR start "rule__Method__Group__2"
    // InternalMiniJava.g:2742:1: rule__Method__Group__2 : rule__Method__Group__2__Impl rule__Method__Group__3 ;
    public final void rule__Method__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2746:1: ( rule__Method__Group__2__Impl rule__Method__Group__3 )
            // InternalMiniJava.g:2747:2: rule__Method__Group__2__Impl rule__Method__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__Method__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__2"


    // $ANTLR start "rule__Method__Group__2__Impl"
    // InternalMiniJava.g:2754:1: rule__Method__Group__2__Impl : ( ( rule__Method__IsstaticAssignment_2 )? ) ;
    public final void rule__Method__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2758:1: ( ( ( rule__Method__IsstaticAssignment_2 )? ) )
            // InternalMiniJava.g:2759:1: ( ( rule__Method__IsstaticAssignment_2 )? )
            {
            // InternalMiniJava.g:2759:1: ( ( rule__Method__IsstaticAssignment_2 )? )
            // InternalMiniJava.g:2760:2: ( rule__Method__IsstaticAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsstaticAssignment_2()); 
            }
            // InternalMiniJava.g:2761:2: ( rule__Method__IsstaticAssignment_2 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==65) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMiniJava.g:2761:3: rule__Method__IsstaticAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__IsstaticAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsstaticAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__2__Impl"


    // $ANTLR start "rule__Method__Group__3"
    // InternalMiniJava.g:2769:1: rule__Method__Group__3 : rule__Method__Group__3__Impl rule__Method__Group__4 ;
    public final void rule__Method__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2773:1: ( rule__Method__Group__3__Impl rule__Method__Group__4 )
            // InternalMiniJava.g:2774:2: rule__Method__Group__3__Impl rule__Method__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Method__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__3"


    // $ANTLR start "rule__Method__Group__3__Impl"
    // InternalMiniJava.g:2781:1: rule__Method__Group__3__Impl : ( ( rule__Method__TypeRefAssignment_3 ) ) ;
    public final void rule__Method__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2785:1: ( ( ( rule__Method__TypeRefAssignment_3 ) ) )
            // InternalMiniJava.g:2786:1: ( ( rule__Method__TypeRefAssignment_3 ) )
            {
            // InternalMiniJava.g:2786:1: ( ( rule__Method__TypeRefAssignment_3 ) )
            // InternalMiniJava.g:2787:2: ( rule__Method__TypeRefAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getTypeRefAssignment_3()); 
            }
            // InternalMiniJava.g:2788:2: ( rule__Method__TypeRefAssignment_3 )
            // InternalMiniJava.g:2788:3: rule__Method__TypeRefAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Method__TypeRefAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getTypeRefAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__3__Impl"


    // $ANTLR start "rule__Method__Group__4"
    // InternalMiniJava.g:2796:1: rule__Method__Group__4 : rule__Method__Group__4__Impl rule__Method__Group__5 ;
    public final void rule__Method__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2800:1: ( rule__Method__Group__4__Impl rule__Method__Group__5 )
            // InternalMiniJava.g:2801:2: rule__Method__Group__4__Impl rule__Method__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__Method__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__4"


    // $ANTLR start "rule__Method__Group__4__Impl"
    // InternalMiniJava.g:2808:1: rule__Method__Group__4__Impl : ( ( rule__Method__NameAssignment_4 )? ) ;
    public final void rule__Method__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2812:1: ( ( ( rule__Method__NameAssignment_4 )? ) )
            // InternalMiniJava.g:2813:1: ( ( rule__Method__NameAssignment_4 )? )
            {
            // InternalMiniJava.g:2813:1: ( ( rule__Method__NameAssignment_4 )? )
            // InternalMiniJava.g:2814:2: ( rule__Method__NameAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getNameAssignment_4()); 
            }
            // InternalMiniJava.g:2815:2: ( rule__Method__NameAssignment_4 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMiniJava.g:2815:3: rule__Method__NameAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__NameAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getNameAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__4__Impl"


    // $ANTLR start "rule__Method__Group__5"
    // InternalMiniJava.g:2823:1: rule__Method__Group__5 : rule__Method__Group__5__Impl rule__Method__Group__6 ;
    public final void rule__Method__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2827:1: ( rule__Method__Group__5__Impl rule__Method__Group__6 )
            // InternalMiniJava.g:2828:2: rule__Method__Group__5__Impl rule__Method__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Method__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__5"


    // $ANTLR start "rule__Method__Group__5__Impl"
    // InternalMiniJava.g:2835:1: rule__Method__Group__5__Impl : ( '(' ) ;
    public final void rule__Method__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2839:1: ( ( '(' ) )
            // InternalMiniJava.g:2840:1: ( '(' )
            {
            // InternalMiniJava.g:2840:1: ( '(' )
            // InternalMiniJava.g:2841:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getLeftParenthesisKeyword_5()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getLeftParenthesisKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__5__Impl"


    // $ANTLR start "rule__Method__Group__6"
    // InternalMiniJava.g:2850:1: rule__Method__Group__6 : rule__Method__Group__6__Impl rule__Method__Group__7 ;
    public final void rule__Method__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2854:1: ( rule__Method__Group__6__Impl rule__Method__Group__7 )
            // InternalMiniJava.g:2855:2: rule__Method__Group__6__Impl rule__Method__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__Method__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__6"


    // $ANTLR start "rule__Method__Group__6__Impl"
    // InternalMiniJava.g:2862:1: rule__Method__Group__6__Impl : ( ( rule__Method__Group_6__0 )? ) ;
    public final void rule__Method__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2866:1: ( ( ( rule__Method__Group_6__0 )? ) )
            // InternalMiniJava.g:2867:1: ( ( rule__Method__Group_6__0 )? )
            {
            // InternalMiniJava.g:2867:1: ( ( rule__Method__Group_6__0 )? )
            // InternalMiniJava.g:2868:2: ( rule__Method__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup_6()); 
            }
            // InternalMiniJava.g:2869:2: ( rule__Method__Group_6__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID||(LA37_0>=41 && LA37_0<=44)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMiniJava.g:2869:3: rule__Method__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Method__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__6__Impl"


    // $ANTLR start "rule__Method__Group__7"
    // InternalMiniJava.g:2877:1: rule__Method__Group__7 : rule__Method__Group__7__Impl rule__Method__Group__8 ;
    public final void rule__Method__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2881:1: ( rule__Method__Group__7__Impl rule__Method__Group__8 )
            // InternalMiniJava.g:2882:2: rule__Method__Group__7__Impl rule__Method__Group__8
            {
            pushFollow(FOLLOW_22);
            rule__Method__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__7"


    // $ANTLR start "rule__Method__Group__7__Impl"
    // InternalMiniJava.g:2889:1: rule__Method__Group__7__Impl : ( ')' ) ;
    public final void rule__Method__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2893:1: ( ( ')' ) )
            // InternalMiniJava.g:2894:1: ( ')' )
            {
            // InternalMiniJava.g:2894:1: ( ')' )
            // InternalMiniJava.g:2895:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getRightParenthesisKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__7__Impl"


    // $ANTLR start "rule__Method__Group__8"
    // InternalMiniJava.g:2904:1: rule__Method__Group__8 : rule__Method__Group__8__Impl ;
    public final void rule__Method__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2908:1: ( rule__Method__Group__8__Impl )
            // InternalMiniJava.g:2909:2: rule__Method__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Method__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__8"


    // $ANTLR start "rule__Method__Group__8__Impl"
    // InternalMiniJava.g:2915:1: rule__Method__Group__8__Impl : ( ( rule__Method__Alternatives_8 ) ) ;
    public final void rule__Method__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2919:1: ( ( ( rule__Method__Alternatives_8 ) ) )
            // InternalMiniJava.g:2920:1: ( ( rule__Method__Alternatives_8 ) )
            {
            // InternalMiniJava.g:2920:1: ( ( rule__Method__Alternatives_8 ) )
            // InternalMiniJava.g:2921:2: ( rule__Method__Alternatives_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getAlternatives_8()); 
            }
            // InternalMiniJava.g:2922:2: ( rule__Method__Alternatives_8 )
            // InternalMiniJava.g:2922:3: rule__Method__Alternatives_8
            {
            pushFollow(FOLLOW_2);
            rule__Method__Alternatives_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getAlternatives_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group__8__Impl"


    // $ANTLR start "rule__Method__Group_6__0"
    // InternalMiniJava.g:2931:1: rule__Method__Group_6__0 : rule__Method__Group_6__0__Impl rule__Method__Group_6__1 ;
    public final void rule__Method__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2935:1: ( rule__Method__Group_6__0__Impl rule__Method__Group_6__1 )
            // InternalMiniJava.g:2936:2: rule__Method__Group_6__0__Impl rule__Method__Group_6__1
            {
            pushFollow(FOLLOW_15);
            rule__Method__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6__0"


    // $ANTLR start "rule__Method__Group_6__0__Impl"
    // InternalMiniJava.g:2943:1: rule__Method__Group_6__0__Impl : ( ( rule__Method__ParamsAssignment_6_0 ) ) ;
    public final void rule__Method__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2947:1: ( ( ( rule__Method__ParamsAssignment_6_0 ) ) )
            // InternalMiniJava.g:2948:1: ( ( rule__Method__ParamsAssignment_6_0 ) )
            {
            // InternalMiniJava.g:2948:1: ( ( rule__Method__ParamsAssignment_6_0 ) )
            // InternalMiniJava.g:2949:2: ( rule__Method__ParamsAssignment_6_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsAssignment_6_0()); 
            }
            // InternalMiniJava.g:2950:2: ( rule__Method__ParamsAssignment_6_0 )
            // InternalMiniJava.g:2950:3: rule__Method__ParamsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__Method__ParamsAssignment_6_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsAssignment_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6__0__Impl"


    // $ANTLR start "rule__Method__Group_6__1"
    // InternalMiniJava.g:2958:1: rule__Method__Group_6__1 : rule__Method__Group_6__1__Impl ;
    public final void rule__Method__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2962:1: ( rule__Method__Group_6__1__Impl )
            // InternalMiniJava.g:2963:2: rule__Method__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Method__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6__1"


    // $ANTLR start "rule__Method__Group_6__1__Impl"
    // InternalMiniJava.g:2969:1: rule__Method__Group_6__1__Impl : ( ( rule__Method__Group_6_1__0 )* ) ;
    public final void rule__Method__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2973:1: ( ( ( rule__Method__Group_6_1__0 )* ) )
            // InternalMiniJava.g:2974:1: ( ( rule__Method__Group_6_1__0 )* )
            {
            // InternalMiniJava.g:2974:1: ( ( rule__Method__Group_6_1__0 )* )
            // InternalMiniJava.g:2975:2: ( rule__Method__Group_6_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup_6_1()); 
            }
            // InternalMiniJava.g:2976:2: ( rule__Method__Group_6_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==26) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMiniJava.g:2976:3: rule__Method__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Method__Group_6_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6__1__Impl"


    // $ANTLR start "rule__Method__Group_6_1__0"
    // InternalMiniJava.g:2985:1: rule__Method__Group_6_1__0 : rule__Method__Group_6_1__0__Impl rule__Method__Group_6_1__1 ;
    public final void rule__Method__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:2989:1: ( rule__Method__Group_6_1__0__Impl rule__Method__Group_6_1__1 )
            // InternalMiniJava.g:2990:2: rule__Method__Group_6_1__0__Impl rule__Method__Group_6_1__1
            {
            pushFollow(FOLLOW_23);
            rule__Method__Group_6_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Method__Group_6_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6_1__0"


    // $ANTLR start "rule__Method__Group_6_1__0__Impl"
    // InternalMiniJava.g:2997:1: rule__Method__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__Method__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3001:1: ( ( ',' ) )
            // InternalMiniJava.g:3002:1: ( ',' )
            {
            // InternalMiniJava.g:3002:1: ( ',' )
            // InternalMiniJava.g:3003:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getCommaKeyword_6_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getCommaKeyword_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6_1__0__Impl"


    // $ANTLR start "rule__Method__Group_6_1__1"
    // InternalMiniJava.g:3012:1: rule__Method__Group_6_1__1 : rule__Method__Group_6_1__1__Impl ;
    public final void rule__Method__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3016:1: ( rule__Method__Group_6_1__1__Impl )
            // InternalMiniJava.g:3017:2: rule__Method__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Method__Group_6_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6_1__1"


    // $ANTLR start "rule__Method__Group_6_1__1__Impl"
    // InternalMiniJava.g:3023:1: rule__Method__Group_6_1__1__Impl : ( ( rule__Method__ParamsAssignment_6_1_1 ) ) ;
    public final void rule__Method__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3027:1: ( ( ( rule__Method__ParamsAssignment_6_1_1 ) ) )
            // InternalMiniJava.g:3028:1: ( ( rule__Method__ParamsAssignment_6_1_1 ) )
            {
            // InternalMiniJava.g:3028:1: ( ( rule__Method__ParamsAssignment_6_1_1 ) )
            // InternalMiniJava.g:3029:2: ( rule__Method__ParamsAssignment_6_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsAssignment_6_1_1()); 
            }
            // InternalMiniJava.g:3030:2: ( rule__Method__ParamsAssignment_6_1_1 )
            // InternalMiniJava.g:3030:3: rule__Method__ParamsAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Method__ParamsAssignment_6_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsAssignment_6_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Group_6_1__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // InternalMiniJava.g:3039:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3043:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalMiniJava.g:3044:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // InternalMiniJava.g:3051:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__TypeRefAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3055:1: ( ( ( rule__Parameter__TypeRefAssignment_0 ) ) )
            // InternalMiniJava.g:3056:1: ( ( rule__Parameter__TypeRefAssignment_0 ) )
            {
            // InternalMiniJava.g:3056:1: ( ( rule__Parameter__TypeRefAssignment_0 ) )
            // InternalMiniJava.g:3057:2: ( rule__Parameter__TypeRefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeRefAssignment_0()); 
            }
            // InternalMiniJava.g:3058:2: ( rule__Parameter__TypeRefAssignment_0 )
            // InternalMiniJava.g:3058:3: rule__Parameter__TypeRefAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__TypeRefAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeRefAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // InternalMiniJava.g:3066:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3070:1: ( rule__Parameter__Group__1__Impl )
            // InternalMiniJava.g:3071:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // InternalMiniJava.g:3077:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3081:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // InternalMiniJava.g:3082:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // InternalMiniJava.g:3082:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // InternalMiniJava.g:3083:2: ( rule__Parameter__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            }
            // InternalMiniJava.g:3084:2: ( rule__Parameter__NameAssignment_1 )
            // InternalMiniJava.g:3084:3: rule__Parameter__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalMiniJava.g:3093:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3097:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalMiniJava.g:3098:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Field__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0"


    // $ANTLR start "rule__Field__Group__0__Impl"
    // InternalMiniJava.g:3105:1: rule__Field__Group__0__Impl : ( ( rule__Field__AccessAssignment_0 )? ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3109:1: ( ( ( rule__Field__AccessAssignment_0 )? ) )
            // InternalMiniJava.g:3110:1: ( ( rule__Field__AccessAssignment_0 )? )
            {
            // InternalMiniJava.g:3110:1: ( ( rule__Field__AccessAssignment_0 )? )
            // InternalMiniJava.g:3111:2: ( rule__Field__AccessAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getAccessAssignment_0()); 
            }
            // InternalMiniJava.g:3112:2: ( rule__Field__AccessAssignment_0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=14 && LA39_0<=16)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMiniJava.g:3112:3: rule__Field__AccessAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__AccessAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getAccessAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0__Impl"


    // $ANTLR start "rule__Field__Group__1"
    // InternalMiniJava.g:3120:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3124:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalMiniJava.g:3125:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Field__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1"


    // $ANTLR start "rule__Field__Group__1__Impl"
    // InternalMiniJava.g:3132:1: rule__Field__Group__1__Impl : ( ( rule__Field__TypeRefAssignment_1 ) ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3136:1: ( ( ( rule__Field__TypeRefAssignment_1 ) ) )
            // InternalMiniJava.g:3137:1: ( ( rule__Field__TypeRefAssignment_1 ) )
            {
            // InternalMiniJava.g:3137:1: ( ( rule__Field__TypeRefAssignment_1 ) )
            // InternalMiniJava.g:3138:2: ( rule__Field__TypeRefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeRefAssignment_1()); 
            }
            // InternalMiniJava.g:3139:2: ( rule__Field__TypeRefAssignment_1 )
            // InternalMiniJava.g:3139:3: rule__Field__TypeRefAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Field__TypeRefAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeRefAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__2"
    // InternalMiniJava.g:3147:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3151:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalMiniJava.g:3152:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Field__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2"


    // $ANTLR start "rule__Field__Group__2__Impl"
    // InternalMiniJava.g:3159:1: rule__Field__Group__2__Impl : ( ( rule__Field__NameAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3163:1: ( ( ( rule__Field__NameAssignment_2 ) ) )
            // InternalMiniJava.g:3164:1: ( ( rule__Field__NameAssignment_2 ) )
            {
            // InternalMiniJava.g:3164:1: ( ( rule__Field__NameAssignment_2 ) )
            // InternalMiniJava.g:3165:2: ( rule__Field__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameAssignment_2()); 
            }
            // InternalMiniJava.g:3166:2: ( rule__Field__NameAssignment_2 )
            // InternalMiniJava.g:3166:3: rule__Field__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Field__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2__Impl"


    // $ANTLR start "rule__Field__Group__3"
    // InternalMiniJava.g:3174:1: rule__Field__Group__3 : rule__Field__Group__3__Impl rule__Field__Group__4 ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3178:1: ( rule__Field__Group__3__Impl rule__Field__Group__4 )
            // InternalMiniJava.g:3179:2: rule__Field__Group__3__Impl rule__Field__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__Field__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3"


    // $ANTLR start "rule__Field__Group__3__Impl"
    // InternalMiniJava.g:3186:1: rule__Field__Group__3__Impl : ( ( rule__Field__Group_3__0 )? ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3190:1: ( ( ( rule__Field__Group_3__0 )? ) )
            // InternalMiniJava.g:3191:1: ( ( rule__Field__Group_3__0 )? )
            {
            // InternalMiniJava.g:3191:1: ( ( rule__Field__Group_3__0 )? )
            // InternalMiniJava.g:3192:2: ( rule__Field__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup_3()); 
            }
            // InternalMiniJava.g:3193:2: ( rule__Field__Group_3__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==30) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMiniJava.g:3193:3: rule__Field__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3__Impl"


    // $ANTLR start "rule__Field__Group__4"
    // InternalMiniJava.g:3201:1: rule__Field__Group__4 : rule__Field__Group__4__Impl ;
    public final void rule__Field__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3205:1: ( rule__Field__Group__4__Impl )
            // InternalMiniJava.g:3206:2: rule__Field__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4"


    // $ANTLR start "rule__Field__Group__4__Impl"
    // InternalMiniJava.g:3212:1: rule__Field__Group__4__Impl : ( ';' ) ;
    public final void rule__Field__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3216:1: ( ( ';' ) )
            // InternalMiniJava.g:3217:1: ( ';' )
            {
            // InternalMiniJava.g:3217:1: ( ';' )
            // InternalMiniJava.g:3218:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getSemicolonKeyword_4()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4__Impl"


    // $ANTLR start "rule__Field__Group_3__0"
    // InternalMiniJava.g:3228:1: rule__Field__Group_3__0 : rule__Field__Group_3__0__Impl rule__Field__Group_3__1 ;
    public final void rule__Field__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3232:1: ( rule__Field__Group_3__0__Impl rule__Field__Group_3__1 )
            // InternalMiniJava.g:3233:2: rule__Field__Group_3__0__Impl rule__Field__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__Field__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group_3__0"


    // $ANTLR start "rule__Field__Group_3__0__Impl"
    // InternalMiniJava.g:3240:1: rule__Field__Group_3__0__Impl : ( '=' ) ;
    public final void rule__Field__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3244:1: ( ( '=' ) )
            // InternalMiniJava.g:3245:1: ( '=' )
            {
            // InternalMiniJava.g:3245:1: ( '=' )
            // InternalMiniJava.g:3246:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getEqualsSignKeyword_3_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getEqualsSignKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group_3__0__Impl"


    // $ANTLR start "rule__Field__Group_3__1"
    // InternalMiniJava.g:3255:1: rule__Field__Group_3__1 : rule__Field__Group_3__1__Impl ;
    public final void rule__Field__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3259:1: ( rule__Field__Group_3__1__Impl )
            // InternalMiniJava.g:3260:2: rule__Field__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group_3__1"


    // $ANTLR start "rule__Field__Group_3__1__Impl"
    // InternalMiniJava.g:3266:1: rule__Field__Group_3__1__Impl : ( ( rule__Field__DefaultValueAssignment_3_1 ) ) ;
    public final void rule__Field__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3270:1: ( ( ( rule__Field__DefaultValueAssignment_3_1 ) ) )
            // InternalMiniJava.g:3271:1: ( ( rule__Field__DefaultValueAssignment_3_1 ) )
            {
            // InternalMiniJava.g:3271:1: ( ( rule__Field__DefaultValueAssignment_3_1 ) )
            // InternalMiniJava.g:3272:2: ( rule__Field__DefaultValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getDefaultValueAssignment_3_1()); 
            }
            // InternalMiniJava.g:3273:2: ( rule__Field__DefaultValueAssignment_3_1 )
            // InternalMiniJava.g:3273:3: rule__Field__DefaultValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Field__DefaultValueAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getDefaultValueAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group_3__1__Impl"


    // $ANTLR start "rule__Block__Group__0"
    // InternalMiniJava.g:3282:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3286:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalMiniJava.g:3287:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Block__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Block__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0"


    // $ANTLR start "rule__Block__Group__0__Impl"
    // InternalMiniJava.g:3294:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3298:1: ( ( () ) )
            // InternalMiniJava.g:3299:1: ( () )
            {
            // InternalMiniJava.g:3299:1: ( () )
            // InternalMiniJava.g:3300:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }
            // InternalMiniJava.g:3301:2: ()
            // InternalMiniJava.g:3301:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0__Impl"


    // $ANTLR start "rule__Block__Group__1"
    // InternalMiniJava.g:3309:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3313:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalMiniJava.g:3314:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__Block__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Block__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1"


    // $ANTLR start "rule__Block__Group__1__Impl"
    // InternalMiniJava.g:3321:1: rule__Block__Group__1__Impl : ( '{' ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3325:1: ( ( '{' ) )
            // InternalMiniJava.g:3326:1: ( '{' )
            {
            // InternalMiniJava.g:3326:1: ( '{' )
            // InternalMiniJava.g:3327:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1__Impl"


    // $ANTLR start "rule__Block__Group__2"
    // InternalMiniJava.g:3336:1: rule__Block__Group__2 : rule__Block__Group__2__Impl rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3340:1: ( rule__Block__Group__2__Impl rule__Block__Group__3 )
            // InternalMiniJava.g:3341:2: rule__Block__Group__2__Impl rule__Block__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Block__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Block__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2"


    // $ANTLR start "rule__Block__Group__2__Impl"
    // InternalMiniJava.g:3348:1: rule__Block__Group__2__Impl : ( ( rule__Block__StatementsAssignment_2 )* ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3352:1: ( ( ( rule__Block__StatementsAssignment_2 )* ) )
            // InternalMiniJava.g:3353:1: ( ( rule__Block__StatementsAssignment_2 )* )
            {
            // InternalMiniJava.g:3353:1: ( ( rule__Block__StatementsAssignment_2 )* )
            // InternalMiniJava.g:3354:2: ( rule__Block__StatementsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 
            }
            // InternalMiniJava.g:3355:2: ( rule__Block__StatementsAssignment_2 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_INT)||(LA41_0>=12 && LA41_0<=13)||LA41_0==22||LA41_0==28||LA41_0==31||(LA41_0>=34 && LA41_0<=35)||(LA41_0>=37 && LA41_0<=38)||(LA41_0>=41 && LA41_0<=44)||LA41_0==55||(LA41_0>=59 && LA41_0<=63)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMiniJava.g:3355:3: rule__Block__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__Block__StatementsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2__Impl"


    // $ANTLR start "rule__Block__Group__3"
    // InternalMiniJava.g:3363:1: rule__Block__Group__3 : rule__Block__Group__3__Impl ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3367:1: ( rule__Block__Group__3__Impl )
            // InternalMiniJava.g:3368:2: rule__Block__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__3"


    // $ANTLR start "rule__Block__Group__3__Impl"
    // InternalMiniJava.g:3374:1: rule__Block__Group__3__Impl : ( '}' ) ;
    public final void rule__Block__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3378:1: ( ( '}' ) )
            // InternalMiniJava.g:3379:1: ( '}' )
            {
            // InternalMiniJava.g:3379:1: ( '}' )
            // InternalMiniJava.g:3380:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__3__Impl"


    // $ANTLR start "rule__Statement__Group_0__0"
    // InternalMiniJava.g:3390:1: rule__Statement__Group_0__0 : rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 ;
    public final void rule__Statement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3394:1: ( rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 )
            // InternalMiniJava.g:3395:2: rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1
            {
            pushFollow(FOLLOW_7);
            rule__Statement__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Statement__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__0"


    // $ANTLR start "rule__Statement__Group_0__0__Impl"
    // InternalMiniJava.g:3402:1: rule__Statement__Group_0__0__Impl : ( ruleReturn ) ;
    public final void rule__Statement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3406:1: ( ( ruleReturn ) )
            // InternalMiniJava.g:3407:1: ( ruleReturn )
            {
            // InternalMiniJava.g:3407:1: ( ruleReturn )
            // InternalMiniJava.g:3408:2: ruleReturn
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getReturnParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleReturn();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getReturnParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__0__Impl"


    // $ANTLR start "rule__Statement__Group_0__1"
    // InternalMiniJava.g:3417:1: rule__Statement__Group_0__1 : rule__Statement__Group_0__1__Impl ;
    public final void rule__Statement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3421:1: ( rule__Statement__Group_0__1__Impl )
            // InternalMiniJava.g:3422:2: rule__Statement__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__1"


    // $ANTLR start "rule__Statement__Group_0__1__Impl"
    // InternalMiniJava.g:3428:1: rule__Statement__Group_0__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3432:1: ( ( ';' ) )
            // InternalMiniJava.g:3433:1: ( ';' )
            {
            // InternalMiniJava.g:3433:1: ( ';' )
            // InternalMiniJava.g:3434:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__1__Impl"


    // $ANTLR start "rule__Statement__Group_1__0"
    // InternalMiniJava.g:3444:1: rule__Statement__Group_1__0 : rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1 ;
    public final void rule__Statement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3448:1: ( rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1 )
            // InternalMiniJava.g:3449:2: rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__Statement__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Statement__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_1__0"


    // $ANTLR start "rule__Statement__Group_1__0__Impl"
    // InternalMiniJava.g:3456:1: rule__Statement__Group_1__0__Impl : ( ( ruleAssignment ) ) ;
    public final void rule__Statement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3460:1: ( ( ( ruleAssignment ) ) )
            // InternalMiniJava.g:3461:1: ( ( ruleAssignment ) )
            {
            // InternalMiniJava.g:3461:1: ( ( ruleAssignment ) )
            // InternalMiniJava.g:3462:2: ( ruleAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_1_0()); 
            }
            // InternalMiniJava.g:3463:2: ( ruleAssignment )
            // InternalMiniJava.g:3463:3: ruleAssignment
            {
            pushFollow(FOLLOW_2);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_1__0__Impl"


    // $ANTLR start "rule__Statement__Group_1__1"
    // InternalMiniJava.g:3471:1: rule__Statement__Group_1__1 : rule__Statement__Group_1__1__Impl ;
    public final void rule__Statement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3475:1: ( rule__Statement__Group_1__1__Impl )
            // InternalMiniJava.g:3476:2: rule__Statement__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_1__1"


    // $ANTLR start "rule__Statement__Group_1__1__Impl"
    // InternalMiniJava.g:3482:1: rule__Statement__Group_1__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3486:1: ( ( ';' ) )
            // InternalMiniJava.g:3487:1: ( ';' )
            {
            // InternalMiniJava.g:3487:1: ( ';' )
            // InternalMiniJava.g:3488:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getSemicolonKeyword_1_1()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getSemicolonKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_1__1__Impl"


    // $ANTLR start "rule__Statement__Group_5__0"
    // InternalMiniJava.g:3498:1: rule__Statement__Group_5__0 : rule__Statement__Group_5__0__Impl rule__Statement__Group_5__1 ;
    public final void rule__Statement__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3502:1: ( rule__Statement__Group_5__0__Impl rule__Statement__Group_5__1 )
            // InternalMiniJava.g:3503:2: rule__Statement__Group_5__0__Impl rule__Statement__Group_5__1
            {
            pushFollow(FOLLOW_7);
            rule__Statement__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Statement__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_5__0"


    // $ANTLR start "rule__Statement__Group_5__0__Impl"
    // InternalMiniJava.g:3510:1: rule__Statement__Group_5__0__Impl : ( rulePrintStatement ) ;
    public final void rule__Statement__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3514:1: ( ( rulePrintStatement ) )
            // InternalMiniJava.g:3515:1: ( rulePrintStatement )
            {
            // InternalMiniJava.g:3515:1: ( rulePrintStatement )
            // InternalMiniJava.g:3516:2: rulePrintStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getPrintStatementParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrintStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getPrintStatementParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_5__0__Impl"


    // $ANTLR start "rule__Statement__Group_5__1"
    // InternalMiniJava.g:3525:1: rule__Statement__Group_5__1 : rule__Statement__Group_5__1__Impl ;
    public final void rule__Statement__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3529:1: ( rule__Statement__Group_5__1__Impl )
            // InternalMiniJava.g:3530:2: rule__Statement__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_5__1"


    // $ANTLR start "rule__Statement__Group_5__1__Impl"
    // InternalMiniJava.g:3536:1: rule__Statement__Group_5__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3540:1: ( ( ';' ) )
            // InternalMiniJava.g:3541:1: ( ';' )
            {
            // InternalMiniJava.g:3541:1: ( ';' )
            // InternalMiniJava.g:3542:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getSemicolonKeyword_5_1()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getSemicolonKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_5__1__Impl"


    // $ANTLR start "rule__Statement__Group_7__0"
    // InternalMiniJava.g:3552:1: rule__Statement__Group_7__0 : rule__Statement__Group_7__0__Impl rule__Statement__Group_7__1 ;
    public final void rule__Statement__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3556:1: ( rule__Statement__Group_7__0__Impl rule__Statement__Group_7__1 )
            // InternalMiniJava.g:3557:2: rule__Statement__Group_7__0__Impl rule__Statement__Group_7__1
            {
            pushFollow(FOLLOW_7);
            rule__Statement__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Statement__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_7__0"


    // $ANTLR start "rule__Statement__Group_7__0__Impl"
    // InternalMiniJava.g:3564:1: rule__Statement__Group_7__0__Impl : ( ruleSelectionExpression ) ;
    public final void rule__Statement__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3568:1: ( ( ruleSelectionExpression ) )
            // InternalMiniJava.g:3569:1: ( ruleSelectionExpression )
            {
            // InternalMiniJava.g:3569:1: ( ruleSelectionExpression )
            // InternalMiniJava.g:3570:2: ruleSelectionExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getSelectionExpressionParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSelectionExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getSelectionExpressionParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_7__0__Impl"


    // $ANTLR start "rule__Statement__Group_7__1"
    // InternalMiniJava.g:3579:1: rule__Statement__Group_7__1 : rule__Statement__Group_7__1__Impl ;
    public final void rule__Statement__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3583:1: ( rule__Statement__Group_7__1__Impl )
            // InternalMiniJava.g:3584:2: rule__Statement__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_7__1"


    // $ANTLR start "rule__Statement__Group_7__1__Impl"
    // InternalMiniJava.g:3590:1: rule__Statement__Group_7__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3594:1: ( ( ';' ) )
            // InternalMiniJava.g:3595:1: ( ';' )
            {
            // InternalMiniJava.g:3595:1: ( ';' )
            // InternalMiniJava.g:3596:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getSemicolonKeyword_7_1()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getSemicolonKeyword_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_7__1__Impl"


    // $ANTLR start "rule__PrintStatement__Group__0"
    // InternalMiniJava.g:3606:1: rule__PrintStatement__Group__0 : rule__PrintStatement__Group__0__Impl rule__PrintStatement__Group__1 ;
    public final void rule__PrintStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3610:1: ( rule__PrintStatement__Group__0__Impl rule__PrintStatement__Group__1 )
            // InternalMiniJava.g:3611:2: rule__PrintStatement__Group__0__Impl rule__PrintStatement__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__PrintStatement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__0"


    // $ANTLR start "rule__PrintStatement__Group__0__Impl"
    // InternalMiniJava.g:3618:1: rule__PrintStatement__Group__0__Impl : ( 'System' ) ;
    public final void rule__PrintStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3622:1: ( ( 'System' ) )
            // InternalMiniJava.g:3623:1: ( 'System' )
            {
            // InternalMiniJava.g:3623:1: ( 'System' )
            // InternalMiniJava.g:3624:2: 'System'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getSystemKeyword_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getSystemKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__0__Impl"


    // $ANTLR start "rule__PrintStatement__Group__1"
    // InternalMiniJava.g:3633:1: rule__PrintStatement__Group__1 : rule__PrintStatement__Group__1__Impl rule__PrintStatement__Group__2 ;
    public final void rule__PrintStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3637:1: ( rule__PrintStatement__Group__1__Impl rule__PrintStatement__Group__2 )
            // InternalMiniJava.g:3638:2: rule__PrintStatement__Group__1__Impl rule__PrintStatement__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__PrintStatement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__1"


    // $ANTLR start "rule__PrintStatement__Group__1__Impl"
    // InternalMiniJava.g:3645:1: rule__PrintStatement__Group__1__Impl : ( '.' ) ;
    public final void rule__PrintStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3649:1: ( ( '.' ) )
            // InternalMiniJava.g:3650:1: ( '.' )
            {
            // InternalMiniJava.g:3650:1: ( '.' )
            // InternalMiniJava.g:3651:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getFullStopKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__1__Impl"


    // $ANTLR start "rule__PrintStatement__Group__2"
    // InternalMiniJava.g:3660:1: rule__PrintStatement__Group__2 : rule__PrintStatement__Group__2__Impl rule__PrintStatement__Group__3 ;
    public final void rule__PrintStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3664:1: ( rule__PrintStatement__Group__2__Impl rule__PrintStatement__Group__3 )
            // InternalMiniJava.g:3665:2: rule__PrintStatement__Group__2__Impl rule__PrintStatement__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__PrintStatement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__2"


    // $ANTLR start "rule__PrintStatement__Group__2__Impl"
    // InternalMiniJava.g:3672:1: rule__PrintStatement__Group__2__Impl : ( 'out' ) ;
    public final void rule__PrintStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3676:1: ( ( 'out' ) )
            // InternalMiniJava.g:3677:1: ( 'out' )
            {
            // InternalMiniJava.g:3677:1: ( 'out' )
            // InternalMiniJava.g:3678:2: 'out'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getOutKeyword_2()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getOutKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__2__Impl"


    // $ANTLR start "rule__PrintStatement__Group__3"
    // InternalMiniJava.g:3687:1: rule__PrintStatement__Group__3 : rule__PrintStatement__Group__3__Impl rule__PrintStatement__Group__4 ;
    public final void rule__PrintStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3691:1: ( rule__PrintStatement__Group__3__Impl rule__PrintStatement__Group__4 )
            // InternalMiniJava.g:3692:2: rule__PrintStatement__Group__3__Impl rule__PrintStatement__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__PrintStatement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__3"


    // $ANTLR start "rule__PrintStatement__Group__3__Impl"
    // InternalMiniJava.g:3699:1: rule__PrintStatement__Group__3__Impl : ( '.' ) ;
    public final void rule__PrintStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3703:1: ( ( '.' ) )
            // InternalMiniJava.g:3704:1: ( '.' )
            {
            // InternalMiniJava.g:3704:1: ( '.' )
            // InternalMiniJava.g:3705:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getFullStopKeyword_3()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__3__Impl"


    // $ANTLR start "rule__PrintStatement__Group__4"
    // InternalMiniJava.g:3714:1: rule__PrintStatement__Group__4 : rule__PrintStatement__Group__4__Impl rule__PrintStatement__Group__5 ;
    public final void rule__PrintStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3718:1: ( rule__PrintStatement__Group__4__Impl rule__PrintStatement__Group__5 )
            // InternalMiniJava.g:3719:2: rule__PrintStatement__Group__4__Impl rule__PrintStatement__Group__5
            {
            pushFollow(FOLLOW_31);
            rule__PrintStatement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__4"


    // $ANTLR start "rule__PrintStatement__Group__4__Impl"
    // InternalMiniJava.g:3726:1: rule__PrintStatement__Group__4__Impl : ( 'println' ) ;
    public final void rule__PrintStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3730:1: ( ( 'println' ) )
            // InternalMiniJava.g:3731:1: ( 'println' )
            {
            // InternalMiniJava.g:3731:1: ( 'println' )
            // InternalMiniJava.g:3732:2: 'println'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getPrintlnKeyword_4()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getPrintlnKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__4__Impl"


    // $ANTLR start "rule__PrintStatement__Group__5"
    // InternalMiniJava.g:3741:1: rule__PrintStatement__Group__5 : rule__PrintStatement__Group__5__Impl rule__PrintStatement__Group__6 ;
    public final void rule__PrintStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3745:1: ( rule__PrintStatement__Group__5__Impl rule__PrintStatement__Group__6 )
            // InternalMiniJava.g:3746:2: rule__PrintStatement__Group__5__Impl rule__PrintStatement__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__PrintStatement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__5"


    // $ANTLR start "rule__PrintStatement__Group__5__Impl"
    // InternalMiniJava.g:3753:1: rule__PrintStatement__Group__5__Impl : ( '(' ) ;
    public final void rule__PrintStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3757:1: ( ( '(' ) )
            // InternalMiniJava.g:3758:1: ( '(' )
            {
            // InternalMiniJava.g:3758:1: ( '(' )
            // InternalMiniJava.g:3759:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getLeftParenthesisKeyword_5()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getLeftParenthesisKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__5__Impl"


    // $ANTLR start "rule__PrintStatement__Group__6"
    // InternalMiniJava.g:3768:1: rule__PrintStatement__Group__6 : rule__PrintStatement__Group__6__Impl rule__PrintStatement__Group__7 ;
    public final void rule__PrintStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3772:1: ( rule__PrintStatement__Group__6__Impl rule__PrintStatement__Group__7 )
            // InternalMiniJava.g:3773:2: rule__PrintStatement__Group__6__Impl rule__PrintStatement__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__PrintStatement__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__6"


    // $ANTLR start "rule__PrintStatement__Group__6__Impl"
    // InternalMiniJava.g:3780:1: rule__PrintStatement__Group__6__Impl : ( ( rule__PrintStatement__ExpressionAssignment_6 ) ) ;
    public final void rule__PrintStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3784:1: ( ( ( rule__PrintStatement__ExpressionAssignment_6 ) ) )
            // InternalMiniJava.g:3785:1: ( ( rule__PrintStatement__ExpressionAssignment_6 ) )
            {
            // InternalMiniJava.g:3785:1: ( ( rule__PrintStatement__ExpressionAssignment_6 ) )
            // InternalMiniJava.g:3786:2: ( rule__PrintStatement__ExpressionAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getExpressionAssignment_6()); 
            }
            // InternalMiniJava.g:3787:2: ( rule__PrintStatement__ExpressionAssignment_6 )
            // InternalMiniJava.g:3787:3: rule__PrintStatement__ExpressionAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__PrintStatement__ExpressionAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getExpressionAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__6__Impl"


    // $ANTLR start "rule__PrintStatement__Group__7"
    // InternalMiniJava.g:3795:1: rule__PrintStatement__Group__7 : rule__PrintStatement__Group__7__Impl ;
    public final void rule__PrintStatement__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3799:1: ( rule__PrintStatement__Group__7__Impl )
            // InternalMiniJava.g:3800:2: rule__PrintStatement__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrintStatement__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__7"


    // $ANTLR start "rule__PrintStatement__Group__7__Impl"
    // InternalMiniJava.g:3806:1: rule__PrintStatement__Group__7__Impl : ( ')' ) ;
    public final void rule__PrintStatement__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3810:1: ( ( ')' ) )
            // InternalMiniJava.g:3811:1: ( ')' )
            {
            // InternalMiniJava.g:3811:1: ( ')' )
            // InternalMiniJava.g:3812:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getRightParenthesisKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__Group__7__Impl"


    // $ANTLR start "rule__Return__Group__0"
    // InternalMiniJava.g:3822:1: rule__Return__Group__0 : rule__Return__Group__0__Impl rule__Return__Group__1 ;
    public final void rule__Return__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3826:1: ( rule__Return__Group__0__Impl rule__Return__Group__1 )
            // InternalMiniJava.g:3827:2: rule__Return__Group__0__Impl rule__Return__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Return__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Return__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Return__Group__0"


    // $ANTLR start "rule__Return__Group__0__Impl"
    // InternalMiniJava.g:3834:1: rule__Return__Group__0__Impl : ( 'return' ) ;
    public final void rule__Return__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3838:1: ( ( 'return' ) )
            // InternalMiniJava.g:3839:1: ( 'return' )
            {
            // InternalMiniJava.g:3839:1: ( 'return' )
            // InternalMiniJava.g:3840:2: 'return'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReturnAccess().getReturnKeyword_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReturnAccess().getReturnKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Return__Group__0__Impl"


    // $ANTLR start "rule__Return__Group__1"
    // InternalMiniJava.g:3849:1: rule__Return__Group__1 : rule__Return__Group__1__Impl ;
    public final void rule__Return__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3853:1: ( rule__Return__Group__1__Impl )
            // InternalMiniJava.g:3854:2: rule__Return__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Return__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Return__Group__1"


    // $ANTLR start "rule__Return__Group__1__Impl"
    // InternalMiniJava.g:3860:1: rule__Return__Group__1__Impl : ( ( rule__Return__ExpressionAssignment_1 ) ) ;
    public final void rule__Return__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3864:1: ( ( ( rule__Return__ExpressionAssignment_1 ) ) )
            // InternalMiniJava.g:3865:1: ( ( rule__Return__ExpressionAssignment_1 ) )
            {
            // InternalMiniJava.g:3865:1: ( ( rule__Return__ExpressionAssignment_1 ) )
            // InternalMiniJava.g:3866:2: ( rule__Return__ExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReturnAccess().getExpressionAssignment_1()); 
            }
            // InternalMiniJava.g:3867:2: ( rule__Return__ExpressionAssignment_1 )
            // InternalMiniJava.g:3867:3: rule__Return__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Return__ExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReturnAccess().getExpressionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Return__Group__1__Impl"


    // $ANTLR start "rule__IfStatement__Group__0"
    // InternalMiniJava.g:3876:1: rule__IfStatement__Group__0 : rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 ;
    public final void rule__IfStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3880:1: ( rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 )
            // InternalMiniJava.g:3881:2: rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__IfStatement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__0"


    // $ANTLR start "rule__IfStatement__Group__0__Impl"
    // InternalMiniJava.g:3888:1: rule__IfStatement__Group__0__Impl : ( 'if' ) ;
    public final void rule__IfStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3892:1: ( ( 'if' ) )
            // InternalMiniJava.g:3893:1: ( 'if' )
            {
            // InternalMiniJava.g:3893:1: ( 'if' )
            // InternalMiniJava.g:3894:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getIfKeyword_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getIfKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__0__Impl"


    // $ANTLR start "rule__IfStatement__Group__1"
    // InternalMiniJava.g:3903:1: rule__IfStatement__Group__1 : rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 ;
    public final void rule__IfStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3907:1: ( rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 )
            // InternalMiniJava.g:3908:2: rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IfStatement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__1"


    // $ANTLR start "rule__IfStatement__Group__1__Impl"
    // InternalMiniJava.g:3915:1: rule__IfStatement__Group__1__Impl : ( '(' ) ;
    public final void rule__IfStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3919:1: ( ( '(' ) )
            // InternalMiniJava.g:3920:1: ( '(' )
            {
            // InternalMiniJava.g:3920:1: ( '(' )
            // InternalMiniJava.g:3921:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__1__Impl"


    // $ANTLR start "rule__IfStatement__Group__2"
    // InternalMiniJava.g:3930:1: rule__IfStatement__Group__2 : rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 ;
    public final void rule__IfStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3934:1: ( rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 )
            // InternalMiniJava.g:3935:2: rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__IfStatement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__2"


    // $ANTLR start "rule__IfStatement__Group__2__Impl"
    // InternalMiniJava.g:3942:1: rule__IfStatement__Group__2__Impl : ( ( rule__IfStatement__ExpressionAssignment_2 ) ) ;
    public final void rule__IfStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3946:1: ( ( ( rule__IfStatement__ExpressionAssignment_2 ) ) )
            // InternalMiniJava.g:3947:1: ( ( rule__IfStatement__ExpressionAssignment_2 ) )
            {
            // InternalMiniJava.g:3947:1: ( ( rule__IfStatement__ExpressionAssignment_2 ) )
            // InternalMiniJava.g:3948:2: ( rule__IfStatement__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getExpressionAssignment_2()); 
            }
            // InternalMiniJava.g:3949:2: ( rule__IfStatement__ExpressionAssignment_2 )
            // InternalMiniJava.g:3949:3: rule__IfStatement__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__ExpressionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getExpressionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__2__Impl"


    // $ANTLR start "rule__IfStatement__Group__3"
    // InternalMiniJava.g:3957:1: rule__IfStatement__Group__3 : rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 ;
    public final void rule__IfStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3961:1: ( rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 )
            // InternalMiniJava.g:3962:2: rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__IfStatement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__3"


    // $ANTLR start "rule__IfStatement__Group__3__Impl"
    // InternalMiniJava.g:3969:1: rule__IfStatement__Group__3__Impl : ( ')' ) ;
    public final void rule__IfStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3973:1: ( ( ')' ) )
            // InternalMiniJava.g:3974:1: ( ')' )
            {
            // InternalMiniJava.g:3974:1: ( ')' )
            // InternalMiniJava.g:3975:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__3__Impl"


    // $ANTLR start "rule__IfStatement__Group__4"
    // InternalMiniJava.g:3984:1: rule__IfStatement__Group__4 : rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 ;
    public final void rule__IfStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:3988:1: ( rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 )
            // InternalMiniJava.g:3989:2: rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5
            {
            pushFollow(FOLLOW_33);
            rule__IfStatement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__4"


    // $ANTLR start "rule__IfStatement__Group__4__Impl"
    // InternalMiniJava.g:3996:1: rule__IfStatement__Group__4__Impl : ( ( rule__IfStatement__ThenBlockAssignment_4 ) ) ;
    public final void rule__IfStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4000:1: ( ( ( rule__IfStatement__ThenBlockAssignment_4 ) ) )
            // InternalMiniJava.g:4001:1: ( ( rule__IfStatement__ThenBlockAssignment_4 ) )
            {
            // InternalMiniJava.g:4001:1: ( ( rule__IfStatement__ThenBlockAssignment_4 ) )
            // InternalMiniJava.g:4002:2: ( rule__IfStatement__ThenBlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getThenBlockAssignment_4()); 
            }
            // InternalMiniJava.g:4003:2: ( rule__IfStatement__ThenBlockAssignment_4 )
            // InternalMiniJava.g:4003:3: rule__IfStatement__ThenBlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__ThenBlockAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getThenBlockAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__4__Impl"


    // $ANTLR start "rule__IfStatement__Group__5"
    // InternalMiniJava.g:4011:1: rule__IfStatement__Group__5 : rule__IfStatement__Group__5__Impl ;
    public final void rule__IfStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4015:1: ( rule__IfStatement__Group__5__Impl )
            // InternalMiniJava.g:4016:2: rule__IfStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__5"


    // $ANTLR start "rule__IfStatement__Group__5__Impl"
    // InternalMiniJava.g:4022:1: rule__IfStatement__Group__5__Impl : ( ( rule__IfStatement__Group_5__0 )? ) ;
    public final void rule__IfStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4026:1: ( ( ( rule__IfStatement__Group_5__0 )? ) )
            // InternalMiniJava.g:4027:1: ( ( rule__IfStatement__Group_5__0 )? )
            {
            // InternalMiniJava.g:4027:1: ( ( rule__IfStatement__Group_5__0 )? )
            // InternalMiniJava.g:4028:2: ( rule__IfStatement__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getGroup_5()); 
            }
            // InternalMiniJava.g:4029:2: ( rule__IfStatement__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==36) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMiniJava.g:4029:3: rule__IfStatement__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IfStatement__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__5__Impl"


    // $ANTLR start "rule__IfStatement__Group_5__0"
    // InternalMiniJava.g:4038:1: rule__IfStatement__Group_5__0 : rule__IfStatement__Group_5__0__Impl rule__IfStatement__Group_5__1 ;
    public final void rule__IfStatement__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4042:1: ( rule__IfStatement__Group_5__0__Impl rule__IfStatement__Group_5__1 )
            // InternalMiniJava.g:4043:2: rule__IfStatement__Group_5__0__Impl rule__IfStatement__Group_5__1
            {
            pushFollow(FOLLOW_26);
            rule__IfStatement__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_5__0"


    // $ANTLR start "rule__IfStatement__Group_5__0__Impl"
    // InternalMiniJava.g:4050:1: rule__IfStatement__Group_5__0__Impl : ( ( 'else' ) ) ;
    public final void rule__IfStatement__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4054:1: ( ( ( 'else' ) ) )
            // InternalMiniJava.g:4055:1: ( ( 'else' ) )
            {
            // InternalMiniJava.g:4055:1: ( ( 'else' ) )
            // InternalMiniJava.g:4056:2: ( 'else' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getElseKeyword_5_0()); 
            }
            // InternalMiniJava.g:4057:2: ( 'else' )
            // InternalMiniJava.g:4057:3: 'else'
            {
            match(input,36,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getElseKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_5__0__Impl"


    // $ANTLR start "rule__IfStatement__Group_5__1"
    // InternalMiniJava.g:4065:1: rule__IfStatement__Group_5__1 : rule__IfStatement__Group_5__1__Impl ;
    public final void rule__IfStatement__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4069:1: ( rule__IfStatement__Group_5__1__Impl )
            // InternalMiniJava.g:4070:2: rule__IfStatement__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_5__1"


    // $ANTLR start "rule__IfStatement__Group_5__1__Impl"
    // InternalMiniJava.g:4076:1: rule__IfStatement__Group_5__1__Impl : ( ( rule__IfStatement__ElseBlockAssignment_5_1 ) ) ;
    public final void rule__IfStatement__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4080:1: ( ( ( rule__IfStatement__ElseBlockAssignment_5_1 ) ) )
            // InternalMiniJava.g:4081:1: ( ( rule__IfStatement__ElseBlockAssignment_5_1 ) )
            {
            // InternalMiniJava.g:4081:1: ( ( rule__IfStatement__ElseBlockAssignment_5_1 ) )
            // InternalMiniJava.g:4082:2: ( rule__IfStatement__ElseBlockAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getElseBlockAssignment_5_1()); 
            }
            // InternalMiniJava.g:4083:2: ( rule__IfStatement__ElseBlockAssignment_5_1 )
            // InternalMiniJava.g:4083:3: rule__IfStatement__ElseBlockAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__IfStatement__ElseBlockAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getElseBlockAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_5__1__Impl"


    // $ANTLR start "rule__WhileStatement__Group__0"
    // InternalMiniJava.g:4092:1: rule__WhileStatement__Group__0 : rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 ;
    public final void rule__WhileStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4096:1: ( rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 )
            // InternalMiniJava.g:4097:2: rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__WhileStatement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__0"


    // $ANTLR start "rule__WhileStatement__Group__0__Impl"
    // InternalMiniJava.g:4104:1: rule__WhileStatement__Group__0__Impl : ( 'while' ) ;
    public final void rule__WhileStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4108:1: ( ( 'while' ) )
            // InternalMiniJava.g:4109:1: ( 'while' )
            {
            // InternalMiniJava.g:4109:1: ( 'while' )
            // InternalMiniJava.g:4110:2: 'while'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getWhileKeyword_0()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getWhileKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__0__Impl"


    // $ANTLR start "rule__WhileStatement__Group__1"
    // InternalMiniJava.g:4119:1: rule__WhileStatement__Group__1 : rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 ;
    public final void rule__WhileStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4123:1: ( rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 )
            // InternalMiniJava.g:4124:2: rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__WhileStatement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__1"


    // $ANTLR start "rule__WhileStatement__Group__1__Impl"
    // InternalMiniJava.g:4131:1: rule__WhileStatement__Group__1__Impl : ( '(' ) ;
    public final void rule__WhileStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4135:1: ( ( '(' ) )
            // InternalMiniJava.g:4136:1: ( '(' )
            {
            // InternalMiniJava.g:4136:1: ( '(' )
            // InternalMiniJava.g:4137:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__1__Impl"


    // $ANTLR start "rule__WhileStatement__Group__2"
    // InternalMiniJava.g:4146:1: rule__WhileStatement__Group__2 : rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 ;
    public final void rule__WhileStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4150:1: ( rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 )
            // InternalMiniJava.g:4151:2: rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__WhileStatement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__2"


    // $ANTLR start "rule__WhileStatement__Group__2__Impl"
    // InternalMiniJava.g:4158:1: rule__WhileStatement__Group__2__Impl : ( ( rule__WhileStatement__ConditionAssignment_2 ) ) ;
    public final void rule__WhileStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4162:1: ( ( ( rule__WhileStatement__ConditionAssignment_2 ) ) )
            // InternalMiniJava.g:4163:1: ( ( rule__WhileStatement__ConditionAssignment_2 ) )
            {
            // InternalMiniJava.g:4163:1: ( ( rule__WhileStatement__ConditionAssignment_2 ) )
            // InternalMiniJava.g:4164:2: ( rule__WhileStatement__ConditionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getConditionAssignment_2()); 
            }
            // InternalMiniJava.g:4165:2: ( rule__WhileStatement__ConditionAssignment_2 )
            // InternalMiniJava.g:4165:3: rule__WhileStatement__ConditionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__WhileStatement__ConditionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getConditionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__2__Impl"


    // $ANTLR start "rule__WhileStatement__Group__3"
    // InternalMiniJava.g:4173:1: rule__WhileStatement__Group__3 : rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 ;
    public final void rule__WhileStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4177:1: ( rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 )
            // InternalMiniJava.g:4178:2: rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__WhileStatement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__3"


    // $ANTLR start "rule__WhileStatement__Group__3__Impl"
    // InternalMiniJava.g:4185:1: rule__WhileStatement__Group__3__Impl : ( ')' ) ;
    public final void rule__WhileStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4189:1: ( ( ')' ) )
            // InternalMiniJava.g:4190:1: ( ')' )
            {
            // InternalMiniJava.g:4190:1: ( ')' )
            // InternalMiniJava.g:4191:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__3__Impl"


    // $ANTLR start "rule__WhileStatement__Group__4"
    // InternalMiniJava.g:4200:1: rule__WhileStatement__Group__4 : rule__WhileStatement__Group__4__Impl ;
    public final void rule__WhileStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4204:1: ( rule__WhileStatement__Group__4__Impl )
            // InternalMiniJava.g:4205:2: rule__WhileStatement__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WhileStatement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__4"


    // $ANTLR start "rule__WhileStatement__Group__4__Impl"
    // InternalMiniJava.g:4211:1: rule__WhileStatement__Group__4__Impl : ( ( rule__WhileStatement__BlockAssignment_4 ) ) ;
    public final void rule__WhileStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4215:1: ( ( ( rule__WhileStatement__BlockAssignment_4 ) ) )
            // InternalMiniJava.g:4216:1: ( ( rule__WhileStatement__BlockAssignment_4 ) )
            {
            // InternalMiniJava.g:4216:1: ( ( rule__WhileStatement__BlockAssignment_4 ) )
            // InternalMiniJava.g:4217:2: ( rule__WhileStatement__BlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getBlockAssignment_4()); 
            }
            // InternalMiniJava.g:4218:2: ( rule__WhileStatement__BlockAssignment_4 )
            // InternalMiniJava.g:4218:3: rule__WhileStatement__BlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__WhileStatement__BlockAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getBlockAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__4__Impl"


    // $ANTLR start "rule__ForStatement__Group__0"
    // InternalMiniJava.g:4227:1: rule__ForStatement__Group__0 : rule__ForStatement__Group__0__Impl rule__ForStatement__Group__1 ;
    public final void rule__ForStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4231:1: ( rule__ForStatement__Group__0__Impl rule__ForStatement__Group__1 )
            // InternalMiniJava.g:4232:2: rule__ForStatement__Group__0__Impl rule__ForStatement__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__ForStatement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__0"


    // $ANTLR start "rule__ForStatement__Group__0__Impl"
    // InternalMiniJava.g:4239:1: rule__ForStatement__Group__0__Impl : ( 'for' ) ;
    public final void rule__ForStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4243:1: ( ( 'for' ) )
            // InternalMiniJava.g:4244:1: ( 'for' )
            {
            // InternalMiniJava.g:4244:1: ( 'for' )
            // InternalMiniJava.g:4245:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getForKeyword_0()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getForKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__0__Impl"


    // $ANTLR start "rule__ForStatement__Group__1"
    // InternalMiniJava.g:4254:1: rule__ForStatement__Group__1 : rule__ForStatement__Group__1__Impl rule__ForStatement__Group__2 ;
    public final void rule__ForStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4258:1: ( rule__ForStatement__Group__1__Impl rule__ForStatement__Group__2 )
            // InternalMiniJava.g:4259:2: rule__ForStatement__Group__1__Impl rule__ForStatement__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__ForStatement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__1"


    // $ANTLR start "rule__ForStatement__Group__1__Impl"
    // InternalMiniJava.g:4266:1: rule__ForStatement__Group__1__Impl : ( '(' ) ;
    public final void rule__ForStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4270:1: ( ( '(' ) )
            // InternalMiniJava.g:4271:1: ( '(' )
            {
            // InternalMiniJava.g:4271:1: ( '(' )
            // InternalMiniJava.g:4272:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__1__Impl"


    // $ANTLR start "rule__ForStatement__Group__2"
    // InternalMiniJava.g:4281:1: rule__ForStatement__Group__2 : rule__ForStatement__Group__2__Impl rule__ForStatement__Group__3 ;
    public final void rule__ForStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4285:1: ( rule__ForStatement__Group__2__Impl rule__ForStatement__Group__3 )
            // InternalMiniJava.g:4286:2: rule__ForStatement__Group__2__Impl rule__ForStatement__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ForStatement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__2"


    // $ANTLR start "rule__ForStatement__Group__2__Impl"
    // InternalMiniJava.g:4293:1: rule__ForStatement__Group__2__Impl : ( ( rule__ForStatement__DeclarationAssignment_2 ) ) ;
    public final void rule__ForStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4297:1: ( ( ( rule__ForStatement__DeclarationAssignment_2 ) ) )
            // InternalMiniJava.g:4298:1: ( ( rule__ForStatement__DeclarationAssignment_2 ) )
            {
            // InternalMiniJava.g:4298:1: ( ( rule__ForStatement__DeclarationAssignment_2 ) )
            // InternalMiniJava.g:4299:2: ( rule__ForStatement__DeclarationAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getDeclarationAssignment_2()); 
            }
            // InternalMiniJava.g:4300:2: ( rule__ForStatement__DeclarationAssignment_2 )
            // InternalMiniJava.g:4300:3: rule__ForStatement__DeclarationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__DeclarationAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getDeclarationAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__2__Impl"


    // $ANTLR start "rule__ForStatement__Group__3"
    // InternalMiniJava.g:4308:1: rule__ForStatement__Group__3 : rule__ForStatement__Group__3__Impl rule__ForStatement__Group__4 ;
    public final void rule__ForStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4312:1: ( rule__ForStatement__Group__3__Impl rule__ForStatement__Group__4 )
            // InternalMiniJava.g:4313:2: rule__ForStatement__Group__3__Impl rule__ForStatement__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__ForStatement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__3"


    // $ANTLR start "rule__ForStatement__Group__3__Impl"
    // InternalMiniJava.g:4320:1: rule__ForStatement__Group__3__Impl : ( ';' ) ;
    public final void rule__ForStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4324:1: ( ( ';' ) )
            // InternalMiniJava.g:4325:1: ( ';' )
            {
            // InternalMiniJava.g:4325:1: ( ';' )
            // InternalMiniJava.g:4326:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getSemicolonKeyword_3()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__3__Impl"


    // $ANTLR start "rule__ForStatement__Group__4"
    // InternalMiniJava.g:4335:1: rule__ForStatement__Group__4 : rule__ForStatement__Group__4__Impl rule__ForStatement__Group__5 ;
    public final void rule__ForStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4339:1: ( rule__ForStatement__Group__4__Impl rule__ForStatement__Group__5 )
            // InternalMiniJava.g:4340:2: rule__ForStatement__Group__4__Impl rule__ForStatement__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__ForStatement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__4"


    // $ANTLR start "rule__ForStatement__Group__4__Impl"
    // InternalMiniJava.g:4347:1: rule__ForStatement__Group__4__Impl : ( ( rule__ForStatement__ConditionAssignment_4 ) ) ;
    public final void rule__ForStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4351:1: ( ( ( rule__ForStatement__ConditionAssignment_4 ) ) )
            // InternalMiniJava.g:4352:1: ( ( rule__ForStatement__ConditionAssignment_4 ) )
            {
            // InternalMiniJava.g:4352:1: ( ( rule__ForStatement__ConditionAssignment_4 ) )
            // InternalMiniJava.g:4353:2: ( rule__ForStatement__ConditionAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getConditionAssignment_4()); 
            }
            // InternalMiniJava.g:4354:2: ( rule__ForStatement__ConditionAssignment_4 )
            // InternalMiniJava.g:4354:3: rule__ForStatement__ConditionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__ConditionAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getConditionAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__4__Impl"


    // $ANTLR start "rule__ForStatement__Group__5"
    // InternalMiniJava.g:4362:1: rule__ForStatement__Group__5 : rule__ForStatement__Group__5__Impl rule__ForStatement__Group__6 ;
    public final void rule__ForStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4366:1: ( rule__ForStatement__Group__5__Impl rule__ForStatement__Group__6 )
            // InternalMiniJava.g:4367:2: rule__ForStatement__Group__5__Impl rule__ForStatement__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__ForStatement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__5"


    // $ANTLR start "rule__ForStatement__Group__5__Impl"
    // InternalMiniJava.g:4374:1: rule__ForStatement__Group__5__Impl : ( ';' ) ;
    public final void rule__ForStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4378:1: ( ( ';' ) )
            // InternalMiniJava.g:4379:1: ( ';' )
            {
            // InternalMiniJava.g:4379:1: ( ';' )
            // InternalMiniJava.g:4380:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getSemicolonKeyword_5()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__5__Impl"


    // $ANTLR start "rule__ForStatement__Group__6"
    // InternalMiniJava.g:4389:1: rule__ForStatement__Group__6 : rule__ForStatement__Group__6__Impl rule__ForStatement__Group__7 ;
    public final void rule__ForStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4393:1: ( rule__ForStatement__Group__6__Impl rule__ForStatement__Group__7 )
            // InternalMiniJava.g:4394:2: rule__ForStatement__Group__6__Impl rule__ForStatement__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__ForStatement__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__6"


    // $ANTLR start "rule__ForStatement__Group__6__Impl"
    // InternalMiniJava.g:4401:1: rule__ForStatement__Group__6__Impl : ( ( rule__ForStatement__ProgressionAssignment_6 ) ) ;
    public final void rule__ForStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4405:1: ( ( ( rule__ForStatement__ProgressionAssignment_6 ) ) )
            // InternalMiniJava.g:4406:1: ( ( rule__ForStatement__ProgressionAssignment_6 ) )
            {
            // InternalMiniJava.g:4406:1: ( ( rule__ForStatement__ProgressionAssignment_6 ) )
            // InternalMiniJava.g:4407:2: ( rule__ForStatement__ProgressionAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getProgressionAssignment_6()); 
            }
            // InternalMiniJava.g:4408:2: ( rule__ForStatement__ProgressionAssignment_6 )
            // InternalMiniJava.g:4408:3: rule__ForStatement__ProgressionAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__ProgressionAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getProgressionAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__6__Impl"


    // $ANTLR start "rule__ForStatement__Group__7"
    // InternalMiniJava.g:4416:1: rule__ForStatement__Group__7 : rule__ForStatement__Group__7__Impl rule__ForStatement__Group__8 ;
    public final void rule__ForStatement__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4420:1: ( rule__ForStatement__Group__7__Impl rule__ForStatement__Group__8 )
            // InternalMiniJava.g:4421:2: rule__ForStatement__Group__7__Impl rule__ForStatement__Group__8
            {
            pushFollow(FOLLOW_26);
            rule__ForStatement__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__7"


    // $ANTLR start "rule__ForStatement__Group__7__Impl"
    // InternalMiniJava.g:4428:1: rule__ForStatement__Group__7__Impl : ( ')' ) ;
    public final void rule__ForStatement__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4432:1: ( ( ')' ) )
            // InternalMiniJava.g:4433:1: ( ')' )
            {
            // InternalMiniJava.g:4433:1: ( ')' )
            // InternalMiniJava.g:4434:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__7__Impl"


    // $ANTLR start "rule__ForStatement__Group__8"
    // InternalMiniJava.g:4443:1: rule__ForStatement__Group__8 : rule__ForStatement__Group__8__Impl ;
    public final void rule__ForStatement__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4447:1: ( rule__ForStatement__Group__8__Impl )
            // InternalMiniJava.g:4448:2: rule__ForStatement__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__8"


    // $ANTLR start "rule__ForStatement__Group__8__Impl"
    // InternalMiniJava.g:4454:1: rule__ForStatement__Group__8__Impl : ( ( rule__ForStatement__BlockAssignment_8 ) ) ;
    public final void rule__ForStatement__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4458:1: ( ( ( rule__ForStatement__BlockAssignment_8 ) ) )
            // InternalMiniJava.g:4459:1: ( ( rule__ForStatement__BlockAssignment_8 ) )
            {
            // InternalMiniJava.g:4459:1: ( ( rule__ForStatement__BlockAssignment_8 ) )
            // InternalMiniJava.g:4460:2: ( rule__ForStatement__BlockAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getBlockAssignment_8()); 
            }
            // InternalMiniJava.g:4461:2: ( rule__ForStatement__BlockAssignment_8 )
            // InternalMiniJava.g:4461:3: rule__ForStatement__BlockAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__ForStatement__BlockAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getBlockAssignment_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__Group__8__Impl"


    // $ANTLR start "rule__TypeRef__Group__0"
    // InternalMiniJava.g:4470:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4474:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalMiniJava.g:4475:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0"


    // $ANTLR start "rule__TypeRef__Group__0__Impl"
    // InternalMiniJava.g:4482:1: rule__TypeRef__Group__0__Impl : ( ruleSingleTypeRef ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4486:1: ( ( ruleSingleTypeRef ) )
            // InternalMiniJava.g:4487:1: ( ruleSingleTypeRef )
            {
            // InternalMiniJava.g:4487:1: ( ruleSingleTypeRef )
            // InternalMiniJava.g:4488:2: ruleSingleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getSingleTypeRefParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSingleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getSingleTypeRefParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0__Impl"


    // $ANTLR start "rule__TypeRef__Group__1"
    // InternalMiniJava.g:4497:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4501:1: ( rule__TypeRef__Group__1__Impl )
            // InternalMiniJava.g:4502:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1"


    // $ANTLR start "rule__TypeRef__Group__1__Impl"
    // InternalMiniJava.g:4508:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__Group_1__0 )? ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4512:1: ( ( ( rule__TypeRef__Group_1__0 )? ) )
            // InternalMiniJava.g:4513:1: ( ( rule__TypeRef__Group_1__0 )? )
            {
            // InternalMiniJava.g:4513:1: ( ( rule__TypeRef__Group_1__0 )? )
            // InternalMiniJava.g:4514:2: ( rule__TypeRef__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:4515:2: ( rule__TypeRef__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==39) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==40) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalMiniJava.g:4515:3: rule__TypeRef__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeRef__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1__Impl"


    // $ANTLR start "rule__TypeRef__Group_1__0"
    // InternalMiniJava.g:4524:1: rule__TypeRef__Group_1__0 : rule__TypeRef__Group_1__0__Impl rule__TypeRef__Group_1__1 ;
    public final void rule__TypeRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4528:1: ( rule__TypeRef__Group_1__0__Impl rule__TypeRef__Group_1__1 )
            // InternalMiniJava.g:4529:2: rule__TypeRef__Group_1__0__Impl rule__TypeRef__Group_1__1
            {
            pushFollow(FOLLOW_35);
            rule__TypeRef__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__0"


    // $ANTLR start "rule__TypeRef__Group_1__0__Impl"
    // InternalMiniJava.g:4536:1: rule__TypeRef__Group_1__0__Impl : ( () ) ;
    public final void rule__TypeRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4540:1: ( ( () ) )
            // InternalMiniJava.g:4541:1: ( () )
            {
            // InternalMiniJava.g:4541:1: ( () )
            // InternalMiniJava.g:4542:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getArrayTypeRefTypeRefAction_1_0()); 
            }
            // InternalMiniJava.g:4543:2: ()
            // InternalMiniJava.g:4543:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getArrayTypeRefTypeRefAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__0__Impl"


    // $ANTLR start "rule__TypeRef__Group_1__1"
    // InternalMiniJava.g:4551:1: rule__TypeRef__Group_1__1 : rule__TypeRef__Group_1__1__Impl rule__TypeRef__Group_1__2 ;
    public final void rule__TypeRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4555:1: ( rule__TypeRef__Group_1__1__Impl rule__TypeRef__Group_1__2 )
            // InternalMiniJava.g:4556:2: rule__TypeRef__Group_1__1__Impl rule__TypeRef__Group_1__2
            {
            pushFollow(FOLLOW_36);
            rule__TypeRef__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__1"


    // $ANTLR start "rule__TypeRef__Group_1__1__Impl"
    // InternalMiniJava.g:4563:1: rule__TypeRef__Group_1__1__Impl : ( '[' ) ;
    public final void rule__TypeRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4567:1: ( ( '[' ) )
            // InternalMiniJava.g:4568:1: ( '[' )
            {
            // InternalMiniJava.g:4568:1: ( '[' )
            // InternalMiniJava.g:4569:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getLeftSquareBracketKeyword_1_1()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getLeftSquareBracketKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__1__Impl"


    // $ANTLR start "rule__TypeRef__Group_1__2"
    // InternalMiniJava.g:4578:1: rule__TypeRef__Group_1__2 : rule__TypeRef__Group_1__2__Impl ;
    public final void rule__TypeRef__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4582:1: ( rule__TypeRef__Group_1__2__Impl )
            // InternalMiniJava.g:4583:2: rule__TypeRef__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeRef__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__2"


    // $ANTLR start "rule__TypeRef__Group_1__2__Impl"
    // InternalMiniJava.g:4589:1: rule__TypeRef__Group_1__2__Impl : ( ']' ) ;
    public final void rule__TypeRef__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4593:1: ( ( ']' ) )
            // InternalMiniJava.g:4594:1: ( ']' )
            {
            // InternalMiniJava.g:4594:1: ( ']' )
            // InternalMiniJava.g:4595:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getRightSquareBracketKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_1__2__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_1__0"
    // InternalMiniJava.g:4605:1: rule__SingleTypeRef__Group_1__0 : rule__SingleTypeRef__Group_1__0__Impl rule__SingleTypeRef__Group_1__1 ;
    public final void rule__SingleTypeRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4609:1: ( rule__SingleTypeRef__Group_1__0__Impl rule__SingleTypeRef__Group_1__1 )
            // InternalMiniJava.g:4610:2: rule__SingleTypeRef__Group_1__0__Impl rule__SingleTypeRef__Group_1__1
            {
            pushFollow(FOLLOW_37);
            rule__SingleTypeRef__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_1__0"


    // $ANTLR start "rule__SingleTypeRef__Group_1__0__Impl"
    // InternalMiniJava.g:4617:1: rule__SingleTypeRef__Group_1__0__Impl : ( () ) ;
    public final void rule__SingleTypeRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4621:1: ( ( () ) )
            // InternalMiniJava.g:4622:1: ( () )
            {
            // InternalMiniJava.g:4622:1: ( () )
            // InternalMiniJava.g:4623:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getIntegerTypeRefAction_1_0()); 
            }
            // InternalMiniJava.g:4624:2: ()
            // InternalMiniJava.g:4624:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getIntegerTypeRefAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_1__0__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_1__1"
    // InternalMiniJava.g:4632:1: rule__SingleTypeRef__Group_1__1 : rule__SingleTypeRef__Group_1__1__Impl ;
    public final void rule__SingleTypeRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4636:1: ( rule__SingleTypeRef__Group_1__1__Impl )
            // InternalMiniJava.g:4637:2: rule__SingleTypeRef__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_1__1"


    // $ANTLR start "rule__SingleTypeRef__Group_1__1__Impl"
    // InternalMiniJava.g:4643:1: rule__SingleTypeRef__Group_1__1__Impl : ( 'int' ) ;
    public final void rule__SingleTypeRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4647:1: ( ( 'int' ) )
            // InternalMiniJava.g:4648:1: ( 'int' )
            {
            // InternalMiniJava.g:4648:1: ( 'int' )
            // InternalMiniJava.g:4649:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getIntKeyword_1_1()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getIntKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_1__1__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_2__0"
    // InternalMiniJava.g:4659:1: rule__SingleTypeRef__Group_2__0 : rule__SingleTypeRef__Group_2__0__Impl rule__SingleTypeRef__Group_2__1 ;
    public final void rule__SingleTypeRef__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4663:1: ( rule__SingleTypeRef__Group_2__0__Impl rule__SingleTypeRef__Group_2__1 )
            // InternalMiniJava.g:4664:2: rule__SingleTypeRef__Group_2__0__Impl rule__SingleTypeRef__Group_2__1
            {
            pushFollow(FOLLOW_38);
            rule__SingleTypeRef__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_2__0"


    // $ANTLR start "rule__SingleTypeRef__Group_2__0__Impl"
    // InternalMiniJava.g:4671:1: rule__SingleTypeRef__Group_2__0__Impl : ( () ) ;
    public final void rule__SingleTypeRef__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4675:1: ( ( () ) )
            // InternalMiniJava.g:4676:1: ( () )
            {
            // InternalMiniJava.g:4676:1: ( () )
            // InternalMiniJava.g:4677:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getBooleanTypeRefAction_2_0()); 
            }
            // InternalMiniJava.g:4678:2: ()
            // InternalMiniJava.g:4678:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getBooleanTypeRefAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_2__0__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_2__1"
    // InternalMiniJava.g:4686:1: rule__SingleTypeRef__Group_2__1 : rule__SingleTypeRef__Group_2__1__Impl ;
    public final void rule__SingleTypeRef__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4690:1: ( rule__SingleTypeRef__Group_2__1__Impl )
            // InternalMiniJava.g:4691:2: rule__SingleTypeRef__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_2__1"


    // $ANTLR start "rule__SingleTypeRef__Group_2__1__Impl"
    // InternalMiniJava.g:4697:1: rule__SingleTypeRef__Group_2__1__Impl : ( 'boolean' ) ;
    public final void rule__SingleTypeRef__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4701:1: ( ( 'boolean' ) )
            // InternalMiniJava.g:4702:1: ( 'boolean' )
            {
            // InternalMiniJava.g:4702:1: ( 'boolean' )
            // InternalMiniJava.g:4703:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getBooleanKeyword_2_1()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getBooleanKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_2__1__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_3__0"
    // InternalMiniJava.g:4713:1: rule__SingleTypeRef__Group_3__0 : rule__SingleTypeRef__Group_3__0__Impl rule__SingleTypeRef__Group_3__1 ;
    public final void rule__SingleTypeRef__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4717:1: ( rule__SingleTypeRef__Group_3__0__Impl rule__SingleTypeRef__Group_3__1 )
            // InternalMiniJava.g:4718:2: rule__SingleTypeRef__Group_3__0__Impl rule__SingleTypeRef__Group_3__1
            {
            pushFollow(FOLLOW_39);
            rule__SingleTypeRef__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_3__0"


    // $ANTLR start "rule__SingleTypeRef__Group_3__0__Impl"
    // InternalMiniJava.g:4725:1: rule__SingleTypeRef__Group_3__0__Impl : ( () ) ;
    public final void rule__SingleTypeRef__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4729:1: ( ( () ) )
            // InternalMiniJava.g:4730:1: ( () )
            {
            // InternalMiniJava.g:4730:1: ( () )
            // InternalMiniJava.g:4731:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getStringTypeRefAction_3_0()); 
            }
            // InternalMiniJava.g:4732:2: ()
            // InternalMiniJava.g:4732:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getStringTypeRefAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_3__0__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_3__1"
    // InternalMiniJava.g:4740:1: rule__SingleTypeRef__Group_3__1 : rule__SingleTypeRef__Group_3__1__Impl ;
    public final void rule__SingleTypeRef__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4744:1: ( rule__SingleTypeRef__Group_3__1__Impl )
            // InternalMiniJava.g:4745:2: rule__SingleTypeRef__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_3__1"


    // $ANTLR start "rule__SingleTypeRef__Group_3__1__Impl"
    // InternalMiniJava.g:4751:1: rule__SingleTypeRef__Group_3__1__Impl : ( 'String' ) ;
    public final void rule__SingleTypeRef__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4755:1: ( ( 'String' ) )
            // InternalMiniJava.g:4756:1: ( 'String' )
            {
            // InternalMiniJava.g:4756:1: ( 'String' )
            // InternalMiniJava.g:4757:2: 'String'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getStringKeyword_3_1()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getStringKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_3__1__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_4__0"
    // InternalMiniJava.g:4767:1: rule__SingleTypeRef__Group_4__0 : rule__SingleTypeRef__Group_4__0__Impl rule__SingleTypeRef__Group_4__1 ;
    public final void rule__SingleTypeRef__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4771:1: ( rule__SingleTypeRef__Group_4__0__Impl rule__SingleTypeRef__Group_4__1 )
            // InternalMiniJava.g:4772:2: rule__SingleTypeRef__Group_4__0__Impl rule__SingleTypeRef__Group_4__1
            {
            pushFollow(FOLLOW_23);
            rule__SingleTypeRef__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_4__0"


    // $ANTLR start "rule__SingleTypeRef__Group_4__0__Impl"
    // InternalMiniJava.g:4779:1: rule__SingleTypeRef__Group_4__0__Impl : ( () ) ;
    public final void rule__SingleTypeRef__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4783:1: ( ( () ) )
            // InternalMiniJava.g:4784:1: ( () )
            {
            // InternalMiniJava.g:4784:1: ( () )
            // InternalMiniJava.g:4785:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getVoidTypeRefAction_4_0()); 
            }
            // InternalMiniJava.g:4786:2: ()
            // InternalMiniJava.g:4786:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getVoidTypeRefAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_4__0__Impl"


    // $ANTLR start "rule__SingleTypeRef__Group_4__1"
    // InternalMiniJava.g:4794:1: rule__SingleTypeRef__Group_4__1 : rule__SingleTypeRef__Group_4__1__Impl ;
    public final void rule__SingleTypeRef__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4798:1: ( rule__SingleTypeRef__Group_4__1__Impl )
            // InternalMiniJava.g:4799:2: rule__SingleTypeRef__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleTypeRef__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_4__1"


    // $ANTLR start "rule__SingleTypeRef__Group_4__1__Impl"
    // InternalMiniJava.g:4805:1: rule__SingleTypeRef__Group_4__1__Impl : ( 'void' ) ;
    public final void rule__SingleTypeRef__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4809:1: ( ( 'void' ) )
            // InternalMiniJava.g:4810:1: ( 'void' )
            {
            // InternalMiniJava.g:4810:1: ( 'void' )
            // InternalMiniJava.g:4811:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSingleTypeRefAccess().getVoidKeyword_4_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSingleTypeRefAccess().getVoidKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleTypeRef__Group_4__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__0"
    // InternalMiniJava.g:4821:1: rule__VariableDeclaration__Group__0 : rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 ;
    public final void rule__VariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4825:1: ( rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 )
            // InternalMiniJava.g:4826:2: rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__VariableDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__0"


    // $ANTLR start "rule__VariableDeclaration__Group__0__Impl"
    // InternalMiniJava.g:4833:1: rule__VariableDeclaration__Group__0__Impl : ( ( rule__VariableDeclaration__TypeRefAssignment_0 ) ) ;
    public final void rule__VariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4837:1: ( ( ( rule__VariableDeclaration__TypeRefAssignment_0 ) ) )
            // InternalMiniJava.g:4838:1: ( ( rule__VariableDeclaration__TypeRefAssignment_0 ) )
            {
            // InternalMiniJava.g:4838:1: ( ( rule__VariableDeclaration__TypeRefAssignment_0 ) )
            // InternalMiniJava.g:4839:2: ( rule__VariableDeclaration__TypeRefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getTypeRefAssignment_0()); 
            }
            // InternalMiniJava.g:4840:2: ( rule__VariableDeclaration__TypeRefAssignment_0 )
            // InternalMiniJava.g:4840:3: rule__VariableDeclaration__TypeRefAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__TypeRefAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getTypeRefAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__1"
    // InternalMiniJava.g:4848:1: rule__VariableDeclaration__Group__1 : rule__VariableDeclaration__Group__1__Impl ;
    public final void rule__VariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4852:1: ( rule__VariableDeclaration__Group__1__Impl )
            // InternalMiniJava.g:4853:2: rule__VariableDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__1"


    // $ANTLR start "rule__VariableDeclaration__Group__1__Impl"
    // InternalMiniJava.g:4859:1: rule__VariableDeclaration__Group__1__Impl : ( ( rule__VariableDeclaration__NameAssignment_1 ) ) ;
    public final void rule__VariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4863:1: ( ( ( rule__VariableDeclaration__NameAssignment_1 ) ) )
            // InternalMiniJava.g:4864:1: ( ( rule__VariableDeclaration__NameAssignment_1 ) )
            {
            // InternalMiniJava.g:4864:1: ( ( rule__VariableDeclaration__NameAssignment_1 ) )
            // InternalMiniJava.g:4865:2: ( rule__VariableDeclaration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_1()); 
            }
            // InternalMiniJava.g:4866:2: ( rule__VariableDeclaration__NameAssignment_1 )
            // InternalMiniJava.g:4866:3: rule__VariableDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalMiniJava.g:4875:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4879:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalMiniJava.g:4880:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__Assignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalMiniJava.g:4887:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__AssigneeAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4891:1: ( ( ( rule__Assignment__AssigneeAssignment_0 ) ) )
            // InternalMiniJava.g:4892:1: ( ( rule__Assignment__AssigneeAssignment_0 ) )
            {
            // InternalMiniJava.g:4892:1: ( ( rule__Assignment__AssigneeAssignment_0 ) )
            // InternalMiniJava.g:4893:2: ( rule__Assignment__AssigneeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getAssigneeAssignment_0()); 
            }
            // InternalMiniJava.g:4894:2: ( rule__Assignment__AssigneeAssignment_0 )
            // InternalMiniJava.g:4894:3: rule__Assignment__AssigneeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__AssigneeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getAssigneeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalMiniJava.g:4902:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4906:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalMiniJava.g:4907:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Assignment__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalMiniJava.g:4914:1: rule__Assignment__Group__1__Impl : ( '=' ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4918:1: ( ( '=' ) )
            // InternalMiniJava.g:4919:1: ( '=' )
            {
            // InternalMiniJava.g:4919:1: ( '=' )
            // InternalMiniJava.g:4920:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalMiniJava.g:4929:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4933:1: ( rule__Assignment__Group__2__Impl )
            // InternalMiniJava.g:4934:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalMiniJava.g:4940:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__ValueAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4944:1: ( ( ( rule__Assignment__ValueAssignment_2 ) ) )
            // InternalMiniJava.g:4945:1: ( ( rule__Assignment__ValueAssignment_2 ) )
            {
            // InternalMiniJava.g:4945:1: ( ( rule__Assignment__ValueAssignment_2 ) )
            // InternalMiniJava.g:4946:2: ( rule__Assignment__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getValueAssignment_2()); 
            }
            // InternalMiniJava.g:4947:2: ( rule__Assignment__ValueAssignment_2 )
            // InternalMiniJava.g:4947:3: rule__Assignment__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__ValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getValueAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalMiniJava.g:4956:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4960:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalMiniJava.g:4961:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Or__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalMiniJava.g:4968:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4972:1: ( ( ruleAnd ) )
            // InternalMiniJava.g:4973:1: ( ruleAnd )
            {
            // InternalMiniJava.g:4973:1: ( ruleAnd )
            // InternalMiniJava.g:4974:2: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalMiniJava.g:4983:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4987:1: ( rule__Or__Group__1__Impl )
            // InternalMiniJava.g:4988:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalMiniJava.g:4994:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:4998:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalMiniJava.g:4999:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalMiniJava.g:4999:1: ( ( rule__Or__Group_1__0 )* )
            // InternalMiniJava.g:5000:2: ( rule__Or__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5001:2: ( rule__Or__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==45) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalMiniJava.g:5001:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__Or__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalMiniJava.g:5010:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5014:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalMiniJava.g:5015:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_41);
            rule__Or__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalMiniJava.g:5022:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5026:1: ( ( () ) )
            // InternalMiniJava.g:5027:1: ( () )
            {
            // InternalMiniJava.g:5027:1: ( () )
            // InternalMiniJava.g:5028:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }
            // InternalMiniJava.g:5029:2: ()
            // InternalMiniJava.g:5029:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalMiniJava.g:5037:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5041:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalMiniJava.g:5042:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_25);
            rule__Or__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalMiniJava.g:5049:1: rule__Or__Group_1__1__Impl : ( '||' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5053:1: ( ( '||' ) )
            // InternalMiniJava.g:5054:1: ( '||' )
            {
            // InternalMiniJava.g:5054:1: ( '||' )
            // InternalMiniJava.g:5055:2: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalMiniJava.g:5064:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5068:1: ( rule__Or__Group_1__2__Impl )
            // InternalMiniJava.g:5069:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalMiniJava.g:5075:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5079:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalMiniJava.g:5080:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalMiniJava.g:5080:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalMiniJava.g:5081:2: ( rule__Or__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }
            // InternalMiniJava.g:5082:2: ( rule__Or__RightAssignment_1_2 )
            // InternalMiniJava.g:5082:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalMiniJava.g:5091:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5095:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalMiniJava.g:5096:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__And__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalMiniJava.g:5103:1: rule__And__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5107:1: ( ( ruleEquality ) )
            // InternalMiniJava.g:5108:1: ( ruleEquality )
            {
            // InternalMiniJava.g:5108:1: ( ruleEquality )
            // InternalMiniJava.g:5109:2: ruleEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalMiniJava.g:5118:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5122:1: ( rule__And__Group__1__Impl )
            // InternalMiniJava.g:5123:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalMiniJava.g:5129:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5133:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalMiniJava.g:5134:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalMiniJava.g:5134:1: ( ( rule__And__Group_1__0 )* )
            // InternalMiniJava.g:5135:2: ( rule__And__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5136:2: ( rule__And__Group_1__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==46) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalMiniJava.g:5136:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__And__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalMiniJava.g:5145:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5149:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalMiniJava.g:5150:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_43);
            rule__And__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalMiniJava.g:5157:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5161:1: ( ( () ) )
            // InternalMiniJava.g:5162:1: ( () )
            {
            // InternalMiniJava.g:5162:1: ( () )
            // InternalMiniJava.g:5163:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }
            // InternalMiniJava.g:5164:2: ()
            // InternalMiniJava.g:5164:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalMiniJava.g:5172:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5176:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalMiniJava.g:5177:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_25);
            rule__And__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalMiniJava.g:5184:1: rule__And__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5188:1: ( ( '&&' ) )
            // InternalMiniJava.g:5189:1: ( '&&' )
            {
            // InternalMiniJava.g:5189:1: ( '&&' )
            // InternalMiniJava.g:5190:2: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalMiniJava.g:5199:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5203:1: ( rule__And__Group_1__2__Impl )
            // InternalMiniJava.g:5204:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalMiniJava.g:5210:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5214:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalMiniJava.g:5215:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalMiniJava.g:5215:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalMiniJava.g:5216:2: ( rule__And__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }
            // InternalMiniJava.g:5217:2: ( rule__And__RightAssignment_1_2 )
            // InternalMiniJava.g:5217:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Equality__Group__0"
    // InternalMiniJava.g:5226:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5230:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // InternalMiniJava.g:5231:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__Equality__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0"


    // $ANTLR start "rule__Equality__Group__0__Impl"
    // InternalMiniJava.g:5238:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5242:1: ( ( ruleComparison ) )
            // InternalMiniJava.g:5243:1: ( ruleComparison )
            {
            // InternalMiniJava.g:5243:1: ( ruleComparison )
            // InternalMiniJava.g:5244:2: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0__Impl"


    // $ANTLR start "rule__Equality__Group__1"
    // InternalMiniJava.g:5253:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5257:1: ( rule__Equality__Group__1__Impl )
            // InternalMiniJava.g:5258:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1"


    // $ANTLR start "rule__Equality__Group__1__Impl"
    // InternalMiniJava.g:5264:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5268:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // InternalMiniJava.g:5269:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // InternalMiniJava.g:5269:1: ( ( rule__Equality__Group_1__0 )* )
            // InternalMiniJava.g:5270:2: ( rule__Equality__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5271:2: ( rule__Equality__Group_1__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=47 && LA46_0<=48)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalMiniJava.g:5271:3: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_46);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__0"
    // InternalMiniJava.g:5280:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5284:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // InternalMiniJava.g:5285:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0"


    // $ANTLR start "rule__Equality__Group_1__0__Impl"
    // InternalMiniJava.g:5292:1: rule__Equality__Group_1__0__Impl : ( ( rule__Equality__Alternatives_1_0 ) ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5296:1: ( ( ( rule__Equality__Alternatives_1_0 ) ) )
            // InternalMiniJava.g:5297:1: ( ( rule__Equality__Alternatives_1_0 ) )
            {
            // InternalMiniJava.g:5297:1: ( ( rule__Equality__Alternatives_1_0 ) )
            // InternalMiniJava.g:5298:2: ( rule__Equality__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 
            }
            // InternalMiniJava.g:5299:2: ( rule__Equality__Alternatives_1_0 )
            // InternalMiniJava.g:5299:3: rule__Equality__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1__1"
    // InternalMiniJava.g:5307:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5311:1: ( rule__Equality__Group_1__1__Impl )
            // InternalMiniJava.g:5312:2: rule__Equality__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1"


    // $ANTLR start "rule__Equality__Group_1__1__Impl"
    // InternalMiniJava.g:5318:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__RightAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5322:1: ( ( ( rule__Equality__RightAssignment_1_1 ) ) )
            // InternalMiniJava.g:5323:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            {
            // InternalMiniJava.g:5323:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            // InternalMiniJava.g:5324:2: ( rule__Equality__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 
            }
            // InternalMiniJava.g:5325:2: ( rule__Equality__RightAssignment_1_1 )
            // InternalMiniJava.g:5325:3: rule__Equality__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Equality__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_0__0"
    // InternalMiniJava.g:5334:1: rule__Equality__Group_1_0_0__0 : rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 ;
    public final void rule__Equality__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5338:1: ( rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 )
            // InternalMiniJava.g:5339:2: rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1
            {
            pushFollow(FOLLOW_47);
            rule__Equality__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__0"


    // $ANTLR start "rule__Equality__Group_1_0_0__0__Impl"
    // InternalMiniJava.g:5346:1: rule__Equality__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5350:1: ( ( () ) )
            // InternalMiniJava.g:5351:1: ( () )
            {
            // InternalMiniJava.g:5351:1: ( () )
            // InternalMiniJava.g:5352:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0_0_0()); 
            }
            // InternalMiniJava.g:5353:2: ()
            // InternalMiniJava.g:5353:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_0__1"
    // InternalMiniJava.g:5361:1: rule__Equality__Group_1_0_0__1 : rule__Equality__Group_1_0_0__1__Impl ;
    public final void rule__Equality__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5365:1: ( rule__Equality__Group_1_0_0__1__Impl )
            // InternalMiniJava.g:5366:2: rule__Equality__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__1"


    // $ANTLR start "rule__Equality__Group_1_0_0__1__Impl"
    // InternalMiniJava.g:5372:1: rule__Equality__Group_1_0_0__1__Impl : ( '==' ) ;
    public final void rule__Equality__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5376:1: ( ( '==' ) )
            // InternalMiniJava.g:5377:1: ( '==' )
            {
            // InternalMiniJava.g:5377:1: ( '==' )
            // InternalMiniJava.g:5378:2: '=='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_1__0"
    // InternalMiniJava.g:5388:1: rule__Equality__Group_1_0_1__0 : rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 ;
    public final void rule__Equality__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5392:1: ( rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 )
            // InternalMiniJava.g:5393:2: rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1
            {
            pushFollow(FOLLOW_45);
            rule__Equality__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__0"


    // $ANTLR start "rule__Equality__Group_1_0_1__0__Impl"
    // InternalMiniJava.g:5400:1: rule__Equality__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5404:1: ( ( () ) )
            // InternalMiniJava.g:5405:1: ( () )
            {
            // InternalMiniJava.g:5405:1: ( () )
            // InternalMiniJava.g:5406:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getInequalityLeftAction_1_0_1_0()); 
            }
            // InternalMiniJava.g:5407:2: ()
            // InternalMiniJava.g:5407:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getInequalityLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_1__1"
    // InternalMiniJava.g:5415:1: rule__Equality__Group_1_0_1__1 : rule__Equality__Group_1_0_1__1__Impl ;
    public final void rule__Equality__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5419:1: ( rule__Equality__Group_1_0_1__1__Impl )
            // InternalMiniJava.g:5420:2: rule__Equality__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__1"


    // $ANTLR start "rule__Equality__Group_1_0_1__1__Impl"
    // InternalMiniJava.g:5426:1: rule__Equality__Group_1_0_1__1__Impl : ( '!=' ) ;
    public final void rule__Equality__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5430:1: ( ( '!=' ) )
            // InternalMiniJava.g:5431:1: ( '!=' )
            {
            // InternalMiniJava.g:5431:1: ( '!=' )
            // InternalMiniJava.g:5432:2: '!='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalMiniJava.g:5442:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5446:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalMiniJava.g:5447:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__Comparison__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalMiniJava.g:5454:1: rule__Comparison__Group__0__Impl : ( ruleModulo ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5458:1: ( ( ruleModulo ) )
            // InternalMiniJava.g:5459:1: ( ruleModulo )
            {
            // InternalMiniJava.g:5459:1: ( ruleModulo )
            // InternalMiniJava.g:5460:2: ruleModulo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getModuloParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getModuloParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalMiniJava.g:5469:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5473:1: ( rule__Comparison__Group__1__Impl )
            // InternalMiniJava.g:5474:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalMiniJava.g:5480:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5484:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // InternalMiniJava.g:5485:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // InternalMiniJava.g:5485:1: ( ( rule__Comparison__Group_1__0 )* )
            // InternalMiniJava.g:5486:2: ( rule__Comparison__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5487:2: ( rule__Comparison__Group_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=49 && LA47_0<=52)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMiniJava.g:5487:3: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__0"
    // InternalMiniJava.g:5496:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5500:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // InternalMiniJava.g:5501:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0"


    // $ANTLR start "rule__Comparison__Group_1__0__Impl"
    // InternalMiniJava.g:5508:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Alternatives_1_0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5512:1: ( ( ( rule__Comparison__Alternatives_1_0 ) ) )
            // InternalMiniJava.g:5513:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            {
            // InternalMiniJava.g:5513:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            // InternalMiniJava.g:5514:2: ( rule__Comparison__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 
            }
            // InternalMiniJava.g:5515:2: ( rule__Comparison__Alternatives_1_0 )
            // InternalMiniJava.g:5515:3: rule__Comparison__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1__1"
    // InternalMiniJava.g:5523:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5527:1: ( rule__Comparison__Group_1__1__Impl )
            // InternalMiniJava.g:5528:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1"


    // $ANTLR start "rule__Comparison__Group_1__1__Impl"
    // InternalMiniJava.g:5534:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5538:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // InternalMiniJava.g:5539:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // InternalMiniJava.g:5539:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // InternalMiniJava.g:5540:2: ( rule__Comparison__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }
            // InternalMiniJava.g:5541:2: ( rule__Comparison__RightAssignment_1_1 )
            // InternalMiniJava.g:5541:3: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_0__0"
    // InternalMiniJava.g:5550:1: rule__Comparison__Group_1_0_0__0 : rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 ;
    public final void rule__Comparison__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5554:1: ( rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 )
            // InternalMiniJava.g:5555:2: rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1
            {
            pushFollow(FOLLOW_50);
            rule__Comparison__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__0"


    // $ANTLR start "rule__Comparison__Group_1_0_0__0__Impl"
    // InternalMiniJava.g:5562:1: rule__Comparison__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5566:1: ( ( () ) )
            // InternalMiniJava.g:5567:1: ( () )
            {
            // InternalMiniJava.g:5567:1: ( () )
            // InternalMiniJava.g:5568:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getSuperiorOrEqualLeftAction_1_0_0_0()); 
            }
            // InternalMiniJava.g:5569:2: ()
            // InternalMiniJava.g:5569:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getSuperiorOrEqualLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_0__1"
    // InternalMiniJava.g:5577:1: rule__Comparison__Group_1_0_0__1 : rule__Comparison__Group_1_0_0__1__Impl ;
    public final void rule__Comparison__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5581:1: ( rule__Comparison__Group_1_0_0__1__Impl )
            // InternalMiniJava.g:5582:2: rule__Comparison__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__1"


    // $ANTLR start "rule__Comparison__Group_1_0_0__1__Impl"
    // InternalMiniJava.g:5588:1: rule__Comparison__Group_1_0_0__1__Impl : ( '>=' ) ;
    public final void rule__Comparison__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5592:1: ( ( '>=' ) )
            // InternalMiniJava.g:5593:1: ( '>=' )
            {
            // InternalMiniJava.g:5593:1: ( '>=' )
            // InternalMiniJava.g:5594:2: '>='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_0_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_1__0"
    // InternalMiniJava.g:5604:1: rule__Comparison__Group_1_0_1__0 : rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 ;
    public final void rule__Comparison__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5608:1: ( rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 )
            // InternalMiniJava.g:5609:2: rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1
            {
            pushFollow(FOLLOW_51);
            rule__Comparison__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__0"


    // $ANTLR start "rule__Comparison__Group_1_0_1__0__Impl"
    // InternalMiniJava.g:5616:1: rule__Comparison__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5620:1: ( ( () ) )
            // InternalMiniJava.g:5621:1: ( () )
            {
            // InternalMiniJava.g:5621:1: ( () )
            // InternalMiniJava.g:5622:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getInferiorOrEqualLeftAction_1_0_1_0()); 
            }
            // InternalMiniJava.g:5623:2: ()
            // InternalMiniJava.g:5623:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getInferiorOrEqualLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_1__1"
    // InternalMiniJava.g:5631:1: rule__Comparison__Group_1_0_1__1 : rule__Comparison__Group_1_0_1__1__Impl ;
    public final void rule__Comparison__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5635:1: ( rule__Comparison__Group_1_0_1__1__Impl )
            // InternalMiniJava.g:5636:2: rule__Comparison__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__1"


    // $ANTLR start "rule__Comparison__Group_1_0_1__1__Impl"
    // InternalMiniJava.g:5642:1: rule__Comparison__Group_1_0_1__1__Impl : ( '<=' ) ;
    public final void rule__Comparison__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5646:1: ( ( '<=' ) )
            // InternalMiniJava.g:5647:1: ( '<=' )
            {
            // InternalMiniJava.g:5647:1: ( '<=' )
            // InternalMiniJava.g:5648:2: '<='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_2__0"
    // InternalMiniJava.g:5658:1: rule__Comparison__Group_1_0_2__0 : rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 ;
    public final void rule__Comparison__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5662:1: ( rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 )
            // InternalMiniJava.g:5663:2: rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1
            {
            pushFollow(FOLLOW_52);
            rule__Comparison__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__0"


    // $ANTLR start "rule__Comparison__Group_1_0_2__0__Impl"
    // InternalMiniJava.g:5670:1: rule__Comparison__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5674:1: ( ( () ) )
            // InternalMiniJava.g:5675:1: ( () )
            {
            // InternalMiniJava.g:5675:1: ( () )
            // InternalMiniJava.g:5676:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getSuperiorLeftAction_1_0_2_0()); 
            }
            // InternalMiniJava.g:5677:2: ()
            // InternalMiniJava.g:5677:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getSuperiorLeftAction_1_0_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_2__1"
    // InternalMiniJava.g:5685:1: rule__Comparison__Group_1_0_2__1 : rule__Comparison__Group_1_0_2__1__Impl ;
    public final void rule__Comparison__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5689:1: ( rule__Comparison__Group_1_0_2__1__Impl )
            // InternalMiniJava.g:5690:2: rule__Comparison__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__1"


    // $ANTLR start "rule__Comparison__Group_1_0_2__1__Impl"
    // InternalMiniJava.g:5696:1: rule__Comparison__Group_1_0_2__1__Impl : ( '>' ) ;
    public final void rule__Comparison__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5700:1: ( ( '>' ) )
            // InternalMiniJava.g:5701:1: ( '>' )
            {
            // InternalMiniJava.g:5701:1: ( '>' )
            // InternalMiniJava.g:5702:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_3__0"
    // InternalMiniJava.g:5712:1: rule__Comparison__Group_1_0_3__0 : rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 ;
    public final void rule__Comparison__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5716:1: ( rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 )
            // InternalMiniJava.g:5717:2: rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1
            {
            pushFollow(FOLLOW_48);
            rule__Comparison__Group_1_0_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__0"


    // $ANTLR start "rule__Comparison__Group_1_0_3__0__Impl"
    // InternalMiniJava.g:5724:1: rule__Comparison__Group_1_0_3__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5728:1: ( ( () ) )
            // InternalMiniJava.g:5729:1: ( () )
            {
            // InternalMiniJava.g:5729:1: ( () )
            // InternalMiniJava.g:5730:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getInferiorLeftAction_1_0_3_0()); 
            }
            // InternalMiniJava.g:5731:2: ()
            // InternalMiniJava.g:5731:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getInferiorLeftAction_1_0_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_3__1"
    // InternalMiniJava.g:5739:1: rule__Comparison__Group_1_0_3__1 : rule__Comparison__Group_1_0_3__1__Impl ;
    public final void rule__Comparison__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5743:1: ( rule__Comparison__Group_1_0_3__1__Impl )
            // InternalMiniJava.g:5744:2: rule__Comparison__Group_1_0_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1_0_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__1"


    // $ANTLR start "rule__Comparison__Group_1_0_3__1__Impl"
    // InternalMiniJava.g:5750:1: rule__Comparison__Group_1_0_3__1__Impl : ( '<' ) ;
    public final void rule__Comparison__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5754:1: ( ( '<' ) )
            // InternalMiniJava.g:5755:1: ( '<' )
            {
            // InternalMiniJava.g:5755:1: ( '<' )
            // InternalMiniJava.g:5756:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_3_1()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__1__Impl"


    // $ANTLR start "rule__Modulo__Group__0"
    // InternalMiniJava.g:5766:1: rule__Modulo__Group__0 : rule__Modulo__Group__0__Impl rule__Modulo__Group__1 ;
    public final void rule__Modulo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5770:1: ( rule__Modulo__Group__0__Impl rule__Modulo__Group__1 )
            // InternalMiniJava.g:5771:2: rule__Modulo__Group__0__Impl rule__Modulo__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__Modulo__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__0"


    // $ANTLR start "rule__Modulo__Group__0__Impl"
    // InternalMiniJava.g:5778:1: rule__Modulo__Group__0__Impl : ( rulePlusOrMinus ) ;
    public final void rule__Modulo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5782:1: ( ( rulePlusOrMinus ) )
            // InternalMiniJava.g:5783:1: ( rulePlusOrMinus )
            {
            // InternalMiniJava.g:5783:1: ( rulePlusOrMinus )
            // InternalMiniJava.g:5784:2: rulePlusOrMinus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getPlusOrMinusParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getPlusOrMinusParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__0__Impl"


    // $ANTLR start "rule__Modulo__Group__1"
    // InternalMiniJava.g:5793:1: rule__Modulo__Group__1 : rule__Modulo__Group__1__Impl ;
    public final void rule__Modulo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5797:1: ( rule__Modulo__Group__1__Impl )
            // InternalMiniJava.g:5798:2: rule__Modulo__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__1"


    // $ANTLR start "rule__Modulo__Group__1__Impl"
    // InternalMiniJava.g:5804:1: rule__Modulo__Group__1__Impl : ( ( rule__Modulo__Group_1__0 )* ) ;
    public final void rule__Modulo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5808:1: ( ( ( rule__Modulo__Group_1__0 )* ) )
            // InternalMiniJava.g:5809:1: ( ( rule__Modulo__Group_1__0 )* )
            {
            // InternalMiniJava.g:5809:1: ( ( rule__Modulo__Group_1__0 )* )
            // InternalMiniJava.g:5810:2: ( rule__Modulo__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5811:2: ( rule__Modulo__Group_1__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==53) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalMiniJava.g:5811:3: rule__Modulo__Group_1__0
            	    {
            	    pushFollow(FOLLOW_54);
            	    rule__Modulo__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__1__Impl"


    // $ANTLR start "rule__Modulo__Group_1__0"
    // InternalMiniJava.g:5820:1: rule__Modulo__Group_1__0 : rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 ;
    public final void rule__Modulo__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5824:1: ( rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 )
            // InternalMiniJava.g:5825:2: rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__Modulo__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__0"


    // $ANTLR start "rule__Modulo__Group_1__0__Impl"
    // InternalMiniJava.g:5832:1: rule__Modulo__Group_1__0__Impl : ( ( rule__Modulo__Group_1_0__0 ) ) ;
    public final void rule__Modulo__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5836:1: ( ( ( rule__Modulo__Group_1_0__0 ) ) )
            // InternalMiniJava.g:5837:1: ( ( rule__Modulo__Group_1_0__0 ) )
            {
            // InternalMiniJava.g:5837:1: ( ( rule__Modulo__Group_1_0__0 ) )
            // InternalMiniJava.g:5838:2: ( rule__Modulo__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getGroup_1_0()); 
            }
            // InternalMiniJava.g:5839:2: ( rule__Modulo__Group_1_0__0 )
            // InternalMiniJava.g:5839:3: rule__Modulo__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__0__Impl"


    // $ANTLR start "rule__Modulo__Group_1__1"
    // InternalMiniJava.g:5847:1: rule__Modulo__Group_1__1 : rule__Modulo__Group_1__1__Impl ;
    public final void rule__Modulo__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5851:1: ( rule__Modulo__Group_1__1__Impl )
            // InternalMiniJava.g:5852:2: rule__Modulo__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__1"


    // $ANTLR start "rule__Modulo__Group_1__1__Impl"
    // InternalMiniJava.g:5858:1: rule__Modulo__Group_1__1__Impl : ( ( rule__Modulo__RightAssignment_1_1 ) ) ;
    public final void rule__Modulo__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5862:1: ( ( ( rule__Modulo__RightAssignment_1_1 ) ) )
            // InternalMiniJava.g:5863:1: ( ( rule__Modulo__RightAssignment_1_1 ) )
            {
            // InternalMiniJava.g:5863:1: ( ( rule__Modulo__RightAssignment_1_1 ) )
            // InternalMiniJava.g:5864:2: ( rule__Modulo__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getRightAssignment_1_1()); 
            }
            // InternalMiniJava.g:5865:2: ( rule__Modulo__RightAssignment_1_1 )
            // InternalMiniJava.g:5865:3: rule__Modulo__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__1__Impl"


    // $ANTLR start "rule__Modulo__Group_1_0__0"
    // InternalMiniJava.g:5874:1: rule__Modulo__Group_1_0__0 : rule__Modulo__Group_1_0__0__Impl rule__Modulo__Group_1_0__1 ;
    public final void rule__Modulo__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5878:1: ( rule__Modulo__Group_1_0__0__Impl rule__Modulo__Group_1_0__1 )
            // InternalMiniJava.g:5879:2: rule__Modulo__Group_1_0__0__Impl rule__Modulo__Group_1_0__1
            {
            pushFollow(FOLLOW_53);
            rule__Modulo__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1_0__0"


    // $ANTLR start "rule__Modulo__Group_1_0__0__Impl"
    // InternalMiniJava.g:5886:1: rule__Modulo__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Modulo__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5890:1: ( ( () ) )
            // InternalMiniJava.g:5891:1: ( () )
            {
            // InternalMiniJava.g:5891:1: ( () )
            // InternalMiniJava.g:5892:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getModuloLeftAction_1_0_0()); 
            }
            // InternalMiniJava.g:5893:2: ()
            // InternalMiniJava.g:5893:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getModuloLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1_0__0__Impl"


    // $ANTLR start "rule__Modulo__Group_1_0__1"
    // InternalMiniJava.g:5901:1: rule__Modulo__Group_1_0__1 : rule__Modulo__Group_1_0__1__Impl ;
    public final void rule__Modulo__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5905:1: ( rule__Modulo__Group_1_0__1__Impl )
            // InternalMiniJava.g:5906:2: rule__Modulo__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1_0__1"


    // $ANTLR start "rule__Modulo__Group_1_0__1__Impl"
    // InternalMiniJava.g:5912:1: rule__Modulo__Group_1_0__1__Impl : ( '%' ) ;
    public final void rule__Modulo__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5916:1: ( ( '%' ) )
            // InternalMiniJava.g:5917:1: ( '%' )
            {
            // InternalMiniJava.g:5917:1: ( '%' )
            // InternalMiniJava.g:5918:2: '%'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getPercentSignKeyword_1_0_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getPercentSignKeyword_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1_0__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__0"
    // InternalMiniJava.g:5928:1: rule__PlusOrMinus__Group__0 : rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 ;
    public final void rule__PlusOrMinus__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5932:1: ( rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 )
            // InternalMiniJava.g:5933:2: rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__PlusOrMinus__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0"


    // $ANTLR start "rule__PlusOrMinus__Group__0__Impl"
    // InternalMiniJava.g:5940:1: rule__PlusOrMinus__Group__0__Impl : ( ruleMulOrDiv ) ;
    public final void rule__PlusOrMinus__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5944:1: ( ( ruleMulOrDiv ) )
            // InternalMiniJava.g:5945:1: ( ruleMulOrDiv )
            {
            // InternalMiniJava.g:5945:1: ( ruleMulOrDiv )
            // InternalMiniJava.g:5946:2: ruleMulOrDiv
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__1"
    // InternalMiniJava.g:5955:1: rule__PlusOrMinus__Group__1 : rule__PlusOrMinus__Group__1__Impl ;
    public final void rule__PlusOrMinus__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5959:1: ( rule__PlusOrMinus__Group__1__Impl )
            // InternalMiniJava.g:5960:2: rule__PlusOrMinus__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1"


    // $ANTLR start "rule__PlusOrMinus__Group__1__Impl"
    // InternalMiniJava.g:5966:1: rule__PlusOrMinus__Group__1__Impl : ( ( rule__PlusOrMinus__Group_1__0 )* ) ;
    public final void rule__PlusOrMinus__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5970:1: ( ( ( rule__PlusOrMinus__Group_1__0 )* ) )
            // InternalMiniJava.g:5971:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            {
            // InternalMiniJava.g:5971:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            // InternalMiniJava.g:5972:2: ( rule__PlusOrMinus__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:5973:2: ( rule__PlusOrMinus__Group_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=54 && LA49_0<=55)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalMiniJava.g:5973:3: rule__PlusOrMinus__Group_1__0
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__PlusOrMinus__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0"
    // InternalMiniJava.g:5982:1: rule__PlusOrMinus__Group_1__0 : rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 ;
    public final void rule__PlusOrMinus__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5986:1: ( rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 )
            // InternalMiniJava.g:5987:2: rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__PlusOrMinus__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0__Impl"
    // InternalMiniJava.g:5994:1: rule__PlusOrMinus__Group_1__0__Impl : ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) ;
    public final void rule__PlusOrMinus__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:5998:1: ( ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) )
            // InternalMiniJava.g:5999:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            {
            // InternalMiniJava.g:5999:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            // InternalMiniJava.g:6000:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 
            }
            // InternalMiniJava.g:6001:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            // InternalMiniJava.g:6001:3: rule__PlusOrMinus__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1"
    // InternalMiniJava.g:6009:1: rule__PlusOrMinus__Group_1__1 : rule__PlusOrMinus__Group_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6013:1: ( rule__PlusOrMinus__Group_1__1__Impl )
            // InternalMiniJava.g:6014:2: rule__PlusOrMinus__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1__Impl"
    // InternalMiniJava.g:6020:1: rule__PlusOrMinus__Group_1__1__Impl : ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) ;
    public final void rule__PlusOrMinus__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6024:1: ( ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) )
            // InternalMiniJava.g:6025:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            {
            // InternalMiniJava.g:6025:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            // InternalMiniJava.g:6026:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 
            }
            // InternalMiniJava.g:6027:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            // InternalMiniJava.g:6027:3: rule__PlusOrMinus__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0"
    // InternalMiniJava.g:6036:1: rule__PlusOrMinus__Group_1_0_0__0 : rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 ;
    public final void rule__PlusOrMinus__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6040:1: ( rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 )
            // InternalMiniJava.g:6041:2: rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1
            {
            pushFollow(FOLLOW_57);
            rule__PlusOrMinus__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0__Impl"
    // InternalMiniJava.g:6048:1: rule__PlusOrMinus__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6052:1: ( ( () ) )
            // InternalMiniJava.g:6053:1: ( () )
            {
            // InternalMiniJava.g:6053:1: ( () )
            // InternalMiniJava.g:6054:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 
            }
            // InternalMiniJava.g:6055:2: ()
            // InternalMiniJava.g:6055:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1"
    // InternalMiniJava.g:6063:1: rule__PlusOrMinus__Group_1_0_0__1 : rule__PlusOrMinus__Group_1_0_0__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6067:1: ( rule__PlusOrMinus__Group_1_0_0__1__Impl )
            // InternalMiniJava.g:6068:2: rule__PlusOrMinus__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1__Impl"
    // InternalMiniJava.g:6074:1: rule__PlusOrMinus__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6078:1: ( ( '+' ) )
            // InternalMiniJava.g:6079:1: ( '+' )
            {
            // InternalMiniJava.g:6079:1: ( '+' )
            // InternalMiniJava.g:6080:2: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0"
    // InternalMiniJava.g:6090:1: rule__PlusOrMinus__Group_1_0_1__0 : rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 ;
    public final void rule__PlusOrMinus__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6094:1: ( rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 )
            // InternalMiniJava.g:6095:2: rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1
            {
            pushFollow(FOLLOW_55);
            rule__PlusOrMinus__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0__Impl"
    // InternalMiniJava.g:6102:1: rule__PlusOrMinus__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6106:1: ( ( () ) )
            // InternalMiniJava.g:6107:1: ( () )
            {
            // InternalMiniJava.g:6107:1: ( () )
            // InternalMiniJava.g:6108:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 
            }
            // InternalMiniJava.g:6109:2: ()
            // InternalMiniJava.g:6109:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1"
    // InternalMiniJava.g:6117:1: rule__PlusOrMinus__Group_1_0_1__1 : rule__PlusOrMinus__Group_1_0_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6121:1: ( rule__PlusOrMinus__Group_1_0_1__1__Impl )
            // InternalMiniJava.g:6122:2: rule__PlusOrMinus__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1__Impl"
    // InternalMiniJava.g:6128:1: rule__PlusOrMinus__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6132:1: ( ( '-' ) )
            // InternalMiniJava.g:6133:1: ( '-' )
            {
            // InternalMiniJava.g:6133:1: ( '-' )
            // InternalMiniJava.g:6134:2: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__0"
    // InternalMiniJava.g:6144:1: rule__MulOrDiv__Group__0 : rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 ;
    public final void rule__MulOrDiv__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6148:1: ( rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 )
            // InternalMiniJava.g:6149:2: rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1
            {
            pushFollow(FOLLOW_58);
            rule__MulOrDiv__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0"


    // $ANTLR start "rule__MulOrDiv__Group__0__Impl"
    // InternalMiniJava.g:6156:1: rule__MulOrDiv__Group__0__Impl : ( ruleArrayAccess ) ;
    public final void rule__MulOrDiv__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6160:1: ( ( ruleArrayAccess ) )
            // InternalMiniJava.g:6161:1: ( ruleArrayAccess )
            {
            // InternalMiniJava.g:6161:1: ( ruleArrayAccess )
            // InternalMiniJava.g:6162:2: ruleArrayAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getArrayAccessParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getArrayAccessParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__1"
    // InternalMiniJava.g:6171:1: rule__MulOrDiv__Group__1 : rule__MulOrDiv__Group__1__Impl ;
    public final void rule__MulOrDiv__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6175:1: ( rule__MulOrDiv__Group__1__Impl )
            // InternalMiniJava.g:6176:2: rule__MulOrDiv__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1"


    // $ANTLR start "rule__MulOrDiv__Group__1__Impl"
    // InternalMiniJava.g:6182:1: rule__MulOrDiv__Group__1__Impl : ( ( rule__MulOrDiv__Group_1__0 )* ) ;
    public final void rule__MulOrDiv__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6186:1: ( ( ( rule__MulOrDiv__Group_1__0 )* ) )
            // InternalMiniJava.g:6187:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            {
            // InternalMiniJava.g:6187:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            // InternalMiniJava.g:6188:2: ( rule__MulOrDiv__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:6189:2: ( rule__MulOrDiv__Group_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=56 && LA50_0<=57)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMiniJava.g:6189:3: rule__MulOrDiv__Group_1__0
            	    {
            	    pushFollow(FOLLOW_59);
            	    rule__MulOrDiv__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__0"
    // InternalMiniJava.g:6198:1: rule__MulOrDiv__Group_1__0 : rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 ;
    public final void rule__MulOrDiv__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6202:1: ( rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 )
            // InternalMiniJava.g:6203:2: rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__MulOrDiv__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0"


    // $ANTLR start "rule__MulOrDiv__Group_1__0__Impl"
    // InternalMiniJava.g:6210:1: rule__MulOrDiv__Group_1__0__Impl : ( ( rule__MulOrDiv__Alternatives_1_0 ) ) ;
    public final void rule__MulOrDiv__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6214:1: ( ( ( rule__MulOrDiv__Alternatives_1_0 ) ) )
            // InternalMiniJava.g:6215:1: ( ( rule__MulOrDiv__Alternatives_1_0 ) )
            {
            // InternalMiniJava.g:6215:1: ( ( rule__MulOrDiv__Alternatives_1_0 ) )
            // InternalMiniJava.g:6216:2: ( rule__MulOrDiv__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getAlternatives_1_0()); 
            }
            // InternalMiniJava.g:6217:2: ( rule__MulOrDiv__Alternatives_1_0 )
            // InternalMiniJava.g:6217:3: rule__MulOrDiv__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__1"
    // InternalMiniJava.g:6225:1: rule__MulOrDiv__Group_1__1 : rule__MulOrDiv__Group_1__1__Impl ;
    public final void rule__MulOrDiv__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6229:1: ( rule__MulOrDiv__Group_1__1__Impl )
            // InternalMiniJava.g:6230:2: rule__MulOrDiv__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1"


    // $ANTLR start "rule__MulOrDiv__Group_1__1__Impl"
    // InternalMiniJava.g:6236:1: rule__MulOrDiv__Group_1__1__Impl : ( ( rule__MulOrDiv__RightAssignment_1_1 ) ) ;
    public final void rule__MulOrDiv__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6240:1: ( ( ( rule__MulOrDiv__RightAssignment_1_1 ) ) )
            // InternalMiniJava.g:6241:1: ( ( rule__MulOrDiv__RightAssignment_1_1 ) )
            {
            // InternalMiniJava.g:6241:1: ( ( rule__MulOrDiv__RightAssignment_1_1 ) )
            // InternalMiniJava.g:6242:2: ( rule__MulOrDiv__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getRightAssignment_1_1()); 
            }
            // InternalMiniJava.g:6243:2: ( rule__MulOrDiv__RightAssignment_1_1 )
            // InternalMiniJava.g:6243:3: rule__MulOrDiv__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_0__0"
    // InternalMiniJava.g:6252:1: rule__MulOrDiv__Group_1_0_0__0 : rule__MulOrDiv__Group_1_0_0__0__Impl rule__MulOrDiv__Group_1_0_0__1 ;
    public final void rule__MulOrDiv__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6256:1: ( rule__MulOrDiv__Group_1_0_0__0__Impl rule__MulOrDiv__Group_1_0_0__1 )
            // InternalMiniJava.g:6257:2: rule__MulOrDiv__Group_1_0_0__0__Impl rule__MulOrDiv__Group_1_0_0__1
            {
            pushFollow(FOLLOW_60);
            rule__MulOrDiv__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_0__0"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_0__0__Impl"
    // InternalMiniJava.g:6264:1: rule__MulOrDiv__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__MulOrDiv__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6268:1: ( ( () ) )
            // InternalMiniJava.g:6269:1: ( () )
            {
            // InternalMiniJava.g:6269:1: ( () )
            // InternalMiniJava.g:6270:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getMultiplicationLeftAction_1_0_0_0()); 
            }
            // InternalMiniJava.g:6271:2: ()
            // InternalMiniJava.g:6271:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getMultiplicationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_0__1"
    // InternalMiniJava.g:6279:1: rule__MulOrDiv__Group_1_0_0__1 : rule__MulOrDiv__Group_1_0_0__1__Impl ;
    public final void rule__MulOrDiv__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6283:1: ( rule__MulOrDiv__Group_1_0_0__1__Impl )
            // InternalMiniJava.g:6284:2: rule__MulOrDiv__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_0__1"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_0__1__Impl"
    // InternalMiniJava.g:6290:1: rule__MulOrDiv__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__MulOrDiv__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6294:1: ( ( '*' ) )
            // InternalMiniJava.g:6295:1: ( '*' )
            {
            // InternalMiniJava.g:6295:1: ( '*' )
            // InternalMiniJava.g:6296:2: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getAsteriskKeyword_1_0_0_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getAsteriskKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_1__0"
    // InternalMiniJava.g:6306:1: rule__MulOrDiv__Group_1_0_1__0 : rule__MulOrDiv__Group_1_0_1__0__Impl rule__MulOrDiv__Group_1_0_1__1 ;
    public final void rule__MulOrDiv__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6310:1: ( rule__MulOrDiv__Group_1_0_1__0__Impl rule__MulOrDiv__Group_1_0_1__1 )
            // InternalMiniJava.g:6311:2: rule__MulOrDiv__Group_1_0_1__0__Impl rule__MulOrDiv__Group_1_0_1__1
            {
            pushFollow(FOLLOW_58);
            rule__MulOrDiv__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_1__0"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_1__0__Impl"
    // InternalMiniJava.g:6318:1: rule__MulOrDiv__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__MulOrDiv__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6322:1: ( ( () ) )
            // InternalMiniJava.g:6323:1: ( () )
            {
            // InternalMiniJava.g:6323:1: ( () )
            // InternalMiniJava.g:6324:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getDivisionLeftAction_1_0_1_0()); 
            }
            // InternalMiniJava.g:6325:2: ()
            // InternalMiniJava.g:6325:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getDivisionLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_1__1"
    // InternalMiniJava.g:6333:1: rule__MulOrDiv__Group_1_0_1__1 : rule__MulOrDiv__Group_1_0_1__1__Impl ;
    public final void rule__MulOrDiv__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6337:1: ( rule__MulOrDiv__Group_1_0_1__1__Impl )
            // InternalMiniJava.g:6338:2: rule__MulOrDiv__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_1__1"


    // $ANTLR start "rule__MulOrDiv__Group_1_0_1__1__Impl"
    // InternalMiniJava.g:6344:1: rule__MulOrDiv__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__MulOrDiv__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6348:1: ( ( '/' ) )
            // InternalMiniJava.g:6349:1: ( '/' )
            {
            // InternalMiniJava.g:6349:1: ( '/' )
            // InternalMiniJava.g:6350:2: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getSolidusKeyword_1_0_1_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getSolidusKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__ArrayAccess__Group__0"
    // InternalMiniJava.g:6360:1: rule__ArrayAccess__Group__0 : rule__ArrayAccess__Group__0__Impl rule__ArrayAccess__Group__1 ;
    public final void rule__ArrayAccess__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6364:1: ( rule__ArrayAccess__Group__0__Impl rule__ArrayAccess__Group__1 )
            // InternalMiniJava.g:6365:2: rule__ArrayAccess__Group__0__Impl rule__ArrayAccess__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__ArrayAccess__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group__0"


    // $ANTLR start "rule__ArrayAccess__Group__0__Impl"
    // InternalMiniJava.g:6372:1: rule__ArrayAccess__Group__0__Impl : ( ruleArrayLength ) ;
    public final void rule__ArrayAccess__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6376:1: ( ( ruleArrayLength ) )
            // InternalMiniJava.g:6377:1: ( ruleArrayLength )
            {
            // InternalMiniJava.g:6377:1: ( ruleArrayLength )
            // InternalMiniJava.g:6378:2: ruleArrayLength
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getArrayLengthParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayLength();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getArrayLengthParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group__0__Impl"


    // $ANTLR start "rule__ArrayAccess__Group__1"
    // InternalMiniJava.g:6387:1: rule__ArrayAccess__Group__1 : rule__ArrayAccess__Group__1__Impl ;
    public final void rule__ArrayAccess__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6391:1: ( rule__ArrayAccess__Group__1__Impl )
            // InternalMiniJava.g:6392:2: rule__ArrayAccess__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group__1"


    // $ANTLR start "rule__ArrayAccess__Group__1__Impl"
    // InternalMiniJava.g:6398:1: rule__ArrayAccess__Group__1__Impl : ( ( rule__ArrayAccess__Group_1__0 )? ) ;
    public final void rule__ArrayAccess__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6402:1: ( ( ( rule__ArrayAccess__Group_1__0 )? ) )
            // InternalMiniJava.g:6403:1: ( ( rule__ArrayAccess__Group_1__0 )? )
            {
            // InternalMiniJava.g:6403:1: ( ( rule__ArrayAccess__Group_1__0 )? )
            // InternalMiniJava.g:6404:2: ( rule__ArrayAccess__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:6405:2: ( rule__ArrayAccess__Group_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==39) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMiniJava.g:6405:3: rule__ArrayAccess__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrayAccess__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group__1__Impl"


    // $ANTLR start "rule__ArrayAccess__Group_1__0"
    // InternalMiniJava.g:6414:1: rule__ArrayAccess__Group_1__0 : rule__ArrayAccess__Group_1__0__Impl rule__ArrayAccess__Group_1__1 ;
    public final void rule__ArrayAccess__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6418:1: ( rule__ArrayAccess__Group_1__0__Impl rule__ArrayAccess__Group_1__1 )
            // InternalMiniJava.g:6419:2: rule__ArrayAccess__Group_1__0__Impl rule__ArrayAccess__Group_1__1
            {
            pushFollow(FOLLOW_35);
            rule__ArrayAccess__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__0"


    // $ANTLR start "rule__ArrayAccess__Group_1__0__Impl"
    // InternalMiniJava.g:6426:1: rule__ArrayAccess__Group_1__0__Impl : ( () ) ;
    public final void rule__ArrayAccess__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6430:1: ( ( () ) )
            // InternalMiniJava.g:6431:1: ( () )
            {
            // InternalMiniJava.g:6431:1: ( () )
            // InternalMiniJava.g:6432:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getArrayAccessObjectAction_1_0()); 
            }
            // InternalMiniJava.g:6433:2: ()
            // InternalMiniJava.g:6433:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getArrayAccessObjectAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__0__Impl"


    // $ANTLR start "rule__ArrayAccess__Group_1__1"
    // InternalMiniJava.g:6441:1: rule__ArrayAccess__Group_1__1 : rule__ArrayAccess__Group_1__1__Impl rule__ArrayAccess__Group_1__2 ;
    public final void rule__ArrayAccess__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6445:1: ( rule__ArrayAccess__Group_1__1__Impl rule__ArrayAccess__Group_1__2 )
            // InternalMiniJava.g:6446:2: rule__ArrayAccess__Group_1__1__Impl rule__ArrayAccess__Group_1__2
            {
            pushFollow(FOLLOW_25);
            rule__ArrayAccess__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__1"


    // $ANTLR start "rule__ArrayAccess__Group_1__1__Impl"
    // InternalMiniJava.g:6453:1: rule__ArrayAccess__Group_1__1__Impl : ( '[' ) ;
    public final void rule__ArrayAccess__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6457:1: ( ( '[' ) )
            // InternalMiniJava.g:6458:1: ( '[' )
            {
            // InternalMiniJava.g:6458:1: ( '[' )
            // InternalMiniJava.g:6459:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getLeftSquareBracketKeyword_1_1()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getLeftSquareBracketKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__1__Impl"


    // $ANTLR start "rule__ArrayAccess__Group_1__2"
    // InternalMiniJava.g:6468:1: rule__ArrayAccess__Group_1__2 : rule__ArrayAccess__Group_1__2__Impl rule__ArrayAccess__Group_1__3 ;
    public final void rule__ArrayAccess__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6472:1: ( rule__ArrayAccess__Group_1__2__Impl rule__ArrayAccess__Group_1__3 )
            // InternalMiniJava.g:6473:2: rule__ArrayAccess__Group_1__2__Impl rule__ArrayAccess__Group_1__3
            {
            pushFollow(FOLLOW_36);
            rule__ArrayAccess__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__2"


    // $ANTLR start "rule__ArrayAccess__Group_1__2__Impl"
    // InternalMiniJava.g:6480:1: rule__ArrayAccess__Group_1__2__Impl : ( ( rule__ArrayAccess__IndexAssignment_1_2 ) ) ;
    public final void rule__ArrayAccess__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6484:1: ( ( ( rule__ArrayAccess__IndexAssignment_1_2 ) ) )
            // InternalMiniJava.g:6485:1: ( ( rule__ArrayAccess__IndexAssignment_1_2 ) )
            {
            // InternalMiniJava.g:6485:1: ( ( rule__ArrayAccess__IndexAssignment_1_2 ) )
            // InternalMiniJava.g:6486:2: ( rule__ArrayAccess__IndexAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getIndexAssignment_1_2()); 
            }
            // InternalMiniJava.g:6487:2: ( rule__ArrayAccess__IndexAssignment_1_2 )
            // InternalMiniJava.g:6487:3: rule__ArrayAccess__IndexAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__IndexAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getIndexAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__2__Impl"


    // $ANTLR start "rule__ArrayAccess__Group_1__3"
    // InternalMiniJava.g:6495:1: rule__ArrayAccess__Group_1__3 : rule__ArrayAccess__Group_1__3__Impl ;
    public final void rule__ArrayAccess__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6499:1: ( rule__ArrayAccess__Group_1__3__Impl )
            // InternalMiniJava.g:6500:2: rule__ArrayAccess__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayAccess__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__3"


    // $ANTLR start "rule__ArrayAccess__Group_1__3__Impl"
    // InternalMiniJava.g:6506:1: rule__ArrayAccess__Group_1__3__Impl : ( ']' ) ;
    public final void rule__ArrayAccess__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6510:1: ( ( ']' ) )
            // InternalMiniJava.g:6511:1: ( ']' )
            {
            // InternalMiniJava.g:6511:1: ( ']' )
            // InternalMiniJava.g:6512:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getRightSquareBracketKeyword_1_3()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getRightSquareBracketKeyword_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__Group_1__3__Impl"


    // $ANTLR start "rule__ArrayLength__Group__0"
    // InternalMiniJava.g:6522:1: rule__ArrayLength__Group__0 : rule__ArrayLength__Group__0__Impl rule__ArrayLength__Group__1 ;
    public final void rule__ArrayLength__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6526:1: ( rule__ArrayLength__Group__0__Impl rule__ArrayLength__Group__1 )
            // InternalMiniJava.g:6527:2: rule__ArrayLength__Group__0__Impl rule__ArrayLength__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ArrayLength__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group__0"


    // $ANTLR start "rule__ArrayLength__Group__0__Impl"
    // InternalMiniJava.g:6534:1: rule__ArrayLength__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__ArrayLength__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6538:1: ( ( rulePrimary ) )
            // InternalMiniJava.g:6539:1: ( rulePrimary )
            {
            // InternalMiniJava.g:6539:1: ( rulePrimary )
            // InternalMiniJava.g:6540:2: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getPrimaryParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getPrimaryParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group__0__Impl"


    // $ANTLR start "rule__ArrayLength__Group__1"
    // InternalMiniJava.g:6549:1: rule__ArrayLength__Group__1 : rule__ArrayLength__Group__1__Impl ;
    public final void rule__ArrayLength__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6553:1: ( rule__ArrayLength__Group__1__Impl )
            // InternalMiniJava.g:6554:2: rule__ArrayLength__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group__1"


    // $ANTLR start "rule__ArrayLength__Group__1__Impl"
    // InternalMiniJava.g:6560:1: rule__ArrayLength__Group__1__Impl : ( ( rule__ArrayLength__Group_1__0 )? ) ;
    public final void rule__ArrayLength__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6564:1: ( ( ( rule__ArrayLength__Group_1__0 )? ) )
            // InternalMiniJava.g:6565:1: ( ( rule__ArrayLength__Group_1__0 )? )
            {
            // InternalMiniJava.g:6565:1: ( ( rule__ArrayLength__Group_1__0 )? )
            // InternalMiniJava.g:6566:2: ( rule__ArrayLength__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getGroup_1()); 
            }
            // InternalMiniJava.g:6567:2: ( rule__ArrayLength__Group_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==19) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMiniJava.g:6567:3: rule__ArrayLength__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrayLength__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group__1__Impl"


    // $ANTLR start "rule__ArrayLength__Group_1__0"
    // InternalMiniJava.g:6576:1: rule__ArrayLength__Group_1__0 : rule__ArrayLength__Group_1__0__Impl rule__ArrayLength__Group_1__1 ;
    public final void rule__ArrayLength__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6580:1: ( rule__ArrayLength__Group_1__0__Impl rule__ArrayLength__Group_1__1 )
            // InternalMiniJava.g:6581:2: rule__ArrayLength__Group_1__0__Impl rule__ArrayLength__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ArrayLength__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__0"


    // $ANTLR start "rule__ArrayLength__Group_1__0__Impl"
    // InternalMiniJava.g:6588:1: rule__ArrayLength__Group_1__0__Impl : ( () ) ;
    public final void rule__ArrayLength__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6592:1: ( ( () ) )
            // InternalMiniJava.g:6593:1: ( () )
            {
            // InternalMiniJava.g:6593:1: ( () )
            // InternalMiniJava.g:6594:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getArrayLengthArrayAction_1_0()); 
            }
            // InternalMiniJava.g:6595:2: ()
            // InternalMiniJava.g:6595:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getArrayLengthArrayAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__0__Impl"


    // $ANTLR start "rule__ArrayLength__Group_1__1"
    // InternalMiniJava.g:6603:1: rule__ArrayLength__Group_1__1 : rule__ArrayLength__Group_1__1__Impl rule__ArrayLength__Group_1__2 ;
    public final void rule__ArrayLength__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6607:1: ( rule__ArrayLength__Group_1__1__Impl rule__ArrayLength__Group_1__2 )
            // InternalMiniJava.g:6608:2: rule__ArrayLength__Group_1__1__Impl rule__ArrayLength__Group_1__2
            {
            pushFollow(FOLLOW_61);
            rule__ArrayLength__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__1"


    // $ANTLR start "rule__ArrayLength__Group_1__1__Impl"
    // InternalMiniJava.g:6615:1: rule__ArrayLength__Group_1__1__Impl : ( '.' ) ;
    public final void rule__ArrayLength__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6619:1: ( ( '.' ) )
            // InternalMiniJava.g:6620:1: ( '.' )
            {
            // InternalMiniJava.g:6620:1: ( '.' )
            // InternalMiniJava.g:6621:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getFullStopKeyword_1_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getFullStopKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__1__Impl"


    // $ANTLR start "rule__ArrayLength__Group_1__2"
    // InternalMiniJava.g:6630:1: rule__ArrayLength__Group_1__2 : rule__ArrayLength__Group_1__2__Impl ;
    public final void rule__ArrayLength__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6634:1: ( rule__ArrayLength__Group_1__2__Impl )
            // InternalMiniJava.g:6635:2: rule__ArrayLength__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayLength__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__2"


    // $ANTLR start "rule__ArrayLength__Group_1__2__Impl"
    // InternalMiniJava.g:6641:1: rule__ArrayLength__Group_1__2__Impl : ( 'length' ) ;
    public final void rule__ArrayLength__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6645:1: ( ( 'length' ) )
            // InternalMiniJava.g:6646:1: ( 'length' )
            {
            // InternalMiniJava.g:6646:1: ( 'length' )
            // InternalMiniJava.g:6647:2: 'length'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayLengthAccess().getLengthKeyword_1_2()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayLengthAccess().getLengthKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayLength__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_0__0"
    // InternalMiniJava.g:6657:1: rule__Primary__Group_0__0 : rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 ;
    public final void rule__Primary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6661:1: ( rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 )
            // InternalMiniJava.g:6662:2: rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1
            {
            pushFollow(FOLLOW_25);
            rule__Primary__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0"


    // $ANTLR start "rule__Primary__Group_0__0__Impl"
    // InternalMiniJava.g:6669:1: rule__Primary__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6673:1: ( ( '(' ) )
            // InternalMiniJava.g:6674:1: ( '(' )
            {
            // InternalMiniJava.g:6674:1: ( '(' )
            // InternalMiniJava.g:6675:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0__Impl"


    // $ANTLR start "rule__Primary__Group_0__1"
    // InternalMiniJava.g:6684:1: rule__Primary__Group_0__1 : rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 ;
    public final void rule__Primary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6688:1: ( rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 )
            // InternalMiniJava.g:6689:2: rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2
            {
            pushFollow(FOLLOW_32);
            rule__Primary__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1"


    // $ANTLR start "rule__Primary__Group_0__1__Impl"
    // InternalMiniJava.g:6696:1: rule__Primary__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__Primary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6700:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:6701:1: ( ruleExpression )
            {
            // InternalMiniJava.g:6701:1: ( ruleExpression )
            // InternalMiniJava.g:6702:2: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1__Impl"


    // $ANTLR start "rule__Primary__Group_0__2"
    // InternalMiniJava.g:6711:1: rule__Primary__Group_0__2 : rule__Primary__Group_0__2__Impl ;
    public final void rule__Primary__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6715:1: ( rule__Primary__Group_0__2__Impl )
            // InternalMiniJava.g:6716:2: rule__Primary__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2"


    // $ANTLR start "rule__Primary__Group_0__2__Impl"
    // InternalMiniJava.g:6722:1: rule__Primary__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6726:1: ( ( ')' ) )
            // InternalMiniJava.g:6727:1: ( ')' )
            {
            // InternalMiniJava.g:6727:1: ( ')' )
            // InternalMiniJava.g:6728:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2__Impl"


    // $ANTLR start "rule__Primary__Group_1__0"
    // InternalMiniJava.g:6738:1: rule__Primary__Group_1__0 : rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 ;
    public final void rule__Primary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6742:1: ( rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 )
            // InternalMiniJava.g:6743:2: rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1
            {
            pushFollow(FOLLOW_62);
            rule__Primary__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0"


    // $ANTLR start "rule__Primary__Group_1__0__Impl"
    // InternalMiniJava.g:6750:1: rule__Primary__Group_1__0__Impl : ( () ) ;
    public final void rule__Primary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6754:1: ( ( () ) )
            // InternalMiniJava.g:6755:1: ( () )
            {
            // InternalMiniJava.g:6755:1: ( () )
            // InternalMiniJava.g:6756:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getNotAction_1_0()); 
            }
            // InternalMiniJava.g:6757:2: ()
            // InternalMiniJava.g:6757:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getNotAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0__Impl"


    // $ANTLR start "rule__Primary__Group_1__1"
    // InternalMiniJava.g:6765:1: rule__Primary__Group_1__1 : rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 ;
    public final void rule__Primary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6769:1: ( rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 )
            // InternalMiniJava.g:6770:2: rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2
            {
            pushFollow(FOLLOW_25);
            rule__Primary__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1"


    // $ANTLR start "rule__Primary__Group_1__1__Impl"
    // InternalMiniJava.g:6777:1: rule__Primary__Group_1__1__Impl : ( ( '!' ) ) ;
    public final void rule__Primary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6781:1: ( ( ( '!' ) ) )
            // InternalMiniJava.g:6782:1: ( ( '!' ) )
            {
            // InternalMiniJava.g:6782:1: ( ( '!' ) )
            // InternalMiniJava.g:6783:2: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1()); 
            }
            // InternalMiniJava.g:6784:2: ( '!' )
            // InternalMiniJava.g:6784:3: '!'
            {
            match(input,59,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1__Impl"


    // $ANTLR start "rule__Primary__Group_1__2"
    // InternalMiniJava.g:6792:1: rule__Primary__Group_1__2 : rule__Primary__Group_1__2__Impl ;
    public final void rule__Primary__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6796:1: ( rule__Primary__Group_1__2__Impl )
            // InternalMiniJava.g:6797:2: rule__Primary__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2"


    // $ANTLR start "rule__Primary__Group_1__2__Impl"
    // InternalMiniJava.g:6803:1: rule__Primary__Group_1__2__Impl : ( ( rule__Primary__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Primary__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6807:1: ( ( ( rule__Primary__ExpressionAssignment_1_2 ) ) )
            // InternalMiniJava.g:6808:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            {
            // InternalMiniJava.g:6808:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            // InternalMiniJava.g:6809:2: ( rule__Primary__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 
            }
            // InternalMiniJava.g:6810:2: ( rule__Primary__ExpressionAssignment_1_2 )
            // InternalMiniJava.g:6810:3: rule__Primary__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Primary__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_2__0"
    // InternalMiniJava.g:6819:1: rule__Primary__Group_2__0 : rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1 ;
    public final void rule__Primary__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6823:1: ( rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1 )
            // InternalMiniJava.g:6824:2: rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1
            {
            pushFollow(FOLLOW_63);
            rule__Primary__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__0"


    // $ANTLR start "rule__Primary__Group_2__0__Impl"
    // InternalMiniJava.g:6831:1: rule__Primary__Group_2__0__Impl : ( () ) ;
    public final void rule__Primary__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6835:1: ( ( () ) )
            // InternalMiniJava.g:6836:1: ( () )
            {
            // InternalMiniJava.g:6836:1: ( () )
            // InternalMiniJava.g:6837:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getNegAction_2_0()); 
            }
            // InternalMiniJava.g:6838:2: ()
            // InternalMiniJava.g:6838:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getNegAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__0__Impl"


    // $ANTLR start "rule__Primary__Group_2__1"
    // InternalMiniJava.g:6846:1: rule__Primary__Group_2__1 : rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2 ;
    public final void rule__Primary__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6850:1: ( rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2 )
            // InternalMiniJava.g:6851:2: rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2
            {
            pushFollow(FOLLOW_25);
            rule__Primary__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__1"


    // $ANTLR start "rule__Primary__Group_2__1__Impl"
    // InternalMiniJava.g:6858:1: rule__Primary__Group_2__1__Impl : ( ( '-' ) ) ;
    public final void rule__Primary__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6862:1: ( ( ( '-' ) ) )
            // InternalMiniJava.g:6863:1: ( ( '-' ) )
            {
            // InternalMiniJava.g:6863:1: ( ( '-' ) )
            // InternalMiniJava.g:6864:2: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getHyphenMinusKeyword_2_1()); 
            }
            // InternalMiniJava.g:6865:2: ( '-' )
            // InternalMiniJava.g:6865:3: '-'
            {
            match(input,55,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getHyphenMinusKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__1__Impl"


    // $ANTLR start "rule__Primary__Group_2__2"
    // InternalMiniJava.g:6873:1: rule__Primary__Group_2__2 : rule__Primary__Group_2__2__Impl ;
    public final void rule__Primary__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6877:1: ( rule__Primary__Group_2__2__Impl )
            // InternalMiniJava.g:6878:2: rule__Primary__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__2"


    // $ANTLR start "rule__Primary__Group_2__2__Impl"
    // InternalMiniJava.g:6884:1: rule__Primary__Group_2__2__Impl : ( ( rule__Primary__ExpressionAssignment_2_2 ) ) ;
    public final void rule__Primary__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6888:1: ( ( ( rule__Primary__ExpressionAssignment_2_2 ) ) )
            // InternalMiniJava.g:6889:1: ( ( rule__Primary__ExpressionAssignment_2_2 ) )
            {
            // InternalMiniJava.g:6889:1: ( ( rule__Primary__ExpressionAssignment_2_2 ) )
            // InternalMiniJava.g:6890:2: ( rule__Primary__ExpressionAssignment_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExpressionAssignment_2_2()); 
            }
            // InternalMiniJava.g:6891:2: ( rule__Primary__ExpressionAssignment_2_2 )
            // InternalMiniJava.g:6891:3: rule__Primary__ExpressionAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Primary__ExpressionAssignment_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExpressionAssignment_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__2__Impl"


    // $ANTLR start "rule__SelectionExpression__Group__0"
    // InternalMiniJava.g:6900:1: rule__SelectionExpression__Group__0 : rule__SelectionExpression__Group__0__Impl rule__SelectionExpression__Group__1 ;
    public final void rule__SelectionExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6904:1: ( rule__SelectionExpression__Group__0__Impl rule__SelectionExpression__Group__1 )
            // InternalMiniJava.g:6905:2: rule__SelectionExpression__Group__0__Impl rule__SelectionExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__SelectionExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group__0"


    // $ANTLR start "rule__SelectionExpression__Group__0__Impl"
    // InternalMiniJava.g:6912:1: rule__SelectionExpression__Group__0__Impl : ( ruleTerminalExpression ) ;
    public final void rule__SelectionExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6916:1: ( ( ruleTerminalExpression ) )
            // InternalMiniJava.g:6917:1: ( ruleTerminalExpression )
            {
            // InternalMiniJava.g:6917:1: ( ruleTerminalExpression )
            // InternalMiniJava.g:6918:2: ruleTerminalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group__0__Impl"


    // $ANTLR start "rule__SelectionExpression__Group__1"
    // InternalMiniJava.g:6927:1: rule__SelectionExpression__Group__1 : rule__SelectionExpression__Group__1__Impl ;
    public final void rule__SelectionExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6931:1: ( rule__SelectionExpression__Group__1__Impl )
            // InternalMiniJava.g:6932:2: rule__SelectionExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group__1"


    // $ANTLR start "rule__SelectionExpression__Group__1__Impl"
    // InternalMiniJava.g:6938:1: rule__SelectionExpression__Group__1__Impl : ( ( rule__SelectionExpression__Alternatives_1 )* ) ;
    public final void rule__SelectionExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6942:1: ( ( ( rule__SelectionExpression__Alternatives_1 )* ) )
            // InternalMiniJava.g:6943:1: ( ( rule__SelectionExpression__Alternatives_1 )* )
            {
            // InternalMiniJava.g:6943:1: ( ( rule__SelectionExpression__Alternatives_1 )* )
            // InternalMiniJava.g:6944:2: ( rule__SelectionExpression__Alternatives_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getAlternatives_1()); 
            }
            // InternalMiniJava.g:6945:2: ( rule__SelectionExpression__Alternatives_1 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==19) ) {
                    int LA53_2 = input.LA(2);

                    if ( (LA53_2==RULE_ID) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalMiniJava.g:6945:3: rule__SelectionExpression__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__SelectionExpression__Alternatives_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group__1__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__0"
    // InternalMiniJava.g:6954:1: rule__SelectionExpression__Group_1_0__0 : rule__SelectionExpression__Group_1_0__0__Impl rule__SelectionExpression__Group_1_0__1 ;
    public final void rule__SelectionExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6958:1: ( rule__SelectionExpression__Group_1_0__0__Impl rule__SelectionExpression__Group_1_0__1 )
            // InternalMiniJava.g:6959:2: rule__SelectionExpression__Group_1_0__0__Impl rule__SelectionExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_8);
            rule__SelectionExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__0"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__0__Impl"
    // InternalMiniJava.g:6966:1: rule__SelectionExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__SelectionExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6970:1: ( ( () ) )
            // InternalMiniJava.g:6971:1: ( () )
            {
            // InternalMiniJava.g:6971:1: ( () )
            // InternalMiniJava.g:6972:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFieldAccessReceiverAction_1_0_0()); 
            }
            // InternalMiniJava.g:6973:2: ()
            // InternalMiniJava.g:6973:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFieldAccessReceiverAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__1"
    // InternalMiniJava.g:6981:1: rule__SelectionExpression__Group_1_0__1 : rule__SelectionExpression__Group_1_0__1__Impl rule__SelectionExpression__Group_1_0__2 ;
    public final void rule__SelectionExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6985:1: ( rule__SelectionExpression__Group_1_0__1__Impl rule__SelectionExpression__Group_1_0__2 )
            // InternalMiniJava.g:6986:2: rule__SelectionExpression__Group_1_0__1__Impl rule__SelectionExpression__Group_1_0__2
            {
            pushFollow(FOLLOW_6);
            rule__SelectionExpression__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__1"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__1__Impl"
    // InternalMiniJava.g:6993:1: rule__SelectionExpression__Group_1_0__1__Impl : ( '.' ) ;
    public final void rule__SelectionExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:6997:1: ( ( '.' ) )
            // InternalMiniJava.g:6998:1: ( '.' )
            {
            // InternalMiniJava.g:6998:1: ( '.' )
            // InternalMiniJava.g:6999:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFullStopKeyword_1_0_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFullStopKeyword_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__2"
    // InternalMiniJava.g:7008:1: rule__SelectionExpression__Group_1_0__2 : rule__SelectionExpression__Group_1_0__2__Impl ;
    public final void rule__SelectionExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7012:1: ( rule__SelectionExpression__Group_1_0__2__Impl )
            // InternalMiniJava.g:7013:2: rule__SelectionExpression__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__2"


    // $ANTLR start "rule__SelectionExpression__Group_1_0__2__Impl"
    // InternalMiniJava.g:7019:1: rule__SelectionExpression__Group_1_0__2__Impl : ( ( rule__SelectionExpression__FieldAssignment_1_0_2 ) ) ;
    public final void rule__SelectionExpression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7023:1: ( ( ( rule__SelectionExpression__FieldAssignment_1_0_2 ) ) )
            // InternalMiniJava.g:7024:1: ( ( rule__SelectionExpression__FieldAssignment_1_0_2 ) )
            {
            // InternalMiniJava.g:7024:1: ( ( rule__SelectionExpression__FieldAssignment_1_0_2 ) )
            // InternalMiniJava.g:7025:2: ( rule__SelectionExpression__FieldAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFieldAssignment_1_0_2()); 
            }
            // InternalMiniJava.g:7026:2: ( rule__SelectionExpression__FieldAssignment_1_0_2 )
            // InternalMiniJava.g:7026:3: rule__SelectionExpression__FieldAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__FieldAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFieldAssignment_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_0__2__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__0"
    // InternalMiniJava.g:7035:1: rule__SelectionExpression__Group_1_1__0 : rule__SelectionExpression__Group_1_1__0__Impl rule__SelectionExpression__Group_1_1__1 ;
    public final void rule__SelectionExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7039:1: ( rule__SelectionExpression__Group_1_1__0__Impl rule__SelectionExpression__Group_1_1__1 )
            // InternalMiniJava.g:7040:2: rule__SelectionExpression__Group_1_1__0__Impl rule__SelectionExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_8);
            rule__SelectionExpression__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__0"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__0__Impl"
    // InternalMiniJava.g:7047:1: rule__SelectionExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__SelectionExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7051:1: ( ( () ) )
            // InternalMiniJava.g:7052:1: ( () )
            {
            // InternalMiniJava.g:7052:1: ( () )
            // InternalMiniJava.g:7053:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getMethodCallReceiverAction_1_1_0()); 
            }
            // InternalMiniJava.g:7054:2: ()
            // InternalMiniJava.g:7054:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getMethodCallReceiverAction_1_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__0__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__1"
    // InternalMiniJava.g:7062:1: rule__SelectionExpression__Group_1_1__1 : rule__SelectionExpression__Group_1_1__1__Impl rule__SelectionExpression__Group_1_1__2 ;
    public final void rule__SelectionExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7066:1: ( rule__SelectionExpression__Group_1_1__1__Impl rule__SelectionExpression__Group_1_1__2 )
            // InternalMiniJava.g:7067:2: rule__SelectionExpression__Group_1_1__1__Impl rule__SelectionExpression__Group_1_1__2
            {
            pushFollow(FOLLOW_6);
            rule__SelectionExpression__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__1"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__1__Impl"
    // InternalMiniJava.g:7074:1: rule__SelectionExpression__Group_1_1__1__Impl : ( '.' ) ;
    public final void rule__SelectionExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7078:1: ( ( '.' ) )
            // InternalMiniJava.g:7079:1: ( '.' )
            {
            // InternalMiniJava.g:7079:1: ( '.' )
            // InternalMiniJava.g:7080:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFullStopKeyword_1_1_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFullStopKeyword_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__1__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__2"
    // InternalMiniJava.g:7089:1: rule__SelectionExpression__Group_1_1__2 : rule__SelectionExpression__Group_1_1__2__Impl rule__SelectionExpression__Group_1_1__3 ;
    public final void rule__SelectionExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7093:1: ( rule__SelectionExpression__Group_1_1__2__Impl rule__SelectionExpression__Group_1_1__3 )
            // InternalMiniJava.g:7094:2: rule__SelectionExpression__Group_1_1__2__Impl rule__SelectionExpression__Group_1_1__3
            {
            pushFollow(FOLLOW_31);
            rule__SelectionExpression__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__2"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__2__Impl"
    // InternalMiniJava.g:7101:1: rule__SelectionExpression__Group_1_1__2__Impl : ( ( rule__SelectionExpression__MethodAssignment_1_1_2 ) ) ;
    public final void rule__SelectionExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7105:1: ( ( ( rule__SelectionExpression__MethodAssignment_1_1_2 ) ) )
            // InternalMiniJava.g:7106:1: ( ( rule__SelectionExpression__MethodAssignment_1_1_2 ) )
            {
            // InternalMiniJava.g:7106:1: ( ( rule__SelectionExpression__MethodAssignment_1_1_2 ) )
            // InternalMiniJava.g:7107:2: ( rule__SelectionExpression__MethodAssignment_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getMethodAssignment_1_1_2()); 
            }
            // InternalMiniJava.g:7108:2: ( rule__SelectionExpression__MethodAssignment_1_1_2 )
            // InternalMiniJava.g:7108:3: rule__SelectionExpression__MethodAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__MethodAssignment_1_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getMethodAssignment_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__2__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__3"
    // InternalMiniJava.g:7116:1: rule__SelectionExpression__Group_1_1__3 : rule__SelectionExpression__Group_1_1__3__Impl rule__SelectionExpression__Group_1_1__4 ;
    public final void rule__SelectionExpression__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7120:1: ( rule__SelectionExpression__Group_1_1__3__Impl rule__SelectionExpression__Group_1_1__4 )
            // InternalMiniJava.g:7121:2: rule__SelectionExpression__Group_1_1__3__Impl rule__SelectionExpression__Group_1_1__4
            {
            pushFollow(FOLLOW_64);
            rule__SelectionExpression__Group_1_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__3"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__3__Impl"
    // InternalMiniJava.g:7128:1: rule__SelectionExpression__Group_1_1__3__Impl : ( '(' ) ;
    public final void rule__SelectionExpression__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7132:1: ( ( '(' ) )
            // InternalMiniJava.g:7133:1: ( '(' )
            {
            // InternalMiniJava.g:7133:1: ( '(' )
            // InternalMiniJava.g:7134:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getLeftParenthesisKeyword_1_1_3()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getLeftParenthesisKeyword_1_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__3__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__4"
    // InternalMiniJava.g:7143:1: rule__SelectionExpression__Group_1_1__4 : rule__SelectionExpression__Group_1_1__4__Impl rule__SelectionExpression__Group_1_1__5 ;
    public final void rule__SelectionExpression__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7147:1: ( rule__SelectionExpression__Group_1_1__4__Impl rule__SelectionExpression__Group_1_1__5 )
            // InternalMiniJava.g:7148:2: rule__SelectionExpression__Group_1_1__4__Impl rule__SelectionExpression__Group_1_1__5
            {
            pushFollow(FOLLOW_64);
            rule__SelectionExpression__Group_1_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__4"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__4__Impl"
    // InternalMiniJava.g:7155:1: rule__SelectionExpression__Group_1_1__4__Impl : ( ( rule__SelectionExpression__Group_1_1_4__0 )? ) ;
    public final void rule__SelectionExpression__Group_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7159:1: ( ( ( rule__SelectionExpression__Group_1_1_4__0 )? ) )
            // InternalMiniJava.g:7160:1: ( ( rule__SelectionExpression__Group_1_1_4__0 )? )
            {
            // InternalMiniJava.g:7160:1: ( ( rule__SelectionExpression__Group_1_1_4__0 )? )
            // InternalMiniJava.g:7161:2: ( rule__SelectionExpression__Group_1_1_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getGroup_1_1_4()); 
            }
            // InternalMiniJava.g:7162:2: ( rule__SelectionExpression__Group_1_1_4__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_INT)||(LA54_0>=12 && LA54_0<=13)||LA54_0==28||LA54_0==55||(LA54_0>=59 && LA54_0<=63)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMiniJava.g:7162:3: rule__SelectionExpression__Group_1_1_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SelectionExpression__Group_1_1_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getGroup_1_1_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__4__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__5"
    // InternalMiniJava.g:7170:1: rule__SelectionExpression__Group_1_1__5 : rule__SelectionExpression__Group_1_1__5__Impl ;
    public final void rule__SelectionExpression__Group_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7174:1: ( rule__SelectionExpression__Group_1_1__5__Impl )
            // InternalMiniJava.g:7175:2: rule__SelectionExpression__Group_1_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__5"


    // $ANTLR start "rule__SelectionExpression__Group_1_1__5__Impl"
    // InternalMiniJava.g:7181:1: rule__SelectionExpression__Group_1_1__5__Impl : ( ')' ) ;
    public final void rule__SelectionExpression__Group_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7185:1: ( ( ')' ) )
            // InternalMiniJava.g:7186:1: ( ')' )
            {
            // InternalMiniJava.g:7186:1: ( ')' )
            // InternalMiniJava.g:7187:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getRightParenthesisKeyword_1_1_5()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getRightParenthesisKeyword_1_1_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1__5__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4__0"
    // InternalMiniJava.g:7197:1: rule__SelectionExpression__Group_1_1_4__0 : rule__SelectionExpression__Group_1_1_4__0__Impl rule__SelectionExpression__Group_1_1_4__1 ;
    public final void rule__SelectionExpression__Group_1_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7201:1: ( rule__SelectionExpression__Group_1_1_4__0__Impl rule__SelectionExpression__Group_1_1_4__1 )
            // InternalMiniJava.g:7202:2: rule__SelectionExpression__Group_1_1_4__0__Impl rule__SelectionExpression__Group_1_1_4__1
            {
            pushFollow(FOLLOW_15);
            rule__SelectionExpression__Group_1_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4__0"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4__0__Impl"
    // InternalMiniJava.g:7209:1: rule__SelectionExpression__Group_1_1_4__0__Impl : ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 ) ) ;
    public final void rule__SelectionExpression__Group_1_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7213:1: ( ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 ) ) )
            // InternalMiniJava.g:7214:1: ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 ) )
            {
            // InternalMiniJava.g:7214:1: ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 ) )
            // InternalMiniJava.g:7215:2: ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getArgsAssignment_1_1_4_0()); 
            }
            // InternalMiniJava.g:7216:2: ( rule__SelectionExpression__ArgsAssignment_1_1_4_0 )
            // InternalMiniJava.g:7216:3: rule__SelectionExpression__ArgsAssignment_1_1_4_0
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__ArgsAssignment_1_1_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getArgsAssignment_1_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4__0__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4__1"
    // InternalMiniJava.g:7224:1: rule__SelectionExpression__Group_1_1_4__1 : rule__SelectionExpression__Group_1_1_4__1__Impl ;
    public final void rule__SelectionExpression__Group_1_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7228:1: ( rule__SelectionExpression__Group_1_1_4__1__Impl )
            // InternalMiniJava.g:7229:2: rule__SelectionExpression__Group_1_1_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4__1"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4__1__Impl"
    // InternalMiniJava.g:7235:1: rule__SelectionExpression__Group_1_1_4__1__Impl : ( ( rule__SelectionExpression__Group_1_1_4_1__0 )* ) ;
    public final void rule__SelectionExpression__Group_1_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7239:1: ( ( ( rule__SelectionExpression__Group_1_1_4_1__0 )* ) )
            // InternalMiniJava.g:7240:1: ( ( rule__SelectionExpression__Group_1_1_4_1__0 )* )
            {
            // InternalMiniJava.g:7240:1: ( ( rule__SelectionExpression__Group_1_1_4_1__0 )* )
            // InternalMiniJava.g:7241:2: ( rule__SelectionExpression__Group_1_1_4_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getGroup_1_1_4_1()); 
            }
            // InternalMiniJava.g:7242:2: ( rule__SelectionExpression__Group_1_1_4_1__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==26) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMiniJava.g:7242:3: rule__SelectionExpression__Group_1_1_4_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__SelectionExpression__Group_1_1_4_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getGroup_1_1_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4__1__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4_1__0"
    // InternalMiniJava.g:7251:1: rule__SelectionExpression__Group_1_1_4_1__0 : rule__SelectionExpression__Group_1_1_4_1__0__Impl rule__SelectionExpression__Group_1_1_4_1__1 ;
    public final void rule__SelectionExpression__Group_1_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7255:1: ( rule__SelectionExpression__Group_1_1_4_1__0__Impl rule__SelectionExpression__Group_1_1_4_1__1 )
            // InternalMiniJava.g:7256:2: rule__SelectionExpression__Group_1_1_4_1__0__Impl rule__SelectionExpression__Group_1_1_4_1__1
            {
            pushFollow(FOLLOW_25);
            rule__SelectionExpression__Group_1_1_4_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1_4_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4_1__0"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4_1__0__Impl"
    // InternalMiniJava.g:7263:1: rule__SelectionExpression__Group_1_1_4_1__0__Impl : ( ',' ) ;
    public final void rule__SelectionExpression__Group_1_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7267:1: ( ( ',' ) )
            // InternalMiniJava.g:7268:1: ( ',' )
            {
            // InternalMiniJava.g:7268:1: ( ',' )
            // InternalMiniJava.g:7269:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getCommaKeyword_1_1_4_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getCommaKeyword_1_1_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4_1__0__Impl"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4_1__1"
    // InternalMiniJava.g:7278:1: rule__SelectionExpression__Group_1_1_4_1__1 : rule__SelectionExpression__Group_1_1_4_1__1__Impl ;
    public final void rule__SelectionExpression__Group_1_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7282:1: ( rule__SelectionExpression__Group_1_1_4_1__1__Impl )
            // InternalMiniJava.g:7283:2: rule__SelectionExpression__Group_1_1_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__Group_1_1_4_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4_1__1"


    // $ANTLR start "rule__SelectionExpression__Group_1_1_4_1__1__Impl"
    // InternalMiniJava.g:7289:1: rule__SelectionExpression__Group_1_1_4_1__1__Impl : ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 ) ) ;
    public final void rule__SelectionExpression__Group_1_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7293:1: ( ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 ) ) )
            // InternalMiniJava.g:7294:1: ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 ) )
            {
            // InternalMiniJava.g:7294:1: ( ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 ) )
            // InternalMiniJava.g:7295:2: ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getArgsAssignment_1_1_4_1_1()); 
            }
            // InternalMiniJava.g:7296:2: ( rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 )
            // InternalMiniJava.g:7296:3: rule__SelectionExpression__ArgsAssignment_1_1_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__SelectionExpression__ArgsAssignment_1_1_4_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getArgsAssignment_1_1_4_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__Group_1_1_4_1__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__0"
    // InternalMiniJava.g:7305:1: rule__TerminalExpression__Group_0__0 : rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 ;
    public final void rule__TerminalExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7309:1: ( rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 )
            // InternalMiniJava.g:7310:2: rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1
            {
            pushFollow(FOLLOW_65);
            rule__TerminalExpression__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0"


    // $ANTLR start "rule__TerminalExpression__Group_0__0__Impl"
    // InternalMiniJava.g:7317:1: rule__TerminalExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7321:1: ( ( () ) )
            // InternalMiniJava.g:7322:1: ( () )
            {
            // InternalMiniJava.g:7322:1: ( () )
            // InternalMiniJava.g:7323:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getStringConstantAction_0_0()); 
            }
            // InternalMiniJava.g:7324:2: ()
            // InternalMiniJava.g:7324:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getStringConstantAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__1"
    // InternalMiniJava.g:7332:1: rule__TerminalExpression__Group_0__1 : rule__TerminalExpression__Group_0__1__Impl ;
    public final void rule__TerminalExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7336:1: ( rule__TerminalExpression__Group_0__1__Impl )
            // InternalMiniJava.g:7337:2: rule__TerminalExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1"


    // $ANTLR start "rule__TerminalExpression__Group_0__1__Impl"
    // InternalMiniJava.g:7343:1: rule__TerminalExpression__Group_0__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_0_1 ) ) ;
    public final void rule__TerminalExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7347:1: ( ( ( rule__TerminalExpression__ValueAssignment_0_1 ) ) )
            // InternalMiniJava.g:7348:1: ( ( rule__TerminalExpression__ValueAssignment_0_1 ) )
            {
            // InternalMiniJava.g:7348:1: ( ( rule__TerminalExpression__ValueAssignment_0_1 ) )
            // InternalMiniJava.g:7349:2: ( rule__TerminalExpression__ValueAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_0_1()); 
            }
            // InternalMiniJava.g:7350:2: ( rule__TerminalExpression__ValueAssignment_0_1 )
            // InternalMiniJava.g:7350:3: rule__TerminalExpression__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_1__0"
    // InternalMiniJava.g:7359:1: rule__TerminalExpression__Group_1__0 : rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1 ;
    public final void rule__TerminalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7363:1: ( rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1 )
            // InternalMiniJava.g:7364:2: rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1
            {
            pushFollow(FOLLOW_66);
            rule__TerminalExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__0"


    // $ANTLR start "rule__TerminalExpression__Group_1__0__Impl"
    // InternalMiniJava.g:7371:1: rule__TerminalExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7375:1: ( ( () ) )
            // InternalMiniJava.g:7376:1: ( () )
            {
            // InternalMiniJava.g:7376:1: ( () )
            // InternalMiniJava.g:7377:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getIntConstantAction_1_0()); 
            }
            // InternalMiniJava.g:7378:2: ()
            // InternalMiniJava.g:7378:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getIntConstantAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_1__1"
    // InternalMiniJava.g:7386:1: rule__TerminalExpression__Group_1__1 : rule__TerminalExpression__Group_1__1__Impl ;
    public final void rule__TerminalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7390:1: ( rule__TerminalExpression__Group_1__1__Impl )
            // InternalMiniJava.g:7391:2: rule__TerminalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__1"


    // $ANTLR start "rule__TerminalExpression__Group_1__1__Impl"
    // InternalMiniJava.g:7397:1: rule__TerminalExpression__Group_1__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__TerminalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7401:1: ( ( ( rule__TerminalExpression__ValueAssignment_1_1 ) ) )
            // InternalMiniJava.g:7402:1: ( ( rule__TerminalExpression__ValueAssignment_1_1 ) )
            {
            // InternalMiniJava.g:7402:1: ( ( rule__TerminalExpression__ValueAssignment_1_1 ) )
            // InternalMiniJava.g:7403:2: ( rule__TerminalExpression__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1()); 
            }
            // InternalMiniJava.g:7404:2: ( rule__TerminalExpression__ValueAssignment_1_1 )
            // InternalMiniJava.g:7404:3: rule__TerminalExpression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_2__0"
    // InternalMiniJava.g:7413:1: rule__TerminalExpression__Group_2__0 : rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1 ;
    public final void rule__TerminalExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7417:1: ( rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1 )
            // InternalMiniJava.g:7418:2: rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1
            {
            pushFollow(FOLLOW_67);
            rule__TerminalExpression__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__0"


    // $ANTLR start "rule__TerminalExpression__Group_2__0__Impl"
    // InternalMiniJava.g:7425:1: rule__TerminalExpression__Group_2__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7429:1: ( ( () ) )
            // InternalMiniJava.g:7430:1: ( () )
            {
            // InternalMiniJava.g:7430:1: ( () )
            // InternalMiniJava.g:7431:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0()); 
            }
            // InternalMiniJava.g:7432:2: ()
            // InternalMiniJava.g:7432:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_2__1"
    // InternalMiniJava.g:7440:1: rule__TerminalExpression__Group_2__1 : rule__TerminalExpression__Group_2__1__Impl ;
    public final void rule__TerminalExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7444:1: ( rule__TerminalExpression__Group_2__1__Impl )
            // InternalMiniJava.g:7445:2: rule__TerminalExpression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__1"


    // $ANTLR start "rule__TerminalExpression__Group_2__1__Impl"
    // InternalMiniJava.g:7451:1: rule__TerminalExpression__Group_2__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_2_1 ) ) ;
    public final void rule__TerminalExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7455:1: ( ( ( rule__TerminalExpression__ValueAssignment_2_1 ) ) )
            // InternalMiniJava.g:7456:1: ( ( rule__TerminalExpression__ValueAssignment_2_1 ) )
            {
            // InternalMiniJava.g:7456:1: ( ( rule__TerminalExpression__ValueAssignment_2_1 ) )
            // InternalMiniJava.g:7457:2: ( rule__TerminalExpression__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); 
            }
            // InternalMiniJava.g:7458:2: ( rule__TerminalExpression__ValueAssignment_2_1 )
            // InternalMiniJava.g:7458:3: rule__TerminalExpression__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_3__0"
    // InternalMiniJava.g:7467:1: rule__TerminalExpression__Group_3__0 : rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1 ;
    public final void rule__TerminalExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7471:1: ( rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1 )
            // InternalMiniJava.g:7472:2: rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1
            {
            pushFollow(FOLLOW_68);
            rule__TerminalExpression__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__0"


    // $ANTLR start "rule__TerminalExpression__Group_3__0__Impl"
    // InternalMiniJava.g:7479:1: rule__TerminalExpression__Group_3__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7483:1: ( ( () ) )
            // InternalMiniJava.g:7484:1: ( () )
            {
            // InternalMiniJava.g:7484:1: ( () )
            // InternalMiniJava.g:7485:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getThisAction_3_0()); 
            }
            // InternalMiniJava.g:7486:2: ()
            // InternalMiniJava.g:7486:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getThisAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_3__1"
    // InternalMiniJava.g:7494:1: rule__TerminalExpression__Group_3__1 : rule__TerminalExpression__Group_3__1__Impl ;
    public final void rule__TerminalExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7498:1: ( rule__TerminalExpression__Group_3__1__Impl )
            // InternalMiniJava.g:7499:2: rule__TerminalExpression__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__1"


    // $ANTLR start "rule__TerminalExpression__Group_3__1__Impl"
    // InternalMiniJava.g:7505:1: rule__TerminalExpression__Group_3__1__Impl : ( 'this' ) ;
    public final void rule__TerminalExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7509:1: ( ( 'this' ) )
            // InternalMiniJava.g:7510:1: ( 'this' )
            {
            // InternalMiniJava.g:7510:1: ( 'this' )
            // InternalMiniJava.g:7511:2: 'this'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getThisKeyword_3_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getThisKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_4__0"
    // InternalMiniJava.g:7521:1: rule__TerminalExpression__Group_4__0 : rule__TerminalExpression__Group_4__0__Impl rule__TerminalExpression__Group_4__1 ;
    public final void rule__TerminalExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7525:1: ( rule__TerminalExpression__Group_4__0__Impl rule__TerminalExpression__Group_4__1 )
            // InternalMiniJava.g:7526:2: rule__TerminalExpression__Group_4__0__Impl rule__TerminalExpression__Group_4__1
            {
            pushFollow(FOLLOW_69);
            rule__TerminalExpression__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_4__0"


    // $ANTLR start "rule__TerminalExpression__Group_4__0__Impl"
    // InternalMiniJava.g:7533:1: rule__TerminalExpression__Group_4__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7537:1: ( ( () ) )
            // InternalMiniJava.g:7538:1: ( () )
            {
            // InternalMiniJava.g:7538:1: ( () )
            // InternalMiniJava.g:7539:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSuperAction_4_0()); 
            }
            // InternalMiniJava.g:7540:2: ()
            // InternalMiniJava.g:7540:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSuperAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_4__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_4__1"
    // InternalMiniJava.g:7548:1: rule__TerminalExpression__Group_4__1 : rule__TerminalExpression__Group_4__1__Impl ;
    public final void rule__TerminalExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7552:1: ( rule__TerminalExpression__Group_4__1__Impl )
            // InternalMiniJava.g:7553:2: rule__TerminalExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_4__1"


    // $ANTLR start "rule__TerminalExpression__Group_4__1__Impl"
    // InternalMiniJava.g:7559:1: rule__TerminalExpression__Group_4__1__Impl : ( 'super' ) ;
    public final void rule__TerminalExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7563:1: ( ( 'super' ) )
            // InternalMiniJava.g:7564:1: ( 'super' )
            {
            // InternalMiniJava.g:7564:1: ( 'super' )
            // InternalMiniJava.g:7565:2: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSuperKeyword_4_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSuperKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_4__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_5__0"
    // InternalMiniJava.g:7575:1: rule__TerminalExpression__Group_5__0 : rule__TerminalExpression__Group_5__0__Impl rule__TerminalExpression__Group_5__1 ;
    public final void rule__TerminalExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7579:1: ( rule__TerminalExpression__Group_5__0__Impl rule__TerminalExpression__Group_5__1 )
            // InternalMiniJava.g:7580:2: rule__TerminalExpression__Group_5__0__Impl rule__TerminalExpression__Group_5__1
            {
            pushFollow(FOLLOW_70);
            rule__TerminalExpression__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_5__0"


    // $ANTLR start "rule__TerminalExpression__Group_5__0__Impl"
    // InternalMiniJava.g:7587:1: rule__TerminalExpression__Group_5__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7591:1: ( ( () ) )
            // InternalMiniJava.g:7592:1: ( () )
            {
            // InternalMiniJava.g:7592:1: ( () )
            // InternalMiniJava.g:7593:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNullAction_5_0()); 
            }
            // InternalMiniJava.g:7594:2: ()
            // InternalMiniJava.g:7594:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNullAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_5__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_5__1"
    // InternalMiniJava.g:7602:1: rule__TerminalExpression__Group_5__1 : rule__TerminalExpression__Group_5__1__Impl ;
    public final void rule__TerminalExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7606:1: ( rule__TerminalExpression__Group_5__1__Impl )
            // InternalMiniJava.g:7607:2: rule__TerminalExpression__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_5__1"


    // $ANTLR start "rule__TerminalExpression__Group_5__1__Impl"
    // InternalMiniJava.g:7613:1: rule__TerminalExpression__Group_5__1__Impl : ( 'null' ) ;
    public final void rule__TerminalExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7617:1: ( ( 'null' ) )
            // InternalMiniJava.g:7618:1: ( 'null' )
            {
            // InternalMiniJava.g:7618:1: ( 'null' )
            // InternalMiniJava.g:7619:2: 'null'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNullKeyword_5_1()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNullKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_5__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__0"
    // InternalMiniJava.g:7629:1: rule__TerminalExpression__Group_6__0 : rule__TerminalExpression__Group_6__0__Impl rule__TerminalExpression__Group_6__1 ;
    public final void rule__TerminalExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7633:1: ( rule__TerminalExpression__Group_6__0__Impl rule__TerminalExpression__Group_6__1 )
            // InternalMiniJava.g:7634:2: rule__TerminalExpression__Group_6__0__Impl rule__TerminalExpression__Group_6__1
            {
            pushFollow(FOLLOW_71);
            rule__TerminalExpression__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__0"


    // $ANTLR start "rule__TerminalExpression__Group_6__0__Impl"
    // InternalMiniJava.g:7641:1: rule__TerminalExpression__Group_6__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7645:1: ( ( () ) )
            // InternalMiniJava.g:7646:1: ( () )
            {
            // InternalMiniJava.g:7646:1: ( () )
            // InternalMiniJava.g:7647:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNewObjectAction_6_0()); 
            }
            // InternalMiniJava.g:7648:2: ()
            // InternalMiniJava.g:7648:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNewObjectAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__1"
    // InternalMiniJava.g:7656:1: rule__TerminalExpression__Group_6__1 : rule__TerminalExpression__Group_6__1__Impl rule__TerminalExpression__Group_6__2 ;
    public final void rule__TerminalExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7660:1: ( rule__TerminalExpression__Group_6__1__Impl rule__TerminalExpression__Group_6__2 )
            // InternalMiniJava.g:7661:2: rule__TerminalExpression__Group_6__1__Impl rule__TerminalExpression__Group_6__2
            {
            pushFollow(FOLLOW_6);
            rule__TerminalExpression__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__1"


    // $ANTLR start "rule__TerminalExpression__Group_6__1__Impl"
    // InternalMiniJava.g:7668:1: rule__TerminalExpression__Group_6__1__Impl : ( 'new' ) ;
    public final void rule__TerminalExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7672:1: ( ( 'new' ) )
            // InternalMiniJava.g:7673:1: ( 'new' )
            {
            // InternalMiniJava.g:7673:1: ( 'new' )
            // InternalMiniJava.g:7674:2: 'new'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNewKeyword_6_1()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNewKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__2"
    // InternalMiniJava.g:7683:1: rule__TerminalExpression__Group_6__2 : rule__TerminalExpression__Group_6__2__Impl rule__TerminalExpression__Group_6__3 ;
    public final void rule__TerminalExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7687:1: ( rule__TerminalExpression__Group_6__2__Impl rule__TerminalExpression__Group_6__3 )
            // InternalMiniJava.g:7688:2: rule__TerminalExpression__Group_6__2__Impl rule__TerminalExpression__Group_6__3
            {
            pushFollow(FOLLOW_31);
            rule__TerminalExpression__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__2"


    // $ANTLR start "rule__TerminalExpression__Group_6__2__Impl"
    // InternalMiniJava.g:7695:1: rule__TerminalExpression__Group_6__2__Impl : ( ( rule__TerminalExpression__TypeAssignment_6_2 ) ) ;
    public final void rule__TerminalExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7699:1: ( ( ( rule__TerminalExpression__TypeAssignment_6_2 ) ) )
            // InternalMiniJava.g:7700:1: ( ( rule__TerminalExpression__TypeAssignment_6_2 ) )
            {
            // InternalMiniJava.g:7700:1: ( ( rule__TerminalExpression__TypeAssignment_6_2 ) )
            // InternalMiniJava.g:7701:2: ( rule__TerminalExpression__TypeAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getTypeAssignment_6_2()); 
            }
            // InternalMiniJava.g:7702:2: ( rule__TerminalExpression__TypeAssignment_6_2 )
            // InternalMiniJava.g:7702:3: rule__TerminalExpression__TypeAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__TypeAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getTypeAssignment_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__2__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__3"
    // InternalMiniJava.g:7710:1: rule__TerminalExpression__Group_6__3 : rule__TerminalExpression__Group_6__3__Impl rule__TerminalExpression__Group_6__4 ;
    public final void rule__TerminalExpression__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7714:1: ( rule__TerminalExpression__Group_6__3__Impl rule__TerminalExpression__Group_6__4 )
            // InternalMiniJava.g:7715:2: rule__TerminalExpression__Group_6__3__Impl rule__TerminalExpression__Group_6__4
            {
            pushFollow(FOLLOW_64);
            rule__TerminalExpression__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__3"


    // $ANTLR start "rule__TerminalExpression__Group_6__3__Impl"
    // InternalMiniJava.g:7722:1: rule__TerminalExpression__Group_6__3__Impl : ( ( '(' ) ) ;
    public final void rule__TerminalExpression__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7726:1: ( ( ( '(' ) ) )
            // InternalMiniJava.g:7727:1: ( ( '(' ) )
            {
            // InternalMiniJava.g:7727:1: ( ( '(' ) )
            // InternalMiniJava.g:7728:2: ( '(' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_6_3()); 
            }
            // InternalMiniJava.g:7729:2: ( '(' )
            // InternalMiniJava.g:7729:3: '('
            {
            match(input,28,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_6_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__3__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__4"
    // InternalMiniJava.g:7737:1: rule__TerminalExpression__Group_6__4 : rule__TerminalExpression__Group_6__4__Impl rule__TerminalExpression__Group_6__5 ;
    public final void rule__TerminalExpression__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7741:1: ( rule__TerminalExpression__Group_6__4__Impl rule__TerminalExpression__Group_6__5 )
            // InternalMiniJava.g:7742:2: rule__TerminalExpression__Group_6__4__Impl rule__TerminalExpression__Group_6__5
            {
            pushFollow(FOLLOW_64);
            rule__TerminalExpression__Group_6__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__4"


    // $ANTLR start "rule__TerminalExpression__Group_6__4__Impl"
    // InternalMiniJava.g:7749:1: rule__TerminalExpression__Group_6__4__Impl : ( ( rule__TerminalExpression__Group_6_4__0 )? ) ;
    public final void rule__TerminalExpression__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7753:1: ( ( ( rule__TerminalExpression__Group_6_4__0 )? ) )
            // InternalMiniJava.g:7754:1: ( ( rule__TerminalExpression__Group_6_4__0 )? )
            {
            // InternalMiniJava.g:7754:1: ( ( rule__TerminalExpression__Group_6_4__0 )? )
            // InternalMiniJava.g:7755:2: ( rule__TerminalExpression__Group_6_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getGroup_6_4()); 
            }
            // InternalMiniJava.g:7756:2: ( rule__TerminalExpression__Group_6_4__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_INT)||(LA56_0>=12 && LA56_0<=13)||LA56_0==28||LA56_0==55||(LA56_0>=59 && LA56_0<=63)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMiniJava.g:7756:3: rule__TerminalExpression__Group_6_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_6_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getGroup_6_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__4__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6__5"
    // InternalMiniJava.g:7764:1: rule__TerminalExpression__Group_6__5 : rule__TerminalExpression__Group_6__5__Impl ;
    public final void rule__TerminalExpression__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7768:1: ( rule__TerminalExpression__Group_6__5__Impl )
            // InternalMiniJava.g:7769:2: rule__TerminalExpression__Group_6__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__5"


    // $ANTLR start "rule__TerminalExpression__Group_6__5__Impl"
    // InternalMiniJava.g:7775:1: rule__TerminalExpression__Group_6__5__Impl : ( ')' ) ;
    public final void rule__TerminalExpression__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7779:1: ( ( ')' ) )
            // InternalMiniJava.g:7780:1: ( ')' )
            {
            // InternalMiniJava.g:7780:1: ( ')' )
            // InternalMiniJava.g:7781:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_6_5()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_6_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6__5__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6_4__0"
    // InternalMiniJava.g:7791:1: rule__TerminalExpression__Group_6_4__0 : rule__TerminalExpression__Group_6_4__0__Impl rule__TerminalExpression__Group_6_4__1 ;
    public final void rule__TerminalExpression__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7795:1: ( rule__TerminalExpression__Group_6_4__0__Impl rule__TerminalExpression__Group_6_4__1 )
            // InternalMiniJava.g:7796:2: rule__TerminalExpression__Group_6_4__0__Impl rule__TerminalExpression__Group_6_4__1
            {
            pushFollow(FOLLOW_15);
            rule__TerminalExpression__Group_6_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4__0"


    // $ANTLR start "rule__TerminalExpression__Group_6_4__0__Impl"
    // InternalMiniJava.g:7803:1: rule__TerminalExpression__Group_6_4__0__Impl : ( ( rule__TerminalExpression__ArgsAssignment_6_4_0 ) ) ;
    public final void rule__TerminalExpression__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7807:1: ( ( ( rule__TerminalExpression__ArgsAssignment_6_4_0 ) ) )
            // InternalMiniJava.g:7808:1: ( ( rule__TerminalExpression__ArgsAssignment_6_4_0 ) )
            {
            // InternalMiniJava.g:7808:1: ( ( rule__TerminalExpression__ArgsAssignment_6_4_0 ) )
            // InternalMiniJava.g:7809:2: ( rule__TerminalExpression__ArgsAssignment_6_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getArgsAssignment_6_4_0()); 
            }
            // InternalMiniJava.g:7810:2: ( rule__TerminalExpression__ArgsAssignment_6_4_0 )
            // InternalMiniJava.g:7810:3: rule__TerminalExpression__ArgsAssignment_6_4_0
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ArgsAssignment_6_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getArgsAssignment_6_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6_4__1"
    // InternalMiniJava.g:7818:1: rule__TerminalExpression__Group_6_4__1 : rule__TerminalExpression__Group_6_4__1__Impl ;
    public final void rule__TerminalExpression__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7822:1: ( rule__TerminalExpression__Group_6_4__1__Impl )
            // InternalMiniJava.g:7823:2: rule__TerminalExpression__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4__1"


    // $ANTLR start "rule__TerminalExpression__Group_6_4__1__Impl"
    // InternalMiniJava.g:7829:1: rule__TerminalExpression__Group_6_4__1__Impl : ( ( rule__TerminalExpression__Group_6_4_1__0 )* ) ;
    public final void rule__TerminalExpression__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7833:1: ( ( ( rule__TerminalExpression__Group_6_4_1__0 )* ) )
            // InternalMiniJava.g:7834:1: ( ( rule__TerminalExpression__Group_6_4_1__0 )* )
            {
            // InternalMiniJava.g:7834:1: ( ( rule__TerminalExpression__Group_6_4_1__0 )* )
            // InternalMiniJava.g:7835:2: ( rule__TerminalExpression__Group_6_4_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getGroup_6_4_1()); 
            }
            // InternalMiniJava.g:7836:2: ( rule__TerminalExpression__Group_6_4_1__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==26) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalMiniJava.g:7836:3: rule__TerminalExpression__Group_6_4_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__TerminalExpression__Group_6_4_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getGroup_6_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6_4_1__0"
    // InternalMiniJava.g:7845:1: rule__TerminalExpression__Group_6_4_1__0 : rule__TerminalExpression__Group_6_4_1__0__Impl rule__TerminalExpression__Group_6_4_1__1 ;
    public final void rule__TerminalExpression__Group_6_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7849:1: ( rule__TerminalExpression__Group_6_4_1__0__Impl rule__TerminalExpression__Group_6_4_1__1 )
            // InternalMiniJava.g:7850:2: rule__TerminalExpression__Group_6_4_1__0__Impl rule__TerminalExpression__Group_6_4_1__1
            {
            pushFollow(FOLLOW_25);
            rule__TerminalExpression__Group_6_4_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6_4_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4_1__0"


    // $ANTLR start "rule__TerminalExpression__Group_6_4_1__0__Impl"
    // InternalMiniJava.g:7857:1: rule__TerminalExpression__Group_6_4_1__0__Impl : ( ',' ) ;
    public final void rule__TerminalExpression__Group_6_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7861:1: ( ( ',' ) )
            // InternalMiniJava.g:7862:1: ( ',' )
            {
            // InternalMiniJava.g:7862:1: ( ',' )
            // InternalMiniJava.g:7863:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getCommaKeyword_6_4_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getCommaKeyword_6_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4_1__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_6_4_1__1"
    // InternalMiniJava.g:7872:1: rule__TerminalExpression__Group_6_4_1__1 : rule__TerminalExpression__Group_6_4_1__1__Impl ;
    public final void rule__TerminalExpression__Group_6_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7876:1: ( rule__TerminalExpression__Group_6_4_1__1__Impl )
            // InternalMiniJava.g:7877:2: rule__TerminalExpression__Group_6_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_6_4_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4_1__1"


    // $ANTLR start "rule__TerminalExpression__Group_6_4_1__1__Impl"
    // InternalMiniJava.g:7883:1: rule__TerminalExpression__Group_6_4_1__1__Impl : ( ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 ) ) ;
    public final void rule__TerminalExpression__Group_6_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7887:1: ( ( ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 ) ) )
            // InternalMiniJava.g:7888:1: ( ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 ) )
            {
            // InternalMiniJava.g:7888:1: ( ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 ) )
            // InternalMiniJava.g:7889:2: ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getArgsAssignment_6_4_1_1()); 
            }
            // InternalMiniJava.g:7890:2: ( rule__TerminalExpression__ArgsAssignment_6_4_1_1 )
            // InternalMiniJava.g:7890:3: rule__TerminalExpression__ArgsAssignment_6_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ArgsAssignment_6_4_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getArgsAssignment_6_4_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_6_4_1__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__0"
    // InternalMiniJava.g:7899:1: rule__TerminalExpression__Group_7__0 : rule__TerminalExpression__Group_7__0__Impl rule__TerminalExpression__Group_7__1 ;
    public final void rule__TerminalExpression__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7903:1: ( rule__TerminalExpression__Group_7__0__Impl rule__TerminalExpression__Group_7__1 )
            // InternalMiniJava.g:7904:2: rule__TerminalExpression__Group_7__0__Impl rule__TerminalExpression__Group_7__1
            {
            pushFollow(FOLLOW_71);
            rule__TerminalExpression__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__0"


    // $ANTLR start "rule__TerminalExpression__Group_7__0__Impl"
    // InternalMiniJava.g:7911:1: rule__TerminalExpression__Group_7__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7915:1: ( ( () ) )
            // InternalMiniJava.g:7916:1: ( () )
            {
            // InternalMiniJava.g:7916:1: ( () )
            // InternalMiniJava.g:7917:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNewArrayAction_7_0()); 
            }
            // InternalMiniJava.g:7918:2: ()
            // InternalMiniJava.g:7918:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNewArrayAction_7_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__1"
    // InternalMiniJava.g:7926:1: rule__TerminalExpression__Group_7__1 : rule__TerminalExpression__Group_7__1__Impl rule__TerminalExpression__Group_7__2 ;
    public final void rule__TerminalExpression__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7930:1: ( rule__TerminalExpression__Group_7__1__Impl rule__TerminalExpression__Group_7__2 )
            // InternalMiniJava.g:7931:2: rule__TerminalExpression__Group_7__1__Impl rule__TerminalExpression__Group_7__2
            {
            pushFollow(FOLLOW_23);
            rule__TerminalExpression__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__1"


    // $ANTLR start "rule__TerminalExpression__Group_7__1__Impl"
    // InternalMiniJava.g:7938:1: rule__TerminalExpression__Group_7__1__Impl : ( 'new' ) ;
    public final void rule__TerminalExpression__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7942:1: ( ( 'new' ) )
            // InternalMiniJava.g:7943:1: ( 'new' )
            {
            // InternalMiniJava.g:7943:1: ( 'new' )
            // InternalMiniJava.g:7944:2: 'new'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getNewKeyword_7_1()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getNewKeyword_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__2"
    // InternalMiniJava.g:7953:1: rule__TerminalExpression__Group_7__2 : rule__TerminalExpression__Group_7__2__Impl rule__TerminalExpression__Group_7__3 ;
    public final void rule__TerminalExpression__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7957:1: ( rule__TerminalExpression__Group_7__2__Impl rule__TerminalExpression__Group_7__3 )
            // InternalMiniJava.g:7958:2: rule__TerminalExpression__Group_7__2__Impl rule__TerminalExpression__Group_7__3
            {
            pushFollow(FOLLOW_35);
            rule__TerminalExpression__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__2"


    // $ANTLR start "rule__TerminalExpression__Group_7__2__Impl"
    // InternalMiniJava.g:7965:1: rule__TerminalExpression__Group_7__2__Impl : ( ( rule__TerminalExpression__TypeAssignment_7_2 ) ) ;
    public final void rule__TerminalExpression__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7969:1: ( ( ( rule__TerminalExpression__TypeAssignment_7_2 ) ) )
            // InternalMiniJava.g:7970:1: ( ( rule__TerminalExpression__TypeAssignment_7_2 ) )
            {
            // InternalMiniJava.g:7970:1: ( ( rule__TerminalExpression__TypeAssignment_7_2 ) )
            // InternalMiniJava.g:7971:2: ( rule__TerminalExpression__TypeAssignment_7_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getTypeAssignment_7_2()); 
            }
            // InternalMiniJava.g:7972:2: ( rule__TerminalExpression__TypeAssignment_7_2 )
            // InternalMiniJava.g:7972:3: rule__TerminalExpression__TypeAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__TypeAssignment_7_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getTypeAssignment_7_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__2__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__3"
    // InternalMiniJava.g:7980:1: rule__TerminalExpression__Group_7__3 : rule__TerminalExpression__Group_7__3__Impl rule__TerminalExpression__Group_7__4 ;
    public final void rule__TerminalExpression__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7984:1: ( rule__TerminalExpression__Group_7__3__Impl rule__TerminalExpression__Group_7__4 )
            // InternalMiniJava.g:7985:2: rule__TerminalExpression__Group_7__3__Impl rule__TerminalExpression__Group_7__4
            {
            pushFollow(FOLLOW_25);
            rule__TerminalExpression__Group_7__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__3"


    // $ANTLR start "rule__TerminalExpression__Group_7__3__Impl"
    // InternalMiniJava.g:7992:1: rule__TerminalExpression__Group_7__3__Impl : ( ( '[' ) ) ;
    public final void rule__TerminalExpression__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:7996:1: ( ( ( '[' ) ) )
            // InternalMiniJava.g:7997:1: ( ( '[' ) )
            {
            // InternalMiniJava.g:7997:1: ( ( '[' ) )
            // InternalMiniJava.g:7998:2: ( '[' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getLeftSquareBracketKeyword_7_3()); 
            }
            // InternalMiniJava.g:7999:2: ( '[' )
            // InternalMiniJava.g:7999:3: '['
            {
            match(input,39,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getLeftSquareBracketKeyword_7_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__3__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__4"
    // InternalMiniJava.g:8007:1: rule__TerminalExpression__Group_7__4 : rule__TerminalExpression__Group_7__4__Impl rule__TerminalExpression__Group_7__5 ;
    public final void rule__TerminalExpression__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8011:1: ( rule__TerminalExpression__Group_7__4__Impl rule__TerminalExpression__Group_7__5 )
            // InternalMiniJava.g:8012:2: rule__TerminalExpression__Group_7__4__Impl rule__TerminalExpression__Group_7__5
            {
            pushFollow(FOLLOW_36);
            rule__TerminalExpression__Group_7__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__4"


    // $ANTLR start "rule__TerminalExpression__Group_7__4__Impl"
    // InternalMiniJava.g:8019:1: rule__TerminalExpression__Group_7__4__Impl : ( ( rule__TerminalExpression__SizeAssignment_7_4 ) ) ;
    public final void rule__TerminalExpression__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8023:1: ( ( ( rule__TerminalExpression__SizeAssignment_7_4 ) ) )
            // InternalMiniJava.g:8024:1: ( ( rule__TerminalExpression__SizeAssignment_7_4 ) )
            {
            // InternalMiniJava.g:8024:1: ( ( rule__TerminalExpression__SizeAssignment_7_4 ) )
            // InternalMiniJava.g:8025:2: ( rule__TerminalExpression__SizeAssignment_7_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSizeAssignment_7_4()); 
            }
            // InternalMiniJava.g:8026:2: ( rule__TerminalExpression__SizeAssignment_7_4 )
            // InternalMiniJava.g:8026:3: rule__TerminalExpression__SizeAssignment_7_4
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__SizeAssignment_7_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSizeAssignment_7_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__4__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_7__5"
    // InternalMiniJava.g:8034:1: rule__TerminalExpression__Group_7__5 : rule__TerminalExpression__Group_7__5__Impl ;
    public final void rule__TerminalExpression__Group_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8038:1: ( rule__TerminalExpression__Group_7__5__Impl )
            // InternalMiniJava.g:8039:2: rule__TerminalExpression__Group_7__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_7__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__5"


    // $ANTLR start "rule__TerminalExpression__Group_7__5__Impl"
    // InternalMiniJava.g:8045:1: rule__TerminalExpression__Group_7__5__Impl : ( ']' ) ;
    public final void rule__TerminalExpression__Group_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8049:1: ( ( ']' ) )
            // InternalMiniJava.g:8050:1: ( ']' )
            {
            // InternalMiniJava.g:8050:1: ( ']' )
            // InternalMiniJava.g:8051:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getRightSquareBracketKeyword_7_5()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getRightSquareBracketKeyword_7_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_7__5__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_8__0"
    // InternalMiniJava.g:8061:1: rule__TerminalExpression__Group_8__0 : rule__TerminalExpression__Group_8__0__Impl rule__TerminalExpression__Group_8__1 ;
    public final void rule__TerminalExpression__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8065:1: ( rule__TerminalExpression__Group_8__0__Impl rule__TerminalExpression__Group_8__1 )
            // InternalMiniJava.g:8066:2: rule__TerminalExpression__Group_8__0__Impl rule__TerminalExpression__Group_8__1
            {
            pushFollow(FOLLOW_25);
            rule__TerminalExpression__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_8__0"


    // $ANTLR start "rule__TerminalExpression__Group_8__0__Impl"
    // InternalMiniJava.g:8073:1: rule__TerminalExpression__Group_8__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8077:1: ( ( () ) )
            // InternalMiniJava.g:8078:1: ( () )
            {
            // InternalMiniJava.g:8078:1: ( () )
            // InternalMiniJava.g:8079:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSymbolRefAction_8_0()); 
            }
            // InternalMiniJava.g:8080:2: ()
            // InternalMiniJava.g:8080:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSymbolRefAction_8_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_8__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_8__1"
    // InternalMiniJava.g:8088:1: rule__TerminalExpression__Group_8__1 : rule__TerminalExpression__Group_8__1__Impl ;
    public final void rule__TerminalExpression__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8092:1: ( rule__TerminalExpression__Group_8__1__Impl )
            // InternalMiniJava.g:8093:2: rule__TerminalExpression__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_8__1"


    // $ANTLR start "rule__TerminalExpression__Group_8__1__Impl"
    // InternalMiniJava.g:8099:1: rule__TerminalExpression__Group_8__1__Impl : ( ( rule__TerminalExpression__SymbolAssignment_8_1 ) ) ;
    public final void rule__TerminalExpression__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8103:1: ( ( ( rule__TerminalExpression__SymbolAssignment_8_1 ) ) )
            // InternalMiniJava.g:8104:1: ( ( rule__TerminalExpression__SymbolAssignment_8_1 ) )
            {
            // InternalMiniJava.g:8104:1: ( ( rule__TerminalExpression__SymbolAssignment_8_1 ) )
            // InternalMiniJava.g:8105:2: ( rule__TerminalExpression__SymbolAssignment_8_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSymbolAssignment_8_1()); 
            }
            // InternalMiniJava.g:8106:2: ( rule__TerminalExpression__SymbolAssignment_8_1 )
            // InternalMiniJava.g:8106:3: rule__TerminalExpression__SymbolAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__SymbolAssignment_8_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSymbolAssignment_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_8__1__Impl"


    // $ANTLR start "rule__Program__NameAssignment_0_1"
    // InternalMiniJava.g:8115:1: rule__Program__NameAssignment_0_1 : ( ruleQualifiedName ) ;
    public final void rule__Program__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8119:1: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8120:2: ( ruleQualifiedName )
            {
            // InternalMiniJava.g:8120:2: ( ruleQualifiedName )
            // InternalMiniJava.g:8121:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getNameQualifiedNameParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getNameQualifiedNameParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__NameAssignment_0_1"


    // $ANTLR start "rule__Program__ImportsAssignment_1"
    // InternalMiniJava.g:8130:1: rule__Program__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Program__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8134:1: ( ( ruleImport ) )
            // InternalMiniJava.g:8135:2: ( ruleImport )
            {
            // InternalMiniJava.g:8135:2: ( ruleImport )
            // InternalMiniJava.g:8136:3: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getImportsImportParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getImportsImportParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ImportsAssignment_1"


    // $ANTLR start "rule__Program__ClassesAssignment_2"
    // InternalMiniJava.g:8145:1: rule__Program__ClassesAssignment_2 : ( ruleTypeDeclaration ) ;
    public final void rule__Program__ClassesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8149:1: ( ( ruleTypeDeclaration ) )
            // InternalMiniJava.g:8150:2: ( ruleTypeDeclaration )
            {
            // InternalMiniJava.g:8150:2: ( ruleTypeDeclaration )
            // InternalMiniJava.g:8151:3: ruleTypeDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClassesTypeDeclarationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClassesTypeDeclarationParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ClassesAssignment_2"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalMiniJava.g:8160:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8164:1: ( ( ruleQualifiedNameWithWildcard ) )
            // InternalMiniJava.g:8165:2: ( ruleQualifiedNameWithWildcard )
            {
            // InternalMiniJava.g:8165:2: ( ruleQualifiedNameWithWildcard )
            // InternalMiniJava.g:8166:3: ruleQualifiedNameWithWildcard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Clazz__AccessLevelAssignment_0"
    // InternalMiniJava.g:8175:1: rule__Clazz__AccessLevelAssignment_0 : ( ruleAccessLevel ) ;
    public final void rule__Clazz__AccessLevelAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8179:1: ( ( ruleAccessLevel ) )
            // InternalMiniJava.g:8180:2: ( ruleAccessLevel )
            {
            // InternalMiniJava.g:8180:2: ( ruleAccessLevel )
            // InternalMiniJava.g:8181:3: ruleAccessLevel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getAccessLevelAccessLevelEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAccessLevel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getAccessLevelAccessLevelEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__AccessLevelAssignment_0"


    // $ANTLR start "rule__Clazz__IsabstractAssignment_1"
    // InternalMiniJava.g:8190:1: rule__Clazz__IsabstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__Clazz__IsabstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8194:1: ( ( ( 'abstract' ) ) )
            // InternalMiniJava.g:8195:2: ( ( 'abstract' ) )
            {
            // InternalMiniJava.g:8195:2: ( ( 'abstract' ) )
            // InternalMiniJava.g:8196:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getIsabstractAbstractKeyword_1_0()); 
            }
            // InternalMiniJava.g:8197:3: ( 'abstract' )
            // InternalMiniJava.g:8198:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getIsabstractAbstractKeyword_1_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getIsabstractAbstractKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getIsabstractAbstractKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__IsabstractAssignment_1"


    // $ANTLR start "rule__Clazz__NameAssignment_3"
    // InternalMiniJava.g:8209:1: rule__Clazz__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Clazz__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8213:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8214:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8214:2: ( RULE_ID )
            // InternalMiniJava.g:8215:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__NameAssignment_3"


    // $ANTLR start "rule__Clazz__SuperClassAssignment_4_1"
    // InternalMiniJava.g:8224:1: rule__Clazz__SuperClassAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Clazz__SuperClassAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8228:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8229:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8229:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8230:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getSuperClassClazzCrossReference_4_1_0()); 
            }
            // InternalMiniJava.g:8231:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8232:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getSuperClassClazzQualifiedNameParserRuleCall_4_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getSuperClassClazzQualifiedNameParserRuleCall_4_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getSuperClassClazzCrossReference_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__SuperClassAssignment_4_1"


    // $ANTLR start "rule__Clazz__ImplementzAssignment_5_1"
    // InternalMiniJava.g:8243:1: rule__Clazz__ImplementzAssignment_5_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Clazz__ImplementzAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8247:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8248:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8248:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8249:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzInterfaceCrossReference_5_1_0()); 
            }
            // InternalMiniJava.g:8250:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8251:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzInterfaceQualifiedNameParserRuleCall_5_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzInterfaceQualifiedNameParserRuleCall_5_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzInterfaceCrossReference_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__ImplementzAssignment_5_1"


    // $ANTLR start "rule__Clazz__ImplementzAssignment_5_2_1"
    // InternalMiniJava.g:8262:1: rule__Clazz__ImplementzAssignment_5_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Clazz__ImplementzAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8266:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8267:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8267:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8268:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzInterfaceCrossReference_5_2_1_0()); 
            }
            // InternalMiniJava.g:8269:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8270:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getImplementzInterfaceQualifiedNameParserRuleCall_5_2_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzInterfaceQualifiedNameParserRuleCall_5_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getImplementzInterfaceCrossReference_5_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__ImplementzAssignment_5_2_1"


    // $ANTLR start "rule__Clazz__MembersAssignment_7"
    // InternalMiniJava.g:8281:1: rule__Clazz__MembersAssignment_7 : ( ruleMember ) ;
    public final void rule__Clazz__MembersAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8285:1: ( ( ruleMember ) )
            // InternalMiniJava.g:8286:2: ( ruleMember )
            {
            // InternalMiniJava.g:8286:2: ( ruleMember )
            // InternalMiniJava.g:8287:3: ruleMember
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClazzAccess().getMembersMemberParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMember();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClazzAccess().getMembersMemberParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clazz__MembersAssignment_7"


    // $ANTLR start "rule__Interface__AccessLevelAssignment_0"
    // InternalMiniJava.g:8296:1: rule__Interface__AccessLevelAssignment_0 : ( ruleAccessLevel ) ;
    public final void rule__Interface__AccessLevelAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8300:1: ( ( ruleAccessLevel ) )
            // InternalMiniJava.g:8301:2: ( ruleAccessLevel )
            {
            // InternalMiniJava.g:8301:2: ( ruleAccessLevel )
            // InternalMiniJava.g:8302:3: ruleAccessLevel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getAccessLevelAccessLevelEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAccessLevel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getAccessLevelAccessLevelEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__AccessLevelAssignment_0"


    // $ANTLR start "rule__Interface__NameAssignment_2"
    // InternalMiniJava.g:8311:1: rule__Interface__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Interface__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8315:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8316:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8316:2: ( RULE_ID )
            // InternalMiniJava.g:8317:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__NameAssignment_2"


    // $ANTLR start "rule__Interface__ImplementzAssignment_3_1"
    // InternalMiniJava.g:8326:1: rule__Interface__ImplementzAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Interface__ImplementzAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8330:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8331:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8331:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8332:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzInterfaceCrossReference_3_1_0()); 
            }
            // InternalMiniJava.g:8333:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8334:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzInterfaceQualifiedNameParserRuleCall_3_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzInterfaceQualifiedNameParserRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzInterfaceCrossReference_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__ImplementzAssignment_3_1"


    // $ANTLR start "rule__Interface__ImplementzAssignment_3_2_1"
    // InternalMiniJava.g:8345:1: rule__Interface__ImplementzAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Interface__ImplementzAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8349:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8350:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8350:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8351:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzInterfaceCrossReference_3_2_1_0()); 
            }
            // InternalMiniJava.g:8352:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8353:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getImplementzInterfaceQualifiedNameParserRuleCall_3_2_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzInterfaceQualifiedNameParserRuleCall_3_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getImplementzInterfaceCrossReference_3_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__ImplementzAssignment_3_2_1"


    // $ANTLR start "rule__Interface__MembersAssignment_5"
    // InternalMiniJava.g:8364:1: rule__Interface__MembersAssignment_5 : ( ruleMember ) ;
    public final void rule__Interface__MembersAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8368:1: ( ( ruleMember ) )
            // InternalMiniJava.g:8369:2: ( ruleMember )
            {
            // InternalMiniJava.g:8369:2: ( ruleMember )
            // InternalMiniJava.g:8370:3: ruleMember
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInterfaceAccess().getMembersMemberParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMember();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInterfaceAccess().getMembersMemberParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interface__MembersAssignment_5"


    // $ANTLR start "rule__Method__AccessAssignment_0"
    // InternalMiniJava.g:8379:1: rule__Method__AccessAssignment_0 : ( ruleAccessLevel ) ;
    public final void rule__Method__AccessAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8383:1: ( ( ruleAccessLevel ) )
            // InternalMiniJava.g:8384:2: ( ruleAccessLevel )
            {
            // InternalMiniJava.g:8384:2: ( ruleAccessLevel )
            // InternalMiniJava.g:8385:3: ruleAccessLevel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getAccessAccessLevelEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAccessLevel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getAccessAccessLevelEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__AccessAssignment_0"


    // $ANTLR start "rule__Method__IsabstractAssignment_1"
    // InternalMiniJava.g:8394:1: rule__Method__IsabstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__Method__IsabstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8398:1: ( ( ( 'abstract' ) ) )
            // InternalMiniJava.g:8399:2: ( ( 'abstract' ) )
            {
            // InternalMiniJava.g:8399:2: ( ( 'abstract' ) )
            // InternalMiniJava.g:8400:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsabstractAbstractKeyword_1_0()); 
            }
            // InternalMiniJava.g:8401:3: ( 'abstract' )
            // InternalMiniJava.g:8402:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsabstractAbstractKeyword_1_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsabstractAbstractKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsabstractAbstractKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__IsabstractAssignment_1"


    // $ANTLR start "rule__Method__IsstaticAssignment_2"
    // InternalMiniJava.g:8413:1: rule__Method__IsstaticAssignment_2 : ( ( 'static' ) ) ;
    public final void rule__Method__IsstaticAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8417:1: ( ( ( 'static' ) ) )
            // InternalMiniJava.g:8418:2: ( ( 'static' ) )
            {
            // InternalMiniJava.g:8418:2: ( ( 'static' ) )
            // InternalMiniJava.g:8419:3: ( 'static' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsstaticStaticKeyword_2_0()); 
            }
            // InternalMiniJava.g:8420:3: ( 'static' )
            // InternalMiniJava.g:8421:4: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getIsstaticStaticKeyword_2_0()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsstaticStaticKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getIsstaticStaticKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__IsstaticAssignment_2"


    // $ANTLR start "rule__Method__TypeRefAssignment_3"
    // InternalMiniJava.g:8432:1: rule__Method__TypeRefAssignment_3 : ( ruleTypeRef ) ;
    public final void rule__Method__TypeRefAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8436:1: ( ( ruleTypeRef ) )
            // InternalMiniJava.g:8437:2: ( ruleTypeRef )
            {
            // InternalMiniJava.g:8437:2: ( ruleTypeRef )
            // InternalMiniJava.g:8438:3: ruleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getTypeRefTypeRefParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getTypeRefTypeRefParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__TypeRefAssignment_3"


    // $ANTLR start "rule__Method__NameAssignment_4"
    // InternalMiniJava.g:8447:1: rule__Method__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__Method__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8451:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8452:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8452:2: ( RULE_ID )
            // InternalMiniJava.g:8453:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_4_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__NameAssignment_4"


    // $ANTLR start "rule__Method__ParamsAssignment_6_0"
    // InternalMiniJava.g:8462:1: rule__Method__ParamsAssignment_6_0 : ( ruleParameter ) ;
    public final void rule__Method__ParamsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8466:1: ( ( ruleParameter ) )
            // InternalMiniJava.g:8467:2: ( ruleParameter )
            {
            // InternalMiniJava.g:8467:2: ( ruleParameter )
            // InternalMiniJava.g:8468:3: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_6_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_6_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__ParamsAssignment_6_0"


    // $ANTLR start "rule__Method__ParamsAssignment_6_1_1"
    // InternalMiniJava.g:8477:1: rule__Method__ParamsAssignment_6_1_1 : ( ruleParameter ) ;
    public final void rule__Method__ParamsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8481:1: ( ( ruleParameter ) )
            // InternalMiniJava.g:8482:2: ( ruleParameter )
            {
            // InternalMiniJava.g:8482:2: ( ruleParameter )
            // InternalMiniJava.g:8483:3: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_6_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_6_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__ParamsAssignment_6_1_1"


    // $ANTLR start "rule__Method__BodyAssignment_8_0"
    // InternalMiniJava.g:8492:1: rule__Method__BodyAssignment_8_0 : ( ruleBlock ) ;
    public final void rule__Method__BodyAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8496:1: ( ( ruleBlock ) )
            // InternalMiniJava.g:8497:2: ( ruleBlock )
            {
            // InternalMiniJava.g:8497:2: ( ruleBlock )
            // InternalMiniJava.g:8498:3: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getBodyBlockParserRuleCall_8_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getBodyBlockParserRuleCall_8_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__BodyAssignment_8_0"


    // $ANTLR start "rule__Parameter__TypeRefAssignment_0"
    // InternalMiniJava.g:8507:1: rule__Parameter__TypeRefAssignment_0 : ( ruleTypeRef ) ;
    public final void rule__Parameter__TypeRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8511:1: ( ( ruleTypeRef ) )
            // InternalMiniJava.g:8512:2: ( ruleTypeRef )
            {
            // InternalMiniJava.g:8512:2: ( ruleTypeRef )
            // InternalMiniJava.g:8513:3: ruleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeRefTypeRefParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeRefTypeRefParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__TypeRefAssignment_0"


    // $ANTLR start "rule__Parameter__NameAssignment_1"
    // InternalMiniJava.g:8522:1: rule__Parameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8526:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8527:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8527:2: ( RULE_ID )
            // InternalMiniJava.g:8528:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_1"


    // $ANTLR start "rule__Field__AccessAssignment_0"
    // InternalMiniJava.g:8537:1: rule__Field__AccessAssignment_0 : ( ruleAccessLevel ) ;
    public final void rule__Field__AccessAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8541:1: ( ( ruleAccessLevel ) )
            // InternalMiniJava.g:8542:2: ( ruleAccessLevel )
            {
            // InternalMiniJava.g:8542:2: ( ruleAccessLevel )
            // InternalMiniJava.g:8543:3: ruleAccessLevel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getAccessAccessLevelEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAccessLevel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getAccessAccessLevelEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__AccessAssignment_0"


    // $ANTLR start "rule__Field__TypeRefAssignment_1"
    // InternalMiniJava.g:8552:1: rule__Field__TypeRefAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Field__TypeRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8556:1: ( ( ruleTypeRef ) )
            // InternalMiniJava.g:8557:2: ( ruleTypeRef )
            {
            // InternalMiniJava.g:8557:2: ( ruleTypeRef )
            // InternalMiniJava.g:8558:3: ruleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeRefTypeRefParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeRefTypeRefParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__TypeRefAssignment_1"


    // $ANTLR start "rule__Field__NameAssignment_2"
    // InternalMiniJava.g:8567:1: rule__Field__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8571:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8572:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8572:2: ( RULE_ID )
            // InternalMiniJava.g:8573:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__NameAssignment_2"


    // $ANTLR start "rule__Field__DefaultValueAssignment_3_1"
    // InternalMiniJava.g:8582:1: rule__Field__DefaultValueAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__Field__DefaultValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8586:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8587:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8587:2: ( ruleExpression )
            // InternalMiniJava.g:8588:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getDefaultValueExpressionParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getDefaultValueExpressionParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__DefaultValueAssignment_3_1"


    // $ANTLR start "rule__Block__StatementsAssignment_2"
    // InternalMiniJava.g:8597:1: rule__Block__StatementsAssignment_2 : ( ruleStatement ) ;
    public final void rule__Block__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8601:1: ( ( ruleStatement ) )
            // InternalMiniJava.g:8602:2: ( ruleStatement )
            {
            // InternalMiniJava.g:8602:2: ( ruleStatement )
            // InternalMiniJava.g:8603:3: ruleStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__StatementsAssignment_2"


    // $ANTLR start "rule__PrintStatement__ExpressionAssignment_6"
    // InternalMiniJava.g:8612:1: rule__PrintStatement__ExpressionAssignment_6 : ( ruleExpression ) ;
    public final void rule__PrintStatement__ExpressionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8616:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8617:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8617:2: ( ruleExpression )
            // InternalMiniJava.g:8618:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrintStatementAccess().getExpressionExpressionParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrintStatementAccess().getExpressionExpressionParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrintStatement__ExpressionAssignment_6"


    // $ANTLR start "rule__Return__ExpressionAssignment_1"
    // InternalMiniJava.g:8627:1: rule__Return__ExpressionAssignment_1 : ( ruleExpression ) ;
    public final void rule__Return__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8631:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8632:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8632:2: ( ruleExpression )
            // InternalMiniJava.g:8633:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReturnAccess().getExpressionExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReturnAccess().getExpressionExpressionParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Return__ExpressionAssignment_1"


    // $ANTLR start "rule__IfStatement__ExpressionAssignment_2"
    // InternalMiniJava.g:8642:1: rule__IfStatement__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__IfStatement__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8646:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8647:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8647:2: ( ruleExpression )
            // InternalMiniJava.g:8648:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__ExpressionAssignment_2"


    // $ANTLR start "rule__IfStatement__ThenBlockAssignment_4"
    // InternalMiniJava.g:8657:1: rule__IfStatement__ThenBlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__IfStatement__ThenBlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8661:1: ( ( ruleBlock ) )
            // InternalMiniJava.g:8662:2: ( ruleBlock )
            {
            // InternalMiniJava.g:8662:2: ( ruleBlock )
            // InternalMiniJava.g:8663:3: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getThenBlockBlockParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getThenBlockBlockParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__ThenBlockAssignment_4"


    // $ANTLR start "rule__IfStatement__ElseBlockAssignment_5_1"
    // InternalMiniJava.g:8672:1: rule__IfStatement__ElseBlockAssignment_5_1 : ( ruleBlock ) ;
    public final void rule__IfStatement__ElseBlockAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8676:1: ( ( ruleBlock ) )
            // InternalMiniJava.g:8677:2: ( ruleBlock )
            {
            // InternalMiniJava.g:8677:2: ( ruleBlock )
            // InternalMiniJava.g:8678:3: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfStatementAccess().getElseBlockBlockParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfStatementAccess().getElseBlockBlockParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__ElseBlockAssignment_5_1"


    // $ANTLR start "rule__WhileStatement__ConditionAssignment_2"
    // InternalMiniJava.g:8687:1: rule__WhileStatement__ConditionAssignment_2 : ( ruleExpression ) ;
    public final void rule__WhileStatement__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8691:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8692:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8692:2: ( ruleExpression )
            // InternalMiniJava.g:8693:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__ConditionAssignment_2"


    // $ANTLR start "rule__WhileStatement__BlockAssignment_4"
    // InternalMiniJava.g:8702:1: rule__WhileStatement__BlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__WhileStatement__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8706:1: ( ( ruleBlock ) )
            // InternalMiniJava.g:8707:2: ( ruleBlock )
            {
            // InternalMiniJava.g:8707:2: ( ruleBlock )
            // InternalMiniJava.g:8708:3: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhileStatementAccess().getBlockBlockParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhileStatementAccess().getBlockBlockParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__BlockAssignment_4"


    // $ANTLR start "rule__ForStatement__DeclarationAssignment_2"
    // InternalMiniJava.g:8717:1: rule__ForStatement__DeclarationAssignment_2 : ( ruleAssignment ) ;
    public final void rule__ForStatement__DeclarationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8721:1: ( ( ruleAssignment ) )
            // InternalMiniJava.g:8722:2: ( ruleAssignment )
            {
            // InternalMiniJava.g:8722:2: ( ruleAssignment )
            // InternalMiniJava.g:8723:3: ruleAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getDeclarationAssignmentParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getDeclarationAssignmentParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__DeclarationAssignment_2"


    // $ANTLR start "rule__ForStatement__ConditionAssignment_4"
    // InternalMiniJava.g:8732:1: rule__ForStatement__ConditionAssignment_4 : ( ruleExpression ) ;
    public final void rule__ForStatement__ConditionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8736:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8737:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8737:2: ( ruleExpression )
            // InternalMiniJava.g:8738:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getConditionExpressionParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getConditionExpressionParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__ConditionAssignment_4"


    // $ANTLR start "rule__ForStatement__ProgressionAssignment_6"
    // InternalMiniJava.g:8747:1: rule__ForStatement__ProgressionAssignment_6 : ( ruleAssignment ) ;
    public final void rule__ForStatement__ProgressionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8751:1: ( ( ruleAssignment ) )
            // InternalMiniJava.g:8752:2: ( ruleAssignment )
            {
            // InternalMiniJava.g:8752:2: ( ruleAssignment )
            // InternalMiniJava.g:8753:3: ruleAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getProgressionAssignmentParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getProgressionAssignmentParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__ProgressionAssignment_6"


    // $ANTLR start "rule__ForStatement__BlockAssignment_8"
    // InternalMiniJava.g:8762:1: rule__ForStatement__BlockAssignment_8 : ( ruleBlock ) ;
    public final void rule__ForStatement__BlockAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8766:1: ( ( ruleBlock ) )
            // InternalMiniJava.g:8767:2: ( ruleBlock )
            {
            // InternalMiniJava.g:8767:2: ( ruleBlock )
            // InternalMiniJava.g:8768:3: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getForStatementAccess().getBlockBlockParserRuleCall_8_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getForStatementAccess().getBlockBlockParserRuleCall_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForStatement__BlockAssignment_8"


    // $ANTLR start "rule__ClassRef__ReferencedClassAssignment"
    // InternalMiniJava.g:8777:1: rule__ClassRef__ReferencedClassAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassRef__ReferencedClassAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8781:1: ( ( ( ruleQualifiedName ) ) )
            // InternalMiniJava.g:8782:2: ( ( ruleQualifiedName ) )
            {
            // InternalMiniJava.g:8782:2: ( ( ruleQualifiedName ) )
            // InternalMiniJava.g:8783:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassRefAccess().getReferencedClassTypeDeclarationCrossReference_0()); 
            }
            // InternalMiniJava.g:8784:3: ( ruleQualifiedName )
            // InternalMiniJava.g:8785:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassRefAccess().getReferencedClassTypeDeclarationQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassRefAccess().getReferencedClassTypeDeclarationQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassRefAccess().getReferencedClassTypeDeclarationCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassRef__ReferencedClassAssignment"


    // $ANTLR start "rule__VariableDeclaration__TypeRefAssignment_0"
    // InternalMiniJava.g:8796:1: rule__VariableDeclaration__TypeRefAssignment_0 : ( ruleTypeRef ) ;
    public final void rule__VariableDeclaration__TypeRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8800:1: ( ( ruleTypeRef ) )
            // InternalMiniJava.g:8801:2: ( ruleTypeRef )
            {
            // InternalMiniJava.g:8801:2: ( ruleTypeRef )
            // InternalMiniJava.g:8802:3: ruleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getTypeRefTypeRefParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getTypeRefTypeRefParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__TypeRefAssignment_0"


    // $ANTLR start "rule__VariableDeclaration__NameAssignment_1"
    // InternalMiniJava.g:8811:1: rule__VariableDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VariableDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8815:1: ( ( RULE_ID ) )
            // InternalMiniJava.g:8816:2: ( RULE_ID )
            {
            // InternalMiniJava.g:8816:2: ( RULE_ID )
            // InternalMiniJava.g:8817:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__NameAssignment_1"


    // $ANTLR start "rule__Assignment__AssigneeAssignment_0"
    // InternalMiniJava.g:8826:1: rule__Assignment__AssigneeAssignment_0 : ( ruleAssignee ) ;
    public final void rule__Assignment__AssigneeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8830:1: ( ( ruleAssignee ) )
            // InternalMiniJava.g:8831:2: ( ruleAssignee )
            {
            // InternalMiniJava.g:8831:2: ( ruleAssignee )
            // InternalMiniJava.g:8832:3: ruleAssignee
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getAssigneeAssigneeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAssignee();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getAssigneeAssigneeParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__AssigneeAssignment_0"


    // $ANTLR start "rule__Assignment__ValueAssignment_2"
    // InternalMiniJava.g:8841:1: rule__Assignment__ValueAssignment_2 : ( ruleExpression ) ;
    public final void rule__Assignment__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8845:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8846:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8846:2: ( ruleExpression )
            // InternalMiniJava.g:8847:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__ValueAssignment_2"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalMiniJava.g:8856:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8860:1: ( ( ruleAnd ) )
            // InternalMiniJava.g:8861:2: ( ruleAnd )
            {
            // InternalMiniJava.g:8861:2: ( ruleAnd )
            // InternalMiniJava.g:8862:3: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalMiniJava.g:8871:1: rule__And__RightAssignment_1_2 : ( ruleEquality ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8875:1: ( ( ruleEquality ) )
            // InternalMiniJava.g:8876:2: ( ruleEquality )
            {
            // InternalMiniJava.g:8876:2: ( ruleEquality )
            // InternalMiniJava.g:8877:3: ruleEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Equality__RightAssignment_1_1"
    // InternalMiniJava.g:8886:1: rule__Equality__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8890:1: ( ( ruleComparison ) )
            // InternalMiniJava.g:8891:2: ( ruleComparison )
            {
            // InternalMiniJava.g:8891:2: ( ruleComparison )
            // InternalMiniJava.g:8892:3: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__RightAssignment_1_1"


    // $ANTLR start "rule__Comparison__RightAssignment_1_1"
    // InternalMiniJava.g:8901:1: rule__Comparison__RightAssignment_1_1 : ( ruleModulo ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8905:1: ( ( ruleModulo ) )
            // InternalMiniJava.g:8906:2: ( ruleModulo )
            {
            // InternalMiniJava.g:8906:2: ( ruleModulo )
            // InternalMiniJava.g:8907:3: ruleModulo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightModuloParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightModuloParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_1_1"


    // $ANTLR start "rule__Modulo__RightAssignment_1_1"
    // InternalMiniJava.g:8916:1: rule__Modulo__RightAssignment_1_1 : ( rulePlusOrMinus ) ;
    public final void rule__Modulo__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8920:1: ( ( rulePlusOrMinus ) )
            // InternalMiniJava.g:8921:2: ( rulePlusOrMinus )
            {
            // InternalMiniJava.g:8921:2: ( rulePlusOrMinus )
            // InternalMiniJava.g:8922:3: rulePlusOrMinus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getRightPlusOrMinusParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getRightPlusOrMinusParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__RightAssignment_1_1"


    // $ANTLR start "rule__PlusOrMinus__RightAssignment_1_1"
    // InternalMiniJava.g:8931:1: rule__PlusOrMinus__RightAssignment_1_1 : ( ruleMulOrDiv ) ;
    public final void rule__PlusOrMinus__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8935:1: ( ( ruleMulOrDiv ) )
            // InternalMiniJava.g:8936:2: ( ruleMulOrDiv )
            {
            // InternalMiniJava.g:8936:2: ( ruleMulOrDiv )
            // InternalMiniJava.g:8937:3: ruleMulOrDiv
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__RightAssignment_1_1"


    // $ANTLR start "rule__MulOrDiv__RightAssignment_1_1"
    // InternalMiniJava.g:8946:1: rule__MulOrDiv__RightAssignment_1_1 : ( ruleArrayAccess ) ;
    public final void rule__MulOrDiv__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8950:1: ( ( ruleArrayAccess ) )
            // InternalMiniJava.g:8951:2: ( ruleArrayAccess )
            {
            // InternalMiniJava.g:8951:2: ( ruleArrayAccess )
            // InternalMiniJava.g:8952:3: ruleArrayAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getRightArrayAccessParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getRightArrayAccessParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__RightAssignment_1_1"


    // $ANTLR start "rule__ArrayAccess__IndexAssignment_1_2"
    // InternalMiniJava.g:8961:1: rule__ArrayAccess__IndexAssignment_1_2 : ( ruleExpression ) ;
    public final void rule__ArrayAccess__IndexAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8965:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:8966:2: ( ruleExpression )
            {
            // InternalMiniJava.g:8966:2: ( ruleExpression )
            // InternalMiniJava.g:8967:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayAccessAccess().getIndexExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayAccessAccess().getIndexExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayAccess__IndexAssignment_1_2"


    // $ANTLR start "rule__Primary__ExpressionAssignment_1_2"
    // InternalMiniJava.g:8976:1: rule__Primary__ExpressionAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Primary__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8980:1: ( ( rulePrimary ) )
            // InternalMiniJava.g:8981:2: ( rulePrimary )
            {
            // InternalMiniJava.g:8981:2: ( rulePrimary )
            // InternalMiniJava.g:8982:3: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ExpressionAssignment_1_2"


    // $ANTLR start "rule__Primary__ExpressionAssignment_2_2"
    // InternalMiniJava.g:8991:1: rule__Primary__ExpressionAssignment_2_2 : ( rulePrimary ) ;
    public final void rule__Primary__ExpressionAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:8995:1: ( ( rulePrimary ) )
            // InternalMiniJava.g:8996:2: ( rulePrimary )
            {
            // InternalMiniJava.g:8996:2: ( rulePrimary )
            // InternalMiniJava.g:8997:3: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ExpressionAssignment_2_2"


    // $ANTLR start "rule__SelectionExpression__FieldAssignment_1_0_2"
    // InternalMiniJava.g:9006:1: rule__SelectionExpression__FieldAssignment_1_0_2 : ( ( RULE_ID ) ) ;
    public final void rule__SelectionExpression__FieldAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9010:1: ( ( ( RULE_ID ) ) )
            // InternalMiniJava.g:9011:2: ( ( RULE_ID ) )
            {
            // InternalMiniJava.g:9011:2: ( ( RULE_ID ) )
            // InternalMiniJava.g:9012:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFieldFieldCrossReference_1_0_2_0()); 
            }
            // InternalMiniJava.g:9013:3: ( RULE_ID )
            // InternalMiniJava.g:9014:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getFieldFieldIDTerminalRuleCall_1_0_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFieldFieldIDTerminalRuleCall_1_0_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getFieldFieldCrossReference_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__FieldAssignment_1_0_2"


    // $ANTLR start "rule__SelectionExpression__MethodAssignment_1_1_2"
    // InternalMiniJava.g:9025:1: rule__SelectionExpression__MethodAssignment_1_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__SelectionExpression__MethodAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9029:1: ( ( ( RULE_ID ) ) )
            // InternalMiniJava.g:9030:2: ( ( RULE_ID ) )
            {
            // InternalMiniJava.g:9030:2: ( ( RULE_ID ) )
            // InternalMiniJava.g:9031:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getMethodMethodCrossReference_1_1_2_0()); 
            }
            // InternalMiniJava.g:9032:3: ( RULE_ID )
            // InternalMiniJava.g:9033:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getMethodMethodIDTerminalRuleCall_1_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getMethodMethodIDTerminalRuleCall_1_1_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getMethodMethodCrossReference_1_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__MethodAssignment_1_1_2"


    // $ANTLR start "rule__SelectionExpression__ArgsAssignment_1_1_4_0"
    // InternalMiniJava.g:9044:1: rule__SelectionExpression__ArgsAssignment_1_1_4_0 : ( ruleExpression ) ;
    public final void rule__SelectionExpression__ArgsAssignment_1_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9048:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:9049:2: ( ruleExpression )
            {
            // InternalMiniJava.g:9049:2: ( ruleExpression )
            // InternalMiniJava.g:9050:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getArgsExpressionParserRuleCall_1_1_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getArgsExpressionParserRuleCall_1_1_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__ArgsAssignment_1_1_4_0"


    // $ANTLR start "rule__SelectionExpression__ArgsAssignment_1_1_4_1_1"
    // InternalMiniJava.g:9059:1: rule__SelectionExpression__ArgsAssignment_1_1_4_1_1 : ( ruleExpression ) ;
    public final void rule__SelectionExpression__ArgsAssignment_1_1_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9063:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:9064:2: ( ruleExpression )
            {
            // InternalMiniJava.g:9064:2: ( ruleExpression )
            // InternalMiniJava.g:9065:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelectionExpressionAccess().getArgsExpressionParserRuleCall_1_1_4_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelectionExpressionAccess().getArgsExpressionParserRuleCall_1_1_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionExpression__ArgsAssignment_1_1_4_1_1"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_0_1"
    // InternalMiniJava.g:9074:1: rule__TerminalExpression__ValueAssignment_0_1 : ( RULE_STRING ) ;
    public final void rule__TerminalExpression__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9078:1: ( ( RULE_STRING ) )
            // InternalMiniJava.g:9079:2: ( RULE_STRING )
            {
            // InternalMiniJava.g:9079:2: ( RULE_STRING )
            // InternalMiniJava.g:9080:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_0_1"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_1_1"
    // InternalMiniJava.g:9089:1: rule__TerminalExpression__ValueAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__TerminalExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9093:1: ( ( RULE_INT ) )
            // InternalMiniJava.g:9094:2: ( RULE_INT )
            {
            // InternalMiniJava.g:9094:2: ( RULE_INT )
            // InternalMiniJava.g:9095:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_1_1"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_2_1"
    // InternalMiniJava.g:9104:1: rule__TerminalExpression__ValueAssignment_2_1 : ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__TerminalExpression__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9108:1: ( ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) ) )
            // InternalMiniJava.g:9109:2: ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) )
            {
            // InternalMiniJava.g:9109:2: ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) )
            // InternalMiniJava.g:9110:3: ( rule__TerminalExpression__ValueAlternatives_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getValueAlternatives_2_1_0()); 
            }
            // InternalMiniJava.g:9111:3: ( rule__TerminalExpression__ValueAlternatives_2_1_0 )
            // InternalMiniJava.g:9111:4: rule__TerminalExpression__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAlternatives_2_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getValueAlternatives_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_2_1"


    // $ANTLR start "rule__TerminalExpression__TypeAssignment_6_2"
    // InternalMiniJava.g:9119:1: rule__TerminalExpression__TypeAssignment_6_2 : ( ( RULE_ID ) ) ;
    public final void rule__TerminalExpression__TypeAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9123:1: ( ( ( RULE_ID ) ) )
            // InternalMiniJava.g:9124:2: ( ( RULE_ID ) )
            {
            // InternalMiniJava.g:9124:2: ( ( RULE_ID ) )
            // InternalMiniJava.g:9125:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getTypeClazzCrossReference_6_2_0()); 
            }
            // InternalMiniJava.g:9126:3: ( RULE_ID )
            // InternalMiniJava.g:9127:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getTypeClazzIDTerminalRuleCall_6_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getTypeClazzIDTerminalRuleCall_6_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getTypeClazzCrossReference_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__TypeAssignment_6_2"


    // $ANTLR start "rule__TerminalExpression__ArgsAssignment_6_4_0"
    // InternalMiniJava.g:9138:1: rule__TerminalExpression__ArgsAssignment_6_4_0 : ( ruleExpression ) ;
    public final void rule__TerminalExpression__ArgsAssignment_6_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9142:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:9143:2: ( ruleExpression )
            {
            // InternalMiniJava.g:9143:2: ( ruleExpression )
            // InternalMiniJava.g:9144:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getArgsExpressionParserRuleCall_6_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getArgsExpressionParserRuleCall_6_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ArgsAssignment_6_4_0"


    // $ANTLR start "rule__TerminalExpression__ArgsAssignment_6_4_1_1"
    // InternalMiniJava.g:9153:1: rule__TerminalExpression__ArgsAssignment_6_4_1_1 : ( ruleExpression ) ;
    public final void rule__TerminalExpression__ArgsAssignment_6_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9157:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:9158:2: ( ruleExpression )
            {
            // InternalMiniJava.g:9158:2: ( ruleExpression )
            // InternalMiniJava.g:9159:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getArgsExpressionParserRuleCall_6_4_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getArgsExpressionParserRuleCall_6_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ArgsAssignment_6_4_1_1"


    // $ANTLR start "rule__TerminalExpression__TypeAssignment_7_2"
    // InternalMiniJava.g:9168:1: rule__TerminalExpression__TypeAssignment_7_2 : ( ruleTypeRef ) ;
    public final void rule__TerminalExpression__TypeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9172:1: ( ( ruleTypeRef ) )
            // InternalMiniJava.g:9173:2: ( ruleTypeRef )
            {
            // InternalMiniJava.g:9173:2: ( ruleTypeRef )
            // InternalMiniJava.g:9174:3: ruleTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getTypeTypeRefParserRuleCall_7_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getTypeTypeRefParserRuleCall_7_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__TypeAssignment_7_2"


    // $ANTLR start "rule__TerminalExpression__SizeAssignment_7_4"
    // InternalMiniJava.g:9183:1: rule__TerminalExpression__SizeAssignment_7_4 : ( ruleExpression ) ;
    public final void rule__TerminalExpression__SizeAssignment_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9187:1: ( ( ruleExpression ) )
            // InternalMiniJava.g:9188:2: ( ruleExpression )
            {
            // InternalMiniJava.g:9188:2: ( ruleExpression )
            // InternalMiniJava.g:9189:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSizeExpressionParserRuleCall_7_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSizeExpressionParserRuleCall_7_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__SizeAssignment_7_4"


    // $ANTLR start "rule__TerminalExpression__SymbolAssignment_8_1"
    // InternalMiniJava.g:9198:1: rule__TerminalExpression__SymbolAssignment_8_1 : ( ( RULE_ID ) ) ;
    public final void rule__TerminalExpression__SymbolAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniJava.g:9202:1: ( ( ( RULE_ID ) ) )
            // InternalMiniJava.g:9203:2: ( ( RULE_ID ) )
            {
            // InternalMiniJava.g:9203:2: ( ( RULE_ID ) )
            // InternalMiniJava.g:9204:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSymbolSymbolCrossReference_8_1_0()); 
            }
            // InternalMiniJava.g:9205:3: ( RULE_ID )
            // InternalMiniJava.g:9206:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getSymbolSymbolIDTerminalRuleCall_8_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSymbolSymbolIDTerminalRuleCall_8_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getSymbolSymbolCrossReference_8_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__SymbolAssignment_8_1"

    // $ANTLR start synpred5_InternalMiniJava
    public final void synpred5_InternalMiniJava_fragment() throws RecognitionException {   
        // InternalMiniJava.g:1118:2: ( ( ( rule__Statement__Group_1__0 ) ) )
        // InternalMiniJava.g:1118:2: ( ( rule__Statement__Group_1__0 ) )
        {
        // InternalMiniJava.g:1118:2: ( ( rule__Statement__Group_1__0 ) )
        // InternalMiniJava.g:1119:3: ( rule__Statement__Group_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getStatementAccess().getGroup_1()); 
        }
        // InternalMiniJava.g:1120:3: ( rule__Statement__Group_1__0 )
        // InternalMiniJava.g:1120:4: rule__Statement__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__Statement__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalMiniJava

    // $ANTLR start synpred16_InternalMiniJava
    public final void synpred16_InternalMiniJava_fragment() throws RecognitionException {   
        // InternalMiniJava.g:1229:2: ( ( ( ruleParameter ) ) )
        // InternalMiniJava.g:1229:2: ( ( ruleParameter ) )
        {
        // InternalMiniJava.g:1229:2: ( ( ruleParameter ) )
        // InternalMiniJava.g:1230:3: ( ruleParameter )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getSymbolAccess().getParameterParserRuleCall_0()); 
        }
        // InternalMiniJava.g:1231:3: ( ruleParameter )
        // InternalMiniJava.g:1231:4: ruleParameter
        {
        pushFollow(FOLLOW_2);
        ruleParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalMiniJava

    // Delegated rules

    public final boolean synpred5_InternalMiniJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalMiniJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalMiniJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMiniJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\11\4\1\uffff\1\4\1\50\1\13\2\4\1\uffff";
    static final String dfa_3s = "\4\101\5\47\1\uffff\1\4\1\50\1\36\1\47\1\34\1\uffff";
    static final String dfa_4s = "\11\uffff\1\2\5\uffff\1\1";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\11\uffff\1\1\1\2\1\3\30\uffff\1\5\1\6\1\7\1\10\23\uffff\2\11",
            "\1\4\44\uffff\1\5\1\6\1\7\1\10\23\uffff\2\11",
            "\1\4\44\uffff\1\5\1\6\1\7\1\10\23\uffff\2\11",
            "\1\4\44\uffff\1\5\1\6\1\7\1\10\23\uffff\2\11",
            "\1\14\16\uffff\1\12\10\uffff\1\11\12\uffff\1\13",
            "\1\14\27\uffff\1\11\12\uffff\1\13",
            "\1\14\27\uffff\1\11\12\uffff\1\13",
            "\1\14\27\uffff\1\11\12\uffff\1\13",
            "\1\14\27\uffff\1\11\12\uffff\1\13",
            "",
            "\1\15",
            "\1\16",
            "\1\17\20\uffff\1\11\1\uffff\1\17",
            "\1\14\16\uffff\1\12\10\uffff\1\11\12\uffff\1\13",
            "\1\14\27\uffff\1\11",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1065:1: rule__Member__Alternatives : ( ( ruleField ) | ( ruleMethod ) );";
        }
    }
    static final String dfa_7s = "\30\uffff";
    static final String dfa_8s = "\1\4\4\uffff\11\0\12\uffff";
    static final String dfa_9s = "\1\77\4\uffff\11\0\12\uffff";
    static final String dfa_10s = "\1\uffff\1\1\1\2\17\uffff\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String dfa_11s = "\5\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\12\uffff}>";
    static final String[] dfa_12s = {
            "\1\15\1\5\1\6\5\uffff\1\7\1\10\10\uffff\1\26\5\uffff\1\2\2\uffff\1\25\2\uffff\1\1\1\22\1\uffff\1\23\1\24\2\uffff\4\2\12\uffff\1\2\3\uffff\1\2\1\11\1\12\1\13\1\14",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1107:1: rule__Statement__Alternatives : ( ( ( rule__Statement__Group_0__0 ) ) | ( ( rule__Statement__Group_1__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleForStatement ) | ( ( rule__Statement__Group_5__0 ) ) | ( ruleBlock ) | ( ( rule__Statement__Group_7__0 ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_8 = input.LA(1);

                         
                        int index4_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_9 = input.LA(1);

                         
                        int index4_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_10 = input.LA(1);

                         
                        int index4_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_11 = input.LA(1);

                         
                        int index4_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_12 = input.LA(1);

                         
                        int index4_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMiniJava()) ) {s = 2;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\15\uffff";
    static final String dfa_14s = "\11\uffff\1\14\3\uffff";
    static final String dfa_15s = "\6\4\1\uffff\1\4\1\50\1\13\2\4\1\uffff";
    static final String dfa_16s = "\1\101\5\47\1\uffff\1\4\1\50\1\36\1\47\1\34\1\uffff";
    static final String dfa_17s = "\6\uffff\1\2\5\uffff\1\1";
    static final String dfa_18s = "\15\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\11\uffff\3\6\30\uffff\1\2\1\3\1\4\1\5\23\uffff\2\6",
            "\1\11\16\uffff\1\7\10\uffff\1\6\12\uffff\1\10",
            "\1\11\27\uffff\1\6\12\uffff\1\10",
            "\1\11\27\uffff\1\6\12\uffff\1\10",
            "\1\11\27\uffff\1\6\12\uffff\1\10",
            "\1\11\27\uffff\1\6\12\uffff\1\10",
            "",
            "\1\12",
            "\1\13",
            "\1\6\20\uffff\1\6\1\uffff\1\6",
            "\1\11\16\uffff\1\7\10\uffff\1\6\12\uffff\1\10",
            "\1\11\27\uffff\1\6",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1203:1: rule__TypedDeclaration__Alternatives : ( ( ruleSymbol ) | ( ruleMember ) );";
        }
    }
    static final String dfa_20s = "\7\4\1\50\1\0\2\4\2\uffff";
    static final String dfa_21s = "\1\54\5\47\1\4\1\50\1\0\1\47\1\4\2\uffff";
    static final String dfa_22s = "\13\uffff\1\1\1\2";
    static final String dfa_23s = "\10\uffff\1\0\4\uffff}>";
    static final String[] dfa_24s = {
            "\1\1\44\uffff\1\2\1\3\1\4\1\5",
            "\1\10\16\uffff\1\6\23\uffff\1\7",
            "\1\10\42\uffff\1\7",
            "\1\10\42\uffff\1\7",
            "\1\10\42\uffff\1\7",
            "\1\10\42\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\uffff",
            "\1\10\16\uffff\1\6\23\uffff\1\7",
            "\1\10",
            "",
            ""
    };
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "1224:1: rule__Symbol__Alternatives : ( ( ( ruleParameter ) ) | ( ruleVariableDeclaration ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_8 = input.LA(1);

                         
                        int index7_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalMiniJava()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index7_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_25s = "\7\uffff";
    static final String dfa_26s = "\2\uffff\1\1\3\uffff\1\1";
    static final String dfa_27s = "\1\4\1\uffff\1\4\1\uffff\3\4";
    static final String dfa_28s = "\1\77\1\uffff\1\47\1\uffff\1\72\1\77\1\47";
    static final String dfa_29s = "\1\uffff\1\1\1\uffff\1\2\3\uffff";
    static final String dfa_30s = "\7\uffff}>";
    static final String[] dfa_31s = {
            "\1\2\2\1\5\uffff\2\1\16\uffff\1\1\14\uffff\4\3\12\uffff\1\1\3\uffff\5\1",
            "",
            "\1\3\16\uffff\1\4\12\uffff\1\1\10\uffff\1\5",
            "",
            "\1\6\65\uffff\1\1",
            "\3\1\5\uffff\2\1\16\uffff\1\1\13\uffff\1\3\16\uffff\1\1\3\uffff\5\1",
            "\1\3\16\uffff\1\4\10\uffff\1\1\1\uffff\1\1\10\uffff\1\5"
    };

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_25;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "1245:1: rule__Assignee__Alternatives : ( ( ( ruleArrayAccess ) ) | ( ruleVariableDeclaration ) );";
        }
    }
    static final String dfa_32s = "\14\uffff";
    static final String dfa_33s = "\1\4\6\uffff\1\4\1\uffff\1\23\2\uffff";
    static final String dfa_34s = "\1\77\6\uffff\1\54\1\uffff\1\47\2\uffff";
    static final String dfa_35s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\uffff\1\10\1\7";
    static final String dfa_36s = "\14\uffff}>";
    static final String[] dfa_37s = {
            "\1\10\1\1\1\2\5\uffff\2\3\56\uffff\1\4\1\5\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\44\uffff\4\12",
            "",
            "\1\12\10\uffff\1\13\12\uffff\1\12",
            "",
            ""
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "1416:1: rule__TerminalExpression__Alternatives : ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__Group_1__0 ) ) | ( ( rule__TerminalExpression__Group_2__0 ) ) | ( ( rule__TerminalExpression__Group_3__0 ) ) | ( ( rule__TerminalExpression__Group_4__0 ) ) | ( ( rule__TerminalExpression__Group_5__0 ) ) | ( ( rule__TerminalExpression__Group_6__0 ) ) | ( ( rule__TerminalExpression__Group_7__0 ) ) | ( ( rule__TerminalExpression__Group_8__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000825C000L,0x0000000000000001L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000821C002L,0x0000000000000001L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000021C000L,0x0000000000000001L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00001E000081C010L,0x0000000000000003L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00001E000001C012L,0x0000000000000003L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000821C000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00001E000001C010L,0x0000000000000003L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00001E002001C010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00001E000001C010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000800L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xF880000010003070L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xF8801E6C90C1F070L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xF8801E6C9041F072L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0xF8801E001001F070L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x001E000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x001E000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0xF880000030003070L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000000L});

}