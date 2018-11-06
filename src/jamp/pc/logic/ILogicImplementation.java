/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import jamp.pc.logic.socketClient.SocketClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import messageuserbean.UserBean;

/**
 *
 * @author Julen
 */
public class ILogicImplementation implements ILogic {

    private final SocketClient socket = new SocketClient();
    private UserBean returnUser;
    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.logic.socketClient");

    @Override
    public void userSignUp(UserBean user) throws UserLoginExistException, Exception {
        LOGGER.info("userSignUp in ILogicImplementation");

        socket.signUp(user);

    }

    @Override
    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException, Exception {
        returnUser = socket.logIn(user);

        return returnUser;
    }

}
