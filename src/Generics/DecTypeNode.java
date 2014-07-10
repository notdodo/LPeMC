package Generics;

public class DecTypeNode extends Node {

    private String id;

    public DecTypeNode(String idType) {
        id = idType;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName() + "[" + id + "]";
    }

    @Override
    public String typeCheck() {
        return "";
    }

    @Override
    public String codeGen() {
        return "";
    }
}
