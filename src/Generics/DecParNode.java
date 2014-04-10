package Generics;


public class DecParNode extends Node {

    private String id;
    private Node type;
    private boolean typeChecked = false;
    private String typeString = "";
    private boolean isFun = false;

    public DecParNode(String i, Node t) {
        id = i;
        type = t;
    }

    public DecParNode(String i, Node t, boolean f) {
        this.id = i;
        this.type = t;
        this.isFun = f;
    }

    public boolean getIsFun() {
        return this.isFun;
    }

    public Node getType() {
        return this.type;
    }

    public String toPrint() {
        return "DecParNode[" + id + ","
                + type.toPrint() + "]";
    }

    public String typeCheck() {
        if (!typeChecked) {
            typeChecked = true;
            typeString = type.typeCheck();
        }
        return typeString;
    }

    public String codeGen() {
        return "";
    }
}
