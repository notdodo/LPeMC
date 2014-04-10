package Type;

import Generics.MiniFunLib;
import Generics.Node;


public class BoolTypeNode extends Node {

    public BoolTypeNode() {
    }

    public String toPrint() {
        return "BoolType";
    }

    public String typeCheck() {
        return MiniFunLib.BOOL;
    }

    public String codeGen() {
        return "";
    }
}
