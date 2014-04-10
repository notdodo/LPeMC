package List;

// first(list) restituisce il primo elemento della lista
import Generics.MiniFunLib;
import Generics.Node;

public class FirstNode extends Node {

    private final Node exp;

    public FirstNode(Node e) {
        exp = e;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + exp.toPrint() + "]";
    }

    // se non ho un LIST:type o empty non posso fare il type check
    @Override
    public String typeCheck() {
        if (!(this.exp.typeCheck().indexOf(MiniFunLib.LIST) == 0 || this.exp.typeCheck().equals(MiniFunLib.EMPTY))) {
            System.out.println("Type Error: " + this.getClass().getSimpleName());
            System.exit(0);
        }
        return this.exp.typeCheck().substring(MiniFunLib.LIST.length());
    }

    @Override
    public String codeGen() {
        return exp.codeGen()
                + "lw\n";
    }
}
