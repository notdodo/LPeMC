package Logic;

import Generics.Node;
import Generics.MiniFunLib;

public class NotNode extends Node {

    private final Node exp;

    public NotNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + this.exp.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.exp.codeGen()
                + "push " + MiniFunLib.TRUE + "\n"
                + "beq " + lab1 + "\n"
                + "push " + MiniFunLib.TRUE + "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + lab2 + ":\n";
    }
}
