package Generics;

import Type.FunParType;
import java.util.ArrayList;

public class FunNode extends Node {

    protected STentry decl;
    protected int diffNesting;
    protected ArrayList<Node> parList;
    protected ArrayList<Node> paramTypes;

    public FunNode(STentry d, int dn, ArrayList<Node> pl) {
        this.decl = d;
        this.diffNesting = dn;
        this.parList = pl;
    }

    public STentry getDecl() {
        return this.decl;
    }

    public void addParType(ArrayList<Node> pt) {
        this.paramTypes = pt;
    }

    @Override
    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return this.getClass().getSimpleName()
                + "[" + diffNesting + ","
                + (decl.getOffSet()) + ","
                + parString + "]";
    }

    @Override
    public String typeCheck() {
        if (this.decl.getDecl() instanceof DecParNode) {
            // Recupero parametri dalla dichiarazione della funzione
            FunParType funType = ((FunParType) ((DecParNode) decl.getDecl()).getType());
            ArrayList<Node> decFunPar = funType.getPar();
            // Controllo di avere lo stesso numero e tipo di parametri
            if (checkPar(decFunPar, this.parList)) {
                return funType.getRetType().typeCheck();
            }
        } else if (this.decl.getDecl() instanceof DecFunNode) {
            ArrayList<Node> decPar = ((DecFunNode) this.decl.getDecl()).getPar();
            if (checkPar(decPar, this.parList)) {
                return ((DecFunNode) this.decl.getDecl()).getRetType().typeCheck();
            }
        }
        System.out.println("Errore di dichiarazione " + this.getClass().getSimpleName());
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

        for (int i = parList.size() - 1; i >= 0; i--) {
            parCode += (parList.get(i)).codeGen();
        }

        String lookupAL = "";

        // per recuperare AL del padre sintattico della funzione da invocare
        for (int i = 0; i < diffNesting; i++) {
            lookupAL += MiniFunLib.LOADW;
        }
        String accessLink = "";
        String codeAdress = "";

        if (decl.getDecl() instanceof DecFunNode) {
            accessLink = MiniFunLib.LOADFP //ricarico il control link                
                    + lookupAL;
            codeAdress = MiniFunLib.LOADFP //Anche stavolta andiamo indietro per cercare lo scope di definzione della funzione
                    + lookupAL
                    /*
                     Trovato l'access link (frame pointer )dove è presente la dichiarazione della funzione
                     */
                    // ora posso caricare l'offset dove è dichiarata la funzione
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

        return MiniFunLib.LOADFP //  push control link (rif al AL (record di attivazione) del chiamante)
                + parCode
                /*
                 Ora dobbiamo inserire l'access link, eseguiamo una serie di operazioni che ci
                 permetterenno di arrivare al padre sintattico in modo corretto
                
                 */
                + accessLink //carico il contenuto di quella locazione con load word fino ad arrivare                
                /*
                 Andiamo a trovare l'indirizzo a cui fare il jump, l'indirizzo della funzione che 
                 vogliamo invocare
                 */
                + codeAdress
                + MiniFunLib.JS; //effettua il salto all'indirizzo corretto
    }

    private boolean checkPar(ArrayList<Node> declParameter, ArrayList<Node> passedParameter) {
        if (declParameter.size() == passedParameter.size()) {
            // Controllo ad uno ad un la compatibilità dei Parametri con la
            // loro dichiarazione
            for (int i = 0; i < declParameter.size(); i++) {
                Node par = declParameter.get(i);
                if (par instanceof DecParNode) {
                    if (((DecParNode) declParameter.get(i)).getType() instanceof FunParType) {
                        ArrayList<Node> parCheck = ((FunParType) ((DecParNode) declParameter.get(i)).getType()).getPar();
                        if (passedParameter.get(i) instanceof FunParNode) {
                            ArrayList<Node> parCheckFunPar = ((FunParNode) (passedParameter.get(i))).getPar();
                        } else {
                            System.out.println("Parametro atteso: funzione");
                            System.exit(0);
                        }
                    }
                } else {
                    if (!MiniFunLib.isCompatible(declParameter.get(i), passedParameter.get(i))) {
                        System.out.println("Type Error FunNode: Parametri incompatibili:"
                                + declParameter.get(i).typeCheck()
                                + ", "
                                + passedParameter.get(i).typeCheck());
                        System.exit(0);
                    }
                }
            }
        } else {
            System.out.println("Type Error FunNode: Numero parametri sbagliato "
                    + declParameter.size() + " "
                    + ", "
                    + passedParameter.size());
            System.exit(0);
        }
        return true;
    }
}
