package Type;

import Generics.*;

public class IdTypeNode extends Node {

    private STentry id;

    public IdTypeNode(STentry idp) {
        id = idp;
    }

    @Override
    public String toPrint() {
        return "IdTypeNode[" + this.id.toPrint() + "]";
    }

    @Override
    public String typeCheck() {
        return this.id.getDecl().typeCheck();
    }

    @Override
    public String codeGen() {
        return "";
    }

}
