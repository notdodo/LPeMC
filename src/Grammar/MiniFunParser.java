package Grammar;

// $ANTLR 3.5.1 D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g 2014-04-06 18:34:20

import Generics.ProgNode;
import Generics.DecVarNode;
import Generics.VarNode;
import Generics.DecParNode;
import Generics.DecFunNode;
import Generics.STentry;
import Generics.FunParNode;
import Generics.PrintNode;
import Generics.FunNode;
import Generics.Node;
import Generics.LetNode;
import List.EmptyNode;
import Logic.OrNode;
import Type.NatNode;
import Type.BoolNode;
import Op.DivNode;
import Logic.AndNode;
import Logic.NotNode;
import Logic.EqNode;
import Logic.IfNode;
import Op.MinNode;
import Op.MagNode;
import Op.MinusNode;
import Op.PlusNode;
import Op.TimesNode;
import List.FirstNode;
import List.RestNode;
import List.ListNode;
import Type.BoolTypeNode;
import Type.FunParType;
import Type.IntTypeNode;
import Type.ListTypeNode;
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
	@Override public String getGrammarFileName() { return "D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g"; }


	    private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();    
	    private int nestingLevel = 0;



	// $ANTLR start "prog"
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:16:2: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:16:28: (l= let )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:17:9: l= let
			{
			pushFollow(FOLLOW_let_in_prog42);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:20:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:20:23: ( LET d= declist IN e= exp SEMIC )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:21:9: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let77); 
			boolean localLet = false;
				  HashMap<String,STentry> hm = new HashMap<String,STentry>(); // creo una hashmap per lo scope attuale
				  if (nestingLevel == 0) symTable.add(hm);
				  else {localLet=true;}
			pushFollow(FOLLOW_declist_in_let109);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let111); 
			pushFollow(FOLLOW_exp_in_let115);
			e=exp();
			state._fsp--;

			match(input,SEMIC,FOLLOW_SEMIC_in_let117); 
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:30:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:30:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:31:9: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{
			astList = new ArrayList<Node>();
				int offSet;
				// dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
				// per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
				if (nestingLevel==0) offSet = 1;
				else offSet = 2;
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:38:2: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:38:3: VAR i= ID COL t= primType ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist156); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist160); 
					match(input,COL,FOLLOW_COL_in_declist162); 
					pushFollow(FOLLOW_primType_in_declist166);
					t=primType();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist168); 
					pushFollow(FOLLOW_exp_in_declist172);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist174); 
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:51:2: FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist196); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist200); 
					match(input,COL,FOLLOW_COL_in_declist202); 
					pushFollow(FOLLOW_type_in_declist206);
					rt=type();
					state._fsp--;

					DecFunNode fn = new DecFunNode((i!=null?i.getText():null), rt);
								      STentry entry = new STentry(fn,offSet++);
								      HashMap<String, STentry> hm = symTable.get(nestingLevel);
								      if (hm.put((i!=null?i.getText():null), entry) != null) {
								      	System.out.println("Identifier "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" is already defined");
					                                System.exit(0);
								      }
								     
					match(input,LPAR,FOLLOW_LPAR_in_declist225); 
					int parOffSet = -1;
					                  ArrayList<Node> parList = new ArrayList<Node>();
					                  hm = new HashMap<String,STentry>();
						          symTable.add(hm);
						          nestingLevel++;
					                 
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:65:19: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ID) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:65:20: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist231); 
							match(input,COL,FOLLOW_COL_in_declist233); 
							pushFollow(FOLLOW_type_in_declist237);
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
							                                    
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:75:39: ( COMMA fpi= ID COL t= type )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:75:40: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist242); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist246); 
									match(input,COL,FOLLOW_COL_in_declist248); 
									pushFollow(FOLLOW_type_in_declist252);
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
					match(input,RPAR,FOLLOW_RPAR_in_declist275); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist280); 
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:91:3: (e= let |e= exp )
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
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:91:4: e= let
							{
							pushFollow(FOLLOW_let_in_declist288);
							e=let();
							state._fsp--;

							fn.addLocal(((LetNode)e).getDecl());
							}
							break;
						case 2 :
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:91:56: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist296);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist302); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist304); 
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:97:1: exp returns [Node ast] : f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:98:3: (f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:98:5: f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
			{
			pushFollow(FOLLOW_term_in_exp330);
			f=term();
			state._fsp--;

			ast = f;
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:100:7: ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:100:8: ( EQ l= term )*
					{
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:100:8: ( EQ l= term )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==EQ) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:100:9: EQ l= term
							{
							match(input,EQ,FOLLOW_EQ_in_exp349); 
							pushFollow(FOLLOW_term_in_exp353);
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:104:8: MINORE l= term
					{
					match(input,MINORE,FOLLOW_MINORE_in_exp389); 
					pushFollow(FOLLOW_term_in_exp393);
					l=term();
					state._fsp--;

					ast = new MinNode(ast, l);
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:107:8: MAGGIORE l= term
					{
					match(input,MAGGIORE,FOLLOW_MAGGIORE_in_exp419); 
					pushFollow(FOLLOW_term_in_exp423);
					l=term();
					state._fsp--;

					ast = new MagNode(ast, l);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:111:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:112:2: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:112:4: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term458);
			f=value();
			state._fsp--;

			ast = f;
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:114:6: ( PLUS l= value | MINUS l= value | OR l= value )*
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:114:7: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term474); 
					pushFollow(FOLLOW_value_in_term478);
					l=value();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:117:6: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term499); 
					pushFollow(FOLLOW_value_in_term503);
					l=value();
					state._fsp--;

					ast = new MinusNode(ast, l);
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:120:6: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term526); 
					pushFollow(FOLLOW_value_in_term530);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:124:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:125:2: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:125:4: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value565);
			f=fatt();
			state._fsp--;

			ast = f;
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:127:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:127:7: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value582); 
					pushFollow(FOLLOW_fatt_in_value586);
					l=fatt();
					state._fsp--;

					ast = new TimesNode (ast,l);
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:130:6: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value608); 
					pushFollow(FOLLOW_fatt_in_value612);
					l=fatt();
					state._fsp--;

					ast = new DivNode(ast, l);
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:133:7: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value636); 
					pushFollow(FOLLOW_fatt_in_value640);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:137:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
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
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:138:2: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:138:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt679); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:140:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt691); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:142:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt704); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:144:4: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt715); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:146:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt728); 
					pushFollow(FOLLOW_exp_in_fatt732);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt734); 
					ast = e;
					}
					break;
				case 6 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:148:4: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt748); 
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
						   	//System.out.println("FunParNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
						   	ast = new FunParNode(entry,nestingLevel-declNL);
						   }else {
						   	//System.out.println("VarNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
						 	ast = new VarNode(entry,nestingLevel-declNL); 
						   }	  
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:172:4: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==LPAR) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:172:5: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt763); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:174:7: (fp= exp ( COMMA p= exp )* )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==EMPTY||(LA10_0 >= FALSE && LA10_0 <= FIRST)||(LA10_0 >= ID && LA10_0 <= IF)||LA10_0==LPAR||(LA10_0 >= NAT && LA10_0 <= NOT)||(LA10_0 >= PRINT && LA10_0 <= REST)||LA10_0==SLPAR||LA10_0==TRUE) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:174:8: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt781);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:175:7: ( COMMA p= exp )*
									loop9:
									while (true) {
										int alt9=2;
										int LA9_0 = input.LA(1);
										if ( (LA9_0==COMMA) ) {
											alt9=1;
										}

										switch (alt9) {
										case 1 :
											// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:175:8: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt792); 
											pushFollow(FOLLOW_exp_in_fatt796);
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

							match(input,RPAR,FOLLOW_RPAR_in_fatt816); 

								    	ast = new FunNode(entry,nestingLevel-declNL,parList);
								    
								    
							}
							break;

					}

					}
					break;
				case 7 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:183:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt834); 
					pushFollow(FOLLOW_exp_in_fatt838);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt840); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt842); 
					pushFollow(FOLLOW_exp_in_fatt846);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt848); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt856); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt858); 
					pushFollow(FOLLOW_exp_in_fatt862);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt864); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:186:4: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt877); 
					pushFollow(FOLLOW_exp_in_fatt881);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt883); 
					pushFollow(FOLLOW_exp_in_fatt887);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt889); 
					ast = new ListNode(e1,e2);
					}
					break;
				case 9 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:188:4: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt899); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt901); 
					pushFollow(FOLLOW_exp_in_fatt905);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt907); 
					ast = new FirstNode(e);
					}
					break;
				case 10 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:190:4: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt917); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt919); 
					pushFollow(FOLLOW_exp_in_fatt923);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt925); 
					ast = new RestNode(e);
					}
					break;
				case 11 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:192:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt936); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt938); 
					pushFollow(FOLLOW_exp_in_fatt942);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt944); 
					ast = new PrintNode(e);
					}
					break;
				case 12 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:194:4: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt959); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt961); 
					pushFollow(FOLLOW_exp_in_fatt965);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt967); 
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:198:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:198:27: (p= primType |f= funParType )
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:199:9: p= primType
					{
					pushFollow(FOLLOW_primType_in_type1003);
					p=primType();
					state._fsp--;

					ast = p;
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:201:9: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type1029);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:203:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:203:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:204:9: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType1059); 
			FunParType fpt = new FunParType();
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:205:13: (t= type ( COMMA t= type )* )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BOOLTYPE||LA15_0==INTTYPE||(LA15_0 >= LISTTYPE && LA15_0 <= LPAR)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:205:14: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType1078);
					t=type();
					state._fsp--;

					fpt.addPar(t);
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:206:17: ( COMMA t= type )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:206:18: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType1099); 
							pushFollow(FOLLOW_type_in_funParType1103);
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

			match(input,RPAR,FOLLOW_RPAR_in_funParType1119); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType1121); 
			pushFollow(FOLLOW_primType_in_funParType1125);
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
	// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:209:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:210:2: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR )
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
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:210:4: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType1140); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:211:6: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType1152); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\doppioculo\\src\\MiniFun.g:213:6: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType1167); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType1169); 
					pushFollow(FOLLOW_primType_in_primType1173);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType1175); 
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



	public static final BitSet FOLLOW_let_in_prog42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let77 = new BitSet(new long[]{0x0000100000900000L});
	public static final BitSet FOLLOW_declist_in_let109 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_IN_in_let111 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_let115 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist156 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist160 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist162 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_declist166 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist168 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_declist172 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist174 = new BitSet(new long[]{0x0000100000100002L});
	public static final BitSet FOLLOW_FUN_in_declist196 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist200 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist202 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist206 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_declist225 = new BitSet(new long[]{0x0000002000200000L});
	public static final BitSet FOLLOW_ID_in_declist231 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist233 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist237 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_declist242 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_declist246 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_declist248 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_declist252 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_declist275 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_declist280 = new BitSet(new long[]{0x000008998A6C8000L});
	public static final BitSet FOLLOW_let_in_declist288 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_exp_in_declist296 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_declist302 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist304 = new BitSet(new long[]{0x0000100000100002L});
	public static final BitSet FOLLOW_term_in_exp330 = new BitSet(new long[]{0x0000000030010002L});
	public static final BitSet FOLLOW_EQ_in_exp349 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp353 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_MINORE_in_exp389 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAGGIORE_in_exp419 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_term_in_exp423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term458 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_PLUS_in_term474 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term478 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_MINUS_in_term499 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term503 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_OR_in_term526 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_value_in_term530 = new BitSet(new long[]{0x0000000640000002L});
	public static final BitSet FOLLOW_fatt_in_value565 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_TIMES_in_value582 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value586 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_DIV_in_value608 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value612 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_AND_in_value636 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_fatt_in_value640 = new BitSet(new long[]{0x0000040000001012L});
	public static final BitSet FOLLOW_NAT_in_fatt679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt728 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt732 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt748 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt763 = new BitSet(new long[]{0x000008B9886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt781 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_fatt792 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt796 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_fatt816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt834 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt838 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt840 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_fatt842 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt846 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_fatt848 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ELSE_in_fatt856 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_fatt858 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt862 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_fatt864 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt877 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt881 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt883 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt887 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt899 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt901 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt905 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt917 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt919 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt923 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt936 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt938 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt942 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt959 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt961 = new BitSet(new long[]{0x00000899886C8000L});
	public static final BitSet FOLLOW_exp_in_fatt965 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type1003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type1029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType1059 = new BitSet(new long[]{0x000000200D000080L});
	public static final BitSet FOLLOW_type_in_funParType1078 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_COMMA_in_funParType1099 = new BitSet(new long[]{0x000000000D000080L});
	public static final BitSet FOLLOW_type_in_funParType1103 = new BitSet(new long[]{0x0000002000000400L});
	public static final BitSet FOLLOW_RPAR_in_funParType1119 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_funParType1121 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_funParType1125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType1140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType1152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType1167 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType1169 = new BitSet(new long[]{0x0000000005000080L});
	public static final BitSet FOLLOW_primType_in_primType1173 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType1175 = new BitSet(new long[]{0x0000000000000002L});
}
