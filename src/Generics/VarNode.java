package Generics;


public class VarNode extends Node {

    private STentry decl;
    private int diffNesting;

    public VarNode(STentry d, int dn) {
        decl = d;
        diffNesting = dn;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() +"[" + diffNesting + "," + decl.getOffSet() + "]";
    }

    @Override
    public String typeCheck() {
        return decl.getDecl().typeCheck();
    }

    @Override
    public String codeGen() {

        String lookupAL = "";

        for (int i = 0; i < diffNesting; i++) {
            lookupAL += "lw\n";
        }
/*
        Stessa logica del FunNode
        */
        return "lfp\n"
                + lookupAL
                + "push " + decl.getOffSet() + "\n"
                + "sub\n"
                + "lw\n";
    }

}
