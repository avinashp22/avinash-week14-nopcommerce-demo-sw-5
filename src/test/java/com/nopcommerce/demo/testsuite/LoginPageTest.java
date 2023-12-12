package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
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

    @Test (groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        loginPage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome, Please Sign In!");
    }

    @Test   (groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        // Click on login link
        loginPage.clickOnLoginLink();
        // Enter EmailId
        loginPage.enterEmailId("avinashhaapatelll@gmail.com");
        // Enter Password
        loginPage.enterPassword("Prime12345!");
        // Click on Login Button
        loginPage.clickOnLoginButton();
        // Verify that the Error message
        Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Test  (groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on Login Button
        loginPage.login("avinashp22@gmail.com", "Prime12345!");
        //Verify that LogOut link is display
        Assert.assertEquals(homePage.getTextLogOut(), "Log out");

    }

    @Test  (groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        //Click on Login Button
        loginPage.login("avinashp22@gmail.com", "Prime12345!");
        //Click on LogOut Link
        homePage.clickOnLogOutLink();
        //Verify that LogIn Link Display
        Assert.assertEquals(homePage.getTextLogIn(), "Log in");
    }


}
