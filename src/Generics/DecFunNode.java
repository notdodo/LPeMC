package Generics;

import java.util.ArrayList;

/**
 * Classe per la creazione del nodo di dichiarazione di una funzione
 */
public class DecFunNode extends Node {

    private String id;
    private Node retType;
    private ArrayList<Node> parList = new ArrayList<Node>();
    private Node body;
    private boolean typeChecked = false;
    private String typeString = "";
    private ArrayList<Node> decList = new ArrayList<Node>();
    private ArrayList<Node> paramTypes = new ArrayList<Node>();

    /**
     * @param i Identifica del nome della funzione
     * @param rt Identifica il tipo di ritorno della funzione
     */
    public DecFunNode(String i) {
        id = i;
    }

    public DecFunNode(String i, Node rt) {
        this.id = i;
        this.retType = rt;
    }

    // Aggiunge il tipo di ritorno della funzione
    public void addRet(Node rt) {
        this.retType = rt;
    }

    // Aggiunge i parametri
    public void addPar(ArrayList<Node> pl) {
        for (int i = 0; i < parList.size(); i++) {
        }
        this.parList = pl;
    }

    // Aggiunge il body della funzione
    public void addBody(Node b) {
        body = b;
    }

    // Aggiunge i tipi parametrici
    public void addParType(ArrayList<Node> apt) {
        this.paramTypes = apt;
    }

    // Recupera i parametri
    public ArrayList<Node> getPar() {
        return this.parList;
    }

    // Recupera il tipo di titorno della funzione
    public Node getRetType() {
        return this.retType;
    }

    // Recupera i tipi parametrici
    public ArrayList<Node> getParType() {
        return this.paramTypes;
    }

    @Override
    public String toPrint() {
        String parString = "";
        String parTypeString = "";
        // Stampo i parametri
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        // Stampo i tipi parametrici
        for (int i = 0; i < this.paramTypes.size(); i++) {
            if (i == 0) {
                parTypeString = (this.paramTypes.get(i)).toPrint();
            } else {
                parTypeString = parTypeString + "," + (this.paramTypes.get(i)).toPrint();
            }
            parTypeString += ",";
        }

        return "DecFunNode"
                + "[\"" + id + "\","
                + parTypeString
                + retType.toPrint() + ","
                + parString + ","
                + body.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (!typeChecked) {
            // Controllo che la funzione ritorni il tipo corretto
            if (MiniFunLib.isCompatible(this.retType, this.body)) {
                typeChecked = true;
                typeString = this.body.typeCheck();
            } else {
                System.err.println("Type Error: + "
                        + this.getClass().getSimpleName()
                        + " " + this.id + " Tipo ritorno incompatibile"
                        + this.body.getClass());
                System.exit(0);
            }
        }
        return typeString;
    }

    public void addLocal(ArrayList<Node> e) {
        this.decList = e;
    }

    @Override
    public String codeGen() {
        String labelFun = MiniFunLib.newLabel();
        String popParSequence = "";
        String popListDec = "";

        // Genero il codice per i parametri
        for (int i = 0; i < parList.size(); i++) {
            popParSequence += MiniFunLib.POP;
            if (((DecParNode) this.parList.get(i)).getType() instanceof FunParType) {
                popParSequence += MiniFunLib.POP;
            }
        }

        // Genero il codice per le variabili locali
        for (int i = 0; i < this.decList.size(); i++) {
            popListDec += MiniFunLib.POP;
        }

        MiniFunLib.addFunctionCode(
                labelFun + ": // " + this.id + "\n"
                + MiniFunLib.COPYFP // prendo il contenuto dello stack e lo copio del FP che punta al nuovo AR
                + MiniFunLib.LOADRA // push RA del chiamante
                + body.codeGen() // genero il codice per eseguire la funzione
                // bisogna ripulire lo stack e risaltare al chiamante
                + MiniFunLib.STORERV // per salvare il valore
                + popListDec // aggiunto per la seconda estensione
                + MiniFunLib.STORERA // salvo il RA
                + MiniFunLib.POP // estraggo AL
                + popParSequence // estraggo le variabili
                + MiniFunLib.STOREFP // salvo il frame pointer
                + MiniFunLib.LOADRV // agggiunge il valore di ritorno allo stack
                + MiniFunLib.LOADRA // carico il return address
                + MiniFunLib.JS // eseguo il jump e restituisco il controllo al chiamante
                + "// END " + this.id + "\n"
        );

        return MiniFunLib.PUSH + labelFun + " // " + this.id + "\n";
    }
}
