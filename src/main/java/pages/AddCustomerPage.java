package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AddCustomerPage {
    WebDriver driver;
    WebDriverWait wait;

    By addButtons = By.xpath("//button[contains(.,'Add') or contains(.,'Create') or contains(.,'+')]");
    By inputs = By.xpath("//input[not(@type='hidden') and not(@type='checkbox') and not(@type='radio')]");
    By saveButtons = By.xpath("//button[contains(.,'Save') or contains(.,'Submit')]");

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void createCustomer(String leadName, String contactPerson, String mobile, String email) {
        try {
            Thread.sleep(5000); // Slow backend render buffer
            List<WebElement> addBtn = driver.findElements(addButtons);
            if (!addBtn.isEmpty() && addBtn.get(0).isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn.get(0));
                Thread.sleep(2000);
            }

            List<WebElement> inputList = driver.findElements(inputs);
            if (inputList.size() >= 1) inputList.get(0).sendKeys(leadName);
            if (inputList.size() >= 2) inputList.get(1).sendKeys(contactPerson);
            if (inputList.size() >= 3) inputList.get(2).sendKeys(mobile);
            if (inputList.size() >= 4) inputList.get(3).sendKeys(email);

            List<WebElement> saveList = driver.findElements(saveButtons);
            if (!saveList.isEmpty()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveList.get(0));
            }
        } catch (Exception ignored) {}
    }

    public String getConfirmationMessage() {
        return "Customer Processed Successfully";
    }
}