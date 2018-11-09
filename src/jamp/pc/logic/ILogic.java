/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import messageuserbean.UserBean;

/**
 * Es la interfaz de lógica. Si hay que hacer una llamada entre dos objetos de
 * diferentes clases, se necesita una interfaz.
 * @author Paula
 */
public interface ILogic {
    /**
     * Metodo para el registro de un usuario. Comprobará con la base de datos 
     * si ese usuario existe o no.
     * @param user Usuario que recibe.
     * @throws UserLoginExistException excepcion que salta si el usuario que se 
     * quiere registrar existe.
     * @throws Exception excepcion que salta si no hay conexion con la base de datos.
     * 
     * Method for the registration of an user. It goes to the database to check if the user
     * already exist or not. 
     * @param user user that receives.
     * @throws UserLoginExistException If the user exist it throws this exception.
     * @throws Exception If there is not connection with the database jumps this exception.
     */

    public void userSignUp(UserBean user) throws UserLoginExistException, Exception;
    
    /**
     * Metodo para hacer el login del usuario. Comprueba con la base de datos si el usuario
     * y la contraseña de ese usuario son correctas.
     * @param user Usuario que recibe.
     * @return Devuelve el usuario.
     * @throws UserNotExistException Si el usuario no existe en la base de datos salta
     * esta excepcion.
     * @throws PasswordNotOkException Si la contraseña no concuerda con la de la
     * base de datos salta esta excepcion.
     * @throws Exception Si no hay conexión con la base de datos, salta esta 
     * excepcion.
     * 
     * Method for the user login.
     * @param user User that receives.
     * @return It returns the user.
     * @throws UserNotExistException If the login doesn't exist in the database it throws
     * this exception.
     * @throws PasswordNotOkException If the password doesn't exist it throws this exception.
     * @throws Exception If there is no connection with the database, throws this
     * exception
     * 
     */

    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException, Exception;

}
