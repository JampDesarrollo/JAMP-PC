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
    public void test1_initIteraction() {
        clickOn("#tfUsuario");
        write("jul");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#principalPane", isVisible());
    }

    /**
     * Test Method to the Log Out menu item
     */
    @Test
    public void test2_logOut() {

        clickOn("#menu");
        clickOn("#btnLogOut");
        verifyThat("#loginPane", isVisible());
    }

    /**
     * Test of initial state of PrincipalView.
     */
    @Test
    public void test3_initState() {
        clickOn("#tfUsuario");
        write("a");
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
    @Test
    public void test4_label() {
        verifyThat("#lblLogin", hasText("Login: a"));
        verifyThat("#lblFullName", hasText("Nombre Completo: ander oli"));
        verifyThat("#lblEmail", hasText("Email: ander@hotm.com"));
    }

}
