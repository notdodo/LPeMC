// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g 2014-04-11 19:15:47

    package Grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MiniFunLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public MiniFunLexer() {} 
	public MiniFunLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public MiniFunLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g"; }

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:397:6: ( 'let' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:397:8: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "APICI"
	public final void mAPICI() throws RecognitionException {
		try {
			int _type = APICI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:398:9: ( '\"' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:398:11: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "APICI"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:400:4: ( 'in' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:400:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:401:7: ( ';' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:401:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMIC"

	// $ANTLR start "COL"
	public final void mCOL() throws RecognitionException {
		try {
			int _type = COL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:402:5: ( ':' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:402:7: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COL"

	// $ANTLR start "DOUBLCOL"
	public final void mDOUBLCOL() throws RecognitionException {
		try {
			int _type = DOUBLCOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:403:9: ( '::' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:403:11: '::'
			{
			match("::"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLCOL"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:404:7: ( ',' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:404:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:405:5: ( '=' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:405:7: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASS"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:406:4: ( '==' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:406:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "MINEQ"
	public final void mMINEQ() throws RecognitionException {
		try {
			int _type = MINEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:407:7: ( '<=' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:407:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINEQ"

	// $ANTLR start "MAGEQ"
	public final void mMAGEQ() throws RecognitionException {
		try {
			int _type = MAGEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:408:7: ( '>=' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:408:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAGEQ"

	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:409:6: ( '<' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:409:8: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIN"

	// $ANTLR start "MAG"
	public final void mMAG() throws RecognitionException {
		try {
			int _type = MAG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:410:6: ( '>' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:410:8: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAG"

	// $ANTLR start "NOTEQ"
	public final void mNOTEQ() throws RecognitionException {
		try {
			int _type = NOTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:411:9: ( '!=' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:411:11: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQ"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:412:6: ( '+' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:412:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:413:7: ( '*' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:413:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:414:7: ( '-' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:414:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:415:4: ( '||' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:415:6: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:416:5: ( '&&' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:416:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:417:5: ( '/' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:417:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "NAT"
	public final void mNAT() throws RecognitionException {
		try {
			int _type = NAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:5: ( ( ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			else if ( (LA2_0=='0') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:8: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:18: ( '0' .. '9' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					}

					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:418:33: '0'
					{
					match('0'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:419:6: ( 'true' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:419:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:420:7: ( 'false' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:420:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:421:5: ( 'not' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:421:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "EMPTY"
	public final void mEMPTY() throws RecognitionException {
		try {
			int _type = EMPTY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:422:9: ( 'empty' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:422:11: 'empty'
			{
			match("empty"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EMPTY"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:423:6: ( 'var' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:423:8: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:424:6: ( 'fun' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:424:8: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:425:7: ( '->' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:425:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:426:7: ( '(' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:426:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:427:6: ( ')' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:427:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "CLPAR"
	public final void mCLPAR() throws RecognitionException {
		try {
			int _type = CLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:428:8: ( '{' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:428:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLPAR"

	// $ANTLR start "CRPAR"
	public final void mCRPAR() throws RecognitionException {
		try {
			int _type = CRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:429:7: ( '}' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:429:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CRPAR"

	// $ANTLR start "SLPAR"
	public final void mSLPAR() throws RecognitionException {
		try {
			int _type = SLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:430:8: ( '[' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:430:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLPAR"

	// $ANTLR start "SRPAR"
	public final void mSRPAR() throws RecognitionException {
		try {
			int _type = SRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:431:7: ( ']' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:431:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SRPAR"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:432:5: ( 'if' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:432:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:433:7: ( 'then' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:433:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:434:7: ( 'else' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:434:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:435:7: ( 'print' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:435:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "FIRST"
	public final void mFIRST() throws RecognitionException {
		try {
			int _type = FIRST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:436:9: ( 'first' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:436:11: 'first'
			{
			match("first"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIRST"

	// $ANTLR start "REST"
	public final void mREST() throws RecognitionException {
		try {
			int _type = REST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:437:9: ( 'rest' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:437:11: 'rest'
			{
			match("rest"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REST"

	// $ANTLR start "INTTYPE"
	public final void mINTTYPE() throws RecognitionException {
		try {
			int _type = INTTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:438:9: ( 'int' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:438:11: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTTYPE"

	// $ANTLR start "BOOLTYPE"
	public final void mBOOLTYPE() throws RecognitionException {
		try {
			int _type = BOOLTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:439:9: ( 'bool' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:439:11: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLTYPE"

	// $ANTLR start "LISTTYPE"
	public final void mLISTTYPE() throws RecognitionException {
		try {
			int _type = LISTTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:440:9: ( 'list' )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:440:11: 'list'
			{
			match("list"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LISTTYPE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:442:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:442:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:443:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:446:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:446:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:446:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESP"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:448:9: ( . )
			// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:448:11: .
			{
			matchAny(); 
			 System.out.println("Invalid char: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERR"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:8: ( LET | APICI | IN | SEMIC | COL | DOUBLCOL | COMMA | ASS | EQ | MINEQ | MAGEQ | MIN | MAG | NOTEQ | PLUS | TIMES | MINUS | OR | AND | DIV | NAT | TRUE | FALSE | NOT | EMPTY | VAR | FUN | ARROW | LPAR | RPAR | CLPAR | CRPAR | SLPAR | SRPAR | IF | THEN | ELSE | PRINT | FIRST | REST | INTTYPE | BOOLTYPE | LISTTYPE | ID | WHITESP | ERR )
		int alt5=46;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:10: LET
				{
				mLET(); 

				}
				break;
			case 2 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:14: APICI
				{
				mAPICI(); 

				}
				break;
			case 3 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:20: IN
				{
				mIN(); 

				}
				break;
			case 4 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:23: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 5 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:29: COL
				{
				mCOL(); 

				}
				break;
			case 6 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:33: DOUBLCOL
				{
				mDOUBLCOL(); 

				}
				break;
			case 7 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:42: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 8 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:48: ASS
				{
				mASS(); 

				}
				break;
			case 9 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:52: EQ
				{
				mEQ(); 

				}
				break;
			case 10 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:55: MINEQ
				{
				mMINEQ(); 

				}
				break;
			case 11 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:61: MAGEQ
				{
				mMAGEQ(); 

				}
				break;
			case 12 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:67: MIN
				{
				mMIN(); 

				}
				break;
			case 13 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:71: MAG
				{
				mMAG(); 

				}
				break;
			case 14 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:75: NOTEQ
				{
				mNOTEQ(); 

				}
				break;
			case 15 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:81: PLUS
				{
				mPLUS(); 

				}
				break;
			case 16 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:86: TIMES
				{
				mTIMES(); 

				}
				break;
			case 17 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:92: MINUS
				{
				mMINUS(); 

				}
				break;
			case 18 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:98: OR
				{
				mOR(); 

				}
				break;
			case 19 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:101: AND
				{
				mAND(); 

				}
				break;
			case 20 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:105: DIV
				{
				mDIV(); 

				}
				break;
			case 21 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:109: NAT
				{
				mNAT(); 

				}
				break;
			case 22 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:113: TRUE
				{
				mTRUE(); 

				}
				break;
			case 23 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:118: FALSE
				{
				mFALSE(); 

				}
				break;
			case 24 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:124: NOT
				{
				mNOT(); 

				}
				break;
			case 25 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:128: EMPTY
				{
				mEMPTY(); 

				}
				break;
			case 26 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:134: VAR
				{
				mVAR(); 

				}
				break;
			case 27 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:138: FUN
				{
				mFUN(); 

				}
				break;
			case 28 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:142: ARROW
				{
				mARROW(); 

				}
				break;
			case 29 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:148: LPAR
				{
				mLPAR(); 

				}
				break;
			case 30 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:153: RPAR
				{
				mRPAR(); 

				}
				break;
			case 31 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:158: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 32 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:164: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 33 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:170: SLPAR
				{
				mSLPAR(); 

				}
				break;
			case 34 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:176: SRPAR
				{
				mSRPAR(); 

				}
				break;
			case 35 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:182: IF
				{
				mIF(); 

				}
				break;
			case 36 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:185: THEN
				{
				mTHEN(); 

				}
				break;
			case 37 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:190: ELSE
				{
				mELSE(); 

				}
				break;
			case 38 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:195: PRINT
				{
				mPRINT(); 

				}
				break;
			case 39 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:201: FIRST
				{
				mFIRST(); 

				}
				break;
			case 40 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:207: REST
				{
				mREST(); 

				}
				break;
			case 41 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:212: INTTYPE
				{
				mINTTYPE(); 

				}
				break;
			case 42 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:220: BOOLTYPE
				{
				mBOOLTYPE(); 

				}
				break;
			case 43 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:229: LISTTYPE
				{
				mLISTTYPE(); 

				}
				break;
			case 44 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:238: ID
				{
				mID(); 

				}
				break;
			case 45 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:241: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 46 :
				// /home/edoardo/NetBeansProjects/LPeMC/src/Grammar/MiniFun.g:1:249: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\1\46\1\uffff\1\46\1\uffff\1\54\1\uffff\1\57\1\61\1\63\1\43\2"+
		"\uffff\1\70\2\43\3\uffff\5\46\6\uffff\3\46\3\uffff\2\46\2\uffff\1\123"+
		"\1\124\23\uffff\11\46\6\uffff\3\46\1\uffff\1\141\1\46\1\143\2\uffff\3"+
		"\46\1\147\1\46\1\151\2\46\1\154\3\46\1\uffff\1\160\1\uffff\1\161\1\162"+
		"\1\46\1\uffff\1\46\1\uffff\1\46\1\166\1\uffff\1\46\1\170\1\171\3\uffff"+
		"\1\172\1\173\1\174\1\uffff\1\175\6\uffff";
	static final String DFA5_eofS =
		"\176\uffff";
	static final String DFA5_minS =
		"\1\0\1\145\1\uffff\1\146\1\uffff\1\72\1\uffff\4\75\2\uffff\1\76\1\174"+
		"\1\46\3\uffff\1\150\1\141\1\157\1\154\1\141\6\uffff\1\162\1\145\1\157"+
		"\3\uffff\1\164\1\163\2\uffff\2\60\23\uffff\1\165\1\145\1\154\1\156\1\162"+
		"\1\164\1\160\1\163\1\162\6\uffff\1\151\1\163\1\157\1\uffff\1\60\1\164"+
		"\1\60\2\uffff\1\145\1\156\1\163\1\60\1\163\1\60\1\164\1\145\1\60\1\156"+
		"\1\164\1\154\1\uffff\1\60\1\uffff\2\60\1\145\1\uffff\1\164\1\uffff\1\171"+
		"\1\60\1\uffff\1\164\2\60\3\uffff\3\60\1\uffff\1\60\6\uffff";
	static final String DFA5_maxS =
		"\1\uffff\1\151\1\uffff\1\156\1\uffff\1\72\1\uffff\4\75\2\uffff\1\76\1"+
		"\174\1\46\3\uffff\1\162\1\165\1\157\1\155\1\141\6\uffff\1\162\1\145\1"+
		"\157\3\uffff\1\164\1\163\2\uffff\2\172\23\uffff\1\165\1\145\1\154\1\156"+
		"\1\162\1\164\1\160\1\163\1\162\6\uffff\1\151\1\163\1\157\1\uffff\1\172"+
		"\1\164\1\172\2\uffff\1\145\1\156\1\163\1\172\1\163\1\172\1\164\1\145\1"+
		"\172\1\156\1\164\1\154\1\uffff\1\172\1\uffff\2\172\1\145\1\uffff\1\164"+
		"\1\uffff\1\171\1\172\1\uffff\1\164\2\172\3\uffff\3\172\1\uffff\1\172\6"+
		"\uffff";
	static final String DFA5_acceptS =
		"\2\uffff\1\2\1\uffff\1\4\1\uffff\1\7\4\uffff\1\17\1\20\3\uffff\1\24\2"+
		"\25\5\uffff\1\35\1\36\1\37\1\40\1\41\1\42\3\uffff\1\54\1\55\1\56\2\uffff"+
		"\1\54\1\2\2\uffff\1\4\1\6\1\5\1\7\1\11\1\10\1\12\1\14\1\13\1\15\1\16\1"+
		"\17\1\20\1\34\1\21\1\22\1\23\1\24\1\25\11\uffff\1\35\1\36\1\37\1\40\1"+
		"\41\1\42\3\uffff\1\55\3\uffff\1\3\1\43\14\uffff\1\1\1\uffff\1\51\3\uffff"+
		"\1\33\1\uffff\1\30\2\uffff\1\32\3\uffff\1\53\1\26\1\44\3\uffff\1\45\1"+
		"\uffff\1\50\1\52\1\27\1\47\1\31\1\46";
	static final String DFA5_specialS =
		"\1\0\175\uffff}>";
	static final String[] DFA5_transitionS = {
			"\11\43\2\42\2\43\1\42\22\43\1\42\1\12\1\2\3\43\1\17\1\43\1\30\1\31\1"+
			"\14\1\13\1\6\1\15\1\43\1\20\1\22\11\21\1\5\1\4\1\10\1\7\1\11\2\43\32"+
			"\41\1\34\1\43\1\35\3\43\1\41\1\40\2\41\1\26\1\24\2\41\1\3\2\41\1\1\1"+
			"\41\1\25\1\41\1\36\1\41\1\37\1\41\1\23\1\41\1\27\4\41\1\32\1\16\1\33"+
			"\uff82\43",
			"\1\44\3\uffff\1\45",
			"",
			"\1\51\7\uffff\1\50",
			"",
			"\1\53",
			"",
			"\1\56",
			"\1\60",
			"\1\62",
			"\1\64",
			"",
			"",
			"\1\67",
			"\1\71",
			"\1\72",
			"",
			"",
			"",
			"\1\76\11\uffff\1\75",
			"\1\77\7\uffff\1\101\13\uffff\1\100",
			"\1\102",
			"\1\104\1\103",
			"\1\105",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\114",
			"\1\115",
			"\1\116",
			"",
			"",
			"",
			"\1\120",
			"\1\121",
			"",
			"",
			"\12\46\7\uffff\32\46\6\uffff\23\46\1\122\6\46",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\136",
			"\1\137",
			"\1\140",
			"",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\1\142",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"",
			"\1\144",
			"\1\145",
			"\1\146",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\1\150",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\1\152",
			"\1\153",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\1\155",
			"\1\156",
			"\1\157",
			"",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\1\163",
			"",
			"\1\164",
			"",
			"\1\165",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"\1\167",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"",
			"",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( LET | APICI | IN | SEMIC | COL | DOUBLCOL | COMMA | ASS | EQ | MINEQ | MAGEQ | MIN | MAG | NOTEQ | PLUS | TIMES | MINUS | OR | AND | DIV | NAT | TRUE | FALSE | NOT | EMPTY | VAR | FUN | ARROW | LPAR | RPAR | CLPAR | CRPAR | SLPAR | SRPAR | IF | THEN | ELSE | PRINT | FIRST | REST | INTTYPE | BOOLTYPE | LISTTYPE | ID | WHITESP | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA5_0 = input.LA(1);
						s = -1;
						if ( (LA5_0=='l') ) {s = 1;}
						else if ( (LA5_0=='\"') ) {s = 2;}
						else if ( (LA5_0=='i') ) {s = 3;}
						else if ( (LA5_0==';') ) {s = 4;}
						else if ( (LA5_0==':') ) {s = 5;}
						else if ( (LA5_0==',') ) {s = 6;}
						else if ( (LA5_0=='=') ) {s = 7;}
						else if ( (LA5_0=='<') ) {s = 8;}
						else if ( (LA5_0=='>') ) {s = 9;}
						else if ( (LA5_0=='!') ) {s = 10;}
						else if ( (LA5_0=='+') ) {s = 11;}
						else if ( (LA5_0=='*') ) {s = 12;}
						else if ( (LA5_0=='-') ) {s = 13;}
						else if ( (LA5_0=='|') ) {s = 14;}
						else if ( (LA5_0=='&') ) {s = 15;}
						else if ( (LA5_0=='/') ) {s = 16;}
						else if ( ((LA5_0 >= '1' && LA5_0 <= '9')) ) {s = 17;}
						else if ( (LA5_0=='0') ) {s = 18;}
						else if ( (LA5_0=='t') ) {s = 19;}
						else if ( (LA5_0=='f') ) {s = 20;}
						else if ( (LA5_0=='n') ) {s = 21;}
						else if ( (LA5_0=='e') ) {s = 22;}
						else if ( (LA5_0=='v') ) {s = 23;}
						else if ( (LA5_0=='(') ) {s = 24;}
						else if ( (LA5_0==')') ) {s = 25;}
						else if ( (LA5_0=='{') ) {s = 26;}
						else if ( (LA5_0=='}') ) {s = 27;}
						else if ( (LA5_0=='[') ) {s = 28;}
						else if ( (LA5_0==']') ) {s = 29;}
						else if ( (LA5_0=='p') ) {s = 30;}
						else if ( (LA5_0=='r') ) {s = 31;}
						else if ( (LA5_0=='b') ) {s = 32;}
						else if ( ((LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='a'||(LA5_0 >= 'c' && LA5_0 <= 'd')||(LA5_0 >= 'g' && LA5_0 <= 'h')||(LA5_0 >= 'j' && LA5_0 <= 'k')||LA5_0=='m'||LA5_0=='o'||LA5_0=='q'||LA5_0=='s'||LA5_0=='u'||(LA5_0 >= 'w' && LA5_0 <= 'z')) ) {s = 33;}
						else if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {s = 34;}
						else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\b')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\u001F')||(LA5_0 >= '#' && LA5_0 <= '%')||LA5_0=='\''||LA5_0=='.'||(LA5_0 >= '?' && LA5_0 <= '@')||LA5_0=='\\'||(LA5_0 >= '^' && LA5_0 <= '`')||(LA5_0 >= '~' && LA5_0 <= '\uFFFF')) ) {s = 35;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 5, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
