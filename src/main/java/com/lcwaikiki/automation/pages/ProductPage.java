package com.lcwaikiki.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Sabit locatorlar

    private static final By size_Button = By.xpath("//button[contains(text(),'5-6 Yaş')]");  // Seçilen beden butonu
    private static final By add_To_CartButton = By.xpath("//button[normalize-space()='SEPETE EKLE']");  // Sepete ekle butonu
    private static final By cart_Icon = By.xpath("//a[@href='https://www.lcw.com/sepetim']//*[name()='svg']"); // Sepet ikonunun lokatörü

    // Constructor
    public ProductPage(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Bekleme süresi
    }

    // Beden seç ve sepete ekle
    public void selectSizeAndAddToCart() throws InterruptedException {
        // Beden butonuna tıklama
        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(size_Button));
        sizeButton.click();

        Thread.sleep(5000);
        // Sepete ekle butonuna tıklama
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(add_To_CartButton));
        addToCartButton.click();

        Thread.sleep(5000);
    }

    // Sepet sayfasına gitme
    public void navigateToCartPage() {
        System.out.println("Sepet sayfasına yönlendiriliyor.");
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(cart_Icon));
        cartIcon.click();
    }


}
