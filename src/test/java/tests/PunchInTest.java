package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class PunchInTest extends BaseTest {

    @Test
    public void testPunchInToast() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("richa.10.maurya@gmail.com");
        loginPage.enterPassword("Rishu1030");
        loginPage.clickLogin();

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPunchIn();

        String toastText = dashboard.getToastMessage();
        Assert.assertFalse(toastText.isEmpty(), "Punch In toast message should appear");
    }
}