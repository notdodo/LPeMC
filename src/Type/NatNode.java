package Type;

import Generics.Node;
import Generics.MiniFunLib;

public class NatNode extends Node {

    private final int val;

    public NatNode(int v) {
        val = v;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() 
                + "[" + val + "]";
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.INT;
    }

    @Override
    public String codeGen() {
        return "push " + val + "\n";
    }
}
