package com.lcwaikiki.automation.tests;

import com.lcwaikiki.automation.pages.CartPage;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void testCartPageOperations() throws InterruptedException {
        // Sepet sayfasında işlemler
        CartPage cartPage = new CartPage(driver);
        // Ürün bilgilerini doğrula
        cartPage.verifyCartItemDetails( "Bej", "1");
        // Ürünü favorilere ekle
        cartPage.addToFavorites();
        // Favorilerim sayfasına git
        cartPage.navigateToFavoritesPage();
    }
}
