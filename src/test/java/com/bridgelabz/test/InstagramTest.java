package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.InstagramLoginPage;
import com.bridgelabz.pages.RegistrationOnToTheInstagram;
import com.bridgelabz.utility.DataProviderCredentials;
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
    public void redirectOnToTheSignUp() throws InterruptedException {
        String title = registration.redirectOnToTheSignUpScreen();
        Assert.assertEquals("Instagram",title);
    }


    @Test(priority = 1)
    public void insertTheDataIntoTheRegistrationForm() {
        registration = new RegistrationOnToTheInstagram(driver);
        boolean isEnable = registration.enterDataInToTheRegistrationForm();
        Assert.assertEquals(true,isEnable);
    }

    @Test(priority = 2, dataProvider = "testLoginData", dataProviderClass = DataProviderCredentials.class)
    public void loginInToTheInstagram(String userName, String password) throws InterruptedException {
        login.loginInToTheInstagram(userName, password);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
