/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.logic.ILogic;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
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
     * The business logic object containing all business methods.
     */
    private ILogic ilogic;

    /**
     * UserBean objet
     */
    private UserBean user;

    /**
     * Maximum text fields length.
     */
    private final int MAX_LENGTH = 255;
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

    private WindowEvent event;

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
     * @param ILogic
     */
    public void setILogic(ILogic ILogic) {
        this.ilogic = ILogic;
    }

    /**
     * Set the user received in Login view for this view.
     *
     * @param user
     */
    public void setUser(UserBean user) {
        this.user = user;

    }

    /**
     * Initializes the controller class.
     *
     * @param root
     * @throws java.io.IOException
     */
    public void initStage(Parent root) throws IOException {
        LOGGER.info("Initializing Principal stage.");
        //Create a scene associated to the node graph root.
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //Associate scene to primaryStage(Window)
        stage.setScene(scene);
        stage.setResizable(false);
        //Set window properties
        stage.setTitle("Principal");
        //Set window's events handlers
        stage.setOnShowing(this::windowShow);
        btnLogOut.setOnAction(this::logOutAction);
        //Show primary window
        stage.show();
    }

    /**
     * Initializes the window when shown.
     *
     * @param event
     */
    private void windowShow(WindowEvent event) {
        LOGGER.info("Beginning Principal::windowShow");
        String date = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(user.getLastAccess());
        lblDate.setText("Último acceso: " + date);
        lblEmail.setText("Email: " + user.getEmail());
        lblFullName.setText("Nombre Completo: " + user.getFullname());
        lblLogin.setText("Login: " + user.getLogin());
        btnLogOut.setMnemonicParsing(true);
        btnLogOut.setText("_Cerrar Sesion");
    }

    /**
     * Close current view and open Login view method.
     *
     * @param event
     */
    public void logOutAction(ActionEvent event) {
        LOGGER.info("Beginning Principal::logout action");
        //Cerramos la ventana actual
        stage.hide();
    }

}
