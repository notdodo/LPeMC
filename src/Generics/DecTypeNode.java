package Generics;

/**
 * Classe per la creazione del nodo per i tipi parametrici
 */
public class DecTypeNode extends Node {

    private String id;
    private Node genericType = null;

    /**
     * @param idType Identifica il nome del tipo parametrico
     */
    public DecTypeNode(String idType) {
        id = idType;
    }

    @Override
    public String toPrint() {
        return "DecTypeNode[\"" + id + "\"]";
    }

    @Override
    public String typeCheck() {
        // Antepongo la string Type: prima del nome del tipo parametrico per riconoscerlo
        if (genericType == null) {
            return MiniFunLib.TYPE + this.id;
        }
        return this.genericType.typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }

    // Sostituisco il tipo parametrico con quello finale
    public void setGenericType(Node type) {
        if (!type.typeCheck().equals(MiniFunLib.TYPE + this.id)) {
            this.genericType = type;
        }
    }
}
