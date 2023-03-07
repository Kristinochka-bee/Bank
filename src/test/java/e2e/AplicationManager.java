package e2e;

import com.google.common.io.Files;
import e2e.helpers.AddCustomerHelpers;
import e2e.helpers.CustomersInfoHelpers;
import e2e.helpers.LoginHelpers;
import e2e.helpers.OpenAccountHelpers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AplicationManager {

    public WebDriver driver;

    LoginHelpers login;
    AddCustomerHelpers register;
    OpenAccountHelpers openAccount;
    CustomersInfoHelpers customers;

    public CustomersInfoHelpers getCustomers() {
        return customers;
    }

    public OpenAccountHelpers getOpenAccount() {
        return openAccount;
    }

    public LoginHelpers getLogin() {
        return login;
    }

    public AddCustomerHelpers getRegister() {
        return register;
    }

    protected void init() {
        driver = new ChromeDriver();                                //указываем драйвер кот будем использолвать
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login = new LoginHelpers(driver);
        register = new AddCustomerHelpers(driver);
        openAccount = new OpenAccountHelpers(driver);
        customers = new CustomersInfoHelpers(driver);

    }

    public String takeScreenshot() throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File sreenshot = new File("reference/screen" + System.currentTimeMillis() + ".png");

        Files.copy(tmp, sreenshot);
        return sreenshot.getAbsolutePath();
    }

    protected void stop() {
        driver.quit();
    }
}