package List;

import Generics.MiniFunLib;
import Generics.Node;

/**
 * Classe per la creazione del nodo che restituisce la testa di una lista
 */
public class FirstNode extends Node {

    private final Node exp;

    /**
     * @param e Identifica la lista su cui lavorare
     */
    public FirstNode(Node e) {
        exp = e;
    }

    @Override
    public String toPrint() {
        return "PrintNode"
                + "[" + exp.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        // Se non è un tipo List: o è EMPTY
        if (!(this.exp.typeCheck().indexOf(MiniFunLib.LIST) == 0 || this.exp.typeCheck().equals(MiniFunLib.EMPTY))) {
            System.err.println("Type Error: " + this.getClass().getSimpleName());
            System.exit(0);
        }
        // Elimino la string List:
        return this.exp.typeCheck().substring(MiniFunLib.LIST.length());
    }

    @Override
    public String codeGen() {
        return exp.codeGen() + MiniFunLib.LOADW;
    }
}
