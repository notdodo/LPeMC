package Type;

import Generics.Node;
import Generics.MiniFunLib;


/**
 * Classe per la gestione del tipo booleano (Bool)<br/>
 */
public class BoolNode extends Node {

    private boolean val;

    /**
     * @param v Imposta il valore del Nodo
     */
    public BoolNode(boolean v) {
        val = v;
    }

    /**
     * @return Stampa l'albero sintattico
     */
    public String toPrint() {
        return "BoolNode[" + val + "]";
    }

    public String typeCheck() {
        return MiniFunLib.BOOL;
    }

    public String codeGen() {
        if (val) {
            return "push " + MiniFunLib.TRUE + "\n";
        }
        return "push " + MiniFunLib.FALSE + "\n";
    }
}
