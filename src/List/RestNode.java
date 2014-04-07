package List;

// rest restituisce la code di una lista

import Generics.Node;

public class RestNode extends Node {

    private Node exp;

    public RestNode(Node e) {
        exp = e;
    }

    public String toPrint() {
        return "RestNode[" + exp.toPrint() + "]";
    }

    // controllo ricorsivamente l'albero fino a fine lista
    public String typeCheck() {
        return this.exp.typeCheck();
    }

    public String codeGen() {
        return "push 1\n"
                + exp.codeGen()
                + "add\n"
                + "lw\n";
    }
}
