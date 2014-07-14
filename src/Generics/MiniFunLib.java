package Generics;

/**
 * Classe che contiene le stringe per la generazione del codice e delle funzioni
 * utility
 */
public class MiniFunLib {

    public static final String INT = "Int";
    public static final String BOOL = "Bool";
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public static final int NULLPOINTER = -1;
    public static final String EMPTY = "Empty";
    public static final String LIST = "List:";
    public static final String TYPE = "Type:";

    private static int labIndex = 0;
    private static String functionCode = "";

    public static final String PUSH = "push ";
    public static final String POP = "pop\n";
    public static final String ADD = "add\n";
    public static final String SUB = "sub\n";
    public static final String MULT = "mult\n";
    public static final String DIV = "div\n";
    public static final String STOREW = "sw\n";
    public static final String LOADW = "lw\n";
    public static final String BRANCH = "b ";
    public static final String BRANCHEQ = "beq ";
    public static final String BRANCHLESS = "bless ";
    public static final String JS = "js\n";
    public static final String LOADRA = "lra\n";
    public static final String STORERA = "sra\n";
    public static final String LOADRV = "lrv\n";
    public static final String STORERV = "srv\n";
    public static final String LOADFP = "lfp\n";
    public static final String STOREFP = "sfp\n";
    public static final String COPYFP = "cfp\n";
    public static final String LOADHP = "lhp\n";
    public static final String STOREHP = "shp\n";
    public static final String PRINT = "print\n";
    public static final String HALT = "halt\n";

    /**
     * Controlla il tipo di n1 e n2, se sono liste controlla che siano
     * compatibili (EMPTY è una lista)
     */
    public static boolean isCompatible(Node n1, Node n2) {
        if ((n1.typeCheck().equals(n2.typeCheck())
                || (n1.typeCheck().indexOf(MiniFunLib.LIST) == 0 && n2.typeCheck().equals(MiniFunLib.EMPTY)))
                || (n2.typeCheck().indexOf(MiniFunLib.LIST) == 0 && n1.typeCheck().equals(MiniFunLib.EMPTY))) {
            return true;
        }
        System.err.println("===\nn1.typeCheck = " + n1.typeCheck() + "\nn2.typeCheck = " + n2.typeCheck() + "\nn1.getClass = " + n1.getClass() + "\nn2.getClass = " + n2.getClass());
        return false;
    }

    /**
     * @return Una nuova label
     */
    public static String newLabel() {
        return "lab" + labIndex++;
    }

    /**
     * Appende il codice della funzione
     */
    public static void addFunctionCode(String code) {
        functionCode += code;
    }

    /**
     * Recupera il codice della funzione
     */
    public static String getFunctionCode() {
        return functionCode;
    }

}
