package Type;

import Generics.MiniFunLib;
import Generics.Node;

/**
 * Classe per la creazione di un tipo lista
 */
public class ListTypeNode extends Node {

    private final Node type;

    /**
     * @param t Identifica il tipo della lista
     */
    public ListTypeNode(Node t) {
        this.type = t;
    }

    @Override
    public String toPrint() {
        return "ListTypeNode" + ":" + type.toPrint();
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.LIST + this.type.typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }
}
