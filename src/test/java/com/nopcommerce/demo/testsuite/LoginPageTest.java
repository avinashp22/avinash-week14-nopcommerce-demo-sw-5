package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {


    }

    @Test
    public void verifyTheErrorMessageWithInValidCredentials() {


    }

    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {


    }

    @Test
    public void verifyThatUserShouldLogOutSuccessFully() {


    }


}
