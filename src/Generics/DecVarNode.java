package Generics;

/**
 * Classe per la creazione del nodo di dichiarazione delle variabili
 */
public class DecVarNode extends Node {

    private final String id;
    private final Node type;
    private final Node exp;
    private boolean typeChecked = false;
    private String typeString = "";

    /**
     * @param i Identifica il nome della variabile
     * @param t Identifica il tipo della variabile
     * @param e Identifica l'espressione che assume la variabile
     */
    public DecVarNode(String i, Node t, Node e) {
        id = i;
        type = t;
        exp = e;
    }

    @Override
    public String toPrint() {
        return "DecVarNode"
                + "[\"" + id + "\","
                + type.toPrint() + ","
                + exp.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (!typeChecked) {
            // Controllo che i tipi siano compatibili
            if (MiniFunLib.isCompatible(exp, type)) {
                // Blocco la ricorsione del typeCheck
                typeChecked = true;
                typeString = type.typeCheck();
            } else {
                System.err.println("Type Error: "
                        + this.getClass().getSimpleName()
                        + " " + this.id);
                System.exit(0);
            }
        }
        return typeString;
    }

    @Override
    public String codeGen() {
        return exp.codeGen();
    }
}
