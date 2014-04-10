package Generics;

import java.util.ArrayList;

public class FunParNode extends Node {

    private STentry decl;
    private int diffNesting;
    private ArrayList<Node> parList;

    public FunParNode(STentry d, int dn, ArrayList<Node> pl) {
        decl = d;
        diffNesting = dn;
        parList = pl;
    }

    public FunParNode(STentry d, int dn) {
        decl = d;
        diffNesting = dn;
        this.parList = new ArrayList<Node>();
    }

    public ArrayList<Node> getPar() {
        return this.parList;
    }

    @Override
    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return this.getClass().getSimpleName()
                + "[" + diffNesting + "," + (decl.getOffSet()) + "," + parString + "]";
    }

    @Override
    public String typeCheck() {
        return this.decl.getDecl().typeCheck();
    }

    @Override
    public String codeGen() {
        String lookupAL = "";
        for (int i = 0; i < diffNesting; i++) {
            lookupAL += "lw\n";
        }

        //il return va bene se la entry è un decFuNonde, se è un parametro allora recuperiamo AL e codice della funzione
        //bisogna prendere la chiusura
        if (decl.getDecl() instanceof DecFunNode) {
            return // Scorro AL per recuperare codice della funzione
                    "lfp\n"
                    + lookupAL + "push " + decl.getOffSet() + "\n"
                    + "sub\n"
                    + "lw\n"
                    // L' AL da passare è quello del padre sintattico
                    + "lfp\n"
                    + lookupAL;
        } else {
            return "lfp\n" //parte il codice per trovare l'indirizzo del codice della funzione chiamata
                    + lookupAL
                    + "push " + this.decl.getOffSet() + "\n"
                    + "sub\n" + "lw\n" //trovato!

                    + "lfp\n"// parte il codice per trovarci l'AL
                    + lookupAL
                    + "push " + (this.decl.getOffSet() + 1) + "\n"
                    + "sub\n"
                    + "lw\n" //abbiamo trovato l'access link
                    ;
        }
    }

}
