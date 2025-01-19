package com.lcwaikiki.automation.tests;

import com.lcwaikiki.automation.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test
    public void testNavigateToProductDetail() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectSizeAndAddToCart();
        productPage.navigateToCartPage();


    }
}
