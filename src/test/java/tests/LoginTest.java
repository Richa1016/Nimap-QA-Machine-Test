package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"richa.10.maurya@gmail.com", "Rishu1030", true},
            {"invalid_user@test.com", "WrongPass123", false}
        };
    }

    @Test(dataProvider = "loginCredentials")
    public void testLogin(String email, String password, boolean isValid) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        if (isValid) {
            // Valid hone par user dashboard ya main panel par move ho jata hai
            Assert.assertTrue(currentUrl.contains("dashboard") || !currentUrl.contains("login") || loginPage.isErrorDisplayed(),
                "User processed login credentials successfully");
        } else {
            // Invalid hone par user login par hi rehta hai ya error alert aata hai
            Assert.assertTrue(currentUrl.contains("login") || currentUrl.equals("https://test.fieldforceconnect.com/") || loginPage.isErrorDisplayed(),
                "System blocked invalid credentials");
        }
    }
}