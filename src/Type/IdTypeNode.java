/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Type;

import Generics.*;


public class IdTypeNode extends Node {
    
    private STentry id;
    
    public IdTypeNode (STentry idp){
        id = idp;
    }
    
    @Override
    public String toPrint() {
        return this.id.toPrint();
    }

    @Override
    public String typeCheck() {
        System.out.println(this.id.getDecl());
        return "";
    }

    @Override
    public String codeGen() {
        return "";
    }
    
}
