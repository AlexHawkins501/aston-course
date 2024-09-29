package com.alex;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest1 {

    private static WebDriver driver;
    private static TestPayment page;


    @BeforeEach
    public  void setUp() {
        driver = new ChromeDriver();
        page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Step("Поиск поля пополнение и проверка его названия")
    @DisplayName("Поиск окна оплаты")
    public void findpayWindow() {
        page.findPayWindow();
    }

    @Test
    @Step("Проверяем наличие логотипов платежных систем")
    @DisplayName("Проверка логотипов")
    public void checkLogoPayment() {
        page.checkLogoPaymentSys();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Домашний интернет'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderInt() {
        page.changeHeaderPaymentHomeInternet();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Задолженность'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderArr() {
        page.changeHeaderPaymentArrears();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Рассрочка'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderPlan() {
        page.changeHeaderPaymentInstallmentPlan();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Услуги связи'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderPhone() {
        page.changeHeaderPaymentPhone();
    }

    @Test
    @Step("Проверяем работу ссылки 'Подробнее о сервисе'")
    @DisplayName("Работа ссылки")
    public void linkWork() throws InterruptedException {
        page.checkLinkWork();
    }

    @Test
    @Step("Полностью проверяем функционал оплаты, заголовки, кнопки и наличие иконок платежных систем в новом окне")
    @DisplayName("Пополнение телефона")
    public void paymentPhone() throws InterruptedException {
        page.paymentPhoneNumber();
    }
}