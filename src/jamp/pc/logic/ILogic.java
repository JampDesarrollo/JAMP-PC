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
 *
 * @author Paula
 */
public interface ILogic {

    /**
     * already exist or not.
     *
     * @param user user that receives.
     * @throws UserLoginExistException If the user exist it throws this
     * exception.
     * @throws Exception If there is not connection with the database jumps this
     * exception.
     */

    public void userSignUp(UserBean user) throws UserLoginExistException, Exception;

    /**
     *
     * Method for the user login.
     *
     * @param user User that receives.
     * @return It returns the user.
     * @throws UserNotExistException If the login doesn't exist in the database
     * it throws this exception.
     * @throws PasswordNotOkException If the password doesn't exist it throws
     * this exception.
     * @throws Exception If there is no connection with the database, throws
     * this exception
     *
     */
    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException, Exception;

}
