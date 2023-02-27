package e2e.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersInfoHelpers extends CommonHelpers{
    public CustomersInfoHelpers(WebDriver driver) {
        super(driver);
    }
    public void goToCustomersPage() {
        Assert.assertTrue(isElementPresent(By.xpath("(//button[normalize-space()='Bank Manager Login'])[1]")));
        driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).isDisplayed();
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
    }
    public void checkTextInPopWindow(){

    }
}
