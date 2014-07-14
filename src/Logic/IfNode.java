package Logic;

import Generics.MiniFunLib;
import Generics.Node;
import Type.BoolTypeNode;

/**
 * Classe per la gestione del nodo di controllo<br/>
 * ESEMPIO: if (a) then {1} else {2}
 */
public class IfNode extends Node {

    private final Node cond;
    private final Node th;
    private final Node el;

    /**
     * @param c Identifica la condizione da verificare
     * @param t Identifica il nodo THEN
     * @param e Identifica il nodo ELSE
     */
    public IfNode(Node c, Node t, Node e) {
        cond = c;
        th = t;
        el = e;
    }

    @Override
    public String toPrint() {
        return this.getClass().getSimpleName()
                + "[" + cond.toPrint() + ","
                + th.toPrint() + ","
                + el.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        if (MiniFunLib.isCompatible(cond, new BoolTypeNode())) {
            if (MiniFunLib.isCompatible(th, el)) {
                return el.typeCheck();
            } else {
                if (MiniFunLib.isCompatible(el, th)) {
                    return th.typeCheck();
                } else {
                    System.err.println("Type Error Else/Then " + this.getClass().getSimpleName());
                    System.exit(0);
                }
            }
        }
        System.out.println("Type Error Condition " + this.getClass().getSimpleName());
        System.exit(0);
        return "";
    }

    @Override
    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return cond.codeGen()
                + MiniFunLib.PUSH + MiniFunLib.TRUE + "\n"
                + MiniFunLib.BRANCHEQ + lab1 + "\n"
                + el.codeGen()
                + MiniFunLib.BRANCH + lab2 + "\n"
                + lab1 + ":\n"
                + th.codeGen()
                + lab2 + ":\n";
    }
}
