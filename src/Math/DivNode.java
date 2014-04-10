package Math;


import Generics.MiniFunLib;
import Generics.Node;
import Type.IntTypeNode;


public class DivNode extends Node {

    private Node left;
    private Node right;

    public DivNode(Node l, Node r) {
        left = l;
        right = r;
    }

    public String toPrint() {
        return "DivNode[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new IntTypeNode()))
                && (MiniFunLib.isCompatible(right, new IntTypeNode()))) {
            return MiniFunLib.INT;
        }
        System.out.println("Type Error: DivNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return left.codeGen()
                + right.codeGen()
                + "push " + "0" + "\n"
                + "beq " + lab1 + "\n"
                + "div\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "halt\n"
                + lab2 + ":\n";
    }
}
