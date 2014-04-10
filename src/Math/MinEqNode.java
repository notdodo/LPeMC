package Math;

import Generics.MiniFunLib;
import Generics.Node;

public class MinEqNode extends Node {

    private final Node left;
    private final Node right;

    public MinEqNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + this.left.toPrint() + "," + this.right.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.left.codeGen() + this.right.codeGen()
                + "bless " + lab1 + "\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}
