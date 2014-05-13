// $ANTLR 3.5.1 D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g 2014-05-13 17:28:17

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
	@Override public String getGrammarFileName() { return "D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g"; }


	private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
	private ArrayList<HashMap<String,STentry>> symTableParType = new ArrayList<HashMap<String,STentry>>();     
	private int nestingLevel = 0;



	// $ANTLR start "prog"
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:27:1: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:27:27: (l= let )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:28:2: l= let
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:31:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:31:23: ( LET d= declist IN e= exp SEMIC )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:32:13: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let71); 

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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:51:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token f=null;
		Token fp=null;
		Token fpi=null;
		Node t =null;
		Node e =null;
		Node rt =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:51:42: ( ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:52:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
			            
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:65:13: ( VAR i= ID COL t= primType ASS e= exp SEMIC | FUN f= ID ( ALPAR i= ID ( COMMA i= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
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
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:66:21: VAR i= ID COL t= primType ASS e= exp SEMIC
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
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:81:21: FUN f= ID ( ALPAR i= ID ( COMMA i= ID )* ARPAR )? COL rt= type LPAR (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist305); 
					f=(Token)match(input,ID,FOLLOW_ID_in_declist311); 

					                	DecFunNode fn = new DecFunNode((f!=null?f.getText():null));
					                	
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:85:17: ( ALPAR i= ID ( COMMA i= ID )* ARPAR )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ALPAR) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:86:18: ALPAR i= ID ( COMMA i= ID )* ARPAR
							{
							match(input,ALPAR,FOLLOW_ALPAR_in_declist369); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist373); 
								
											offSetParType=1;
							                        	DecTypeNode tn = new DecTypeNode((i!=null?i.getText():null));
							                        	STentry entry = new STentry(tn,offSet++);
							                        	HashMap<String,STentry> hmType = symTableParType.get(nestingLevel);
							                        	hmType.put((i!=null?i.getText():null),entry);
							                    	
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:94:13: ( COMMA i= ID )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:95:15: COMMA i= ID
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist409); 
									i=(Token)match(input,ID,FOLLOW_ID_in_declist415); 

									           				entry = new STentry(tn,offSet++);
									                        			if (hmType.put((i!=null?i.getText():null),entry) != null) {
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

							match(input,ARPAR,FOLLOW_ARPAR_in_declist485); 

							        			fn.addParType(tn);
							        			
							        		
							}
							break;

					}

					match(input,COL,FOLLOW_COL_in_declist576); 
					pushFollow(FOLLOW_type_in_declist580);
					rt=type();
					state._fsp--;

					// dichiarazione di una funzione
					                       	fn.addRet(rt);
					                        STentry entry = new STentry(fn,offSet++);                        
					                        HashMap<String, STentry> hm = symTable.get(nestingLevel);
					                        HashMap<String, STentry> hmp = symTableParType.get(nestingLevel);
					                        System.out.println((f!=null?f.getText():null));
					                        if (hm.put((f!=null?f.getText():null), entry) != null) {
					                            System.out.println("Identifier " + (f!=null?f.getText():null)
					                            + " at line " + (f!=null?f.getLine():0) + " is already defined");
					                            System.exit(0);
					                        }
					                        
					                        
					                       
					                    
					match(input,LPAR,FOLLOW_LPAR_in_declist627); 

					                        int parOffSet = -1;
					                        ArrayList<Node> parList = new ArrayList<Node>();
					                        hm = new HashMap<String,STentry>();
					                        hmp = new HashMap<String,STentry>();
					                        symTable.add(hm);
					                        symTableParType.add(hmp); //Chiedere a Massi se e' corretto, dovrebbe esserlo
					                        nestingLevel++;
					                    
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:143:21: (fp= ID COL t= type ( COMMA fpi= ID COL t= type )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:144:25: fp= ID COL t= type ( COMMA fpi= ID COL t= type )*
							{
							fp=(Token)match(input,ID,FOLLOW_ID_in_declist700); 
							match(input,COL,FOLLOW_COL_in_declist702); 
							pushFollow(FOLLOW_type_in_declist706);
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
							                        
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:157:25: ( COMMA fpi= ID COL t= type )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:158:29: COMMA fpi= ID COL t= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist790); 
									fpi=(Token)match(input,ID,FOLLOW_ID_in_declist794); 
									match(input,COL,FOLLOW_COL_in_declist796); 
									pushFollow(FOLLOW_type_in_declist800);
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
					                
					match(input,RPAR,FOLLOW_RPAR_in_declist919); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist922); 
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:183:17: (e= let |e= exp )
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
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:184:21: e= let
							{
							pushFollow(FOLLOW_let_in_declist982);
							e=let();
							state._fsp--;


							                        fn.addLocal(((LetNode)e).getDecl());
							                    
							}
							break;
						case 2 :
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:189:21: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist1053);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist1089); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist1091); 

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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:202:1: exp returns [Node ast] : f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:202:23: (f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )* )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:203:13: f= term ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1153);
			f=term();
			state._fsp--;


			                ast = f;
			            
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:208:13: ( EQ l= term | NOTEQ l= term | MINEQ l= term | MAGEQ l= term | ALPAR l= term | ARPAR l= term )*
			loop7:
			while (true) {
				int alt7=7;
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
				case ALPAR:
					{
					alt7=5;
					}
					break;
				case ARPAR:
					{
					alt7=6;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:209:21: EQ l= term
					{
					match(input,EQ,FOLLOW_EQ_in_exp1218); 
					pushFollow(FOLLOW_term_in_exp1224);
					l=term();
					state._fsp--;

					 
					                        ast = new EqNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:214:21: NOTEQ l= term
					{
					match(input,NOTEQ,FOLLOW_NOTEQ_in_exp1285); 
					pushFollow(FOLLOW_term_in_exp1291);
					l=term();
					state._fsp--;

					 
					                        ast = new NotEqNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:220:21: MINEQ l= term
					{
					match(input,MINEQ,FOLLOW_MINEQ_in_exp1365); 
					pushFollow(FOLLOW_term_in_exp1371);
					l=term();
					state._fsp--;

					 
					                        ast = new MinEqNode(ast, l); 
					                    
					}
					break;
				case 4 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:226:21: MAGEQ l= term
					{
					match(input,MAGEQ,FOLLOW_MAGEQ_in_exp1445); 
					pushFollow(FOLLOW_term_in_exp1451);
					l=term();
					state._fsp--;

					 
					                        ast = new MagEqNode(ast, l); 
					                    
					}
					break;
				case 5 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:232:21: ALPAR l= term
					{
					match(input,ALPAR,FOLLOW_ALPAR_in_exp1525); 
					pushFollow(FOLLOW_term_in_exp1531);
					l=term();
					state._fsp--;

					 
					                        ast = new MinNode(ast, l); 
					                    
					}
					break;
				case 6 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:237:21: ARPAR l= term
					{
					match(input,ARPAR,FOLLOW_ARPAR_in_exp1594); 
					pushFollow(FOLLOW_term_in_exp1600);
					l=term();
					state._fsp--;

					 
					                        ast = new MagNode(ast, l); 
					                    
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:243:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:243:24: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:244:13: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term1673);
			f=value();
			state._fsp--;

			 
			                ast = f; 
			            
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:249:6: ( PLUS l= value | MINUS l= value | OR l= value )*
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
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:250:21: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term1730); 
					pushFollow(FOLLOW_value_in_term1736);
					l=value();
					state._fsp--;

					 
					                        ast = new PlusNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:256:21: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term1823); 
					pushFollow(FOLLOW_value_in_term1829);
					l=value();
					state._fsp--;

					 
					                        ast = new MinusNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:262:21: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term1916); 
					pushFollow(FOLLOW_value_in_term1922);
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:268:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:268:25: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:269:13: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value1984);
			f=fatt();
			state._fsp--;

			 
			                ast = f; 
			            
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:274:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
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
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:275:21: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value2042); 
					pushFollow(FOLLOW_fatt_in_value2048);
					l=fatt();
					state._fsp--;

					 
					                        ast = new TimesNode (ast,l); 
					                    
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:281:21: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value2135); 
					pushFollow(FOLLOW_fatt_in_value2141);
					l=fatt();
					state._fsp--;

					 
					                        ast = new DivNode(ast, l); 
					                    
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:287:21: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value2225); 
					pushFollow(FOLLOW_fatt_in_value2231);
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:293:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
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
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:293:24: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
			int alt13=12;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt13=1;
				}
				break;
			case TRUE:
				{
				alt13=2;
				}
				break;
			case FALSE:
				{
				alt13=3;
				}
				break;
			case EMPTY:
				{
				alt13=4;
				}
				break;
			case LPAR:
				{
				alt13=5;
				}
				break;
			case ID:
				{
				alt13=6;
				}
				break;
			case IF:
				{
				alt13=7;
				}
				break;
			case SLPAR:
				{
				alt13=8;
				}
				break;
			case FIRST:
				{
				alt13=9;
				}
				break;
			case REST:
				{
				alt13=10;
				}
				break;
			case PRINT:
				{
				alt13=11;
				}
				break;
			case NOT:
				{
				alt13=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:294:17: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt2297); 

					                    ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					                
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:299:17: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt2337); 

					                    ast = new BoolNode(true);
					                
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:304:17: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt2389); 

					                    ast = new BoolNode(false);
					                
					}
					break;
				case 4 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:309:17: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt2440); 

					                    ast = new EmptyNode();
					                
					}
					break;
				case 5 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:314:17: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt2493); 
					pushFollow(FOLLOW_exp_in_fatt2499);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt2501); 

					                    ast = e;
					                
					}
					break;
				case 6 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:319:17: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt2542); 

					                    HashMap<String,STentry> hm;
					                    HashMap<String,STentry> hmp;
					                    STentry entry = null;
					                    STentry entryPar=null;
					                    int declNL;
					                    int declNLPar;
					                    
					                    // controllo che esista una dichiarazione per quell'ID
					                   
					                    for(declNL = nestingLevel; declNL >= 0; declNL--) {
					                       hm = symTable.get(declNL);
					                       //System.out.println(declNL+"hm:"+hm+"\n\n");
					                       entry = hm.get((i!=null?i.getText():null));
					                        if (entry != null) 
					                            break;
					                    }
					                    if (entry == null){
									System.out.println("Identifier "+(i!=null?i.getText():null)+
					                            		" at line "+(i!=null?i.getLine():0)+" is not defined");
					                        		//System.exit(0);  
					                        		                 
					                    }
					                    
					                    for(declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
					                       		hmp = symTableParType.get(declNLPar);
					                       		//System.out.println(declNLPar+"hmp:"+hmp);
					                        	entryPar = hmp.get((i!=null?i.getText():null));
					                        	if (entryPar != null) 
					                            		break;
					                            		}
					                   if (entryPar == null){
									System.out.println("Type "+(i!=null?i.getText():null)+
					                            		" at line "+(i!=null?i.getLine():0)+" is not defined");
					                        		//System.exit(0);
					                        		}
					                   /* if (entry == null){
					                    	for(declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
					                       		hmp = symTableParType.get(declNLPar);
					                        	entryPar = hmp.get((i!=null?i.getText():null));
					                        	if (entryPar != null) 
					                            		break;
					                            		}}
					                    	 if(entryPar==null){
					                    //Non ci credo neanche un po'                    	
					                                   	System.out.println("Parameter "+(i!=null?i.getText():null)+
					                            		" at line "+(i!=null?i.getLine():0)+" is not defined");
					                        		System.exit(0);                   		
					                    			 }
					                    	
					                     */
					                    
					                                        
					                    if(entry.getDecl() instanceof DecFunNode || 
					                        (entry.getDecl() instanceof DecParNode && 
					                        ((DecParNode)entry.getDecl()).getType() instanceof FunParType)){
					                            ast = new FunParNode(entry,nestingLevel-declNL);
					                    } else {
					                    //System.out.println("VarNode "+ (i!=null?i.getText():null)+" "+(i!=null?i.getLine():0));
					                        ast = new VarNode(entry,nestingLevel-declNL); 
					                    }	  
					                
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:383:17: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==LPAR) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:384:21: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt2618); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:385:21: (fp= exp ( COMMA p= exp )* )?
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( (LA11_0==EMPTY||(LA11_0 >= FALSE && LA11_0 <= FIRST)||(LA11_0 >= ID && LA11_0 <= IF)||LA11_0==LPAR||(LA11_0 >= NAT && LA11_0 <= NOT)||(LA11_0 >= PRINT && LA11_0 <= REST)||LA11_0==SLPAR||LA11_0==TRUE) ) {
								alt11=1;
							}
							switch (alt11) {
								case 1 :
									// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:386:25: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt2672);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:387:25: ( COMMA p= exp )*
									loop10:
									while (true) {
										int alt10=2;
										int LA10_0 = input.LA(1);
										if ( (LA10_0==COMMA) ) {
											alt10=1;
										}

										switch (alt10) {
										case 1 :
											// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:388:29: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt2730); 
											pushFollow(FOLLOW_exp_in_fatt2736);
											p=exp();
											state._fsp--;

											parList.add(p);
											}
											break;

										default :
											break loop10;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt2811); 

							                        ast = new FunNode(entry,nestingLevel-declNL,parList);
							                    
							}
							break;

					}

					}
					break;
				case 7 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:397:17: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt2883); 
					pushFollow(FOLLOW_exp_in_fatt2889);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt2891); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2893); 
					pushFollow(FOLLOW_exp_in_fatt2899);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2901); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt2920); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt2922); 
					pushFollow(FOLLOW_exp_in_fatt2928);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt2930); 

					                    ast = new IfNode(x,y,z);
					                
					}
					break;
				case 8 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:403:17: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt2981); 
					pushFollow(FOLLOW_exp_in_fatt2987);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt2989); 
					pushFollow(FOLLOW_exp_in_fatt2995);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt2997); 

					                    ast = new ListNode(e1,e2);
					                
					}
					break;
				case 9 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:408:17: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt3047); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt3049); 
					pushFollow(FOLLOW_exp_in_fatt3055);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt3057); 

					                    ast = new FirstNode(e);
					                
					}
					break;
				case 10 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:413:17: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt3107); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt3109); 
					pushFollow(FOLLOW_exp_in_fatt3115);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt3117); 

					                    ast = new RestNode(e);
					                
					}
					break;
				case 11 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:418:17: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt3167); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt3169); 
					pushFollow(FOLLOW_exp_in_fatt3175);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt3177); 

					                    ast = new PrintNode(e);
					                
					}
					break;
				case 12 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:423:17: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt3231); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt3233); 
					pushFollow(FOLLOW_exp_in_fatt3239);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt3241); 

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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:429:1: type returns [Node ast] : (p= primType |f= funParType );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node p =null;
		Node f =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:429:27: (p= primType |f= funParType )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==BOOLTYPE||LA14_0==ID||LA14_0==INTTYPE||LA14_0==LISTTYPE) ) {
				alt14=1;
			}
			else if ( (LA14_0==LPAR) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:430:17: p= primType
					{
					pushFollow(FOLLOW_primType_in_type3301);
					p=primType();
					state._fsp--;


					                    ast = p;
					                
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:435:17: f= funParType
					{
					pushFollow(FOLLOW_funParType_in_type3355);
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:441:1: funParType returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType ;
	public final Node funParType() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node p =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:441:30: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType )
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:442:13: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW p= primType
			{
			match(input,LPAR,FOLLOW_LPAR_in_funParType3409); 

			                FunParType fpt = new FunParType();
			            
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:446:13: (t= type ( COMMA t= type )* )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BOOLTYPE||LA16_0==ID||LA16_0==INTTYPE||(LA16_0 >= LISTTYPE && LA16_0 <= LPAR)) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:447:17: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_funParType3463);
					t=type();
					state._fsp--;


					                    fpt.addPar(t);
					                
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:451:17: ( COMMA t= type )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==COMMA) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:452:21: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_funParType3522); 
							pushFollow(FOLLOW_type_in_funParType3528);
							t=type();
							state._fsp--;


							                        fpt.addPar(t);
							                    
							}
							break;

						default :
							break loop15;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_funParType3599); 
			match(input,ARROW,FOLLOW_ARROW_in_funParType3601); 
			pushFollow(FOLLOW_primType_in_funParType3607);
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
	// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:463:1: primType returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR |i= ID );
	public final Node primType() throws RecognitionException {
		Node ast = null;


		Token i=null;
		Node t =null;

		try {
			// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:463:28: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= primType SRPAR |i= ID )
			int alt17=4;
			switch ( input.LA(1) ) {
			case INTTYPE:
				{
				alt17=1;
				}
				break;
			case BOOLTYPE:
				{
				alt17=2;
				}
				break;
			case LISTTYPE:
				{
				alt17=3;
				}
				break;
			case ID:
				{
				alt17=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:464:17: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_primType3651); 

					                    ast = new IntTypeNode();
					                
					}
					break;
				case 2 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:469:17: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_primType3704); 

					                    ast = new BoolTypeNode();
					                
					}
					break;
				case 3 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:474:17: LISTTYPE SLPAR t= primType SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_primType3758); 
					match(input,SLPAR,FOLLOW_SLPAR_in_primType3760); 
					pushFollow(FOLLOW_primType_in_primType3765);
					t=primType();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_primType3767); 

					                    ast = new ListTypeNode(t);
					                
					}
					break;
				case 4 :
					// D:\\Develop\\NetBeans\\MiniFun_Project\\src\\Grammar\\MiniFun.g:478:15: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_primType3804); 

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



	public static final BitSet FOLLOW_let_in_prog43 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let71 = new BitSet(new long[]{0x0001000004800000L});
	public static final BitSet FOLLOW_declist_in_let117 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IN_in_let119 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_let125 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist220 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist226 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist228 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_declist234 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ASS_in_declist236 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_declist242 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist244 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_FUN_in_declist305 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist311 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_ALPAR_in_declist369 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist373 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_COMMA_in_declist409 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist415 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_ARPAR_in_declist485 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist576 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist580 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist627 = new BitSet(new long[]{0x0000020001000000L});
	public static final BitSet FOLLOW_ID_in_declist700 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist702 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist706 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_declist790 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist794 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COL_in_declist796 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_declist800 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_declist919 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_declist922 = new BitSet(new long[]{0x0000898C53640000L});
	public static final BitSet FOLLOW_let_in_declist982 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_exp_in_declist1053 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_declist1089 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist1091 = new BitSet(new long[]{0x0001000000800002L});
	public static final BitSet FOLLOW_term_in_exp1153 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_EQ_in_exp1218 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1224 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_NOTEQ_in_exp1285 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1291 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_MINEQ_in_exp1365 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1371 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_MAGEQ_in_exp1445 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1451 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_ALPAR_in_exp1525 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1531 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_ARPAR_in_exp1594 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_term_in_exp1600 = new BitSet(new long[]{0x0000001180080092L});
	public static final BitSet FOLLOW_value_in_term1673 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_PLUS_in_term1730 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1736 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_MINUS_in_term1823 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1829 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_OR_in_term1916 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_value_in_term1922 = new BitSet(new long[]{0x0000006200000002L});
	public static final BitSet FOLLOW_fatt_in_value1984 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_TIMES_in_value2042 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value2048 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_DIV_in_value2135 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value2141 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_AND_in_value2225 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_fatt_in_value2231 = new BitSet(new long[]{0x0000400000008022L});
	public static final BitSet FOLLOW_NAT_in_fatt2297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt2337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt2389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt2440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2493 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2499 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt2542 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt2618 = new BitSet(new long[]{0x00008B8C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2672 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_fatt2730 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2736 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_fatt2811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt2883 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2889 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt2891 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2893 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2899 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2901 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ELSE_in_fatt2920 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLPAR_in_fatt2922 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2928 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CRPAR_in_fatt2930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt2981 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2987 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt2989 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt2995 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt2997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt3047 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt3049 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt3055 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt3057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt3107 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt3109 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt3115 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt3117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt3167 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt3169 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt3175 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt3177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt3231 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt3233 = new BitSet(new long[]{0x0000898C43640000L});
	public static final BitSet FOLLOW_exp_in_fatt3239 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt3241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type3301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funParType_in_type3355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_funParType3409 = new BitSet(new long[]{0x0000020069000400L});
	public static final BitSet FOLLOW_type_in_funParType3463 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_COMMA_in_funParType3522 = new BitSet(new long[]{0x0000000069000400L});
	public static final BitSet FOLLOW_type_in_funParType3528 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_RPAR_in_funParType3599 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ARROW_in_funParType3601 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_funParType3607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_primType3651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_primType3704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_primType3758 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SLPAR_in_primType3760 = new BitSet(new long[]{0x0000000029000400L});
	public static final BitSet FOLLOW_primType_in_primType3765 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SRPAR_in_primType3767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_primType3804 = new BitSet(new long[]{0x0000000000000002L});
}
