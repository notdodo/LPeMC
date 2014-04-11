package Generics;

public class VarNode extends Node {

    private final STentry decl;
    private final int diffNesting;

    public VarNode(STentry d, int dn) {
        decl = d;
        diffNesting = dn;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() 
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
        /*
         Stessa logica del FunNode
         */
        return MiniFunLib.LOADFP
                + lookupAL
                + MiniFunLib.PUSH+ decl.getOffSet() + "\n"
                + MiniFunLib.SUB
                + MiniFunLib.LOADW;
    }

}
