package Type;

import Generics.Node;
import Generics.MiniFunLib;

/**
 * Classe per la gestione del tipo booleano (Bool)<br/>
 */
public class BoolNode extends Node {

    private final boolean val;

    /**
     * @param v Imposta il valore del Nodo
     */
    public BoolNode(boolean v) {
        val = v;
    }

    /**
     * @return Stampa l'albero sintattico
     */
    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + val + "]";
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.BOOL;
    }

    @Override
    public String codeGen() {
        if (val) {
            return "push " + MiniFunLib.TRUE + "\n";
        }
        return "push " + MiniFunLib.FALSE + "\n";
    }
}
