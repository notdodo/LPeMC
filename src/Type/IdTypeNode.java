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
            return this.getClass().getSimpleName();
    }

    @Override
    public String typeCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String codeGen() {
        return "";
    }
    
}
