
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

/**
 *
 * @author Julen
 */
    

import jamp.pc.logic.ILogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class PC03PrincipalController {

    @FXML
    private MenuItem btnLogOut;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblEmail;

     /**
     * Maximum text fields length.
     */
    private final int MAX_LENGTH=255;
    /**
     * Logger object used to log messages for application.
     */
    protected static final Logger LOGGER=Logger.getLogger("jamp.pc.ui.controller");
     /**
     * The Stage object associated to the Scene controlled by this controller.
     * This is an utility method reference that provides quick access inside the 
     * controller to the Stage object in order to make its initialization. Note 
     * that this makes Application, Controller and Stage being tightly coupled.
     */
    protected Stage stage;
    private WindowEvent event;
    /**
     * Gets the Stage object related to this controller.
     * @return The Stage object initialized by this controller.
     */
    public Stage getStage(){
        return stage;
    }
    /**
     * Sets the Stage object related to this controller. 
     * @param stage The Stage object to be initialized.
     */
    public void setStage(Stage stage){
        this.stage=stage;
    }
    /**
     * The business logic object containing all business methods.
     */
    private ILogic iLogic;
    /**
     * Sets the business logic object to be used by this UI controller. 
     * @param usersManager An object implementing {@link UsersManager} interface.
     */
    
     /**
     * Initializes the controller class.
     */
    public void initStage(Parent root) throws IOException{
        LOGGER.info("Initializing Principal stage.");
        //Create a scene associated to the node graph root.
        Scene scene = new Scene(root);
        stage = new Stage();
        //Associate scene to primaryStage(Window)
        stage.setScene(scene);
        //Set window properties
        stage.setTitle("Principal");

        stage.setResizable(true);

        //Set window's events handlers
        stage.setOnShowing(this::windowShow);
        //Set control events handlers (if not set by FXML)

        

        //Show primary window
        stage.show();
    }
    
    private void windowShow(WindowEvent event){
        LOGGER.info("Beginning LoginController::windowShow");

        UserBean user = null;
       // lblDate.setText(user.getLastAccess());
        //lblEmail.setText(user.getEmail());
        //lblFullName.setText(user.getFullname());
        //lblLogin.setText(user.getLogin());

        btnLogOut.setMnemonicParsing(true);
        btnLogOut.setText("_Cerrar Sesion");
        
        btnLogOut.setOnAction(this::logOutAction);
    }
    

    public void logOutAction(ActionEvent event){
        
        try {
            //imLoading.setVisible(true);
            //instancio el xml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/PC01Login.fxml"));            
            //lo cargo en el root que es de tipo parent
            Parent root = (Parent) loader.load();         
            //tengo que crear un nuevo escenario
            stage = new Stage();
            //obtener el controlador
            PC01LoginController controller = (PC01LoginController) loader.getController();
            //le mando el objeto logica 
            // controller.setIlogic(ilogic);
            //a ese controlador le paso el stage
            controller.setStage(stage);
            //inizializo el stage
            controller.initStage(root);
            //cierro la ventana de ahora
            stage.close();
            } catch (IOException ex) {
            //mensaje de "no se ha podido cargar la ventana"
            LOGGER.info("Error accediendo a la ventana");

        } 
    }

}


