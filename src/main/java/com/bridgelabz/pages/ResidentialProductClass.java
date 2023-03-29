package com.bridgelabz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ResidentialProductClass {

    WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/a")
    WebElement residential;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"section1\"]/div/div/div[1]/div/div[3]/div/div[1]/div/a/div/img")
    WebElement model66;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"doc-0-english-listbox\"]/ul/li/a/div/span[1]")
    WebElement downloadArrow;

    public ResidentialProductClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void downloadModel66SpecSheet() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        WebElement products = driver.findElement(By.cssSelector("#main-nav > div:nth-child(1) > a > span"));
        Point coordinate = products.getLocation();
        robot.mouseMove((int) coordinate.getX(),(int) coordinate.getY()+100);
        Thread.sleep(2000);
        residential.click();
        Thread.sleep(1000);
        for (int i=0; i<=10; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
        model66.click();
        Thread.sleep(1000);
        downloadArrow.click();
        Thread.sleep(3000);
    }
}

