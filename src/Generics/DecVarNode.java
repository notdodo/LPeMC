package Generics;


public class DecVarNode extends Node {

    private String id;
    private Node type;
    private Node exp;
    private boolean typeChecked = false;
    private String typeString = "";

    public DecVarNode(String i, Node t, Node e) {
        id = i;
        type = t;
        exp = e;
    }

    public String toPrint() {
        return "DecVarNode[" + id + ","
                + type.toPrint() + ","
                + exp.toPrint() + "]";
    }

    public String typeCheck() {
        if (!typeChecked) {
            if (MiniFunLib.isCompatible(exp, type)) {
                typeChecked = true;
                typeString = type.typeCheck();
            } else {
                System.out.println("Type Error: DecVarNode "+this.id);
                System.exit(0);
            }
        }
        return typeString;
    }

    public String codeGen() {
        return exp.codeGen();
    }
}
