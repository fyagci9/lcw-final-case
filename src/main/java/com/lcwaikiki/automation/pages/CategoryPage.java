package com.lcwaikiki.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    // Sabit locator'lar
    private static final By childrenAndBabyCategory = By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']");
    private static final By girlChildCategory = By.xpath("//span[normalize-space()='KIZ ÇOCUK']");
    private static final By montAndKabanText = By.xpath("//section[contains(@class,'content-tab')]//a[normalize-space()='Mont ve Kaban']");
    private static final By sizeFilter = By.xpath("//div[normalize-space()='Beden']");
    private static final By scrollContainer = By.xpath("(//div[@class='collapsible-filter-container__body'])[3]");
    private static final By sizeFiveAndSixYear = By.xpath("//span[contains(text(),'5-6 Yaş')]");
    private static final By sizeSixAndSevenYear = By.xpath("//span[contains(text(),'6-7 Yaş')]");
    private static final By colorBej = By.xpath("//span[normalize-space()='BEJ']");
    private static final By dropdownButton = By.xpath("//button[@class='dropdown-button__button']");
    private static final By bestSellerText = By.xpath("//a[normalize-space()='En çok satanlar']");

    private static final By fourthProduct = By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='product-grid']/div[4]"); // 4. ürün locater'ı

    // Constructor
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Sabit bekleme süresi
    }

    // WebElement'i bekleyerek getirme metodu
    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Genel bir hover metodu
    private void hoverOnElement(By locator) {
        actions.moveToElement(getElement(locator)).perform();
    }
    // Genel bir tıklama metodu
    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement(locator).click();
    }

    // Sayfayı kaydırma
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // "Çocuk & Bebek" kategorisine hover işlemi
    public void hoverOnChildrenAndBabyCategory() {
        hoverOnElement(childrenAndBabyCategory);
    }

    // "Kız Çocuk" kategorisine hover işlemi
    public void hoverOnGirlChildrenCategory() {
        hoverOnElement(girlChildCategory);
    }

    // "Mont ve Kaban" alt menüsünü tıklama
    public void clickMontAndKaban() {
        clickElement(montAndKabanText);
    }

    // En çok satanlar seçimi
    public void getBestSeller() throws InterruptedException {
        clickElement(dropdownButton);
        clickElement(bestSellerText);
        Thread.sleep(5000);
    }

    // Beden filtresi seçimleri
    public void selectSizeFilter() throws InterruptedException {
        WebElement SizeFilter = getElement(sizeFilter);
        scrollToElement(SizeFilter);

        WebElement sizeScrollContainer = getElement(scrollContainer);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", sizeScrollContainer);

        clickElement(sizeFiveAndSixYear);

        Thread.sleep(5000);

        // 6-7 yaş seçimi
       wait.until(ExpectedConditions.visibilityOfElementLocated(sizeSixAndSevenYear));
       clickElement(sizeSixAndSevenYear);
        Thread.sleep(5000);
    }

    // Renk filtresi seçimi
    public void selectColorFilter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600)");

        WebElement colorFilterElement = getElement(colorBej);
        if (colorFilterElement.isDisplayed()) {
            clickElement(colorBej);
        } else {
            System.out.println("Renk filtresi elementi görünür değil!");
        }
    }

    // 4. ürünü seç ve detayına git
    public void selectFourthProduct() {
        WebElement FourthProduct = getElement(fourthProduct);
        scrollToElement(FourthProduct);
        FourthProduct.click();
    }
}
