package Generics;

import java.util.ArrayList;

// creato per utilizzare funzioni e variabili locali
public class LetNode extends Node {

    private final ArrayList<Node> astList;
    private final Node exp;
    // se si tratta di un let dichiarato internamente ad una funzione
    private final boolean localLet;

    public LetNode(ArrayList<Node> list, Node exp, boolean localLet) {
        this.astList = list;
        this.exp = exp;
        this.localLet = localLet;
    }

    public ArrayList<Node> getDecl() {
        return this.astList;
    }

    @Override
    public String toPrint() {
        String left = "";
        for (Node obj : astList) {
            left += obj.toPrint();
        }
        return this.getClass().getSimpleName() 
                + "[" + left + "," + exp.toPrint() 
                + "]";
    }

    @Override
    public String typeCheck() {
        // controllo l'albero fino ad ora ottenuto e l'espressione dentro IN
        for (int i = 0; i < this.astList.size(); i++) {
            this.astList.get(i).typeCheck();
        }
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        String code = "";
        // alloco le variabili
        for (int i = 0; i < this.astList.size(); i++) {
            code += this.astList.get(i).codeGen();
        }

        if (this.localLet) {
            return "// LetNode\n" + code + this.exp.codeGen() + "// END LetNode\n";
        } else {
            return "// LetNode\n" + code + this.exp.codeGen() 
                    + MiniFunLib.HALT
                    + MiniFunLib.getFunctionCode() + "// END LetNode\n";
        }
    }

}
