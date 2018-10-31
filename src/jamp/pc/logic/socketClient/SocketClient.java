/*
 * 
 * EXCHANGE OBJETS
 * 
 * 
 */
package jamp.pc.logic.socketClient;

import jamp.pc.logic.PasswordNotOkException;
import jamp.pc.logic.UserLoginExistException;
import jamp.pc.logic.UserNotExistException;
import messageuserbean.UserBean;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import messageuserbean.Message;

public class SocketClient {

    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.logic.socketClient");
    /**
     *
     */
    private final String PORT = ResourceBundle.getBundle("jamp.pc.logic.socketClient.config").getString("PORT");
    /**
     *
     */
    private final String IP = ResourceBundle.getBundle("jamp.pc.logic.socketClient.config").getString("IP");

    /**
     *
     * @param user
     * @return
     */
    public UserBean logIn(UserBean user) {

        Socket client = null;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        UserBean returnBean = null;
        try {
            //Socket creation and Input and output streams creation on the socket
            client = new Socket(IP, Integer.parseInt(PORT));
            output = new ObjectOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());

            //Write on the socket.
            Message message = new Message(2, user);
            output.writeObject(message);
            //Read from the socket.
            Message received = (Message) input.readObject();
            int mess = received.getCode();
            returnBean = (UserBean) received.getUser();

            switch (mess) {
                //aqui habia un case 2:
                case 21:
                    throw new PasswordNotOkException();
                case 22:
                    throw new UserNotExistException();
                case -2:
                    throw new Exception();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        return returnBean;
    }

    /**
     *
     * @param user
     */
    public void signUp(UserBean user) throws UserLoginExistException, Exception {

        Socket client = null;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            //Socket creation and Input and output streams creation on the socket
            client = new Socket(IP, Integer.parseInt(PORT));
            output = new ObjectOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());
            LOGGER.info("En socketclient");
            //Write on the socket.
            Message message = new Message(1, user);
            output.writeObject(message);
            //Read from the socket.
            Message received = (Message) input.readObject();
            int mess = received.getCode();
            //returnBean = (UserBean) received.getUser();

            switch (mess) {
                //aqui habia un case 2:
                case 11:
                    throw new UserLoginExistException();
                case -1:
                    throw new Exception();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Error Exception", e.getMessage());
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
               System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
