package List;

import Generics.MiniFunLib;
import Generics.Node;

public class ListNode extends Node {

    private final Node first;
    private final Node rest;
    private boolean typeChecked = false;
    private String typeString = "";

    public ListNode(Node f, Node r) {
        first = f;
        rest = r;
    }

    @Override
    public String toPrint() {
        return "ListNode"
                + "[" + first.toPrint() + ","
                + rest.toPrint()
                + "]";
    }

    // genera ricorsione quindi mi serve un flag di stop
    @Override
    public String typeCheck() {
        if (!this.typeChecked) {
            this.typeChecked = true;
            // type check della lista meno il first
            String listRest = this.rest.typeCheck();
            // creo il tipo LIST:type
            String listFirst = MiniFunLib.LIST + this.first.typeCheck();
            // se la lista è vuota (EMPTY) o i tipi di first e rest sono uguali
            if (this.rest instanceof EmptyNode || (listFirst).equals(listRest)) {
                typeString = listFirst;
                return listFirst;
            } else {
                System.out.println("Type Error " + this.getClass().getSimpleName());
                System.exit(0);
            }
        }
        return typeString;
    }

    @Override
    public String codeGen() {
        return first.codeGen()
                + rest.codeGen()
                + "push 1\n"
                + MiniFunLib.LOADHP
                + MiniFunLib.ADD
                + MiniFunLib.STOREW
                + MiniFunLib.LOADHP
                + MiniFunLib.STOREW
                + MiniFunLib.LOADHP
                + "push 2\n"
                + MiniFunLib.LOADHP
                + MiniFunLib.ADD
                + MiniFunLib.STOREHP;
    }

}
