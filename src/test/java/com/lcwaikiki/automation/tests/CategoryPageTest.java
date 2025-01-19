package com.lcwaikiki.automation.tests;

import com.lcwaikiki.automation.pages.CategoryPage;
import org.testng.annotations.Test;

public class CategoryPageTest extends BaseTest {

    @Test
    public void testCategorySelection() throws InterruptedException {
        // Kategori sayfasını aç ve işlemleri sırayla yap
        CategoryPage categoryPage = new CategoryPage(driver);

        categoryPage.hoverOnChildrenAndBabyCategory(); // Çocuk & Bebek kategorisini aç
        categoryPage.hoverOnGirlChildrenCategory();    // Kız Çocuk kategorisini aç
        categoryPage.clickMontAndKaban();              // Mont ve Kaban alt kategorisini seç

        categoryPage.getBestSeller();                 // En çok satan ürünü getir
        categoryPage.selectSizeFilter();              // Beden filtresini uygula
        categoryPage.selectColorFilter();             // Renk filtresini uygula
        categoryPage.selectFourthProduct();           // 4. ürünü seç


    }

}
