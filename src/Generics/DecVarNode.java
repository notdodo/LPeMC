package Generics;

public class DecVarNode extends Node {

    private final String id;
    private final Node type;
    private final Node exp;
    private boolean typeChecked = false;
    private String typeString = "";

    public DecVarNode(String i, Node t, Node e) {
        id = i;
        type = t;
        exp = e;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName()
                + "[" + id + ","
                + type.toPrint() + ","
                + exp.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (!typeChecked) {
            if (MiniFunLib.isCompatible(exp, type)) {
                typeChecked = true;
                typeString = type.typeCheck();
            } else {
                System.out.println("Type Error: "
                        + this.getClass().getSimpleName()
                        + " " + this.id);
                System.exit(0);
            }
        }
        return typeString;
    }

    @Override
    public String codeGen() {
        return exp.codeGen();
    }
}
