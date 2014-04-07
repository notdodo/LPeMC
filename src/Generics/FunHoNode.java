package Generics;


import Type.FunParType;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edoardo
 */
class FunHoNode extends FunNode {

    public FunHoNode(STentry decl, int diffNesting,
            ArrayList<Node> parList) {
        super(decl, diffNesting, parList);
    }

    @Override
    public String toPrint() {
        return super.toPrint();
        // String funParamsToPrint = "<FunParams>";
        // for (Node p : funParams) {
        // funParamsToPrint += p.toPrint();
        // }
        // funParamsToPrint += "</FunParams>";
        //
        // // ATTENZIONE SI POTREBBE ANDARE IN LOOP!!!! FUNZIONE CHE CHIAMA SE
        // // STESSA E QUINDI NON SI FINISCE? PER QUESTO INSERISCO L'OFFSET E
        // NON
        // // RICHIAMO LA FUNZIONE.
        // return "<HigherOrderFunNode><FunDiffNesting>" + diffNesting +
        // "</FunDiffNesting>"
        // + "<FunSTEntryOffset>" + funEntry.getOffSet()
        // + "</FunSTEntryOffset>" + funParamsToPrint + "</HigherOrderFunNode>";
    }

    @Override
    public String typeCheck() {
        if (decl.getDecl() instanceof DecParNode) {
            // Recupero parametri dalla dichiarazione della funzione
            ArrayList<Node> decFunPar = ((FunParType) ((DecParNode) decl.getDecl()).getType()).getPar();
            // Controllo di avere lo stesso numero di parametri
            if (decFunPar.size() == parList.size()) {
                // Controllo ad uno ad un la compatibilità dei Parametri con la
                // loro dichiarazione
                for (int i = 0; i < parList.size(); i++) {
                    if (!MiniFunLib.isCompatible(decFunPar.get(i), parList.get(i))) {
                        System.out.println("Type Error FunHoNode: Parametri incompatibili:"
                                        + decFunPar.get(i).typeCheck()
                                        + ", "
                                        + parList.get(i).typeCheck());
                        System.exit(0);
                    }
                }
                return ((DecParNode)decl.getDecl()).getType().typeCheck();
            } else {
                System.out.println("Type Error FunHoNode: Numero parametri sbagliato"
                                + decFunPar.size()
                                + ", "
                                + parList.size());
                System.exit(0);
                return "";
            }
        }
        return "";
    }

    @Override
    public String codeGen() {
        // Costruisco l'activation link

        String parCode = "";
        String lookupAL = "";

        // Codice per PUSH parametri. I parametri vengono caricati al contrario
        for (int i = this.parList.size() - 1; i >= 0; i--) {
            parCode += (this.parList.get(i)).codeGen();
        }
        // Scorro access link per recuperare AL del padre sintattico della
        // funzione da chiamare
        for (int i = 0; i < diffNesting; i++) {
            lookupAL += "lw\n";
        }
/*
        
        Questo codice serve per passare la chiusura
        
        */

        String code
                = 
                "lfp\n" //Control Link
                + 
                parCode//codice parametri
                + 
                "lfp\n"// parte il codice per trovarci l'AL
                + lookupAL
                + 
                "push " + (this.decl.getOffSet() + 1) + "\n"
                + "sub\n"
                + "lw\n" //abbiamo trovato l'access link
                
                +"lfp\n" //parte il codice per trovare l'indirizzo del codice della funzione chiamata
                + lookupAL
                + 
                "push " + this.decl.getOffSet() + "\n"
                + "sub\n" + "lw\n" //trovato!
                 
                + "js\n"; //effettuiamo dunque il salto

        return code;
    }
}
