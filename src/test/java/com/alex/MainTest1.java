package com.alex;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Пока делал Allure репорт, понял, что так будет правильнее, поэтому вот...


public class MainTest1 {

    @Test
    @Step("Проверяем появление окна cookies")
    @DisplayName("Проверка куки файлов")
    public void cookies() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        driver.quit();
    }

    @Test
    @Step("Поиск поля пополнение и проверка его названия")
    @DisplayName("Поиск окна оплаты")
    public void findpayWindow() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.findPayWindow();
        driver.quit();
    }

    @Test
    @Step("Проверяем наличие логотипов платежных систем")
    @DisplayName("Проверка логотипов")
    public void checkLogoPayment() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.checkLogoPaymentSys();
        driver.quit();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Домашний интернет'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderInt() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.changeHeaderPaymentHomeInternet();
        driver.quit();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Задолженность'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderArr() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.changeHeaderPaymentArrears();
        driver.quit();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Рассрочка'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderPlan() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.changeHeaderPaymentInstallmentPlan();
        driver.quit();
    }

    @Test
    @Step("Меняем варианты оплаты услуг 'Услуги связи'")
    @DisplayName("Изменяем заголовок")
    public void changeHeaderPhone() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.changeHeaderPaymentPhone();
        driver.quit();
    }

    @Test
    @Step("Проверяем работу ссылки 'Подробнее о сервисе'")
    @DisplayName("Работа ссылки")
    public void linkWork() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.checkLinkWork();
        driver.quit();
    }

    @Test
    @Step("Полностью проверяем функционал оплаты, заголовки, кнопки и наличие иконок платежных систем в новом окне")
    @DisplayName("Пополнение телефона")
    public void paymentPhone() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.paymentPhoneNumber();
        driver.quit();
    }

}
