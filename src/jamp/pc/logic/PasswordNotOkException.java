/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

/**
 * Clase de excepcion para cuando la contraseña no esta bien Excepction class
 * for when the password doesn't exist.
 *
 * @author paula
 */
public class PasswordNotOkException extends Exception {

    public PasswordNotOkException(String msg) {

        super(msg);

    }

    public PasswordNotOkException() {
    }

}
