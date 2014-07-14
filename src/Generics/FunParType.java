package Generics;

import Generics.Node;
import java.util.ArrayList;

/**
 * Classe per dichiarare le funzione tramite l'operatore freccia
 */
public class FunParType extends Node {

    private Node retType;
    private final ArrayList<Node> parList;

    public FunParType() {
        this.parList = new ArrayList<>();
    }

    // Aggiunge il tipo di ritorno
    public void addRet(Node rt) {
        this.retType = rt;
    }

    // Aggiunge i parametri
    public void addPar(Node n) {
        this.parList.add(n);
    }

    // Recupera i parametri
    public ArrayList<Node> getPar() {
        return this.parList;
    }

    // Recupera il tipo di ritorno
    public Node getRetType() {
        return this.retType;
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
        return "FunParType"
                + "[" + parString + ", "
                + this.retType.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        return this.retType.typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }
}
