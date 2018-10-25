
package jamp.pc;

import jamp.pc.logic.ILogic;
import jamp.pc.logic.ILogicFactory;
import jamp.pc.ui.controller.PC01LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/*
 * Esta clase Aplicación, va a lanzar la primera ventana de la aplicacion que es la ventana de Login.
 */

/**
 *
 * @author Paula
 */
public class UiApplication extends Application{
    
    
   
  
    /**
     * Metodo que "pinta" la ventana
     * @param stage recibe el parametro stage, que es el escenario o la ventana
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
       //vamos a cargar un objeto de la logica , para eso llamamos a la factoria 
       ILogic iLogic = ILogicFactory.getILogic();
       
       
        //Instanciamos el cargador
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/view/PC01Login.fxml"));
        
        //Cargamos el documento en el root
        Parent root =(Parent)loader.load();
        
        //Obtengo el controlador, por que luego quiero pasarle el stage, entonces primero lo tengo que tener
        PC01LoginController controler =(PC01LoginController)loader.getController();
        
        //le paso el objeto de logica al controlador
        controler.setILogic(iLogic);
        
        //al metodo set stage le paso el stage
        controler.setStage(stage);
        
        //ial metodo initstage del controlador le paso el root
        controler.initStage(root); 
  
       
    }
    
      public static void  main(String[] args){
    
        //Lanza el metodo start
        launch();
    
    }
    
}
