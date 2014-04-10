package List;

import Generics.MiniFunLib;
import Generics.Node;


public class EmptyNode extends Node {

    public EmptyNode() {
    }

    public String toPrint() {
        return "Empty";
    }

    public String typeCheck() {
        return MiniFunLib.EMPTY;
    }

    public String codeGen() {
        return "push " + MiniFunLib.NULLPOINTER + "\n";
    }
}
