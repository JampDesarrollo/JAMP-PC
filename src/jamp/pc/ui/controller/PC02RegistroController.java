<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class for users sign up view. It contains event handlers
 *
 * @author ander
 */
public class PC02RegistroController {

    /**
     * Users Login text field
     */
    @FXML
    private TextField tfLogin;
    /**
     * Users Name and Surname text field
     */
    @FXML
    private TextField tfNomAp;
    /**
     * Users email text field
     */
    @FXML
    private TextField tfEmail;
    /**
     * Users Password password field
     */
    @FXML
    private PasswordField pfCtrs;
    /**
     * Repetition of the Password password field
     */
    @FXML
    private PasswordField pfRctrs;
    /**
     * Show written password button
     */
    @FXML
    private Button btnOjo;
    /**
     * Label to write the errors
     */
    @FXML
    private Label lblMal;
    /**
     * Go back to Login view button
     */
    @FXML
    private Button btnAtras;
    /**
     * User Signup button
     */
    @FXML
    private Button btnRegis;
    /**
     * Loading image view
     */
    @FXML
    private ImageView imgLoading;
    /**
     * Stage in which the scene will be loaded
     */
    private Stage stage;
    /**
     *
     */
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.ui.controller");
    /**
     *
     */
    private final int MAX_LENGTH = 255;

    private static final boolean EYESTATUS = true;

    /**
     * Method for initializing PC02Registro Stage.
     *
     * @param root The Parent object
     */
    public void initStage(Parent root) {
        try {
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sign Up");
            stage.setResizable(false);
            stage.setOnShowing(this::handleWindowShowing);
            btnAtras.setOnAction((ActionEvent event) -> {
                back();
            });
            btnOjo.setOnAction((ActionEvent event) -> {
                showPassword(EYESTATUS);
            });
            btnRegis.setOnAction((ActionEvent event) -> {
                regis();
            });
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "{0} No se ha podido abrir la ventana. \n ",
                    e.getMessage());
        }
    }

    /**
     * Initializes the window when shown.
     *
     * @param event
     */
    private void handleWindowShowing(WindowEvent event) {
        LOGGER.info("Beggining PC02RegistroController::handleWindowShowing");
        btnAtras.setDisable(false);
        btnOjo.setDisable(false);
        btnRegis.setDisable(false);
        lblMal.setVisible(false);
        imgLoading.setVisible(false);
        btnRegis.requestFocus();
    }

    private void back() {
        try{
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("view.PC01LoginController.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        PC01LoginController loginStageController
                = ((PC01LoginController) loader.getController());
        loginStageController.setStage(stage);
        loginStageController.initStage(root);
        }catch(IOException e){
            LOGGER.log(Level.INFO, "{0} No se ha podido abrir la ventana. \n ",
                    e.getMessage());
        }
        stage.close();
    }

    private void showPassword(boolean EYESTATUS1) {
        if (EYESTATUS1) {

        } else {

        }
        EYESTATUS1 = !EYESTATUS1;
    }

    private void regis() {

    }


}
