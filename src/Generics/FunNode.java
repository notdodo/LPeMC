package Generics;

import Type.FunParType;
import java.util.ArrayList;

public class FunNode extends Node {

    protected STentry decl;
    protected int diffNesting;
    protected ArrayList<Node> parList;

    public FunNode(STentry d, int dn, ArrayList<Node> pl) {
        this.decl = d;
        this.diffNesting = dn;
        this.parList = pl;
    }

    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return "FunNode[" + diffNesting + "," + (decl.getOffSet()) + "," + parString + "]";
    }

    public String typeCheck() {
        if (decl.getDecl() instanceof DecParNode) {
            // Recupero parametri dalla dichiarazione della funzione
            FunParType funType = ((FunParType) ((DecParNode) decl.getDecl()).getType());
            ArrayList<Node> decFunPar = funType.getPar();
            // Controllo di avere lo stesso numero di parametri
            if (parameterMatch(decFunPar, parList)) {
                return funType.getRetType().typeCheck();
            }
        } else if (decl.getDecl() instanceof DecFunNode) {
            ArrayList<Node> decPar = ((DecFunNode) this.decl.getDecl()).getPar();
            if (parameterMatch(decPar, parList)) {
                return ((DecFunNode) this.decl.getDecl()).getRetType().typeCheck();
            }
        }
        System.out.println("Errore di dichiarazione FunNode");
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
            lookupAL += "lw\n";
        }
        String accessLink = "";
        String codeAdress = "";

        if (decl.getDecl() instanceof DecFunNode) {
            accessLink = "lfp\n" //ricarico il control link                
                    + lookupAL;
            codeAdress = "lfp\n" //Anche stavolta andiamo indietro per cercare lo scope di definzione della funzione
                    + lookupAL
                    /*
                     Trovato l'access link (frame pointer )dove è presente la dichiarazione della funzione
                     */
                    + "push " + decl.getOffSet() + "\n" // ora posso caricare l'offset dove è dichiarata la funzione
                    + "sub\n" // sottraggo e trovo l'indirizzo corretto
                    + "lw\n"; // la loadword carica l'indirzzo della funzione
        } else {
            accessLink = "lfp\n"// parte il codice per trovarci l'AL
                    + lookupAL
                    + "push " + (this.decl.getOffSet() + 1) + "\n"
                    + "sub\n"
                    + "lw\n";

            codeAdress = "lfp\n" //parte il codice per trovare l'indirizzo del codice della funzione chiamata
                    + lookupAL
                    + "push " + this.decl.getOffSet() + "\n"
                    + "sub\n"
                    + "lw\n";//trovato!
        }

        return "lfp\n" //  push control link (rif al AL (record di attivazione) del chiamante)
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
                + "js\n"; //effettua il salto all'indirizzo corretto
    }

    private boolean parameterMatch(ArrayList<Node> declParameter, ArrayList<Node> passedParameter) {
        //controllare che se è un funparnode
        System.out.println(declParameter+" "+ passedParameter);
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
                            //parameterMatch(parCheck, parCheckFunPar);
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