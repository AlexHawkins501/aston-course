package com.alex;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hawk\\IdeaProjects\\Lesson_1\\Lesson_13_Selenium_Part1\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by");
    }

    @Test
    void testMtsBy() throws InterruptedException {
        // Подтверждаем cookie
        WebElement cookieAgree = wait.until(presenceOfElementLocated(By.id("cookie-agree")));
        Thread.sleep(2000);
        if (cookieAgree.isDisplayed()) {
            cookieAgree.click();
        }

        // Проверяем наличие блока пополнения
        assertTrue(driver.findElement(By.className("pay__wrapper")).isDisplayed());

        // 1. Проверяем заголовок
        WebElement title = driver.findElement(By.cssSelector(".pay__wrapper>h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());

        // 2. Проверяем наличие логотипов
        String[] logoSelectors = {
                ".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']",
                ".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']",
                ".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']",
                ".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']",
                ".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']"
        };

        for (String selector : logoSelectors) {
            assertTrue(driver.findElement(By.cssSelector(selector)).isDisplayed(), "Logo is not displayed: " + selector);
        }

        // 3. Проверяем ссылку "Подробнее о сервисе"
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();
        wait.until(driver -> driver.getCurrentUrl().equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        driver.navigate().back();
        Thread.sleep(2000);

        // 4. Проверяем функциональность формы пополнения
        WebElement phoneInputField = driver.findElement(By.className("phone"));
        phoneInputField.sendKeys("297777777");

        WebElement sum = driver.findElement(By.className("total_rub"));
        sum.sendKeys("400");

        WebElement buttonContinue = driver.findElement(By.cssSelector(".button__default"));
        buttonContinue.click();

        assertTrue(wait.until(visibilityOfElementLocated(By.cssSelector(".bepaid-app"))).isDisplayed(), "BePaid app is not displayed after clicking continue");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}