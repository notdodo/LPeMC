package Generics;

import java.util.ArrayList;

/**
 * Classe per la creazione del nodo per invocare una funzione high-order
 */
public class FunParNode extends Node {

    private STentry decl;
    private int diffNesting;
    private ArrayList<Node> parList;
    private ArrayList<Node> paramTypes;

    /**
     * @param d Identifica la entry relativa alla dichiarazione della funzione
     * @param dn Identifica la posizione della dichiarazione della funzione
     * @param pl Identifica i parametri della funzione
     */
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

    // Aggiunge i parametri
    public void addParType(ArrayList<Node> paramTypes) {
        this.paramTypes = paramTypes;
    }

    // Recupera i parametri
    public ArrayList<Node> getPar() {
        return this.parList;
    }

    @Override
    public String toPrint() {
        String parString = "";
        // Stampo i parametri
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return "FunParNode"
                + "[" + diffNesting + ","
                + (decl.getOffSet()) + ","
                + parString + "]";
    }

    @Override
    public String typeCheck() {
        return this.decl.getDecl().typeCheck();
    }

    @Override
    public String codeGen() {
        String lookupAL = "";
        for (int i = 0; i < diffNesting; i++) {
            lookupAL += MiniFunLib.LOADW;
        }

        // Se è un DecFunNode allora il return va bene
        if (decl.getDecl() instanceof DecFunNode) {
            return // Scorro AL per recuperare codice della funzione
                    MiniFunLib.LOADFP
                    + lookupAL + MiniFunLib.PUSH + decl.getOffSet() + "\n"
                    + MiniFunLib.SUB
                    + MiniFunLib.LOADW
                    // L'AL da passare è quello del padre sintattico
                    + MiniFunLib.LOADFP
                    + lookupAL;
        } else {
            // E' una funzione passata come parametro e recupero AL e il codice dalla funzione, includo la chiusura
            return MiniFunLib.LOADFP // codice per trovare l'indirizzo del codice della funzione chiamata
                    + lookupAL
                    + MiniFunLib.PUSH + this.decl.getOffSet() + "\n"
                    + MiniFunLib.SUB
                    + MiniFunLib.LOADW
                    + MiniFunLib.LOADFP // codice per trovare l'AL
                    + lookupAL
                    + MiniFunLib.PUSH + (this.decl.getOffSet() + 1) + "\n"
                    + MiniFunLib.SUB
                    + MiniFunLib.LOADW // Salvo l'access link
                    ;
        }
    }
}
