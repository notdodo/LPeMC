package List;

import Generics.MiniFunLib;
import Generics.Node;

/**
 * Classe per la creazione del nodo che indentifica una lista vuota
 */
public class EmptyNode extends Node {

    public EmptyNode() {
    }

    @Override
    public String toPrint() {
        return "EmptyNode";
    }

    @Override
    public String typeCheck() {
        return MiniFunLib.EMPTY;
    }

    @Override
    public String codeGen() {
        return MiniFunLib.PUSH + MiniFunLib.NULLPOINTER + "\n";
    }
}
