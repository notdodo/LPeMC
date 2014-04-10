package Op;


import Generics.Node;
import Generics.MiniFunLib;
import Type.IntTypeNode;


public class PlusNode extends Node {

    private Node left;
    private Node right;

    public PlusNode(Node l, Node r) {
        left = l;
        right = r;
    }

    public String toPrint() {
        return "PlusNode[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new IntTypeNode()))
                && (MiniFunLib.isCompatible(right, new IntTypeNode()))) {
            return MiniFunLib.INT;
        }
        System.out.println("Type Error PlusNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        return left.codeGen() + right.codeGen() + "add\n";
    }

}
