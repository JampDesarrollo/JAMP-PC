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
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 * Testing class for User's signUp controller when the server is not available
 * or offline.
 *
 * @author ander
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC02RegistroControllerITOffline extends ApplicationTest {

    /**
     * Start application to be tested
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplication().start(stage);
    }

    /**
     * This method takes the test to the SignUp view
     */
    @Test
    public void test0_goToSignUpView() {
        clickOn("#hpLink");
        verifyThat("#signUpPane", isVisible());
    }

    /**
     * Test of initial state of SignUp view.
     */
    @Test
    public void test1_InitStage() {

        //Test si los campos estan como deberian al inizializarse
        verifyThat("#tfLogin", isEnabled());
        verifyThat("#lblLoginW", isInvisible());

        verifyThat("#tfFullName", isEnabled());
        verifyThat("#lblFNameW", isInvisible());

        verifyThat("#tfEmail", isEnabled());
        verifyThat("#lblEmailW", isInvisible());

        verifyThat("#pfPassw", isEnabled());
        verifyThat("#tfPassw", isInvisible());
        verifyThat("#lblPasswW", isInvisible());

        verifyThat("#pfRpassw", isEnabled());
        verifyThat("#tfRpassw", isInvisible());
        verifyThat("#lblRpasswW", isInvisible());
        verifyThat("#btnEye", isEnabled());

        verifyThat("#btnBack", isEnabled());
        verifyThat("#btnSignUp", isEnabled());
        verifyThat("#imgLoading", isInvisible());
    }

    /**
     * Test signing up a user when connection to server is not posible
     */
    @Test
    public void test2_signUpFailed() {

        doubleClickOn("#tfLogin");
        write("userLogin");

        clickOn("#tfFullName");
        write("Ander Redna");

        clickOn("#tfEmail");
        write("ander@hotn.com");

        clickOn("#pfPassw");
        write("password");

        clickOn("#pfRpassw");
        write("password");

        clickOn("#btnSignUp");

        verifyThat("#lblRpasswW", isVisible());
        verifyThat("#lblRpasswW", hasText("Ha habido un error con la conexión, "
                + "inténtelo más tarde."));

    }
}
