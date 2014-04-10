// $ANTLR 3.5.1 C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g 2014-04-10 13:36:44

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARROW", "ASS", "BOOLTYPE", 
		"CLPAR", "COL", "COMMA", "CRPAR", "DIV", "DOUBLCOL", "ELSE", "EMPTY", 
		"EQ", "ERR", "FALSE", "FIRST", "FUN", "ID", "IF", "IN", "INTTYPE", "LET", 
		"LISTTYPE", "LPAR", "MAGGIORE", "MINORE", "MINUS", "NAT", "NOT", "OR", 
		"PLUS", "PRINT", "REST", "RPAR", "SEMIC", "SLPAR", "SRPAR", "THEN", "TIMES", 
		"TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOLTYPE=7;
	public static final int CLPAR=8;
	public static final int COL=9;
	public static final int COMMA=10;
	public static final int CRPAR=11;
	public static final int DIV=12;
	public static final int DOUBLCOL=13;
	public static final int ELSE=14;
	public static final int EMPTY=15;
	public static final int EQ=16;
	public static final int ERR=17;
	public static final int FALSE=18;
	public static final int FIRST=19;
	public static final int FUN=20;
	public static final int ID=21;
	public static final int IF=22;
	public static final int IN=23;
	public static final int INTTYPE=24;
	public static final int LET=25;
	public static final int LISTTYPE=26;
	public static final int LPAR=27;
	public static final int MAGGIORE=28;
	public static final int MINORE=29;
	public static final int MINUS=30;
	public static final int NAT=31;
	public static final int NOT=32;
	public static final int OR=33;
	public static final int PLUS=34;
	public static final int PRINT=35;
	public static final int REST=36;
	public static final int RPAR=37;
	public static final int SEMIC=38;
	public static final int SLPAR=39;
	public static final int SRPAR=40;
	public static final int THEN=41;
	public static final int TIMES=42;
	public static final int TRUE=43;
	public static final int VAR=44;
	public static final int WHITESP=45;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g"; }


	    private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();    
	    private int nestingLevel = 0;



	// $ANTLR start "prog"
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:27:2: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:27:28: (l= let )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:28:9: l= let
			{
			pushFollow(FOLLOW_let_in_prog52);
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:31:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:31:23: ( LET d= declist IN e= exp SEMIC )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:32:9: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let86); 
			boolean localLet = false;
				  HashMap<String,STentry> hm = new HashMap<String,STentry>(); // creo una hashmap per lo scope attuale
				  if (nestingLevel == 0) symTable.add(hm);
				  else {localLet=true;}
			pushFollow(FOLLOW_declist_in_let118);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let120); 
			pushFollow(FOLLOW_exp_in_let124);
			e=exp();
			state._fsp--;

			match(input,SEMIC,FOLLOW_SEMIC_in_let126); 
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:41:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:41:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:42:9: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{
			astList = new ArrayList<Node>();
				int offSet;
				// dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
				// per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
				if (nestingLevel==0) offSet = 1;
				else offSet = 2;
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:49:2: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:49:3: VAR i= ID COL t= primType ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist164); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist168); 
					match(input,COL,FOLLOW_COL_in_declist170); 
					pushFollow(FOLLOW_primType_in_declist174);
					t=primType();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist176); 
					pushFollow(FOLLOW_exp_in_declist180);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist182); 
					DecVarNode vn = new DecVarNode((i!=null?i.getText():null),t,e);
						    STentry entry = new STentry(vn,offSet++);
						    HashMap<String,STentry> hm = symTable.get(nestingLevel);
						    if (hm.put((i!=null?i.getText():null),entry) != null) {
						    	System.out.println("Identifier "+(i!=null?i.getText():null)+
						          " at line "+(i!=null?i.getLine():0)+" already defined");
						      	System.exit(0);
						    }
						    // la dichiarazione viene aggiunta alla hashmap come il riferimento al nodo DecVar
						    astList.add(vn);
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:62:2: FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist204); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist208); 
					match(input,COL,FOLLOW_COL_in_declist210); 
					pushFollow(FOLLOW_type_in_declist214);
					rt=type();
					state._fsp--;

					DecFunNode fn = new DecFunNode((i!=null?i.getText():null), rt);
								      STentry entry = new STentry(fn,offSet++);
								      HashMap<String, STentry> hm = symTable.get(nestingLevel);
								      if (hm.put((i!=null?i.getText():null), entry) != null) {
								      	System.out.println("Identifier "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" is already defined");
					                                System.exit(0);
								      }
								     
					match(input,LPAR,FOLLOW_LPAR_in_declist232); 
					int parOffSet = -1;
					                  ArrayList<Node> parList = new ArrayList<Node>();
					                  hm = new HashMap<String,STentry>();
						          symTable.add(hm);
						          nestingLevel++;
					                 
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:76:19: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ID) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:76:20: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist238); 
							match(input,COL,FOLLOW_COL_in_declist240); 
							pushFollow(FOLLOW_type_in_declist244);
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
							                                    
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:86:39: ( COMMA fpi= ID COL t= type )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:86:40: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist249); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist253); 
									match(input,COL,FOLLOW_COL_in_declist255); 
									pushFollow(FOLLOW_type_in_declist259);
									t=type();
									state._fsp--;

									if (t instanceof FunParType) {
									                 		     					parOffSet--;
									                 		     					dpn = new DecParNode((fpi!=null?fpi.getText():null), t, true); //aggiunto fpi
									                 		     				}else {
									                 		     					dpn = new DecParNode((fpi!=null?fpi.getText():null), t); //aggiunto fpi
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
					match(input,RPAR,FOLLOW_RPAR_in_declist282); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist287); 
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:102:3: (e= let |e= exp )
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
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:102:4: e= let
							{
							pushFollow(FOLLOW_let_in_declist295);
							e=let();
							state._fsp--;

							fn.addLocal(((LetNode)e).getDecl());
							}
							break;
						case 2 :
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:102:56: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist303);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist309); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist311); 
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:108:1: exp returns [Node ast] : f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:109:3: (f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:109:5: f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
			{
			pushFollow(FOLLOW_term_in_exp336);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:111:7: ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
			int alt6=3;
			switch ( input.LA(1) ) {
			case COMMA:
			case CRPAR:
			case DOUBLCOL:
			case EQ:
			case RPAR:
			case SEMIC:
			case SRPAR:
			case THEN:
				{
				alt6=1;
				}
				break;
			case MINORE:
				{
				alt6=2;
				}
				break;
			case MAGGIORE:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:111:8: ( EQ l= term )*
					{
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:111:8: ( EQ l= term )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==EQ) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:111:9: EQ l= term
							{
							match(input,EQ,FOLLOW_EQ_in_exp355); 
							pushFollow(FOLLOW_term_in_exp359);
							l=term();
							state._fsp--;

							ast = new EqNode (ast,l);
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:115:8: MINORE l= term
					{
					match(input,MINORE,FOLLOW_MINORE_in_exp395); 
					pushFollow(FOLLOW_term_in_exp399);
					l=term();
					state._fsp--;

					ast = new MinEqNode(ast, l);
					}
					break;
				case 3 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:118:8: MAGGIORE l= term
					{
					match(input,MAGGIORE,FOLLOW_MAGGIORE_in_exp425); 
					pushFollow(FOLLOW_term_in_exp429);
					l=term();
					state._fsp--;

					ast = new MagEqNode(ast, l);
					}
					break;

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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:122:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:123:2: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:123:4: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term464);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:125:6: ( PLUS l= value | MINUS l= value | OR l= value )*
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:125:7: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term480); 
					pushFollow(FOLLOW_value_in_term484);
					l=value();
					state._fsp--;

					ast = new PlusNode (ast, l);
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:128:6: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term505); 
					pushFollow(FOLLOW_value_in_term509);
					l=value();
					state._fsp--;

					ast = new MinusNode(ast, l);
					}
					break;
				case 3 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:131:6: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term532); 
					pushFollow(FOLLOW_value_in_term536);
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:135:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:136:2: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:136:4: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value570);
			f=fatt();
			state._fsp--;

			ast = f;
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:138:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:138:7: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value587); 
					pushFollow(FOLLOW_fatt_in_value591);
					l=fatt();
					state._fsp--;

					ast = new TimesNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:141:6: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value613); 
					pushFollow(FOLLOW_fatt_in_value617);
					l=fatt();
					state._fsp--;

					ast = new DivNode(ast, l);
					}
					break;
				case 3 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:144:7: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value641); 
					pushFollow(FOLLOW_fatt_in_value645);
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:148:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
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
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:149:2: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:149:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt684); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:151:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt696); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:153:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt709); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:155:4: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt720); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:157:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt733); 
					pushFollow(FOLLOW_exp_in_fatt737);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt739); 
					ast = e;
					}
					break;
				case 6 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:159:4: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt753); 
					HashMap<String,STentry> hm;
						   STentry entry=null;
						   int declNL;
						   // controllo che esista una dichiarazione per quell'ID
						   for(declNL=nestingLevel; declNL>=0; declNL--) {
						        hm = symTable.get(declNL);
						   	entry = hm.get((i!=null?i.getText():null));
						       	if (entry != null) break;
						   } 
						   if (entry == null) {
						   	System.out.println("Identifier "+(i!=null?i.getText():null)+
						          " at line "+(i!=null?i.getLine():0)+" is not defined");
						        System.exit(0);
						   }
						   if(entry.getDecl() instanceof DecFunNode || 
						   	(entry.getDecl() instanceof DecParNode && ((DecParNode)entry.getDecl()).getType() instanceof FunParType)){
						   	System.out.println("1 FunParNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
						   	ast = new FunParNode(entry,nestingLevel-declNL);
						   }else {
						   	//System.out.println("VarNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
						 	ast = new VarNode(entry,nestingLevel-declNL); 
						   }	  
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:183:4: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==LPAR) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:183:5: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt768); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:185:7: (fp= exp ( COMMA p= exp )* )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==EMPTY||(LA10_0 >= FALSE && LA10_0 <= FIRST)||(LA10_0 >= ID && LA10_0 <= IF)||LA10_0==LPAR||(LA10_0 >= NAT && LA10_0 <= NOT)||(LA10_0 >= PRINT && LA10_0 <= REST)||LA10_0==SLPAR||LA10_0==TRUE) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:185:8: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt786);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:186:7: ( COMMA p= exp )*
									loop9:
									while (true) {
										int alt9=2;
										int LA9_0 = input.LA(1);
										if ( (LA9_0==COMMA) ) {
											alt9=1;
										}

										switch (alt9) {
										case 1 :
											// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:186:8: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt797); 
											pushFollow(FOLLOW_exp_in_fatt801);
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

							match(input,RPAR,FOLLOW_RPAR_in_fatt821); 

								    	   	System.out.println("2 FunNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
								    	ast = new FunNode(entry,nestingLevel-declNL,parList);

								    
							System.out.println(ast);
							}
							break;

					}

					}
					break;
				case 7 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:196:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt856); 
					pushFollow(FOLLOW_exp_in_fatt860);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt862); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt864); 
					pushFollow(FOLLOW_exp_in_fatt868);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt870); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt878); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt880); 
					pushFollow(FOLLOW_exp_in_fatt884);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt886); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:199:4: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt899); 
					pushFollow(FOLLOW_exp_in_fatt903);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt905); 
					pushFollow(FOLLOW_exp_in_fatt909);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt911); 
					ast = new ListNode(e1,e2);
					}
					break;
				case 9 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:201:4: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt921); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt923); 
					pushFollow(FOLLOW_exp_in_fatt927);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt929); 
					ast = new FirstNode(e);
					}
					break;
				case 10 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:203:4: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt939); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt941); 
					pushFollow(FOLLOW_exp_in_fatt945);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt947); 
					ast = new RestNode(e);
					}
					break;
				case 11 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:205:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt958); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt960); 
					pushFollow(FOLLOW_exp_in_fatt964);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt966); 
					ast = new PrintNode(e);
					}
					break;
				case 12 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:207:4: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt981); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt983); 
					pushFollow(FOLLOW_exp_in_fatt987);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt989); 
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:211:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:211:27: (p= primType |f= funParType )
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:212:9: p= primType
					{
					pushFollow(FOLLOW_primType_in_type1025);
					p=primType();
					state._fsp--;

					ast = p;
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:214:9: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type1051);
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:216:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:216:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:217:9: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType1081); 
			FunParType fpt = new FunParType();
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:218:13: (t= type ( COMMA t= type )* )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BOOLTYPE||LA15_0==INTTYPE||(LA15_0 >= LISTTYPE && LA15_0 <= LPAR)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:218:14: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType1100);
					t=type();
					state._fsp--;

					fpt.addPar(t);
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:219:17: ( COMMA t= type )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:219:18: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType1121); 
							pushFollow(FOLLOW_type_in_funParType1125);
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

			match(input,RPAR,FOLLOW_RPAR_in_funParType1141); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType1143); 
			pushFollow(FOLLOW_primType_in_funParType1147);
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
	// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:222:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:223:2: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR )
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
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:223:4: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType1161); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:224:6: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType1173); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\Edoardo\\Downloads\\Est2\\src\\Grammar\\MiniFun.g:226:6: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType1188); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType1190); 
					pushFollow(FOLLOW_primType_in_primType1194);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType1196); 
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



	public static final BitSet FOLLOW_let_in_prog52 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let86 = new BitSet(new long[]{0x0000100000900000L});
	public static final BitSet FOLLOW_declist_in_let118 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_IN_in_let120 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_let124 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist164 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist168 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist170 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_declist174 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist176 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_declist180 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist182 = new BitSet(new long[]{0x0000100000100002L});
	public static final BitSet FOLLOW_FUN_in_declist204 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist208 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist210 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist214 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_declist232 = new BitSet(new long[]{0x0000002000200000L});
	public static final BitSet FOLLOW_ID_in_declist238 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist240 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist244 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_declist249 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist253 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist255 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist259 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_declist282 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_declist287 = new BitSet(new long[]{0x000008998A6C8000L});
	public static final BitSet FOLLOW_let_in_declist295 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_exp_in_declist303 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_declist309 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist311 = new BitSet(new long[]{0x0000100000100002L});
	public static final BitSet FOLLOW_term_in_exp336 = new BitSet(new long[]{0x0000000030010002L});
	public static final BitSet FOLLOW_EQ_in_exp355 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp359 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_MINORE_in_exp395 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAGGIORE_in_exp425 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term464 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_PLUS_in_term480 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term484 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_MINUS_in_term505 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term509 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_OR_in_term532 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term536 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_fatt_in_value570 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_TIMES_in_value587 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value591 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_DIV_in_value613 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value617 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_AND_in_value641 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value645 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_NAT_in_fatt684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt733 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt737 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt753 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt768 = new BitSet(new long[]{0x000008B9886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt786 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_fatt797 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt801 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_fatt821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt856 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt860 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt862 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_fatt864 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt868 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_fatt870 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ELSE_in_fatt878 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_fatt880 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt884 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_fatt886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt899 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt903 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt905 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt909 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt921 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt923 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt927 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt939 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt941 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt945 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt958 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt960 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt964 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt981 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt983 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt987 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType1081 = new BitSet(new long[]{0x000000200D000080L});
	public static final BitSet FOLLOW_type_in_funParType1100 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_funParType1121 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_funParType1125 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_funParType1141 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_funParType1143 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_funParType1147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType1173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType1188 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType1190 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_primType1194 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType1196 = new BitSet(new long[]{0x0000000000000002L});
}
