/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Julen
 */
public class ILogicFactory {
    
    public static ILogic getILogic(){
    
   return new ILogicImplementation();
   //return new ILogicImplementationTest();
    }
    
}

