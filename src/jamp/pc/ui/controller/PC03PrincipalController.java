/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.logic.ILogic;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import messageuserbean.UserBean;

/**
 * FXML Controller class for users Log out view. It contains event handlers
 *
 * @author Julen
 */
public class PC03PrincipalController {

    /**
     * Log out menu item
     */
    @FXML
    private MenuItem btnLogOut;
    
    /**
     * Log out menu item
     */
    @FXML
    private Button btnLogOut2;
 
    /**
     * Last access date label
     */
    @FXML
    private Label lblDate;
    /**
     * Users Login label
     */
    
    @FXML
    private Label lblLogin;
    /**
     * Users Full name label
     */
    
    @FXML
    private Label lblFullName;

    /**
     * Users Email Label
     */
    @FXML
    private Label lblEmail;
    
    /**
     * Menu 
     */
    @FXML
    private Menu menu;
    
    /**
     * To close app or session
     */
    private int cerrar;

    /**
     * The business logic object containing all business methods.
     */
    private ILogic ilogic;

    /**
     * UserBean object
     */
    private UserBean user;

    /**
     * Logger object used to log messages for application.
     */
    protected static final Logger LOGGER = Logger.getLogger("jamp.pc.ui.controller");
    /**
     * The Stage object associated to the Scene controlled by this controller.
     * This is an utility method reference that provides quick access inside the
     * controller to the Stage object in order to make its initialization. Note
     * that this makes Application, Controller and Stage being tightly coupled.
     */
    protected Stage stage;

    /**
     * Gets the Stage object related to this controller.
     *
     * @return The Stage object initialized by this controller.
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Sets the Stage object related to this controller.
     *
     * @param stage The Stage object to be initialized.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Set logic for this view controller
     *
     * @param ILogic ilogic
     */
    public void setILogic(ILogic ILogic) {
        this.ilogic = ILogic;
    }

    /**
     * Set the user received in Login view for this view.
     *
     * @param user Userbean user
     */
    public void setUser(UserBean user) {
        this.user = user;

    }

    /**
     * Initializes the controller class.
     *
     * @param root root
     * @throws java.io.IOException InputOuput exception
     */
    public void initStage(Parent root) throws IOException {
        LOGGER.info("Initializing Principal stage.");
        //Create a scene associated to the node graph root.
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //Associate scene to primaryStage(Window)
        stage.setScene(scene);
        stage.setResizable(true);
        //Set window properties
        stage.setTitle("Principal");
        //Set window's events handlers
        stage.setOnShowing(this::windowShow);
        
        btnLogOut.setOnAction(this::logOutAction);
        btnLogOut2.setOnAction(this::logOutAction);
        //Show primary window
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent e) -> {
            cerrar = 1;
            e.consume();
            cerrarSesionAlert(cerrar);

        });
    }

    /**
     * Initializes the window when shown.
     *
     * @param event WindowEvent event
     */
    private void windowShow(WindowEvent event) {
        LOGGER.info("Beginning Principal::windowShow");
        
        String date = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(user.getLastAccess());
        
        lblDate.setText("Último acceso: " + date);
        lblEmail.setText("Email: " + user.getEmail());
        lblFullName.setText("Nombre Completo: " + user.getFullname());
        lblLogin.setText("Login: " + user.getLogin());
        
        menu.setMnemonicParsing(true);
        menu.setText("_Menu");
        
        btnLogOut.setMnemonicParsing(true);
        btnLogOut.setText("_Cerrar Sesion");
        btnLogOut.setAccelerator(
                new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

        btnLogOut2.setMnemonicParsing(true);
        btnLogOut2.setText("_Cerrar Sesion");
    }

    /**
     * Close current view and open Login view method.
     *
     * @param event Action Event
     */
    public void logOutAction(ActionEvent event) {
        LOGGER.info("Beginning Principal::logout action");
        cerrar = 2;
        cerrarSesionAlert(cerrar);
    }
    
        /**
     * Method that show a confirm dialog to close session
     * @param cerrar Difference for close app or close session
     */
    public void cerrarSesionAlert(int cerrar){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Dialogo de confirmacion");
        alert.setContentText("Estas seguro que deseas cerrar la sesion");
        alert.setHeaderText("Cerrar Sesion");
        
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("okButton");
        
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("cancelButton");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(cerrar == 1){
                System.exit(0);
            }else{
                stage.hide();
            }
  
        }
    }

}
