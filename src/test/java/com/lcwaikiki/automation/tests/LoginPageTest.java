package com.lcwaikiki.automation.tests;

import com.lcwaikiki.automation.pages.CartPage;
import com.lcwaikiki.automation.pages.LoginPage;
import com.lcwaikiki.automation.pages.CategoryPage;
import com.lcwaikiki.automation.pages.ProductPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private CategoryPage categoryPage;

    @Test
    // ALLURE REPORT ANNOTATİONSLARI
    @Epic("User Login and Shopping Flow")
    @Feature("Login and Category Selection")
    @Story("User logs in and selects categories for shopping")
    @Description("Tests user login and category selection with product addition to cart and favorites.")
    @Severity(SeverityLevel.CRITICAL)

    public void testLoginAndCategorySelectionWithoutValidation() throws InterruptedException {





        loginPage = new LoginPage(driver);

        // Kullanıcı girişi yap
        loginPage.loginWithoutValidation("firatyagcideneme@gmail.com", "Deneme1");

        categoryPage = new CategoryPage(driver);

        // Kategori işlemleri
        categoryPage.hoverOnChildrenAndBabyCategory();
        categoryPage.hoverOnGirlChildrenCategory();
        categoryPage.clickMontAndKaban();
        categoryPage.getBestSeller();
        categoryPage.selectSizeFilter();
        categoryPage.selectColorFilter();
        categoryPage.selectFourthProduct();

        // Ürün detay sayfasında beden seç ve sepete ekle
        ProductPage productPage = new ProductPage(driver);
        // Beden seç ve sepete ekle
        productPage.selectSizeAndAddToCart();
        // Sepet sayfasına git
        productPage.navigateToCartPage();


        // Sepet sayfasında işlemler
        CartPage cartPage = new CartPage(driver);
        // Ürün bilgilerini doğrula
        cartPage.verifyCartItemDetails("Bej", "1");
        // Ürünü favorilere ekle
        cartPage.addToFavorites();
        // Favorilerim sayfasına git
        cartPage.navigateToFavoritesPage();


        // **Ekran görüntüsü ekleme işlemi**
        attachScreenshot(); // Ekran görüntüsü kaydet ve rapora ekle
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        // Ekran görüntüsü alma ve byte[] olarak döndürme
        return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}
