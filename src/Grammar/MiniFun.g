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
l=let // creo un nono Prog principale
{$ast = new ProgNode($l.ast);};

let returns [Node ast]:
            LET
            // creo un nodo Let figlio di Prog o figlio di un altro nodo Let
            {
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
            }
            d = declist IN e = exp SEMIC
            {
                $ast = new LetNode($d.astList, $e.ast, localLet);
            };

declist returns [ArrayList<Node> astList]:
            {
                $astList= new ArrayList<Node>();
                int offSet;
                int offSetParType;
                // dal nestingLevel capisco se sono in una dichiarazione locale o gloabel
                // per la globale l'offSet va a 2 per l'indirizzamento dell'ActivationRecord
                if (nestingLevel == 0){
                    offSet = 1;
                } else {
                    offSet = 2;
                }
            }
                // dichiarazione di una variabile
            (
                    VAR i = ID COL t = primType ASS e = exp SEMIC
                    {
                        DecVarNode vn = new DecVarNode($i.text,$t.ast,$e.ast);
                        STentry entry = new STentry(vn,offSet++);
                        HashMap<String,STentry> hm = symTable.get(nestingLevel);
                        if (hm.put($i.text,entry) != null) {
                            System.out.println("Identifier " + $i.text
                               + " at line "+$i.line+" already defined");
                            System.exit(0);
                        }
                        // la dichiarazione viene aggiunta alla hashmap
                        //come il riferimento al nodo DecVar
                        $astList.add(vn);
                    }
                
                | FUN f = ID
                 {
                 DecFunNode fn = new DecFunNode($f.text);
                 }
                ( //inizio parte opzionale per la dichiarazione dei tipi parametrici
                 ALPAR i=ID
{
offSetParType=1;
                         DecTypeNode tn = new DecTypeNode($i.text);
                         STentry entry = new STentry(tn,offSet++);
                         HashMap<String,STentry> hmType = symTableParType.get(nestingLevel);
                         hmType.put($i.text,entry);
                     }
          (
            COMMA i = ID
            {
            entry = new STentry(tn,offSet++);
                         if (hmType.put($i.text,entry) != null) {
                             System.out.println("Parameter " + $i.text
                                + " at line "+$i.line+" already defined");
                             System.exit(0);
                         }
           
           }
           
           )*
           
         ARPAR
         {
         fn.addParType(tn);
        
         }
        
                )?

                
                        COL rt=type
                    {// dichiarazione di una funzione
                        fn.addRet($rt.ast);
                        STentry entry = new STentry(fn,offSet++);
                        HashMap<String, STentry> hm = symTable.get(nestingLevel);
                        HashMap<String, STentry> hmp = symTableParType.get(nestingLevel);
                        System.out.println($f.text);
                        if (hm.put($f.text, entry) != null) {
                            System.out.println("Identifier " + $f.text
                            + " at line " + $f.line + " is already defined");
                            System.exit(0);
                        }
                        
                        
                       
                    }
                    LPAR
                    {
                        int parOffSet = -1;
                        ArrayList<Node> parList = new ArrayList<Node>();
                        hm = new HashMap<String,STentry>();
                        hmp = new HashMap<String,STentry>();
                        symTable.add(hm);
                        symTableParType.add(hmp); //Chiedere a Massi se e' corretto, dovrebbe esserlo
                        nestingLevel++;
                    }
                    (
                        fp=ID COL t=type
                        {
                            DecParNode dpn;
                            if ($t.ast instanceof FunParType) {
                                parOffSet--;
                                dpn = new DecParNode($fp.text, $t.ast, true);
                            }else {
                                dpn = new DecParNode($fp.text, $t.ast);
                            }
                            entry = new STentry(dpn, parOffSet--);
                            hm.put($fp.text,entry);
                            parList.add(dpn);
                        }
                        (
                            COMMA fpi=ID COL t=type
                            {
                                if ($t.ast instanceof FunParType) {
                                    parOffSet--;
                                    //aggiunto fpi
                                    dpn = new DecParNode($fpi.text, $t.ast, true);
                                }else {
                                    //aggiunto fpi
                                    dpn = new DecParNode($fpi.text, $t.ast);
                                }
                                entry = new STentry(dpn, parOffSet--);
                                if (hm.put($fpi.text,entry) != null) {
                                    System.out.println("Identifier "+$fpi.text+
                                        " at line "+$fpi.line+" already defined");
                                    System.exit(0);
                                }
                                parList.add(dpn);
                            }
                        )*
                    )?
                {
                    fn.addPar(parList);
                }
                RPAR CLPAR
                // all'interno della funzione posso richiamare un let per funzioni o variabili locali
                (
                    e=let
                    {
                        fn.addLocal(((LetNode)$e.ast).getDecl());
                    }
                    |
                    e=exp
                )
                CRPAR SEMIC
                {
                    fn.addBody($e.ast); // aggiungo il body alla funzione (Let o espressione)
                    symTable.remove(nestingLevel);
                    symTableParType.remove(nestingLevel);
                    nestingLevel--;
                    $astList.add(fn);
                }
            )*;


exp returns [Node ast]:
            f=term
            {
                $ast = $f.ast;
            }
 
            ( // a (== b)*
                    EQ l = term
                    {
                        $ast = new EqNode ($ast,$l.ast);
                    }
             
                | NOTEQ l = term
                    {
                        $ast = new NotEqNode($ast, $l.ast);
                    }
 
                    // a <= b
                | MINEQ l = term
                    {
                        $ast = new MinEqNode($ast, $l.ast);
                    }
 
                    // a >= b
                | MAGEQ l = term
                    {
                        $ast = new MagEqNode($ast, $l.ast);
                    }
 
                    // a <= b
                | ALPAR l = term
                    {
                        $ast = new MinNode($ast, $l.ast);
                    }
                
                | ARPAR l = term
                    {
                        $ast = new MagNode($ast, $l.ast);
                    }
            )*;
 
term returns [Node ast]:
            f=value
            {
                $ast = $f.ast;
            }

( // a (+ b)*
                    PLUS l = value
                    {
                        $ast= new PlusNode ($ast,$l.ast);
                    }
                    
                    // a (- b)*
                | MINUS l = value
                    {
                        $ast = new MinusNode($ast, $l.ast);
                    }
                    
                    // a (|| b)*
                | OR l = value
                    {
                        $ast = new OrNode($ast, $l.ast);
                    }
  )*;

value returns [Node ast]:
            f = fatt
            {
                $ast= $f.ast;
            }

( // a (* b)*
                    TIMES l = fatt
                    {
                        $ast= new TimesNode ($ast,$l.ast);
                    }
                    
                    // a (/ b)*
                | DIV l = fatt
                    {
                        $ast = new DivNode($ast, $l.ast);
                    }
                
                    // a (&& b)*
                | AND l = fatt
                    {
                        $ast = new AndNode($ast, $l.ast);
                    }
  )*;
 
fatt returns [Node ast]:
                n=NAT
                {
                    $ast = new NatNode(Integer.parseInt($n.text));
                }
 
            | TRUE
                {
                    $ast = new BoolNode(true);
                }
            
            | FALSE
                {
                    $ast = new BoolNode(false);
                }
            
            | EMPTY
                {
                    $ast = new EmptyNode();
                }
            
            | LPAR e = exp RPAR
                {
                    $ast = $e.ast;
                }
  
            | i=ID
                {
                    HashMap<String,STentry> hm;
                    HashMap<String,STentry> hmp;
                    STentry entry = null;
                    STentry entryPar=null;
                    int declNL;
                    int declNLPar;
                    
                    // controllo che esista una dichiarazione per quell'ID
                   
                   for (declNL = nestingLevel; declNL >= 0; declNL--) {
                    hm = symTable.get(declNL);
                    entry = hm.get($i.text);
                    if (entry != null)
                    break;
                    hmp = symTableParType.get(declNL);
                    entry = hmp.get($i.text);
                    if (entry != null)
                    break;
                   }
                   
                   
   /*
                    for(declNL = nestingLevel; declNL >= 0; declNL--) {
                       hm = symTable.get(declNL);
                       //System.out.println(declNL+"hm:"+hm+"\n\n");
                       entry = hm.get($i.text);
                        if (entry != null)
                            break;
                    }
                    if (entry == null){
System.out.println("Identifier "+$i.text+
                             " at line "+$i.line+" is not defined");
                         //System.exit(0);
                        
                    }
                    
                    for(declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
                        hmp = symTableParType.get(declNLPar);
                        //System.out.println(declNLPar+"hmp:"+hmp);
                         entryPar = hmp.get($i.text);
                         if (entryPar != null)
                             break;
                             }
                   if (entryPar == null){
System.out.println("Type "+$i.text+
                             " at line "+$i.line+" is not defined");
                         //System.exit(0);
                         }
                   /* if (entry == null){
                     for(declNLPar = nestingLevel; declNLPar >= 0; declNLPar--) {
                        hmp = symTableParType.get(declNLPar);
                         entryPar = hmp.get($i.text);
                         if (entryPar != null)
                             break;
                             }}
                     if(entryPar==null){
                    //Non ci credo neanche un po'
                                    System.out.println("Parameter "+$i.text+
                             " at line "+$i.line+" is not defined");
                         System.exit(0);
                     }
                    
                     */
                    
                                   
                    if(entry.getDecl() instanceof DecFunNode ||
                        (entry.getDecl() instanceof DecParNode &&
                        ((DecParNode)entry.getDecl()).getType() instanceof FunParType) && entry != null){
                            $ast = new FunParNode(entry,nestingLevel-declNL);
                    } else {
                    //System.out.println("VarNode "+ $i.text+" "+$i.line);
                        $ast = new VarNode(entry,nestingLevel-declNL);
                    }
                }
                // l'ID e' una funzione -> controllo i parametri
                (
                    LPAR {ArrayList<Node> parList = new ArrayList<Node>();}
                    (
                        fp = exp {parList.add($fp.ast);}
                        (
                            COMMA p = exp {parList.add($p.ast);}
                        )*
                    )?
                    RPAR
                    {
                        $ast = new FunNode(entry,nestingLevel-declNL,parList);
                    }
                )?
            
            | IF x = exp THEN CLPAR y = exp CRPAR
                ELSE CLPAR z = exp CRPAR
                {
                    $ast = new IfNode($x.ast,$y.ast,$z.ast);
                }
            
            | SLPAR e1 = exp DOUBLCOL e2 = exp SRPAR
                {
                    $ast = new ListNode($e1.ast,$e2.ast);
                }
            
            | FIRST LPAR e = exp RPAR
                {
                    $ast = new FirstNode($e.ast);
                }
            
            | REST LPAR e = exp RPAR
                {
                    $ast= new RestNode($e.ast);
                }
            
            | PRINT LPAR e = exp RPAR
                {
                    $ast= new PrintNode($e.ast);
                }
            
            | NOT LPAR e = exp RPAR
                {
                    $ast = new NotNode($e.ast);
                }
  ;
  
type returns [Node ast]:
                p = primType
                {
                    $ast = $p.ast;
                }
            
            | f = funParType
                {
                    $ast = $f.ast;
                };
 
         
funParType returns [Node ast]:
            LPAR
            {
                FunParType fpt = new FunParType();
            }
            (
                t = type
                {
                    fpt.addPar($t.ast);
                }
                (
                    COMMA t = type
                    {
                        fpt.addPar($t.ast);
                    }
                )*
            )?
            RPAR ARROW p = primType
            {
                fpt.addRet($p.ast); $ast=fpt;
            };

primType returns [Node ast]:
                INTTYPE
                {
                    $ast = new IntTypeNode();
                }
            
            | BOOLTYPE
                {
                    $ast = new BoolTypeNode();
                }
                // tipo lista LIST:bool, LIST:int
            | LISTTYPE SLPAR t=primType (COMMA t2=primType)* SRPAR
                {
                    $ast = new ListTypeNode($t.ast);
                }
            | i=ID
             {
             $ast= new IdTypeNode($i.text);
             }
            
   ;
 
/*parType returns [Node ast]:
ALPAR i=ID
{
int offSet=0;
                        DecTypeNode tn = new DecTypeNode($i.text);
                        STentry entry = new STentry(tn,offSet++);
                        HashMap<String,STentry> hmType = symTableParType.get(nestingLevel);
                        if (hmType.put($i.text,entry) != null) {
                            System.out.println("Parameter " + $i.text
                               + " at line "+$i.line+" already defined");
                            System.exit(0);
                        }
                        
                    }
          (
           COMMA i = ID
           {
            entry = new STentry(tn,offSet++);
                        if (hmType.put($i.text,entry) != null) {
                            System.out.println("Parameter " + $i.text
                               + " at line "+$i.line+" already defined");
                            System.exit(0);
                        }
           
           }
           
           )*
           {
            $ast = tn;
           }
        ARPAR
        ;
       */
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
//MIN : '<';
//MAG : '>';
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