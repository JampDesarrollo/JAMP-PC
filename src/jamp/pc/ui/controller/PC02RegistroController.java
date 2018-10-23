/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class PC02RegistroController implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfNomAp;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField pfCtrs;
    @FXML
    private PasswordField pfRctrs;
    @FXML
    private Button btnOjo;
    @FXML
    private Label lblMal;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnRegis;
    @FXML
    private ImageView imgLoading;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
