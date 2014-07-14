package Logic;

import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;

/**
 * Classe per la gestione del nodo congiunzione<br/>
 * ESEMPIO: a && b
 */
public class AndNode extends Node {

    private final Node left;
    private final Node right;

    /**
     * @param l Identifica il primo operatore
     * @param r Identifica il secondo operatore
     */
    public AndNode(Node l, Node r) {
        left = l;
        right = r;
    }

    /**
     * @return Stampa l'albero sintattico
     */
    @Override
    public String toPrint() {
        return "AndNode"
                + "[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    /**
     * @return Controllo dei tipi dei parametri
     */
    @Override
    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new BoolTypeNode()))
                && (MiniFunLib.isCompatible(right, new BoolTypeNode()))) {
            return MiniFunLib.BOOL;
        }
        System.err.println("Type Error: " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    /**
     * @return Codice eseguibile per il relativo nodo
     */
    @Override
    public String codeGen() {
        return left.codeGen()
                + right.codeGen()
                + MiniFunLib.MULT;
    }

}
