package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.InstagramLoginPage;
import com.bridgelabz.pages.RegistrationOnToTheInstagram;
import com.bridgelabz.utility.DataProviderCredentials;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

public class InstagramTest extends BaseClass {

    RegistrationOnToTheInstagram registration;
    InstagramLoginPage login;

    @BeforeMethod
    public void initialization() {
        setUp();
        registration = new RegistrationOnToTheInstagram(driver);
        login = new InstagramLoginPage(driver);
    }

    @Test(priority = 0)
    @Epic("Instagram Regression")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Redirect to sign up screen")
    public void redirectOnToTheSignUp() throws InterruptedException {
        log.debug("signup");
        String title = registration.redirectOnToTheSignUpScreen();
        Assert.assertEquals("Instagram",title);
        log.info("Redirect OnTo The SignUp page");
    }

    @Test(priority = 1)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Registration form ")
    public void insertTheDataIntoTheRegistrationForm() {
        log.debug("insertData");
        registration = new RegistrationOnToTheInstagram(driver);
        boolean isEnable = registration.enterDataInToTheRegistrationForm();
        Assert.assertEquals(true,isEnable);
        log.info("inserted data successfully");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Login to instagram")
    @Test(priority = 2, dataProvider = "testLoginData", dataProviderClass = DataProviderCredentials.class)
    public void loginInToTheInstagram(String userName, String password) throws InterruptedException {
        log.debug("login");
        login.loginInToTheInstagram(userName, password);
        Thread.sleep(3000);
        log.info("login successfully");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
