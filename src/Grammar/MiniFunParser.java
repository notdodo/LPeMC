// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g 2014-04-22 11:49:18

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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:48:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL (rt= type |rt= genericType ) LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:48:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL (rt= type |rt= genericType ) LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:49:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL (rt= type |rt= genericType ) LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:61:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL (rt= type |rt= genericType ) LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==VAR) ) {
					alt5=1;
				}
				else if ( (LA5_0==FUN) ) {
					alt5=2;
				}

				switch (alt5) {
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
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:77:21: FUN i= ID COL (rt= type |rt= genericType ) LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist305); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist311); 
					match(input,COL,FOLLOW_COL_in_declist313); 
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:77:36: (rt= type |rt= genericType )
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==BOOLTYPE||LA1_0==INTTYPE||(LA1_0 >= LISTTYPE && LA1_0 <= LPAR)) ) {
						alt1=1;
					}
					else if ( (LA1_0==ALPAR) ) {
						alt1=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						throw nvae;
					}

					switch (alt1) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:77:37: rt= type
							{
							pushFollow(FOLLOW_type_in_declist318);
							rt=type();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:77:47: rt= genericType
							{
							pushFollow(FOLLOW_genericType_in_declist324);
							rt=genericType();
							state._fsp--;

							}
							break;

					}

					// dichiarazione di una funzione
					                        DecFunNode fn = new DecFunNode((i!=null?i.getText():null), rt);
					                        STentry entry = new STentry(fn,offSet++);
					                        HashMap<String, STentry> hm = symTable.get(nestingLevel);
					                        if (hm.put((i!=null?i.getText():null), entry) != null) {
					                            System.out.println("Identifier " + (i!=null?i.getText():null)
					                            + " at line " + (i!=null?i.getLine():0) + " is already defined");
					                            System.exit(0);
					                        }
					                    
					match(input,LPAR,FOLLOW_LPAR_in_declist372); 

					                        int parOffSet = -1;
					                        ArrayList<Node> parList = new ArrayList<Node>();
					                        hm = new HashMap<String,STentry>();
					                        symTable.add(hm);
					                        nestingLevel++;
					                    
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:96:21: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ID) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:97:25: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist445); 
							match(input,COL,FOLLOW_COL_in_declist447); 
							pushFollow(FOLLOW_type_in_declist451);
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
							loop2:
							while (true) {
								int alt2=2;
								int LA2_0 = input.LA(1);
								if ( (LA2_0==COMMA) ) {
									alt2=1;
								}

								switch (alt2) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:111:29: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist535); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist539); 
									match(input,COL,FOLLOW_COL_in_declist541); 
									pushFollow(FOLLOW_type_in_declist545);
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
									break loop2;
								}
							}

							}
							break;

					}


					                    fn.addPar(parList);
					                
					match(input,RPAR,FOLLOW_RPAR_in_declist664); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist667); 
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:136:17: (e= let |e= exp )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==LET) ) {
						alt4=1;
					}
					else if ( (LA4_0==EMPTY||(LA4_0 >= FALSE && LA4_0 <= FIRST)||(LA4_0 >= ID && LA4_0 <= IF)||LA4_0==LPAR||(LA4_0 >= NAT && LA4_0 <= NOT)||(LA4_0 >= PRINT && LA4_0 <= REST)||LA4_0==SLPAR||LA4_0==TRUE) ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:137:21: e= let
							{
							pushFollow(FOLLOW_let_in_declist727);
							e=let();
							state._fsp--;


							                        fn.addLocal(((LetNode)e).getDecl());
							                    
							}
							break;
						case 2 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:142:21: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist798);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist834); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist836); 

					                    fn.addBody(e); // aggiungo il body alla funzione (Let o espressione)
					                    symTable.remove(nestingLevel--);
					                    astList.add(fn);
					                
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
		return astList;
	}
	// $ANTLR end "declist"



	// $ANTLR start "exp"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:153:1: exp returns [Node ast] : f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:153:23: (f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:154:13: f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp898);
			f=term();
			state._fsp--;


			                ast = f;
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:159:13: ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )*
			loop6:
			while (true) {
				int alt6=7;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt6=1;
					}
					break;
				case NOTEQ:
					{
					alt6=2;
					}
					break;
				case MINEQ:
					{
					alt6=3;
					}
					break;
				case MAGEQ:
					{
					alt6=4;
					}
					break;
				case ALPAR:
					{
					alt6=5;
					}
					break;
				case ARPAR:
					{
					alt6=6;
					}
					break;
				}
				switch (alt6) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:160:21: EQ l= term
					{
					match(input,EQ,FOLLOW_EQ_in_exp963); 
					pushFollow(FOLLOW_term_in_exp969);
					l=term();
					state._fsp--;

					 
					                        ast = new EqNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:165:21: NOTEQ l= term
					{
					match(input,NOTEQ,FOLLOW_NOTEQ_in_exp1030); 
					pushFollow(FOLLOW_term_in_exp1036);
					l=term();
					state._fsp--;

					 
					                        ast = new NotEqNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:171:21: MINEQ l= term
					{
					match(input,MINEQ,FOLLOW_MINEQ_in_exp1110); 
					pushFollow(FOLLOW_term_in_exp1116);
					l=term();
					state._fsp--;

					 
					                        ast = new MinEqNode(ast, l); 
					                    
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:177:21: MAGEQ l= term
					{
					match(input,MAGEQ,FOLLOW_MAGEQ_in_exp1190); 
					pushFollow(FOLLOW_term_in_exp1196);
					l=term();
					state._fsp--;

					 
					                        ast = new MagEqNode(ast, l); 
					                    
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:183:21: ALPAR l= term
					{
					match(input,ALPAR,FOLLOW_ALPAR_in_exp1270); 
					pushFollow(FOLLOW_term_in_exp1276);
					l=term();
					state._fsp--;

					 
					                        ast = new MinNode(ast, l); 
					                    
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:188:21: ARPAR l= term
					{
					match(input,ARPAR,FOLLOW_ARPAR_in_exp1339); 
					pushFollow(FOLLOW_term_in_exp1345);
					l=term();
					state._fsp--;

					 
					                        ast = new MagNode(ast, l); 
					                    
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
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:194:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:194:24: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:195:13: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term1418);
			f=value();
			state._fsp--;

			 
			                ast = f; 
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:200:6: ( PLUS l= value | MINUS l= value | OR l= value )*
			loop7:
			while (true) {
				int alt7=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt7=1;
					}
					break;
				case MINUS:
					{
					alt7=2;
					}
					break;
				case OR:
					{
					alt7=3;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:201:21: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term1475); 
					pushFollow(FOLLOW_value_in_term1481);
					l=value();
					state._fsp--;

					 
					                        ast = new PlusNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:207:21: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term1568); 
					pushFollow(FOLLOW_value_in_term1574);
					l=value();
					state._fsp--;

					 
					                        ast = new MinusNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:213:21: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term1661); 
					pushFollow(FOLLOW_value_in_term1667);
					l=value();
					state._fsp--;

					 
					                        ast = new OrNode(ast, l); 
					                    
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
	// $ANTLR end "term"



	// $ANTLR start "value"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:219:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:219:25: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:220:13: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value1729);
			f=fatt();
			state._fsp--;

			 
			                ast = f; 
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:225:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			loop8:
			while (true) {
				int alt8=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt8=1;
					}
					break;
				case DIV:
					{
					alt8=2;
					}
					break;
				case AND:
					{
					alt8=3;
					}
					break;
				}
				switch (alt8) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:226:21: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value1787); 
					pushFollow(FOLLOW_fatt_in_value1793);
					l=fatt();
					state._fsp--;

					 
					                        ast = new TimesNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:232:21: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value1880); 
					pushFollow(FOLLOW_fatt_in_value1886);
					l=fatt();
					state._fsp--;

					 
					                        ast = new DivNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:238:21: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value1970); 
					pushFollow(FOLLOW_fatt_in_value1976);
					l=fatt();
					state._fsp--;

					 
					                        ast = new AndNode(ast, l); 
					                    
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
	// $ANTLR end "value"



	// $ANTLR start "fatt"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:244:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
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
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:244:24: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
			int alt12=12;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt12=1;
				}
				break;
			case TRUE:
				{
				alt12=2;
				}
				break;
			case FALSE:
				{
				alt12=3;
				}
				break;
			case EMPTY:
				{
				alt12=4;
				}
				break;
			case LPAR:
				{
				alt12=5;
				}
				break;
			case ID:
				{
				alt12=6;
				}
				break;
			case IF:
				{
				alt12=7;
				}
				break;
			case SLPAR:
				{
				alt12=8;
				}
				break;
			case FIRST:
				{
				alt12=9;
				}
				break;
			case REST:
				{
				alt12=10;
				}
				break;
			case PRINT:
				{
				alt12=11;
				}
				break;
			case NOT:
				{
				alt12=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:245:17: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt2042); 

					                    ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:250:17: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt2082); 

					                    ast = new BoolNode(true);
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:255:17: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt2134); 

					                    ast = new BoolNode(false);
					                
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:260:17: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt2185); 

					                    ast = new EmptyNode();
					                
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:265:17: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt2238); 
					pushFollow(FOLLOW_exp_in_fatt2244);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2246); 

					                    ast = e;
					                
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:270:17: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt2287); 

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
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:297:17: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==LPAR) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:298:21: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt2363); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:299:21: (fp= exp ( COMMA p= exp )* )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==EMPTY||(LA10_0 >= FALSE && LA10_0 <= FIRST)||(LA10_0 >= ID && LA10_0 <= IF)||LA10_0==LPAR||(LA10_0 >= NAT && LA10_0 <= NOT)||(LA10_0 >= PRINT && LA10_0 <= REST)||LA10_0==SLPAR||LA10_0==TRUE) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:300:25: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt2417);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:301:25: ( COMMA p= exp )*
									loop9:
									while (true) {
										int alt9=2;
										int LA9_0 = input.LA(1);
										if ( (LA9_0==COMMA) ) {
											alt9=1;
										}

										switch (alt9) {
										case 1 :
											// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:302:29: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt2475); 
											pushFollow(FOLLOW_exp_in_fatt2481);
											p=exp();
											state._fsp--;

											parList.add(p);
											}
											break;

										default :
											break loop9;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt2556); 

							                        ast = new FunNode(entry,nestingLevel-declNL,parList);
							                    
							}
							break;

					}

					}
					break;
				case 7 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:311:17: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt2628); 
					pushFollow(FOLLOW_exp_in_fatt2634);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt2636); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2638); 
					pushFollow(FOLLOW_exp_in_fatt2644);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2646); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt2665); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2667); 
					pushFollow(FOLLOW_exp_in_fatt2673);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2675); 

					                    ast = new IfNode(x,y,z);
					                
					}
					break;
				case 8 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:317:17: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt2726); 
					pushFollow(FOLLOW_exp_in_fatt2732);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt2734); 
					pushFollow(FOLLOW_exp_in_fatt2740);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt2742); 

					                    ast = new ListNode(e1,e2);
					                
					}
					break;
				case 9 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:322:17: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt2792); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2794); 
					pushFollow(FOLLOW_exp_in_fatt2800);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2802); 

					                    ast = new FirstNode(e);
					                
					}
					break;
				case 10 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:327:17: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt2852); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2854); 
					pushFollow(FOLLOW_exp_in_fatt2860);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2862); 

					                    ast = new RestNode(e);
					                
					}
					break;
				case 11 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:332:17: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt2912); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2914); 
					pushFollow(FOLLOW_exp_in_fatt2920);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2922); 

					                    ast = new PrintNode(e);
					                
					}
					break;
				case 12 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:337:17: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt2976); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt2978); 
					pushFollow(FOLLOW_exp_in_fatt2984);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2986); 

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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:343:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:343:27: (p= primType |f= funParType )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==BOOLTYPE||LA13_0==INTTYPE||LA13_0==LISTTYPE) ) {
				alt13=1;
			}
			else if ( (LA13_0==LPAR) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:344:17: p= primType
					{
					pushFollow(FOLLOW_primType_in_type3046);
					p=primType();
					state._fsp--;


					                    ast = p;
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:349:17: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type3100);
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:354:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:354:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:355:13: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType3151); 

			                FunParType fpt = new FunParType();
			            
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:359:13: (t= type ( COMMA t= type )* )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BOOLTYPE||LA15_0==INTTYPE||(LA15_0 >= LISTTYPE && LA15_0 <= LPAR)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:360:17: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType3205);
					t=type();
					state._fsp--;


					                    fpt.addPar(t);
					                
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:364:17: ( COMMA t= type )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:365:21: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType3264); 
							pushFollow(FOLLOW_type_in_funParType3270);
							t=type();
							state._fsp--;


							                        fpt.addPar(t);
							                    
							}
							break;

						default :
							break loop14;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_funParType3341); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType3343); 
			pushFollow(FOLLOW_primType_in_funParType3349);
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
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:376:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:376:28: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR )
			int alt16=3;
			switch ( input.LA(1) ) {
			case INTTYPE:
				{
				alt16=1;
				}
				break;
			case BOOLTYPE:
				{
				alt16=2;
				}
				break;
			case LISTTYPE:
				{
				alt16=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:377:17: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType3393); 

					                    ast = new IntTypeNode();
					                
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:382:17: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType3446); 

					                    ast = new BoolTypeNode();
					                
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:387:17: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType3500); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType3502); 
					pushFollow(FOLLOW_primType_in_primType3506);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType3508); 

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



	// $ANTLR start "genericType"
	// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:393:1: genericType returns [Node ast] : ALPAR i= ID ARPAR ;
	public final Node genericType() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:393:31: ( ALPAR i= ID ARPAR )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:394:2: ALPAR i= ID ARPAR
			{
			match(input,ALPAR,FOLLOW_ALPAR_in_genericType3544); 
			i=(Token)match(input,ID,FOLLOW_ID_in_genericType3548); 
			match(input,ARPAR,FOLLOW_ARPAR_in_genericType3550); 
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
	// $ANTLR end "genericType"

	// Delegated rules



	public static final BitSet FOLLOW_let_in_prog43 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let71 = new BitSet(new long[]{0x0001000004800000L});
	public static final BitSet FOLLOW_declist_in_let117 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IN_in_let119 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_let125 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist220 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist226 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist228 = new BitSet(new long[]{0x0000000028000400L});
	public static final BitSet FOLLOW_primType_in_declist234 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ASS_in_declist236 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_declist242 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist244 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_FUN_in_declist305 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist311 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist313 = new BitSet(new long[]{0x0000000068000410L});
	public static final BitSet FOLLOW_type_in_declist318 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_genericType_in_declist324 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist372 = new BitSet(new long[]{0x0000020001000000L});
	public static final BitSet FOLLOW_ID_in_declist445 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist447 = new BitSet(new long[]{0x0000000068000400L});
	public static final BitSet FOLLOW_type_in_declist451 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_declist535 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist539 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist541 = new BitSet(new long[]{0x0000000068000400L});
	public static final BitSet FOLLOW_type_in_declist545 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_declist664 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_declist667 = new BitSet(new long[]{0x0000898C53640000L});
	public static final BitSet FOLLOW_let_in_declist727 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_exp_in_declist798 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_declist834 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist836 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_term_in_exp898 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_EQ_in_exp963 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp969 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_NOTEQ_in_exp1030 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1036 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_MINEQ_in_exp1110 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1116 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_MAGEQ_in_exp1190 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1196 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_ALPAR_in_exp1270 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1276 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_ARPAR_in_exp1339 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1345 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_value_in_term1418 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_PLUS_in_term1475 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1481 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_MINUS_in_term1568 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1574 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_OR_in_term1661 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1667 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_fatt_in_value1729 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_TIMES_in_value1787 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1793 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_DIV_in_value1880 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1886 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_AND_in_value1970 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value1976 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_NAT_in_fatt2042 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt2082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt2134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt2185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2238 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2244 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt2287 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2363 = new BitSet(new long[]{0x00008B8C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2417 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_fatt2475 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2481 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt2628 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2634 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt2636 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2638 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2644 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2646 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ELSE_in_fatt2665 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2667 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2673 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt2726 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2732 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt2734 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2740 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt2742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt2792 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2794 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2800 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt2852 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2854 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2860 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt2912 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2914 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2920 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt2976 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt2978 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2984 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type3046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type3100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType3151 = new BitSet(new long[]{0x0000020068000400L});
	public static final BitSet FOLLOW_type_in_funParType3205 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_funParType3264 = new BitSet(new long[]{0x0000000068000400L});
	public static final BitSet FOLLOW_type_in_funParType3270 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_funParType3341 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ARROW_in_funParType3343 = new BitSet(new long[]{0x0000000028000400L});
	public static final BitSet FOLLOW_primType_in_funParType3349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType3393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType3446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType3500 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType3502 = new BitSet(new long[]{0x0000000028000400L});
	public static final BitSet FOLLOW_primType_in_primType3506 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType3508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALPAR_in_genericType3544 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_genericType3548 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ARPAR_in_genericType3550 = new BitSet(new long[]{0x0000000000000002L});
}
