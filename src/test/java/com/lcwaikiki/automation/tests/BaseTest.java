package com.lcwaikiki.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--lang=tr");
        driver = new ChromeDriver(ops);

        // Web sitesi URL'sini açın
        driver.get("https://www.lcw.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
   }
}