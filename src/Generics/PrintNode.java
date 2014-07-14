package Generics;

/**
 * Classe per la creazione del nodo per stampare
 */
public class PrintNode extends Node {

    private final Node exp;

    /**
     * @param e Identifica il nodo da stampare
     */
    public PrintNode(Node e) {
        exp = e;
    }

    @Override
    public String toPrint() {
        return "PrintNode"
                + "[" + exp.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
        return exp.typeCheck();
    }

    @Override
    public String codeGen() {
        return exp.codeGen()
                + MiniFunLib.PRINT;
    }
}
