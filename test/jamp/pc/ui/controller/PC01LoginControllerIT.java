/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.UiApplication;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 * Clase de test para el controlador de Login 
 * Test class for the Login controller
 *
 * @author Paula
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC01LoginControllerIT extends ApplicationTest {

    //1. Extender de Application Test
    //2. Definir metodo start
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplication().start(stage);//llamo a la aplicacion que me abre la ventana
    }

    //3. Empezar a escribir nuestros metodos
    
    /**
     * Mostrar la ventana en el modo inicial.
     * Initializing handle WindowShowing of Login 
     */
    @Test
    public void test1_initialStage() {
        
        //como tiene que aparecer en el inicio
        verifyThat("#btnInicio", isEnabled());
        verifyThat("#btnOjo", isEnabled());
        verifyThat("#hpLink", isEnabled());
        verifyThat("#tfUsuario" ,hasText(""));
        verifyThat("#pfContraseña", hasText(""));
        verifyThat("#tfContraseña",isInvisible());
        verifyThat("#imLoading", isInvisible());
        verifyThat("#lblError", isInvisible());
        
    }    
 
    /**
     * Comprobar que los campos estan vacios y al pulsar en 
     * en Iniciar Sesion da error
     * Text User and Password field are empty and we have an error.
     */
   @Test
    public void test2_comprobarCamposVaciosErrorVisible() {
      clickOn("#btnInicio");
      verifyThat("#lblError", isVisible());
      verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
    }
    
    /**
     * Comprobar que al meter el usuario y la contraseña no, da error.
     * We have the login but the passsword field is empty, the error appears.
     */
  @Test
    public void test3_comprobarCampoUsuarioLlenoErrorVisible() {
       
       clickOn("#tfUsuario");
       write("login1");
       clickOn("#btnInicio");
     verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
        verifyThat("#lblError", isVisible());
        
    }  
   
    /**
     * Comprobar que al meter la contraseña y el usuario no, da error.
     * We write the password and the user no, the error appears.
     */   
   @Test
   public void test4_comprobarCampoPasswordLlenoErrorVisible(){
      clickOn("#pfContraseña");
       write("pass1");
       clickOn("#btnInicio");
       verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
       verifyThat("#lblError", isVisible());
   }
   
   
   /**
    * Escribirmos la contraseña en pfContraseña y al pulsar en el ojo la tiene que 
    * mostrar. Cuando volvamos a pulsar en el boton, la oculta.
    * We write the password and the button eye show the password.Then we click on
    * the button and e hide the password
    */ 
   @Test
   public void test5_tfContraseñaIsVisibleOnClickBotonOjo(){
       
       //interaccion
       clickOn("#pfContraseña");
       write("pass1");
       clickOn("#btnOjo");
       //pregunto
       verifyThat("#pfContraseña",isInvisible());
       verifyThat("#tfContraseña", isVisible());
    
       clickOn("#btnOjo");
       verifyThat("#pfContraseña",isVisible());
       verifyThat("#tfContraseña", isInvisible());
       
   }
  
   /**
    * Ponemos el usuario mal y la contraseña bien. Tiene que salir el error
    * de Usuario o contraseña incorrecta
    * We write the password ok but the user no, it appears the error.
    */
   @Test
   public void test6_LoginNotOkPasswordOkVisibleError(){
       
       clickOn("tfUsuario");
       write("ggggg");
       clickOn("pfContraseña");
       write("pass1");
       clickOn("#btnInicio");
       verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Usuario o contraseña incorrecta"));
       verifyThat("#lblError", isVisible());      
   }
      
   /**
    * Escribimos el usuario y la contraseña y va a la ventana Prinicpal.
    * We write the user and password ok, it goes to the Principal window.
    */ 
   @Test
   public void test7_clickLogInIrVentanaLogin(){
   
       clickOn("#tfUsuario");
       write("login1");
       clickOn("#pfContraseña");
       write("pass1");
       clickOn("#btnInicio");
     
      // verifyThat("#principal", isVisible());
   
   }
   /**
    * Pulsa en el link y va a la ventana de Registro.
    * Click on hyperlink and goes to the Register.
    */
   @Test
   public void test8_clickLinkIrVentanaRegistro(){
   
       clickOn("#hpLink");
       verifyThat("#singUpPane",isVisible());
   }
   
   /**
    * En la ventana de Registro pulsamos en el boton back y vuelve a la ventana de Login
    * In the register window we click on back button and we go back to the login window
    */
   @Test
    public void test9_clickBtnBackIrVentanaLogin(){  
       clickOn("#btnBack");
       verifyThat("#loginPane",isVisible());
   }
 

  

}
