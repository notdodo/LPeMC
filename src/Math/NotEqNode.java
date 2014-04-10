package Math;

import Logic.*;
import Generics.Node;
import Generics.MiniFunLib;


public class NotEqNode extends Node {

       private Node left;
    private Node right;

    public NotEqNode(Node left, Node right) {
       this.left = left;
        this.right = right;
    }

    public String toPrint() {
        return "NotEqNode[" + this.left.toPrint() + "," + this.right.toPrint() + "]";
    }

    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error NotEqNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {

        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return left.codeGen() + right.codeGen()
                + "beq " + lab1 + "\n"
                + "push " + MiniFunLib.TRUE+  "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + lab2 + ":\n";
    }
}
