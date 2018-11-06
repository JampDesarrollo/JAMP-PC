/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import messageuserbean.UserBean;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

/**
 *
 * @author 2dam
 */
public class ILogicImplementationTest implements ILogic {

    private final ArrayList<UserBean> users = new ArrayList<>();

    public ILogicImplementationTest() { //va a recibir un objeto usuario

        //crear un array list de usuarios
        for (int i = 0; i < 10; i++) {
            UserBean user = new UserBean();
            //tengo que mirar el usuario que le llega y ver si esta o no
            user.setLogin("login" + i); //creo 10 usuarios
            user.setPassword("pass " + i); //creo 10 password
            user.setFullname("login" + i);
            users.add(user);
        }

    }
//metodo para la vista         

    @Override
    public void userSignUp(UserBean user) throws UserLoginExistException {
        if (users.stream().filter(u -> u.getLogin().equals(user.getLogin())).count() != 0) {
            throw new UserLoginExistException();
        } else {
            users.add(user);
        }
    }

    @Override
    public UserBean userLogin(UserBean user) throws UserNotExistException, PasswordNotOkException {
        List usersWithLogin = users.stream().filter(u -> u.getLogin().equals(user.getLogin())).collect(Collectors.toList());
        UserBean usser;
        if (usersWithLogin.size() == 0) {
            throw new UserNotExistException();

        } else if (!((UserBean) usersWithLogin.get(1)).getPassword().equals(user.getPassword())) {

            throw new PasswordNotOkException();

        } else {
            usser= ((UserBean) usersWithLogin.get(1));
        }
        return usser;
    }

}
