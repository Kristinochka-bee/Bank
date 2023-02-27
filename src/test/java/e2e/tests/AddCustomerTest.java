package e2e.tests;

import com.github.javafaker.Faker;
import e2e.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AddCustomerTest extends TestBase {
    Faker faker = new Faker();


//positive
    @Test
    public void addCustomerWithValidData(){
            String firstName = faker.internet().domainName();
            String lastName = faker.internet().domainName();
            String postCode = faker.internet().uuid();

            app.getRegister().goToAddCustomerPage();
            app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
            app.getRegister().clickAddCustomerButton();


    }

    //negative
    @Test
    public void addCustomerWithEmptyFields(){
        String firstName = " ";
        String lastName = " ";
        String postCode = " ";

        app.getRegister().goToAddCustomerPage();
        app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
        app.getRegister().clickAddCustomerButton();

    }

    //TODO дописать данный метод, вытащить текст из всплывающего окна (ошибки)
    @Test
    public void addExistingCustomer(){
        String firstName = "test@gmail.com";
        String lastName = "test@gmail.com";
        String postCode = "10709";
        String expectedErrorMessage = "Please check the details. Customer may be duplicate.";

        app.getRegister().goToAddCustomerPage();
        app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
        app.getRegister().clickAddCustomerButton();
        app.getRegister().checkItemTextInPopWindow(expectedErrorMessage, "Error");


    }


}
