
package jamp.pc;

import jamp.pc.logic.ILogic;
import jamp.pc.logic.ILogicFactory;
import jamp.pc.ui.controller.PC03PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * UiAplication for test PC03 Controlle
 * 
 * @author Julen
 */
public class UiApplicationPc03 extends Application{
    
    /**
     * Method to show the Stage
     * @param stage return the stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        ILogic iLogic = ILogicFactory.getILogic();       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/view/PC03Principal.fxml"));
        Parent root =(Parent)loader.load();
        PC03PrincipalController controler =(PC03PrincipalController)loader.getController();
        controler.setILogic(iLogic);
        controler.setStage(stage);
        controler.initStage(root); 
    }
     /**
     * Method to launch start
     */
      
    public static void  main(String[] args){
        //Lanza el metodo start
        launch(); 
    }
    
}
