package List;

import Generics.MiniFunLib;
import Generics.Node;

public class ListNode extends Node {

    private final Node first;
    private final Node rest;
    private boolean typeChecked = false;
    private final String typeString = "";

    public ListNode(Node f, Node r) {
        first = f;
        rest = r;
    }

    @Override
    public String toPrint() {
        return "ListNode[" + first.toPrint() + ","
                + rest.toPrint() + "]";
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
                return listFirst;
            }
        } else {
            System.out.println("Type Error " + this.getClass().getSimpleName());
            System.exit(0);
        }
        return "";
    }

    @Override
    public String codeGen() {
        return first.codeGen()
                + rest.codeGen()
                + "push 1\n" + "lhp\n" + "add\n" + "sw\n"
                + "lhp\n" + "sw\n"
                + "lhp\n"
                + "push 2\n" + "lhp\n" + "add\n" + "shp\n";
    }

}
