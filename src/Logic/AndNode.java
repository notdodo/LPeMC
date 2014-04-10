package Logic;

import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;

/**
 * Classe per la gestione del nodo And<br/>
 * ESEMPIO: a == b
 */
public class AndNode extends Node {

    private final Node left;
    private final Node right;

    /**
     * @param l Albero sintattico del primo operatore
     * @param r Albero sintattico del secondo operatore
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
        return this.getClass().getSimpleName() + "[" + left.toPrint() + ","
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
        System.out.println("Type Error: " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    /**
     * @return Codice eseguibile per il relativo nodo
     */
    @Override
    public String codeGen() {
        return left.codeGen() + right.codeGen() + "mult\n";
    }

}
