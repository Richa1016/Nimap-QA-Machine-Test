package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AddCustomerTest extends BaseTest {

    @DataProvider(name = "customerDetails")
    public Object[][] getCustomerData() {
        return new Object[][] {
            {"Tech Solutions Pvt Ltd", "Amit Sharma", "9876543210", "amit.tech@example.com"}
        };
    }

    @Test(dataProvider = "customerDetails")
    public void testAddCustomer(String leadName, String contactPerson, String mobile, String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("richa.10.maurya@gmail.com");
        loginPage.enterPassword("Rishu1030");
        loginPage.clickLogin();

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToAddCustomer();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.createCustomer(leadName, contactPerson, mobile, email);

        String message = addCustomerPage.getConfirmationMessage();
        Assert.assertNotNull(message);
    }
}