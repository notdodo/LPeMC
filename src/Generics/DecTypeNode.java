/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Generics;

/**
 *
 * @author Fabio Limardo
 */
public class DecTypeNode extends Node{
    
    private String id;
    
    public DecTypeNode (String idType){
        id=idType;
    }
    
    @Override
    public String toPrint(){
        return "";
    }
    
    @Override
    public String typeCheck(){
        return "";
    }

    @Override
    public String codeGen() {
        return "";
    }
    
    
    
}
