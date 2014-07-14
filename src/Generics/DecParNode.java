package Generics;

/**
 * Classe per la creazione del nodo di dichiarazione di una parametro di una
 * funzione
 */
public class DecParNode extends Node {

    private String id;
    private Node type;
    private boolean isFun = false;

    /**
     * @param i Identifica del nome del parametro
     * @param t Identifica il tipo del parametro
     * @param f Specifica se il tipo passato è una funzione
     */
    public DecParNode(String i, Node t) {
        id = i;
        type = t;
    }

    public DecParNode(String i, Node t, boolean f) {
        this.id = i;
        this.type = t;
        this.isFun = f;
    }

    // Ritorna il tipo del parametro
    public Node getType() {
        return this.type;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName()
                + "[\"" + id + "\","
                + type.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        return type.typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }
}
