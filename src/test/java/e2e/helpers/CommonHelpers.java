package e2e.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CommonHelpers  {
    By searchField = By.xpath("//input[@type=\"text\"]");
    By searchResult = By.xpath("//tr[@class='ng-scope']");
    By customersButton = By.xpath("//button[normalize-space()=\"Customers\"]");
    WebDriver driver;
    public WebDriverWait wait;

    public CommonHelpers(WebDriver driver) {
        this.driver = driver;
    }
    Duration TIMEOUT = Duration.ofSeconds(10);
    public WebDriverWait setWait() {
        wait = new WebDriverWait(driver, TIMEOUT);
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
    public void clickToCustomersButton() throws InterruptedException {
        driver.findElement(customersButton).click();
    }
    public void getCustomerSearch(String firstName) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(firstName);
    }
    public String getCustomerSearchData() {
       return driver.findElement(searchResult).getText();
    }

}

