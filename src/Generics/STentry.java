package Generics;

/**
 * Classe per la creazione e gestione della Symbol Table per il linguaggio
 */
public class STentry {

    private final Node decl;
    private final int offSet;

    /**
     * @param d Identifica il nodo
     * @param o Identifica la posizione del nodo
     */
    public STentry(Node d, int o) {
        decl = d;
        offSet = o;
    }

    // Recupera la dichiarazione
    public Node getDecl() {
        return decl;
    }

    // Recupera l'offset
    public int getOffSet() {
        return offSet;
    }

    // Stampa la dichiarazione del tipo parametrico
    public String toPrint() {
        return decl.toPrint();
    }

}
