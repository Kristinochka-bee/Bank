package e2e.helpers;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class CommonHelpers  {
    WebDriver driver;
    public WebDriverWait wait;

    public CommonHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait setWait() {
        wait = new WebDriverWait(driver, 10);
        return wait;
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton(){
        driver.switchTo().alert().accept();
    }


    public void clickOnVisibleElement(By locator) {
        Assert.assertTrue(isElementPresent(locator));
        driver.findElement(locator).click();
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public void checkItemText(By locator, String expectedText, String err) {
        String actualErrorMessage = driver.findElement(locator).getText();
        Assert.assertEquals(actualErrorMessage, expectedText, err);
    }

    public void clickSignUpButton(By button) {
        driver.findElement(button).click();
        driver.findElement(button).isEnabled();
    }
    public void fillField(String userData, By locator) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(userData);
    }

}

