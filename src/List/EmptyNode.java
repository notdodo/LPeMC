package List;

import Generics.MiniFunLib;
import Generics.Node;

public class EmptyNode extends Node {

    public EmptyNode() {
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.EMPTY;
    }

    @Override
    public String codeGen() {
        return "push " + MiniFunLib.NULLPOINTER + "\n";
    }
}
