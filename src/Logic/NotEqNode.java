package Logic;

import Generics.Node;
import Generics.MiniFunLib;

/**
 * Classe per la gestione del nodo di disuguaglianza<br/>
 * ESEMPIO: a != b
 */
public class NotEqNode extends Node {

    private final Node left;
    private final Node right;

    /**
     * @param left Identifica il primo operatore
     * @param right Identifica il secondo operatore
     */
    public NotEqNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toPrint() {
        return "NotEqNode"
                + "[" + this.left.toPrint()
                + "," + this.right.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.err.println("Type Error " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return left.codeGen()
                + right.codeGen()
                + MiniFunLib.BRANCHEQ + lab1 + "\n"
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + MiniFunLib.PUSH + MiniFunLib.FALSE + "\n"
                + lab2 + ":\n";
    }
}
