package com.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class InstagramHomePage {

    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "More")
    WebElement moreBtn;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[3]/div/div/div[1]/div/div[1]/div[7]/div/div/div/div/div/div")
    WebElement logOutBtn;

    @CacheLookup
    @FindBy(linkText = "Search")
    WebElement searchBar;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement searchInput;

    @CacheLookup
    @FindBy(linkText = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/header/section/div[1]/div[2]/div/div[1]/button/div/div")
    WebElement followBtn;


    public InstagramHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String logoutFromInstagram() throws InterruptedException {
        moreBtn.click();
        Thread.sleep(200);
        logOutBtn.click();
        Thread.sleep(500);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void searchDataFromInstagramHomePage() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        searchBar.click();
        Thread.sleep(500);
        searchInput.sendKeys("aish");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
    }

    public void followPersonInInstagram() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        searchBar.click();
        Thread.sleep(500);
        searchInput.sendKeys("aish");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
        followBtn.click();
        Thread.sleep(6000);
    }
}

