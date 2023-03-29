package com.bridgelabz.test;

import com.bridgelabz.baseclass.ResidentialProductBaseClass;
import com.bridgelabz.pages.ResidentialProductClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ResidentialProductTestClass extends ResidentialProductBaseClass {

    ResidentialProductClass product;

    @BeforeMethod
    public void initialization() {
        setUp();
        product = new ResidentialProductClass(driver);
    }

    @Test
    public void downloadFile() throws AWTException, InterruptedException {
        product.downloadModel66SpecSheet();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}

