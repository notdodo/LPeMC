package Generics;

public class DecTypeNode extends Node {

    private String id;
    private Node genericType = null;

    public DecTypeNode(String idType) {
        id = idType;
    }

    @Override
    public String toPrint() {
        return "DecTypeNode[\"" + id + "\"]";
    }

    @Override
    public String typeCheck() {
        // Se è generico aggiungo PAR
        if (genericType == null) {
            return MiniFunLib.TYPE + this.id;
        }
        return this.genericType.typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }

    public void setGenericType(Node type) {
        if (!type.typeCheck().equals(MiniFunLib.TYPE + this.id)) {
            this.genericType = type;
        }
    }
}
