package Logic;

import Generics.Node;
import Generics.MiniFunLib;

public class EqNode extends Node {

    private final Node left;
    private final Node right;

    public EqNode(Node l, Node r) {
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
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error: " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return left.codeGen() + right.codeGen()
                + MiniFunLib.BRANCHEQ + lab1 + "\n"
                + MiniFunLib.PUSH + MiniFunLib.FALSE + "\n"
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}
