package Logic;

import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;

public class OrNode extends Node {

    private final Node left;
    private final Node right;

    public OrNode(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new BoolTypeNode()))
                && (MiniFunLib.isCompatible(right, new BoolTypeNode()))) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        return left.codeGen() + right.codeGen() + "add\n";
    }

}
