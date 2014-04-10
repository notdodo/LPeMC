grammar VM;

@header {
import java.util.HashMap;
import java.util.ArrayList;
}

@members {
      
    private int[] code = new int[ExecuteVM.CODESIZE];    
    private int i = 0;
    private HashMap<String,Integer> labelAddress = new HashMap<String,Integer>();
    private ArrayList<String> labels = new ArrayList<String>();
    private ArrayList<Integer> addresses  = new ArrayList<Integer>();
    
    public int[] createCode() throws Exception {
       assembly();
       return code;
    }
    
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

assembly: ( PUSH e=NUMBER   {code[i++] = PUSH; 
			     code[i++] = Integer.parseInt($e.text);}
	  | PUSH e=LABEL    {code[i++] = PUSH;
	    		     labels.add($e.text);
	  		     addresses.add(new Integer(i)); 
	  		     code[i++] = 0;} 		     
	  | POP		    {code[i++] = POP;}	
	  | ADD		    {code[i++] = ADD;}
	  | SUB		    {code[i++] = SUB;}
	  | MULT	    {code[i++] = MULT;}
	  | DIV		    {code[i++] = DIV;}
	  | STOREW	    {code[i++] = STOREW;}
	  | LOADW           {code[i++] = LOADW;}
	  | e=LABEL COL     {labelAddress.put($e.text,new Integer(i));}
	  | BRANCH e=LABEL  {code[i++] = BRANCH;
	  		     labels.add($e.text);
	  		     addresses.add(new Integer(i)); 
	  		     code[i++] = 0;}
	  | BRANCHEQ e=LABEL {code[i++] = BRANCHEQ;
	  	  	     labels.add($e.text);
	  		     addresses.add(new Integer(i)); 
	  		     code[i++] = 0;}
	  | BRANCHLESS e=LABEL {code[i++] = BRANCHLESS;
	  	  	     labels.add($e.text);
	  		     addresses.add(new Integer(i)); 
	  		     code[i++] = 0;}
	  | JS              {code[i++] = JS;}		     
	  | LOADRA          {code[i++] = LOADRA;}
	  | STORERA         {code[i++] = STORERA;} 
	  | LOADRV          {code[i++] = LOADRV;}
	  | STORERV         {code[i++] = STORERV;} 
	  | LOADFP          {code[i++] = LOADFP;}
	  | STOREFP         {code[i++] = STOREFP;}
	  | COPYFP          {code[i++] = COPYFP;}
	  | LOADHP          {code[i++] = LOADHP;}
	  | STOREHP         {code[i++] = STOREHP;}
	  | PRINT           {code[i++] = PRINT;}
	  | HALT            {code[i++] = HALT;}
	  )* {  for (int ind=0; ind<labels.size(); ind++) {
        	  Integer t = labelAddress.get(labels.get(ind));
        	  Integer a = addresses.get(ind);
		  code[a.intValue()]=t.intValue(); 
                }
              }
 ;
 	 
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH  	 : 'push' ; 	// constant in the stack
POP	 : 'pop' ; 	// decreases stack pointer
ADD	 : 'add' ;  	// add two values from the stack
SUB	 : 'sub' ;	// subtract two values from the stack
MULT	 : 'mult' ;  	// multiply two values from the stack
DIV	 : 'div' ;	// divide two values from the stack
STOREW	 : 'sw' ; 	// store in the memory, cell pointed by top the value next
LOADW	 : 'lw' ;	// load a value from the memory cell pointed by top
BRANCH	 : 'b' ;	// jump to label
BRANCHEQ : 'beq' ;	// jump to label if top == next
BRANCHLESS:'bless' ;	// jump to label if top < next
JS	 : 'js' ;	// jump to instruction pointed by top of stack 
			// and store next instruction in ra
LOADRA	 : 'lra' ;	// load from ra
STORERA  : 'sra' ;	// store top into ra	 
LOADRV	 : 'lrv' ;	// load from rv
STORERV  : 'srv' ;	// store top into rv	 
LOADFP	 : 'lfp' ;	// load frame pointer in the stack
STOREFP	 : 'sfp' ;	// store top into frame pointer
COPYFP   : 'cfp' ;      // copy stack pointer into frame pointer
LOADHP	 : 'lhp' ;	// load heap pointer in the stack
STOREHP	 : 'shp' ;	// store top into heap pointer
PRINT	 : 'print' ;	// print top of stack
HALT	 : 'halt' ;	// stop execution

COL	 : ':' ;
LABEL	 : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
NUMBER	 : '0' | ('-')?(('1'..'9')('0'..'9')*) ;

WHITESP  : ( '\t' | ' ' | '\r' | '\n' ) + {skip();};

COMMENT	 : ('// ' ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9' | ' ')*) + {skip();};

ERR   	 : . { System.out.println("Invalid char: "+$text); }; 

