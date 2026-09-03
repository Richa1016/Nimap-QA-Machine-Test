package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Website field selectors
    By emailField = By.xpath("//input[contains(@placeholder,'Email') or contains(@placeholder,'Username') or @type='email' or @type='text'][1]");
    By passwordField = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//button[contains(.,'Log In') or contains(.,'Login') or @type='submit']");
    By errorToast = By.xpath("//*[contains(@class,'toast') or contains(@class,'alert') or contains(@class,'error')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterEmail(String email) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        input.clear();
        if (email != null && !email.isEmpty()) {
            input.sendKeys(email);
        }
    }

    public void enterPassword(String password) {
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        pass.clear();
        if (password != null && !password.isEmpty()) {
            pass.sendKeys(password);
        }
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        try {
            Thread.sleep(3000); // Allow auth roundtrip to complete
        } catch (InterruptedException ignored) {}
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElements(errorToast).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}