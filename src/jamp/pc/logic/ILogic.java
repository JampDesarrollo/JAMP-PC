/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import jamp.pc.ui.controller.UserBean;

/**
 *
 * @author Paula
 */
public interface ILogic {
    

public void userSignUp(UserBean user) throws UserLoginExistException;

public void UserLogin(UserBean user) throws UserNotExistException;

}
