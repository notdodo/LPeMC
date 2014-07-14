package Generics;

import java.util.ArrayList;

/**
 * Classe per la creazione del nodo per la chiamata di una funzione
 */
public class FunNode extends Node {

    protected STentry decl;
    protected int diffNesting;
    protected ArrayList<Node> parList;
    protected ArrayList<Node> paramTypes;

    /**
     * @param d Identifica la entry relativa alla dichiarazione della funzione
     * @param dn Identifica la posizione della dichiarazione della funzione
     * @param pl Identifica i parametri della funzione
     */
    public FunNode(STentry d, int dn, ArrayList<Node> pl) {
        this.decl = d;
        this.diffNesting = dn;
        this.parList = pl;
    }

    // Recupera la dichiarazione
    public STentry getDecl() {
        return this.decl;
    }

    // Aggiunge i parametri
    public void addParType(ArrayList<Node> pt) {
        this.paramTypes = pt;
    }

    @Override
    public String toPrint() {
        String parString = "";
        String parTypeString = "";
        // Stampo i parametri
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        // Stampo i tipi parametrici
        for (int i = 0; i < this.paramTypes.size(); i++) {
            if (i == 0) {
                parTypeString = parTypeString + (this.paramTypes.get(i)).toPrint();
            } else {
                parTypeString = parTypeString + "," + (this.paramTypes.get(i)).toPrint();
            }
        }
        return "FunNode"
                + "["
                + parTypeString + ","
                + diffNesting + ","
                + (decl.getOffSet()) + ","
                + parString + "]";
    }

    @Override
    public String typeCheck() {
        // Se è un DecParNode (high-order function)
        if (this.decl.getDecl() instanceof DecParNode) {
            // Recupero parametri dalla dichiarazione della funzione
            FunParType funType = ((FunParType) ((DecParNode) decl.getDecl()).getType());
            ArrayList<Node> decFunPar = funType.getPar();
            // Controllo di avere lo stesso numero e tipo di parametri
            if (checkPar(decFunPar, this.parList)) {
                return funType.getRetType().typeCheck();
            }
        } else if (this.decl.getDecl() instanceof DecFunNode) {
            // Recupero i parametri dichiarati
            ArrayList<Node> decPar = ((DecFunNode) this.decl.getDecl()).getPar();
            // Recupero i tipi parametrici
            ArrayList<Node> decParamTypes = ((DecFunNode) this.decl.getDecl()).getParType();
            // Controllo i tipi parametrici
            if (this.paramTypes.size() == decParamTypes.size()) {
                for (int i = 0; i < decParamTypes.size(); i++) {
                    // Imposto il nuovo tipo parametrico
                    ((DecTypeNode) decParamTypes.get(i)).setGenericType(this.paramTypes.get(i));
                }
            } else if (this.paramTypes.size() != decParamTypes.size()) {
                System.err.println("Parametric Type Error: Numero dei tipi parametrici incompatibile");
                System.exit(0);
            }
            // Controllo i parametri
            if (checkPar(decPar, this.parList)) {
                return ((DecFunNode) this.decl.getDecl()).getRetType().typeCheck();
            }
        }
        System.err.println("Errore di dichiarazione " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    /**
     * Il codeGen del FunNode Prevede la costruzione dell'activation Record per
     * la chiamata di una funzione
     */
    public String codeGen() {
        String parCode = "";

        // Genero il codice per i parametri
        for (int i = parList.size() - 1; i >= 0; i--) {
            parCode += (parList.get(i)).codeGen();
        }

        String lookupAL = "";
        // Recupero AL del padre sintattico della funzione da invocare
        for (int i = 0; i < diffNesting; i++) {
            lookupAL += MiniFunLib.LOADW;
        }
        String accessLink = "";
        String codeAdress = "";

        if (decl.getDecl() instanceof DecFunNode) {
            accessLink = MiniFunLib.LOADFP // Carico il control link                
                    + lookupAL;
            codeAdress = MiniFunLib.LOADFP // Cerco all'indietro lo scope di definzione della funzione
                    + lookupAL
                    // Trovato l'access link (frame pointer )dove è presente la dichiarazione della funzione                    
                    // carico l'offset dove è dichiarata la funzione
                    + MiniFunLib.PUSH + decl.getOffSet() + "\n"
                    + MiniFunLib.SUB // sottraggo e trovo l'indirizzo corretto
                    + MiniFunLib.LOADW; // la loadword carica l'indirzzo della funzione
        } else {
            accessLink = MiniFunLib.LOADFP// parte il codice per trovarci l'AL
                    + lookupAL
                    + MiniFunLib.PUSH + (this.decl.getOffSet() + 1) + "\n"
                    + MiniFunLib.SUB
                    + MiniFunLib.LOADW;
            //parte il codice per trovare l'indirizzo del codice della funzione chiamata
            codeAdress = MiniFunLib.LOADFP
                    + lookupAL
                    + MiniFunLib.PUSH + this.decl.getOffSet() + "\n"
                    + MiniFunLib.SUB
                    + MiniFunLib.LOADW;
        }

        return MiniFunLib.LOADFP // Push control link (rif al AL (record di attivazione) del chiamante)
                + parCode
                // Inserico l'access link, recupero il padre sintattico
                + accessLink // Carico il contenuto di quella locazione con load word fino ad arrivare                
                // Trovo l'indirizzo a cui fare il jump, l'indirizzo della funzione che vogliamo invocare
                + codeAdress
                + MiniFunLib.JS; // Effettua il salto all'indirizzo corretto
    }

    // Fuzione per il controllo dei parametri dichiarati e passati
    private boolean checkPar(ArrayList<Node> declParameter, ArrayList<Node> passedParameter) {
        if (declParameter.size() == passedParameter.size()) {
            // Controllo ad uno ad uno la compatibilità dei Parametri con la loro dichiarazione
            for (int i = 0; i < declParameter.size(); i++) {
                Node par = declParameter.get(i);
                if (par instanceof DecParNode) {
                    if (((DecParNode) declParameter.get(i)).getType() instanceof FunParType) {
                        ArrayList<Node> parCheck = ((FunParType) ((DecParNode) declParameter.get(i)).getType()).getPar();
                        if (passedParameter.get(i) instanceof FunParNode) {
                            ArrayList<Node> parCheckFunPar = ((FunParNode) (passedParameter.get(i))).getPar();
                        } else {
                            System.err.println("Parametro atteso: funzione");
                            System.exit(0);
                        }
                    } else {
                        // Controllo i tipi parametrici
                        if (!MiniFunLib.isCompatible(declParameter.get(i), passedParameter.get(i))) {
                            System.err.println("Type Error FunNode: Tipi Parametrici incompatibili:"
                                    + declParameter.get(i).typeCheck()
                                    + ", "
                                    + passedParameter.get(i).typeCheck());
                            System.exit(0);
                        }
                    }
                } else {
                    // Ho passato una funzione come parametro e devo controllare i parametri
                    if (!MiniFunLib.isCompatible(declParameter.get(i), passedParameter.get(i))) {
                        System.err.println("Type Error FunNode: Parametri incompatibili:"
                                + declParameter.get(i).typeCheck()
                                + ", "
                                + passedParameter.get(i).typeCheck());
                        System.exit(0);
                    }
                }
            }
        } else {
            System.err.println("Type Error FunNode: Numero parametri sbagliato "
                    + declParameter.size() + " "
                    + ", "
                    + passedParameter.size());
            System.exit(0);
        }
        return true;
    }
}
