package Type;

import Generics.Node;
import Generics.MiniFunLib;

public class IntTypeNode extends Node {

    public IntTypeNode() {
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.INT;
    }

    @Override
    public String codeGen() {
        return "";
    }
}
