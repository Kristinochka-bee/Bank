package e2e.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenAccountHelpers extends CommonHelpers{
    public OpenAccountHelpers(WebDriver driver) {
        super(driver);
    }
    public void goToOpenAccountPage() {
        Assert.assertTrue(isElementPresent(By.xpath("(//button[normalize-space()='Bank Manager Login'])[1]")));
        driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).isDisplayed();
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
    }
    public void findNameInCustomerList(){
        clickOnVisibleElement(By.xpath("//select[@id='userSelect']"));
        driver.findElement(By.xpath("(//option[@value='1'])[1]"));
    }
    public void selectCurrency(){
        clickOnVisibleElement(By.xpath("//select[@id='currency']"));
        driver.findElement(By.xpath("//option[@value='Pound']"));
    }

}
