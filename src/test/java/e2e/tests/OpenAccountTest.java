package e2e.tests;

import e2e.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    //TODO клиенты , которые были добавлены не активны в dropList Open Account при запуске теста
    @Test
    public void openAccountWithValidData(){
        app.getOpenAccount().goToOpenAccountPage();
        app.getOpenAccount().findNameInCustomerList();
        app.getOpenAccount().selectCurrency();
        app.getOpenAccount().clickSignUpButton(By.xpath("//button[normalize-space()='Process']"));

    }

}
