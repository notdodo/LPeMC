package Math;

import Generics.MiniFunLib;
import Generics.Node;

public class MagNode extends Node {

    private final Node left;
    private final Node right;

    public MagNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName()
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
        System.out.println("Type Error " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        String lab3 = MiniFunLib.newLabel();
        return this.right.codeGen() + this.left.codeGen()
                + MiniFunLib.BRANCHLESS + lab1 + "\n"
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + this.right.codeGen()
                + this.left.codeGen()
                + MiniFunLib.BRANCHEQ + lab2 + "\n"
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + MiniFunLib.BRANCH + lab3 + "\n"
                + lab2 + ":\n"
                + MiniFunLib.PUSH + MiniFunLib.FALSE + "\n"
                + MiniFunLib.BRANCH + lab3 + "\n"
                + lab3 + ":\n";
    }
}
