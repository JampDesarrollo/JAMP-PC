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
 * Log out controller Test Class
 * @author Julen
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC03PrincipalControllerIT extends ApplicationTest{
    
    /**
    * Method to start the application for the controller
    * 
    */
    @Override
    public void start(Stage stage) throws Exception{   
        new UiApplication().start(stage);
    }
    
    @Test
    public void test1_initIteraction(){
        clickOn("#tfUsuario");
        write("jul");
        clickOn("#pfContraseña");
        write("12345678");
        clickOn("#btnInicio");
        verifyThat("#principalPane", isVisible());    
    }
    @Test
    public void test2_initState(){
        verifyThat("#menuBar", isVisible());
        verifyThat("#menu", isVisible());
        clickOn("#menu");
        verifyThat("#btnLogOut", isVisible());
        
    }
    
    @Test
    public void test3_label(){
        verifyThat("lblLogin",hasText("jul"));
        verifyThat("lblFullName",hasText("Julen Zarate"));
        verifyThat("lblEmail",hasText("jul@gmaill.com")); 
    }
    /**
    * Test Method to the Log Out menu item
    */
    @Test
    public void test4_logOut(){
        clickOn("#menu");
        clickOn("#btnLogOut"); 
        verifyThat("#loginPane", isVisible());
    }
}
