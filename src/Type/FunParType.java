package Type;

import Generics.Node;
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
public class FunParType extends Node {

    private Node retType;
    private final ArrayList<Node> parList;

    public FunParType() {
        this.parList = new ArrayList<>();
    }

    public void addRet(Node rt) {
        this.retType = rt;
    }

    public void addPar(Node n) {
        this.parList.add(n);
    }

    public ArrayList<Node> getPar() {
        return this.parList;
    }

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
        return this.getClass().getSimpleName()
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
