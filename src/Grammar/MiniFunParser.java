// $ANTLR 3.5.1 /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g 2014-04-10 15:27:47

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
		"LET", "LISTTYPE", "LPAR", "MAG", "MAGGIORE", "MIN", "MINORE", "MINUS", 
		"NAT", "NOT", "NOTEQ", "OR", "PLUS", "PRINT", "REST", "RPAR", "SEMIC", 
		"SLPAR", "SRPAR", "THEN", "TIMES", "TRUE", "VAR", "WHITESP"
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
	public static final int MAGGIORE=30;
	public static final int MIN=31;
	public static final int MINORE=32;
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
	@Override public String getGrammarFileName() { return "/home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g"; }


	    private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();    
	    private int nestingLevel = 0;



	// $ANTLR start "prog"
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:27:2: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:27:28: (l= let )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:28:9: l= let
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:31:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:31:23: ( LET d= declist IN e= exp SEMIC )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:32:9: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let87); 
			boolean localLet = false;
				  HashMap<String,STentry> hm = new HashMap<String,STentry>(); // creo una hashmap per lo scope attuale
				  if (nestingLevel == 0) symTable.add(hm);
				  else {localLet=true;}
			pushFollow(FOLLOW_declist_in_let119);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let121); 
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:41:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:41:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:42:9: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{
			astList = new ArrayList<Node>();
				int offSet;
				// dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
				// per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
				if (nestingLevel==0) offSet = 1;
				else offSet = 2;
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:49:2: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:49:3: VAR i= ID COL t= primType ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist166); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist170); 
					match(input,COL,FOLLOW_COL_in_declist172); 
					pushFollow(FOLLOW_primType_in_declist176);
					t=primType();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist178); 
					pushFollow(FOLLOW_exp_in_declist182);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist184); 
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:62:2: FUN i= ID COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist206); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist210); 
					match(input,COL,FOLLOW_COL_in_declist212); 
					pushFollow(FOLLOW_type_in_declist216);
					rt=type();
					state._fsp--;

					DecFunNode fn = new DecFunNode((i!=null?i.getText():null), rt);
								      STentry entry = new STentry(fn,offSet++);
								      HashMap<String, STentry> hm = symTable.get(nestingLevel);
								      if (hm.put((i!=null?i.getText():null), entry) != null) {
								      	System.out.println("Identifier "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" is already defined");
					                                System.exit(0);
								      }
								     
					match(input,LPAR,FOLLOW_LPAR_in_declist235); 
					int parOffSet = -1;
					                  ArrayList<Node> parList = new ArrayList<Node>();
					                  hm = new HashMap<String,STentry>();
						          symTable.add(hm);
						          nestingLevel++;
					                 
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:76:19: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ID) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:76:20: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist241); 
							match(input,COL,FOLLOW_COL_in_declist243); 
							pushFollow(FOLLOW_type_in_declist247);
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
							                                    
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:86:39: ( COMMA fpi= ID COL t= type )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:86:40: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist252); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist256); 
									match(input,COL,FOLLOW_COL_in_declist258); 
									pushFollow(FOLLOW_type_in_declist262);
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
					match(input,RPAR,FOLLOW_RPAR_in_declist285); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist290); 
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:102:3: (e= let |e= exp )
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
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:102:4: e= let
							{
							pushFollow(FOLLOW_let_in_declist298);
							e=let();
							state._fsp--;

							fn.addLocal(((LetNode)e).getDecl());
							}
							break;
						case 2 :
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:102:56: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist306);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist312); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist314); 
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:108:1: exp returns [Node ast] : f= term ( EQ l= term | NOTEQ l= term | MINORE l= term | MAGGIORE l= term | MIN l= term | MAG l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:109:3: (f= term ( EQ l= term | NOTEQ l= term | MINORE l= term | MAGGIORE l= term | MIN l= term | MAG l= term )* )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:109:5: f= term ( EQ l= term | NOTEQ l= term | MINORE l= term | MAGGIORE l= term | MIN l= term | MAG l= term )*
			{
			pushFollow(FOLLOW_term_in_exp340);
			f=term();
			state._fsp--;

			ast = f;
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:111:7: ( EQ l= term | NOTEQ l= term | MINORE l= term | MAGGIORE l= term | MIN l= term | MAG l= term )*
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
				case MINORE:
					{
					alt5=3;
					}
					break;
				case MAGGIORE:
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:111:8: EQ l= term
					{
					match(input,EQ,FOLLOW_EQ_in_exp358); 
					pushFollow(FOLLOW_term_in_exp362);
					l=term();
					state._fsp--;

					ast = new EqNode (ast,l);
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:114:14: NOTEQ l= term
					{
					match(input,NOTEQ,FOLLOW_NOTEQ_in_exp394); 
					pushFollow(FOLLOW_term_in_exp398);
					l=term();
					state._fsp--;

					ast = new NotEqNode(ast, l);
					}
					break;
				case 3 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:117:8: MINORE l= term
					{
					match(input,MINORE,FOLLOW_MINORE_in_exp424); 
					pushFollow(FOLLOW_term_in_exp428);
					l=term();
					state._fsp--;

					ast = new MinEqNode(ast, l);
					}
					break;
				case 4 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:120:8: MAGGIORE l= term
					{
					match(input,MAGGIORE,FOLLOW_MAGGIORE_in_exp454); 
					pushFollow(FOLLOW_term_in_exp458);
					l=term();
					state._fsp--;

					ast = new MagEqNode(ast, l);
					}
					break;
				case 5 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:123:8: MIN l= term
					{
					match(input,MIN,FOLLOW_MIN_in_exp484); 
					pushFollow(FOLLOW_term_in_exp488);
					l=term();
					state._fsp--;

					ast = new MinNode(ast, l);
					}
					break;
				case 6 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:125:14: MAG l= term
					{
					match(input,MAG,FOLLOW_MAG_in_exp513); 
					pushFollow(FOLLOW_term_in_exp517);
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:129:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:130:2: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:130:4: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term561);
			f=value();
			state._fsp--;

			ast = f;
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:132:6: ( PLUS l= value | MINUS l= value | OR l= value )*
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:132:7: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term577); 
					pushFollow(FOLLOW_value_in_term581);
					l=value();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:135:6: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term602); 
					pushFollow(FOLLOW_value_in_term606);
					l=value();
					state._fsp--;

					ast = new MinusNode(ast, l);
					}
					break;
				case 3 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:138:6: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term629); 
					pushFollow(FOLLOW_value_in_term633);
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:142:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:143:2: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:143:4: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value668);
			f=fatt();
			state._fsp--;

			ast = f;
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:145:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:145:7: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value685); 
					pushFollow(FOLLOW_fatt_in_value689);
					l=fatt();
					state._fsp--;

					ast = new TimesNode (ast,l);
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:148:6: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value711); 
					pushFollow(FOLLOW_fatt_in_value715);
					l=fatt();
					state._fsp--;

					ast = new DivNode(ast, l);
					}
					break;
				case 3 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:151:7: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value739); 
					pushFollow(FOLLOW_fatt_in_value743);
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:155:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
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
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:156:2: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:156:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt782); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:158:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt794); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:160:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt807); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:162:4: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt818); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:164:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt831); 
					pushFollow(FOLLOW_exp_in_fatt835);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt837); 
					ast = e;
					}
					break;
				case 6 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:166:4: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt851); 
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:190:4: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==LPAR) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:190:5: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt866); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:192:7: (fp= exp ( COMMA p= exp )* )?
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( (LA9_0==EMPTY||(LA9_0 >= FALSE && LA9_0 <= FIRST)||(LA9_0 >= ID && LA9_0 <= IF)||LA9_0==LPAR||(LA9_0 >= NAT && LA9_0 <= NOT)||(LA9_0 >= PRINT && LA9_0 <= REST)||LA9_0==SLPAR||LA9_0==TRUE) ) {
								alt9=1;
							}
							switch (alt9) {
								case 1 :
									// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:192:8: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt884);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:193:7: ( COMMA p= exp )*
									loop8:
									while (true) {
										int alt8=2;
										int LA8_0 = input.LA(1);
										if ( (LA8_0==COMMA) ) {
											alt8=1;
										}

										switch (alt8) {
										case 1 :
											// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:193:8: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt895); 
											pushFollow(FOLLOW_exp_in_fatt899);
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

							match(input,RPAR,FOLLOW_RPAR_in_fatt919); 

								    	   	System.out.println("2 FunNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
								    	ast = new FunNode(entry,nestingLevel-declNL,parList);
								    
								    
							System.out.println(ast);
							}
							break;

					}

					}
					break;
				case 7 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:203:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt954); 
					pushFollow(FOLLOW_exp_in_fatt958);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt960); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt962); 
					pushFollow(FOLLOW_exp_in_fatt966);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt968); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt976); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt978); 
					pushFollow(FOLLOW_exp_in_fatt982);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt984); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:207:4: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt997); 
					pushFollow(FOLLOW_exp_in_fatt1001);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt1003); 
					pushFollow(FOLLOW_exp_in_fatt1007);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt1009); 
					ast = new ListNode(e1,e2);
					}
					break;
				case 9 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:209:4: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt1019); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt1021); 
					pushFollow(FOLLOW_exp_in_fatt1025);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt1027); 
					ast = new FirstNode(e);
					}
					break;
				case 10 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:211:4: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt1037); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt1039); 
					pushFollow(FOLLOW_exp_in_fatt1043);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt1045); 
					ast = new RestNode(e);
					}
					break;
				case 11 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:213:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt1056); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt1058); 
					pushFollow(FOLLOW_exp_in_fatt1062);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt1064); 
					ast = new PrintNode(e);
					}
					break;
				case 12 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:215:4: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt1079); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt1081); 
					pushFollow(FOLLOW_exp_in_fatt1085);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt1087); 
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:219:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:219:27: (p= primType |f= funParType )
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:220:9: p= primType
					{
					pushFollow(FOLLOW_primType_in_type1123);
					p=primType();
					state._fsp--;

					ast = p;
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:222:9: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type1149);
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:224:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:224:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:225:9: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType1179); 
			FunParType fpt = new FunParType();
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:226:13: (t= type ( COMMA t= type )* )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==BOOLTYPE||LA14_0==INTTYPE||(LA14_0 >= LISTTYPE && LA14_0 <= LPAR)) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:226:14: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType1198);
					t=type();
					state._fsp--;

					fpt.addPar(t);
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:227:17: ( COMMA t= type )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==COMMA) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:227:18: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType1219); 
							pushFollow(FOLLOW_type_in_funParType1223);
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

			match(input,RPAR,FOLLOW_RPAR_in_funParType1239); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType1241); 
			pushFollow(FOLLOW_primType_in_funParType1245);
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
	// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:230:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:231:2: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR )
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
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:231:4: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType1260); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:232:6: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType1272); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/federico/NetBeansProjects/Est2_nostro/src/Grammar/MiniFun.g:234:6: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType1287); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType1289); 
					pushFollow(FOLLOW_primType_in_primType1293);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType1295); 
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
	public static final BitSet FOLLOW_LET_in_let87 = new BitSet(new long[]{0x0001000001200000L});
	public static final BitSet FOLLOW_declist_in_let119 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_let121 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_let125 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist166 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist170 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist172 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_declist176 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASS_in_declist178 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_declist182 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist184 = new BitSet(new long[]{0x0001000000200002L});
	public static final BitSet FOLLOW_FUN_in_declist206 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist210 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist212 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist216 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_declist235 = new BitSet(new long[]{0x0000020000400000L});
	public static final BitSet FOLLOW_ID_in_declist241 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist243 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist247 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist252 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist256 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COL_in_declist258 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_declist262 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist285 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_declist290 = new BitSet(new long[]{0x0000898C14D90000L});
	public static final BitSet FOLLOW_let_in_declist298 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_exp_in_declist306 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_declist312 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist314 = new BitSet(new long[]{0x0001000000200002L});
	public static final BitSet FOLLOW_term_in_exp340 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_EQ_in_exp358 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp362 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_NOTEQ_in_exp394 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp398 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MINORE_in_exp424 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp428 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MAGGIORE_in_exp454 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp458 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MIN_in_exp484 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp488 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_MAG_in_exp513 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_term_in_exp517 = new BitSet(new long[]{0x00000011E0020002L});
	public static final BitSet FOLLOW_value_in_term561 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_PLUS_in_term577 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term581 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_MINUS_in_term602 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term606 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_OR_in_term629 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_value_in_term633 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_fatt_in_value668 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_TIMES_in_value685 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value689 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_DIV_in_value711 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value715 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_AND_in_value739 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_fatt_in_value743 = new BitSet(new long[]{0x0000400000002012L});
	public static final BitSet FOLLOW_NAT_in_fatt782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt831 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt835 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt851 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt866 = new BitSet(new long[]{0x00008B8C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt884 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_fatt895 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt899 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_fatt919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt954 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt958 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt960 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_fatt962 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt966 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt968 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_fatt976 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_fatt978 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt982 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt997 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1001 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt1003 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1007 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt1019 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt1021 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1025 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt1027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt1037 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt1039 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1043 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt1056 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt1058 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1062 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt1064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt1079 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt1081 = new BitSet(new long[]{0x0000898C10D90000L});
	public static final BitSet FOLLOW_exp_in_fatt1085 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt1087 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type1123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType1179 = new BitSet(new long[]{0x000002001A000100L});
	public static final BitSet FOLLOW_type_in_funParType1198 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_COMMA_in_funParType1219 = new BitSet(new long[]{0x000000001A000100L});
	public static final BitSet FOLLOW_type_in_funParType1223 = new BitSet(new long[]{0x0000020000000800L});
	public static final BitSet FOLLOW_RPAR_in_funParType1239 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ARROW_in_funParType1241 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_funParType1245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType1272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType1287 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType1289 = new BitSet(new long[]{0x000000000A000100L});
	public static final BitSet FOLLOW_primType_in_primType1293 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType1295 = new BitSet(new long[]{0x0000000000000002L});
}
