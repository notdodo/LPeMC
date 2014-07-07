// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g 2014-07-07 19:22:46

package Grammar;
import Generics.*;
import Type.*;
import Logic.*;
import Math.*;
import List.*;
import java.util.HashMap;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MiniFunParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPAR", "AND", "APICI", "ARPAR", 
		"ARROW", "ASS", "BOOLTYPE", "CLPAR", "COL", "COMMA", "CRPAR", "DIV", "DOUBLCOL", 
		"ELSE", "EMPTY", "EQ", "ERR", "FALSE", "FIRST", "FUN", "ID", "IF", "IN", 
		"INTTYPE", "LET", "LISTTYPE", "LPAR", "MAGEQ", "MINEQ", "MINUS", "NAT", 
		"NOT", "NOTEQ", "OR", "PLUS", "PRINT", "REST", "RPAR", "SEMIC", "SLPAR", 
		"SRPAR", "THEN", "TIMES", "TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ALPAR=4;
	public static final int AND=5;
	public static final int APICI=6;
	public static final int ARPAR=7;
	public static final int ARROW=8;
	public static final int ASS=9;
	public static final int BOOLTYPE=10;
	public static final int CLPAR=11;
	public static final int COL=12;
	public static final int COMMA=13;
	public static final int CRPAR=14;
	public static final int DIV=15;
	public static final int DOUBLCOL=16;
	public static final int ELSE=17;
	public static final int EMPTY=18;
	public static final int EQ=19;
	public static final int ERR=20;
	public static final int FALSE=21;
	public static final int FIRST=22;
	public static final int FUN=23;
	public static final int ID=24;
	public static final int IF=25;
	public static final int IN=26;
	public static final int INTTYPE=27;
	public static final int LET=28;
	public static final int LISTTYPE=29;
	public static final int LPAR=30;
	public static final int MAGEQ=31;
	public static final int MINEQ=32;
	public static final int MINUS=33;
	public static final int NAT=34;
	public static final int NOT=35;
	public static final int NOTEQ=36;
	public static final int OR=37;
	public static final int PLUS=38;
	public static final int PRINT=39;
	public static final int REST=40;
	public static final int RPAR=41;
	public static final int SEMIC=42;
	public static final int SLPAR=43;
	public static final int SRPAR=44;
	public static final int THEN=45;
	public static final int TIMES=46;
	public static final int TRUE=47;
	public static final int VAR=48;
	public static final int WHITESP=49;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public MiniFunParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public MiniFunParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return MiniFunParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g"; }


	private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
	private ArrayList<HashMap<String,STentry>> symTableParType = new ArrayList<HashMap<String,STentry>>();
	private int nestingLevel = 0;



	// $ANTLR start "prog"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:27:1: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:27:24: (l= let )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:28:2: l= let
			{
			pushFollow(FOLLOW_let_in_prog38);
			l=let();
			state._fsp--;

			ast = new ProgNode(l);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "let"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:31:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:31:23: ( LET d= declist IN e= exp SEMIC )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:32:13: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let64); 

			                boolean localLet = false;
			                HashMap<String,STentry> hm = new HashMap<String,STentry>();
			                HashMap<String,STentry> hmp = new HashMap<String,STentry>();
			                // creo una hashmap per lo scope attuale
			                if (nestingLevel == 0){
			                    symTable.add(hm);
			                    symTableParType.add(hmp);
			                } else {
			                    localLet=true;
			                }
			            
			pushFollow(FOLLOW_declist_in_let109);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let111); 
			pushFollow(FOLLOW_exp_in_let117);
			e=exp();
			state._fsp--;

			match(input,SEMIC,FOLLOW_SEMIC_in_let119); 

			                ast = new LetNode(d, e, localLet);
			            
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "let"



	// $ANTLR start "declist"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:51:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token f=null;
		Token i2=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:51:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:52:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{

			                astList = new ArrayList<Node>();
			                int offSet;
			                int offSetParType;
			                // dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
			                // per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
			                if (nestingLevel == 0){
			                    offSet = 1;
			                } else {
			                    offSet = 2;
			                }
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:65:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==VAR) ) {
					alt6=1;
				}
				else if ( (LA6_0==FUN) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:66:21: VAR i= ID COL t= primType ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist209); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist215); 
					match(input,COL,FOLLOW_COL_in_declist217); 
					pushFollow(FOLLOW_primType_in_declist223);
					t=primType();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist225); 
					pushFollow(FOLLOW_exp_in_declist231);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist233); 

					                        DecVarNode vn = new DecVarNode((i!=null?i.getText():null),t,e);
					                        STentry entry = new STentry(vn,offSet++);
					                        HashMap<String,STentry> hm = symTable.get(nestingLevel);
					                        if (hm.put((i!=null?i.getText():null),entry) != null) {
					                            System.out.println("Identifier " + (i!=null?i.getText():null)
					                               + " at line "+(i!=null?i.getLine():0)+" already defined");
					                            System.exit(0);
					                        }
					                        // la dichiarazione viene aggiunta alla hashmap
					                        //come il riferimento al nodo DecVar
					                        astList.add(vn);
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:81:19: FUN f= ID ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist292); 
					f=(Token)match(input,ID,FOLLOW_ID_in_declist298); 

					                 ArrayList<Node> paramTypes = new ArrayList<Node>();
					                 DecFunNode fn = new DecFunNode((f!=null?f.getText():null));
					                 
					                 STentry entry = new STentry(fn,offSet++);
					                 HashMap<String, STentry> hm = symTable.get(nestingLevel);
					                 if (hm.put((f!=null?f.getText():null), entry) != null) {
					                            System.out.println("Identifier " + (f!=null?f.getText():null)
					                            + " at line " + (f!=null?f.getLine():0) + " is already defined");
					                            System.exit(0);
					                 }
					                 hm = new HashMap<String, STentry>();
					                 symTable.add(hm);
					                 HashMap<String,STentry> hmType = new HashMap<String, STentry>();
					                 symTableParType.add(hmType);
					                                                   nestingLevel++;
					                 
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:99:17: ( ALPAR i= ID ( COMMA i2= ID )* ARPAR )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ALPAR) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:100:18: ALPAR i= ID ( COMMA i2= ID )* ARPAR
							{
							match(input,ALPAR,FOLLOW_ALPAR_in_declist355); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist359); 

							                         DecTypeNode tn = new DecTypeNode((i!=null?i.getText():null));
							                         paramTypes.add(tn);
							                         entry = new STentry(tn, 0);
							                         hmType.put((i!=null?i.getText():null), entry);
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:105:12: ( COMMA i2= ID )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:105:13: COMMA i2= ID
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist375); 
									i2=(Token)match(input,ID,FOLLOW_ID_in_declist381); 

									            	 DecTypeNode tn2 = new DecTypeNode((i2!=null?i2.getText():null));
									            	 paramTypes.add(tn2);
									            	 entry = new STentry(tn2, 0);
									                       if (hmType.put((i2!=null?i2.getText():null),entry) != null) {
									                             System.out.println("Parameter " + (i!=null?i.getText():null)
									                                + " at line "+(i!=null?i.getLine():0)+" already defined");
									                             System.exit(0);
									                       }
									           	
									}
									break;

								default :
									break loop1;
								}
							}

							match(input,ARPAR,FOLLOW_ARPAR_in_declist423); 
							fn.addParType(paramTypes);
							}
							break;

					}

					match(input,COL,FOLLOW_COL_in_declist482); 
					pushFollow(FOLLOW_type_in_declist486);
					rt=type();
					state._fsp--;

					   // dichiarazione di una funzione
					                        fn.addRet(rt);
					                    
					match(input,LPAR,FOLLOW_LPAR_in_declist530); 

					                        int parOffSet = -1;
					                        ArrayList<Node> parList = new ArrayList<Node>();

					                    
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:130:21: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:131:25: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist602); 
							match(input,COL,FOLLOW_COL_in_declist604); 
							pushFollow(FOLLOW_type_in_declist608);
							t=type();
							state._fsp--;


							                            DecParNode dpn;
							                            if (t instanceof FunParType) {
							                                parOffSet--;
							                                dpn = new DecParNode((fp!=null?fp.getText():null), t, true);
							                            }else {
							                                dpn = new DecParNode((fp!=null?fp.getText():null), t);
							                            }
							                            entry = new STentry(dpn, parOffSet--);
							                            hm.put((fp!=null?fp.getText():null),entry);
							                            parList.add(dpn);
							                        
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:144:25: ( COMMA fpi= ID COL t= type )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:145:29: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist690); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist694); 
									match(input,COL,FOLLOW_COL_in_declist696); 
									pushFollow(FOLLOW_type_in_declist700);
									t=type();
									state._fsp--;


									                                if (t instanceof FunParType) {
									                                    parOffSet--;
									                                    //aggiunto fpi
									                                    dpn = new DecParNode((fpi!=null?fpi.getText():null), t, true);
									                                }else {
									                                    //aggiunto fpi
									                                    dpn = new DecParNode((fpi!=null?fpi.getText():null), t);
									                                }
									                                entry = new STentry(dpn, parOffSet--);
									                                if (hm.put((fpi!=null?fpi.getText():null),entry) != null) {
									                                    System.out.println("Identifier "+(fpi!=null?fpi.getText():null)+
									                                        " at line "+(fpi!=null?fpi.getLine():0)+" already defined");
									                                    System.exit(0);
									                                }
									                                parList.add(dpn);
									                            
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}


					                    fn.addPar(parList);
					                
					match(input,RPAR,FOLLOW_RPAR_in_declist816); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist818); 
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:170:17: (e= let |e= exp )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==LET) ) {
						alt5=1;
					}
					else if ( (LA5_0==EMPTY||(LA5_0 >= FALSE && LA5_0 <= FIRST)||(LA5_0 >= ID && LA5_0 <= IF)||LA5_0==LPAR||(LA5_0 >= NAT && LA5_0 <= NOT)||(LA5_0 >= PRINT && LA5_0 <= REST)||LA5_0==SLPAR||LA5_0==TRUE) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:171:21: e= let
							{
							pushFollow(FOLLOW_let_in_declist877);
							e=let();
							state._fsp--;


							                        fn.addLocal(((LetNode)e).getDecl());
							                    
							}
							break;
						case 2 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:176:21: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist945);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist981); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist983); 

					                    fn.addBody(e); // aggiungo il body alla funzione (Let o espressione)
					                    symTable.remove(nestingLevel);
					                    symTableParType.remove(nestingLevel);
					                    nestingLevel--;
					                    astList.add(fn);
					                
					}
					break;

				default :
					break loop6;
				}
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
		return astList;
	}
	// $ANTLR end "declist"



	// $ANTLR start "exp"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:189:1: exp returns [Node ast] : f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:189:23: (f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:190:13: f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1042);
			f=term();
			state._fsp--;


			                ast = f;
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:195:13: ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term )*
			loop7:
			while (true) {
				int alt7=5;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt7=1;
					}
					break;
				case NOTEQ:
					{
					alt7=2;
					}
					break;
				case MINEQ:
					{
					alt7=3;
					}
					break;
				case MAGEQ:
					{
					alt7=4;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:196:21: EQ l= term
					{
					match(input,EQ,FOLLOW_EQ_in_exp1095); 
					pushFollow(FOLLOW_term_in_exp1101);
					l=term();
					state._fsp--;


					                        ast = new EqNode (ast,l);
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:201:19: NOTEQ l= term
					{
					match(input,NOTEQ,FOLLOW_NOTEQ_in_exp1157); 
					pushFollow(FOLLOW_term_in_exp1163);
					l=term();
					state._fsp--;


					                        ast = new NotEqNode(ast, l);
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:207:19: MINEQ l= term
					{
					match(input,MINEQ,FOLLOW_MINEQ_in_exp1228); 
					pushFollow(FOLLOW_term_in_exp1234);
					l=term();
					state._fsp--;


					                        ast = new MinEqNode(ast, l);
					                    
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:213:19: MAGEQ l= term
					{
					match(input,MAGEQ,FOLLOW_MAGEQ_in_exp1299); 
					pushFollow(FOLLOW_term_in_exp1305);
					l=term();
					state._fsp--;


					                        ast = new MagEqNode(ast, l);
					                    
					}
					break;

				default :
					break loop7;
				}
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
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:230:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:230:24: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:231:13: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term1408);
			f=value();
			state._fsp--;


			                ast = f;
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:236:21: ( PLUS l= value | MINUS l= value | OR l= value )*
			loop8:
			while (true) {
				int alt8=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt8=1;
					}
					break;
				case MINUS:
					{
					alt8=2;
					}
					break;
				case OR:
					{
					alt8=3;
					}
					break;
				}
				switch (alt8) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:237:21: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term1448); 
					pushFollow(FOLLOW_value_in_term1454);
					l=value();
					state._fsp--;


					                        ast = new PlusNode (ast,l);
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:243:19: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term1538); 
					pushFollow(FOLLOW_value_in_term1544);
					l=value();
					state._fsp--;


					                        ast = new MinusNode(ast, l);
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:249:19: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term1628); 
					pushFollow(FOLLOW_value_in_term1634);
					l=value();
					state._fsp--;


					                        ast = new OrNode(ast, l);
					                    
					}
					break;

				default :
					break loop8;
				}
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
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "value"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:255:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:255:25: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:256:13: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value1688);
			f=fatt();
			state._fsp--;


			                ast = f;
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:261:21: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			loop9:
			while (true) {
				int alt9=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt9=1;
					}
					break;
				case DIV:
					{
					alt9=2;
					}
					break;
				case AND:
					{
					alt9=3;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:262:21: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value1728); 
					pushFollow(FOLLOW_fatt_in_value1734);
					l=fatt();
					state._fsp--;


					                        ast = new TimesNode (ast,l);
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:268:19: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value1818); 
					pushFollow(FOLLOW_fatt_in_value1824);
					l=fatt();
					state._fsp--;


					                        ast = new DivNode(ast, l);
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:274:19: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value1904); 
					pushFollow(FOLLOW_fatt_in_value1910);
					l=fatt();
					state._fsp--;


					                        ast = new AndNode(ast, l);
					                    
					}
					break;

				default :
					break loop9;
				}
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
		return ast;
	}
	// $ANTLR end "value"



	// $ANTLR start "fatt"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:280:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )? LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
	public final Node fatt() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node cane =null;
		Node p =null;
		Node fp =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e1 =null;
		Node e2 =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:280:24: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )? LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
			int alt15=12;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt15=1;
				}
				break;
			case TRUE:
				{
				alt15=2;
				}
				break;
			case FALSE:
				{
				alt15=3;
				}
				break;
			case EMPTY:
				{
				alt15=4;
				}
				break;
			case LPAR:
				{
				alt15=5;
				}
				break;
			case ID:
				{
				alt15=6;
				}
				break;
			case IF:
				{
				alt15=7;
				}
				break;
			case SLPAR:
				{
				alt15=8;
				}
				break;
			case FIRST:
				{
				alt15=9;
				}
				break;
			case REST:
				{
				alt15=10;
				}
				break;
			case PRINT:
				{
				alt15=11;
				}
				break;
			case NOT:
				{
				alt15=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:281:17: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt1967); 

					                    ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:286:15: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt2003); 

					                    ast = new BoolNode(true);
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:291:15: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt2050); 

					                    ast = new BoolNode(false);
					                
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:296:15: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt2097); 

					                    ast = new EmptyNode();
					                
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:301:15: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt2144); 
					pushFollow(FOLLOW_exp_in_fatt2150);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2152); 

					                    ast = e;
					                
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:306:15: i= ID ( ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )? LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt2191); 

					                    HashMap<String,STentry> hm;
					                    HashMap<String,STentry> hmp;
					                    STentry entry = null;
					                    STentry entryPar=null;
					                    int declNL;
					                    int declNLPar;
					                    
					                    // controllo che esista una dichiarazione per quell'ID
					                   for (declNL = nestingLevel; declNL >= 0; declNL--) {
					                    hm = symTable.get(declNL);
					                    entry = hm.get((i!=null?i.getText():null));
					                    if (entry != null)
					                    break;
					                  }
					                  if (entry == null) {
					                    System.out.println("Identifier "+(i!=null?i.getText():null)+
					                             " at line "+(i!=null?i.getLine():0)+" is not defined");
					                     System.exit(0);
					                   }
					                   
					                    if(entry.getDecl() instanceof DecFunNode ||
					                        (entry.getDecl() instanceof DecParNode &&
					                        ((DecParNode)entry.getDecl()).getType() instanceof FunParType) && entry != null){
					                            ast = new FunParNode(entry,nestingLevel-declNL);
					                    } else {
					                    //System.out.println("VarNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
					                        ast = new VarNode(entry,nestingLevel-declNL);
					                    }
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:338:17: ( ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )? LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==ALPAR||LA14_0==LPAR) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:339:18: ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )? LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:339:18: ( ALPAR cane= primType ( COMMA p= primType )* ARPAR )?
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( (LA11_0==ALPAR) ) {
								alt11=1;
							}
							switch (alt11) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:339:19: ALPAR cane= primType ( COMMA p= primType )* ARPAR
									{
									match(input,ALPAR,FOLLOW_ALPAR_in_fatt2264); 
									pushFollow(FOLLOW_primType_in_fatt2268);
									cane=primType();
									state._fsp--;

									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:339:39: ( COMMA p= primType )*
									loop10:
									while (true) {
										int alt10=2;
										int LA10_0 = input.LA(1);
										if ( (LA10_0==COMMA) ) {
											alt10=1;
										}

										switch (alt10) {
										case 1 :
											// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:339:40: COMMA p= primType
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt2271); 
											pushFollow(FOLLOW_primType_in_fatt2275);
											p=primType();
											state._fsp--;

											}
											break;

										default :
											break loop10;
										}
									}

									match(input,ARPAR,FOLLOW_ARPAR_in_fatt2279); 
									}
									break;

							}

							match(input,LPAR,FOLLOW_LPAR_in_fatt2285); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:341:21: (fp= exp ( COMMA p= exp )* )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==EMPTY||(LA13_0 >= FALSE && LA13_0 <= FIRST)||(LA13_0 >= ID && LA13_0 <= IF)||LA13_0==LPAR||(LA13_0 >= NAT && LA13_0 <= NOT)||(LA13_0 >= PRINT && LA13_0 <= REST)||LA13_0==SLPAR||LA13_0==TRUE) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:342:25: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt2339);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:343:25: ( COMMA p= exp )*
									loop12:
									while (true) {
										int alt12=2;
										int LA12_0 = input.LA(1);
										if ( (LA12_0==COMMA) ) {
											alt12=1;
										}

										switch (alt12) {
										case 1 :
											// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:344:29: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt2397); 
											pushFollow(FOLLOW_exp_in_fatt2403);
											p=exp();
											state._fsp--;

											parList.add(p);
											}
											break;

										default :
											break loop12;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt2477); 

							                        ast = new FunNode(entry,nestingLevel-declNL,parList);
							                    
							}
							break;

					}

					}
					break;
				case 7 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:353:15: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt2547); 
					pushFollow(FOLLOW_exp_in_fatt2553);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt2555); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2557); 
					pushFollow(FOLLOW_exp_in_fatt2563);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2565); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt2583); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2585); 
					pushFollow(FOLLOW_exp_in_fatt2591);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2593); 

					                    ast = new IfNode(x,y,z);
					                
					}
					break;
				case 8 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:359:15: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt2640); 
					pushFollow(FOLLOW_exp_in_fatt2646);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt2648); 
					pushFollow(FOLLOW_exp_in_fatt2654);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt2656); 

					                    ast = new ListNode(e1,e2);
					                
					}
					break;
				case 9 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:364:15: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt2703); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2705); 
					pushFollow(FOLLOW_exp_in_fatt2711);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2713); 

					                    ast = new FirstNode(e);
					                
					}
					break;
				case 10 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:369:15: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt2760); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2762); 
					pushFollow(FOLLOW_exp_in_fatt2768);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2770); 

					                    ast = new RestNode(e);
					                
					}
					break;
				case 11 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:374:15: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt2817); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2819); 
					pushFollow(FOLLOW_exp_in_fatt2825);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2827); 

					                    ast = new PrintNode(e);
					                
					}
					break;
				case 12 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:379:15: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt2874); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2876); 
					pushFollow(FOLLOW_exp_in_fatt2882);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2884); 

					                    ast = new NotNode(e);
					                
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "fatt"



	// $ANTLR start "type"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:385:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:385:24: (p= primType |f= funParType )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BOOLTYPE||LA16_0==ID||LA16_0==INTTYPE||LA16_0==LISTTYPE) ) {
				alt16=1;
			}
			else if ( (LA16_0==LPAR) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:386:17: p= primType
					{
					pushFollow(FOLLOW_primType_in_type2938);
					p=primType();
					state._fsp--;


					                    ast = p;
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:391:15: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type2989);
					f=funParType();
					state._fsp--;


					                    ast = f;
					                
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"



	// $ANTLR start "funParType"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:397:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:397:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:398:13: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType3041); 

			                FunParType fpt = new FunParType();
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:402:13: (t= type ( COMMA t= type )* )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==BOOLTYPE||LA18_0==ID||LA18_0==INTTYPE||(LA18_0 >= LISTTYPE && LA18_0 <= LPAR)) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:403:17: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType3091);
					t=type();
					state._fsp--;


					                    fpt.addPar(t);
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:407:17: ( COMMA t= type )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==COMMA) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:408:21: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType3149); 
							pushFollow(FOLLOW_type_in_funParType3155);
							t=type();
							state._fsp--;


							                        fpt.addPar(t);
							                    
							}
							break;

						default :
							break loop17;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_funParType3225); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType3227); 
			pushFollow(FOLLOW_primType_in_funParType3233);
			p=primType();
			state._fsp--;


			                fpt.addRet(p); ast =fpt;
			            
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "funParType"



	// $ANTLR start "primType"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:419:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType ( COMMA t2= primType )* SRPAR |i= ID );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Token i=null;
		Node t =null;
		Node t2 =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:419:28: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType ( COMMA t2= primType )* SRPAR |i= ID )
			int alt20=4;
			switch ( input.LA(1) ) {
			case INTTYPE:
				{
				alt20=1;
				}
				break;
			case BOOLTYPE:
				{
				alt20=2;
				}
				break;
			case LISTTYPE:
				{
				alt20=3;
				}
				break;
			case ID:
				{
				alt20=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:420:17: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType3274); 

					                    ast = new IntTypeNode();
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:425:15: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType3321); 

					                    ast = new BoolTypeNode();
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:430:15: LISTTYPE SLPAR t= primType ( COMMA t2= primType )* SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType3372); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType3374); 
					pushFollow(FOLLOW_primType_in_primType3378);
					t=primType();
					state._fsp--;

					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:430:41: ( COMMA t2= primType )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==COMMA) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:430:42: COMMA t2= primType
							{
							match(input,COMMA,FOLLOW_COMMA_in_primType3381); 
							pushFollow(FOLLOW_primType_in_primType3385);
							t2=primType();
							state._fsp--;

							}
							break;

						default :
							break loop19;
						}
					}

					match(input,SRPAR,FOLLOW_SRPAR_in_primType3389); 

					                    ast = new ListTypeNode(t);
					                
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:434:15: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_primType3425); 

					             HashMap<String,STentry> hmp;
					             STentry entryPar=null;
					                                 		
					             for(int declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
					             	hmp = symTableParType.get(declNLPar);
					                      entryPar = hmp.get((i!=null?i.getText():null));
					                      if (entryPar != null)
					                          break;
					             }
					             if (entryPar == null){
						System.out.println("Parameter Type "+(i!=null?i.getText():null)+
					                              " at line "+(i!=null?i.getLine():0)+" is not defined");
					                          System.exit(0);
					             }
					             System.out.println("Trovato: \""+(i!=null?i.getText():null)+"\"");
					             ast = new IdTypeNode((i!=null?i.getText():null));
					             
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "primType"

	// Delegated rules



	public static final BitSet FOLLOW_let_in_prog38 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let64 = new BitSet(new long[]{0x0001000004800000L});
	public static final BitSet FOLLOW_declist_in_let109 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IN_in_let111 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_let117 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist209 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist215 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist217 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_declist223 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ASS_in_declist225 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_declist231 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist233 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_FUN_in_declist292 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist298 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_ALPAR_in_declist355 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist359 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_COMMA_in_declist375 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist381 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_ARPAR_in_declist423 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist482 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist486 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist530 = new BitSet(new long[]{0x0000020001000000L});
	public static final BitSet FOLLOW_ID_in_declist602 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist604 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist608 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_declist690 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist694 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist696 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist700 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_declist816 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_declist818 = new BitSet(new long[]{0x0000898C53640000L});
	public static final BitSet FOLLOW_let_in_declist877 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_exp_in_declist945 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_declist981 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist983 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_term_in_exp1042 = new BitSet(new long[]{0x0000001180080002L});
	public static final BitSet FOLLOW_EQ_in_exp1095 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1101 = new BitSet(new long[]{0x0000001180080002L});
	public static final BitSet FOLLOW_NOTEQ_in_exp1157 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1163 = new BitSet(new long[]{0x0000001180080002L});
	public static final BitSet FOLLOW_MINEQ_in_exp1228 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1234 = new BitSet(new long[]{0x0000001180080002L});
	public static final BitSet FOLLOW_MAGEQ_in_exp1299 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1305 = new BitSet(new long[]{0x0000001180080002L});
	public static final BitSet FOLLOW_value_in_term1408 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_PLUS_in_term1448 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1454 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_MINUS_in_term1538 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1544 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_OR_in_term1628 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1634 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_fatt_in_value1688 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_TIMES_in_value1728 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1734 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_DIV_in_value1818 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1824 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_AND_in_value1904 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1910 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_NAT_in_fatt1967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt2003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt2050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt2097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2144 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2150 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt2191 = new BitSet(new long[]{0x0000000040000012L});
	public static final BitSet FOLLOW_ALPAR_in_fatt2264 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_fatt2268 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_COMMA_in_fatt2271 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_fatt2275 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_ARPAR_in_fatt2279 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2285 = new BitSet(new long[]{0x00008B8C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2339 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_fatt2397 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2403 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt2547 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2553 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt2555 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2557 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2563 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2565 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ELSE_in_fatt2583 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2585 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2591 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt2640 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2646 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt2648 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2654 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt2656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt2703 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2705 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2711 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt2760 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2762 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2768 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt2817 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2819 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2825 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt2874 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2876 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2882 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type2938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type2989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType3041 = new BitSet(new long[]{0x0000020069000400L});
	public static final BitSet FOLLOW_type_in_funParType3091 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_funParType3149 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_funParType3155 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_funParType3225 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ARROW_in_funParType3227 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_funParType3233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType3274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType3321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType3372 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType3374 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_primType3378 = new BitSet(new long[]{0x0000100000002000L});
	public static final BitSet FOLLOW_COMMA_in_primType3381 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_primType3385 = new BitSet(new long[]{0x0000100000002000L});
	public static final BitSet FOLLOW_SRPAR_in_primType3389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_primType3425 = new BitSet(new long[]{0x0000000000000002L});
}
