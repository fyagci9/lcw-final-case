package com.lcwaikiki.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Element locator'ları
    private By loginIcon = By.xpath("//span[contains(@class,'user-wrapper')]//a[contains(@class,'header-dropdown-toggle')]//*[name()='svg']");
    private By loginButton = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']");
    private By emailField = By.name("emailAndPhone");
    private By passwordField = By.name("password");
    private By continueButton = By.xpath("//button[normalize-space()='Devam Et']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void loginWithoutValidation(String email, String password) throws InterruptedException {
        hoverOverElement(loginIcon);
        clickElement(loginButton);

        Thread.sleep(2000);

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
        Thread.sleep(2000);

        clickElement(continueButton);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);
        Thread.sleep(2000);

        driver.get("https://www.lcw.com/"); // Ana sayfa URL'sine yönlendirme

    }




}
