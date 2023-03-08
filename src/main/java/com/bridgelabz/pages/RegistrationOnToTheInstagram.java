package com.bridgelabz.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationOnToTheInstagram {

    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "Sign up")
    WebElement signUpLink;

    @CacheLookup
    @FindBy(name = "emailOrPhone")
    WebElement email;

    @CacheLookup
    @FindBy(name = "fullName")
    WebElement fullName;

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[7]/div")
    WebElement signUpButton;

    public RegistrationOnToTheInstagram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectOnToTheSignUpScreen() throws InterruptedException {
        signUpLink.click();
        Thread.sleep(100);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean enterDataInToTheRegistrationForm() {
        signUpLink.click();
        email.sendKeys("surabhi123@gmail.com");
        fullName.sendKeys("Surabhi Bhagat");
        userName.sendKeys("surabhi12345");
        password.sendKeys("Surabhi@123");
        boolean flag = signUpButton.isEnabled();
        return flag;
    }
}
