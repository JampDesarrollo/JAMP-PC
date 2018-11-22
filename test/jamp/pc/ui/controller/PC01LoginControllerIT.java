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
     * Initializing handle WindowShowing of Login
     */
  
    public void test1_initialStage() {

        //como tiene que aparecer en el inicio
        verifyThat("#btnInicio", isEnabled());
        verifyThat("#btnOjo", isEnabled());
        verifyThat("#hpLink", isEnabled());
        verifyThat("#tfUsuario", hasText("Nombre de usuario"));
        verifyThat("#pfContraseña", hasText(""));
        verifyThat("#tfContraseña", isInvisible());
        verifyThat("#imLoading", isInvisible());
        verifyThat("#lblError", isInvisible());

    }
    
    
    /**
     * Click on hyperlink and goes to the Register.
     */
    @Test
    public void test2_clickLinkIrVentanaRegistro() {

        clickOn("#hpLink");
        verifyThat("#signUpPane", isVisible());
    }

    /**
     * In the register window we click on back button and we go back to
     * the login window
     */
    @Test
    public void test3_clickBtnBackIrVentanaLogin() {
        clickOn("#btnBack");
        verifyThat("#loginPane", isVisible());      
    }

    /**
     * Check that Text field of the user and Password field are empty and we have an error.
     */
    @Test
    public void test4_comprobarCamposVaciosErrorVisible() {
        eraseText(20);
        clickOn("#btnInicio");
        verifyThat("#lblError", isVisible());
        verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
    }

    /**
     *  We have the login full but the passsword field is empty, the error
     * "campo requerido" appears.
     */
    @Test
    public void test5_comprobarCampoUsuarioLlenoErrorVisible() {
        eraseText(20);
        clickOn("#tfUsuario");
        write("pau");
        clickOn("#btnInicio");
        verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
        verifyThat("#lblError", isVisible());

    }

    /**
     * We write the password and the user no, the error "Campo requerido" appears.
     */
    @Test
    public void test6_comprobarCampoPasswordLlenoErrorVisible() {
        eraseText(20);
        clickOn("#pfContraseña");
        write("12345");
        clickOn("#btnInicio");
        verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
        verifyThat("#lblError", isVisible());
    }

    /**
     * We write the password and the button eye show the password.Then we click on the
     * button and we hide the password
     */
    @Test
    public void test7_tfContraseñaIsVisibleOnClickBotonOjo() {
         eraseText(20);
        //interaccion
        clickOn("#pfContraseña");
        write("12345");
        clickOn("#btnOjo");
        //pregunto
        verifyThat("#pfContraseña", isInvisible());
        verifyThat("#tfContraseña", isVisible());

        clickOn("#btnOjo");
        verifyThat("#pfContraseña", isVisible());
        verifyThat("#tfContraseña", isInvisible());

    }  
    
    /**
     * We don't have 8 characters in password, it appears the error 
     * "La contraseña tiene que tener mínimo 8 carácteres"
     */   
    @Test
    public void test8_MinCharactersOfPasswordWrong(){
    
     eraseText(20);
     clickOn("#tfUsuario");
     write("pau");
     clickOn("#pfContraseña");
     write("12345");
     clickOn("#btnInicio");
     verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("La contraseña tiene que tener mínimo 8 carácteres"));
     verifyThat("#lblError", isVisible());
    
    }
    
    /**
     * We write the password ok but the user no, it appears the error 
     * "usuario o contraseña incorrecta".
     * 
     */
    @Test
    public void test9_LoginNotOkPasswordOkVisibleError() {
        eraseText(20);
        clickOn("#tfUsuario");
        write("pau");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Usuario incorrecto"));
        verifyThat("#lblError", isVisible());
    }
    /**
     * We write the wrong password but the login is OK. It appears the error. 
     */
     @Test
    public void testa_LoginOkPasswordNotOkVisibleError(){
    
        eraseText(20);
        clickOn("#tfUsuario");
        write("paula");
        clickOn("#pfContraseña");
        write("1234567895689545677");
        clickOn("#btnInicio");
        verifyThat("#lblError", org.testfx.matcher.control.LabeledMatchers.hasText("Contraseña incorrecta"));
        verifyThat("#lblError", isVisible());
             
    }
    /**
     * Everything is OK. Go to the principal window.
     */
     @Test
    public void testb_LoginOKPasswordOk(){
         //login correcto y contraseña correcta
        eraseText(20);
        clickOn("#tfUsuario");
        write("paula");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#principalPane", isVisible());    
    
        
    }
    
    
}
