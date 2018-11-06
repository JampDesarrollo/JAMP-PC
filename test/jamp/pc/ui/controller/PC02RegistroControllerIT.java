/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.UiApplication;
import javafx.stage.Stage;
import org.junit.Before;
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
 *
 * @author ander
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC02RegistroControllerIT extends ApplicationTest {

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplication().start(stage);
    }

    @Before
    public void goToSignUpView() {
        clickOn("#hpLink");
    }

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

    @Test
    public void test2_toolTipVisible() {
        //Test si los campos estan como deberian al inizializarse
        moveTo("#pfPassw");
        verifyThat("#tip", isInvisible());
    }

    @Test
    public void test3_eyeButton() {
        verifyThat("#pfPassw", isVisible());
        verifyThat("#tfPassw", isInvisible());

        verifyThat("#pfRpassw", isVisible());
        verifyThat("#tfRpassw", isInvisible());

        clickOn("#btnEye");

        verifyThat("#pfPassw", isInvisible());
        verifyThat("#tfPassw", isVisible());

        verifyThat("#pfRpassw", isInvisible());
        verifyThat("#tfRpassw", isVisible());

    }

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

    @Test
    public void test5_emailPattern() {
        clickOn("#tfEmail");
        write("correo");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isVisible());
        //verifyThat("#lblEmailW", hasText("Introduzca un email correcto"));

        doubleClickOn("#tfEmail");
        eraseText(6);
        write("correo@hotm.c");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isVisible());
        //verifyThat("#lblEmailW", hasText("Introduzca un email correcto"));

        doubleClickOn("#tfEmail");
        eraseText(13);
        doubleClickOn("#tfEmail");
        eraseText(13);
        write("correo@hotm.com");
        clickOn("#btnSignUp");
        verifyThat("#lblEmailW", isInvisible());

    }

    @Test
    public void test6_password8Chars() {
        clickOn("#pfPassw");
        write("passwo");
        clickOn("#btnSignUp");
        verifyThat("#lblPasswW", isVisible());
        /*verifyThat("#lblPasswW", hasText("La contraseña tiene que tener "
                + "8 caracteres mínimo"));*/

    }

    @Test
    public void test7_passwordsMatch() {
        clickOn("#pfPassw");
        write("password");
        clickOn("#pfRpassw");
        write("passwor");
        clickOn("#btnSignUp");
        verifyThat("#lblRpasswW", isVisible());
        /*verifyThat("#lblRpasswW", hasText("La contraseña no coincide, "
                + "inténtalo de nuevo."));*/

        clickOn("#pfRpassw");
        write("password");
        clickOn("#btnSignUp");
        verifyThat("#lblRpasswW", isInvisible());

    }

    @Test
    public void test8_signUp() {

        clickOn("#tfLogin");
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
        verifyThat("#imgLoading", isVisible());

    }

    @Test
    public void test9_backButton() {
        clickOn("#btnBack");
        verifyThat("#loginPane", isVisible());
    }
}