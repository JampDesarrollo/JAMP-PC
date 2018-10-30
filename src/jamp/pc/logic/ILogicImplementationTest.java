/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jamp.pc.logic;


import jamp.pc.ui.controller.UserBean;
import java.util.ArrayList;

/**
 *
 * @author 2dam
 */


public class ILogicImplementationTest implements ILogic{
    private ArrayList<UserBean>users;
    
//metodo para la vista         
public void login(UserBean user){ //va a recibir un objeto usuario

    //crear un array list de usuarios
    
    
    for (int i = 0; i < 10; i++) {
        
        //tengo que mirar el usuario que le llega y ver si esta o no
        user.setLogin("login" + i); //creo 10 usuarios
        user.setPassword("pass "+ i); //creo 10 password
        users.add(user);
   
        
    }

    private ArrayList<UserBean> users = new ArrayList<UserBean>();
    private UserBean usu;

//comprobando que el login existe 

public void isLoginExisting(UserBean usuario){
    for (int i = 0; i < 10; i++) {
        UserBean user = new UserBean();
        //tengo que mirar el usuario que le llega y ver si esta o no
        user.setLogin("login" + i); //creo 10 usuarios
        user.setPassword("pass "+ i); //creo 10 password
        users.add(user);
   
        
    }
        //LOGGER.info("Validating Login existence.");
        if (users.stream().filter(user->usuario.getLogin().equals(user.getLogin())).count()!=0){
           // LOGGER.severe("El login existe.");
            

        }

        return usu;
    }

    @Override
    public void userSignUp(UserBean user) throws UserLoginExistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public UserBean userLogin(UserBean user) throws UserNotExistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
