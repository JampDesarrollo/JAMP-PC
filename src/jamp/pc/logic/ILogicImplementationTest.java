/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package jamp.pc.logic;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import jamp.pc.ui.controller.UserBean;
import java.util.ArrayList;

/**
 *
 * @author 2dam
 */
/*
public class ILogicImplementationTest {

    private ArrayList<UserBean> users = new ArrayList<UserBean>();
    private UserBean usu;

//comprobando que el login existe 
    //  @Override
    public void userSignUp(UserBean user) throws UserLoginExistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // @Override
    public UserBean UserLogin(UserBean user) throws UserNotExistException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        //creo los usuarios y las password
        for (int i = 0; i < 10; i++) {
            usu = new UserBean(); // voy a crear 10 usuarios
            usu.setLogin("login" + i); //le añado a los usuarios el login  y el password
            usu.setPassword("pass " + i);
            users.add(usu); // meto a l usuario en el array list de los usuarios

        }
        
        //compruebo si existe o no 
        LOGGER.info("Validating Login existence.");
        if (users.stream().filter(usu -> usu.getLogin().equals(user.getLogin())).count() != 0) {
            LOGGER.severe("El usuario existe.");

        }

        return usu;
    }

}
*/