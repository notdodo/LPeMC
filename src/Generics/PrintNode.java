package Generics;


public class PrintNode extends Node {

    private Node exp;

    public PrintNode(Node e) {
        exp = e;
    }

    public String toPrint() {
        return "PrintNode[" + exp.toPrint() + "]";
    }

    public String typeCheck() {
        return exp.typeCheck();
    }

    public String codeGen() {
        return exp.codeGen()
                + "print\n";
    }
}
