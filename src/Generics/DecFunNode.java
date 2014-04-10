package Generics;

import Type.FunParType;
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

    /**
     * @param i Identificare del nome della funzione
     */
    public DecFunNode(String i) {
        id = i;
    }

    public DecFunNode(String i, Node rt) {
        this.id = i;
        this.retType = rt;
    }

    public void addRet(Node rt) {
        this.retType = rt;
    }

    public void addPar(ArrayList<Node> pl) {
        for (int i = 0; i < parList.size(); i++) {
        }
        this.parList = pl;
    }

    public void addBody(Node b) {
        body = b;
    }

    public ArrayList<Node> getPar() {
        return this.parList;
    }

    public String getType() {
        return this.retType.typeCheck();
    }

    public Node getRetType() {
        return this.retType;
    }

    public String getID() {
        return this.id;
    }

    @Override
    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }

        return this.getClass().getSimpleName() + "[" + id + ","
                + retType.toPrint() + ","
                + parString + ","
                + body.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (!typeChecked) {

            ///Questa non va bene
//            // se è un FunParType controllo il num dei parametri
//            if (this.retType instanceof FunParType ) {
//                    FunParType fpt = (FunParType)this.retType;
//                if (fpt.getPar().size() != this.parList.size()) {
//                    System.out.println(this.getClass().getName() + " TypeCheck Error: DecFunNode "+this.id+" Numero parametri Errato");
//                    System.exit(0);
//                }
//            }
            if (MiniFunLib.isCompatible(this.retType, this.body)) {
                typeChecked = true;
                typeString = this.body.typeCheck();
            } else {
                System.out.println("Type Error: + " + this.getClass().getSimpleName()
                        + " " + this.id + " Tipo ritorno incompatibile" + this.body.getClass());
                System.exit(0);
            }
        }
        return typeString;
    }

    public void addLocal(ArrayList<Node> e) {
        this.decList = e;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String codeGen() {
        String labelFun = MiniFunLib.newLabel();

        String popParSequence = "";
        String popListDec = "";

        for (int i = 0; i < parList.size(); i++) {
            popParSequence += "pop\n";
            if (((DecParNode) this.parList.get(i)).getType() instanceof FunParType) {
                popParSequence += "pop\n";
            }
        }

        for (int i = 0; i < this.decList.size(); i++) {
            popListDec += "pop\n";
        }

        MiniFunLib.addFunctionCode(
                labelFun + ": // " + this.id + "\n"
                + "cfp\n" // prende il contenuto dello stack e lo copia nel FP che ora punta al nuovo AR
                + "lra\n" // push RA del chiamante
                + body.codeGen() //verrà generato il valore di ritorno alla fine
                /*
                 Ora bisogna ripulire lo stack e risaltare al chiamante
                 */
                + "srv\n" //per salvare il valore
                + popListDec //aggiunto per la seconda estensione
                + "sra\n"
                + "pop\n" //cancelliamo AL
                + popParSequence //cancelliamo le variabili
                + "sfp\n" // prendiamo il frame pointer e lo salviamo
                + "lrv\n" //questo effettua l'unica operzione "utile" di una chiamata di funzione, ovvero aggiunge il valore di ritorno allo stack
                + "lra\n" //carichiamo il return address
                + "js\n" //effettuaiamo il jump e restituiamo il controllo al chiamante
                + "// END " + this.id + "\n"
        );

        return "push " + labelFun + " // " + this.id + "\n";
    }
}
