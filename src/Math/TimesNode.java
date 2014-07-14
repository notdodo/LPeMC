package Math;

import Generics.Node;
import Generics.MiniFunLib;
import Type.IntTypeNode;

/**
 * Classe per utilizzare l'operatore di moltiplicazione
 */
public class TimesNode extends Node {

    private final Node left;
    private final Node right;

    /**
     * @param l Identifica il primo operatore
     * @param r Identifica il secondo operatore
     */
    public TimesNode(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint() {
        return "TimesNode"
                + "[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new IntTypeNode()))
                && (MiniFunLib.isCompatible(right, new IntTypeNode()))) {
            return MiniFunLib.INT;
        }
        System.err.println("Type Error " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        return left.codeGen()
                + right.codeGen()
                + MiniFunLib.MULT;
    }
}
