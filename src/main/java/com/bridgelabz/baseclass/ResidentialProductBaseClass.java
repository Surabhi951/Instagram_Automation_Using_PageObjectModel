package com.bridgelabz.baseclass;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResidentialProductBaseClass {

    public WebDriver driver;

    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://insinkerator.emerson.com/en-in");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        try{
            driver.quit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

