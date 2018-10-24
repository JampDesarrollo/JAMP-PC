/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.logic.ILogic;
import jamp.pc.logic.ILogicImplementation;
import jamp.pc.logic.PasswordNotOkException;
import jamp.pc.logic.UserNotExistException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class PC01LoginController implements Initializable {

    private Stage stage;
    private static final Logger LOGGER = Logger.getLogger("package.class");
    private ILogic ilogic;
   

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
    @FXML
    private TextField tfContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /**
     * 
     * @param stage 
     */
    public void setStage(Stage stage) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.stage = stage;

    }
    
     public void setILogic(ILogic ILogic) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.ilogic=ILogic;
    }

    /**
     * 
     * @param root 
     */
    public void initStage(Parent root) {  //recibo el root, AHÍ tengo el archivo XML
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //creo la escena y le paso la que esta cargada en root
        Scene scene = new Scene(root);

        //asociar la escena con el escenario
        stage.setScene(scene);

        //titulo de la ventana
        stage.setTitle("Login");
        stage.setResizable(false);

        //cuando haga el metodo setOnShowing, haga el metodo handlewindowshowing
        stage.setOnShowing(this::handleWindowShowing);

        //muestro la ventana, me lleva al handlewindowshowing
        stage.show();

    }

    //metodo handlewindowshowing, que va a inicializar el estado de los componentes
    /**
     * 
     * @param event 
     */
    public void handleWindowShowing(WindowEvent event) {

        //los botones van a estar activos desde el primero momento
        btnInicio.setDisable(false);
        btnOjo.setDisable(false);
        hpLink.setDisable(false);
        
        
        //el label de informacion estará invisible
       lblError.setVisible(false);
        
        //crear acciones para los bototones en cuanto sean pulsados
        btnInicio.setOnAction((EventHandler<ActionEvent>) this); //el this es la referencia que le pasamos al método logIn, en este caso la referencia es el botón
        
        hpLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //cuando le doy al link de registrar
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //instancio el xml
                try {
                    FXMLLoader loader = new FXMLLoader(PC01LoginController.this.getClass().getResource("PC02RegistroController.fxml"));
                    //lo cargo en el root que es de tipo parent
                    Parent root = (Parent) loader.load();
                    //tengo que crear un nuevo escenario
                    stage = new Stage();
                    //obtener el controlador
                    PC02RegistroController controller = (PC02RegistroController) loader.getController();
                    //a ese controlador le paso el stage
                    controller.setStage(stage);
                    //inizializo el stage
                    controller.initStage(root);
                    //cierro la ventana de ahora
                    stage.hide();
                }catch (IOException ex) {
                    LOGGER.info("Error accediendo a la ventana");
                }
            }
        });
      
    }

    //hiperlink registrar
    //boton iniciar sesion
    /**
     * 
     * @param event 
     */
    public void logIn(ActionEvent event) {

        //va a mirar si los campos estan llenos o no
        boolean filled = chkAllFieldsFilled();

        //si los campos estan rellenos
        if (filled) {

            //comprobamos que estan correctamente llenos
            boolean correct = chkUserPassword();

            if (correct) {

                //si esta todo correcto que vaya a la ventana principal
                try {

                    //instancio el xml
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PC03Principal.fxml"));
                    //lo cargo en el root que es de tipo parent
                    Parent root = (Parent) loader.load();
                    //creo un nuevo escenario
                    stage = new Stage();
                    
                    //obtener el controlador
                    PC03PrincipalController controller = (PC03PrincipalController) loader.getController();

                    //a ese controlador le paso el stage
                    controller.setStage(stage);

                    //inizializo el stage
                    controller.initStage(root);

                    //cierro la ventana de ahora
                    stage.hide();

                } catch (IOException ex) {
                    //mensaje de "no se ha podido cargar la ventana"
                    LOGGER.info("Error accediendo a la ventana");

                }

            } else {
                //se pone el foco en los campos de la contraseña y usuario
                tfUsuario.requestFocus();
                pfContraseña.requestFocus();
                lblError.setVisible(true);
                lblError.setText("Usuario o contraseña inccorrecta");
                lblError.setStyle("-fx-text-inner-color: red;");

            }

        } else {

            //se va a enfocar los campos y se le va a cambiar el texto del label
            // enfocar los campos
            tfUsuario.requestFocus();
            pfContraseña.requestFocus();
            //hacer visible el texto
            lblError.setVisible(true);
            lblError.setText("Todos los campos deben de estar rellenos");
            lblError.setStyle("-fx-text-inner-color: red;");

        }

    }
    /**
     * 
     * @return devuelve un boolean de si 
     */
    private boolean chkAllFieldsFilled() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean isFilled = false;

        if (this.tfUsuario.getText().trim() != "" && this.pfContraseña.getText().trim() != "") {

            //si son diferentes a vacio, devuelve true, eso quiere decir que hay algo escrito
            isFilled = true;
        } else {
            isFilled = false;
        }

        return isFilled;

    }
    /**
     * 
     * @return
     * @throws UserNotExistException
     * @throws PasswordNotOkException
     * @throws Exception 
     */
    private boolean chkUserPassword(){
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        boolean notError = false;

        try {
//user bean 
//las excepciones en logica 
//usar la implementacion de logica
//llamo al metodo de iniciar sesion de la implementacion de logica

String nombre ="paula";



            // comprobar que esta correcto, vamos que en la bda existe 
            notError = true;
        } /*catch (UserNotExistException e) {
            notError = false;

        } catch (PasswordNotOkException e) {

            notError = false;

        }*/ catch (Exception e) {

            LOGGER.info("Error al conectar con la base de datos ");
        }

        return notError;
    }

   
   

}
