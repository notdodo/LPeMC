package Type;

import Generics.Node;
import Generics.MiniFunLib;

public class IntTypeNode extends Node {

    public IntTypeNode() {
    }

    @Override
    public String toPrint() {
        return "IntTypeNode";
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
