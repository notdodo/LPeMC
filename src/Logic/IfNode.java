package Logic;


import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;


public class IfNode extends Node {

    private Node cond;
    private Node th;
    private Node el;

    public IfNode(Node c, Node t, Node e) {
        cond = c;
        th = t;
        el = e;
    }

    public String toPrint() {
        return "IfNode[" + cond.toPrint() + ","
                + th.toPrint() + ","
                + el.toPrint() + "]";
    }

    public String typeCheck() {
        if (MiniFunLib.isCompatible(cond, new BoolTypeNode())) {
            if (MiniFunLib.isCompatible(th, el)) {
                return el.typeCheck();
            } else if (MiniFunLib.isCompatible(el, th)) {
                return th.typeCheck();
            }
        }
        System.out.println("Type Error IfNode");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return cond.codeGen()
                + "push " + MiniFunLib.TRUE + "\n"
                + "beq " + lab1 + "\n"
                + el.codeGen()
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + th.codeGen()
                + lab2 + ":\n";
    }
}
