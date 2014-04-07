package Op;

import Generics.Node;
import Generics.MiniFunLib;


public class MagNode extends Node {

    private Node left;
    private Node right;

    public MagNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public String toPrint() {
        return "MagNode[" + this.left.toPrint() + "," + this.right.toPrint() + "]";
    }

    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error: MagNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.right.codeGen() + this.left.codeGen()
                + "bless " + lab1 + "\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}
