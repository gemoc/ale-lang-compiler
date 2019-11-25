package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'File'", "'{'", "'commands'", "','", "'}'", "'Def'", "'expr'", "'App'", "'lhs'", "'rhs'", "'Var'", "'This'", "'value'", "'Bool'", "'Int'", "'Skip'", "'Project'", "'exp'", "'BObject'", "'fields'", "'Copy'", "'copy'", "'With'", "'Not'", "'If'", "'cond'", "'then'", "'els'", "'Let'", "'Fun'", "'body'", "'Assign'", "'ArithOpPlus'", "'ArithOpMinus'", "'ArithOpTimes'", "'ArithOpDivide'", "'ArithOpRemainder'", "'BoolOpAnd'", "'BoolOpOr'", "'Seq'", "'CmpOpEqual'", "'CmpOpUnequal'", "'CmpOpLess'", "'-'", "'Field'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=5;
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
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
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


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "File";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleFile"
    // InternalMyDsl.g:64:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalMyDsl.g:64:45: (iv_ruleFile= ruleFile EOF )
            // InternalMyDsl.g:65:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalMyDsl.g:71:1: ruleFile returns [EObject current=null] : ( () otherlv_1= 'File' otherlv_2= '{' (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_commands_5_0 = null;

        EObject lv_commands_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( ( () otherlv_1= 'File' otherlv_2= '{' (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:78:2: ( () otherlv_1= 'File' otherlv_2= '{' (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:78:2: ( () otherlv_1= 'File' otherlv_2= '{' (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:79:3: () otherlv_1= 'File' otherlv_2= '{' (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:79:3: ()
            // InternalMyDsl.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFileAccess().getFileAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFileAccess().getFileKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getFileAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:94:3: (otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:95:4: otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleTopLevelCmd ) ) (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getFileAccess().getCommandsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getFileAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:103:4: ( (lv_commands_5_0= ruleTopLevelCmd ) )
                    // InternalMyDsl.g:104:5: (lv_commands_5_0= ruleTopLevelCmd )
                    {
                    // InternalMyDsl.g:104:5: (lv_commands_5_0= ruleTopLevelCmd )
                    // InternalMyDsl.g:105:6: lv_commands_5_0= ruleTopLevelCmd
                    {

                    						newCompositeNode(grammarAccess.getFileAccess().getCommandsTopLevelCmdParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_commands_5_0=ruleTopLevelCmd();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFileRule());
                    						}
                    						add(
                    							current,
                    							"commands",
                    							lv_commands_5_0,
                    							"org.xtext.example.mydsl.MyDsl.TopLevelCmd");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:122:4: (otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalMyDsl.g:123:5: otherlv_6= ',' ( (lv_commands_7_0= ruleTopLevelCmd ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_5); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getFileAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:127:5: ( (lv_commands_7_0= ruleTopLevelCmd ) )
                    	    // InternalMyDsl.g:128:6: (lv_commands_7_0= ruleTopLevelCmd )
                    	    {
                    	    // InternalMyDsl.g:128:6: (lv_commands_7_0= ruleTopLevelCmd )
                    	    // InternalMyDsl.g:129:7: lv_commands_7_0= ruleTopLevelCmd
                    	    {

                    	    							newCompositeNode(grammarAccess.getFileAccess().getCommandsTopLevelCmdParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_6);
                    	    lv_commands_7_0=ruleTopLevelCmd();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFileRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"commands",
                    	    								lv_commands_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.TopLevelCmd");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getFileAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFileAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleTopLevelCmd"
    // InternalMyDsl.g:160:1: entryRuleTopLevelCmd returns [EObject current=null] : iv_ruleTopLevelCmd= ruleTopLevelCmd EOF ;
    public final EObject entryRuleTopLevelCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelCmd = null;


        try {
            // InternalMyDsl.g:160:52: (iv_ruleTopLevelCmd= ruleTopLevelCmd EOF )
            // InternalMyDsl.g:161:2: iv_ruleTopLevelCmd= ruleTopLevelCmd EOF
            {
             newCompositeNode(grammarAccess.getTopLevelCmdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopLevelCmd=ruleTopLevelCmd();

            state._fsp--;

             current =iv_ruleTopLevelCmd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelCmd"


    // $ANTLR start "ruleTopLevelCmd"
    // InternalMyDsl.g:167:1: ruleTopLevelCmd returns [EObject current=null] : (this_Def_0= ruleDef | this_App_1= ruleApp | this_Var_2= ruleVar | this_This_3= ruleThis | this_Bool_4= ruleBool | this_Int0_5= ruleInt0 | this_Skip_6= ruleSkip | this_Project_7= ruleProject | this_BObject_8= ruleBObject | this_Copy_9= ruleCopy | this_With_10= ruleWith | this_Not_11= ruleNot | this_If_12= ruleIf | this_Let_13= ruleLet | this_Fun_14= ruleFun | this_Assign_15= ruleAssign | this_ArithOpPlus_16= ruleArithOpPlus | this_ArithOpMinus_17= ruleArithOpMinus | this_ArithOpTimes_18= ruleArithOpTimes | this_ArithOpDivide_19= ruleArithOpDivide | this_ArithOpRemainder_20= ruleArithOpRemainder | this_BoolOpAnd_21= ruleBoolOpAnd | this_BoolOpOr_22= ruleBoolOpOr | this_Seq_23= ruleSeq | this_CmpOpEqual_24= ruleCmpOpEqual | this_CmpOpUnequal_25= ruleCmpOpUnequal | this_CmpOpLess_26= ruleCmpOpLess ) ;
    public final EObject ruleTopLevelCmd() throws RecognitionException {
        EObject current = null;

        EObject this_Def_0 = null;

        EObject this_App_1 = null;

        EObject this_Var_2 = null;

        EObject this_This_3 = null;

        EObject this_Bool_4 = null;

        EObject this_Int0_5 = null;

        EObject this_Skip_6 = null;

        EObject this_Project_7 = null;

        EObject this_BObject_8 = null;

        EObject this_Copy_9 = null;

        EObject this_With_10 = null;

        EObject this_Not_11 = null;

        EObject this_If_12 = null;

        EObject this_Let_13 = null;

        EObject this_Fun_14 = null;

        EObject this_Assign_15 = null;

        EObject this_ArithOpPlus_16 = null;

        EObject this_ArithOpMinus_17 = null;

        EObject this_ArithOpTimes_18 = null;

        EObject this_ArithOpDivide_19 = null;

        EObject this_ArithOpRemainder_20 = null;

        EObject this_BoolOpAnd_21 = null;

        EObject this_BoolOpOr_22 = null;

        EObject this_Seq_23 = null;

        EObject this_CmpOpEqual_24 = null;

        EObject this_CmpOpUnequal_25 = null;

        EObject this_CmpOpLess_26 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:173:2: ( (this_Def_0= ruleDef | this_App_1= ruleApp | this_Var_2= ruleVar | this_This_3= ruleThis | this_Bool_4= ruleBool | this_Int0_5= ruleInt0 | this_Skip_6= ruleSkip | this_Project_7= ruleProject | this_BObject_8= ruleBObject | this_Copy_9= ruleCopy | this_With_10= ruleWith | this_Not_11= ruleNot | this_If_12= ruleIf | this_Let_13= ruleLet | this_Fun_14= ruleFun | this_Assign_15= ruleAssign | this_ArithOpPlus_16= ruleArithOpPlus | this_ArithOpMinus_17= ruleArithOpMinus | this_ArithOpTimes_18= ruleArithOpTimes | this_ArithOpDivide_19= ruleArithOpDivide | this_ArithOpRemainder_20= ruleArithOpRemainder | this_BoolOpAnd_21= ruleBoolOpAnd | this_BoolOpOr_22= ruleBoolOpOr | this_Seq_23= ruleSeq | this_CmpOpEqual_24= ruleCmpOpEqual | this_CmpOpUnequal_25= ruleCmpOpUnequal | this_CmpOpLess_26= ruleCmpOpLess ) )
            // InternalMyDsl.g:174:2: (this_Def_0= ruleDef | this_App_1= ruleApp | this_Var_2= ruleVar | this_This_3= ruleThis | this_Bool_4= ruleBool | this_Int0_5= ruleInt0 | this_Skip_6= ruleSkip | this_Project_7= ruleProject | this_BObject_8= ruleBObject | this_Copy_9= ruleCopy | this_With_10= ruleWith | this_Not_11= ruleNot | this_If_12= ruleIf | this_Let_13= ruleLet | this_Fun_14= ruleFun | this_Assign_15= ruleAssign | this_ArithOpPlus_16= ruleArithOpPlus | this_ArithOpMinus_17= ruleArithOpMinus | this_ArithOpTimes_18= ruleArithOpTimes | this_ArithOpDivide_19= ruleArithOpDivide | this_ArithOpRemainder_20= ruleArithOpRemainder | this_BoolOpAnd_21= ruleBoolOpAnd | this_BoolOpOr_22= ruleBoolOpOr | this_Seq_23= ruleSeq | this_CmpOpEqual_24= ruleCmpOpEqual | this_CmpOpUnequal_25= ruleCmpOpUnequal | this_CmpOpLess_26= ruleCmpOpLess )
            {
            // InternalMyDsl.g:174:2: (this_Def_0= ruleDef | this_App_1= ruleApp | this_Var_2= ruleVar | this_This_3= ruleThis | this_Bool_4= ruleBool | this_Int0_5= ruleInt0 | this_Skip_6= ruleSkip | this_Project_7= ruleProject | this_BObject_8= ruleBObject | this_Copy_9= ruleCopy | this_With_10= ruleWith | this_Not_11= ruleNot | this_If_12= ruleIf | this_Let_13= ruleLet | this_Fun_14= ruleFun | this_Assign_15= ruleAssign | this_ArithOpPlus_16= ruleArithOpPlus | this_ArithOpMinus_17= ruleArithOpMinus | this_ArithOpTimes_18= ruleArithOpTimes | this_ArithOpDivide_19= ruleArithOpDivide | this_ArithOpRemainder_20= ruleArithOpRemainder | this_BoolOpAnd_21= ruleBoolOpAnd | this_BoolOpOr_22= ruleBoolOpOr | this_Seq_23= ruleSeq | this_CmpOpEqual_24= ruleCmpOpEqual | this_CmpOpUnequal_25= ruleCmpOpUnequal | this_CmpOpLess_26= ruleCmpOpLess )
            int alt3=27;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 21:
                {
                alt3=3;
                }
                break;
            case 22:
                {
                alt3=4;
                }
                break;
            case 23:
            case 24:
                {
                alt3=5;
                }
                break;
            case 25:
                {
                alt3=6;
                }
                break;
            case 26:
                {
                alt3=7;
                }
                break;
            case 27:
                {
                alt3=8;
                }
                break;
            case 29:
                {
                alt3=9;
                }
                break;
            case 31:
                {
                alt3=10;
                }
                break;
            case 33:
                {
                alt3=11;
                }
                break;
            case 34:
                {
                alt3=12;
                }
                break;
            case 35:
                {
                alt3=13;
                }
                break;
            case 39:
                {
                alt3=14;
                }
                break;
            case 40:
                {
                alt3=15;
                }
                break;
            case 42:
                {
                alt3=16;
                }
                break;
            case 43:
                {
                alt3=17;
                }
                break;
            case 44:
                {
                alt3=18;
                }
                break;
            case 45:
                {
                alt3=19;
                }
                break;
            case 46:
                {
                alt3=20;
                }
                break;
            case 47:
                {
                alt3=21;
                }
                break;
            case 48:
                {
                alt3=22;
                }
                break;
            case 49:
                {
                alt3=23;
                }
                break;
            case 50:
                {
                alt3=24;
                }
                break;
            case 51:
                {
                alt3=25;
                }
                break;
            case 52:
                {
                alt3=26;
                }
                break;
            case 53:
                {
                alt3=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:175:3: this_Def_0= ruleDef
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Def_0=ruleDef();

                    state._fsp--;


                    			current = this_Def_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:184:3: this_App_1= ruleApp
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getAppParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_App_1=ruleApp();

                    state._fsp--;


                    			current = this_App_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:193:3: this_Var_2= ruleVar
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getVarParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Var_2=ruleVar();

                    state._fsp--;


                    			current = this_Var_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:202:3: this_This_3= ruleThis
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getThisParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_This_3=ruleThis();

                    state._fsp--;


                    			current = this_This_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:211:3: this_Bool_4= ruleBool
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getBoolParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Bool_4=ruleBool();

                    state._fsp--;


                    			current = this_Bool_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:220:3: this_Int0_5= ruleInt0
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getInt0ParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Int0_5=ruleInt0();

                    state._fsp--;


                    			current = this_Int0_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:229:3: this_Skip_6= ruleSkip
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getSkipParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Skip_6=ruleSkip();

                    state._fsp--;


                    			current = this_Skip_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:238:3: this_Project_7= ruleProject
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getProjectParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Project_7=ruleProject();

                    state._fsp--;


                    			current = this_Project_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:247:3: this_BObject_8= ruleBObject
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getBObjectParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_BObject_8=ruleBObject();

                    state._fsp--;


                    			current = this_BObject_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:256:3: this_Copy_9= ruleCopy
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getCopyParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Copy_9=ruleCopy();

                    state._fsp--;


                    			current = this_Copy_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:265:3: this_With_10= ruleWith
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getWithParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_With_10=ruleWith();

                    state._fsp--;


                    			current = this_With_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:274:3: this_Not_11= ruleNot
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getNotParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_Not_11=ruleNot();

                    state._fsp--;


                    			current = this_Not_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:283:3: this_If_12= ruleIf
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getIfParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_If_12=ruleIf();

                    state._fsp--;


                    			current = this_If_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalMyDsl.g:292:3: this_Let_13= ruleLet
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getLetParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_Let_13=ruleLet();

                    state._fsp--;


                    			current = this_Let_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalMyDsl.g:301:3: this_Fun_14= ruleFun
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getFunParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_Fun_14=ruleFun();

                    state._fsp--;


                    			current = this_Fun_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalMyDsl.g:310:3: this_Assign_15= ruleAssign
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getAssignParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assign_15=ruleAssign();

                    state._fsp--;


                    			current = this_Assign_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalMyDsl.g:319:3: this_ArithOpPlus_16= ruleArithOpPlus
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getArithOpPlusParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpPlus_16=ruleArithOpPlus();

                    state._fsp--;


                    			current = this_ArithOpPlus_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalMyDsl.g:328:3: this_ArithOpMinus_17= ruleArithOpMinus
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getArithOpMinusParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpMinus_17=ruleArithOpMinus();

                    state._fsp--;


                    			current = this_ArithOpMinus_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 19 :
                    // InternalMyDsl.g:337:3: this_ArithOpTimes_18= ruleArithOpTimes
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getArithOpTimesParserRuleCall_18());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpTimes_18=ruleArithOpTimes();

                    state._fsp--;


                    			current = this_ArithOpTimes_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 20 :
                    // InternalMyDsl.g:346:3: this_ArithOpDivide_19= ruleArithOpDivide
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getArithOpDivideParserRuleCall_19());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpDivide_19=ruleArithOpDivide();

                    state._fsp--;


                    			current = this_ArithOpDivide_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 21 :
                    // InternalMyDsl.g:355:3: this_ArithOpRemainder_20= ruleArithOpRemainder
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getArithOpRemainderParserRuleCall_20());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpRemainder_20=ruleArithOpRemainder();

                    state._fsp--;


                    			current = this_ArithOpRemainder_20;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 22 :
                    // InternalMyDsl.g:364:3: this_BoolOpAnd_21= ruleBoolOpAnd
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getBoolOpAndParserRuleCall_21());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolOpAnd_21=ruleBoolOpAnd();

                    state._fsp--;


                    			current = this_BoolOpAnd_21;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 23 :
                    // InternalMyDsl.g:373:3: this_BoolOpOr_22= ruleBoolOpOr
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getBoolOpOrParserRuleCall_22());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolOpOr_22=ruleBoolOpOr();

                    state._fsp--;


                    			current = this_BoolOpOr_22;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 24 :
                    // InternalMyDsl.g:382:3: this_Seq_23= ruleSeq
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getSeqParserRuleCall_23());
                    		
                    pushFollow(FOLLOW_2);
                    this_Seq_23=ruleSeq();

                    state._fsp--;


                    			current = this_Seq_23;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 25 :
                    // InternalMyDsl.g:391:3: this_CmpOpEqual_24= ruleCmpOpEqual
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getCmpOpEqualParserRuleCall_24());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpEqual_24=ruleCmpOpEqual();

                    state._fsp--;


                    			current = this_CmpOpEqual_24;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 26 :
                    // InternalMyDsl.g:400:3: this_CmpOpUnequal_25= ruleCmpOpUnequal
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getCmpOpUnequalParserRuleCall_25());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpUnequal_25=ruleCmpOpUnequal();

                    state._fsp--;


                    			current = this_CmpOpUnequal_25;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 27 :
                    // InternalMyDsl.g:409:3: this_CmpOpLess_26= ruleCmpOpLess
                    {

                    			newCompositeNode(grammarAccess.getTopLevelCmdAccess().getCmpOpLessParserRuleCall_26());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpLess_26=ruleCmpOpLess();

                    state._fsp--;


                    			current = this_CmpOpLess_26;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelCmd"


    // $ANTLR start "entryRuleExpr"
    // InternalMyDsl.g:421:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalMyDsl.g:421:45: (iv_ruleExpr= ruleExpr EOF )
            // InternalMyDsl.g:422:2: iv_ruleExpr= ruleExpr EOF
            {
             newCompositeNode(grammarAccess.getExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpr=ruleExpr();

            state._fsp--;

             current =iv_ruleExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // InternalMyDsl.g:428:1: ruleExpr returns [EObject current=null] : (this_App_0= ruleApp | this_Var_1= ruleVar | this_This_2= ruleThis | this_Bool_3= ruleBool | this_Int0_4= ruleInt0 | this_Skip_5= ruleSkip | this_Project_6= ruleProject | this_BObject_7= ruleBObject | this_Copy_8= ruleCopy | this_With_9= ruleWith | this_Not_10= ruleNot | this_If_11= ruleIf | this_Let_12= ruleLet | this_Fun_13= ruleFun | this_Assign_14= ruleAssign | this_ArithOpPlus_15= ruleArithOpPlus | this_ArithOpMinus_16= ruleArithOpMinus | this_ArithOpTimes_17= ruleArithOpTimes | this_ArithOpDivide_18= ruleArithOpDivide | this_ArithOpRemainder_19= ruleArithOpRemainder | this_BoolOpAnd_20= ruleBoolOpAnd | this_BoolOpOr_21= ruleBoolOpOr | this_Seq_22= ruleSeq | this_CmpOpEqual_23= ruleCmpOpEqual | this_CmpOpUnequal_24= ruleCmpOpUnequal | this_CmpOpLess_25= ruleCmpOpLess ) ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_App_0 = null;

        EObject this_Var_1 = null;

        EObject this_This_2 = null;

        EObject this_Bool_3 = null;

        EObject this_Int0_4 = null;

        EObject this_Skip_5 = null;

        EObject this_Project_6 = null;

        EObject this_BObject_7 = null;

        EObject this_Copy_8 = null;

        EObject this_With_9 = null;

        EObject this_Not_10 = null;

        EObject this_If_11 = null;

        EObject this_Let_12 = null;

        EObject this_Fun_13 = null;

        EObject this_Assign_14 = null;

        EObject this_ArithOpPlus_15 = null;

        EObject this_ArithOpMinus_16 = null;

        EObject this_ArithOpTimes_17 = null;

        EObject this_ArithOpDivide_18 = null;

        EObject this_ArithOpRemainder_19 = null;

        EObject this_BoolOpAnd_20 = null;

        EObject this_BoolOpOr_21 = null;

        EObject this_Seq_22 = null;

        EObject this_CmpOpEqual_23 = null;

        EObject this_CmpOpUnequal_24 = null;

        EObject this_CmpOpLess_25 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:434:2: ( (this_App_0= ruleApp | this_Var_1= ruleVar | this_This_2= ruleThis | this_Bool_3= ruleBool | this_Int0_4= ruleInt0 | this_Skip_5= ruleSkip | this_Project_6= ruleProject | this_BObject_7= ruleBObject | this_Copy_8= ruleCopy | this_With_9= ruleWith | this_Not_10= ruleNot | this_If_11= ruleIf | this_Let_12= ruleLet | this_Fun_13= ruleFun | this_Assign_14= ruleAssign | this_ArithOpPlus_15= ruleArithOpPlus | this_ArithOpMinus_16= ruleArithOpMinus | this_ArithOpTimes_17= ruleArithOpTimes | this_ArithOpDivide_18= ruleArithOpDivide | this_ArithOpRemainder_19= ruleArithOpRemainder | this_BoolOpAnd_20= ruleBoolOpAnd | this_BoolOpOr_21= ruleBoolOpOr | this_Seq_22= ruleSeq | this_CmpOpEqual_23= ruleCmpOpEqual | this_CmpOpUnequal_24= ruleCmpOpUnequal | this_CmpOpLess_25= ruleCmpOpLess ) )
            // InternalMyDsl.g:435:2: (this_App_0= ruleApp | this_Var_1= ruleVar | this_This_2= ruleThis | this_Bool_3= ruleBool | this_Int0_4= ruleInt0 | this_Skip_5= ruleSkip | this_Project_6= ruleProject | this_BObject_7= ruleBObject | this_Copy_8= ruleCopy | this_With_9= ruleWith | this_Not_10= ruleNot | this_If_11= ruleIf | this_Let_12= ruleLet | this_Fun_13= ruleFun | this_Assign_14= ruleAssign | this_ArithOpPlus_15= ruleArithOpPlus | this_ArithOpMinus_16= ruleArithOpMinus | this_ArithOpTimes_17= ruleArithOpTimes | this_ArithOpDivide_18= ruleArithOpDivide | this_ArithOpRemainder_19= ruleArithOpRemainder | this_BoolOpAnd_20= ruleBoolOpAnd | this_BoolOpOr_21= ruleBoolOpOr | this_Seq_22= ruleSeq | this_CmpOpEqual_23= ruleCmpOpEqual | this_CmpOpUnequal_24= ruleCmpOpUnequal | this_CmpOpLess_25= ruleCmpOpLess )
            {
            // InternalMyDsl.g:435:2: (this_App_0= ruleApp | this_Var_1= ruleVar | this_This_2= ruleThis | this_Bool_3= ruleBool | this_Int0_4= ruleInt0 | this_Skip_5= ruleSkip | this_Project_6= ruleProject | this_BObject_7= ruleBObject | this_Copy_8= ruleCopy | this_With_9= ruleWith | this_Not_10= ruleNot | this_If_11= ruleIf | this_Let_12= ruleLet | this_Fun_13= ruleFun | this_Assign_14= ruleAssign | this_ArithOpPlus_15= ruleArithOpPlus | this_ArithOpMinus_16= ruleArithOpMinus | this_ArithOpTimes_17= ruleArithOpTimes | this_ArithOpDivide_18= ruleArithOpDivide | this_ArithOpRemainder_19= ruleArithOpRemainder | this_BoolOpAnd_20= ruleBoolOpAnd | this_BoolOpOr_21= ruleBoolOpOr | this_Seq_22= ruleSeq | this_CmpOpEqual_23= ruleCmpOpEqual | this_CmpOpUnequal_24= ruleCmpOpUnequal | this_CmpOpLess_25= ruleCmpOpLess )
            int alt4=26;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case 22:
                {
                alt4=3;
                }
                break;
            case 23:
            case 24:
                {
                alt4=4;
                }
                break;
            case 25:
                {
                alt4=5;
                }
                break;
            case 26:
                {
                alt4=6;
                }
                break;
            case 27:
                {
                alt4=7;
                }
                break;
            case 29:
                {
                alt4=8;
                }
                break;
            case 31:
                {
                alt4=9;
                }
                break;
            case 33:
                {
                alt4=10;
                }
                break;
            case 34:
                {
                alt4=11;
                }
                break;
            case 35:
                {
                alt4=12;
                }
                break;
            case 39:
                {
                alt4=13;
                }
                break;
            case 40:
                {
                alt4=14;
                }
                break;
            case 42:
                {
                alt4=15;
                }
                break;
            case 43:
                {
                alt4=16;
                }
                break;
            case 44:
                {
                alt4=17;
                }
                break;
            case 45:
                {
                alt4=18;
                }
                break;
            case 46:
                {
                alt4=19;
                }
                break;
            case 47:
                {
                alt4=20;
                }
                break;
            case 48:
                {
                alt4=21;
                }
                break;
            case 49:
                {
                alt4=22;
                }
                break;
            case 50:
                {
                alt4=23;
                }
                break;
            case 51:
                {
                alt4=24;
                }
                break;
            case 52:
                {
                alt4=25;
                }
                break;
            case 53:
                {
                alt4=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:436:3: this_App_0= ruleApp
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getAppParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_App_0=ruleApp();

                    state._fsp--;


                    			current = this_App_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:445:3: this_Var_1= ruleVar
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getVarParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Var_1=ruleVar();

                    state._fsp--;


                    			current = this_Var_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:454:3: this_This_2= ruleThis
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getThisParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_This_2=ruleThis();

                    state._fsp--;


                    			current = this_This_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:463:3: this_Bool_3= ruleBool
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getBoolParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Bool_3=ruleBool();

                    state._fsp--;


                    			current = this_Bool_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:472:3: this_Int0_4= ruleInt0
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getInt0ParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Int0_4=ruleInt0();

                    state._fsp--;


                    			current = this_Int0_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:481:3: this_Skip_5= ruleSkip
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getSkipParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Skip_5=ruleSkip();

                    state._fsp--;


                    			current = this_Skip_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:490:3: this_Project_6= ruleProject
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getProjectParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Project_6=ruleProject();

                    state._fsp--;


                    			current = this_Project_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:499:3: this_BObject_7= ruleBObject
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getBObjectParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_BObject_7=ruleBObject();

                    state._fsp--;


                    			current = this_BObject_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:508:3: this_Copy_8= ruleCopy
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getCopyParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Copy_8=ruleCopy();

                    state._fsp--;


                    			current = this_Copy_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:517:3: this_With_9= ruleWith
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getWithParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_With_9=ruleWith();

                    state._fsp--;


                    			current = this_With_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:526:3: this_Not_10= ruleNot
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getNotParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_Not_10=ruleNot();

                    state._fsp--;


                    			current = this_Not_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:535:3: this_If_11= ruleIf
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getIfParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_If_11=ruleIf();

                    state._fsp--;


                    			current = this_If_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:544:3: this_Let_12= ruleLet
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getLetParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_Let_12=ruleLet();

                    state._fsp--;


                    			current = this_Let_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalMyDsl.g:553:3: this_Fun_13= ruleFun
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getFunParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_Fun_13=ruleFun();

                    state._fsp--;


                    			current = this_Fun_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalMyDsl.g:562:3: this_Assign_14= ruleAssign
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getAssignParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assign_14=ruleAssign();

                    state._fsp--;


                    			current = this_Assign_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalMyDsl.g:571:3: this_ArithOpPlus_15= ruleArithOpPlus
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getArithOpPlusParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpPlus_15=ruleArithOpPlus();

                    state._fsp--;


                    			current = this_ArithOpPlus_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalMyDsl.g:580:3: this_ArithOpMinus_16= ruleArithOpMinus
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getArithOpMinusParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpMinus_16=ruleArithOpMinus();

                    state._fsp--;


                    			current = this_ArithOpMinus_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalMyDsl.g:589:3: this_ArithOpTimes_17= ruleArithOpTimes
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getArithOpTimesParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpTimes_17=ruleArithOpTimes();

                    state._fsp--;


                    			current = this_ArithOpTimes_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 19 :
                    // InternalMyDsl.g:598:3: this_ArithOpDivide_18= ruleArithOpDivide
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getArithOpDivideParserRuleCall_18());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpDivide_18=ruleArithOpDivide();

                    state._fsp--;


                    			current = this_ArithOpDivide_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 20 :
                    // InternalMyDsl.g:607:3: this_ArithOpRemainder_19= ruleArithOpRemainder
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getArithOpRemainderParserRuleCall_19());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithOpRemainder_19=ruleArithOpRemainder();

                    state._fsp--;


                    			current = this_ArithOpRemainder_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 21 :
                    // InternalMyDsl.g:616:3: this_BoolOpAnd_20= ruleBoolOpAnd
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getBoolOpAndParserRuleCall_20());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolOpAnd_20=ruleBoolOpAnd();

                    state._fsp--;


                    			current = this_BoolOpAnd_20;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 22 :
                    // InternalMyDsl.g:625:3: this_BoolOpOr_21= ruleBoolOpOr
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getBoolOpOrParserRuleCall_21());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolOpOr_21=ruleBoolOpOr();

                    state._fsp--;


                    			current = this_BoolOpOr_21;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 23 :
                    // InternalMyDsl.g:634:3: this_Seq_22= ruleSeq
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getSeqParserRuleCall_22());
                    		
                    pushFollow(FOLLOW_2);
                    this_Seq_22=ruleSeq();

                    state._fsp--;


                    			current = this_Seq_22;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 24 :
                    // InternalMyDsl.g:643:3: this_CmpOpEqual_23= ruleCmpOpEqual
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getCmpOpEqualParserRuleCall_23());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpEqual_23=ruleCmpOpEqual();

                    state._fsp--;


                    			current = this_CmpOpEqual_23;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 25 :
                    // InternalMyDsl.g:652:3: this_CmpOpUnequal_24= ruleCmpOpUnequal
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getCmpOpUnequalParserRuleCall_24());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpUnequal_24=ruleCmpOpUnequal();

                    state._fsp--;


                    			current = this_CmpOpUnequal_24;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 26 :
                    // InternalMyDsl.g:661:3: this_CmpOpLess_25= ruleCmpOpLess
                    {

                    			newCompositeNode(grammarAccess.getExprAccess().getCmpOpLessParserRuleCall_25());
                    		
                    pushFollow(FOLLOW_2);
                    this_CmpOpLess_25=ruleCmpOpLess();

                    state._fsp--;


                    			current = this_CmpOpLess_25;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleDef"
    // InternalMyDsl.g:673:1: entryRuleDef returns [EObject current=null] : iv_ruleDef= ruleDef EOF ;
    public final EObject entryRuleDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDef = null;


        try {
            // InternalMyDsl.g:673:44: (iv_ruleDef= ruleDef EOF )
            // InternalMyDsl.g:674:2: iv_ruleDef= ruleDef EOF
            {
             newCompositeNode(grammarAccess.getDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDef=ruleDef();

            state._fsp--;

             current =iv_ruleDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDef"


    // $ANTLR start "ruleDef"
    // InternalMyDsl.g:680:1: ruleDef returns [EObject current=null] : (otherlv_0= 'Def' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'expr' ( (lv_expr_4_0= ruleExpr ) ) otherlv_5= '}' ) ;
    public final EObject ruleDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_expr_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:686:2: ( (otherlv_0= 'Def' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'expr' ( (lv_expr_4_0= ruleExpr ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:687:2: (otherlv_0= 'Def' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'expr' ( (lv_expr_4_0= ruleExpr ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:687:2: (otherlv_0= 'Def' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'expr' ( (lv_expr_4_0= ruleExpr ) ) otherlv_5= '}' )
            // InternalMyDsl.g:688:3: otherlv_0= 'Def' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'expr' ( (lv_expr_4_0= ruleExpr ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefAccess().getDefKeyword_0());
            		
            // InternalMyDsl.g:692:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:693:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:693:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:694:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getDefAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getDefAccess().getExprKeyword_3());
            		
            // InternalMyDsl.g:719:3: ( (lv_expr_4_0= ruleExpr ) )
            // InternalMyDsl.g:720:4: (lv_expr_4_0= ruleExpr )
            {
            // InternalMyDsl.g:720:4: (lv_expr_4_0= ruleExpr )
            // InternalMyDsl.g:721:5: lv_expr_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getDefAccess().getExprExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_expr_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDefAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDef"


    // $ANTLR start "entryRuleApp"
    // InternalMyDsl.g:746:1: entryRuleApp returns [EObject current=null] : iv_ruleApp= ruleApp EOF ;
    public final EObject entryRuleApp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApp = null;


        try {
            // InternalMyDsl.g:746:44: (iv_ruleApp= ruleApp EOF )
            // InternalMyDsl.g:747:2: iv_ruleApp= ruleApp EOF
            {
             newCompositeNode(grammarAccess.getAppRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApp=ruleApp();

            state._fsp--;

             current =iv_ruleApp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApp"


    // $ANTLR start "ruleApp"
    // InternalMyDsl.g:753:1: ruleApp returns [EObject current=null] : (otherlv_0= 'App' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleApp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:759:2: ( (otherlv_0= 'App' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:760:2: (otherlv_0= 'App' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:760:2: (otherlv_0= 'App' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:761:3: otherlv_0= 'App' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAppAccess().getAppKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getAppAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getAppAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:773:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:774:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:774:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:775:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getAppAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getAppAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:796:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:797:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:797:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:798:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getAppAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getAppAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApp"


    // $ANTLR start "entryRuleVar"
    // InternalMyDsl.g:823:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalMyDsl.g:823:44: (iv_ruleVar= ruleVar EOF )
            // InternalMyDsl.g:824:2: iv_ruleVar= ruleVar EOF
            {
             newCompositeNode(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVar=ruleVar();

            state._fsp--;

             current =iv_ruleVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // InternalMyDsl.g:830:1: ruleVar returns [EObject current=null] : ( () otherlv_1= 'Var' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:836:2: ( ( () otherlv_1= 'Var' ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalMyDsl.g:837:2: ( () otherlv_1= 'Var' ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalMyDsl.g:837:2: ( () otherlv_1= 'Var' ( (lv_name_2_0= ruleEString ) ) )
            // InternalMyDsl.g:838:3: () otherlv_1= 'Var' ( (lv_name_2_0= ruleEString ) )
            {
            // InternalMyDsl.g:838:3: ()
            // InternalMyDsl.g:839:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVarAccess().getVarAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getVarAccess().getVarKeyword_1());
            		
            // InternalMyDsl.g:849:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:850:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:850:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:851:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getVarAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleThis"
    // InternalMyDsl.g:872:1: entryRuleThis returns [EObject current=null] : iv_ruleThis= ruleThis EOF ;
    public final EObject entryRuleThis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThis = null;


        try {
            // InternalMyDsl.g:872:45: (iv_ruleThis= ruleThis EOF )
            // InternalMyDsl.g:873:2: iv_ruleThis= ruleThis EOF
            {
             newCompositeNode(grammarAccess.getThisRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThis=ruleThis();

            state._fsp--;

             current =iv_ruleThis; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThis"


    // $ANTLR start "ruleThis"
    // InternalMyDsl.g:879:1: ruleThis returns [EObject current=null] : ( () otherlv_1= 'This' ) ;
    public final EObject ruleThis() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:885:2: ( ( () otherlv_1= 'This' ) )
            // InternalMyDsl.g:886:2: ( () otherlv_1= 'This' )
            {
            // InternalMyDsl.g:886:2: ( () otherlv_1= 'This' )
            // InternalMyDsl.g:887:3: () otherlv_1= 'This'
            {
            // InternalMyDsl.g:887:3: ()
            // InternalMyDsl.g:888:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getThisAccess().getThisAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getThisAccess().getThisKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThis"


    // $ANTLR start "entryRuleBool"
    // InternalMyDsl.g:902:1: entryRuleBool returns [EObject current=null] : iv_ruleBool= ruleBool EOF ;
    public final EObject entryRuleBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBool = null;


        try {
            // InternalMyDsl.g:902:45: (iv_ruleBool= ruleBool EOF )
            // InternalMyDsl.g:903:2: iv_ruleBool= ruleBool EOF
            {
             newCompositeNode(grammarAccess.getBoolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBool=ruleBool();

            state._fsp--;

             current =iv_ruleBool; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBool"


    // $ANTLR start "ruleBool"
    // InternalMyDsl.g:909:1: ruleBool returns [EObject current=null] : ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'Bool' ) ;
    public final EObject ruleBool() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:915:2: ( ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'Bool' ) )
            // InternalMyDsl.g:916:2: ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'Bool' )
            {
            // InternalMyDsl.g:916:2: ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'Bool' )
            // InternalMyDsl.g:917:3: () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'Bool'
            {
            // InternalMyDsl.g:917:3: ()
            // InternalMyDsl.g:918:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolAccess().getBoolAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:924:3: ( (lv_value_1_0= 'value' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:925:4: (lv_value_1_0= 'value' )
                    {
                    // InternalMyDsl.g:925:4: (lv_value_1_0= 'value' )
                    // InternalMyDsl.g:926:5: lv_value_1_0= 'value'
                    {
                    lv_value_1_0=(Token)match(input,23,FOLLOW_12); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getBoolAccess().getValueValueKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBoolRule());
                    					}
                    					setWithLastConsumed(current, "value", true, "value");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolAccess().getBoolKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBool"


    // $ANTLR start "entryRuleInt0"
    // InternalMyDsl.g:946:1: entryRuleInt0 returns [EObject current=null] : iv_ruleInt0= ruleInt0 EOF ;
    public final EObject entryRuleInt0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInt0 = null;


        try {
            // InternalMyDsl.g:946:45: (iv_ruleInt0= ruleInt0 EOF )
            // InternalMyDsl.g:947:2: iv_ruleInt0= ruleInt0 EOF
            {
             newCompositeNode(grammarAccess.getInt0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInt0=ruleInt0();

            state._fsp--;

             current =iv_ruleInt0; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInt0"


    // $ANTLR start "ruleInt0"
    // InternalMyDsl.g:953:1: ruleInt0 returns [EObject current=null] : ( () otherlv_1= 'Int' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleInt0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:959:2: ( ( () otherlv_1= 'Int' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:960:2: ( () otherlv_1= 'Int' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:960:2: ( () otherlv_1= 'Int' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:961:3: () otherlv_1= 'Int' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:961:3: ()
            // InternalMyDsl.g:962:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt0Access().getIntAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInt0Access().getIntKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getInt0Access().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:976:3: (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:977:4: otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_14); 

                    				newLeafNode(otherlv_3, grammarAccess.getInt0Access().getValueKeyword_3_0());
                    			
                    // InternalMyDsl.g:981:4: ( (lv_value_4_0= ruleEInt ) )
                    // InternalMyDsl.g:982:5: (lv_value_4_0= ruleEInt )
                    {
                    // InternalMyDsl.g:982:5: (lv_value_4_0= ruleEInt )
                    // InternalMyDsl.g:983:6: lv_value_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getInt0Access().getValueEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_value_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInt0Rule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getInt0Access().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInt0"


    // $ANTLR start "entryRuleSkip"
    // InternalMyDsl.g:1009:1: entryRuleSkip returns [EObject current=null] : iv_ruleSkip= ruleSkip EOF ;
    public final EObject entryRuleSkip() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSkip = null;


        try {
            // InternalMyDsl.g:1009:45: (iv_ruleSkip= ruleSkip EOF )
            // InternalMyDsl.g:1010:2: iv_ruleSkip= ruleSkip EOF
            {
             newCompositeNode(grammarAccess.getSkipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSkip=ruleSkip();

            state._fsp--;

             current =iv_ruleSkip; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSkip"


    // $ANTLR start "ruleSkip"
    // InternalMyDsl.g:1016:1: ruleSkip returns [EObject current=null] : ( () otherlv_1= 'Skip' ) ;
    public final EObject ruleSkip() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1022:2: ( ( () otherlv_1= 'Skip' ) )
            // InternalMyDsl.g:1023:2: ( () otherlv_1= 'Skip' )
            {
            // InternalMyDsl.g:1023:2: ( () otherlv_1= 'Skip' )
            // InternalMyDsl.g:1024:3: () otherlv_1= 'Skip'
            {
            // InternalMyDsl.g:1024:3: ()
            // InternalMyDsl.g:1025:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSkipAccess().getSkipAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSkipAccess().getSkipKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSkip"


    // $ANTLR start "entryRuleProject"
    // InternalMyDsl.g:1039:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalMyDsl.g:1039:48: (iv_ruleProject= ruleProject EOF )
            // InternalMyDsl.g:1040:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalMyDsl.g:1046:1: ruleProject returns [EObject current=null] : (otherlv_0= 'Project' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'exp' ( (lv_exp_4_0= ruleExpr ) ) otherlv_5= '}' ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exp_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1052:2: ( (otherlv_0= 'Project' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'exp' ( (lv_exp_4_0= ruleExpr ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:1053:2: (otherlv_0= 'Project' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'exp' ( (lv_exp_4_0= ruleExpr ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:1053:2: (otherlv_0= 'Project' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'exp' ( (lv_exp_4_0= ruleExpr ) ) otherlv_5= '}' )
            // InternalMyDsl.g:1054:3: otherlv_0= 'Project' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'exp' ( (lv_exp_4_0= ruleExpr ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
            		
            // InternalMyDsl.g:1058:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1059:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1059:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1060:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getProjectAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,28,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getExpKeyword_3());
            		
            // InternalMyDsl.g:1085:3: ( (lv_exp_4_0= ruleExpr ) )
            // InternalMyDsl.g:1086:4: (lv_exp_4_0= ruleExpr )
            {
            // InternalMyDsl.g:1086:4: (lv_exp_4_0= ruleExpr )
            // InternalMyDsl.g:1087:5: lv_exp_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getProjectAccess().getExpExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_exp_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleBObject"
    // InternalMyDsl.g:1112:1: entryRuleBObject returns [EObject current=null] : iv_ruleBObject= ruleBObject EOF ;
    public final EObject entryRuleBObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBObject = null;


        try {
            // InternalMyDsl.g:1112:48: (iv_ruleBObject= ruleBObject EOF )
            // InternalMyDsl.g:1113:2: iv_ruleBObject= ruleBObject EOF
            {
             newCompositeNode(grammarAccess.getBObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBObject=ruleBObject();

            state._fsp--;

             current =iv_ruleBObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBObject"


    // $ANTLR start "ruleBObject"
    // InternalMyDsl.g:1119:1: ruleBObject returns [EObject current=null] : ( () otherlv_1= 'BObject' otherlv_2= '{' (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleBObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_fields_5_0 = null;

        EObject lv_fields_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1125:2: ( ( () otherlv_1= 'BObject' otherlv_2= '{' (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:1126:2: ( () otherlv_1= 'BObject' otherlv_2= '{' (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:1126:2: ( () otherlv_1= 'BObject' otherlv_2= '{' (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:1127:3: () otherlv_1= 'BObject' otherlv_2= '{' (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:1127:3: ()
            // InternalMyDsl.g:1128:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBObjectAccess().getBObjectAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getBObjectAccess().getBObjectKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getBObjectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1142:3: (otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==30) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:1143:4: otherlv_3= 'fields' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) ) (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getBObjectAccess().getFieldsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_17); 

                    				newLeafNode(otherlv_4, grammarAccess.getBObjectAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:1151:4: ( (lv_fields_5_0= ruleField ) )
                    // InternalMyDsl.g:1152:5: (lv_fields_5_0= ruleField )
                    {
                    // InternalMyDsl.g:1152:5: (lv_fields_5_0= ruleField )
                    // InternalMyDsl.g:1153:6: lv_fields_5_0= ruleField
                    {

                    						newCompositeNode(grammarAccess.getBObjectAccess().getFieldsFieldParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_fields_5_0=ruleField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBObjectRule());
                    						}
                    						add(
                    							current,
                    							"fields",
                    							lv_fields_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Field");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1170:4: (otherlv_6= ',' ( (lv_fields_7_0= ruleField ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalMyDsl.g:1171:5: otherlv_6= ',' ( (lv_fields_7_0= ruleField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_17); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getBObjectAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:1175:5: ( (lv_fields_7_0= ruleField ) )
                    	    // InternalMyDsl.g:1176:6: (lv_fields_7_0= ruleField )
                    	    {
                    	    // InternalMyDsl.g:1176:6: (lv_fields_7_0= ruleField )
                    	    // InternalMyDsl.g:1177:7: lv_fields_7_0= ruleField
                    	    {

                    	    							newCompositeNode(grammarAccess.getBObjectAccess().getFieldsFieldParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_6);
                    	    lv_fields_7_0=ruleField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getBObjectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"fields",
                    	    								lv_fields_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Field");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getBObjectAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBObjectAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBObject"


    // $ANTLR start "entryRuleCopy"
    // InternalMyDsl.g:1208:1: entryRuleCopy returns [EObject current=null] : iv_ruleCopy= ruleCopy EOF ;
    public final EObject entryRuleCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCopy = null;


        try {
            // InternalMyDsl.g:1208:45: (iv_ruleCopy= ruleCopy EOF )
            // InternalMyDsl.g:1209:2: iv_ruleCopy= ruleCopy EOF
            {
             newCompositeNode(grammarAccess.getCopyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCopy=ruleCopy();

            state._fsp--;

             current =iv_ruleCopy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCopy"


    // $ANTLR start "ruleCopy"
    // InternalMyDsl.g:1215:1: ruleCopy returns [EObject current=null] : (otherlv_0= 'Copy' otherlv_1= '{' otherlv_2= 'copy' ( (lv_copy_3_0= ruleExpr ) ) otherlv_4= '}' ) ;
    public final EObject ruleCopy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_copy_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1221:2: ( (otherlv_0= 'Copy' otherlv_1= '{' otherlv_2= 'copy' ( (lv_copy_3_0= ruleExpr ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1222:2: (otherlv_0= 'Copy' otherlv_1= '{' otherlv_2= 'copy' ( (lv_copy_3_0= ruleExpr ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1222:2: (otherlv_0= 'Copy' otherlv_1= '{' otherlv_2= 'copy' ( (lv_copy_3_0= ruleExpr ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1223:3: otherlv_0= 'Copy' otherlv_1= '{' otherlv_2= 'copy' ( (lv_copy_3_0= ruleExpr ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCopyAccess().getCopyKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getCopyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getCopyAccess().getCopyKeyword_2());
            		
            // InternalMyDsl.g:1235:3: ( (lv_copy_3_0= ruleExpr ) )
            // InternalMyDsl.g:1236:4: (lv_copy_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1236:4: (lv_copy_3_0= ruleExpr )
            // InternalMyDsl.g:1237:5: lv_copy_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCopyAccess().getCopyExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_copy_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCopyRule());
            					}
            					set(
            						current,
            						"copy",
            						lv_copy_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCopyAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCopy"


    // $ANTLR start "entryRuleWith"
    // InternalMyDsl.g:1262:1: entryRuleWith returns [EObject current=null] : iv_ruleWith= ruleWith EOF ;
    public final EObject entryRuleWith() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWith = null;


        try {
            // InternalMyDsl.g:1262:45: (iv_ruleWith= ruleWith EOF )
            // InternalMyDsl.g:1263:2: iv_ruleWith= ruleWith EOF
            {
             newCompositeNode(grammarAccess.getWithRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWith=ruleWith();

            state._fsp--;

             current =iv_ruleWith; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWith"


    // $ANTLR start "ruleWith"
    // InternalMyDsl.g:1269:1: ruleWith returns [EObject current=null] : (otherlv_0= 'With' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleWith() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1275:2: ( (otherlv_0= 'With' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1276:2: (otherlv_0= 'With' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1276:2: (otherlv_0= 'With' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1277:3: otherlv_0= 'With' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWithAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getWithAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWithAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:1289:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:1290:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1290:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:1291:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getWithAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWithRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getWithAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:1312:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:1313:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:1313:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:1314:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getWithAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWithRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getWithAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWith"


    // $ANTLR start "entryRuleNot"
    // InternalMyDsl.g:1339:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalMyDsl.g:1339:44: (iv_ruleNot= ruleNot EOF )
            // InternalMyDsl.g:1340:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalMyDsl.g:1346:1: ruleNot returns [EObject current=null] : (otherlv_0= 'Not' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= ruleExpr ) ) otherlv_4= '}' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1352:2: ( (otherlv_0= 'Not' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= ruleExpr ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1353:2: (otherlv_0= 'Not' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= ruleExpr ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1353:2: (otherlv_0= 'Not' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= ruleExpr ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1354:3: otherlv_0= 'Not' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= ruleExpr ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNotAccess().getNotKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getNotAccess().getValueKeyword_2());
            		
            // InternalMyDsl.g:1366:3: ( (lv_value_3_0= ruleExpr ) )
            // InternalMyDsl.g:1367:4: (lv_value_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1367:4: (lv_value_3_0= ruleExpr )
            // InternalMyDsl.g:1368:5: lv_value_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getNotAccess().getValueExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_value_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getNotAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleIf"
    // InternalMyDsl.g:1393:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalMyDsl.g:1393:43: (iv_ruleIf= ruleIf EOF )
            // InternalMyDsl.g:1394:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalMyDsl.g:1400:1: ruleIf returns [EObject current=null] : (otherlv_0= 'If' otherlv_1= '{' otherlv_2= 'cond' ( (lv_cond_3_0= ruleExpr ) ) otherlv_4= 'then' ( (lv_thn_5_0= ruleExpr ) ) otherlv_6= 'els' ( (lv_els_7_0= ruleExpr ) ) otherlv_8= '}' ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_cond_3_0 = null;

        EObject lv_thn_5_0 = null;

        EObject lv_els_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1406:2: ( (otherlv_0= 'If' otherlv_1= '{' otherlv_2= 'cond' ( (lv_cond_3_0= ruleExpr ) ) otherlv_4= 'then' ( (lv_thn_5_0= ruleExpr ) ) otherlv_6= 'els' ( (lv_els_7_0= ruleExpr ) ) otherlv_8= '}' ) )
            // InternalMyDsl.g:1407:2: (otherlv_0= 'If' otherlv_1= '{' otherlv_2= 'cond' ( (lv_cond_3_0= ruleExpr ) ) otherlv_4= 'then' ( (lv_thn_5_0= ruleExpr ) ) otherlv_6= 'els' ( (lv_els_7_0= ruleExpr ) ) otherlv_8= '}' )
            {
            // InternalMyDsl.g:1407:2: (otherlv_0= 'If' otherlv_1= '{' otherlv_2= 'cond' ( (lv_cond_3_0= ruleExpr ) ) otherlv_4= 'then' ( (lv_thn_5_0= ruleExpr ) ) otherlv_6= 'els' ( (lv_els_7_0= ruleExpr ) ) otherlv_8= '}' )
            // InternalMyDsl.g:1408:3: otherlv_0= 'If' otherlv_1= '{' otherlv_2= 'cond' ( (lv_cond_3_0= ruleExpr ) ) otherlv_4= 'then' ( (lv_thn_5_0= ruleExpr ) ) otherlv_6= 'els' ( (lv_els_7_0= ruleExpr ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getIfAccess().getIfKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getIfAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIfAccess().getCondKeyword_2());
            		
            // InternalMyDsl.g:1420:3: ( (lv_cond_3_0= ruleExpr ) )
            // InternalMyDsl.g:1421:4: (lv_cond_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1421:4: (lv_cond_3_0= ruleExpr )
            // InternalMyDsl.g:1422:5: lv_cond_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getIfAccess().getCondExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_21);
            lv_cond_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfRule());
            					}
            					set(
            						current,
            						"cond",
            						lv_cond_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,37,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getIfAccess().getThenKeyword_4());
            		
            // InternalMyDsl.g:1443:3: ( (lv_thn_5_0= ruleExpr ) )
            // InternalMyDsl.g:1444:4: (lv_thn_5_0= ruleExpr )
            {
            // InternalMyDsl.g:1444:4: (lv_thn_5_0= ruleExpr )
            // InternalMyDsl.g:1445:5: lv_thn_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getIfAccess().getThnExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_22);
            lv_thn_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfRule());
            					}
            					set(
            						current,
            						"thn",
            						lv_thn_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,38,FOLLOW_5); 

            			newLeafNode(otherlv_6, grammarAccess.getIfAccess().getElsKeyword_6());
            		
            // InternalMyDsl.g:1466:3: ( (lv_els_7_0= ruleExpr ) )
            // InternalMyDsl.g:1467:4: (lv_els_7_0= ruleExpr )
            {
            // InternalMyDsl.g:1467:4: (lv_els_7_0= ruleExpr )
            // InternalMyDsl.g:1468:5: lv_els_7_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getIfAccess().getElsExprParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_els_7_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfRule());
            					}
            					set(
            						current,
            						"els",
            						lv_els_7_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getIfAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleLet"
    // InternalMyDsl.g:1493:1: entryRuleLet returns [EObject current=null] : iv_ruleLet= ruleLet EOF ;
    public final EObject entryRuleLet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLet = null;


        try {
            // InternalMyDsl.g:1493:44: (iv_ruleLet= ruleLet EOF )
            // InternalMyDsl.g:1494:2: iv_ruleLet= ruleLet EOF
            {
             newCompositeNode(grammarAccess.getLetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLet=ruleLet();

            state._fsp--;

             current =iv_ruleLet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLet"


    // $ANTLR start "ruleLet"
    // InternalMyDsl.g:1500:1: ruleLet returns [EObject current=null] : (otherlv_0= 'Let' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' ) ;
    public final EObject ruleLet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_lhs_4_0 = null;

        EObject lv_rhs_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1506:2: ( (otherlv_0= 'Let' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:1507:2: (otherlv_0= 'Let' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:1507:2: (otherlv_0= 'Let' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' )
            // InternalMyDsl.g:1508:3: otherlv_0= 'Let' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getLetAccess().getLetKeyword_0());
            		
            // InternalMyDsl.g:1512:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1513:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1513:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1514:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLetAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getLetAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getLetAccess().getLhsKeyword_3());
            		
            // InternalMyDsl.g:1539:3: ( (lv_lhs_4_0= ruleExpr ) )
            // InternalMyDsl.g:1540:4: (lv_lhs_4_0= ruleExpr )
            {
            // InternalMyDsl.g:1540:4: (lv_lhs_4_0= ruleExpr )
            // InternalMyDsl.g:1541:5: lv_lhs_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getLetAccess().getLhsExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getLetAccess().getRhsKeyword_5());
            		
            // InternalMyDsl.g:1562:3: ( (lv_rhs_6_0= ruleExpr ) )
            // InternalMyDsl.g:1563:4: (lv_rhs_6_0= ruleExpr )
            {
            // InternalMyDsl.g:1563:4: (lv_rhs_6_0= ruleExpr )
            // InternalMyDsl.g:1564:5: lv_rhs_6_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getLetAccess().getRhsExprParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_6_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_6_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLetAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLet"


    // $ANTLR start "entryRuleFun"
    // InternalMyDsl.g:1589:1: entryRuleFun returns [EObject current=null] : iv_ruleFun= ruleFun EOF ;
    public final EObject entryRuleFun() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFun = null;


        try {
            // InternalMyDsl.g:1589:44: (iv_ruleFun= ruleFun EOF )
            // InternalMyDsl.g:1590:2: iv_ruleFun= ruleFun EOF
            {
             newCompositeNode(grammarAccess.getFunRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFun=ruleFun();

            state._fsp--;

             current =iv_ruleFun; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFun"


    // $ANTLR start "ruleFun"
    // InternalMyDsl.g:1596:1: ruleFun returns [EObject current=null] : (otherlv_0= 'Fun' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'body' ( (lv_body_4_0= ruleExpr ) ) otherlv_5= '}' ) ;
    public final EObject ruleFun() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1602:2: ( (otherlv_0= 'Fun' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'body' ( (lv_body_4_0= ruleExpr ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:1603:2: (otherlv_0= 'Fun' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'body' ( (lv_body_4_0= ruleExpr ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:1603:2: (otherlv_0= 'Fun' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'body' ( (lv_body_4_0= ruleExpr ) ) otherlv_5= '}' )
            // InternalMyDsl.g:1604:3: otherlv_0= 'Fun' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'body' ( (lv_body_4_0= ruleExpr ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFunAccess().getFunKeyword_0());
            		
            // InternalMyDsl.g:1608:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1609:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1609:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1610:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFunAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getFunAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getFunAccess().getBodyKeyword_3());
            		
            // InternalMyDsl.g:1635:3: ( (lv_body_4_0= ruleExpr ) )
            // InternalMyDsl.g:1636:4: (lv_body_4_0= ruleExpr )
            {
            // InternalMyDsl.g:1636:4: (lv_body_4_0= ruleExpr )
            // InternalMyDsl.g:1637:5: lv_body_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getFunAccess().getBodyExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getFunAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFun"


    // $ANTLR start "entryRuleAssign"
    // InternalMyDsl.g:1662:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // InternalMyDsl.g:1662:47: (iv_ruleAssign= ruleAssign EOF )
            // InternalMyDsl.g:1663:2: iv_ruleAssign= ruleAssign EOF
            {
             newCompositeNode(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalMyDsl.g:1669:1: ruleAssign returns [EObject current=null] : (otherlv_0= 'Assign' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_lhs_4_0 = null;

        EObject lv_rhs_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1675:2: ( (otherlv_0= 'Assign' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:1676:2: (otherlv_0= 'Assign' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:1676:2: (otherlv_0= 'Assign' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}' )
            // InternalMyDsl.g:1677:3: otherlv_0= 'Assign' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'lhs' ( (lv_lhs_4_0= ruleExpr ) ) otherlv_5= 'rhs' ( (lv_rhs_6_0= ruleExpr ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAssignAccess().getAssignKeyword_0());
            		
            // InternalMyDsl.g:1681:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1682:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1682:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1683:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAssignAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getAssignAccess().getLhsKeyword_3());
            		
            // InternalMyDsl.g:1708:3: ( (lv_lhs_4_0= ruleExpr ) )
            // InternalMyDsl.g:1709:4: (lv_lhs_4_0= ruleExpr )
            {
            // InternalMyDsl.g:1709:4: (lv_lhs_4_0= ruleExpr )
            // InternalMyDsl.g:1710:5: lv_lhs_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getAssignAccess().getLhsExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getAssignAccess().getRhsKeyword_5());
            		
            // InternalMyDsl.g:1731:3: ( (lv_rhs_6_0= ruleExpr ) )
            // InternalMyDsl.g:1732:4: (lv_rhs_6_0= ruleExpr )
            {
            // InternalMyDsl.g:1732:4: (lv_rhs_6_0= ruleExpr )
            // InternalMyDsl.g:1733:5: lv_rhs_6_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getAssignAccess().getRhsExprParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_6_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_6_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAssignAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleArithOpPlus"
    // InternalMyDsl.g:1758:1: entryRuleArithOpPlus returns [EObject current=null] : iv_ruleArithOpPlus= ruleArithOpPlus EOF ;
    public final EObject entryRuleArithOpPlus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithOpPlus = null;


        try {
            // InternalMyDsl.g:1758:52: (iv_ruleArithOpPlus= ruleArithOpPlus EOF )
            // InternalMyDsl.g:1759:2: iv_ruleArithOpPlus= ruleArithOpPlus EOF
            {
             newCompositeNode(grammarAccess.getArithOpPlusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithOpPlus=ruleArithOpPlus();

            state._fsp--;

             current =iv_ruleArithOpPlus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithOpPlus"


    // $ANTLR start "ruleArithOpPlus"
    // InternalMyDsl.g:1765:1: ruleArithOpPlus returns [EObject current=null] : (otherlv_0= 'ArithOpPlus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleArithOpPlus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1771:2: ( (otherlv_0= 'ArithOpPlus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1772:2: (otherlv_0= 'ArithOpPlus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1772:2: (otherlv_0= 'ArithOpPlus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1773:3: otherlv_0= 'ArithOpPlus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArithOpPlusAccess().getArithOpPlusKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getArithOpPlusAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArithOpPlusAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:1785:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:1786:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1786:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:1787:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpPlusAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpPlusRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getArithOpPlusAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:1808:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:1809:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:1809:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:1810:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpPlusAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpPlusRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArithOpPlusAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithOpPlus"


    // $ANTLR start "entryRuleArithOpMinus"
    // InternalMyDsl.g:1835:1: entryRuleArithOpMinus returns [EObject current=null] : iv_ruleArithOpMinus= ruleArithOpMinus EOF ;
    public final EObject entryRuleArithOpMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithOpMinus = null;


        try {
            // InternalMyDsl.g:1835:53: (iv_ruleArithOpMinus= ruleArithOpMinus EOF )
            // InternalMyDsl.g:1836:2: iv_ruleArithOpMinus= ruleArithOpMinus EOF
            {
             newCompositeNode(grammarAccess.getArithOpMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithOpMinus=ruleArithOpMinus();

            state._fsp--;

             current =iv_ruleArithOpMinus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithOpMinus"


    // $ANTLR start "ruleArithOpMinus"
    // InternalMyDsl.g:1842:1: ruleArithOpMinus returns [EObject current=null] : (otherlv_0= 'ArithOpMinus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleArithOpMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1848:2: ( (otherlv_0= 'ArithOpMinus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1849:2: (otherlv_0= 'ArithOpMinus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1849:2: (otherlv_0= 'ArithOpMinus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1850:3: otherlv_0= 'ArithOpMinus' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArithOpMinusAccess().getArithOpMinusKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getArithOpMinusAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArithOpMinusAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:1862:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:1863:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1863:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:1864:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpMinusAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpMinusRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getArithOpMinusAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:1885:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:1886:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:1886:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:1887:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpMinusAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpMinusRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArithOpMinusAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithOpMinus"


    // $ANTLR start "entryRuleArithOpTimes"
    // InternalMyDsl.g:1912:1: entryRuleArithOpTimes returns [EObject current=null] : iv_ruleArithOpTimes= ruleArithOpTimes EOF ;
    public final EObject entryRuleArithOpTimes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithOpTimes = null;


        try {
            // InternalMyDsl.g:1912:53: (iv_ruleArithOpTimes= ruleArithOpTimes EOF )
            // InternalMyDsl.g:1913:2: iv_ruleArithOpTimes= ruleArithOpTimes EOF
            {
             newCompositeNode(grammarAccess.getArithOpTimesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithOpTimes=ruleArithOpTimes();

            state._fsp--;

             current =iv_ruleArithOpTimes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithOpTimes"


    // $ANTLR start "ruleArithOpTimes"
    // InternalMyDsl.g:1919:1: ruleArithOpTimes returns [EObject current=null] : (otherlv_0= 'ArithOpTimes' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleArithOpTimes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1925:2: ( (otherlv_0= 'ArithOpTimes' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1926:2: (otherlv_0= 'ArithOpTimes' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1926:2: (otherlv_0= 'ArithOpTimes' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1927:3: otherlv_0= 'ArithOpTimes' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArithOpTimesAccess().getArithOpTimesKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getArithOpTimesAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArithOpTimesAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:1939:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:1940:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:1940:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:1941:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpTimesAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpTimesRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getArithOpTimesAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:1962:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:1963:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:1963:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:1964:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpTimesAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpTimesRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArithOpTimesAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithOpTimes"


    // $ANTLR start "entryRuleArithOpDivide"
    // InternalMyDsl.g:1989:1: entryRuleArithOpDivide returns [EObject current=null] : iv_ruleArithOpDivide= ruleArithOpDivide EOF ;
    public final EObject entryRuleArithOpDivide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithOpDivide = null;


        try {
            // InternalMyDsl.g:1989:54: (iv_ruleArithOpDivide= ruleArithOpDivide EOF )
            // InternalMyDsl.g:1990:2: iv_ruleArithOpDivide= ruleArithOpDivide EOF
            {
             newCompositeNode(grammarAccess.getArithOpDivideRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithOpDivide=ruleArithOpDivide();

            state._fsp--;

             current =iv_ruleArithOpDivide; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithOpDivide"


    // $ANTLR start "ruleArithOpDivide"
    // InternalMyDsl.g:1996:1: ruleArithOpDivide returns [EObject current=null] : (otherlv_0= 'ArithOpDivide' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleArithOpDivide() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2002:2: ( (otherlv_0= 'ArithOpDivide' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2003:2: (otherlv_0= 'ArithOpDivide' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2003:2: (otherlv_0= 'ArithOpDivide' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2004:3: otherlv_0= 'ArithOpDivide' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArithOpDivideAccess().getArithOpDivideKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getArithOpDivideAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArithOpDivideAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2016:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2017:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2017:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2018:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpDivideAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpDivideRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getArithOpDivideAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2039:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2040:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2040:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2041:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpDivideAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpDivideRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArithOpDivideAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithOpDivide"


    // $ANTLR start "entryRuleArithOpRemainder"
    // InternalMyDsl.g:2066:1: entryRuleArithOpRemainder returns [EObject current=null] : iv_ruleArithOpRemainder= ruleArithOpRemainder EOF ;
    public final EObject entryRuleArithOpRemainder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithOpRemainder = null;


        try {
            // InternalMyDsl.g:2066:57: (iv_ruleArithOpRemainder= ruleArithOpRemainder EOF )
            // InternalMyDsl.g:2067:2: iv_ruleArithOpRemainder= ruleArithOpRemainder EOF
            {
             newCompositeNode(grammarAccess.getArithOpRemainderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithOpRemainder=ruleArithOpRemainder();

            state._fsp--;

             current =iv_ruleArithOpRemainder; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithOpRemainder"


    // $ANTLR start "ruleArithOpRemainder"
    // InternalMyDsl.g:2073:1: ruleArithOpRemainder returns [EObject current=null] : (otherlv_0= 'ArithOpRemainder' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleArithOpRemainder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2079:2: ( (otherlv_0= 'ArithOpRemainder' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2080:2: (otherlv_0= 'ArithOpRemainder' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2080:2: (otherlv_0= 'ArithOpRemainder' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2081:3: otherlv_0= 'ArithOpRemainder' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArithOpRemainderAccess().getArithOpRemainderKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getArithOpRemainderAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArithOpRemainderAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2093:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2094:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2094:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2095:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpRemainderAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpRemainderRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getArithOpRemainderAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2116:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2117:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2117:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2118:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getArithOpRemainderAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithOpRemainderRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArithOpRemainderAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithOpRemainder"


    // $ANTLR start "entryRuleBoolOpAnd"
    // InternalMyDsl.g:2143:1: entryRuleBoolOpAnd returns [EObject current=null] : iv_ruleBoolOpAnd= ruleBoolOpAnd EOF ;
    public final EObject entryRuleBoolOpAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolOpAnd = null;


        try {
            // InternalMyDsl.g:2143:50: (iv_ruleBoolOpAnd= ruleBoolOpAnd EOF )
            // InternalMyDsl.g:2144:2: iv_ruleBoolOpAnd= ruleBoolOpAnd EOF
            {
             newCompositeNode(grammarAccess.getBoolOpAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolOpAnd=ruleBoolOpAnd();

            state._fsp--;

             current =iv_ruleBoolOpAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolOpAnd"


    // $ANTLR start "ruleBoolOpAnd"
    // InternalMyDsl.g:2150:1: ruleBoolOpAnd returns [EObject current=null] : (otherlv_0= 'BoolOpAnd' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleBoolOpAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2156:2: ( (otherlv_0= 'BoolOpAnd' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2157:2: (otherlv_0= 'BoolOpAnd' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2157:2: (otherlv_0= 'BoolOpAnd' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2158:3: otherlv_0= 'BoolOpAnd' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBoolOpAndAccess().getBoolOpAndKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolOpAndAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolOpAndAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2170:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2171:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2171:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2172:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getBoolOpAndAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolOpAndRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getBoolOpAndAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2193:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2194:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2194:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2195:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getBoolOpAndAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolOpAndRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBoolOpAndAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolOpAnd"


    // $ANTLR start "entryRuleBoolOpOr"
    // InternalMyDsl.g:2220:1: entryRuleBoolOpOr returns [EObject current=null] : iv_ruleBoolOpOr= ruleBoolOpOr EOF ;
    public final EObject entryRuleBoolOpOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolOpOr = null;


        try {
            // InternalMyDsl.g:2220:49: (iv_ruleBoolOpOr= ruleBoolOpOr EOF )
            // InternalMyDsl.g:2221:2: iv_ruleBoolOpOr= ruleBoolOpOr EOF
            {
             newCompositeNode(grammarAccess.getBoolOpOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolOpOr=ruleBoolOpOr();

            state._fsp--;

             current =iv_ruleBoolOpOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolOpOr"


    // $ANTLR start "ruleBoolOpOr"
    // InternalMyDsl.g:2227:1: ruleBoolOpOr returns [EObject current=null] : (otherlv_0= 'BoolOpOr' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleBoolOpOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2233:2: ( (otherlv_0= 'BoolOpOr' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2234:2: (otherlv_0= 'BoolOpOr' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2234:2: (otherlv_0= 'BoolOpOr' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2235:3: otherlv_0= 'BoolOpOr' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBoolOpOrAccess().getBoolOpOrKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolOpOrAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolOpOrAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2247:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2248:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2248:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2249:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getBoolOpOrAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolOpOrRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getBoolOpOrAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2270:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2271:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2271:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2272:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getBoolOpOrAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolOpOrRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBoolOpOrAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolOpOr"


    // $ANTLR start "entryRuleSeq"
    // InternalMyDsl.g:2297:1: entryRuleSeq returns [EObject current=null] : iv_ruleSeq= ruleSeq EOF ;
    public final EObject entryRuleSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeq = null;


        try {
            // InternalMyDsl.g:2297:44: (iv_ruleSeq= ruleSeq EOF )
            // InternalMyDsl.g:2298:2: iv_ruleSeq= ruleSeq EOF
            {
             newCompositeNode(grammarAccess.getSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSeq=ruleSeq();

            state._fsp--;

             current =iv_ruleSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSeq"


    // $ANTLR start "ruleSeq"
    // InternalMyDsl.g:2304:1: ruleSeq returns [EObject current=null] : (otherlv_0= 'Seq' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2310:2: ( (otherlv_0= 'Seq' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2311:2: (otherlv_0= 'Seq' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2311:2: (otherlv_0= 'Seq' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2312:3: otherlv_0= 'Seq' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSeqAccess().getSeqKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getSeqAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getSeqAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2324:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2325:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2325:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2326:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getSeqAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSeqRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getSeqAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2347:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2348:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2348:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2349:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getSeqAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSeqRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSeqAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSeq"


    // $ANTLR start "entryRuleCmpOpEqual"
    // InternalMyDsl.g:2374:1: entryRuleCmpOpEqual returns [EObject current=null] : iv_ruleCmpOpEqual= ruleCmpOpEqual EOF ;
    public final EObject entryRuleCmpOpEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmpOpEqual = null;


        try {
            // InternalMyDsl.g:2374:51: (iv_ruleCmpOpEqual= ruleCmpOpEqual EOF )
            // InternalMyDsl.g:2375:2: iv_ruleCmpOpEqual= ruleCmpOpEqual EOF
            {
             newCompositeNode(grammarAccess.getCmpOpEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCmpOpEqual=ruleCmpOpEqual();

            state._fsp--;

             current =iv_ruleCmpOpEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmpOpEqual"


    // $ANTLR start "ruleCmpOpEqual"
    // InternalMyDsl.g:2381:1: ruleCmpOpEqual returns [EObject current=null] : (otherlv_0= 'CmpOpEqual' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleCmpOpEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2387:2: ( (otherlv_0= 'CmpOpEqual' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2388:2: (otherlv_0= 'CmpOpEqual' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2388:2: (otherlv_0= 'CmpOpEqual' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2389:3: otherlv_0= 'CmpOpEqual' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCmpOpEqualAccess().getCmpOpEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCmpOpEqualAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getCmpOpEqualAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2401:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2402:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2402:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2403:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpEqualAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpEqualRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getCmpOpEqualAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2424:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2425:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2425:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2426:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpEqualAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpEqualRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCmpOpEqualAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmpOpEqual"


    // $ANTLR start "entryRuleCmpOpUnequal"
    // InternalMyDsl.g:2451:1: entryRuleCmpOpUnequal returns [EObject current=null] : iv_ruleCmpOpUnequal= ruleCmpOpUnequal EOF ;
    public final EObject entryRuleCmpOpUnequal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmpOpUnequal = null;


        try {
            // InternalMyDsl.g:2451:53: (iv_ruleCmpOpUnequal= ruleCmpOpUnequal EOF )
            // InternalMyDsl.g:2452:2: iv_ruleCmpOpUnequal= ruleCmpOpUnequal EOF
            {
             newCompositeNode(grammarAccess.getCmpOpUnequalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCmpOpUnequal=ruleCmpOpUnequal();

            state._fsp--;

             current =iv_ruleCmpOpUnequal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmpOpUnequal"


    // $ANTLR start "ruleCmpOpUnequal"
    // InternalMyDsl.g:2458:1: ruleCmpOpUnequal returns [EObject current=null] : (otherlv_0= 'CmpOpUnequal' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleCmpOpUnequal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2464:2: ( (otherlv_0= 'CmpOpUnequal' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2465:2: (otherlv_0= 'CmpOpUnequal' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2465:2: (otherlv_0= 'CmpOpUnequal' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2466:3: otherlv_0= 'CmpOpUnequal' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCmpOpUnequalAccess().getCmpOpUnequalKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCmpOpUnequalAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getCmpOpUnequalAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2478:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2479:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2479:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2480:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpUnequalAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpUnequalRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getCmpOpUnequalAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2501:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2502:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2502:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2503:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpUnequalAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpUnequalRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCmpOpUnequalAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmpOpUnequal"


    // $ANTLR start "entryRuleCmpOpLess"
    // InternalMyDsl.g:2528:1: entryRuleCmpOpLess returns [EObject current=null] : iv_ruleCmpOpLess= ruleCmpOpLess EOF ;
    public final EObject entryRuleCmpOpLess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmpOpLess = null;


        try {
            // InternalMyDsl.g:2528:50: (iv_ruleCmpOpLess= ruleCmpOpLess EOF )
            // InternalMyDsl.g:2529:2: iv_ruleCmpOpLess= ruleCmpOpLess EOF
            {
             newCompositeNode(grammarAccess.getCmpOpLessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCmpOpLess=ruleCmpOpLess();

            state._fsp--;

             current =iv_ruleCmpOpLess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmpOpLess"


    // $ANTLR start "ruleCmpOpLess"
    // InternalMyDsl.g:2535:1: ruleCmpOpLess returns [EObject current=null] : (otherlv_0= 'CmpOpLess' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleCmpOpLess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2541:2: ( (otherlv_0= 'CmpOpLess' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:2542:2: (otherlv_0= 'CmpOpLess' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:2542:2: (otherlv_0= 'CmpOpLess' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}' )
            // InternalMyDsl.g:2543:3: otherlv_0= 'CmpOpLess' otherlv_1= '{' otherlv_2= 'lhs' ( (lv_lhs_3_0= ruleExpr ) ) otherlv_4= 'rhs' ( (lv_rhs_5_0= ruleExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCmpOpLessAccess().getCmpOpLessKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCmpOpLessAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getCmpOpLessAccess().getLhsKeyword_2());
            		
            // InternalMyDsl.g:2555:3: ( (lv_lhs_3_0= ruleExpr ) )
            // InternalMyDsl.g:2556:4: (lv_lhs_3_0= ruleExpr )
            {
            // InternalMyDsl.g:2556:4: (lv_lhs_3_0= ruleExpr )
            // InternalMyDsl.g:2557:5: lv_lhs_3_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpLessAccess().getLhsExprParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_lhs_3_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpLessRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getCmpOpLessAccess().getRhsKeyword_4());
            		
            // InternalMyDsl.g:2578:3: ( (lv_rhs_5_0= ruleExpr ) )
            // InternalMyDsl.g:2579:4: (lv_rhs_5_0= ruleExpr )
            {
            // InternalMyDsl.g:2579:4: (lv_rhs_5_0= ruleExpr )
            // InternalMyDsl.g:2580:5: lv_rhs_5_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getCmpOpLessAccess().getRhsExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rhs_5_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCmpOpLessRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCmpOpLessAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmpOpLess"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:2605:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:2605:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:2606:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:2612:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2618:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:2619:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:2619:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:2620:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2628:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:2639:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMyDsl.g:2639:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMyDsl.g:2640:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:2646:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2652:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:2653:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:2653:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:2654:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:2654:3: (kw= '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==54) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:2655:4: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_24); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleField"
    // InternalMyDsl.g:2672:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalMyDsl.g:2672:46: (iv_ruleField= ruleField EOF )
            // InternalMyDsl.g:2673:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalMyDsl.g:2679:1: ruleField returns [EObject current=null] : (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_value_4_0= ruleExpr ) ) otherlv_5= '}' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2685:2: ( (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_value_4_0= ruleExpr ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:2686:2: (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_value_4_0= ruleExpr ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:2686:2: (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_value_4_0= ruleExpr ) ) otherlv_5= '}' )
            // InternalMyDsl.g:2687:3: otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_value_4_0= ruleExpr ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldAccess().getFieldKeyword_0());
            		
            // InternalMyDsl.g:2691:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2692:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2692:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2693:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getValueKeyword_3());
            		
            // InternalMyDsl.g:2718:3: ( (lv_value_4_0= ruleExpr ) )
            // InternalMyDsl.g:2719:4: (lv_value_4_0= ruleExpr )
            {
            // InternalMyDsl.g:2719:4: (lv_value_4_0= ruleExpr )
            // InternalMyDsl.g:2720:5: lv_value_4_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getValueExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_value_4_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"org.xtext.example.mydsl.MyDsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x003FFD8EAFE50000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});

}