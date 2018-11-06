/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.UiApplication;
import javafx.stage.Stage;
import static jdk.management.resource.ResourceContextFactory.isEnabled;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;



/**
 *
 * @author 2dam
 */
public class PC01LoginControllerIT extends ApplicationTest {

    //1. Extender de Application Test
    //2. Definir metodo start
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplication().start(stage);//llamo a la aplicacion que me abre la ventana
    }

    //3. Empezar a escribir nuestros metodos
    
    @Test
    public void test1_initialStage(){
    
        verifyThat("#btnInicio", isEnabled());
        verifyThat("#btnOjo", isEnabled());
        verifyThat("#hpLink", isEnabled());
      
    }
    /*
    
     /**
      * Verifica que los campos de usuario y contraseña estan vacios
      */  

    @Test
    public void test2_CamposVacios() {
      
        verifyThat("#tfUsuario", hasText(""));
        clickOn("#pfContraseña");
        verifyThat("#pfContraseña", hasText(""));
        clickOn("#btnInicio");
     // verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isVisible());

    }
     /**
      * Escribe en el campo Usuario el username y contraseña vacio
      */
  /*  
    @Test
    public void test3_CampoLoginLlenoContraseñaVacio() {

        clickOn("#tfUsuario");
        write("username");
        clickOn("#pfContraseña");
        verifyThat("#pfContraseña", hasText(""));
        clickOn("#btnInicio");
        //verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isVisible());

    }
    /**
     * Escribe en el campo Contraseña  password y el usuario vacio
     */
  /*  
    @Test
    public void test4_CampoContraseñaLlenoLoginVacio() {
        clickOn("#tfUsuario");
        verifyThat("#tfUsuario", hasText(""));
        clickOn("#pfContraseña");
        write("password");
        clickOn("#btnInicio");
         //verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isEnabled());

    }
    /**
     * Verifica que el usuario y la contraseña se pasa de los caracteres 
     */
    /*
      @Test
    public void test5_MaxCaracteresAll() {
        clickOn("#tfUsuario");
        write("username");
        clickOn("#pfPassword");
        write("password");
        clickOn("#btnInicio");
       //verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isVisible());

    }
    */
    /**
     * Verifica que el usuario no se pasa pero la contraseña si
     */
    /*
    @Test
    public void test6_MaxCaracteresUser() {

        clickOn("#tfUsuario");
        write("user");
        clickOn("#pfContraseña");
        write("password");
        clickOn("#btnInicio");
    //verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isEnabled());
       

    }
    /**
     * Verifica que el usuario se pasa de cararcteres pero la contraseña no
     */
    
    /*
    @Test
    public void test7_MaxCaracteresPassword() {
        clickOn("#tfUsuario");
        write("username");
        clickOn("#pfPassword");
        write("pass");
        clickOn("#btnInicio");
        //verifyThat("#imLoading", isDisabled());
        verifyThat("#lblError", isEnabled());

    }
    */
   /**
    * Verifica que tanto el usuario como la contraseña estan entre los caracteres establecidos.
    */ 
    /*
    public void  test8_UserPasswordOk(){
    
    clickOn("#tfUsuario");
        write("user");
        clickOn("#pfPassword");
        write("pass");
    clickOn("#btnInicio");
    
    
    }
   
    @Test
    public void test9_hplink() {

        clickOn("#hpLink");
    }
*/
}
