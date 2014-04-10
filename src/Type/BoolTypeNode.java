package Type;

import Generics.MiniFunLib;
import Generics.Node;

public class BoolTypeNode extends Node {

    public BoolTypeNode() {
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.BOOL;
    }

    @Override
    public String codeGen() {
        return "";
    }
}
