/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import jamp.pc.logic.socketClient.SocketClient;
import jamp.pc.ui.controller.UserBean;

/**
 *
 * @author Julen
 */
public class ILogicImplementation implements ILogic {

    private SocketClient socket;
    private UserBean returnUser;
    
    @Override
    public void userSignUp(UserBean user) throws UserLoginExistException {
        socket.signUp(user);
    }

    @Override
    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException {
       returnUser = socket.logIn(user);
        
        return returnUser;
    }
  
}
