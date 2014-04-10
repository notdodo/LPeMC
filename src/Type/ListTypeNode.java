package Type;

// tipo lista generico
import Generics.MiniFunLib;
import Generics.Node;

public class ListTypeNode extends Node {

    private final Node type;

    public ListTypeNode(Node t) {
        this.type = t;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName();
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
