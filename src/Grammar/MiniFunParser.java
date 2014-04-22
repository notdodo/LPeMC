// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g 2014-04-15 00:17:26

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "APICI", "ARROW", "ASS", 
		"BOOLTYPE", "CLPAR", "COL", "COMMA", "CRPAR", "DIV", "DOUBLCOL", "ELSE", 
		"EMPTY", "EQ", "ERR", "FALSE", "FIRST", "FUN", "ID", "IF", "IN", "INTTYPE", 
		"LET", "LISTTYPE", "LPAR", "MAG", "MAGEQ", "MIN", "MINEQ", "MINUS", "NAT", 
		"NOT", "NOTEQ", "OR", "PLUS", "PRINT", "REST", "RPAR", "SEMIC", "SLPAR", 
		"SRPAR", "THEN", "TIMES", "TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int APICI=5;
	public static final int ARROW=6;
	public static final int ASS=7;
	public static final int BOOLTYPE=8;
	public static final int CLPAR=9;
	public static final int COL=10;
	public static final int COMMA=11;
	public static final int CRPAR=12;
	public static final int DIV=13;
	public static final int DOUBLCOL=14;
	public static final int ELSE=15;
	public static final int EMPTY=16;
	public static final int EQ=17;
	public static final int ERR=18;
	public static final int FALSE=19;
	public static final int FIRST=20;
	public static final int FUN=21;
	public static final int ID=22;
	public static final int IF=23;
	public static final int IN=24;
	public static final int INTTYPE=25;
	public static final int LET=26;
	public static final int LISTTYPE=27;
	public static final int LPAR=28;
	public static final int MAG=29;
	public static final int MAGEQ=30;
	public static final int MIN=31;
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
	private int nestingLevel = 0;



	// $ANTLR start "prog"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:26:1: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:26:27: (l= let )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:27:2: l= let
			{
			pushFollow(FOLLOW_let_in_prog43);
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:30:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:30:23: ( LET d= declist IN e= exp SEMIC )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:31:13: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let71); 

			                boolean localLet = false;
			                HashMap<String,STentry> hm = new HashMap<String,STentry>(); 
			                // creo una hashmap per lo scope attuale
			                if (nestingLevel == 0){
			                    symTable.add(hm);
			                } else {
			                    localLet=true;
			                }
			            
			pushFollow(FOLLOW_declist_in_let117);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let119); 
			pushFollow(FOLLOW_exp_in_let125);
			e=exp();
			state._fsp--;

			match(input,SEMIC,FOLLOW_SEMIC_in_let127); 
			 
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:48:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:48:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:49:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{

			                astList = new ArrayList<Node>();
			                int offSet;
			                // dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
			                // per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
			                if (nestingLevel == 0){ 
			                    offSet = 1;
			                } else { 
			                    offSet = 2;
			                }
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:61:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==VAR) ) {
					alt4=1;
				}
				else if ( (LA4_0==FUN) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:62:21: VAR i= ID COL t= primType ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist220); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist226); 
					match(input,COL,FOLLOW_COL_in_declist228); 
					pushFollow(FOLLOW_primType_in_declist234);
					t=primType();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist236); 
					pushFollow(FOLLOW_exp_in_declist242);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist244); 

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
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:77:21: FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist305); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist311); 
					match(input,COL,FOLLOW_COL_in_declist313); 
					pushFollow(FOLLOW_type_in_declist317);
					rt=type();
					state._fsp--;

					// dichiarazione di una funzione
					                        DecFunNode fn = new DecFunNode((i!=null?i.getText():null), rt);
					                        STentry entry = new STentry(fn,offSet++);
					                        HashMap<String, STentry> hm = symTable.get(nestingLevel);
					                        if (hm.put((i!=null?i.getText():null), entry) != null) {
					                            System.out.println("Identifier " + (i!=null?i.getText():null)
					                            + " at line " + (i!=null?i.getLine():0) + " is already defined");
					                            System.exit(0);
					                        }
					                    
					match(input,LPAR,FOLLOW_LPAR_in_declist363); 

					                        int parOffSet = -1;
					                        ArrayList<Node> parList = new ArrayList<Node>();
					                        hm = new HashMap<String,STentry>();
					                        symTable.add(hm);
					                        nestingLevel++;
					                    
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:96:21: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ID) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:97:25: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist436); 
							match(input,COL,FOLLOW_COL_in_declist438); 
							pushFollow(FOLLOW_type_in_declist442);
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
							                        
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:110:25: ( COMMA fpi= ID COL t= type )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:111:29: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist526); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist530); 
									match(input,COL,FOLLOW_COL_in_declist532); 
									pushFollow(FOLLOW_type_in_declist536);
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
									break loop1;
								}
							}

							}
							break;

					}


					                    fn.addPar(parList);
					                
					match(input,RPAR,FOLLOW_RPAR_in_declist655); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist658); 
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:136:17: (e= let |e= exp )
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==LET) ) {
						alt3=1;
					}
					else if ( (LA3_0==EMPTY||(LA3_0 >= FALSE && LA3_0 <= FIRST)||(LA3_0 >= ID && LA3_0 <= IF)||LA3_0==LPAR||(LA3_0 >= NAT && LA3_0 <= NOT)||(LA3_0 >= PRINT && LA3_0 <= REST)||LA3_0==SLPAR||LA3_0==TRUE) ) {
						alt3=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}

					switch (alt3) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:137:21: e= let
							{
							pushFollow(FOLLOW_let_in_declist718);
							e=let();
							state._fsp--;


							                        fn.addLocal(((LetNode)e).getDecl());
							                    
							}
							break;
						case 2 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:142:21: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist789);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist825); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist827); 

					                    fn.addBody(e); // aggiungo il body alla funzione (Let o espressione)
					                    symTable.remove(nestingLevel--);
					                    astList.add(fn);
					                
					}
					break;

				default :
					break loop4;
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:152:1: exp returns [Node ast] : f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | MIN l= term | MAG l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:152:23: (f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | MIN l= term | MAG l= term )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:153:13: f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | MIN l= term | MAG l= term )*
			{
			pushFollow(FOLLOW_term_in_exp888);
			f=term();
			state._fsp--;


			                ast = f;
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:158:13: ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | MIN l= term | MAG l= term )*
			loop5:
			while (true) {
				int alt5=7;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt5=1;
					}
					break;
				case NOTEQ:
					{
					alt5=2;
					}
					break;
				case MINEQ:
					{
					alt5=3;
					}
					break;
				case MAGEQ:
					{
					alt5=4;
					}
					break;
				case MIN:
					{
					alt5=5;
					}
					break;
				case MAG:
					{
					alt5=6;
					}
					break;
				}
				switch (alt5) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:159:21: EQ l= term
					{
					match(input,EQ,FOLLOW_EQ_in_exp953); 
					pushFollow(FOLLOW_term_in_exp959);
					l=term();
					state._fsp--;

					 
					                        ast = new EqNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:164:21: NOTEQ l= term
					{
					match(input,NOTEQ,FOLLOW_NOTEQ_in_exp1020); 
					pushFollow(FOLLOW_term_in_exp1026);
					l=term();
					state._fsp--;

					 
					                        ast = new NotEqNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:170:21: MINEQ l= term
					{
					match(input,MINEQ,FOLLOW_MINEQ_in_exp1100); 
					pushFollow(FOLLOW_term_in_exp1106);
					l=term();
					state._fsp--;

					 
					                        ast = new MinEqNode(ast, l); 
					                    
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:176:21: MAGEQ l= term
					{
					match(input,MAGEQ,FOLLOW_MAGEQ_in_exp1180); 
					pushFollow(FOLLOW_term_in_exp1186);
					l=term();
					state._fsp--;

					 
					                        ast = new MagEqNode(ast, l); 
					                    
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:182:21: MIN l= term
					{
					match(input,MIN,FOLLOW_MIN_in_exp1260); 
					pushFollow(FOLLOW_term_in_exp1266);
					l=term();
					state._fsp--;

					 
					                        ast = new MinNode(ast, l); 
					                    
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:187:21: MAG l= term
					{
					match(input,MAG,FOLLOW_MAG_in_exp1329); 
					pushFollow(FOLLOW_term_in_exp1335);
					l=term();
					state._fsp--;

					 
					                        ast = new MagNode(ast, l); 
					                    
					}
					break;

				default :
					break loop5;
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:193:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:193:24: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:194:13: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term1408);
			f=value();
			state._fsp--;

			 
			                ast = f; 
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:199:6: ( PLUS l= value | MINUS l= value | OR l= value )*
			loop6:
			while (true) {
				int alt6=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt6=1;
					}
					break;
				case MINUS:
					{
					alt6=2;
					}
					break;
				case OR:
					{
					alt6=3;
					}
					break;
				}
				switch (alt6) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:200:21: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term1465); 
					pushFollow(FOLLOW_value_in_term1471);
					l=value();
					state._fsp--;

					 
					                        ast = new PlusNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:206:21: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term1558); 
					pushFollow(FOLLOW_value_in_term1564);
					l=value();
					state._fsp--;

					 
					                        ast = new MinusNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:212:21: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term1651); 
					pushFollow(FOLLOW_value_in_term1657);
					l=value();
					state._fsp--;

					 
					                        ast = new OrNode(ast, l); 
					                    
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
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "value"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:218:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:218:25: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:219:13: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value1719);
			f=fatt();
			state._fsp--;

			 
			                ast = f; 
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:224:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			loop7:
			while (true) {
				int alt7=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt7=1;
					}
					break;
				case DIV:
					{
					alt7=2;
					}
					break;
				case AND:
					{
					alt7=3;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:225:21: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value1777); 
					pushFollow(FOLLOW_fatt_in_value1783);
					l=fatt();
					state._fsp--;

					 
					                        ast = new TimesNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:231:21: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value1870); 
					pushFollow(FOLLOW_fatt_in_value1876);
					l=fatt();
					state._fsp--;

					 
					                        ast = new DivNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:237:21: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value1960); 
					pushFollow(FOLLOW_fatt_in_value1966);
					l=fatt();
					state._fsp--;

					 
					                        ast = new AndNode(ast, l); 
					                    
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
	// $ANTLR end "value"



	// $ANTLR start "fatt"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:243:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
	public final Node fatt() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node fp =null;
		Node p =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e1 =null;
		Node e2 =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:243:24: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
			int alt11=12;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt11=1;
				}
				break;
			case TRUE:
				{
				alt11=2;
				}
				break;
			case FALSE:
				{
				alt11=3;
				}
				break;
			case EMPTY:
				{
				alt11=4;
				}
				break;
			case LPAR:
				{
				alt11=5;
				}
				break;
			case ID:
				{
				alt11=6;
				}
				break;
			case IF:
				{
				alt11=7;
				}
				break;
			case SLPAR:
				{
				alt11=8;
				}
				break;
			case FIRST:
				{
				alt11=9;
				}
				break;
			case REST:
				{
				alt11=10;
				}
				break;
			case PRINT:
				{
				alt11=11;
				}
				break;
			case NOT:
				{
				alt11=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:244:17: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt2032); 

					                    ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:249:17: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt2072); 

					                    ast = new BoolNode(true);
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:254:17: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt2124); 

					                    ast = new BoolNode(false);
					                
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:259:17: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt2175); 

					                    ast = new EmptyNode();
					                
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:264:17: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt2228); 
					pushFollow(FOLLOW_exp_in_fatt2234);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2236); 

					                    ast = e;
					                
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:269:17: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt2277); 

					                    HashMap<String,STentry> hm;
					                    STentry entry = null;
					                    int declNL;
					                    // controllo che esista una dichiarazione per quell'ID
					                    for(declNL = nestingLevel; declNL >= 0; declNL--) {
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
					                        ((DecParNode)entry.getDecl()).getType() instanceof FunParType)){
					                            ast = new FunParNode(entry,nestingLevel-declNL);
					                    } else {
					                    //System.out.println("VarNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
					                        ast = new VarNode(entry,nestingLevel-declNL); 
					                    }	  
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:296:17: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==LPAR) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:297:21: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt2353); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:298:21: (fp= exp ( COMMA p= exp )* )?
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( (LA9_0==EMPTY||(LA9_0 >= FALSE && LA9_0 <= FIRST)||(LA9_0 >= ID && LA9_0 <= IF)||LA9_0==LPAR||(LA9_0 >= NAT && LA9_0 <= NOT)||(LA9_0 >= PRINT && LA9_0 <= REST)||LA9_0==SLPAR||LA9_0==TRUE) ) {
								alt9=1;
							}
							switch (alt9) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:299:25: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt2407);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:300:25: ( COMMA p= exp )*
									loop8:
									while (true) {
										int alt8=2;
										int LA8_0 = input.LA(1);
										if ( (LA8_0==COMMA) ) {
											alt8=1;
										}

										switch (alt8) {
										case 1 :
											// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:301:29: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt2465); 
											pushFollow(FOLLOW_exp_in_fatt2471);
											p=exp();
											state._fsp--;

											parList.add(p);
											}
											break;

										default :
											break loop8;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt2546); 

							                        ast = new FunNode(entry,nestingLevel-declNL,parList);
							                    
							}
							break;

					}

					}
					break;
				case 7 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:310:17: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt2618); 
					pushFollow(FOLLOW_exp_in_fatt2624);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt2626); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2628); 
					pushFollow(FOLLOW_exp_in_fatt2634);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2636); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt2655); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2657); 
					pushFollow(FOLLOW_exp_in_fatt2663);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2665); 

					                    ast = new IfNode(x,y,z);
					                
					}
					break;
				case 8 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:316:17: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt2716); 
					pushFollow(FOLLOW_exp_in_fatt2722);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt2724); 
					pushFollow(FOLLOW_exp_in_fatt2730);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt2732); 

					                    ast = new ListNode(e1,e2);
					                
					}
					break;
				case 9 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:321:17: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt2782); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2784); 
					pushFollow(FOLLOW_exp_in_fatt2790);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2792); 

					                    ast = new FirstNode(e);
					                
					}
					break;
				case 10 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:326:17: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt2842); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2844); 
					pushFollow(FOLLOW_exp_in_fatt2850);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2852); 

					                    ast = new RestNode(e);
					                
					}
					break;
				case 11 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:331:17: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt2902); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2904); 
					pushFollow(FOLLOW_exp_in_fatt2910);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2912); 

					                    ast = new PrintNode(e);
					                
					}
					break;
				case 12 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:336:17: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt2966); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2968); 
					pushFollow(FOLLOW_exp_in_fatt2974);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2976); 

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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:342:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:342:27: (p= primType |f= funParType )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==BOOLTYPE||LA12_0==INTTYPE||LA12_0==LISTTYPE) ) {
				alt12=1;
			}
			else if ( (LA12_0==LPAR) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:343:17: p= primType
					{
					pushFollow(FOLLOW_primType_in_type3036);
					p=primType();
					state._fsp--;


					                    ast = p;
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:348:17: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type3090);
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:353:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:353:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:354:13: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType3141); 

			                FunParType fpt = new FunParType();
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:358:13: (t= type ( COMMA t= type )* )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==BOOLTYPE||LA14_0==INTTYPE||(LA14_0 >= LISTTYPE && LA14_0 <= LPAR)) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:359:17: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType3195);
					t=type();
					state._fsp--;


					                    fpt.addPar(t);
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:363:17: ( COMMA t= type )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==COMMA) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:364:21: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType3254); 
							pushFollow(FOLLOW_type_in_funParType3260);
							t=type();
							state._fsp--;


							                        fpt.addPar(t);
							                    
							}
							break;

						default :
							break loop13;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_funParType3331); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType3333); 
			pushFollow(FOLLOW_primType_in_funParType3339);
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:375:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:375:28: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR )
			int alt15=3;
			switch ( input.LA(1) ) {
			case INTTYPE:
				{
				alt15=1;
				}
				break;
			case BOOLTYPE:
				{
				alt15=2;
				}
				break;
			case LISTTYPE:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:376:17: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType3383); 

					                    ast = new IntTypeNode();
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:381:17: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType3436); 

					                    ast = new BoolTypeNode();
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:386:17: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType3490); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType3492); 
					pushFollow(FOLLOW_primType_in_primType3496);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType3498); 

					                    ast = new ListTypeNode(t);
					                
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



	public static final BitSet FOLLOW_let_in_prog43 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let71 = new BitSet(new long[]{0x0001000001200000L});
	public static final BitSet FOLLOW_declist_in_let117 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_let119 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_let125 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist220 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist226 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist228 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_declist234 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASS_in_declist236 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_declist242 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist244 = new BitSet(new long[]{0x0001000000200002L});
	public static final BitSet FOLLOW_FUN_in_declist305 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist311 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist313 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist317 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_declist363 = new BitSet(new long[]{0x0000020000400000L});
	public static final BitSet FOLLOW_ID_in_declist436 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist438 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist442 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist526 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist530 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist532 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist536 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist655 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_declist658 = new BitSet(new long[]{0x0000898C14D90000L});
	public static final BitSet FOLLOW_let_in_declist718 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_exp_in_declist789 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_declist825 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist827 = new BitSet(new long[]{0x0001000000200002L});
	public static final BitSet FOLLOW_term_in_exp888 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_EQ_in_exp953 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp959 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_NOTEQ_in_exp1020 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp1026 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MINEQ_in_exp1100 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp1106 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MAGEQ_in_exp1180 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp1186 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MIN_in_exp1260 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp1266 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MAG_in_exp1329 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp1335 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_value_in_term1408 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_PLUS_in_term1465 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term1471 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_MINUS_in_term1558 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term1564 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_OR_in_term1651 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term1657 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_fatt_in_value1719 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_TIMES_in_value1777 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value1783 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_DIV_in_value1870 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value1876 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_AND_in_value1960 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value1966 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_NAT_in_fatt2032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt2072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt2124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt2175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2228 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2234 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt2277 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2353 = new BitSet(new long[]{0x00008B8C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2407 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_fatt2465 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2471 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_fatt2546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt2618 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2624 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt2626 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2628 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2634 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2636 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_fatt2655 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2657 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2663 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt2716 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2722 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt2724 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2730 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt2732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt2782 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2784 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2790 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt2842 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2844 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2850 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt2902 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2904 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2910 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt2966 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2968 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt2974 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type3036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type3090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType3141 = new BitSet(new long[]{0x000002001A000100L});
	public static final BitSet FOLLOW_type_in_funParType3195 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_funParType3254 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_funParType3260 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_funParType3331 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ARROW_in_funParType3333 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_funParType3339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType3383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType3436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType3490 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType3492 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_primType3496 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType3498 = new BitSet(new long[]{0x0000000000000002L});
}
