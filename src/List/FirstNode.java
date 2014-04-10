package List;

// first(list) restituisce il primo elemento della lista

import Generics.MiniFunLib;
import Generics.Node;

public class FirstNode extends Node {

    private Node exp;

    public FirstNode(Node e) {
        exp = e;
    }

    public String toPrint() {
        return "FirstNode[" + exp.toPrint() + "]";
    }

    // se non ho un LIST:type o empty non posso fare il type check
    public String typeCheck() {
        if (!(this.exp.typeCheck().indexOf(MiniFunLib.LIST) == 0 || this.exp.typeCheck().equals(MiniFunLib.EMPTY))) {
            System.out.println("Type Error: FirstNode");
            System.exit(0);
        }
        return this.exp.typeCheck().substring(MiniFunLib.LIST.length());
    }

    public String codeGen() {
        return exp.codeGen()
                + "lw\n";
    }
}
