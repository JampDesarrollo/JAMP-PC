/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

/**
 *
 * @author Paula
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class PC01LoginController implements Initializable {

    @FXML
    private Label lblJAMP;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfContraseña;
    @FXML
    private Button btnOjo;
    @FXML
    private ImageView imgOjo;
    @FXML
    private Label lblError;
    @FXML
    private Button btnInicio;
    @FXML
    private Separator spSeparador;
    @FXML
    private Label lblCuenta;
    @FXML
    private Hyperlink hpLink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
}
