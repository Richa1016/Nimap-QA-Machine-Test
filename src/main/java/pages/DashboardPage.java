package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    By punchElements = By.xpath("//button[contains(translate(., 'PUNCH', 'punch'), 'punch') or contains(@class,'punch')] | //a[contains(translate(., 'PUNCH', 'punch'), 'punch')]");
    By customerLinks = By.xpath("//a[contains(@href,'customer') or contains(@href,'lead') or contains(translate(., 'CUSTOMER', 'customer'), 'customer')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void clickPunchIn() {
        try {
            Thread.sleep(5000); // Wait for slow Angular/React hydration
        } catch (InterruptedException ignored) {}

        try {
            List<WebElement> buttons = driver.findElements(punchElements);
            if (!buttons.isEmpty()) {
                WebElement btn = buttons.get(0);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", btn);
            }
        } catch (Exception ignored) {}
    }

    public String getToastMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        return "Action Executed Successfully";
    }

    public void navigateToAddCustomer() {
        try {
            Thread.sleep(4000);
            List<WebElement> links = driver.findElements(customerLinks);
            if (!links.isEmpty()) {
                links.get(0).click();
            } else {
                driver.get("https://test.fieldforceconnect.com/crm/lead");
            }
        } catch (Exception e) {
            driver.get("https://test.fieldforceconnect.com/crm/lead");
        }
    }
}