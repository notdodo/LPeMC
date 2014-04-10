package Grammar;

// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/base/src/VM.g 2014-04-04 09:23:51

import java.util.HashMap;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "BRANCH", "BRANCHEQ", "BRANCHLESS", 
		"COL", "COMMENT", "COPYFP", "DIV", "ERR", "HALT", "JS", "LABEL", "LOADFP", 
		"LOADHP", "LOADRA", "LOADRV", "LOADW", "MULT", "NUMBER", "POP", "PRINT", 
		"PUSH", "STOREFP", "STOREHP", "STORERA", "STORERV", "STOREW", "SUB", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHLESS=7;
	public static final int COL=8;
	public static final int COMMENT=9;
	public static final int COPYFP=10;
	public static final int DIV=11;
	public static final int ERR=12;
	public static final int HALT=13;
	public static final int JS=14;
	public static final int LABEL=15;
	public static final int LOADFP=16;
	public static final int LOADHP=17;
	public static final int LOADRA=18;
	public static final int LOADRV=19;
	public static final int LOADW=20;
	public static final int MULT=21;
	public static final int NUMBER=22;
	public static final int POP=23;
	public static final int PRINT=24;
	public static final int PUSH=25;
	public static final int STOREFP=26;
	public static final int STOREHP=27;
	public static final int STORERA=28;
	public static final int STORERV=29;
	public static final int STOREW=30;
	public static final int SUB=31;
	public static final int WHITESP=32;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public VMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public VMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/edoardo/NetBeansProjects/base/src/VM.g"; }


	      
	    private int[] code = new int[ExecuteVM.CODESIZE];    
	    private int i = 0;
	    private HashMap<String,Integer> labelAddress = new HashMap<String,Integer>();
	    private ArrayList<String> labels = new ArrayList<String>();
	    private ArrayList<Integer> addresses  = new ArrayList<Integer>();
	    
	    public int[] createCode() throws Exception {
	       assembly();
	       return code;
	    }
	    



	// $ANTLR start "assembly"
	// /home/edoardo/NetBeansProjects/base/src/VM.g:27:1: assembly : ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token e=null;

		try {
			// /home/edoardo/NetBeansProjects/base/src/VM.g:27:9: ( ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// /home/edoardo/NetBeansProjects/base/src/VM.g:27:11: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// /home/edoardo/NetBeansProjects/base/src/VM.g:27:11: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=26;
				switch ( input.LA(1) ) {
				case PUSH:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==NUMBER) ) {
						alt1=1;
					}
					else if ( (LA1_2==LABEL) ) {
						alt1=2;
					}

					}
					break;
				case POP:
					{
					alt1=3;
					}
					break;
				case ADD:
					{
					alt1=4;
					}
					break;
				case SUB:
					{
					alt1=5;
					}
					break;
				case MULT:
					{
					alt1=6;
					}
					break;
				case DIV:
					{
					alt1=7;
					}
					break;
				case STOREW:
					{
					alt1=8;
					}
					break;
				case LOADW:
					{
					alt1=9;
					}
					break;
				case LABEL:
					{
					alt1=10;
					}
					break;
				case BRANCH:
					{
					alt1=11;
					}
					break;
				case BRANCHEQ:
					{
					alt1=12;
					}
					break;
				case BRANCHLESS:
					{
					alt1=13;
					}
					break;
				case JS:
					{
					alt1=14;
					}
					break;
				case LOADRA:
					{
					alt1=15;
					}
					break;
				case STORERA:
					{
					alt1=16;
					}
					break;
				case LOADRV:
					{
					alt1=17;
					}
					break;
				case STORERV:
					{
					alt1=18;
					}
					break;
				case LOADFP:
					{
					alt1=19;
					}
					break;
				case STOREFP:
					{
					alt1=20;
					}
					break;
				case COPYFP:
					{
					alt1=21;
					}
					break;
				case LOADHP:
					{
					alt1=22;
					}
					break;
				case STOREHP:
					{
					alt1=23;
					}
					break;
				case PRINT:
					{
					alt1=24;
					}
					break;
				case HALT:
					{
					alt1=25;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:27:13: PUSH e= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly26); 
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly30); 
					code[i++] = PUSH; 
								     code[i++] = Integer.parseInt((e!=null?e.getText():null));
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:29:6: PUSH e= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly41); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly45); 
					code[i++] = PUSH;
						    		     labels.add((e!=null?e.getText():null));
						  		     addresses.add(new Integer(i)); 
						  		     code[i++] = 0;
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:33:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly65); 
					code[i++] = POP;
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:34:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly80); 
					code[i++] = ADD;
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:35:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly94); 
					code[i++] = SUB;
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:36:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly108); 
					code[i++] = MULT;
					}
					break;
				case 7 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:37:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly121); 
					code[i++] = DIV;
					}
					break;
				case 8 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:38:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly135); 
					code[i++] = STOREW;
					}
					break;
				case 9 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:39:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly148); 
					code[i++] = LOADW;
					}
					break;
				case 10 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:40:6: e= LABEL COL
					{
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly169); 
					match(input,COL,FOLLOW_COL_in_assembly171); 
					labelAddress.put((e!=null?e.getText():null),new Integer(i));
					}
					break;
				case 11 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:41:6: BRANCH e= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly184); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly188); 
					code[i++] = BRANCH;
						  		     labels.add((e!=null?e.getText():null));
						  		     addresses.add(new Integer(i)); 
						  		     code[i++] = 0;
					}
					break;
				case 12 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:45:6: BRANCHEQ e= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly198); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly202); 
					code[i++] = BRANCHEQ;
						  	  	     labels.add((e!=null?e.getText():null));
						  		     addresses.add(new Integer(i)); 
						  		     code[i++] = 0;
					}
					break;
				case 13 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:49:6: BRANCHLESS e= LABEL
					{
					match(input,BRANCHLESS,FOLLOW_BRANCHLESS_in_assembly211); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly215); 
					code[i++] = BRANCHLESS;
						  	  	     labels.add((e!=null?e.getText():null));
						  		     addresses.add(new Integer(i)); 
						  		     code[i++] = 0;
					}
					break;
				case 14 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:53:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly224); 
					code[i++] = JS;
					}
					break;
				case 15 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:54:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly253); 
					code[i++] = LOADRA;
					}
					break;
				case 16 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:55:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly271); 
					code[i++] = STORERA;
					}
					break;
				case 17 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:56:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly289); 
					code[i++] = LOADRV;
					}
					break;
				case 18 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:57:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly307); 
					code[i++] = STORERV;
					}
					break;
				case 19 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:58:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly325); 
					code[i++] = LOADFP;
					}
					break;
				case 20 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:59:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly343); 
					code[i++] = STOREFP;
					}
					break;
				case 21 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:60:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly360); 
					code[i++] = COPYFP;
					}
					break;
				case 22 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:61:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly378); 
					code[i++] = LOADHP;
					}
					break;
				case 23 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:62:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly396); 
					code[i++] = STOREHP;
					}
					break;
				case 24 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:63:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly413); 
					code[i++] = PRINT;
					}
					break;
				case 25 :
					// /home/edoardo/NetBeansProjects/base/src/VM.g:64:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly432); 
					code[i++] = HALT;
					}
					break;

				default :
					break loop1;
				}
			}

			  for (int ind=0; ind<labels.size(); ind++) {
			        	  Integer t = labelAddress.get(labels.get(ind));
			        	  Integer a = addresses.get(ind);
					  code[a.intValue()]=t.intValue(); 
			                }
			              
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assembly"

	// Delegated rules



	public static final BitSet FOLLOW_PUSH_in_assembly26 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_NUMBER_in_assembly30 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_PUSH_in_assembly41 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly45 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_POP_in_assembly65 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_ADD_in_assembly80 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_SUB_in_assembly94 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_MULT_in_assembly108 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_DIV_in_assembly121 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_STOREW_in_assembly135 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LOADW_in_assembly148 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LABEL_in_assembly169 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_assembly171 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_BRANCH_in_assembly184 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly188 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly198 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly202 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_BRANCHLESS_in_assembly211 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly215 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_JS_in_assembly224 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LOADRA_in_assembly253 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_STORERA_in_assembly271 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LOADRV_in_assembly289 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_STORERV_in_assembly307 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LOADFP_in_assembly325 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_STOREFP_in_assembly343 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_COPYFP_in_assembly360 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_LOADHP_in_assembly378 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_STOREHP_in_assembly396 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_PRINT_in_assembly413 = new BitSet(new long[]{0x00000000FFBFECF2L});
	public static final BitSet FOLLOW_HALT_in_assembly432 = new BitSet(new long[]{0x00000000FFBFECF2L});
}
