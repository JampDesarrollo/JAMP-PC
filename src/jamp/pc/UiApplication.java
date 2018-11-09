package jamp.pc;

import jamp.pc.logic.ILogic;
import jamp.pc.logic.ILogicFactory;
import jamp.pc.ui.controller.PC01LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Clase que va a lanzar la primera ventana de la aplicación, la ventana de
 * Login.
 *
 * @author Paula
 */
public class UiApplication extends Application {

    /**
     * Metodo que sirve para cargar la primera ventana de la aplicacion
     *
     * @param stage recibe el parametro stage que es el escenario Method that
     * throws the first stage and receives the stage.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //vamos a cargar un objeto de la logica , para eso llamamos a la factoria 
        ILogic iLogic = ILogicFactory.getILogic();
        //Instanciamos el cargador
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/view/PC01Login.fxml"));
        //Cargamos el documento en el root
        Parent root = (Parent) loader.load();
        //Obtengo el controlador, por que luego quiero pasarle el stage, entonces primero lo tengo que tener
        PC01LoginController controler = (PC01LoginController) loader.getController();
        //le paso el objeto de logica al controlador
        controler.setILogic(iLogic);
        //al metodo set stage le paso el stage, al controlador le paso el escenario
        controler.setStage(stage);
        //al metodo initstage del controlador le paso el root
        controler.initStage(root);
    }

    /**
     * Metodo qque sirve para poder lanzar el metodo start de esta misma clase
     *
     * @param args Method that throws the method start of this class
     */
    public static void main(String[] args) {
        //Lanza el metodo start
        launch();

    }

}
