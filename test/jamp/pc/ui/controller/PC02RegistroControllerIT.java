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
 * Testing class for User's signUp controller.
 *
 * @author ander
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC02RegistroControllerIT extends ApplicationTest {

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

    /*@Test
    public void test2_toolTipVisible() {
        //Test si los campos estan  como deberian al inizializarse moveTo
        ("#pfPassw");
        sleep(1000);
        verifyThat("#tip", isVisible());
    }*/
    /**
     * Eye button sets visible and invisible passwordfields and textfields.
     */
    @Test
    public void test3_eyeButtonWorks() {
        verifyThat("#pfPassw", isVisible());
        verifyThat("#tfPassw", isInvisible());

        verifyThat("#pfRpassw", isVisible());
        verifyThat("#tfRpassw", isInvisible());

        clickOn("#btnEye");

        verifyThat("#pfPassw", isInvisible());
        verifyThat("#tfPassw", isVisible());

        verifyThat("#pfRpassw", isInvisible());
        verifyThat("#tfRpassw", isVisible());

        clickOn("#btnEye");

    }

    /**
     * Checks if all fields are filled and if their corresponding labels are
     * visible if there's an error.
     */
    @Test
    public void test4_allFieldsFilled() {
        clickOn("#btnSignUp");
        verifyThat("#lblLoginW", isVisible());
        verifyThat("#lblFNameW", isVisible());
        verifyThat("#lblEmailW", isVisible());
        verifyThat("#lblPasswW", isVisible());

        clickOn("#tfLogin");
        write("userLogin");
        clickOn("#btnSignUp");
        verifyThat("#lblLoginW", isInvisible());

        clickOn("#tfFullName");
        write("Ander Redna");
        clickOn("#btnSignUp");
        verifyThat("#lblFNameW", isInvisible());

        clickOn("#tfEmail");
        write("ander@hotn.com");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isInvisible());

        clickOn("#pfPassw");
        write("password");
        clickOn("#btnSignUp");
        verifyThat("#lblPasswW", isInvisible());

    }

    /**
     * Checks if the email writen in textfield email follows a pattern.
     */
    @Test
    public void test5_emailPattern() {
        doubleClickOn("#tfEmail");
        eraseText(13);
        doubleClickOn("#tfEmail");
        eraseText(13);
        write("correo");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isVisible());
        verifyThat("#lblEmailW", hasText("Introduzca un email correcto"));

        doubleClickOn("#tfEmail");
        eraseText(6);
        write("correo@hotm.c");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isVisible());
        verifyThat("#lblEmailW", hasText("Introduzca un email correcto"));

        doubleClickOn("#tfEmail");
        eraseText(13);
        doubleClickOn("#tfEmail");
        eraseText(13);
        write("correo@hotm.com");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isInvisible());

    }

    /**
     * Checks if the passwordfield has 8 characters minimum.
     */
    @Test
    public void test6_password8Chars() {
        doubleClickOn("#pfPassw");
        write("passwo");
        clickOn("#btnSignUp");
        verifyThat("#lblPasswW", isVisible());
        verifyThat("#lblPasswW", hasText("La contraseña tiene que tener "
                + "8 caracteres mínimo"));

    }

    /**
     * Checks if the passwordfield and the repetition are the same.
     */
    @Test
    public void test7_passwordsMatch() {
        doubleClickOn("#tfEmail");
        eraseText(13);
        doubleClickOn("#pfPassw");
        write("password");
        doubleClickOn("#pfRpassw");
        write("passwor");
        clickOn("#btnSignUp");
        verifyThat("#lblRpasswW", isVisible());
        verifyThat("#lblRpasswW", hasText("La contraseña no coincide, "
                + "inténtalo de nuevo."));

        doubleClickOn("#pfRpassw");
        write("password");
        clickOn("#btnSignUp");
        verifyThat("#lblRpasswW", isInvisible());

    }

    /**
     * Checks if the labelloginWrong is visible if there's alredy a user with
     * that login.
     */
    @Test
    public void test8_userLoginExists() {

        doubleClickOn("#tfLogin");
        write("a");
        doubleClickOn("#tfEmail");
        write("asq@hotm.com");
        clickOn("#btnSignUp");
        sleep(1000);
        verifyThat("#lblLoginW", hasText("Ese nombre de usuario existe"));

    }

    /**
     * Checks if it's possible to sign up a new user and takes you to the next
     * view.
     */
    @Test
    public void test9_signUp() {

        doubleClickOn("#tfLogin");
        write("userLogin");

        clickOn("#btnSignUp");
        verifyThat("#principalPane", isVisible());
        clickOn("#menu");
        clickOn("#btnLogOut");
    }

    /**
     * Test Button back takes you back to previous view.
     */
    /*@Test
    public void testu_backButton() {

        clickOn("#hpLink");
        sleep(1000);
        clickOn("#btnBack");
        verifyThat("#loginPane", isVisible());
    }*/
}
