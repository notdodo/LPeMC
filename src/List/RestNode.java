package List;

// rest restituisce la code di una lista
import Generics.Node;

public class RestNode extends Node {

    private final Node exp;

    public RestNode(Node e) {
        exp = e;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + exp.toPrint() + "]";
    }

    // controllo ricorsivamente l'albero fino a fine lista
    @Override
    public String typeCheck() {
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        return "push 1\n"
                + exp.codeGen()
                + "add\n"
                + "lw\n";
    }
}
