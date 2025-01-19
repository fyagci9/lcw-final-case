package com.lcwaikiki.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    // Sabit locatorlar

    private static final By product_Color = By.xpath("//span[@class='rd-cart-item-color']");
    private static final By product_Quantity = By.xpath("//input[@value='1']");
    private static final By addTOFavoritesButton = By.xpath("//i[@class='fa fa-heart-o']");
    private static final By favorites_Button = By.xpath("//span[normalize-space()='Favorilerim']");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Ürün bilgilerini doğrulama
    public void verifyCartItemDetails(String expectedColor, String expectedQuantity) {
        WebElement productColor = wait.until(ExpectedConditions.visibilityOfElementLocated(product_Color));
        WebElement productQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(product_Quantity));


        // Ürün renginde "Bej" kelimesinin geçtiğini kontrol et
        if (!productColor.getText().replace("Renk: ", "").toLowerCase().contains("bej")) {
            throw new AssertionError("Beklenen ürün rengi içinde 'Bej' geçmeliydi, ancak bulundu: " + productColor.getText());
        }

        // Ürün adedi doğrulama
        if (!productQuantity.getAttribute("value").equals(expectedQuantity)) {
            throw new AssertionError("Beklenen ürün adedi '" + expectedQuantity + "', ancak bulundu: " + productQuantity.getAttribute("value"));
        }

        System.out.println("Ürün bilgileri başarıyla doğrulandı.");
    }

    // Ürünü favorilere ekleme
    public void addToFavorites() throws InterruptedException {
        WebElement addToFavoritesButton = wait.until(ExpectedConditions.elementToBeClickable(addTOFavoritesButton));
        addToFavoritesButton.click();
        System.out.println("Ürün favorilere eklendi.");
        Thread.sleep(5000);
    }

    // Favorilerim sayfasına gitme
    public void navigateToFavoritesPage() {
        WebElement favoritesButton = wait.until(ExpectedConditions.elementToBeClickable(favorites_Button));
        favoritesButton.click();
        System.out.println("Favorilerim sayfasına yönlendirildi.");
    }
}
