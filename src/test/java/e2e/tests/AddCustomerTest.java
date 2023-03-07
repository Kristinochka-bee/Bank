package e2e.tests;

import com.github.javafaker.Faker;
import e2e.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AddCustomerTest extends TestBase {
    Faker faker = new Faker();

//positive
    @Test
    public void addCustomerWithValidData() throws InterruptedException {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String postCode = faker.address().zipCode();
            String fullNameAndPostCode = firstName + " " + lastName + " " + postCode;

            app.getRegister().goToAddCustomerPage();
            app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
            app.getRegister().clickAddCustomerButton();

            String expectedResult = "Customer added successfully with customer id :";
            String actualResult = app.getRegister().getAlertText();
            Assert.assertTrue(actualResult.contains(expectedResult));
            app.getRegister().clickAlertOkButton();

            app.getRegister().clickToCustomersButton();
            app.getRegister().setWait();
            app.getRegister().getCustomerSearch(firstName);

            String actualResultOfFoundCustomer = app.getRegister().getCustomerSearchData();
            Assert.assertTrue(actualResultOfFoundCustomer.contains(fullNameAndPostCode));

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

        String expectedErrorMessage = "Please check the details. Customer may be duplicate.";
        String actualResult = app.getRegister().getAlertText();
        Assert.assertTrue(actualResult.contains(expectedErrorMessage));
        app.getRegister().clickAlertOkButton();

    }

    @Test
    public void addExistingCustomer() throws InterruptedException {
        String firstName = "Boris";
        String lastName = "Risker";
        String postCode = "10709";

        String expectedErrorMessage = "Please check the details. Customer may be duplicate.";

        app.getRegister().goToAddCustomerPage();
        app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
        app.getRegister().clickAddCustomerButton();

        String expectedResult = "Customer added successfully with customer id :";
        String actualResult = app.getRegister().getAlertText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        app.getRegister().clickAlertOkButton();

        app.getRegister().clickAddCustomersBigButton();
        app.getRegister().fillRegistrationForm(firstName, lastName, postCode);
        app.getRegister().clickAddCustomerButton();

        String actualResultOfError = app.getRegister().getAlertText();
        Assert.assertTrue(actualResultOfError.contains(expectedErrorMessage));
        app.getRegister().clickAlertOkButton();
    }
}