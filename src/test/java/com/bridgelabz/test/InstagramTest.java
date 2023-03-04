package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.RegistrationToInstagram;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InstagramTest extends BaseClass {

    RegistrationToInstagram registration;

    @Test
    public void insertTheDataIntoTheRegistrationField() throws InterruptedException {
        registration = new RegistrationToInstagram(driver);
        String title = registration.redirectOnToSignUpScreen();
        Assert.assertEquals("Instagram",title);
        boolean isEnable = registration.enterDataInToTheField();
        Assert.assertEquals(true,isEnable);
    }
}
