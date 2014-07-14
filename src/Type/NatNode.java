package Type;

import Generics.Node;
import Generics.MiniFunLib;

/**
 * Classe per la gestione del tipo intero (Int)<br/>
 */
public class NatNode extends Node {

    private final int val;

    /**
     * @param v Identifica il valore intero 
     */
    public NatNode(int v) {
        val = v;
    }

    @Override
    public String toPrint() {
        return "NatNode"
                + "[" + val + "]";
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.INT;
    }

    @Override
    public String codeGen() {
        return "push " + val + "\n";
    }
}
