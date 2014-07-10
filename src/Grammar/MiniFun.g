grammar MiniFun;

@lexer::header {
package Grammar;
}

@header {
package Grammar;
import Generics.*;
import Type.*;
import Logic.*;
import Math.*;
import List.*;
import java.util.HashMap;
import java.util.ArrayList;
}

@members {
private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
private ArrayList<HashMap<String,STentry>> symTableParType = new ArrayList<HashMap<String,STentry>>();
private int nestingLevel = 0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
prog returns [Node ast]:
	// creo un nono Prog principale
	l=let {$ast = new ProgNode($l.ast);};

let returns [Node ast]:
	// creo un nodo Let figlio di Prog o figlio di un altro nodo Let
            LET	{boolean localLet = false;
            	 HashMap<String,STentry> hm = new HashMap<String,STentry>();
            	 HashMap<String,STentry> hmp = new HashMap<String,STentry>();
            	 // creo una hashmap per lo scope attuale
            	 if (nestingLevel == 0){
            	 	symTable.add(hm);
            	 	symTableParType.add(hmp);
                	} else {
                		localLet=true;
                	}}
                	d = declist IN e = exp SEMIC {$ast = new LetNode($d.astList, $e.ast, localLet);};

declist returns [ArrayList<Node> astList]:
           {$astList= new ArrayList<Node>();
	int offSet;
            int offSetParType;
            // dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
            // per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
            if (nestingLevel == 0) {
            	offSet = 1;
	} else {
            	offSet = 2;
            }}
            // dichiarazione di una variabile
            (VAR i = ID COL t = primType ASS e = exp SEMIC   {DecVarNode vn = new DecVarNode($i.text,$t.ast,$e.ast);
            							STentry entry = new STentry(vn,offSet++);
                        						HashMap<String,STentry> hm = symTable.get(nestingLevel);
                        						if (hm.put($i.text,entry) != null) {
                            							System.out.println("Identifier " + $i.text + " at line "+$i.line+" already defined");
                           							System.exit(0);
                           						}
                           						// la dichiarazione viene aggiunta alla hashmap, come il riferimento al nodo DecVar
                        						$astList.add(vn);}
                | FUN f = ID {ArrayList<Node> paramTypes = new ArrayList<Node>();
                 		 DecFunNode fn = new DecFunNode($f.text);
                 		 STentry entry = new STentry(fn,offSet++);
                 		 HashMap<String, STentry> hm = symTable.get(nestingLevel);
                 		 if (hm.put($f.text, entry) != null) {
                 		 	System.out.println("Identifier " + $f.text + " at line " + $f.line + " is already defined");
                            		System.exit(0);
                 		 }
                 		 hm = new HashMap<String, STentry>();
                 		 symTable.add(hm);
                 		 HashMap<String,STentry> hmType = new HashMap<String, STentry>();
                 		 symTableParType.add(hmType);
                 		 nestingLevel++;}
                	//inizio parte opzionale per la dichiarazione dei tipi parametrici
                	(ALPAR i=ID   {DecTypeNode tn = new DecTypeNode($i.text);
                			paramTypes.add(tn);
                			entry = new STentry(tn, 0);
                         		hmType.put($i.text, entry);}
           			(COMMA i2 = ID {DecTypeNode tn2 = new DecTypeNode($i2.text);
             				    paramTypes.add(tn2);
             				    entry = new STentry(tn2, 0);
             				    if (hmType.put($i2.text,entry) != null) {
                             				System.out.println("Parameter " + $i.text + " at line "+$i.line+" already defined");
                             				System.exit(0);
                       				    }})*
                       	ARPAR {fn.addParType(paramTypes);})?
                       		COL rt=type {fn.addRet($rt.ast);} LPAR {int parOffSet = -1;
                       							     ArrayList<Node> parList = new ArrayList<Node>();}
                    			(fp=ID COL t=type    {DecParNode dpn;
                    						if ($t.ast instanceof FunParType) {
                    							parOffSet--;
                                						dpn = new DecParNode($fp.text, $t.ast, true);
                            					}else {
                                						dpn = new DecParNode($fp.text, $t.ast);
                            					}
                            					entry = new STentry(dpn, parOffSet--);
                            					hm.put($fp.text,entry);
                            					parList.add(dpn);}
                        			(COMMA fpi=ID COL t=type {if ($t.ast instanceof FunParType) {
                                    							parOffSet--;
                                    							//aggiunto fpi
                                    							dpn = new DecParNode($fpi.text, $t.ast, true);
                                							} else {
                                    							//aggiunto fpi
                                    							dpn = new DecParNode($fpi.text, $t.ast);
                                							}
                                							entry = new STentry(dpn, parOffSet--);
                                							if (hm.put($fpi.text,entry) != null) {
                                    							System.out.println("Identifier " + $fpi.text + " at line " + $fpi.line + " already defined");
                                    							System.exit(0);
                                							}
                                							parList.add(dpn);})*
                                		)? {fn.addPar(parList);}
                                	RPAR CLPAR
                		// all'interno della funzione posso richiamare un let per funzioni o variabili locali
                			(e=let {fn.addLocal(((LetNode)$e.ast).getDecl());}
                			 |
                			 e=exp)
                			 CRPAR SEMIC {fn.addBody($e.ast);
                			 		  symTable.remove(nestingLevel);
                			 		  symTableParType.remove(nestingLevel);
                			 		  nestingLevel--;
                			 		  $astList.add(fn);}
	)*;


exp returns [Node ast]:
	f=term {$ast = $f.ast;}
		(EQ l = term {$ast = new EqNode ($ast,$l.ast);}             
                	| NOTEQ l = term {$ast = new NotEqNode($ast, $l.ast);}
 		| MINEQ l = term {$ast = new MinEqNode($ast, $l.ast);}
 		| MAGEQ l = term {$ast = new MagEqNode($ast, $l.ast);}
            )*;
 
term returns [Node ast]:
	f=value {$ast = $f.ast;}
		(PLUS l = value {$ast= new PlusNode ($ast,$l.ast);}
                    	| MINUS l = value {$ast = new MinusNode($ast, $l.ast);}
                    	| OR l = value {$ast = new OrNode($ast, $l.ast);}
            )*;

value returns [Node ast]:
            f = fatt {$ast= $f.ast;}
		(TIMES l = fatt {$ast= new TimesNode ($ast,$l.ast);}
                    	| DIV l = fatt {$ast = new DivNode($ast, $l.ast);}
                	| AND l = fatt {$ast = new AndNode($ast, $l.ast);}
            )*;
 
fatt returns [Node ast]:
	n=NAT {$ast = new NatNode(Integer.parseInt($n.text));}
 	| TRUE {$ast = new BoolNode(true);}            
            | FALSE {$ast = new BoolNode(false);}
            | EMPTY {$ast = new EmptyNode();}            
            | LPAR e = exp RPAR {$ast = $e.ast;}  
            | i=ID  {ArrayList<Node> paramTypes = new ArrayList<Node>();}
            	(ALPAR p1=primType {paramTypes.add($p1.ast);}
                		(COMMA p2=primType {paramTypes.add($p2.ast);})*
                	ARPAR)? 
            	{HashMap<String,STentry> hm;
                    	STentry entry = null;
                    	int declNL;          
                    	FunParNode fpn = null;
                   	 // controllo che esista una dichiarazione per quell'ID
                   	for (declNL = nestingLevel; declNL >= 0; declNL--) {
                    		hm = symTable.get(declNL);
                    		entry = hm.get($i.text);
                    		if (entry != null)
                    			break;
                  	}
                  	if (entry == null) {
                    		System.out.println("Identifier " + $i.text + " at line " + $i.line + " is not defined");
                     		System.exit(0);
                   	}
                   	if(entry.getDecl() instanceof DecFunNode ||
                        	(entry.getDecl() instanceof DecParNode && ((DecParNode)entry.getDecl()).getType() instanceof FunParType) && entry != null) {
                        	fpn = new FunParNode(entry,nestingLevel-declNL);
                        	fpn.addParType(paramTypes);
                        	$ast = fpn;
                    	} else {
                    		$ast = new VarNode(entry,nestingLevel-declNL);
                    	}}
                	// l'ID e' una funzione -> controllo i parametri
                	(LPAR {ArrayList<Node> parList = new ArrayList<Node>();}
                    		(fp = exp {parList.add($fp.ast);}
                    			(COMMA p = exp {parList.add($p.ast);})*
                    		)?
                    	RPAR {FunNode fn = new FunNode(entry,nestingLevel-declNL,parList);
                    		fn.addParType(paramTypes);
                    		$ast = fn;}
                    	)?
            | IF x = exp THEN CLPAR 
            	y = exp 
           	 CRPAR ELSE CLPAR 
           	 	z = exp 
           	 CRPAR {$ast = new IfNode($x.ast,$y.ast,$z.ast);}
            | SLPAR e1 = exp DOUBLCOL e2 = exp SRPAR {$ast = new ListNode($e1.ast,$e2.ast);}            
            | FIRST LPAR e = exp RPAR {$ast = new FirstNode($e.ast);}
            | REST LPAR e = exp RPAR {$ast= new RestNode($e.ast);}            
            | PRINT LPAR e = exp RPAR {$ast= new PrintNode($e.ast);}            
            | NOT LPAR e = exp RPAR {$ast = new NotNode($e.ast);}
            ;
  
type returns [Node ast]:
	p = primType {$ast = $p.ast;}            
            | f = funParType {$ast = $f.ast;};
                    
funParType returns [Node ast]:
            LPAR {FunParType fpt = new FunParType();}
            	(t = type {fpt.addPar($t.ast);}
                		(COMMA t = type {fpt.addPar($t.ast);})*
            	)?
            RPAR ARROW p = primType {fpt.addRet($p.ast); $ast=fpt;};

primType returns [Node ast]:
	INTTYPE {$ast = new IntTypeNode();}
            | BOOLTYPE {$ast = new BoolTypeNode();}
            | LISTTYPE SLPAR t=primType (COMMA t2=primType)* SRPAR {$ast = new ListTypeNode($t.ast);}
            | i=ID {HashMap<String,STentry> hmp;
                       STentry entryPar=null;
                       for(int declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
              		hmp = symTableParType.get(declNLPar);
                      		entryPar = hmp.get($i.text);
                      		if (entryPar != null)
                          		break;
                       }
                       if (entryPar == null) {
			System.out.println("Parameter Type " + $i.text + " at line " + $i.line + " is not defined");
                          	System.exit(0);
                       }
                       $ast= new IdTypeNode(entryPar);}
	;
	
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
LET : 'let' ;
APICI : '"';

IN : 'in' ;
SEMIC : ';' ;
COL : ':' ;
DOUBLCOL: '::' ;
COMMA : ',' ;
ASS : '=' ;
EQ : '==' ;
MINEQ : '<='; //estensione1
MAGEQ : '>='; //estensione1
NOTEQ : '!=';
PLUS : '+' ;
TIMES : '*' ;
MINUS : '-'; //estensione1
OR : '||'; //estensione1
AND : '&&'; //estensione1
DIV : '/'; //estensione1
NAT : (('1'..'9')('0'..'9')*) | '0';
TRUE : 'true' ;
FALSE : 'false' ;
NOT : 'not'; //estensione1
EMPTY : 'empty';
VAR : 'var' ;
FUN : 'fun' ;
ARROW : '->';
LPAR : '(' ;
RPAR : ')' ;
CLPAR : '{' ;
CRPAR : '}' ;
SLPAR : '[' ;
SRPAR : ']' ;
ALPAR : '<';
ARPAR : '>';
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
PRINT : 'print' ;
FIRST : 'first' ;
REST : 'rest' ;
INTTYPE : 'int' ;
BOOLTYPE: 'bool' ;
LISTTYPE: 'list';

ID : ('a'..'z'|'A'..'Z')
  ('a'..'z'|'A'..'Z'|'0'..'9')* ;

WHITESP : ( '\t' | ' ' | '\r' | '\n' )+ { skip(); } ;
 
ERR : . { System.out.println("Invalid char: "+$text); };