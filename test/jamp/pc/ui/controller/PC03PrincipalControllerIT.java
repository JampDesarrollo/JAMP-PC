/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamp.pc.ui.controller;

import jamp.pc.UiApplication;
import jamp.pc.UiApplicationPc03;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 * Log out controller Test Class
 * @author Julen
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC03PrincipalControllerIT extends ApplicationTest{
    
    /**
    * Method to start the application for the controller
    * 
    */
    public void start(Stage stage) throws Exception{   
        new UiApplicationPc03().start(stage);
    }
    
    
    @Test
    public void test1_logOut(){
        FxAssert.verifyThat("lblDate",hasText("01/01/2018"));
        FxAssert.verifyThat("lblLogin",hasText("LOGIN LABEL"));
        FxAssert.verifyThat("lblFullName",hasText("FULL NAME LABEL"));
        FxAssert.verifyThat("lblEmail",hasText("EMAIL")); 
    }
    /**
    * Tesr Method to the Log Out menu item
    */
    public void test2_logOut(){
        clickOn("#menu");
        clickOn("#btnLogOut"); 
    }
}
