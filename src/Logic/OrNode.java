package Logic;


import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;


public class OrNode extends Node {

    private Node left;
    private Node right;

    public OrNode(Node l, Node r) {
        left = l;
        right = r;
    }

    public String toPrint() {
        return "OrNode[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    public String typeCheck() {
        if ((MiniFunLib.isCompatible(left, new BoolTypeNode()))
                && (MiniFunLib.isCompatible(right, new BoolTypeNode()))) {
            return MiniFunLib.BOOL;
        }
        System.out.println("Type Error OrNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        return left.codeGen() + right.codeGen() + "add\n";
    }

}
