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
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class PC03PrincipalController  {

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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
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
    public void setUsersManager(ILogic usersManager){
        this.iLogic=usersManager;
    }
    
     /**
     * Initializes the controller class.
     */
    public void initStage(Parent root) throws IOException {
        LOGGER.info("Initializing Principal stage.");
        //Create a scene associated to the node graph root.
        Scene scene = new Scene(root);
        stage = new Stage();
        //ventana modal
        stage.initModality(Modality.APPLICATION_MODAL); // para que la ventana de login este detras, pero no haga nada
       
        //Associate scene to primaryStage(Window)
        stage.setScene(scene);
        
        //Set window properties
        stage.setTitle("Principal");
        stage.setResizable(false);
        
        //Set window's events handlers
        stage.setOnShowing(this::handleWindowShowing);
        //Set control events handlers (if not set by FXML)
      
        //Show primary window
        stage.show();
    }
    
    private void handleWindowShowing(WindowEvent event){
        LOGGER.info("Beginning LoginController::windowShow");
      
        lblDate.setText("10/05/2018");
        lblEmail.setText("jampdesarrollo@gmail.com");
        lblFullName.setText("Jamp Desarrollo");
        lblLogin.setText("Jamp");
       
        btnLogOut.setMnemonicParsing(true);
        btnLogOut.setText("_Cerrar Sesion");
        
    } 


    private javafx.event.EventHandler<javafx.event.ActionEvent> 
        logOutAction(WindowEvent event1) throws IOException /*throws IOException*/ {
        //Shows view from GestionUsuarios.fxml
        //Load node graph from fxml file
        
        FXMLLoader loader=
          new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/Login.fxml"));
       
        Parent root = (Parent)loader.load();
         
            //Logger.getLogger(PC03PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        
        //Get controller for graph 
        PC01LoginController controller=
                ((PC01LoginController)loader.getController());
        

        controller.setILogic(iLogic); 
        controller.setStage(stage);//Initializes stage

        controller.initStage(root);
        //hides login stage
       stage.hide();
        return null;
    }

   


}
