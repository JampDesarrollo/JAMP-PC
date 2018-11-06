
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.logic.ILogic;
import jamp.pc.logic.PasswordNotOkException;
import jamp.pc.logic.UserNotExistException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * FXML Controller class esta clase es la que controla los eventos de la primera
 * ventana, la de Login.
 *
 * Controller class for Login view.
 * @author paula
 */
public class PC01LoginController implements Initializable {

    private Stage stage;
    private static final Logger LOGGER = Logger.getLogger("package.class");
    private ILogic ilogic;
    private static final int MAX_CARACT = 5;
    
    /**
     * Text field de Jamp, el titulo
     * 
     */
    @FXML
    private Label lblJAMP;
    
    /**
     * Text Field del usuario
     * User text field
     */
    @FXML
    private TextField tfUsuario;
    
    /**
     * Password field para la contraseña
     * password field for the password
     */
    @FXML
    private PasswordField pfContraseña;
    
    /**
     * Boton para ver la contraseña
     * Button to see the password
     */
    @FXML
    private Button btnOjo;
    
    /**
     * Imagen del boton
     * Button image
     */
    @FXML
    private ImageView imgOjo;
    
    /**
     * Label que marca todos los errores
     * Laber for the errors
     */
    @FXML
    private Label lblError;
    
    /**
     * Boton para iniciar sesion
     * Button for login
     */
    @FXML
    private Button btnInicio;
    
    /**
     * Barra separadora
     */
    @FXML
    private Separator spSeparador;
    
    /**
     * Label de informacion
     */
    @FXML
    private Label lblCuenta;
    
    /**
     * Link para ir a la ventana de Registro.
     * Link to go to signup window.
     */
    @FXML
    private Hyperlink hpLink;
    
    /**
     * Textfield de la contraseña
     * textfield for the password
     */
    @FXML
    private TextField tfContraseña;
    
    /**
     * Gif de espera
     * gif for the wait.
     */
    @FXML
    private ImageView imLoading;

    /**
     * Initializes the controller class.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
   
    /**
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;

    }
    /**
     * Metodo que recibe el objeto logica de la clase aplicacion y lo asocia 
     * con el metodo logica de esta clase.
     * Method that receives the ilogic param of the class application.
     * @param ILogic recibe el objeto logica que se le manda desde aplicacion.
     * @param ILogic it receives the logic object that came from the application
     * class
     */
    public void setILogic(ILogic ILogic) {
        this.ilogic = ILogic;
    }

    /**
     * Metodo que inicializa la escena.
     * @param root recibe el parametro root, que es donde esta guardado el
     * archivo xml.
     * 
     * Method that initializes the "Login" window. It receives the param root,
     * where is the fxml file.
     * @param root receives the root parameter
     */
    public void initStage(Parent root) {  //recibo el root, AHÍ tengo el archivo XML
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
        //muestro la ventana
        stage.show();
    }

    /**
     * Metodo que inicializa el estado de los componentes de la ventana de login
     * Method that initializes the state of the components of the window.
     * @param event
     */
    public void handleWindowShowing(WindowEvent event) {

        //los botones van a estar activos desde el primero momento
        btnInicio.setDisable(false);
        btnOjo.setDisable(false);
        hpLink.setDisable(false);
        btnInicio.requestFocus();
        imLoading.setVisible(false);
        tfContraseña.setVisible(false);
        //el label de informacion estará invisible
        lblError.setVisible(false);
        btnInicio.setOnAction((ActionEvent ev) -> {
            logIn();
            //referencia de metodo
        });
        hpLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //cuando le doy al link de registrar
                try {
                    //instancio el xml
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/PC02Registro.fxml"));
                    //lo cargo en el root que es de tipo parent
                    Parent root = (Parent) loader.load();
                    //tengo que crear un nuevo escenario
                    // stage = new Stage();
                    //obtener el controlador
                    PC02RegistroController controller = (PC02RegistroController) loader.getController();
                    //le mando el objeto logica al controlador 
                    controller.setILogic(ilogic);
                    //a ese controlador le paso el stage
                    controller.setStage(stage);
                    //inizializo el stage
                    controller.initStage(root);
                    stage.hide();
                } catch (IOException ex) {
                    LOGGER.severe("Error accediendo a la ventana ");
                }
            }
        });

        btnOjo.setOnAction((ActionEvent ev) -> {
            showPassword();
        });
    }

    /**
     * Sirve para poder hacer todas las comprobaciones necesarias para poder
     * iniciar sesion y en caso de que todo este correcto pasar a la ventana
     * principal. Dentro de este metodo se haran llamadas a diferentes metodos
     * que harán esas comprobaciones.
     * 
     * It serves to be able to make all the necessary checks to be able to
     * initiate session. 
     */
    public void logIn() {
        //va a mirar si los campos estan llenos o no
        boolean filled = chkAllFieldsFilled();
        //si los campos estan rellenos  
        if (filled) {
            //si estan todos los campos comentados, comprobamos los caracteres maximos 
            tfUsuario.setStyle("-fx-border-color: -fx-box-border;");
            pfContraseña.setStyle("-fx-border-color: -fx-box-border;");
            lblError.setVisible(false);
            boolean maxCar = maxCharacters();
            //si los caracteres son menos
            if (maxCar) {
                tfUsuario.setStyle("-fx-border-color: -fx-box-border;");
                pfContraseña.setStyle("-fx-border-color: -fx-box-border;");
                lblError.setVisible(false);
                //comprobamos que existen el usuario y la contraseña
                UserBean userReturn = chkUserPassword(); //le envio el texto de lo que ha puesto en los campos
                //si esta todo correcto que vaya a la ventana principal
              if (userReturn != null) { // si lo que devuelve es diferente a null 
                    try {
                        imLoading.setVisible(true);
                        //instancio el xml
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/jamp/pc/ui/view/PC03Principal.fxml"));
                        //lo cargo en el root que es de tipo parent
                        Parent root = (Parent) loader.load();
                        //obtener el controlador
                        PC03PrincipalController controller = (PC03PrincipalController) loader.getController();
                        //le mando el objeto logica 
                        controller.setIlogic(ilogic);
                        //ilogic.UserLogin(mensaje);
                        //a ese controlador le paso el stage
                        controller.setStage(stage);
                        //inizializo el stage
                        //le paso el usuario entero a la ventana 
                        controller.setUser(userReturn);
                        controller.initStage(root);
                        stage.hide();
                    } catch (IOException ex) {
                        //mensaje de "no se ha podido cargar la ventana"
                        LOGGER.severe("Error accediendo a la ventana ");
                    }

                }
            } else { //si los caracteres son mayores a los definidos
                if (tfUsuario.getText().trim().length() > MAX_CARACT && pfContraseña.getText().trim().length() > MAX_CARACT) {
                    btnInicio.requestFocus();
                    tfUsuario.setStyle("-fx-border-color: red;");
                    pfContraseña.setStyle("-fx-border-color: red;");
                    lblError.setText("Demasiados caracteres");
                    lblError.setStyle("-fx-text-inner-color: red;");
                    lblError.setVisible(true);

                } else if (tfUsuario.getText().trim().length() > MAX_CARACT) {
                    btnInicio.requestFocus();
                    tfUsuario.setStyle("-fx-border-color: red;");
                    pfContraseña.setStyle("-fx-border-color: -fx-box-border;");
                    lblError.setText("Demasiados caracteres");
                    lblError.setStyle("-fx-text-inner-color: red;");
                    lblError.setVisible(true);

                } else {
                    btnInicio.requestFocus();
                    tfUsuario.setStyle("-fx-border-color: -fx-box-border;");
                    pfContraseña.setStyle("-fx-border-color: red;");
                    lblError.setText("Demasiados caracteres");
                    lblError.setStyle("-fx-text-inner-color: red;");
                    lblError.setVisible(true);

                }
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
                lblError.setText("Campo requerido");
                lblError.setStyle("-fx-text-inner-color: red;");
                lblError.setVisible(true);

            } else if (tfUsuario.getText().trim().equals("")) {
                btnInicio.requestFocus();
                //que este en rojo el usuario pero la contraseña no
                tfUsuario.setStyle("-fx-border-color: red;");
                pfContraseña.setStyle("-fx-border-color: -fx-box-border;");
                lblError.setText("Campo requerido");
                lblError.setStyle("-fx-text-inner-color: red;");
                lblError.setVisible(true);

            } else {
                btnInicio.requestFocus();
                //que este en rojo la contraseña y el usuario normal
                pfContraseña.setStyle("-fx-border-color: red;");
                tfUsuario.setStyle("-fx-border-color: -fx-box-border;");
                //que el texto sea visible 
                lblError.setText("Campo requerido");
                lblError.setStyle("-fx-text-inner-color: red;");
                lblError.setVisible(true);

            }
        }

    }

    /**
     * Metodo para saber si los campos estan llenos o no.
     * @return boolean devuelve un booleano indicando si estan todos los campos
     * llenos o no.
     * 
     *  Method to know that all fields are filled. It returns a boolean.
     *  @return boolean it returns a boolean indicating if all fields are filled or not
     */
    private boolean chkAllFieldsFilled() {
        boolean isFilled = false;
        if (!this.tfUsuario.getText().trim().equals("") && !this.pfContraseña.getText().trim().equals("")) {
            //si son diferentes a vacio, devuelve true, eso quiere decir que hay algo escrito
            isFilled = true;
        } else {
            isFilled = false;
        }
        return isFilled;
    }

    /**
     * Metodo que sirve para comprobar si el usuario y la contrasña que se hen
     * metido son correctas.
     * @return en caso de que este todo correcto, devolverá el usuario para
     * poder mostrarlo en la ventana principal.
     * 
     * Method to know if the user and password are ok. If the user and password
     * are ok, it returns the all the user to be visible in the main window.
     * @return in case that everything is ok, returns the user.
     */
    private UserBean chkUserPassword() {
        UserBean returnUser = null;
        try {
            //creo un nuevo usuario con contraseña y password solamente
            UserBean usuario = new UserBean(tfUsuario.getText(), pfContraseña.getText());
            returnUser = ilogic.userLogin(usuario); // el userlogin me va a devolver el usuario entero 
        } catch (UserNotExistException e) {
            //se pone el foco en el usuario
            btnInicio.requestFocus();
            //que este en rojo
            tfUsuario.setStyle("-fx-border-color: red;");
            pfContraseña.setStyle("-fx-border-color: red;");
            //que el texto sea visible 
            lblError.setText("Usuario o contraseña incorrecta");
            lblError.setVisible(true);
            lblError.setStyle("-fx-text-inner-color: red;");
        } catch (PasswordNotOkException e) {
            //se pone el foco en el campos de la contraseña y usuario 
            btnInicio.requestFocus();
            tfUsuario.setStyle("-fx-border-color: red;");
            pfContraseña.setStyle("-fx-border-color: red;");
            //que el texto sea visible 
            lblError.setText("Usuario o contraseña incorrecta");
            lblError.setVisible(true);
            lblError.setStyle("-fx-text-inner-color: red;");
        } catch (Exception e) {
            LOGGER.severe("Error al conectar con la base de datos ");
        }
        return returnUser;
    }

    /**
     * Metodo que sirve para poder hacer visible u ocultar la contraseña.
     * Method to be able to see the password or not.
     */
    private void showPassword() {
        if (pfContraseña.isVisible()) {
            //Si el texto esta oculto, se cambia a visible
            tfContraseña.setText(pfContraseña.getText());
            pfContraseña.setVisible(false);
            tfContraseña.setVisible(true);
        } else {
            //Si el texto esta visible, se cambia a oculto
            pfContraseña.setText(tfContraseña.getText());
            tfContraseña.setVisible(false);
            pfContraseña.setVisible(true);
        }

    }

    /**
     * Sirve para poder saber si los campos se pasan de una cierta cantidad de
     * caracteres.
     * @return devuelve un boolean indicando si se han pasado de caracteres o no.
     *  Method to control the characters you enter in the textfield and passwordfield.
     * It returns a boolean.
     */
    private boolean maxCharacters() {
        boolean maxcaracteres = false;
        if (tfUsuario.getText().trim().length() < MAX_CARACT && pfContraseña.getText().trim().length() < MAX_CARACT) {
            maxcaracteres = true;
        } else {
            maxcaracteres = false;
        }
        return maxcaracteres;
    }

}
