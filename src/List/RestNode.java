package List;

import Generics.MiniFunLib;
import Generics.Node;

/**
 * Classe per la creazione del nodo che restituisce la coda di una lista
 */
public class RestNode extends Node {

    private final Node exp;

    /**
     * @param e Identifica la lista su cui lavorare
     */
    public RestNode(Node e) {
        exp = e;
    }

    @Override
    public String toPrint() {
        return "RestNode"
                + "[" + exp.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        return "push 1\n"
                + exp.codeGen()
                + MiniFunLib.ADD
                + MiniFunLib.LOADW;
    }
}
