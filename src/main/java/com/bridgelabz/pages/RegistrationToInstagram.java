package com.bridgelabz.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationToInstagram {

    WebDriver driver;

    @FindBy(linkText = "Sign up")
    WebElement signUpLink;

    @FindBy(name = "emailOrPhone")
    WebElement mobileNo;

    @FindBy(name = "fullName")
    WebElement fullName;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[7]/div")
    WebElement signUpButton;

    public RegistrationToInstagram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectOnToSignUpScreen() throws InterruptedException {
        signUpLink.click();
        Thread.sleep(100);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean enterDataInToTheField() {
        mobileNo.sendKeys("7854236951");
        fullName.sendKeys("Surabhi Bhagat");
        userName.sendKeys("test12345");
        password.sendKeys("Surabhi852");
        boolean flag = signUpButton.isEnabled();
        return flag;
    }
}
