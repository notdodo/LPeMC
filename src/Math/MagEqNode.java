package Math;

import Generics.Node;
import Generics.MiniFunLib;

/**
 * Classe per utlizzare l'operatore "maggiore uguale" (>=)
 */
public class MagEqNode extends Node {

    private final Node left;
    private final Node right;

    /**
     * @param left Identifica il primo operatore
     * @param right Identifica il secondo operatore
     */
    public MagEqNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toPrint() {
        return "MagEqNode"
                + "[" + this.left.toPrint() + ","
                + this.right.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.err.println("Type Error: " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.right.codeGen() + this.left.codeGen()
                + MiniFunLib.BRANCHLESS + lab1 + "\n"
                + MiniFunLib.PUSH + MiniFunLib.FALSE + "\n"
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}
