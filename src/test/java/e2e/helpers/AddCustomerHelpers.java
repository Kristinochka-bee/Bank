package e2e.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddCustomerHelpers extends CommonHelpers{
    public AddCustomerHelpers(WebDriver driver) {
        super(driver);
    }
    By firstNameFill = By.xpath("//input[@placeholder='First Name']");
    By lastNameFill = By.xpath("//input[@placeholder='Last Name']");
    By postCodeFill = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.cssSelector("button[type='submit']");

    public void goToAddCustomerPage() {
        Assert.assertTrue(isElementPresent(By.xpath("(//button[normalize-space()='Bank Manager Login'])[1]")));
        driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).isDisplayed();
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
    }
    public void fillRegistrationForm(String firstName, String lastName, String postCode) {
       fillField(firstName, firstNameFill);
       fillField(lastName,lastNameFill);
       fillField(postCode,postCodeFill);
    }
    public void clickAddCustomerButton() {
        driver.findElement(addCustomerButton).isEnabled();
        driver.findElement(addCustomerButton).click();

    }
    public void checkItemTextInPopWindow( String expectedText, String err){
        String actualErrorMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualErrorMessage, expectedText, err);
    }

}
