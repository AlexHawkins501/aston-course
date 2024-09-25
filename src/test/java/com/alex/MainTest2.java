package com.alex;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Было интересно, добавил 2-ой вариант, подскажите пожалуйста как лучше.

public class MainTest2 {

    public TestPayment driverInitialization() {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        return page;
    }

    @Test
    public void cookies() {
        driverInitialization().setCookiesAgree();
    }

    @Test
    public void payWindow() {
        driverInitialization().findPayWindow();
    }

    @Test
    public void checkLogoPayments() {
        driverInitialization().changeHeaderPaymentHomeInternet();
        driverInitialization().changeHeaderPaymentArrears();
        driverInitialization().changeHeaderPaymentPhone();
        driverInitialization().changeHeaderPaymentInstallmentPlan();
    }

    @Test
    public void checkLink() throws InterruptedException {
        driverInitialization().checkLinkWork();
    }

    @Test
    public void paymentPhone() throws InterruptedException {
        driverInitialization().paymentPhoneNumber();
    }

}
