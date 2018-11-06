/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import messageuserbean.UserBean;

/**
 *
 * @author Paula
 */
public interface ILogic {

    public void userSignUp(UserBean user) throws UserLoginExistException;

    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException;

}
