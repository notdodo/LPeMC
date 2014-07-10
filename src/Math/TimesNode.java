package Math;

import Generics.Node;
import Generics.MiniFunLib;
import Type.IntTypeNode;

public class TimesNode extends Node {

    private final Node left;
    private final Node right;

    public TimesNode(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName()
                + "[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new IntTypeNode()))
                && (MiniFunLib.isCompatible(right, new IntTypeNode()))) {
            return MiniFunLib.INT;
        }
        System.out.println("Type Error " + this.getClass().getSimpleName());
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
