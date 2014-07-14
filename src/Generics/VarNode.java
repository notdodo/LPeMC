package Generics;

/**
 * Classe per la creazione di un nodo per una variabile
 */
public class VarNode extends Node {

    private final STentry decl;
    private final int diffNesting;

    /**
     * @param d Identifica la dichiarazione della variabile
     * @param dn Identifica la posizione della variabile
     */
    public VarNode(STentry d, int dn) {
        decl = d;
        diffNesting = dn;
    }

    @Override
    public String toPrint() {
        return "VarNode"
                + "[" + diffNesting + ","
                + decl.getOffSet() + "]";
    }

    @Override
    public String typeCheck() {
        return decl.getDecl().typeCheck();
    }

    @Override
    public String codeGen() {

        String lookupAL = "";

        for (int i = 0; i < diffNesting; i++) {
            lookupAL += MiniFunLib.LOADW;
        }

        return MiniFunLib.LOADFP
                + lookupAL
                + MiniFunLib.PUSH + decl.getOffSet() + "\n"
                + MiniFunLib.SUB
                + MiniFunLib.LOADW;
    }

}
