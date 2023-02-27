package e2e.tests;

import e2e.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CustomersInfoTest extends TestBase {
    @Test
    public void findCustomerInCustomerInfoByFirstName(){
        String firstName = "Molly";

        app.getCustomers().goToCustomersPage();
        app.getCustomers().fillField(firstName, By.xpath("//input[@placeholder='Search Customer']"));
    }
    @Test
    public void findCustomerInCustomerInfoByLastName(){
        String lastName = "Miller";

        app.getCustomers().goToCustomersPage();
        app.getCustomers().fillField(lastName, By.xpath("//input[@placeholder='Search Customer']"));
    }
/*
    @Test
    public void deleteCustomer

 */
}
