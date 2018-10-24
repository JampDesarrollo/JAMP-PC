/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.logic.UserLoginExistException;
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
    private TextField tfFullName;
    /**
     * Users email text field
     */
    @FXML
    private TextField tfEmail;
    /**
     * Users Password password field
     */
    @FXML
    private TextField tfPassw;
    /**
     * Repetition of the Password password field
     */
    @FXML
    private TextField tfRpassw;
    /**
     * Show written password button
     */

    @FXML
    private PasswordField pfPassw;
    /**
     * Repetition of the Password password field
     */
    @FXML
    private PasswordField pfRpassw;
    /**
     * Show written password button
     */

    @FXML
    private Button btnEye;
    /**
     * Label to write the errors
     */
    @FXML
    private Label lblWrong;
    /**
     * Go back to Login view button
     */
    @FXML
    private Button btnBack;
    /**
     * User Signup button
     */
    @FXML
    private Button btnSignUp;
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
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.ui.controller");
    /**
     *
     */
    private final int MAX_LENGTH = 255;

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
            btnBack.setOnAction((ActionEvent event) -> {
                back();
            });
            btnEye.setOnAction((ActionEvent event) -> {
                showPassword();
            });
            btnSignUp.setOnAction((ActionEvent event) -> {
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
        btnBack.setDisable(false);
        btnEye.setDisable(false);
        btnSignUp.setDisable(false);
        lblWrong.setVisible(false);
        imgLoading.setVisible(false);
        tfPassw.setVisible(false);
        tfRpassw.setVisible(false);
        btnSignUp.requestFocus();
    }

    /**
     * Close current view and open Login view method.
     */
    private void back() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/jamp/pc/ui/view/PC01LoginController.fxml"));
            Parent root = (Parent) loader.load();
            stage = new Stage();
            PC01LoginController loginStageController
                    = ((PC01LoginController) loader.getController());
            loginStageController.setStage(stage);
            loginStageController.initStage(root);
            stage.hide();
        } catch (IOException e) {
            LOGGER.log(Level.INFO, "{0} No se ha podido abrir la ventana. \n ",
                    e.getMessage());
        }

    }

    /**
     * Method that sets visible or not visible password fields.
     */
    private void showPassword() {
        if (pfPassw.isVisible()) {
            //Change Passw textfield to visible
            tfPassw.setText(pfPassw.getText());
            pfPassw.setVisible(false);
            tfPassw.setVisible(true);
            //Change Rpassw textfield to visible
            tfRpassw.setText(pfRpassw.getText());
            pfRpassw.setVisible(false);
            tfRpassw.setVisible(true);
        } else {
            //Change Passw passwordfield to visible
            pfPassw.setText(tfPassw.getText());
            tfPassw.setVisible(false);
            pfPassw.setVisible(true);
            //Change Rpassw passwordfield to visible
            pfRpassw.setText(tfRpassw.getText());
            tfRpassw.setVisible(false);
            pfRpassw.setVisible(true);
        }
    }

    /**
     *
     */
    private void regis() {
        boolean filled = chkAllFieldsFilled();
        boolean fieldsLength = chkFieldsLength();
        boolean passwMatch = chkPasswMatch();
        boolean passwLen = chkPasswLength();
        try {
            if(filled && fieldsLength && passwMatch && passwLen){
                
            }
        } catch (UserLoginExistException e) {
            lblWrong.setText("Ese nombre de usuario existe");
            lblWrong.setStyle("-fx-text-inner-color: red;");
            LOGGER.severe("El login de usuario ya existe.");
        }

    }

    /**
     *  Method that check if all fields are filled
     * @return filled Boolean
     */
    private boolean chkAllFieldsFilled() {
        boolean filled = true;
        if (pfPassw.getText().trim().isEmpty()
                || tfEmail.getText().trim().isEmpty()
                || tfLogin.getText().trim().isEmpty()
                || tfFullName.getText().trim().isEmpty()) {
            filled = false;
            lblWrong.setText("Todos los campos tienen que estar rellenos");
            lblWrong.setStyle("-fx-text-inner-color: red;");
            lblWrong.setVisible(true);
        }
        //Set  textfield and passwordfiels border colors to red if not filled
        if (tfEmail.getText().trim().isEmpty()) {
            tfEmail.setStyle("-fx-border-color:red;");
        }

        if (tfLogin.getText().trim().isEmpty()) {
            tfLogin.setStyle("-fx-border-color: red;");
        }

        if (tfFullName.getText().trim().isEmpty()) {
            tfFullName.setStyle("-fx-border-color: red;");
        }

        if (pfPassw.getText().trim().isEmpty()) {
            pfPassw.setStyle("-fx-border-color: red;");
        }

        //Set textfields border colors to default if they're filled
        if (!tfEmail.getText().trim().isEmpty()) {
            tfEmail.setStyle("-fx-border-color: default;");
        }

        if (!tfLogin.getText().trim().isEmpty()) {
            tfLogin.setStyle("-fx-border-color: default;");
        }

        if (!tfFullName.getText().trim().isEmpty()) {
            tfFullName.setStyle("-fx-border-color: default;");
        }
        
        if (pfPassw.getText().trim().isEmpty()) {
            pfPassw.setStyle("-fx-border-color: default;");
        }

        return filled;
    }
    
    /**
     * Method that checks fields length
     * @return fieldsLength Boolean  
     */

    private boolean chkFieldsLength() {
        boolean fieldsLength = true;
        if (pfPassw.getText().trim().length() > MAX_LENGTH
                || tfEmail.getText().trim().length() > MAX_LENGTH
                || tfLogin.getText().trim().length() > MAX_LENGTH
                || tfFullName.getText().trim().length() > MAX_LENGTH) {
            fieldsLength = false;
            lblWrong.setText(lblWrong.getText()
                    + " La longitud máxima de los campos es de 255 caracteres.");
            lblWrong.setStyle("-fx-text-inner-color: red;");
            lblWrong.setVisible(true);
        }
        //Set textfields and passwordfiels border colors to red
        if (pfPassw.getText().trim().length() > MAX_LENGTH) {
            pfPassw.setText("");
            pfPassw.setStyle("-fx-border-color: red;");            
        }

        if (tfEmail.getText().trim().length() > MAX_LENGTH) {
            tfEmail.setStyle("-fx-border-color: red;");
        }

        if (tfLogin.getText().trim().length() > MAX_LENGTH) {
            tfLogin.setStyle("-fx-border-color: red;");
        }

        if (tfFullName.getText().trim().length() > MAX_LENGTH) {
            tfFullName.setStyle("-fx-border-color: red;");
        }
        
        //Set textfields and passwordfiels border colors to default
        if (pfPassw.getText().trim().length() < MAX_LENGTH) {
            pfPassw.setText("");
            pfPassw.setStyle("-fx-border-color: default;");            
        }

        if (tfEmail.getText().trim().length() < MAX_LENGTH) {
            tfEmail.setStyle("-fx-border-color: default;");
        }

        if (tfLogin.getText().trim().length() < MAX_LENGTH) {
            tfLogin.setStyle("-fx-border-color: default;");
        }

        if (tfFullName.getText().trim().length() < MAX_LENGTH) {
            tfFullName.setStyle("-fx-border-color: default;");
        }

        return fieldsLength;
    }
    
    /**
     * Method that checks passwords length
     * @return
     */
    private boolean chkPasswLength() {
        boolean passwLen = true;
        if(pfPassw.getText().length()<8){
            passwLen = false;
            pfPassw.setStyle("-fx-border-color: red;");
            lblWrong.setText(lblWrong.getText()
                    + "La contraseña tiene que tener 8 caracteres mínimo");
            lblWrong.setStyle("-fx-text-inner-color: red;");
            lblWrong.setVisible(true);
        }else{
            pfPassw.setStyle("-fx-border-color: default;");
        }
        return passwLen;
    }

    /**
     * Method that ckecks if the passwords match
     * @return passwMatch Boolean
     */
    private boolean chkPasswMatch() {
        boolean passwMatch = true;
        if(!pfPassw.getText().equals(pfRpassw.getText())){
            passwMatch = false;
            pfRpassw.setText("");
            pfRpassw.setStyle("-fx-border-color: red;");
            lblWrong.setText(lblWrong.getText()
                    + "La contraseña no coincide, inténtalo de nuevo.");
            lblWrong.setStyle("-fx-text-inner-color: red;");
            lblWrong.setVisible(true);
        }else{
            pfRpassw.setStyle("-fx-border-color: default;");
        }
        return passwMatch;
    }

    

}
