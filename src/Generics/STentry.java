package Generics;

public class STentry {

    private final Node decl;
    private final int offSet;

    public STentry(Node d, int o) {
        decl = d;
        offSet = o;
    }

    public Node getDecl() {
        return decl;
    }

    public int getOffSet() {
        return offSet;
    }

    public String toPrint() {
        return decl.toPrint();
    }

}
