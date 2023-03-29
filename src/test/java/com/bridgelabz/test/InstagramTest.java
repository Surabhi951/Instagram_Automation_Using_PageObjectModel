package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.InstagramHomePage;
import com.bridgelabz.pages.InstagramLoginPage;
import com.bridgelabz.pages.RegistrationOnToTheInstagram;
import com.bridgelabz.utility.DataProviderCredentials;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class InstagramTest extends BaseClass {

    RegistrationOnToTheInstagram registration;
    InstagramLoginPage login;
    InstagramHomePage homePage;

    @BeforeMethod
    public void initialization() {
        setUp();
        registration = new RegistrationOnToTheInstagram(driver);
        login = new InstagramLoginPage(driver);
        homePage = new InstagramHomePage(driver);
    }

    @Test(priority = 0)
    @Severity(value = SeverityLevel.CRITICAL)
    public void redirectOnToTheSignUp() throws InterruptedException {
        log.debug("signup");
        String title = registration.redirectOnToTheSignUpScreen();
        Assert.assertEquals("Instagram",title);
        log.info("Redirect OnTo The SignUp page");
    }

    @Test(priority = 1)
    @Severity(value = SeverityLevel.CRITICAL)
    public void insertTheDataIntoTheRegistrationForm() {
        log.debug("insertData");
        registration = new RegistrationOnToTheInstagram(driver);
        boolean isEnable = registration.enterDataInToTheRegistrationForm();
        Assert.assertEquals(true,isEnable);
        log.info("inserted data successfully");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 2, dataProvider = "testLoginData", dataProviderClass = DataProviderCredentials.class)
    public void loginToInstagram(String userName, String password) throws InterruptedException {
        log.debug("login");
        login.loginInToTheInstagram(userName, password);
        Thread.sleep(3000);
        log.info("login successfully");
    }

    @Test(priority = 4)
    public void logOutFromInstagramHomePage() throws InterruptedException {
        log.debug("log out");
        login.loginInToTheInstagram("testingblz123","Theend@1");
        Thread.sleep(200);
        homePage.logoutFromInstagram();
        Thread.sleep(500);
        log.info("log out successfully");
    }

    @Test(priority = 3)
    public void searchData() throws InterruptedException, AWTException {
        login.loginInToTheInstagram("testingblz123","Theend@1");
        homePage.searchDataFromInstagramHomePage();
        Thread.sleep(500);
    }

    @Test(priority = 4)
    public void followPeople() throws InterruptedException, AWTException {
        login.loginInToTheInstagram("testingblz123","Theend@1");
        homePage.followPersonInInstagram();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}


