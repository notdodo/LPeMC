package Logic;

import Generics.Node;
import Generics.MiniFunLib;

/**
 * Classe per la gestione del nodo di negazione<br/>
 * ESEMPIO: not(b)
 */
public class NotNode extends Node {

    private final Node exp;

    /**
     * @param exp Identifica il nodo da negare
     */
    public NotNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public String toPrint() {
        return "NotNode"
                + "[" + this.exp.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.exp.codeGen()
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + MiniFunLib.BRANCHEQ + lab1 + "\n"
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + MiniFunLib.PUSH + MiniFunLib.FALSE + "\n"
                + lab2 + ":\n";
    }
}
