package com.bridgelabz.baseclass;

import com.bridgelabz.utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;


public class BaseClass extends ReadPropertyFile {

    public WebDriver driver;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());

    public void setUp() {
        PropertyConfigurator.configure("C:\\Users\\chetan bhagat\\IdeaProjects\\PageObjectModelInstagram\\log4j.properties");
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(properties.getProperty("Application_Url"));
        driver.manage().window().maximize();
        log.info("Chrome browser has launched");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.debug("Implicit time wait");
    }

    public void closeBrowser() {
        driver.quit();
        log.info("quit");
        Reporter.log("*******Browser session ends*******",true);
    }
}

