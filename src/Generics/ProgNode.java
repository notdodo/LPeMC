package Generics;

public class ProgNode extends Node {

    private final Node let;

    // il costruttore accetta un LetNode
    public ProgNode(Node l) {
        this.let = l;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() 
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
