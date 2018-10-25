/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import jamp.pc.logic.ILogic;
import jamp.pc.logic.ILogicImplementation;
import jamp.pc.logic.PasswordNotOkException;
import jamp.pc.logic.UserNotExistException;
import static jamp.pc.ui.controller.PC03PrincipalController.LOGGER;
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
    private static final int MAX_CARACT = 255;

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
    @FXML
    private ImageView imLoading;

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
        this.ilogic = ILogic;
    }

    /**
     *
     * @param root
     */
    public void initStage(Parent root) {  //recibo el root, AHÍ tengo el archivo XML
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        LOGGER.info("Initializing Login ");
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

        imLoading.setVisible(false);

        //el label de informacion estará invisible
        lblError.setVisible(false);

        //crear acciones para los bototones en cuanto sean pulsados
        //el this es la referencia que le pasamos al método logIn, en este caso la referencia es el botón
        btnInicio.setOnAction((ActionEvent ev) -> {
            logIn();
        });
        hpLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //cuando le doy al link de registrar
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                try {

                    imLoading.setVisible(true);
                    //instancio el xml
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/PC02Registro.fxml"));
                    LOGGER.info("haa");
                    //lo cargo en el root que es de tipo parent
                    Parent root = (Parent) loader.load();
                    LOGGER.info("paula");
                    //tengo que crear un nuevo escenario
                    stage = new Stage();
                    LOGGER.info("holaaaaa");
                    //obtener el controlador
                    PC02RegistroController controller = (PC02RegistroController) loader.getController();
                    //le mando el objeto logica 
                    // controller.setIlogic(ilogic);
                    //a ese controlador le paso el stage

                    controller.setStage(stage);
                    //inizializo el stage

                    controller.initStage(root);
                    //cierro la ventana de ahora
                    stage.hide();

                } catch (IOException ex) {
                    LOGGER.info("Error accediendo a la ventana");
                }
            }
        });

        btnOjo.setOnAction((ActionEvent ev) -> {
            showPassword();
        });
        
    }

    //hiperlink registrar
    //boton iniciar sesion
    /**
     *
     * @param event
     */
    public void logIn() {

        //va a mirar si los campos estan llenos o no
        boolean filled = chkAllFieldsFilled();

        //si los campos estan rellenos  y con menos o igual de caracteres que 255
        if (filled) {

            //comprobamos que existen el usuario y la contraseña
            boolean correct = chkUserPassword(); //le envio el texto de lo que ha puesto en los campos

            if (correct) {
                showPassword();
               
                //si esta todo correcto que vaya a la ventana principal
                try {
                    imLoading.setVisible(true);
                    //instancio el xml
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/PC03Principal.fxml"));
                    LOGGER.info("haa");
                    //lo cargo en el root que es de tipo parent
                    Parent root = (Parent) loader.load();
                    LOGGER.info("paulas");
                    //tengo que crear un nuevo escenario
                    stage = new Stage();
                    LOGGER.info("holaaaaa");
                    //obtener el controlador
                    PC03PrincipalController controller = (PC03PrincipalController) loader.getController();
                    //le mando el objeto logica 
                    // controller.setIlogic(ilogic);
                    //a ese controlador le paso el stage
                    LOGGER.info("muy bien");
                    controller.setStage(stage);
                    //inizializo el stage
                    LOGGER.info("perfect");
                    controller.initStage(root);
                    //cierro la ventana de ahora

                    stage.hide();

                } catch (IOException ex) {
                    //mensaje de "no se ha podido cargar la ventana"
                    LOGGER.info("Error accediendo a la ventana");

                }

            } else {

                //se pone el foco en los campos de la contraseña y usuario
                btnInicio.requestFocus();
                //que este en rojo
                tfUsuario.setStyle("-fx-border-color: red;");
                pfContraseña.setStyle("-fx-border-color: red;");
                //que el texto sea visible 
                lblError.setText("Usuario o contraseña inccorrecta");
                lblError.setVisible(true);
                lblError.setStyle("-fx-text-inner-color: red;");

            }

        } else {

            //se va a enfocar los campos y se le va a cambiar el texto del label
            // enfocar los campos
            if (tfUsuario.getText().trim().equals("") && pfContraseña.getText().trim().equals("")) {
                btnInicio.requestFocus();
                //que este en rojo
                tfUsuario.setStyle("-fx-border-color: red;");
                pfContraseña.setStyle("-fx-border-color: red;");
                //hacer visible el texto
                lblError.setText("Todos los campos deben de estar rellenos");
                lblError.setVisible(true);
                lblError.setStyle("-fx-text-inner-color: red;");
            } else if (tfUsuario.getText().trim().equals("")) {
                btnInicio.requestFocus();
                //que este en rojo
                tfUsuario.setStyle("-fx-border-color: red;");
                lblError.setText("Todos los campos deben de estar rellenos");
                lblError.setVisible(true);
                lblError.setStyle("-fx-text-inner-color: red;");

            } else {

                btnInicio.requestFocus();
                //que este en rojo
                pfContraseña.setStyle("-fx-border-color: red;");
                //que el texto sea visible 
                lblError.setText("Todos los campos deben de estar rellenos");
                lblError.setVisible(true);
                lblError.setStyle("-fx-text-inner-color: red;");
            }
        }

    }

    /**
     *
     * @return devuelve un boolean de si
     */
    private boolean chkAllFieldsFilled() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean isFilled = false;

        if (!this.tfUsuario.getText().trim().equals("") && !this.pfContraseña.getText().trim().equals("")) {

            //si son diferentes a vacio, devuelve true, eso quiere decir que hay algo escrito
            
            isFilled = true;
            showPassword();
          
        } else {
            isFilled = false;
        }

        return isFilled;

    }

    /**
     *
     * @return @throws UserNotExistException
     * @throws PasswordNotOkException
     * @throws Exception
     */
    private boolean chkUserPassword() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        boolean notError = false;

        try {
            showPassword();
           
            //  ilogic = ILogicFactory.getILogic();

//user bean 
//las excepciones en logica 
//usar la implementacion de logica
//llamo al metodo de iniciar sesion de la implementacion de logica
            String nombre = "paula";

//declarar un atributo de la clase de test 
            LOGGER.info("paula");

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

    private void showPassword() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
     
      
      tfContraseña.setText(pfContraseña.getText());
    tfContraseña.setVisible(true);
    pfContraseña.setVisible(false);
    
    
    

    

}
}