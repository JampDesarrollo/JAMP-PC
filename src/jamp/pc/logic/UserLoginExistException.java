/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

/**
 * Exception thrown when the user login exist on database
 *
 * @author ander
 */
public class UserLoginExistException extends Exception {

    public UserLoginExistException(String msg) {
        super(msg);
    }

    public UserLoginExistException() {

    }
}
