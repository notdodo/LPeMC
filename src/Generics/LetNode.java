package Generics;

import java.util.ArrayList;

/**
 * Classe creata per dichiarare funzioni e variabili nel linguaggio
 */
public class LetNode extends Node {

    private final ArrayList<Node> astList;
    private final Node exp;
    // flag per riconoscere un let locale
    private final boolean localLet;

    /**
     * @param list Identifica le dichiarazioni
     * @param exp Identifica il codice da eseguire
     * @param localLet Identifica se il let è locale
     */
    public LetNode(ArrayList<Node> list, Node exp, boolean localLet) {
        this.astList = list;
        this.exp = exp;
        this.localLet = localLet;
    }

    // Recupera la dichiarazione
    public ArrayList<Node> getDecl() {
        return this.astList;
    }

    @Override
    public String toPrint() {
        String left = "";
        for (Node obj : astList) {
            left += obj.toPrint();
        }
        return "LetNode"
                + "[" + left + "," + exp.toPrint()
                + "]";
    }

    @Override
    public String typeCheck() {
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

        // Se è un let interno
        if (this.localLet) {
            return "// LetNode\n" + code + this.exp.codeGen() + "// END LetNode\n";
        } else {
            return "// LetNode\n" + code + this.exp.codeGen()
                    + MiniFunLib.HALT
                    + MiniFunLib.getFunctionCode() + "// END LetNode\n";
        }
    }
}
