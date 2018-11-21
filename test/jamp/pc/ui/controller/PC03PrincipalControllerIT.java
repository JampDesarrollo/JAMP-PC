/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.UiApplication;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 * LogOut controller Test Class
 *
 * @author Julen
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC03PrincipalControllerIT extends ApplicationTest {

    /**
     * Method to start the application for the controller
     *
     * @param stage Primary Stage object
     * @throws Exception If there is any error
     */
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplication().start(stage);
    }

    /**
     * Test of initial state of login view before open PrincipalView.
     */
    @Test
    public void test3_initIteraction() {
        clickOn("#tfUsuario");
        write("julen");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#principalPane", isVisible());
    }

    /**
     * Test Method to the Log Out menu item with close selection
     */
    @Test @Ignore
    public void test2_logOut() {

        clickOn("#menu");
        clickOn("#btnLogOut");
        clickOn("#cancelButton");
        verifyThat("#principalPane", isVisible());
        clickOn("#menu");
        clickOn("#btnLogOut");
        clickOn("#okButton");
        verifyThat("#loginPane", isVisible());
    }

    /**
     * Test of initial state of PrincipalView.
     */
    @Test @Ignore
    public void test3_initState() {
        clickOn("#tfUsuario");
        write("ander");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#principalPane", isVisible());
        verifyThat("#menuBar", isVisible());
        verifyThat("#menu", isVisible());
        clickOn("#menu");
        verifyThat("#btnLogOut", isVisible());

    }

    /**
     * Test that verify labels
     */
    @Test @Ignore
    public void test4_label() {
        verifyThat("#lblLogin", hasText("Login: ander"));
        verifyThat("#lblFullName", hasText("Nombre Completo: ander olivas"));
        verifyThat("#lblEmail", hasText("Email: anderolivas@gmail.com"));
    }
    
   /**
     * Test to bottom_right Button for close session
     */
    @Test @Ignore
    public void test5_btnLogOut2() {
        clickOn("#btnLogOut2");
        clickOn("#cancelButton");
        verifyThat("#principalPane", isVisible());
        clickOn("#btnLogOut2");
        clickOn("#okButton");
        verifyThat("#loginPane", isVisible());
    }
    
    /**
     *  Test to try the login exist
     */
    @Test 
    public void test1_errorLogin() {
        clickOn("#tfUsuario");
        write("and");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#lblError", hasText("Usuario o contraseña incorrecta"));
    }
    
   /**
     *  Test to improve the password is correct
     */
    @Test
    public void test2_errorPassword() {
        clickOn("#tfUsuario");
        write("julen");
        clickOn("#pfContraseña");
        write("1234567");
        clickOn("#btnInicio");
        verifyThat("#lblError", hasText("Usuario o contraseña incorrecta"));
    }
    
    
    
}