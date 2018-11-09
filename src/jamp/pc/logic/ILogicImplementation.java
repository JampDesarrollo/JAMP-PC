/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.logic;

import jamp.pc.logic.socketClient.SocketClient;
import java.util.logging.Logger;
import messageuserbean.UserBean;

/**

 * Clase que implementa la interfaz de Logica.
 * Class that implements the logic interface.

 * @author Julen
 */
public class ILogicImplementation implements ILogic {
    
    /**
     * Atributo para el socket del cliente. Sirve para conectar con el socket 
     * del cliente.
     * Attribute for the socket client. We need it to connect to the socket.
     * 
     */
    private final SocketClient socket = new SocketClient();
    
    /**
     * Atributo para el usuario. El metodo login tiene que devolver un usuario.
     *  Attribute to return the user.
     */
    private UserBean returnUser;
    
    /**
     * Atributo para poder sacar textos de información.
     * Attribute to appear the information text.
     */
    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.logic.socketClient");
    
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

    /**
     * This method register a new UserBean in database
     * @param user The UserBean object to be added
     * @throws UserLoginExistException, Exception.
     */
    @Override
    public void userSignUp(UserBean user) 
            throws UserLoginExistException, Exception {
        LOGGER.info("userSignUp in ILogicImplementation");

        socket.signUp(user);

    }

    
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
  

    @Override
    public UserBean userLogin(UserBean user) 
            throws UserNotExistException, PasswordNotOkException, Exception {
        returnUser = socket.logIn(user);

        return returnUser;
    }

}