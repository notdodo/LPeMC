package Generics;

/**
 * Classe per la crazione del nodo padre del programma da cui tutti gli altri
 * nodi derivano
 */
public class ProgNode extends Node {

    private final Node let;

    /**
     * @param l Identifica il LetNode
     */
    public ProgNode(Node l) {
        this.let = l;
    }

    @Override
    public String toPrint() {
        return "ProgNode"
                + "[" + this.let.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        return this.let.typeCheck();
    }

    @Override
    public String codeGen() {
        return this.let.codeGen();
    }

}
